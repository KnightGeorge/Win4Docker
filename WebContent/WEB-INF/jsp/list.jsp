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
		width: 100%;
		margin: 0 auto;
		margin-bottom: 100px;
	}
	#leftside{
		width: 80%;
		margin: 0 auto;
	}
	#rightside{
		width: 80%;
		margin-right: 20px;
	}
</style>
</head>
<body>
	<div id="box">
		<h1>Win4Docker</h1>
	</div>
	<div id="leftside">
		
			<div>
				<select name="dosomething" id="select">
					<option  value="0" selected="selected">自定义命令</option>
					<option  value="1" >测试网络</option>
					<option  value="2" >查看镜像</option>
					<option  value="3" >查看所有容器状态</option>
					<option  value="4" >新建容器</option>
					<option  value="5" >启动已存在容器</option>
					<option  value="6" >删除容器</option>
					<option  value="7" >删除镜像</option>
				</select>
				<%-- <c:if test="${('#select option:selected').val()==0}">
					<form action="${ctx }/docker/doCmd" method="post">
						<p>请输入命令:<input type="text" name="cmd"></p>
						<input type="submit" value="提交">&nbsp;&nbsp;<input type="reset" value="重置"/>
					</form>
				</c:if> --%>
						
			</div>
		
		<div id="rightside">
			<textarea rows="20" cols="80" id="showmsg" disabled="disabled"></textarea>
		</div>
	</div>
	
</body>
<!-- <script type="text/javascript">
	function doping(ip) {
	
	}
</script> -->
</html>