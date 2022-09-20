package myboard.dao;

import java.sql.Connection;
import java.util.List;

import myboard.dto.BoardDTO;
import myboard.service.BoardListService;

public interface BoardListDAO extends BoardListService{
	
	public abstract List<BoardDTO> listBoard() throws Exception;

}
