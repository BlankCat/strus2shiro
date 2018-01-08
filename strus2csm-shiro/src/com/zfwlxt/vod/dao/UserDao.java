/*
 * Powered By [www.zfwx.com]
 * Web Site: http://www.zfwx.com
 * 
 * Since 2008 - 2017
 */

package com.zfwlxt.vod.dao;

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
 * @author tangrongzhi
 * @version 1.0
 * @since 1.0,2017/12/25 09:47:39
 */


import static cn.org.rapid_framework.util.ObjectUtils.*;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends BaseHibernateDao<User,java.lang.Long>{

	public Class getEntityClass() {
		return User.class;
	}
	
	public User findUserByLoginName(String loginName){
		Query query = super.getSession().createQuery("from User as  model where model.userCode = ?");
		query.setParameter(0, loginName);
		List list = query.list();
		if(list!=null && !list.isEmpty()){
			return (User)list.get(0);
		}
		return null;
	}
	
}
