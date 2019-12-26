<%@page import="com.itwill.member.Member"%>
<%@page import="com.itwill.jumun.Jumun"%>
<%@page import="com.itwill.emo.Emo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	Jumun jumun = (Jumun)request.getAttribute("jumun");
	Member member = (Member)session.getAttribute("member");
%>
<!DOCTYPE html>
<head>
	<title>Product Detail</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="images/icons/favicon.png"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/linearicons-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/slick/slick.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/MagnificPopup/magnific-popup.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/perfect-scrollbar/perfect-scrollbar.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
</head>
<body class="animsition">

	<!-- Header -->
	<header class="header-v2">
		<!-- Header desktop -->
		<div class="container-menu-desktop trans-03">
			<div class="wrap-menu-desktop">


				<nav class="limiter-menu-desktop p-l-45">

					<!-- Logo desktop -->
					<a href="#" class="logo"> <img src="images/icons/kakaoicon.jpg"
						alt="IMG-LOGO">
					</a>


					<!-- Menu desktop -->
					<div class="menu-desktop">
						<ul class="main-menu">
							<li class="on #nav_home"><a href="emo_main.do"
								class="link_gnb link_gnb1"><b><u>홈</u></b><span
									class="animate_line"></span></a></li>
							<li class=" #nav_new"><a href="emo_best.do"
								class="link_gnb link_gnb2">인기<span class="animate_line"></span></a></li>
							<li class=" #nav_hot"><a href="emo_style.do"
								class="link_gnb link_gnb3">스타일<span class="animate_line"></span></a></li>
							<li class=" #nav_hot"><a href="notice_list.do"
								class="link_gnb link_gnb3">공지 사항 <span class="animate_line"></span></a></li>
					</div>

					<!-- Icon header -->

					<div class="wrap-icon-header flex-w flex-r-m h-full">
						<%if(session.getAttribute("sUserId") != null && session.getAttribute("sUserId").equals("admin")) {%>
						<a href="emo_insert_form.do">관리자 페이지</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<%} %>
						<%if(session.getAttribute("sUserId") == null || session.getAttribute("sUserId").equals("")) {%>
						<%}else{ %>
						<a href="user_modify_form.do"><%=session.getAttribute("sUserId")%></a>&nbsp;&nbsp;
						<%} %>
						<!-- 로그인 -->
						<%if(session.getAttribute("sUserId") == null || session.getAttribute("sUserId").equals("")) {%>
						<a href="user_login_form.do">Log In </a>&nbsp;&nbsp;
						<%} %>
						<%if(session.getAttribute("sUserId") == null || session.getAttribute("sUserId").equals("")) {%>
						<%}else{ %>
						<a href="user_logout_action.do">Log out</a>
						<%} %>

						<div class="flex-c-m h-full p-l-18 p-r-25 bor5">
							<li class=" #nav_hot"><a href="cart_form.do"
								class="link_gnb link_gnb3"><b><u>Cart</u></b><span
									class="animate_line"></span></a></li>
						</div>
					</div>
			</div>
			</nav>
		</div>
		</div>

		<!-- Header Mobile -->
		<div class="wrap-header-mobile">
			<!-- Logo moblie -->
			<div class="logo-mobile">
				<a href="index.html"><img src="images/icons/kakaoicon.jpg"
					alt="IMG-LOGO"></a>
			</div>

			<!-- Icon header -->
			<div class="wrap-icon-header flex-w flex-r-m h-full m-r-15">
				<div class="flex-c-m h-full p-r-10">
					<div
						class="icon-header-item cl2 hov-cl1 trans-04 p-lr-11 js-show-modal-search">
						<i class="zmdi zmdi-search"></i>
					</div>
				</div>

				<div class="flex-c-m h-full p-lr-10 bor5">
					<div
						class="icon-header-item cl2 hov-cl1 trans-04 p-lr-11 icon-header-noti js-show-cart"
						data-notify="2">
						<i class="zmdi zmdi-shopping-cart"></i>
					</div>
				</div>
			</div>

			<!-- Button show menu -->
			<div class="btn-show-menu-mobile hamburger hamburger--squeeze">
				<span class="hamburger-box"> <span class="hamburger-inner"></span>
				</span>
			</div>
		</div>






		<!-- Modal Search -->
		<div
			class="modal-search-header flex-c-m trans-04 js-hide-modal-search">
			<div class="container-search-header">
				<button
					class="flex-c-m btn-hide-modal-search trans-04 js-hide-modal-search">
					<img src="images/icons/icon-close2.png" alt="CLOSE">
				</button>

				<form class="wrap-search-header flex-w p-l-15">
					<button class="flex-c-m trans-04">
						<i class="zmdi zmdi-search"></i>
					</button>
					<input class="plh3" type="text" name="search"
						placeholder="Search...">
				</form>
			</div>
		</div>
	</header>


	<!-- Cart -->



	<!-- Slider -->

	<div class="sc-EHOje eFUkzL">
		<div class="sc-bZQynM gJPQeO">

			<ul class="sc-gzVnrw ihHoGK">
				<div class="slick-initialized slick-slider">
					<div class="slick-list">
						<div class="slick-track"
							style="opacity: 1; transform: translate3d(-1090px, 0px, 0px); width: 3270px;">
							<li data-index="-1" class="slick-slide slick-cloned"
								style="background-color: rgb(123, 215, 233); width: 1090px;"><a
								target="_blank" class="sc-htoDjs eRKRko"
								href="https://e.kakao.com/item/hot?referer=mainb61"><img
									src="https://item.kakaocdn.net/dn/N9d4G/btqvqW9sVLz/K1BLy5BY0RTf1R1LfBh4kK/img.png"
									height="340" class="thumb_img" style="display: inline-block;"></a></li>
							<li data-index="0" class="slick-slide slick-active" tabindex="-1"
								style="outline: none; background-color: rgb(123, 215, 233); width: 1090px;"><a
								target="_blank" class="sc-htoDjs eRKRko"
								href="https://e.kakao.com/item/hot?referer=mainb61"><img
									src="https://item.kakaocdn.net/dn/N9d4G/btqvqW9sVLz/K1BLy5BY0RTf1R1LfBh4kK/img.png"
									height="340" class="thumb_img" style="display: inline-block;"></a></li>
							<li data-index="1" class="slick-slide slick-cloned"
								style="background-color: rgb(123, 215, 233); width: 1090px;"><a
								target="_blank" class="sc-htoDjs eRKRko"
								href="https://e.kakao.com/item/hot?referer=mainb61"><img
									src="https://item.kakaocdn.net/dn/N9d4G/btqvqW9sVLz/K1BLy5BY0RTf1R1LfBh4kK/img.png"
									height="340" class="thumb_img" style="display: inline-block;"></a></li>
						</div>
					</div>
				</div>
			</ul>
		</div>
	</div>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
