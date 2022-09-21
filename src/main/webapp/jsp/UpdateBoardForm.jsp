<%@page import="myboard.dao.impl.BoardViewDAOImpl"%>
<%@page import="myboard.service.BoardViewService"%>
<%@page import="myboard.dto.BoardDTO"%>
<%@page import="myboard.dao.BoardDAO"%>
<%@page import="myboard.dao.impl.BoardUpdateDAOImpl"%>
<%@page import="myboard.service.BoardUpdateService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String bidParam = request.getParameter("bid") == null ? "" : request.getParameter("bid");
	BoardViewService boardViewService = new BoardViewDAOImpl();
	BoardDTO boardDTO = boardViewService.viewBoard(Integer.parseInt(bidParam));
	pageContext.setAttribute("boardDTO", boardDTO);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	<div>
		<h3>게시글 수정 화면</h3>
	</div>
	<div>
	<form method="post" action="/MyBoard/jsp/updateBoardProc.jsp">
	<input type="hidden" name="bid" value="${boardDTO.bid}">
		분류 :
			<select name="bdomain">
				<option value="notice" ${boardDTO.bdomain == 'notice' ? 'selected' : ''}>공지사항</option>
				<option value= "humor"${boardDTO.bdomain == 'humor' ? 'selected' : ''}>유머</option>
				<option value="free" ${boardDTO.bdomain == 'free' ? 'selected' : ''} >자유게시판</option>
			</select><br/>
		제목 :  <input type="text" name="btitle" width="400px" value="${boardDTO.btitle}"><br/>
		내용 : <textarea name="bcontent" rows="20" cols="100">${boardDTO.bcontent}</textarea><br/>	
		<input type="button" value="수정" onclick="this.form.submit();"/>
	</form>
	</div>
</body>
</html>