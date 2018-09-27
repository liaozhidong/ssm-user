<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'upd.jsp' starting page</title>

	<link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css"/>
	<link rel="stylesheet" href="/bootstrap/css/bootstrap-datetimepicker.min.css"/>
	<script type="text/javascript" src="/bootstrap/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/bootstrap/js/bootstrap-datetimepicker.min.js"></script>
	<script type="text/javascript" src="/bootstrap/js/bootstrap-datetimepicker.zh-CN.js"></script>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body class="modal-body">
  	<form action="${pageContext.request.contextPath }/items/upd.action" method="post" enctype="multipart/form-data" class="form-horizontal">
	    	<input type="hidden" name="id" value="${items.id }"/>
	    <table>
	    	<tr>
	    		<td>商品姓名</td>
	    		<td><input type="text" name="name" value="${items.name }"></td>
	    	</tr>
	    	<tr>
	    		<td>商品价格</td>
	    		<td><input type="text" name="price" value="${items.price }"></td>
	    	</tr>
	    	<tr>
	    		<td>商品生产日期</td>
	    		<td><input type="text" value="<fmt:formatDate value="${items.createtime}" pattern="yyyy-mm-dd hh:mm"/>" name="createtime"></td>
	    	</tr>
	    	<tr>
	    		<td>商品图片</td>
	    			<td>
	    				<c:if test="${items.pic!=null }">
		    				<img style="width:80px;height:70px" src="${pageContext.request.contextPath }/upload/${items.pic}">
		    				<br/>
		    				<input type="file" name="items_pic1"/>	    			
	    				</c:if>
	    			</td>
	    	</tr>
	    	<tr>
	    		<td>商品简介</td>
	    		<td><input type="text" name="detail" value="${items.detail }"></td>
	    	</tr>
	    </table>
	    <input type="submit" value="修改">
    </form>
  </body>
</html>
