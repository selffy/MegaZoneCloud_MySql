package myboard.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import myboard.constants.MyboardConstants;
import myboard.dto.BoardFileDTO;
import myboard.util.ConnectionManager;

public class BoardFIleViewDAOImpl extends AbstractBoardFIleDAO{

	@Override
	public BoardFileDTO viewBoardFile(int bfid) throws Exception {
		
		Connection conn = getConnection();
		String sql = MyboardConstants.querys.getProperty("FILE_VIEW_SQL");
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bfid);
		ResultSet rs = pstmt.executeQuery();
		BoardFileDTO boardFileDTO = null;
		if(rs!=null) {
			while (rs!=null && rs.next()) {
				boardFileDTO = new BoardFileDTO();
				boardFileDTO.setBfid(rs.getInt("bfid"));
				boardFileDTO.setBfcfn(rs.getString("bcfn"));
				boardFileDTO.setBfsfn(rs.getString("bsfn"));
				boardFileDTO.setBfsize(rs.getInt("bfsize"));
				boardFileDTO.setBfbid(rs.getInt("bfbid"));
			}
		}	
		ConnectionManager.closeConnection(rs, pstmt, conn);
		return boardFileDTO;
	}

	@Override
	public List<BoardFileDTO> listBoardFile(int bid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
