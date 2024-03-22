<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, org.kh.dto.Member" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>POST 전송 결과</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8"); //POST 전송 시 암호화 필요
	/* request.setAttribute("no", request.getParameter("no"));
	request.setAttribute("id", request.getParameter("id"));
	request.setAttribute("pw", request.getParameter("pw"));
	request.setAttribute("name", request.getParameter("name")); */
	String[] sports = request.getParameterValues("sports");
	int len = sports.length;
%>
<%@ include file="menu.jsp" %>
<hr>
<h2>POST 전송 결과 1</h2>
<div>
	<p>pname : ${pname }</p>
	<p>rname : ${rname }</p>
	<p>sname : ${sname }</p>
	<p>aname : ${aname }</p>
	<p>tname : ${tname }</p>
</div>
<hr>
<h2>POST 전송 결과 2</h2>
<div>
	<p>no : ${param.no}</p>
	<p>id : ${param.id }</p>
	<p>pw : ${param.pw }</p>
	<p>name : ${param.name }</p>
	<!-- EL로 post 된 값 출력 불가 => parameter를 이용한 setAttribute() 또는 param 필요  -->
	<p>좋아하는 스포츠</p>
	<ul>
		<li>${paramValues.sports[0] }</li>
		<li>${paramValues.sports[1] }</li>
	</ul>
	
	<p>EL과 scriptlet은 같이 사용 시 값 불러오지 못함</p>
	<ul>
		<%for(int i=0; i<len; i++) { %>
			<li>${paramValues.sports[i] }</li>
		<%} %>
		<!-- EL과 scriptlet은 같이 사용 시 값 불러오지 못함 -->
	</ul>
</div>
</body>
</html>