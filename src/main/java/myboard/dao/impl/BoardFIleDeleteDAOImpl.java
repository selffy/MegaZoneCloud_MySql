package myboard.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import myboard.constants.MyboardConstants;
import myboard.dto.BoardFileDTO;

public class BoardFIleDeleteDAOImpl extends AbstractBoardFIleDAO{

	   @Override
	   public int deleteBoardFile(int bfid) throws Exception {
	      
	      Connection conn =getConnection();
	      String sql = MyboardConstants.querys.getProperty("FILE_DELETE_SQL");
	      PreparedStatement pstmt = conn.prepareStatement(sql);
	      pstmt.setInt(1, bfid);
	      int result = pstmt.executeUpdate();
	      closeConnection(pstmt, conn);
	      
	      return result;
	   }

	@Override
	public List<BoardFileDTO> listBoardFile(int bid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
