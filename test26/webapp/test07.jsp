<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %> 
<%@ page import="org.kh.dto.Member" %>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL FMT</title>
</head>
<body>
<%@ include file="menu.jsp" %>
<hr>
<h2>JSTL(Java Standard Tag Library) FMT</h2>
<c:set var="num" value="123456789.9876543"/>
<c:set var="data" value="3,652,733"/>

</body>
</html>