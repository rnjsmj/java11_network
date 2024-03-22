package com.kh.test8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Application {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//1.
//			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306",
//					"root", "1234");
			// 에서 url을 나타내는 "jdbc:mysql://localhost:3306" 문장에 데이터베이스명이 없기 때문에
			// url을 통해 해당 데이터베이스에 연결할 수 없음
			//=> "jdbc:mysql://localhost:3306" 문장을 "jdbc:mysql://localhost:3306/kh" 로 수정
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kh",
					"root", "1234");
			
			String query = "select emp_id, emp_name from employee"; //*
			PreparedStatement st =conn.prepareStatement(query);
			//2.
			//query 변수에 지정된 실행문(sql 명령) 이 없기 때문에 
			// 해당 쿼리를 실행할 수 없다.
			// => 위 빈 줄에  String query = "select emp_id, emp_name from employee";를 추가하여
			// query 에 대한 sql문을 지정한다
			
			
//			ResultSet rs = st.executeUpdate();
			//3. 
			//**
			//executeUpdate() 메서드는 int를 반환하므로
			//해당 검색 결과인 ResultSet을 반환받을 수 없다. **/
			// => executeUpdate() 메서드를 executeQuery()로 수정
			
			//데이터베이스의 데이터를 가져와야 하므로 select문을 사용해야하는데,
			//데이터를 변경할 때 사용하는 executeUpdate()메서드 문을 사용
			ResultSet rs = st.executeQuery();
			
//			while(rs) {
			// rs ==> boolean 타입 아니므로 while문 동작 불가
			//4.
			//*
			//while(rs) 문장에서 rs는 다음 레코드를 지정해야 레코드의 끝까지 반복 수행을 할 수 있는데,
			// 진행되지 않으므로 반복 수행 불가
			//=>while(rs) 문장을 반복수행이 될 수 있도록 while(rs.next())로 수정
			//*//
			while(rs.next()) {
				
//				System.out.println(rs.getString("empId") + 
//						" / " + rs.getString("empName"));
				// 위 문장에서 empId와 empName 컬럼은 존재하지 않으므로
				// 해당 컬럼에 접근할 수 없다.
				// => 문장에서 컬럼명인 empId를 emp_id로, 그리고 empName를 emp_name로
				// 올바르게 수정한다.
				System.out.println(rs.getString("emp_id") + 
						" / " + rs.getString("emp_name"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
