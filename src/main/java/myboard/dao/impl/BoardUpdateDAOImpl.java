package myboard.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import myboard.constants.MyboardConstants;
import myboard.dao.BoardUpdateDAO;
import myboard.dto.BoardDTO;

public class BoardUpdateDAOImpl extends BoardDAOImpl implements BoardUpdateDAO{

	@Override
	public int updateBoard(BoardDTO boardDTO) throws Exception {
	
		Connection conn = getConnection();
		
		String sql = " update board set btitle=?, bcontent=?, bdomain=?, bwriterid=? ";	
		 	sql += " where bid=? ";	
		
		PreparedStatement pstmt = getConnection().prepareStatement(MyboardConstants.querys.getProperty("UPDATE_SQL"));
		pstmt.setString(1, boardDTO.getBtitle());
		pstmt.setString(2, boardDTO.getBcontent());
		pstmt.setString(3, boardDTO.getBdomain());
		pstmt.setString(4, boardDTO.getBwriterid());
		pstmt.setInt(5, boardDTO.getBid());
		
		int result = pstmt.executeUpdate();
		closeConnection(pstmt, conn);
		
		System.out.println("업데이트 성공");	
		return result;
		
	}//updateBoard



}//class
