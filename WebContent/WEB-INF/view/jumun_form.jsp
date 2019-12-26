<%@page import="com.itwill.jumun.Jumun"%>
<%@page import="com.itwill.member.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Jumun jumun = (Jumun)request.getAttribute("jumun");
	Member member = (Member)session.getAttribute("member");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>회원수정</title>	
<script type="text/javascript">

function button1_click() {
	alert("구매가 완료되었습니다.");
	document.f.action='emo_buy_action.do';
	document.f.method='post';
	document.f.submit();
}

function button2_click() {
	alert("메인으로 이동합니다.");
	document.f.action='emo_main.do';
	document.f.method='post';
	document.f.submit();
}

</script>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
<link rel="icon" type="image/png" href="images/icons/favicon.ico" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="css/util.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
</head>
<body>

	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<form class="login100-form validate-form" name="f" method="post">
					<span class="login100-form-title p-b-26"> 구매정보<br>&gt;_&lt; </span>

					<div class="wrap-input100 validate-input"
						data-validate="Valid email is: a@b.c">
						닉네임<input class="input100" type="text" name="m_niname" value="<%=member.getM_niname()%>"> <span
							class="focus-input100" ></span>
					</div>

					<div class="wrap-input100 validate-input"
						data-validate="Valid email is: a@b.c">
						주문내역<input class="input100" type="text" name="m_id" value="<%=jumun.getJ_desc()%>" readonly="readonly"> <span
							class="focus-input100" ></span>
					</div>
					
					<div class="wrap-input100 validate-input"
						data-validate="Valid email is: a@b.c">
						주문가격<input class="input100" type="text" name="m_pass" value="<%=jumun.getJ_price()%>"> <span
							class="focus-input100" ></span>
					</div>

					<div class="wrap-input100 validate-input"
						data-validate="Valid email is: a@b.c">
						주문날짜<input class="input100" type="text" name="m_phone" value="<%=jumun.getJ_date()%>"> <span
							class="focus-input100" ></span>
					</div>
					
					<div class="container">
					<div class="row">
					<div class="col" align="center">
					<button type="button"  onclick="button1_click();"  class="btn btn-warning">구매확정</button>&nbsp;&nbsp;&nbsp;&nbsp;
					<button type="button"  onclick="button2_click();" class="btn btn-warning">취소</button>
				</div>
				</div>
				</div>

				</form>
			</div>
		</div>
	</div>


	<div id="dropDownSelect1"></div>

	<!--===============================================================================================-->
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/animsition/js/animsition.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/countdowntime/countdowntime.js"></script>
	<!--===============================================================================================-->
	<script src="js/main.js"></script>

</body>
</html>