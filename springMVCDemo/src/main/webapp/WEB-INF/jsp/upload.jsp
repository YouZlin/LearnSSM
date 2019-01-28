<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/springMVCDemo/upload.do" method="post" enctype="multipart/form-data">
		<input type="file" name="upfile"/><br/>
		<input type="submit" value="上传"/>
	</form>

</body>
</html>