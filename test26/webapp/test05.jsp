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
<title>표현언어의 비교문장</title>
</head>
<body>
<!-- c:set : 변수 선언 -->
<c:set scope="application" var="num3" value="30"/>  
<%
	pageContext.setAttribute("num1", 9);
	pageContext.setAttribute("num2", "10");
	pageContext.setAttribute("nullStr", null);
	pageContext.setAttribute("emptyStr", "");
	pageContext.setAttribute("lengthZero", new Integer[0]);
	pageContext.setAttribute("sizeZero", new ArrayList());
	
	session.setAttribute("sid", "kim"); //로그인
%>
<%@ include file="menu.jsp" %>
<hr>
<h2>* 표현언어의 비교문장 *</h2>
<div>
	<!-- 속성 내부에는 작은 따옴표 사용 -->
	<!-- test : if문 조건식 속성 -->
	<c:if test="${sid.equals('admin') }">
		<p>관리자 로그인 중</p>
	</c:if>
	<c:if test="${not empty sid }">
		<p>${sid }님 로그인 중</p>
	</c:if>
	<c:if test="${empty sid }">
		<p>현재 로그인 중이 아닙니다.</p>
	</c:if>
	
</div>
<hr>
<div>
	<h3>* Empty 비교 확인 *</h3>
	<p>empty nullStr : ${empty nullStr }</p>
	<p>empty emptyStr : ${empty emptyStr }</p>
	<p>empty lengthZero : ${empty lengthZero }</p>
	<p>empty sizeZero : ${empty sizeZero }</p>
	<!-- 모두 true -->
</div>
<hr>
<div>
	<h3>삼항 연산자</h3>
	<p>num1 &gt; num2 ? "참" : "거짓" => ${num1 gt num2 ? "num1이 더 크다" : "num2이 더 크다" }</p>
	<!-- 부등호는 태그로 인식될 수 있기 때문에 &gt;와 같이 사용 -->
	<p></p>
</div>
<hr>
<div>
	<h3>null 연산자</h3>
	<p>null + 10 = ${null + 10 }</p>
	<p>nullStr + 10 = ${nullStr + 10 }</p>
	<p>param.noVar &lt; 10 = ${param.noVar < 10 }</p>
	<p>num3 + 10 = ${num3 + 10 }</p>
	<!-- null >>> 0으로 취급하여 연산-->
	<p></p>
</div>
</body>
</html>