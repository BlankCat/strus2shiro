/*
 * Powered By [www.zfwx.com]
 * Web Site: http://www.zfwx.com
 * 
 * Since 2008 - 2017
 */

package com.zfwlxt.vod.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.org.rapid_framework.beanutils.BeanUtils;
import com.zfwlxt.util.Flash;

import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.ModelDriven;

import java.util.*;

import javacommon.base.*;
import javacommon.util.*;

import cn.org.rapid_framework.util.*;
import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.page.*;
import cn.org.rapid_framework.page.impl.*;

import com.zfwlxt.vod.model.*;
import com.zfwlxt.vod.dao.*;
import com.zfwlxt.vod.service.*;
import com.zfwlxt.vod.vo.query.*;

/**
 * @author zhangjianfeng
 * @version 1.0
 * @since 1.0,2017/12/13 15:10:11
 */


public class DjSpecialtyCartAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/admin/DjSpecialtyCart/query.jsp";
	protected static final String LIST_JSP= "/admin/DjSpecialtyCart/list.jsp";
	protected static final String CREATE_JSP = "/admin/DjSpecialtyCart/create.jsp";
	protected static final String EDIT_JSP = "/admin/DjSpecialtyCart/edit.jsp";
	protected static final String SHOW_JSP = "/admin/DjSpecialtyCart/show.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/admin/DjSpecialtyCart/list.do";
	
	private DjSpecialtyCartManager djSpecialtyCartManager;
	
	private DjSpecialtyCart djSpecialtyCart;
	java.lang.Long id = null;
	private String[] items;

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			djSpecialtyCart = new DjSpecialtyCart();
		} else {
			djSpecialtyCart = (DjSpecialtyCart)djSpecialtyCartManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,注意大小写 */
	public void setDjSpecialtyCartManager(DjSpecialtyCartManager manager) {
		this.djSpecialtyCartManager = manager;
	}	
	
	public Object getModel() {
		return djSpecialtyCart;
	}
	
	public void setCartId(java.lang.Long val) {
		this.id = val;
	}

	public void setItems(String[] items) {
		this.items = items;
	}
	
	/** 执行搜索 */
	public String list() {
		DjSpecialtyCartQuery query = newQuery(DjSpecialtyCartQuery.class,DEFAULT_SORT_COLUMNS);
		
		Page page = djSpecialtyCartManager.findPage(query);
		savePage(page,query);
		return LIST_JSP;
	}
	
	/** 查看对象*/
	public String show() {
		return SHOW_JSP;
	}
	
	/** 进入新增页面*/
	public String create() {
		return CREATE_JSP;
	}
	
	/** 保存新增对象 */
	public String save() {
		djSpecialtyCartManager.save(djSpecialtyCart);
		Flash.current().success(CREATED_SUCCESS); //存放在Flash中的数据,在下一次http请求中仍然可以读取数据,error()用于显示错误消息
		return LIST_ACTION;
	}
	
	/**进入更新页面*/
	public String edit() {
		return EDIT_JSP;
	}
	
	/**保存更新对象*/
	public String update() {
		djSpecialtyCartManager.update(this.djSpecialtyCart);
		Flash.current().success(UPDATE_SUCCESS);
		return LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			java.lang.Long id = new java.lang.Long((String)params.get("cartId"));
			djSpecialtyCartManager.removeById(id);
		}
		Flash.current().success(DELETE_SUCCESS);
		return LIST_ACTION;
	}

}
