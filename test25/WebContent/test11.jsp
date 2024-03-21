<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("name", "몽몽");
	pageContext.setAttribute("age", "3");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include 실습</title>
</head>
<body>

<h2>디렉티브 이용</h2>
<%@ include file="inFile.jsp" %>

<h2>액션태그 이용</h2>
<jsp:include page="inFile.jsp"></jsp:include>

</body>
</html>