<%@page import="com.itwill.member.Member"%>
<%@page import="com.itwill.member.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberDao memberDao = new MemberDao();
%>

<%Member member = new Member(); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<%=
	memberDao.selectAll()
%>
@@@@@@@@@@@@@@@@@@@@@@@
<hr>

</body>
</html>