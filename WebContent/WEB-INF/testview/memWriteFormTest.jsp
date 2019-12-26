<%@page import="com.itwill.member.Member"%>
<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*********   case2********************
	String msg = request.getParameter("msg");
	if(msg==null){
		msg="";
	}
	msg=URLDecoder.decode(msg,"UTF-8");
	*/
	Member member = (Member)request.getAttribute("member");
	if(member==null){
		member=new Member("","","","");
	}
	String msg=(String)request.getAttribute("msg");
	if(msg==null)msg="";
	
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>사용자 관리</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet href="css/styles.css" type="text/css">
<link rel=stylesheet href="css/user.css" type="text/css">
<style type="text/css" media="screen">
</style>
<script type="text/javascript">
	function memberCreate() {
		if (document.f.m_id.value == "") {
			alert("아이디를 입력하세요.");
			document.f.m_id.focus();
			return false;
		}
		if (f.m_pass.value == "") {
			alert("비밀번호를 입력하세요.");
			f.m_pass.focus();
			return false;
		}
		if (f.m_pass.value == "") {
			alert("비밀번호 확인을 입력하세요.");
			f.m_pass.focus();
			return false;
		}
		if (f.m_niname.value == "") {
			alert("별명을 입력하세요.");
			f.m_niname.focus();
			return false;
		}
		if (f.m_phone.value == "") {
			alert("전화번호를 입력하세요.");
			f.m_phone.focus();
			return false;
		}
		if (f.m_pass.value != f.m_pass.value) {
			alert("비밀번호와 비밀번호확인은 일치하여야합니다.");
			f.m_pass.focus();
			f.m_pass.select();
			return false;
		}
		f.action = "memwriteaction.do";
		f.method='POST';
		f.submit();
	}

	function userList() {
		f.action = "memTest.jsp";
		f.submit();
	}
</script>
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
				<table width=0 border=0 cellpadding=0 cellspacing=0>
					<tr>
						<td>
							<!--contents--> <br />
							<table style="padding-left: 10px" border=0 cellpadding=0
								cellspacing=0>
								<tr>
									<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>사용자 관리
											- 회원 가입</b></td>
								</tr>
							</table> <!-- write Form  -->
							<form name="f" method="post">
								<table border="0" cellpadding="0" cellspacing="1" width="590"
									bgcolor="BBBBBB">
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">사용자
											아이디</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px" align="left">
											<input type="text" style="width: 150px" name="m_id"
											value="<%=member.getM_id()%>">&nbsp;&nbsp;<font color="red"><%=msg%></font>
										</td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">비밀번호</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px" align="left">
											<input type="password" style="width: 150px" name="m_pass"
											value="<%=member.getM_pass()%>">
										</td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">비밀번호
											확인</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px" align="left">
											<input type="password" style="width: 150px" name="m_pass2"
											value="<%=member.getM_pass()%>">
										</td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">별명</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px" align="left">
											<input type="text" style="width: 150px" name="m_niname"
											value="<%=member.getM_niname()%>">
										</td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">전화번호</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px" align="left">
											<input type="text" style="width: 150px" name="m_phone"
											value="<%=member.getM_phone()%>">
										</td>
									</tr>
								</table>
							</form> <br />

							<table border=0 cellpadding=0 cellspacing=1>
								<tr>
									<td align=center>
										<input type="button" value="회원 가입"
											onclick="memberCreate();"> &nbsp; 
										<input type="button"
											value="취소" onClick=""></td>
								</tr>
							</table>

						</td>
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
