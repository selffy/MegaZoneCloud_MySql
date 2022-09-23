<%@page import="myboard.dao.impl.BoardWriteDAOImpl"%>
<%@page import="myboard.service.BoardWriteService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id ="boardDTO" class="myboard.dto.BoardDTO"/>
<jsp:setProperty name = "boardDTO" property="*" />
<jsp:setProperty name = "boardDTO" property="bwriterid" value="anonymous" />

<jsp:useBean id="boardWriteDAOImpl" class="myboard.dao.impl.BoardWriteDAOImpl"/>

<%
	request.setCharacterEncoding("utf-8");
	BoardWriteService boardWriteService = new BoardWriteDAOImpl();
	int result = boardWriteService.writeBoard(boardDTO);
	
	if(result > 0) {
		out.print("<script>alert('정상적으로 입력 되었습니다!' loaction.href='/MyBoard/jsp/listBoard.jsp';</script>");
	} else {
		out.print("<script>alert('입력 오류가 발생했습니다!' loaction.href='/MyBoard/jsp/listBoard.jsp';</script>");
	}
	response.sendRedirect("/MyBoard/jsp/listBoard.jsp");	
%>

