<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.setAttribute("name","이순신");
	String name = (String) session.getAttribute("name");
	session.setAttribute("address","서울시 강남구");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session 내장 객체 테스트1</title>
</head>
<body>
	<a href=session2.jsp>두 번째 페이지로 이동</a>
</body>
</html>