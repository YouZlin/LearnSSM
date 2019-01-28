<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	${requestScope.name }<br/>
	${requestScope.age }<br/>
	
	<!-- test11.do使用 -->
	${requestScope.user.email }<br/>
</body>
</html>