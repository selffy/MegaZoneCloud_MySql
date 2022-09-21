package myboard.service;

import java.util.List;
import java.util.Map;

import myboard.dto.BoardDTO;

public interface BoardListService extends BoardService{

	public abstract List<BoardDTO> 
		listBoard(String bdomain, Map<String, String> searchCriteria) throws Exception;
	
}
