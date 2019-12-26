<%@page import="com.itwill.notice.NoticeDao"%>
<%@page import="com.itwill.notice.Notice"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.itwill.notice.NoticeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	NoticeDao noticeDao = new NoticeDao();
	Notice notice = new Notice();
	ArrayList<Notice> noticeList = noticeDao.getNoticeList();

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%=
	noticeList
%>
<%-- <%=
	//noticeDao.createNotice("jsp테스트", "테스트1", "테스트1")
%> --%>
<%-- <%=
	noticeDao.deleteNotice(4)
%> --%>
<hr/>
<%=
	noticeDao.getNotice(1)
%>
<%=
	noticeDao.getNotice(2)
%>

</body>
</html>