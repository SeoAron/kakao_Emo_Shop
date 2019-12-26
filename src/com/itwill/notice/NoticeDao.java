package com.itwill.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.itwill.cart.Cart;
import com.itwill.emo.Emo;

public class NoticeDao {
	private DataSource dataSource;
	public NoticeDao() throws Exception {
		InitialContext ic=new InitialContext();
		dataSource=(DataSource)ic.lookup("java:/comp/env/jdbc/OracleDB");
	}
	
	// 게시글 전체 리스트 반환
	
	public ArrayList<Notice> getNoticeList() throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Notice> noticeList = new ArrayList<Notice>();
		
		try {
			con = dataSource.getConnection();
			String sql = "select * from board";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			Notice notice = null;
			while (rs.next()) {
				notice = new Notice();
				notice.setBoard_no(rs.getInt("board_no"));
				notice.setBoard_title(rs.getString("board_title"));
				notice.setBoard_writer(rs.getString("board_writer"));
				notice.setBoard_content(rs.getString("board_content"));
				
				noticeList.add(notice);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();
			if (pstmt != null)
				pstmt.close();
		}
		
		return noticeList;
	}
	// 게시글 번호를 인자로받아 게시글 하나 반환
	public Notice getNotice(int board_no) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Notice notice = new Notice();
		notice = null;

		try {
			con = dataSource.getConnection();
			String sql = "select * from board where board_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				notice = new Notice();
				notice.setBoard_no(rs.getInt("board_no"));
				notice.setBoard_title(rs.getString("board_title"));
				notice.setBoard_writer(rs.getString("board_writer"));
				notice.setBoard_content(rs.getString("board_content"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();

		}
		return notice;
	}
	// 게시글 작성(행수 반환)
	public int createNotice(String board_title,String board_writer,String board_content) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		String insertQuery = "INSERT INTO board VALUES (BOARD_BOARD_NO_SEQ.nextval, ?, ?, ?)";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(insertQuery);
			pstmt.setString(1, board_title);
			pstmt.setString(2, board_writer);
			pstmt.setString(3, board_content);
			int rows = pstmt.executeUpdate();
			return rows;
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
}
	// 게시글 수정(행수 반환)
	public int updateNotice(int board_no,String board_title,String board_writer,String board_content) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		String updateQuery = "UPDATE board SET board_title = ?,board_writer = ?,board_content = ? where board_no = ?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(updateQuery);
			pstmt.setString(1, board_title);
			pstmt.setString(2, board_writer);
			pstmt.setString(3, board_content);
			pstmt.setInt(4, board_no);
			int rows = pstmt.executeUpdate();
			return rows;
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
	}
	// 게시글 삭제(행수 반환)
	public int deleteNotice(int board_no) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		String deleteQuery = "DELETE FROM board WHERE board_no = ?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(deleteQuery);
			pstmt.setInt(1, board_no);
			int rows = pstmt.executeUpdate();
			return rows;
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
	}
}
