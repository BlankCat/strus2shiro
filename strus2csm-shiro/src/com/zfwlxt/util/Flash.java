package com.zfwlxt.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Flash {
	private static final String FLASH_IN_SESSION_KEY = "__flash__";
	
	private Map<String, String> data = new HashMap<String, String>();
    private Map<String, String> out = new HashMap<String, String>();

    @SuppressWarnings("unchecked")
	public static Flash restore(HttpServletRequest request) {
        Flash flash = new Flash();
        HttpSession session = request.getSession();
        Map<String, String> flashData = (Map<String, String>)session.getAttribute(FLASH_IN_SESSION_KEY);
        if(flashData != null) {
        	flash.data = flashData;
        }
        return flash;
    }

    public void save(HttpServletRequest request,HttpServletResponse response) {
    	HttpSession session = request.getSession();
		if(session != null) {
			//zl tomcat_session_manager 已做修改，缺省为true。故这里可不用做修改。
			//RedisSession.setManualDirtyTrackingSupportEnabled(true);
			session.setAttribute("__changed__",FLASH_IN_SESSION_KEY); //zl
			session.setAttribute(FLASH_IN_SESSION_KEY, out);
		}
    }

    // ThreadLocal access
    private static ThreadLocal<Flash> current = new ThreadLocal<Flash>();

    public static Flash current() {
        return current.get();
    }

    static void setCurrent(Flash f) {
        current.set(f);
    }

    public void put(String key, String value) {
        if (key.contains(":")) {
            throw new IllegalArgumentException("Character ':' is invalid in a flash key.");
        }
        data.put(key, value);
        out.put(key, value);
    }
    
    public void now(String key, String value) {
        if (key.contains(":")) {
            throw new IllegalArgumentException("Character ':' is invalid in a flash key.");
        }
        data.put(key, value);
    }

    public void put(String key, Object value) {
        if (value == null) {
            put(key, (String) null);
        }
        put(key, value + "");
    }

    public void error(String value, Object... args) {
		put("error", String.format(value, args));
    }

    public void success(String value, Object... args) {
		put("success", String.format(value, args));
    }

    public void discard(String key) {
        out.remove(key);
    }

    public void discard() {
        out.clear();
    }

    public void keep(String key) {
        if (data.containsKey(key)) {
            out.put(key, data.get(key));
        }
    }

    public void keep() {
        out.putAll(data);
    }

    public String get(String key) {
        return data.get(key);
    }

    public boolean remove(String key) {
        return data.remove(key) != null;
    }

    public void clear() {
        data.clear();
    }

    public boolean contains(String key) {
        return data.containsKey(key);
    }

    public String toString() {
        return data.toString();
    }

	public Map<String, String> getData() {
		return data;
	}

}