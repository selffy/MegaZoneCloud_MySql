package myboard.service;

import java.io.File;
import java.util.List;

import myboard.dto.BoardFileDTO;

public interface BoardFileService extends BoardService {

	public abstract List<BoardFileDTO> listBoardFile() throws Exception;
	
	public abstract BoardFileDTO viewBoardFile(int bfid) throws Exception;
	
	public abstract int writeBoardFile(int bid, BoardFileDTO boardFileDTO) throws Exception;
	
	public abstract int deleteBoardFile(int bfid) throws Exception;
}
