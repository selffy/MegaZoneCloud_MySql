package myboard.test;

import myboard.dao.impl.BoardListDAOImpl;
import myboard.service.BoardListService;
import myboard.service.BoardService;

public class TestBoardList {

	public static void main(String[] args) {
		
		BoardListService boardListService = new BoardListDAOImpl();
		
		try {
			System.out.println(boardListService.listBoard(null, null));		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
