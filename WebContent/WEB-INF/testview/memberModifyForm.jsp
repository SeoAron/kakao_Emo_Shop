<%@page import="com.itwill.member.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	Member member =(Member)request.getAttribute("member");
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>member수정폼</h1><hr>
<form action="memberactionform.do" method="post">
	닉네임<input type="text" name="m_niname" value="<%=member.getM_niname() %>"><br/>
	아이디<input type="text" name="m_id" value="<%=member.getM_id() %>"><br/>
	패스워드<input type="text" name="m_pass" value="<%=member.getM_pass() %>"><br/>
	전화번호<input type="text" name="m_phone" value="<%=member.getM_phone() %>"><br/>
	<input type="submit" value="수정">
	<input type="reset" value="취소">
</form>
</body>
</html>