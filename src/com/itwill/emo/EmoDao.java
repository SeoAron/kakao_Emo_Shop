package com.itwill.emo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;


public class EmoDao {
	
	private DataSource dataSource;

	public EmoDao() throws Exception {
		InitialContext ic = new InitialContext();
		dataSource = (DataSource) ic.lookup("java:/comp/env/jdbc/OracleDB");
	}
	
	
	// 이모티콘 상품 전체 리스트 반환
	public List<Emo> getEmoList() throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Emo> emoList = null;

		try {
			con = dataSource.getConnection();
			String sql = "select * from p_emo";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			emoList = new ArrayList<Emo>();
			Emo emo = null;
			while (rs.next()) {
				emo = new Emo();
				emo.setEmo_no(rs.getInt("p_no"));
				emo.setEmo_name(rs.getString("p_name"));
				emo.setEmo_price(rs.getInt("p_price"));
				emo.setEmo_context(rs.getString("p_desc"));
				emo.setEmo_gruopNo(rs.getInt("p_emostyleno"));
				emo.setEmo_viewCount(rs.getInt("p_click"));
				
				emoList.add(emo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return emoList;
	}
	
	
	// 이모티콘 번호로 해당 이모티콘 반환
	public Emo getProduct(int p_no) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Emo emo = null;

		try {
			con = dataSource.getConnection();
			String sql = "select * from p_emo where p_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, p_no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				emo = new Emo();
				emo.setEmo_no(rs.getInt("p_no"));
				emo.setEmo_name(rs.getString("p_name"));
				emo.setEmo_price(rs.getInt("p_price"));
				emo.setEmo_context(rs.getString("p_desc"));
				emo.setEmo_gruopNo(rs.getInt("p_emostyleno"));
				emo.setEmo_viewCount(rs.getInt("p_click"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();

		}
		return emo;
	}
	
	
	// 이모티콘 번호에 해당하는 이모티콘 조회수 갱신
	public boolean updateReadcount(int p_no) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean result = false;

		try {
			con = dataSource.getConnection();
			String sql = "update p_emo set p_click = p_click+1 where p_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, p_no);
			int count = pstmt.executeUpdate();

			if (count > 0) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();

		}
		return result;
	}
	
	// 이모티콘 추가
	public void create(Emo emo) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = dataSource.getConnection();
			String sql = "insert into p_emo values(P_EMO_P_NO_SEQ.nextval,?,?,?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, emo.getEmo_name());
			pstmt.setInt(2, emo.getEmo_price());
			pstmt.setString(3, emo.getEmo_context());
			pstmt.setInt(4, emo.getEmo_gruopNo());
			pstmt.setInt(5, emo.getEmo_viewCount());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
	}
	
	
	// 이모티콘 삭제
	public void delete(int p_no) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = dataSource.getConnection();
			String sql = "delete from p_emo where p_no = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, p_no);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
	}
	
	
	// 이모티콘 수정
	public void update(Emo emo) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = dataSource.getConnection();
			String sql = "update p_emo set p_name = ?, p_price = ?, p_desc = ?, p_emostyleno = ?, p_click = ? where p_no = ? ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, emo.getEmo_name());
			pstmt.setInt(2, emo.getEmo_price());
			pstmt.setString(3, emo.getEmo_context());
			pstmt.setInt(4, emo.getEmo_gruopNo());
			pstmt.setInt(5, emo.getEmo_viewCount());
			pstmt.setInt(6, emo.getEmo_no());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
	}
	

	
	// 인자수만큼 인기순으로 이모티콘 반환
	public List<Emo> getEmoListByView(int no) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Emo> emoList = null;
		
		try {
			con = dataSource.getConnection();
			String sql = "select * from(select * from p_emo order by p_click desc) where rownum >= 1 and rownum <= ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			
			emoList = new ArrayList<Emo>();
			Emo emo = null;
			
			while (rs.next()) {
				emo = new Emo();
				emo.setEmo_no(rs.getInt("p_no"));
				emo.setEmo_name(rs.getString("p_name"));
				emo.setEmo_price(rs.getInt("p_price"));
				emo.setEmo_context(rs.getString("p_desc"));
				emo.setEmo_gruopNo(rs.getInt("p_emostyleno"));
				emo.setEmo_viewCount(rs.getInt("p_click"));
				
				emoList.add(emo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return emoList;
	}
	
	
	// 전체스타일 갯수반환
	public int getEmoStyleCount() throws Exception {
		int count = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			String sql = "select count(*) from p_emostyle";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		
		return count;
	}
	
	// 전체스타일 이름 리스트반환
	public ArrayList<String> getEmoStyleNameList() throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<String> styleNameList = new ArrayList<String>();
		
		try {
			con = dataSource.getConnection();
			String sql = "select p_emostyle from p_emostyle";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				styleNameList.add(rs.getString("p_emostyle"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		
		return styleNameList;
	}
	
	
	// 인자로 받은 번호의 스타일 이름 반환
	public String getStyleNameByNo(int no) throws Exception {
		String styleName = "";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			String sql = "select p_emostyle from p_emostyle where p_emostyleno = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				styleName = rs.getString(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		
		return styleName;
	}
	
	
	// 인자로 받은 스타일에 해당하는 이모티콘 인자로받은 숫자만큼 반환
	public List<Emo> getEmoListByStyleNo(int styleNo, int no) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Emo> emoList = null;
		
		try {
			con = dataSource.getConnection();
			String sql = "select * from p_emo where p_emostyleno = ? and rownum >= 1 and rownum <= ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, styleNo);
			pstmt.setInt(2, no);
			
			rs = pstmt.executeQuery();
			
			emoList = new ArrayList<Emo>();
			Emo emo = null;
			
			while (rs.next()) {
				emo = new Emo();
				emo.setEmo_no(rs.getInt("p_no"));
				emo.setEmo_name(rs.getString("p_name"));
				emo.setEmo_price(rs.getInt("p_price"));
				emo.setEmo_context(rs.getString("p_desc"));
				emo.setEmo_gruopNo(rs.getInt("p_emostyleno"));
				emo.setEmo_viewCount(rs.getInt("p_click"));
				
				emoList.add(emo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return emoList;
		
	}
	
	
	
	
}
