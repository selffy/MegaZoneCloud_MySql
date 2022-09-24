package myboard.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import myboard.constants.MyboardConstants;
import myboard.service.BoardIDDAO;

public class BoardIDDAOImpl extends BoardDAOImpl implements BoardIDDAO {

	@Override
	public int getBID() throws Exception {

		Connection conn = getConnection();
		String sql = MyboardConstants.querys.getProperty("BID_SQL"); 
		PreparedStatement ptsmt = conn.prepareStatement(sql);	
		ResultSet rs = ptsmt.executeQuery();
		
		int result=0;
		
		if(rs.next()) {
			result = rs.getInt("bid");
		}
		closeConnection(rs, ptsmt, conn);
		return result;
	}

}
