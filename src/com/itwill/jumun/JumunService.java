package com.itwill.jumun;

import java.util.ArrayList;

public class JumunService {
	private JumunDao jumunDao;
	
	public JumunService() throws Exception {
		jumunDao = new JumunDao();
	}
	
	// 회원 번호 인자로 받아서 주문상세정보,총가격 INSERT (추가행수반환)
	public int add(int m_no) throws Exception {
		return jumunDao.add(m_no);
	}
	
	// 주문 취소시 주문번호 인자로 받아서 해당 주문 DELETE (삭제행수반환)
	public int deleteJumun(int j_no) throws Exception {
		return jumunDao.deleteJumun(j_no);
	}
	
	// 회원번호 인자로 받아서 주문 리스트 최근 한개 반환
	public Jumun getJumun(int m_no) throws Exception {
		return jumunDao.getJumun(m_no);
	}
	
	// 주문페이지로 이동시 멤버번호 받아와서 주문디테일에 카트보유이모티콘 INSERT
	public void addDetailEmoList(int m_no) throws Exception {
		jumunDao.addDetailEmoList(m_no);
	}
	
	// ~외 몇건 눌렀을때 띄울 주문 상세 리스트 반환(회원번호 인자로 받는다.)
	public ArrayList<JumunDetail> getDetailEmoList(int j_no) throws Exception {
		return jumunDao.getDetailEmoList(j_no);
	}
	
	// 회원 이모티콘 보유리스트 INSERT
	public void addMemberEmoList(int m_no) throws Exception {
		jumunDao.addMemberEmoList(m_no);
	}
	
	
	
}
