package myboard.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import myboard.constants.MyboardConstants;
import myboard.dao.BoardListDAO;
import myboard.dto.BoardDTO;

public class BoardListDAOImpl extends BoardDAOImpl implements BoardListDAO{

	@Override
	public List<BoardDTO> listBoard() throws Exception{

		PreparedStatement pstmt = getConnection().prepareStatement(MyboardConstants.querys.getProperty("LIST_SQL"));
		ResultSet rs = pstmt.executeQuery();
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		while(rs.next()) {
			BoardDTO boardDto = new BoardDTO();
			boardDto.setBid(rs.getInt("bid"));
			boardDto.setBtitle(rs.getString("btitle"));
			boardDto.setBcontent(rs.getString("bcontent"));
			boardDto.setBwdate(rs.getTimestamp("bwdate"));
			boardDto.setBdomain(rs.getString("bdomain"));
			boardDto.setBwriterid(rs.getString("bwriterid"));
			list.add(boardDto);
			
		}
		return list;
	}

}
