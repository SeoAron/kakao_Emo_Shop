<%@page import="com.itwill.emo.Emo"%>
<%@page import="com.itwill.emo.EmoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8");
	String no = request.getParameter("p_no");
	String name = request.getParameter("p_name");
	String price = request.getParameter("p_price");
	String desc = request.getParameter("p_desc");
	String emostyleno = request.getParameter("p_emostyleno");
	String click = request.getParameter("p_click");
	int noStr = Integer.parseInt(no);
	int priceStr = Integer.parseInt(price);
	int gruopStr = Integer.parseInt(emostyleno);
	int viewCountStr = Integer.parseInt(click);
	
	try{
		EmoDao emoDao = new EmoDao();
		Emo emoCreate = new Emo(noStr,name,priceStr,desc,gruopStr,viewCountStr);
		emoDao.create(emoCreate);
		
		response.sendRedirect("emoListTest.jsp");
	}catch(Exception e){
		e.printStackTrace();
	}
	
	
	

	
%>