<%@page import="com.zfwlxt.vod.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="storeId" name="storeId" />

<!-- ONGL access static field: @package.class@field or @vs@field -->
	
	<s:textfield label="�γ�id" key="courseId" value="%{model.courseId}" cssClass="required validate-integer " required="true" />
	
	
	<s:textfield label="����רҵ" key="speId" value="%{model.speId}" cssClass="required validate-integer " required="true" />
	
	
	<s:textfield label="��������" key="groupId" value="%{model.groupId}" cssClass="required validate-integer " required="true" />
	
	
	<s:textfield label="�ڷ����е�����" key="courseOrder" value="%{model.courseOrder}" cssClass="validate-integer max-value-2147483647" required="false" />
	
