package com.itwill.notice;

import java.util.ArrayList;

import com.itwill.cart.Cart;
import com.itwill.cart.CartDao;

public class NoticeService {
	
	private NoticeDao noticeDao;
	
	public NoticeService() throws Exception{
		noticeDao = new NoticeDao();
	}
	// 게시글 전체 반환(ArrayList)
		public ArrayList<Notice> getNoticeList() throws Exception {
			return noticeDao.getNoticeList();
		}
	// 게시글 번호 인자로받아 게시글 하나 반환
		public Notice getNotice(int board_no) throws Exception {
			return noticeDao.getNotice(board_no);
		}
	// 게시글 작성(행수 반환)
		public  int createNotice(String board_title,String board_writer,String board_content) throws Exception {
			return noticeDao.createNotice(board_title, board_writer, board_content);
		}
	// 게시글 수정(행수 반환)
		public int updateNotice(int board_no,String board_title,String board_writer,String board_content) throws Exception{
			return noticeDao.updateNotice(board_no, board_title, board_writer, board_content);
		}
	// 게시글 삭제(행수 반환)
		public int deleteNotice(int board_no) throws Exception{
			return noticeDao.deleteNotice(board_no);
		}
}
