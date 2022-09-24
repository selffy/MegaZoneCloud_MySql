package myboard.dao;

import myboard.dto.BoardFileDTO;
import myboard.service.BoardFileService;

public interface BoardFileWriteDAO extends BoardFileService {
	
@Override
default int writeBoardFile(int bid, BoardFileDTO boardFileDTO) throws Exception {
	// TODO Auto-generated method stub
	return 0;
}
}
