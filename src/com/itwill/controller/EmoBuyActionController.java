package com.itwill.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwill.cart.CartService;
import com.itwill.jumun.JumunService;
import com.itwill.member.Member;
import com.itwill.summer.Controller;

public class EmoBuyActionController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = "";
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("member");
		
		try {
			JumunService jumunService = new JumunService();
			jumunService.addDetailEmoList(member.getM_no()); //결제 완료시 주문디테일DB 추가
			jumunService.addMemberEmoList(member.getM_no());
			
			CartService cartService = new CartService();
			cartService.deleteCart(member.getM_no()); //결제 완료시 회원 카트비우기
			
			forwardPath = "redirect:emo_main.do";
			
		} catch (Exception e) {
			forwardPath = "forward:/WEB-INF/view/kakaoerroepage.jsp";
			e.printStackTrace();
		}
		return forwardPath;
	}

}
