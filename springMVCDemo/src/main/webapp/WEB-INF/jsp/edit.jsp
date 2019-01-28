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
	<!-- modelAttribute需要指定Controller中定义的对象的名称 -->
	<!-- 如action,不支持嵌入java代码,但是支持el表达式 -->
	<form:form modelAttribute="user" action="${pageContext.request.contextPath }/user/edit.do">
		<%-- <input type="hidden" name="id" value="${user.id }"/> --%>
		<form:hidden path="id"/>
		<!-- 从user对象中自动生成input并填充email的值 -->
		邮箱:<form:input path="email"/><form:errors path="email"></form:errors><br/>
		姓名:<form:input path="name"/><form:errors path="name"></form:errors><br/>
		生日:<form:input path="birthday"/><form:errors path="birthday"></form:errors><br/>
		
		角色:<form:checkboxes items="${allRoleList }" path="roleList" itemLabel="name" itemValue="id"/><br/>
		<input type="submit" value="修改"/>
	</form:form>
</body>
</html>