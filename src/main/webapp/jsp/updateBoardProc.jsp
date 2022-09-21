<%@page import="myboard.dao.impl.BoardUpdateDAOImpl"%>
<%@page import="myboard.dao.impl.BoardWriteDAOImpl"%>
<%@page import="myboard.service.BoardUpdateService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id ="boardDTO" class="myboard.dto.BoardDTO"/>
<jsp:setProperty name = "boardDTO" property="*" />
<jsp:setProperty name = "boardDTO" property="bwriterid" value="anonymous" />

<%
	request.setCharacterEncoding("utf-8");
	BoardUpdateService boardUpdateService = new BoardUpdateDAOImpl();
	int result = boardUpdateService.updateBoard(boardDTO);
	
	

	if(result != 0) {
		out.print("<script>alert('정상적으로 수정 되었습니다!');</script>");
	} else {
		out.print("<script>alert('수정 오류가 발생했습니다!');</script>");
	}	
	response.sendRedirect("/MyBoard/jsp/listBoard.jsp");
%>

