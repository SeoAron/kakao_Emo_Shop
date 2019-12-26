package com.itwill.emo;

import java.util.ArrayList;
import java.util.List;

public class EmoService {
	private EmoDao emoDao;
	public EmoService() throws Exception{
		emoDao = new EmoDao();
	}
	
	
	// 이모티콘 상품 전체 리스트 반환
	public List<Emo> getEmoList() throws Exception {
		return emoDao.getEmoList();
	}
	
	// 이모티콘 번호로 해당 이모티콘 반환
	public Emo getProduct(int p_no) throws Exception {
		return emoDao.getProduct(p_no);
	}
	
	// 이모티콘 번호에 해당하는 이모티콘 조회수 갱신
	public boolean updateReadcount(int p_no) throws Exception {
		return emoDao.updateReadcount(p_no);
	}
	
	// 이모티콘 추가
	public void create(Emo emo) throws Exception {
		emoDao.create(emo);
	}
	
	// 이모티콘 삭제
	public void delete(int p_no) throws Exception {
		emoDao.delete(p_no);
	}
	
	// 이모티콘 수정
	public void update(Emo emo) throws Exception {
		emoDao.update(emo);
	}
	
	// 인자수만큼 인기순으로 이모티콘 반환
	public List<Emo> getEmoListByView(int no) throws Exception {
		return emoDao.getEmoListByView(no);
	}
	
	// 전체스타일 갯수반환
	public int getEmoStyleCount() throws Exception {
		return emoDao.getEmoStyleCount();
	}
	
	// 인자로 받은 번호의 스타일 이름 반환
	public String getStyleNameByNo(int no) throws Exception {
		return emoDao.getStyleNameByNo(no);
	}
	
	// 인자로 받은 스타일에 해당하는 이모티콘 인자로받은 숫자만큼 반환
	public List<Emo> getEmoListByStyleNo(int styleNo, int no) throws Exception {
		return emoDao.getEmoListByStyleNo(styleNo, no);
	}
	// 전체스타일 이름 리스트반환
	public ArrayList<String> getEmoStyleNameList() throws Exception {
		return emoDao.getEmoStyleNameList();
	}
}
