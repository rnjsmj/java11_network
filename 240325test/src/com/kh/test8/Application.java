package com.kh.test8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Application {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306",
					"root", "1234");
//			PreparedStatement st =conn.prepareStatement(query);
			//쿼리문 없음
			
//			ResultSet rs = st.executeUpdate();
			//데이터베이스의 데이터를 가져와야 하므로 select문을 사용해야하는데,
			//데이터를 변경할 때 사용하는 executeUpdate()메서드 문을 사용
			
			while(rs) {
				System.out.println(rs.getString("empId") + 
						" / " + rs.getString("empName"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
