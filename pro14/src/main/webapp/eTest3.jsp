<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비교연산자</title>
</head>
<body>
\${10==10}: ${10==10}<br> 
\${10 eq 10}: ${10 eq 10}<br> 
\${"hello" == "hello"}: ${"hello" == "hello"}<br> 
\${"hello" eq "hello"}: ${"hello" eq "hello"}<br> 
\${20 != 10}: ${20 != 10}<br>  
\${"hello" !=  "apple"}: ${"hello" !=  "apple"}<br> 
\${10 < 10}: ${10 < 10}<br> 
\${100 > 10}: ${100 > 10}<br> 
\${100 <= 10}: ${100 <= 10}<br> 
\${100 >= 10}: ${100 >= 10}<br> 
</body>
</html>