<table style="center: 100px" border=0 width=100% height=376
								align=center>
								<%=jumun.getJ_no() %>
								<%=jumun.getJ_desc() %>
								<%=jumun.getJ_price() %>
								<%=jumun.getJ_date() %>
								<%=jumun.getM_no() %>
								<%=member.getM_niname() %>
								<%=member.getM_id() %>
							</table> 
							
							
					</tr>
				</table>
			</div>
			
			<table style=100px border=0 width=100% height=376 align="center">
								<tr>
									<td align=center>
										<a href = "emo_buy_action.do">구매확정</a>
										<a href = "emo_main.do">취소하기</a>
									</td>
								</tr>
							</table></td>
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	<!-- Footer -->
			<footer class="bg3 p-t-75 p-b-32">
				<div class="container">
					<div data-react-class="ScrollTop" data-react-props="{}">
						<div>
							<div
								style="position: fixed; bottom: 50px; right: 30px; cursor: pointer; transition: opacity 0.2s linear 0s, visibility; opacity: 0; visibility: hidden;">
								<button class="sc-bsbRJL YUAgY">
									<span class="sc-hZSUBg LaeNH">TOP</span>
								</button>
							</div>
						</div>
					</div>
					<hr class="hide">
					<div id="dkFoot" class="footer_comm " role="contentinfo">
						<div class="inner_footer">
							<h2 class="screen_out">김천희 컴퍼니 이용정보</h2>
							<div class="footer_link">
								<a href="/main/faq" target="_blank" class="link_info">자주묻는
									질문</a> <span class="txt_bar">|</span> <a
									href="https://cs.kakao.com/requests?category=278&amp;locale=ko&amp;node=30555&amp;service=94"
									target="_blank" class="link_info">문의하기</a> <span
									class="txt_bar">|</span> <a
									href="https://web.payments.kakao.com/v1/service_terms"
									target="_blank" class="link_info">유료이용약관</a> <span
									class="txt_bar">|</span> <a
									href="https://www.kakao.com/policy/privacy" target="_blank"
									class="link_info">개인정보취급방침</a>
							</div>
							<em class="emph_info">카카오 이모티콘 스토어에서 판매되는 콘텐츠의 저작권은 제공처에
								있으며, 이를 무단 이용하는 경우 저작권법 등에 따라 처벌될 수 있습니다.<br> 상호: 주식회사 카카오,
								<span class="txt_leader">대표자: 여민수, 조수용,</span> <span
								class="txt_num">사업자등록번호: 120-81-47521,</span> <a href="#none"
								target="blank" onclick="onopen(event);"
								style="padding-right: 9px; text-decoration: underline; text-decoration-color: #666;">사업자정보
									확인</a> 통신판매업신고번호: 제2012-제주아라-0011호
							</em>
							<address class="txt_address">호스팅제공자: (주)카카오, 주소 :
								제주특별자치도 제주시 첨단로 242(영평동), 고객센터 : 1577-3754</address>
							<small class="txt_copyright"><a
								href="https://www.kakaocorp.com" target="_blank"
								class="link_info">© kakao Corp.</a></small>

						</div>
			</footer>
