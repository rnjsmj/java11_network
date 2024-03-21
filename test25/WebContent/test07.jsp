<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>웹의 객체 전달과 스코프(Scope)</title>
</head>
<body>
<h2>웹의 객체 전달과 스코프(Scope)</h2>
<%
	List<String> lst = new ArrayList<String>();
	lst.add("1번");
	lst.add("2번");
	lst.add("3번");
	lst.add("4번");
	lst.add("5번");
	request.setAttribute("lst", lst);
	
	Set<String> set = new HashSet<String>();
	set.add("6번");
	set.add("7번");
	set.add("8번");
	set.add("9번");
	set.add("10번");
	request.setAttribute("set", set);
	
	Map<Integer, String> map = new HashMap<Integer, String>();
	map.put(1, "map1");
	map.put(2, "map2");
	map.put(3, "map3");
	map.put(4, "map4");
	map.put(5, "map5");
	request.setAttribute("map", map);
	
	
	RequestDispatcher rd = request.getRequestDispatcher("test08.jsp"); //목적지 지정
	rd.forward(request, response); //데이터 전달
	response.sendRedirect("test08.jsp"); //데이터 이동
	//주소는 바뀌지 않고 보이는 페이지(실행 내용)만 변경됨 -> 데이터 이동 (화면 이동x)
	//
%>
<h2>객체 데이터 전달</h2>
</body>
</html>