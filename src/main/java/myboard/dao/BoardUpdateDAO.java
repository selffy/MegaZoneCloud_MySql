package myboard.dao;

import java.util.List;

import myboard.dto.BoardDTO;
import myboard.service.BoardUpdateService;

public interface BoardUpdateDAO extends BoardUpdateService{

	public abstract int updateBoard(BoardDTO boardDTO) throws Exception;

}
