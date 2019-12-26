package com.itwill.jumun;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JumunDao {
	private DataSource dataSource;

	public JumunDao() throws Exception {
		InitialContext ic = new InitialContext();
		dataSource = (DataSource) ic.lookup("java:/comp/env/jdbc/OracleDB");
	}

	// 회원 번호 인자로 받아서 주문상세정보,총가격 INSERT (추가행수반환)
	public int add(int m_no) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		String insertQuery = "INSERT INTO jumun VALUES "
				+ "(JUMUN_J_NO_SEQ.nextval, sysdate,(select p.p_name||'외 '||(select count(m_no)-1 from cart where m_no =?)||'건' "
				+ "from cart c join p_emo p on p.p_no = c.p_no where m_no = ? and rownum =1),"
				+ "(select sum(p.p_price) from cart c join p_emo p on c.p_no = p.p_no where m_no=?),?)";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(insertQuery);
			pstmt.setInt(1, m_no);
			pstmt.setInt(2, m_no);
			pstmt.setInt(3, m_no);
			pstmt.setInt(4, m_no);
			int rows = pstmt.executeUpdate();
			return rows;
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
	}

	// 주문 취소시 주문번호 인자로 받아서 해당 주문 DELETE (삭제행수반환)
	public int deleteJumun(int j_no) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;

		String removeQuery = "delete from jumun where j_no = ?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(removeQuery);
			pstmt.setInt(1, j_no);
			int rows = pstmt.executeUpdate();
			return rows;
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
	}

	// 회원번호 인자로 받아서 주문 리스트 최근 한개 반환
	public Jumun getJumun(int m_no) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Jumun jumun = null;

		try {
			con = dataSource.getConnection();
			String sql = "select * from (select * from jumun where m_no=?  order by j_no desc) where rownum=1";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, m_no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				jumun = new Jumun();
				jumun.setJ_no(rs.getInt("j_no"));
				jumun.setJ_date(rs.getDate("j_date"));
				jumun.setJ_desc(rs.getString("j_desc"));
				jumun.setJ_price(rs.getInt("j_price"));
				jumun.setM_no(rs.getInt("m_no"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) con.close();
			if (pstmt != null)
				pstmt.close();

		}
		return jumun;
	}
	
	// 주문페이지로 이동시 멤버번호 받아와서 주문디테일에 카트보유이모티콘 INSERT
	public void addDetailEmoList(int m_no) throws Exception {
		int jumunCount = 0;
		Connection con = null;
		PreparedStatement pstmt = null;

		ResultSet rs = null;

		try {
			con = dataSource.getConnection();
			String sql = "select count(*) from cart where m_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, m_no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				jumunCount = rs.getInt(1);
			}

			pstmt.close();

			String insertQuery = "INSERT INTO jumun_detail VALUES (JUMUN_DETAIL_JD_NO_SEQ.nextval,"
					+ "(select jnom from (select rownum r, j_no jnom from jumun where m_no=? order by j_no desc) x where r=1),"
					+ "(select emoname from (select rownum r ,p.p_name emoname from cart c "
					+ "join p_emo p on p.p_no = c.p_no where c.m_no= ?) x where r=?),"
					+ "(select emoprice from (select rownum r, p.p_price emoprice from cart c "
					+ "join p_emo p on p.p_no = c.p_no where c.m_no= ?) x where r=?))";
			pstmt = con.prepareStatement(insertQuery);
			for (int i = 0; i < jumunCount; i++) {
				pstmt.setInt(1, m_no);
				pstmt.setInt(2, m_no);
				pstmt.setInt(3, i);
				pstmt.setInt(4, m_no);
				pstmt.setInt(5, i);
				pstmt.executeUpdate();
				pstmt.clearParameters();
				// int rows = pstmt.executeUpdate();
				// return rows;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			pstmt.close();
			con.close();
		}
	}

	// ~외 몇건 눌렀을때 띄울 주문 상세 리스트 반환(회원번호 인자로 받는다.)
	public ArrayList<JumunDetail> getDetailEmoList(int j_no) throws Exception {
		ArrayList<JumunDetail> jumunDetailEmoList = new ArrayList<JumunDetail>();
		jumunDetailEmoList = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String selectQuery = "select * from jumun_detail where j_no = ?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(selectQuery);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				jumunDetailEmoList.add(new JumunDetail(rs.getInt("jd_no"), rs.getInt("j_no"), rs.getString("jd_emoname"),
						rs.getInt("jd_emoprice")));
			}
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
		return jumunDetailEmoList;

	}
	
	// 회원 이모티콘 보유리스트 INSERT
	public void addMemberEmoList(int m_no) throws Exception {
		int jumunCount = 0;
		Connection con = null;
		PreparedStatement pstmt = null;

		ResultSet rs = null;

		try {
			con = dataSource.getConnection();
			String sql = "select count(*) from cart where m_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, m_no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				jumunCount = rs.getInt(1);
			}

			pstmt.close();

			String insertQuery = "INSERT INTO md_emolist VALUES (MD_EMOLIST_M_OWNEMO_SEQ.nextval,"
					+ "(select p_no from(select rownum r1, p_no from cart where m_no = ?) where r1=?),"
					+ "(select m_no from(select rownum r2, m_no from cart where m_no = ?) where r2=?))";
			pstmt = con.prepareStatement(insertQuery);
			for (int i = 0; i < jumunCount; i++) {
				pstmt.setInt(1, m_no);
				pstmt.setInt(2, i);
				pstmt.setInt(3, m_no);
				pstmt.setInt(4, i);
				pstmt.executeUpdate();
				pstmt.clearParameters();
				// int rows = pstmt.executeUpdate();
				// return rows;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			pstmt.close();
			con.close();
		}
	}
	/*
	 * //주문form에 보여줄 cart이모티콘 리스트(회원번호 인자로 받는다.) //select p_name,p_price from
	 * (select p_no from cart where m_no = ?) c join p_emo p on c.p_no = p.p_no;
	 * 
	 * public ArrayList<JumunDetail> getJumunEmoList(int m_no) throws Exception {
	 * ArrayList<JumunDetail> jumunEmoList = new ArrayList<JumunDetail>();
	 * jumunEmoList = null; Connection con = null; PreparedStatement pstmt = null;
	 * ResultSet rs = null;
	 * 
	 * String selectQuery =
	 * "select p_name,p_price from (select p_no from cart where m_no = 3) c join p_emo p on c.p_no = p.p_no"
	 * ; try { con = dataSource.getConnection(); pstmt =
	 * con.prepareStatement(selectQuery); rs = pstmt.executeQuery(); while
	 * (rs.next()) { jumunEmoList.add(new JumunDetail(rs.getString("jd_emoname"),
	 * rs.getInt("jd_emoprice"))); } } finally { if (rs != null) rs.close(); if
	 * (pstmt != null) pstmt.close(); if (con != null) con.close(); } return
	 * jumunEmoList;
	 * 
	 * }
	 */
	
	
	
	
	
	
	
	
}
