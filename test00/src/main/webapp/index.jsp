<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정재은 홈페이지</title>
</head>
<body>
- 서버 : <%=application.getServerInfo() %><br>
 - 서블릿 : <%= application.getMajorVersion() %>.<%= application.getMinorVersion() %><br>
 - JSP : <%= JspFactory.getDefaultFactory().getEngineInfo().getSpecificationVersion() %><br>
</body>
</html>