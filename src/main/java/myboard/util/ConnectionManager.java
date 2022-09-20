package myboard.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionManager { 

	public static Connection getConnection() throws Exception {
		try {
//			JDBC드라이버 클래스를 메모리에 로딩
			Class.forName("core.log.jdbc.driver.MysqlDriver");
			System.out.println("로딩 성공");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			System.out.println("fail");
		}
		String JDBC_URL = "jdbc:mysql://localhost:3306/board?characterEncoding=UTF-8&serverTimezone=UTC";
		String JDBC_USER = "selffy";
		String JDBC_PASS = "1234";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
			System.out.println("연결 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn; 
		
	}//getConnection()
	
	public static void closeConnection(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}//closeConnection()
	
	public static void closeConnection(Statement stmt, Connection conn) {
		if(stmt != null) {
			try {
				stmt.close();				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		closeConnection(conn);
	}
	

	public static void closeConnection(ResultSet rs, Statement stmt, Connection conn) {
		if(rs != null) {
			try {
				rs.close();				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		closeConnection(stmt, conn);
	}
	
}//class

