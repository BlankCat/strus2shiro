/*
 * Powered By [www.zfwx.com]
 * Web Site: http://www.zfwx.com
 * 
 * Since 2008 - 2017
 */

package com.zfwlxt.vod.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
 * @since 1.0,2017/12/25 09:47:40
 */

@Service
@Transactional
public class DjSpecialtyCommentsManager extends BaseManager<DjSpecialtyComments,java.lang.Long>{

	private DjSpecialtyCommentsDao djSpecialtyCommentsDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setDjSpecialtyCommentsDao(DjSpecialtyCommentsDao dao) {
		this.djSpecialtyCommentsDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.djSpecialtyCommentsDao;
	}
	
	@Transactional(readOnly=true)
	public Page findPage(DjSpecialtyCommentsQuery query) {
		return djSpecialtyCommentsDao.findPage(query);
	}
	
}
