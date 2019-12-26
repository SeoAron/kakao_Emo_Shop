<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.itwill.emo.Emo"%>
<%@page import="com.itwill.emo.EmoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	EmoDao emoDao = new EmoDao();
	Emo emo = new Emo();
	List<Emo> list = emoDao.getEmoListByView(5);
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
!!!!!!!!!!!!!!!!!!!!!!
<%= list %>
!!!!!!!!!!!!!!!!!!!!!!!!
<%
	for(int i = 0; i < list.size(); i++) {
%>
<%=
	list.get(i)
%>
<%
	}
%>
-------------------------------------------------------------------

<%=
emoDao.getEmoList()
%>
@@@@@@@@@@@@@@@@@@@@@@@
<hr>
<%=
emoDao.getEmoListByStyleNo(1, 1)
%>
@@@@@@@@@@@@@@@@@@@@
<hr>
<%=
emoDao.getEmoListByView(5)
%>
@@@@@@@@@@@@
<hr>
<%=
emoDao.getProduct(1)
%>
@@@@@@
<hr>
<%=
emoDao.getStyleNameByNo(1)
%>
<hr>@@
<%=
emoDao.getEmoStyleCount()
%>
<hr>
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^



</body>
</html>