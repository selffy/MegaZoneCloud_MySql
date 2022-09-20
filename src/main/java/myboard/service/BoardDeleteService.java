package myboard.service;

import myboard.dto.BoardDTO;

public interface BoardDeleteService extends BoardService{

	public abstract int deleteBoard(int bid) throws Exception;
}