<!--===============================================================================================-->	
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
	<script>
		$(".js-select2").each(function(){
			$(this).select2({
				minimumResultsForSearch: 20,
				dropdownParent: $(this).next('.dropDownSelect2')
			});
		})
	</script>
<!--===============================================================================================-->
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="vendor/slick/slick.min.js"></script>
	<script src="js/slick-custom.js"></script>
<!--===============================================================================================-->
	<script src="vendor/parallax100/parallax100.js"></script>
	<script>
        $('.parallax100').parallax100();
	</script>
<!--===============================================================================================-->
	<script src="vendor/MagnificPopup/jquery.magnific-popup.min.js"></script>
	<script>
		$('.gallery-lb').each(function() { // the containers for all your galleries
			$(this).magnificPopup({
		        delegate: 'a', // the selector for gallery item
		        type: 'image',
		        gallery: {
		        	enabled:true
		        },
		        mainClass: 'mfp-fade'
		    });
		});
	</script>
<!--===============================================================================================-->
	<script src="vendor/isotope/isotope.pkgd.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/sweetalert/sweetalert.min.js"></script>
	<script>
		$('.js-addwish-b2, .js-addwish-detail').on('click', function(e){
			e.preventDefault();
		});

		$('.js-addwish-b2').each(function(){
			var nameProduct = $(this).parent().parent().find('.js-name-b2').html();
			$(this).on('click', function(){
				swal(nameProduct, "is added to wishlist !", "success");

				$(this).addClass('js-addedwish-b2');
				$(this).off('click');
			});
		});

		$('.js-addwish-detail').each(function(){
			var nameProduct = $(this).parent().parent().parent().find('.js-name-detail').html();

			$(this).on('click', function(){
				swal(nameProduct, "is added to wishlist !", "success");

				$(this).addClass('js-addedwish-detail');
				$(this).off('click');
			});
		});

		/*---------------------------------------------*/

		$('.js-addcart-detail').each(function(){
			var nameProduct = $(this).parent().parent().parent().parent().find('.js-name-detail').html();
			$(this).on('click', function(){
				swal(nameProduct, "is added to cart !", "success");
			});
		});
	
	</script>
<!--===============================================================================================-->
	<script src="vendor/perfect-scrollbar/perfect-scrollbar.min.js"></script>
	<script>
		$('.js-pscroll').each(function(){
			$(this).css('position','relative');
			$(this).css('overflow','hidden');
			var ps = new PerfectScrollbar(this, {
				wheelSpeed: 1,
				scrollingThreshold: 1000,
				wheelPropagation: false,
			});

			$(window).on('resize', function(){
				ps.update();
			})
		});
	</script>
<!--===============================================================================================-->
	<script src="js/main.js"></script>

</body>
</html>