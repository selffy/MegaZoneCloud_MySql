package myboard.dao;

import myboard.service.BoardFileService;

public interface BoardFileDeleteDAO extends BoardFileService {
	
@Override
default int deleteBoardFile(int bfid) throws Exception {
	// TODO Auto-generated method stub
	return 0;
}
}
