package com.itwill.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.emo.Emo;
import com.itwill.emo.EmoDao;
import com.itwill.summer.Controller;

public class EmoInsertActionController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = "";
//		String forwardPath = "";
		
		try{
			if(request.getMethod().equalsIgnoreCase("GET")){
				forwardPath="redirect:error.do";
			}else {
			request.setCharacterEncoding("UTF-8");
			//String no = request.getParameter("p_no");
			String name = request.getParameter("emo_name");
			String price = request.getParameter("emo_price");
			String desc = request.getParameter("emo_context");
			String emostyleno = request.getParameter("emo_gruopNo");
			String click = request.getParameter("emo_viewCount");
			//int noStr = Integer.parseInt(no);
			int priceStr = Integer.parseInt(price);
			int gruopStr = Integer.parseInt(emostyleno);
			int viewCountStr = Integer.parseInt(click);
		
			EmoDao emoDao = new EmoDao();
			Emo emoCreate = new Emo(name,priceStr,desc,gruopStr,viewCountStr);
			emoDao.create(emoCreate);
			
			forwardPath = "redirect:emo_main.do";
			}
			
		}catch(Exception e){
			e.printStackTrace();
			forwardPath = "forward:/WEB-INF/view/kakaoerroepage.jsp";
		}
		
		
		return forwardPath;
	}
	
	
}
