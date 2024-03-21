<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userId = "user1";
	String userName = "몽몽";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 처리</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");	
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	
	if(id.equals(userId) && name.equals(userName)) {
		//로그인 처리 => 세션 저장
		session.setAttribute("sid", id);
		session.setAttribute("sname", name);
		response.sendRedirect("test10.jsp");
	} else {
		response.sendRedirect("test10.jsp");	
	}
%>

</body>
</html>