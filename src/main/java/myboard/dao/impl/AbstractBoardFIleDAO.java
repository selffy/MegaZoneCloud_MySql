package myboard.dao.impl;

import java.util.List;

import myboard.dto.BoardFileDTO;
import myboard.service.BoardFileService;

public class AbstractBoardFIleDAO extends BoardFileDTO implements BoardFileService{

	@Override
	public List<BoardFileDTO> listBoardFile() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardFileDTO viewBoardFile(int bfid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int writeBoardFile(int bid, BoardFileDTO boardFileDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBoardFile(int bfid) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public int writeBoardFile(BoardFileDTO boardFileDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
