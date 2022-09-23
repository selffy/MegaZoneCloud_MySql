package myboard.dao;

import myboard.dto.BoardFileDTO;
import myboard.service.BoardFileService;

public interface BoardFileViewDAO extends BoardFileService{

	@Override
	default BoardFileDTO viewBoardFile(int bfid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
