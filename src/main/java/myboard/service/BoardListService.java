package myboard.service;

import java.util.List;

import myboard.dto.BoardDTO;

public interface BoardListService extends BoardService{

	public abstract List<BoardDTO> listBoard() throws Exception;
}
