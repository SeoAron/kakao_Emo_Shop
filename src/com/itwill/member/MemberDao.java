package com.itwill.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.itwill.emo.Emo;

public class MemberDao {
	private DataSource dataSource;
	
	public MemberDao() throws Exception {
		InitialContext ic = new InitialContext();
		dataSource = (DataSource)ic.lookup("java:/comp/env/jdbc/OracleDB");
		
	}
	
	public boolean create(Member member) throws Exception{
		boolean createOk = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			String Sql = "insert into MEMBER(M_NO,M_NINAME,M_ID,M_PASS,M_PHONE)"+ 
					"values(MEMBER_M_NO_SEQ.nextval,?,?,?,?)";
			pstmt = con.prepareStatement(Sql);
			pstmt.setString(1,member.getM_niname());
			pstmt.setString(2,member.getM_id());
			pstmt.setString(3,member.getM_pass());
			pstmt.setString(4,member.getM_phone());
			int insertRowCount = pstmt.executeUpdate();
			if (insertRowCount == 1) {
				createOk = true;
		}
		}catch (Exception e) {
			createOk = false;
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
		return createOk;
	}
	
	//delete from MEMBER where M_ID=?;
	public int remove(String m_id) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		String Sql ="delete from MEMBER where M_ID=?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(Sql);
			pstmt.setString(1, m_id);
			int row = pstmt.executeUpdate();
			return row;
			
			
			
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
	}
	
	
	
	public int update(Member member) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		String Sql = "UPDATE member set M_NINAME=?,M_PASS=?,M_PHONE =? WHERE M_ID = ?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(Sql);
			pstmt.setString(1,member.getM_niname());
			pstmt.setString(2,member.getM_pass());
			pstmt.setString(3,member.getM_phone());
			pstmt.setString(4,member.getM_id());
			int rows = pstmt.executeUpdate();
			return rows;
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
	}
	

	public Member findMember(String m_id) throws Exception {
		Member Member = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String selectQuery = "select m_no,m_niname,m_id,m_pass,m_phone from member where m_id = ?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(selectQuery);
			pstmt.setString(1, m_id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				Member = new Member(rs.getInt("m_no"),
						rs.getString("m_niname"),
						rs.getString("m_id"),
						rs.getString("m_pass"),
						rs.getString("m_phone"));
			}
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
		return Member;
	}
	
	
	public ArrayList<Member> selectAll() throws Exception {
		ArrayList<Member> memberList = new ArrayList<Member>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String Sql = "select * from member";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(Sql);
			rs = pstmt.executeQuery();
	
			while (rs.next()) {
				memberList.add(new Member( rs.getInt("m_no"),
						rs.getString("m_niname"),
						rs.getString("m_id"),
						rs.getString("m_pass"),
						rs.getString("m_phone")));
			}
			
		}finally{
			/*
			 * 반드시실행하는블록
			 *   1. return전에 반드시실행 
			 *   2. 예외던지기전에 실행
			 */
			if(rs!=null)
				rs.close();
			if(pstmt!=null)
				pstmt.close();
			if(con!=null)
				con.close();
		}
		return memberList;
		
	}
	
	
	
	// 회원의 이모티콘 보유 리스트
	/*
	 * select 이번놈이가진이모티콘,가진이모티콘이름 
	   from (select rownum r, md.m_no 이번놈이가진이모티콘 ,p.p_name 가진이모티콘이름 from md_emolist md
	   join p_emo p on p.p_no = md.p_no where md.m_no= 2) x where r=3;
	 */
	public ArrayList<MemberEmoList> emoAllList(int m_no) throws Exception {
		ArrayList<MemberEmoList> memberEmoLists = new ArrayList<MemberEmoList>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		memberEmoLists = null;
		
		String Sql = "select p.p_name, p.p_price from md_emolist md join p_emo p on p.p_no = md.p_no where md.m_no= ?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(Sql);
			pstmt.setInt(1, m_no);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				memberEmoLists.add(new MemberEmoList( 
						rs.getString("p_name"),
						rs.getInt("p_price")
						));
			}
			
		}finally{
			
			if(rs!=null)
				rs.close();
			if(pstmt!=null)
				pstmt.close();
			if(con!=null)
				con.close();
		}
		return memberEmoLists;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
