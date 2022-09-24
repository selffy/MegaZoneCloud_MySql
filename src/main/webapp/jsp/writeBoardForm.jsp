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
		<form method="post" action="/MyBoard/fileupload" enctype="multipart/form-data">
			분류 :
				<select name="bdomain">
					<option value="">전체<option>
					<option value="notice">공지사항</option>
					<option value="humor">유머</option>
					<option value="free">자유게시판</option>
				</select><br/>
			제목 :  <input type="text" name="btitle" width="500px"><br/>
			내용 : <textarea name="bcontent" rows="10" cols="80"></textarea><br/>	
			첨부파일1 : <input type="file" name="file1"/><br/>
			첨부파일2 : <input type="file" name="file2"/><br/>
			첨부파일3 : <input type="file" name="file3"/><br/>
			<input type="button" value="등록" onclick="this.form.submit();"/>&nbsp;
			<input type="button" value="초기화" onclick="this.form.reset();"/>	
		</form> 	
	</div>
</body>
</html>