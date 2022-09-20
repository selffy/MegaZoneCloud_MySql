package myboard.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import myboard.constants.MyboardConstants;
import myboard.dao.BoardWriteDAO;
import myboard.dto.BoardDTO;
import myboard.util.ConnectionManager;

public class BoardWriteDAOImpl extends BoardDAOImpl implements BoardWriteDAO {
		
		@Override
		public int writeBoard(BoardDTO boardDTO) throws SQLException, Exception {
			
			
			BoardWriteDAO boardWriteDAO = new BoardWriteDAOImpl();
			
			Connection conn = getConnection();
			String sql = MyboardConstants.querys.getProperty("WRITE_SQL");
			
			PreparedStatement pstmt = conn.prepareStatement(sql);		
			pstmt.setString(1, boardDTO.getBtitle());
			pstmt.setString(2, boardDTO.getBcontent());
			pstmt.setString(3, boardDTO.getBdomain());
			pstmt.setString(4, boardDTO.getBwriterid());
			int result = pstmt.executeUpdate();
			ConnectionManager.closeConnection(pstmt, getConnection());

			return result;
			
		}//WriteBoard


}
