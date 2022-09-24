package myboard.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import myboard.constants.MyboardConstants;
import myboard.dto.BoardFileDTO;
import myboard.util.ConnectionManager;

public class BoardFIleWriteDAOImpl extends AbstractBoardFIleDAO{

	@Override
	public int writeBoardFile(int bid, BoardFileDTO boardFileDTO) throws Exception {
		
		Connection conn = ConnectionManager.getConnection();
		String sql = MyboardConstants.querys.getProperty("FILE_WRITE_SQL");
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, boardFileDTO.getBfcfn());
		pstmt.setString(2, boardFileDTO.getBfsfn());
		pstmt.setInt(3, boardFileDTO.getBfsize());
		pstmt.setInt(4, bid);
		
		int result = pstmt.executeUpdate();
		closeConnection(pstmt, conn);
		return result;
		
		
	}
}
