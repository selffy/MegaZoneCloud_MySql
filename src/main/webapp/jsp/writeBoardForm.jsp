<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	<div>
		<h3>게시물 등록 화면</h3>
	</div>
	<div>
	<form method="post" action="/MyBoard/jsp/writeBoardProc.jsp">
		분류 :
			<select name="bdomain">
				<option value="notice">공지사항</option>
				<option value="humor">유머</option>
				<option value="free">자유게시판</option>
			</select><br/>
		제목 :  <input type="text" name="btitle" width="400px"><br/>
		내용 : <textarea name="bcontent" rows="20" cols="100"></textarea><br/>	
		<input type="button" value="등록" onclick="this.form.submit();"/>&nbsp;
		<input type="button" value="초기화" onclick="this.form.reset();"/>	
	</form>
	</div>
</body>
</html>