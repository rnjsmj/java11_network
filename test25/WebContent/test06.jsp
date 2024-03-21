<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 8 객체</title>
</head>
<body>
<h2>JSP 내장 객체</h2>
<p>out(출력) : 브라우저에 출력할 경우 객체</p>
<p>request(요청) : 요청 정보를 담는 객체</p>
<p>response(응답) : 응답 정보를 담는 객체</p>
<p>session(세션) : 세션 정보를 담는 객체</p>
<p>application(앱) : 웹 애플리케이션 정보를 담는 객체 </p>
<p>config(설정) : 웹 설정 정보를 담는 객체</p>
<p>page : 웹 페이지 정보를 담는 객체</p>
<p>exception(예외처리) : 예외 처리 정보를 담는 객체</p>
<%
	//Servlet에서 page 객체 생성
	/* HttpServlet spageContext = new HttpServlet();
	Object spage = spageContext.getPage(); */
	
	//Servlet에서 out 객체 생성
	//PrintWriter out = response.getWriter();
	
	//Servlet에서 request객체 생성
	//ServletRequest request = pageContext.getRequest();
	
	//Servlet에서 response 객체 생성
	//ServletResponse response = pageContext.getResponse();
	
	//Servlet에서 session 객체 생성
	//HttpSession session = pageContext.getSession();
	
	//Servlet에서 application 객체 생성
	//ServletContext application = pageContext.getServletContext();
	
	//Servlet에서 config 객체 생성하기
	//ServletConfig config = pageContext.getServletConfig();
	
	//Servlet에서 exception 객체 생성하기
	//Exception exception = pageContext.getException();
	
	//Servlet에서 jsp 객체 생성하기
	//JspWriter jspOut = pageContext.getOut();
	String name = "출력";
	out.println("<h2>"+name+"</h2>");
	out.println("<br>");
%> 
<h2><%=name %></h2>
<%
	JspWriter jspOut = pageContext.getOut();
	out.println("<h2> out : 태그를 포함한 내용을 출력할 수 있는 객체 </h2>");
	out.println(out==jspOut);
	
	ServletRequest jspReq = pageContext.getRequest();
	out.println("<h2> requst : 브라우저를 통하여 요청한 정보를 저장하는 객체 </h2>");
	out.println(request==jspReq);
	
	ServletResponse jspRes = pageContext.getResponse();
	out.println("<h2> response : 브라우저를 통하여 반환한 결과를 저장하는 객체 </h2>");
	out.println(response==jspRes);
	
	HttpSession jspSes = pageContext.getSession();
	out.println("<h2> session : 인가된 사용자 정보를 저장하는 객체  </h2>");
	out.println("<h3> session은 로그아웃 전 또는 브라우저를 종료하기 전 까지 그 정보가 유지됨  </h3>");
	out.println(session==jspSes);
	
	ServletContext jspApp = pageContext.getServletContext();
	out.println("<h2> application : 인가된 사용자 정보를 저장하는 객체  </h2>");
	out.println("<h3> application은 브라우저를 종료하기 전 까지 그 정보가 유지됨  </h3>");
	out.println(application==jspApp);
	
	ServletConfig jspCon= pageContext.getServletConfig();
	out.println("<h2> cofig : 애플리케이션 설정 정보를 저장하는 객체  </h2>");
	out.println(config==jspCon);
	
	Exception jspExc = pageContext.getException();
	out.println("<h2> exception : 예외처리 정보를 저장하는 객체  </h2>");
	Exception exception = pageContext.getException();
	out.println(exception==jspExc);
	
	Object jspPage = pageContext.getPage();
	out.println("<h2> page : 현재 페이지 정보를 저장하는 객체  </h2>");
	out.println("<h3> page는 현재 페이지 내에서만 그 정보가 유지됨  </h3>");
	out.println("<h3> 전송된 값은 그 정보가 목적지 까지만 유지되며, 다른 페이지에서는 해당 정보 확인 불가  </h3>");
	out.println("<p>웹 환경에서의 Scope : 그 정보가 유지되는 범위</p>");
	out.println("<p>page < trans < session < application</p>");
	out.println(page==jspPage);
	
	//page.setAttribute("name", "강쥐"); //모든 객체는 저장할 경우 setAttribute("필드명", "값") 사용
	//page.getAttribute("name") // 모든 객체는 값 가져올 경우 getAttribute("필드명") 사용
	//단 request 객체의 값을 가져올 경우 getParameter("파라미터명") 사용 
%>
<hr>
<div>
	<a href="test07.jsp">scope 자세히 알기</a>
</div>
</body>
</html>