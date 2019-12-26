<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보</title>
<style>
    body {
        margin-left: 100px;
        margin-right: 100px;
    }
  
</style>
</head>
<body>
<h3 align="center">개인정보수정</h3>
<form action="membermodifyaction.do" method="post">
<hr width="350">
	<div align="center">
      닉&nbsp;네&nbsp;임&nbsp;&nbsp;<input type="text" name="m_niname"><br/>
    </div>
<hr width="350">
	<div align="center">
   	아이디<input type="text" name="m_id"><br/>
    </div>
<hr width="350">
	<div align="center">
    비밀번호<input type="text" name="m_pass"><br/>
    </div> 
<hr width="350">
	<div align="center">
    전화번호<input type="text" name="m_phone"><br/>
    </div>  <br/> 
    <div align="center">   
    <input type="submit" value="수정">
	<input type="submit" value="회원탈퇴">
	<input type="reset" value="취소">
	</div>
</body>
</html>