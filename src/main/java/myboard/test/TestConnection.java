package myboard.test;

import java.sql.Connection;

import myboard.util.ConnectionManager;

public class TestConnection {

	public static void main(String[] args) {
		
		Connection conn = null;
		
		try {
			conn = ConnectionManager.getConnection();
			if(conn != null) {
				System.out.println(conn);
			}		
		} catch (Exception e) {
		}
	
	}//main
	
}//Class
