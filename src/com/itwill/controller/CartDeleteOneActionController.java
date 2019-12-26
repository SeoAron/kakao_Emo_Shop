package com.itwill.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwill.cart.Cart;
import com.itwill.cart.CartService;
import com.itwill.member.Member;
import com.itwill.summer.Controller;

public class CartDeleteOneActionController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = "";
		String p_no = request.getParameter("p_no");
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("member");
		
		try {
			CartService cartService = (CartService)session.getAttribute("cartService");
			if (cartService == null) {
				cartService = new CartService();
				session.setAttribute("cartService", cartService);
			}
			if (session.getAttribute("sUserId") == null) {
				cartService.bLoginCartDelete(Integer.parseInt(p_no));
			}else {
				cartService.deleteUserCart(member.getM_no(), Integer.parseInt(p_no));//로그인한사람 장바구니 삭제
			}
					
			forwardPath = "";
				
		} catch (Exception e) {
			forwardPath = "forward:/WEB-INF/view/kakaoerroepage.jsp";
			e.printStackTrace();
		}
		
		return forwardPath;
	}
	

}
