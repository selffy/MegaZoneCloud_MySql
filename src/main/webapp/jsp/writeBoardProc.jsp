<%@page import="myboard.dao.impl.BoardIDDAOImpl"%>
<%@page import="myboard.service.BoardIDService"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Collection"%>
<%@page import="myboard.dto.BoardFileDTO"%>
<%@page import="myboard.dao.impl.BoardFIleWriteDAOImpl"%>
<%@page import="myboard.service.BoardFileService"%>
<%@page import="myboard.dao.impl.BoardWriteDAOImpl"%>
<%@page import="myboard.service.BoardWriteService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id ="boardDTO" class="myboard.dto.BoardDTO"/>
<jsp:setProperty name = "boardDTO" property="*" />
<jsp:setProperty name = "boardDTO" property="bwriterid" value="anonymous" />

<!-- <jsp:useBean id="boardWriteDAOImpl" class="myboard.dao.impl.BoardWriteDAOImpl"/> -->!

<%
	BoardWriteService boardWriteService = new BoardWriteDAOImpl();
	int resultBoard = boardWriteService.writeBoard(boardDTO);

	//등록된 게시물의 id를 획득
	BoardIDService boardIDService = new BoardIDDAOImpl();
	int bid = boardIDService.getBID();
	
	// 첨부파일정보를 테이블에 등록
	BoardFileService boardFileService = new BoardFIleWriteDAOImpl();
	Collection<Part> parts = request.getParts();
	System.out.println("여기까진 잘됨?");
	List<String> sfnList = (List<String>)request.getAttribute("sfnList");
	System.out.println(sfnList.toString());
	int sfnListIndex = 0;
	
	for(Part part : parts) {	
		if(part.getHeader("Content-Disposition").contains("filename=") && part.getSize()>0){
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setBfcfn(part.getSubmittedFileName());
			boardFileDTO.setBfsfn(sfnList.get(sfnListIndex++));
			boardFileDTO.setBfsize((int)part.getSize());
			boardFileService.writeBoardFile(bid, boardFileDTO);			
		}
	}
	
	
	if(resultBoard > 0) {
		out.print("<script>alert('정상적으로 입력 되었습니다!' loaction.href='/MyBoard/jsp/listBoard.jsp';</script>");
	} else {
		out.print("<script>alert('입력 오류가 발생했습니다!' loaction.href='/MyBoard/jsp/listBoard.jsp';</script>");
	}
	//response.sendRedirect("/MyBoard/jsp/listBoard.jsp");	
%>

