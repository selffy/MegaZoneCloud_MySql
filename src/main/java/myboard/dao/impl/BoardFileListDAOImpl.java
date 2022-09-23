package myboard.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import myboard.util.ConnectionManager;

import myboard.constants.MyboardConstants;
import myboard.dto.BoardFileDTO;
import myboard.util.ConnectionManager;

public class BoardFileListDAOImpl extends AbstractBoardFIleDAO {

	@Override
	public List<BoardFileDTO> listBoardFile() throws Exception {
		Connection conn = ConnectionManager.getConnection();
		String sql = MyboardConstants.querys.getProperty("FILE_WRITE_SQL");
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		List<BoardFileDTO> list = new ArrayList<BoardFileDTO>();
		
		if(rs!=null) {
			while (rs.next()) {
				BoardFileDTO boardFileDTO = new BoardFileDTO();
				boardFileDTO.setBfid(rs.getInt("bfid"));
				boardFileDTO.setBfcfn(rs.getString("bcfn"));
				boardFileDTO.setBfsfn(rs.getString("bsfn"));
				boardFileDTO.setBfsize(rs.getInt("bfsize"));
				boardFileDTO.setBfbid(rs.getInt("bfbid"));
			}
		}	
		ConnectionManager.closeConnection(rs, pstmt, conn);
		return list;
		
	}
}
