package myboard.test;

import myboard.dao.impl.BoardUpdateDAOImpl;
import myboard.dto.BoardDTO;
import myboard.service.BoardUpdateService;

public class TestBoardUpdate {

	public static void main(String[] args) {
		
		BoardUpdateService updateSerivce = new BoardUpdateDAOImpl();
		
		try {
			BoardDTO boardDTO = new BoardDTO();
			
			boardDTO.setBtitle("수일의 하루");
			boardDTO.setBcontent("일상브이로그");
			boardDTO.setBdomain("브이로그");
			boardDTO.setBwriterid("현수일");
			boardDTO.setBid(10);
			
			updateSerivce.updateBoard(boardDTO);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}//main
	
}//class
