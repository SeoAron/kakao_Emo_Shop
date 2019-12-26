package com.itwill.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.emo.Emo;
import com.itwill.emo.EmoService;
import com.itwill.summer.Controller;

public class EmoBestController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = "";
		
		try {
			EmoService emoService = new EmoService();
			List<Emo> emoList = emoService.getEmoListByView(30);// 인기순으로 30개 뽑기
			request.setAttribute("emoList", emoList);
			
			forwardPath = "forward:/WEB-INF/view/emo_Best.jsp";
			
		} catch (Exception e) {
			forwardPath = "forward:/WEB-INF/view/kakaoerroepage.jsp";
			e.printStackTrace();
		}
		return forwardPath;
	}

}
