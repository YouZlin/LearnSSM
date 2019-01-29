<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form modelAttribute="user" action="${pageContext.request.contextPath }/user/register.do" method="POST" >
	
		邮箱:<form:input path="email"/><form:errors path="email"></form:errors><br/><br/>
		密码<form:password path="password"/><form:errors path="password"></form:errors><br/><br/>
		<input type="submit" value="注册"/><br/><br/>
	</form:form>

</body>
</html>