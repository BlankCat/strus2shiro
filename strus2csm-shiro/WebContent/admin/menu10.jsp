<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/commons/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>menu</title>
<link rel="stylesheet" href="skin/css/base.css" type="text/css" />
<link rel="stylesheet" href="skin/css/menu.css" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script language='javascript'>var curopenItem = '1';</script>
<script language="javascript" type="text/javascript" src="skin/js/frame/menu.js"></script>
<base target="main" />
</head>
<body target="main">
<table width='99%' height="100%" border='0' cellspacing='0' cellpadding='0'>
  <tr>
    <td style='padding-left:3px;padding-top:8px' valign="top">
      <!-- Item 2 Strat -->
      <dl class='bitem'>
        <dt onClick='showHide("items2_1")'><b>实体卡管理</b></dt>
        <dd style='display:block' class='sitem' id='items2_1'>
          <ul class='sitemu'>          
            <li>
              <div class='items'>
                <div class='fllct'><a href='<%=basePath %>admin/DjCardTemplate/list.do' target='main'>实体卡模板管理</a></div>
              </div>
            </li>
            <li>
              <div class='items'>
                <div class='fllct'><a href='<%=basePath %>admin/DjCardMake/list.do' target='main'>生成实体卡</a></div>
              </div>
         	</li>  
            <li>
              <div class='items'>
                <div class='fllct'><a href='<%=basePath %>admin/DjCard/list.do' target='main'>实体卡列表</a></div>
              </div>
         	</li>  
          </ul>
        </dd>
      </dl>
	  </td>
  </tr>
</table>
</body>
</html>