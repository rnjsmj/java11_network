<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>POST 데이터 전송</title>
</head>
<body>
	<h2>학생 데이터 입력</h2>
	<form action="test03_pro.jsp" method="post">
		<label for="name">이름</label> :
		<input type="text" name="name" id="name"/><br><br>
		<label for="age">나이</label> :
		<input type="number" step="1" max="100" min="1" value="20" name="age" id="age"/><br><br>
		<label for="point">점수</label> :
		<input type="number" step="5" max="100" min="0" value="50" name="point" id="point"/><br><br>
		<input type="submit" value="입력" />&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="reset"	value="초기화"/>
	</form>
</body>
</html>