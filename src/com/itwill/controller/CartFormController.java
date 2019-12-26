package com.itwill.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwill.cart.CartService;
import com.itwill.emo.Emo;
import com.itwill.emo.EmoService;
import com.itwill.member.Member;
import com.itwill.summer.Controller;

public class CartFormController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = "";
		ArrayList<Emo> emoList = new ArrayList<Emo>();
		
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("member");
		
		try {
			EmoService emoService = new EmoService();
			CartService cartService = (CartService)session.getAttribute("cartService");
			if (cartService == null) {
				cartService = new CartService();
				session.setAttribute("cartService", cartService);
			}
			if (session.getAttribute("sUserId") == null) {
				ArrayList<Integer> bLoginCartList = null;
				bLoginCartList = cartService.bLoginGetCartList();//비로그인 카트 이모티콘 번호리스트반환
				
				for (int i = 0; i < bLoginCartList.size(); i++) {
					Emo emo = null;
					emo = emoService.getProduct(bLoginCartList.get(i));
					emoList.add(emo);//이모티콘 리스트 반환
				}
				request.setAttribute("emoList", emoList);
				
			}else {
				ArrayList<Integer> LoginCartList = null;
				LoginCartList = cartService.getCartEmoNoList(member.getM_no());//로그인일경우 회원 카트 이모티콘 번호리스트 반환
				
				for (int i = 0; i < LoginCartList.size(); i++) {
					Emo emo = null;
					emo = emoService.getProduct(LoginCartList.get(i));
					emoList.add(emo);//이모티콘 리스트 반환
				}
				request.setAttribute("emoList", emoList);
			}
					
			forwardPath = "forward:/WEB-INF/view/cart_form.jsp";
				
		} catch (Exception e) {
			forwardPath = "forward:/WEB-INF/view/kakaoerroepage.jsp";
			e.printStackTrace();
		}
		
		return forwardPath;
	}

}
