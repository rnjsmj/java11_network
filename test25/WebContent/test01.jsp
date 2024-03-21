<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%!
	private String name;
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
%>
<%
	String title = "홈페이지";
	setName("권민지");
%>
<title>test01</title>
</head>
<body>
<%=name %>의 <%=title %>
<hr>
</body>
</html>