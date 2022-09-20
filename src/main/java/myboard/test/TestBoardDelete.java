package myboard.test;

import myboard.dao.impl.BoardDeleteDAOImpl;
import myboard.service.BoardDeleteService;

public class TestBoardDelete {

	public static void main(String[] args) {
		
		BoardDeleteService deleteService = new BoardDeleteDAOImpl();
		
		try {
			deleteService.deleteBoard(5);		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//main
	
}//class
