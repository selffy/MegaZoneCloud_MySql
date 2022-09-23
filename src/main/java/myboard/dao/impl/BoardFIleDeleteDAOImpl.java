package myboard.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import myboard.constants.MyboardConstants;
import myboard.util.ConnectionManager;

public class BoardFIleDeleteDAOImpl extends AbstractBoardFIleDAO{

	@Override
	public int deleteBoardFile(int bfid) throws Exception {

		Connection conn = ConnectionManager.getConnection();
		String sql = MyboardConstants.querys.getProperty("FILE_DELTET_SQL");
		PreparedStatement psmt = conn.prepareStatement(sql);
		
		psmt.setInt(1, bfid);
		int result = psmt.executeUpdate();
		ConnectionManager.closeConnection(psmt, conn);
		
		return bfid;
	}
	
}
