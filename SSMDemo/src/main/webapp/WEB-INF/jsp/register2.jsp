<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册界面二</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/user/register2.do" method="POST" >
	
		邮箱:<input type="text" name="email" value="${param.email }"/>
		<br/><br/>
		密码<input type="password" name="password" value="${param.password }"/>
		<br/><br/>
		<c:if test="${not empty message }">
			<span style="color:red;">${message }</span>
		</c:if>
		<br/><br/>
		<input type="submit" value="注册"/><br/><br/>
	</form>

</body>
</html>