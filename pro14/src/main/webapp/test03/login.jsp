<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인창</title>
</head>
<body>
<form action="result.jsp">
	아이디:
	비밀번호:
	<input type="submit" value="로그인"/>
</form>
<br><br>
<a href="${contextPath}/test03/memberForm.jsp">회원가입하기</a>
</body>
</html>