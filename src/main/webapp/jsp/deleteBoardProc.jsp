<%@page import="myboard.dao.impl.BoardDeleteDAOImpl"%>
<%@page import="myboard.service.BoardDeleteService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id ="boardDTO" class="myboard.dto.BoardDTO"/>
<jsp:getProperty name = "boardDTO" property="bid"/>

<%
	request.setCharacterEncoding("utf-8");
	String bidParam = request.getParameter("bid") == null ? "" : request.getParameter("bid");
	BoardDeleteService boardDeleteService = new BoardDeleteDAOImpl();
	int result = boardDeleteService.deleteBoard(Integer.parseInt(bidParam));

	response.sendRedirect("/MyBoard/jsp/listBoard.jsp");

%>