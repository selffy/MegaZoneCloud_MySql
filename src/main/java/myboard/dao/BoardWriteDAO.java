package myboard.dao;

import java.sql.SQLException;

import myboard.dto.BoardDTO;
import myboard.service.BoardWriteService;

public interface BoardWriteDAO extends BoardWriteService{

	public abstract int writeBoard(BoardDTO boardDTO) throws SQLException, Exception;
}
