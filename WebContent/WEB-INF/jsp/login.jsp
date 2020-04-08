<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Win4Docker</title>
<style type="text/css">
	#box {
		width: 20%;
		margin: 0 auto;
	}
</style>
</head>
<body>
	<div id="box">
		<h2>Win4Docker</h2>
		<form action="${ctx}/user/dologin" method="get">	
			<p>用户名:&nbsp;<input type="text" name="username"></p>
			<p>密&nbsp;&nbsp;&nbsp;码:&nbsp;<input type="password" name="password"></p>
			<input type="submit" value="登录"/>&nbsp;&nbsp;<input type="reset" value="重置"/>
			&nbsp;&nbsp;<input type="button" value="注册"/>
		</form>
	</div>
</body>
</html>