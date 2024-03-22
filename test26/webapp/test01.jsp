<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String title="표현식과 표현언어";
	String[] arrStr = {"까다로움", "꾸준함", "개웃김..", "착함"};
	Map<String, String> map = new HashMap<>();
	map.put("name","몽몽");
	map.put("age", "3");
	map.put("nick", "몽이");
	
	request.setAttribute("tt",title);
	request.setAttribute("arr", arrStr);
	request.setAttribute("mong", map);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>표현 언어(Expression language)</title>
</head>
<body>
<%@ include file="menu.jsp" %>
<hr>
<h2>표현식 (Expression)</h2>
<p><%=title %> : <%=request.getAttribute("tt") %></p>
<div>
<%
	String[] arr = (String[]) request.getAttribute("arr");
	for (int i=0; i<arr.length; i++) {
%>
		<%=arr[i] %>
<% 
	}
%>
</div><br>
<div>
<%
	Map<String, String> m = new HashMap<>();
	m = (HashMap<String,String>) request.getAttribute("mong");
	Collection<String> val = m.values();
	
	for(String s : val) {
%>		
		<span><%=s %></span>
<% 
	}
%>	

</div>
<br>
<h2>표현 언어(Expression language)</h2>
<p>${tt }</p>
<div>
	<!-- items : setAttribute로 선언한 필드명  -->
	<!-- var : 반복을 이용해 접근할 변수명 -->
	<c:forEach var="s" items="${arr }"> 
		<span>${s }</span>
	</c:forEach>
</div><br>
<div>
	<c:forEach var="m" items="${mong }">
		<span>${m.key }</span> : <span>${m.value}</span>
	</c:forEach>
</div>
</body>
</html>