<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>memberinsert폼</h1><hr>
<form action="memberactionform.do" method="post">
	닉네임<input type="text" name="m_niname"><br/>
	아이디<input type="text" name="m_id"><br/>
	패스워드<input type="text" name="m_pass"><br/>
	전화번호<input type="text" name="m_phone"><br/>
	<input type="submit" value="등록">
	<input type="reset" value="취소">
</form>
</body>
</html>