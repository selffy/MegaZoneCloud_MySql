package myboard.test;

import myboard.dao.impl.BoardFIleDeleteDAOImpl;
import myboard.dao.impl.BoardFIleViewDAOImpl;
import myboard.dao.impl.BoardFIleWriteDAOImpl;
import myboard.dao.impl.BoardFileListDAOImpl;
import myboard.dto.BoardFileDTO;
import myboard.service.BoardFileService;

public class TestBoardFile {

	public static void main(String[] args) {
		
		/*
		BoardFileService boardFileService = new BoardFIleWriteDAOImpl();
		
		//write		
		BoardFileDTO boardFileDTO = new BoardFileDTO("bfcfn", "bfsfn",1000, 1);
		
		try {		
			boardFileService.writeBoardFile(1, boardFileDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
		//list
		/*
		BoardFileService boardFileService = new BoardFileListDAOImpl();
		try {
			System.out.println(boardFileService.listBoardFile());
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
		/*
		//delete
		BoardFileService boardFileService = new BoardFIleViewDAOImpl();
		try {
			System.out.println(boardFileService.viewBoardFile(1));
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
		//delete
		BoardFileService boardFileService = new BoardFIleDeleteDAOImpl();
		try {
			System.out.println(boardFileService.deleteBoardFile(1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
