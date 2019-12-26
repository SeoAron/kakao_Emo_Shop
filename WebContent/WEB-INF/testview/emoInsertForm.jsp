<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>insert폼</h1><hr>
<form action="emoactionform.do" method="post">
	<!-- 이모티콘번호<input type="text" name="p_no"><br/> -->
	이모티콘이름<input type="text" name="emo_name"><br/>
	이모티콘가격<input type="text" name="emo_price"><br/>
	이모티콘설명<input type="text" name="emo_context"><br/>
	이모티콘그룹넘버<input type="text" name="emo_gruopNo"><br/>
	아이템조회수<input type="text" name="emo_viewCount"><br/>
	<input type="submit" value="등록">
	<input type="reset" value="취소">
</form>
</body>
</html>