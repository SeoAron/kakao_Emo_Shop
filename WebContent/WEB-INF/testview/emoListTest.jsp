<%@page import="com.itwill.emo.Emo"%>
<%@page import="com.itwill.emo.EmoDao"%>
<%@page import="com.itwill.cart.CartService"%>
<%@page import="java.text.DecimalFormat"%>


<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	CartService cart = (CartService) session.getAttribute("cart");
	if (cart == null) {
		cart = new CartService();
	}
	session.setAttribute("cart", cart);

	EmoDao emoDao = new EmoDao();
	List<Emo> emoList = emoDao.getEmoList();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>이모티콘</title>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<link rel=stylesheet href="css/styles.css" type="text/css">
<link rel=stylesheet href="css/shop.css" type="text/css">
<style type="text/css" media="screen">
</style>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0
	marginwidth=0 marginheight=0>
	<!-- container start-->
	<div id="container">
		<!-- header start -->
		<div id="header">
		</div>
		<!-- header end -->
		<!-- navigation start-->
		<div id="navigation">
		</div>
		<!-- navigation end-->
		<!-- wrapper start -->
		<div id="wrapper">
			<!-- content start -->

			<!-- include_content.jsp start-->
			<div id="content">
				<table border=0 cellpadding=0 cellspacing=0>
					<tr>
						<td><br />
							<table style="padding-left: 10px" border=0 cellpadding=0
								cellspacing=0>
								<tr>
									<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>전체리스트</b></td>
								</tr>
							</table>

							<form name="f" method="post">
								<table width="100%" align="center" border="1" cellspacing="0"
									cellpadding="3" bordercolordark="white"
									bordercolorlight="#556b2f">
									<tr>
										<%
											for (Emo emo : emoList) {
												DecimalFormat df = new DecimalFormat("#,##0");
										%>

										<td align="center" width="25%">
										<a href = "emoListdetail.jsp?id=<%=emo.getEmo_no()%>"></a><br /> <br />
											<b>이름:<%=emo.getEmo_name()%></b><br> <font color="#FF0000">가격:<%=df.format(emo.getEmo_price())%>원
										</font><br />
										</td></tr>
										<%
											}
										%>
									</tr>
								</table>
										<input type = "button" value ="이모티콘 등록" onClick = "emoCreate();">
										<input type = "button" value ="장바구니" onClick = "emoCreate();"><br />
							</form> <br /></td>
					</tr>
				</table>
			</div>
			<!-- include_content.jsp end-->
			<!-- content end -->
		</div>
		<!--wrapper end-->
		<div id="footer">
		</div>
	</div>
	<!--container end-->
</body>
</html>