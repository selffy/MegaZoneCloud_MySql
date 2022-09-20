package myboard.service;

import java.sql.SQLException;

import myboard.dto.BoardDTO;

public interface BoardWriteService extends BoardService {

	public abstract int writeBoard(BoardDTO boardDTO) throws SQLException, Exception;
}
