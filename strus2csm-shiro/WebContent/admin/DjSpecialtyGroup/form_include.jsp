<%@page import="com.zfwlxt.vod.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="id" name="id" />

<!-- ONGL access static field: @package.class@field or @vs@field -->
	
	<s:textfield label="��������" key="groupName" value="%{model.groupName}" cssClass="required " required="true" />
	
	
	<s:textfield label="�����ֶ�" key="groupOrder" value="%{model.groupOrder}" cssClass="required validate-number " required="true" />
	
	
	<s:textfield label="��������רҵ" key="specialtyId" value="%{model.specialtyId}" cssClass="required validate-integer " required="true" />
	
