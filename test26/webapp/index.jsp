<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 구성 요소</title>
</head>
<body>
<h1>JSP 구성 요소</h1>
<hr>
<%@ include file="menu.jsp" %>
<hr>
<h2>디렉티브(Directive)</h2>
<p>필요한 자원을 가져올 때 활용하는 jsp 의 기본 필수 요소</p>
<h3>page directive</h3>
<p>현재 문서 선언, 정보 설정, 필요한 라이브러리 호출</p>
<h3>include directive</h3>
<p>현재 jsp 문서에 다른 jsp 문서를 포함시키는 디렉티브</p>
<h3>taglib directive</h3>
<p> 필요한 jstl(java standard tag library)을 로딩하는 디렉티브</p>

</body>
</html>