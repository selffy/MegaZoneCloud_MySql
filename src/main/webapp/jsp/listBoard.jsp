<%@page import="myboard.dao.impl.BoardDAOImpl"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="myboard.dto.BoardDTO"%>
<%@page import="java.util.List"%>
<%@page import="myboard.dao.impl.BoardListDAOImpl"%>
<%@page import="myboard.service.BoardListService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
	String bdomainParam = request.getParameter("bdomain") == null ? "" : request.getParameter("bdomain");
	String searchDomainParam = request.getParameter("searchDomain")  == null ? "" : request.getParameter("searchDomain");
	String searchTextParam = request.getParameter("searchText")  == null ? "" : request.getParameter("searchText");

	Map<String, String> searchMap = new HashMap<String, String>();
	searchMap.put("searchDomain", searchDomainParam);
	searchMap.put("searchText", searchTextParam);
	
	pageContext.setAttribute("list", new BoardListDAOImpl().listBoard(bdomainParam, searchMap));
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 리스트</title>
</head>
<body>
<div>
	<h3>게시물 리스트화면</h3>
</div>
<div>
	<form name="searchForm" action="/MyBoard/jsp/listBoard.jsp">
			<select name="domainSelect" onchange="location.href='/MyBoard/jsp/listBoard.jsp?bdomain='+this.value; " >
				<option value="" ${param.bdomain==''? 'selected' : ''}>전체</option>
				<option value="notice" ${param.bdomain=='notice'? 'selected' : ''}>공지</option>
				<option value="humour" ${param.bdomain=='humour'? 'selected' : ''}>유머</option>
				<option value="free" ${param.bdomain=='free'? 'selected' : ''}>자유</option>
			</select>&nbsp;&nbsp;
      		
		<select name="searchDomain">
	      <option value="" ${param.searchDomain == '' ? 'selected' : '' }/>전체</option>
	      <option value="btitle" "${param.searchDomain == 'btitle' ? 'selected' : '' }/>제목</option>
	      <option value="bwriterid" ${param.searchDomain == 'bwriterid' ? 'selected' : '' }/>작성자</option>
	     </select> &nbsp;
	      
	     <input type="text" name="searchText" value="${param.searchText}"/> &nbsp;
	     <input type="button" value="검색" onlclick="this.form.submit();"/>
    </form>
</div>
<div>
	<table>
		<colgroup>
			<col width="5%"/>
			<col width="5%"/>
			<col width="40%"/>
			<col width="10%"/>
			<col width="16%"/>
			<col width="10%"/>
			<col width="7%"/>
			<col width="7%"/>
		</colgroup>
		<thead>
			<tr>
				<th>번호</th>
				<th>분류</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일시</th>
				<th>첨부파일수</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>	
		</thead>
		<tbody>
			<c:set var="listSize" value="${list.size()}"/>
			<c:forEach var="boardDTO" items="${list}" varStatus="stat">
			<c:set var="bno" value="${listSize-stat.count+1}"/>
			<tr>
				<td>${bno}</td>
				<td>
				${boardDTO.bdomain=='notice' ? '공지' : ''}
				${boardDTO.bdomain=='humor' ? '유머' : ''}
				${boardDTO.bdomain=='free' ? '자유' : ''}
				</td>
				<td><a href="/MyBoard/jsp/viewBoard.jsp?bid=${boardDTO.bid}&bno=${bno}">${boardDTO.btitle}</a></td>
				<td>${boardDTO.bwriterid}"</td>
				<td><fmt:formatDate value='${boardDTO.bwdate}' pattern='yyyy.MM.dd.hh:mm'/></td>
				<td></td>
				<td><a href="/MyBoard/jsp/UpdateBoardForm.jsp?bid=${boardDTO.bid}">[수정]</a></td>
				<td><a href="/MyBoard/jsp/deleteBoardProc.jsp?bid=${boardDTO.bid}">[삭제]</a></td>
			</tr>
			</c:forEach>			
		</tbody>
	</table>
</div>
<div>
	<input type="button" value="등록" onclick="location.href='/MyBoard/jsp/writeBoardForm.jsp';"/>
</div>
</body>
</html>