package myboard.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import myboard.constants.MyboardConstants;
import myboard.dao.BoardListDAO;
import myboard.dto.BoardDTO;

public class BoardListDAOImpl extends BoardDAOImpl implements BoardListDAO{

	@Override
	public List<BoardDTO> listBoard(String bdomain, Map<String, String> searchCriteria) throws Exception {
		
		String prependSQL = MyboardConstants.querys.getProperty("LIST_SEARCH_SQL_PREPEND");
		String appendSQL = MyboardConstants.querys.getProperty("LIST_SEARCH_SQL_APPEND");
		String whereSQL = "";
		StringBuffer whereSQLBuffer = new StringBuffer();

		if(bdomain.equals("")) {
			whereSQLBuffer.append(" where 1=1 ");
		} else {
			whereSQLBuffer.append(" where bdomain='");
			whereSQLBuffer.append(bdomain);
			whereSQLBuffer.append("' ");			
		}
		
		String searchDomainValue = searchCriteria.get("searchDomain");
		String searchTextValue = searchCriteria.get("searchText");
		
		if(searchDomainValue != null && searchTextValue != null){
			whereSQLBuffer.append(" and ");
			whereSQLBuffer.append(searchDomainValue);
			whereSQLBuffer.append(" like '%");
			whereSQLBuffer.append(searchTextValue);
			whereSQLBuffer.append("%' ");					
			}
		
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(prependSQL + whereSQL + appendSQL);
		ResultSet rs = pstmt.executeQuery();
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		while(rs.next()) {
			BoardDTO boardDTO = new BoardDTO();
			boardDTO.setBid(rs.getInt("bid"));
			boardDTO.setBtitle(rs.getString("btitle"));
			boardDTO.setBcontent(rs.getString("bcontent"));
			boardDTO.setBwdate(rs.getTimestamp("bwdate"));
			boardDTO.setBdomain(rs.getString("bdomain"));
			boardDTO.setBwriterid(rs.getString("bwriterid"));
			list.add(boardDTO);			
		}
		closeConnection(rs, pstmt, conn);
		return list;
		
	}//listboard
	
}//class
