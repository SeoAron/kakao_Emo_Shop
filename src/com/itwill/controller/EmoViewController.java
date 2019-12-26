package com.itwill.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.emo.Emo;
import com.itwill.emo.EmoService;
import com.itwill.summer.Controller;

public class EmoViewController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = "";
		String emo_no = request.getParameter("emo_no");
		if(emo_no==null||emo_no.equals("")){
			forwardPath="forward:/WEB-INF/view/kakaoerroepage.jsp"; //파라미터 안들어왔을경우 보낼페이지
		}else {
			try {
				EmoService emoService = new EmoService();
				Emo emo = emoService.getProduct(Integer.parseInt(emo_no));
				if (emo == null) {
					forwardPath = "";// 이전 리스트로 리다이렉트
				}else {
					request.setAttribute("emo", emo);
					forwardPath = "forward:/WEB-INF/view/emo_view.jsp";
				}
			} catch (Exception e) {
				forwardPath = "forward:/WEB-INF/view/kakaoerroepage.jsp";
				e.printStackTrace();
			}
		}
		return forwardPath;
	}

}
