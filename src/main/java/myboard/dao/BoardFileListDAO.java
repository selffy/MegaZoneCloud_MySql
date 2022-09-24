package myboard.dao;

import java.util.List;

import myboard.dto.BoardFileDTO;
import myboard.service.BoardFileService;

public interface BoardFileListDAO extends BoardFileService {
 
	@Override
	default List<BoardFileDTO> listBoardFile(int bid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}