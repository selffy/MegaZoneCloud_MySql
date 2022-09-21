<%@page import="myboard.dto.BoardDTO"%>
<%@page import="myboard.dao.impl.BoardViewDAOImpl"%>
<%@page import="myboard.service.BoardViewService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
    
<%
	String bidParam = request.getParameter("bid") == null ? "" :request.getParameter("bid");
	BoardViewService boardViewService = new BoardViewDAOImpl();
	BoardDTO boardDTO = boardViewService.viewBoard(Integer.parseInt(bidParam));
	pageContext.setAttribute("boardDTO", boardDTO);
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	<h3>게시물 보기</h3>
</div>
<div>
	번호 : ${param.bno}<br/>
	분류 : ${boardDTO.bdomain}<br/>
	작성자 : ${boardDTO.bwriterid}<br/>
	작성일시 : <fmt:formatDate value = '${boardDTO.bwdate}' pattern='yyyy.MM.dd.hh:mm'/><br/>
	제목 : ${boardDTO.btitle}<br/>
	내용 : <textarea readonly>${boardDTO.bcontent}</textarea>
</div>
<div>
	<input type="button" value="목록" onclick="location.href='/MyBoard/jsp/listBoard.jsp';"/>
</div>
</body>
</html>