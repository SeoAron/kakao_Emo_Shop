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
<h3 align="center">로그인</h3>
<form action="membermodifyaction.do" method="post">
<hr width="350">
	<div align="center">
   	아&nbsp;이&nbsp;디&nbsp;&nbsp;<input type="text" style="width: 150" name="userId" value=""><br/>
    </div>
<hr width="350">
	<div align="center">
    비밀번호&nbsp;&nbsp;<input type="password"style="width: 150" name="password" value="">
    </div>
<hr width="350">
   <div align="center">   
   <input type="button" value="로그인"	onClick="login();"> &nbsp;
   <input type="button" value="회원가입" onClick="userCreateForm();">
   </div>
</body>
</html>