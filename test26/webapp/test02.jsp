<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, org.kh.dto.Member" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>객체와 표현언어</title>
</head>
<body>
<%
	String name= "권민지";
	int age = 24;
	int num1 = 90;
	int num2 = 98;
	int num3 = 100;
	
	Member mem1 = new Member(1, "kim", "1234", "김동연");
	Member mem = new Member(2, "lee", "4321", "이원석");
	Member mem3 = new Member(3, "shin", "1004", "신희성");
	
	List<Member> memList = new ArrayList<Member>();
	memList.add(mem1);
	memList.add(mem);
	memList.add(mem3);
	
	request.setAttribute("name", name); //필드명 : EL로 불러올 이름
	request.setAttribute("age", age);
	request.setAttribute("num1", num1);
	request.setAttribute("num2", num2);
	request.setAttribute("num3", num3);
	
	request.setAttribute("mem1", mem1);
	request.setAttribute("mem2", mem);
	request.setAttribute("mem3", mem3);
	
	request.setAttribute("memList", memList);
%>
<%@ include file="menu.jsp" %>
<hr>
<h2>객체와 표현언어</h2>
<h3>기본형 표현</h3>
<ul>
	<li><strong>name</strong> : ${name }</li>
	<li><strong>age</strong> : ${age }</li>
	<li><strong>kor</strong> : ${num1 }</li>
	<li><strong>eng</strong> : ${num2 }</li>
	<li><strong>mat</strong> : ${num3 }</li>
</ul>
<hr>
<h3>객체형 표현</h3>
<ul>
	<!-- EL 사용 시 private 멤버변수 직접 접근 가능 -->
	<li><strong>no</strong> : ${mem1.no }</li>
	<li><strong>id</strong> : ${mem1.id }</li>
	<li><strong>password</strong> : ${mem1.pw }</li>
	<li><strong>name</strong> : ${mem1.name }</li>
</ul><br>
<ul>
	<li><strong>no</strong> : ${mem2.no }</li>
	<li><strong>id</strong> : ${mem2.id }</li>
	<li><strong>password</strong> : ${mem2.pw }</li>
	<li><strong>name</strong> : ${mem2.name }</li>
</ul><br>
<ul>
	<li><strong>no</strong> : ${mem3.no }</li>
	<li><strong>id</strong> : ${mem3.id }</li>
	<li><strong>password</strong> : ${mem3.pw }</li>
	<li><strong>name</strong> : ${mem3.name }</li>
</ul><br>
<hr>
<h3>컬렉션 객체형 표현</h3>
<c:forEach var="mem" items="${memList}">
<ul>
	<li><strong>no</strong> : ${mem.no }</li>
	<li><strong>id</strong> : ${mem.id }</li>
	<li><strong>password</strong> : ${mem.pw }</li>
	<li><strong>name</strong> : ${mem.name }</li>
</ul><br>
</c:forEach>

</body>
</html>