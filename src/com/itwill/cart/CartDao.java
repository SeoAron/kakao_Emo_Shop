package com.itwill.cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;


public class CartDao {
	private DataSource dataSource;
	public CartDao() throws Exception {
		InitialContext ic=new InitialContext();
		dataSource=(DataSource)ic.lookup("java:/comp/env/jdbc/OracleDB");
	}
	
	// 회원 번호 , 이모티콘상품 번호 인자로 받아 해당 회원 카트에 해당이모티콘 존재여부 반환 (존재true, 없음false)
	public  boolean isProductExist(int m_no,int p_no) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean isExist=false;
		String selectQuery = "select count(*) as p_count from cart c join member m on c.m_no = m.m_no join p_emo p on c.p_no=p.p_no where m.m_no=? and c.p_no=?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(selectQuery);
			pstmt.setInt(1,m_no);
			pstmt.setInt(2,p_no);
			rs = pstmt.executeQuery();
			int count=0;
			if (rs.next()) {
				count=rs.getInt(1);
			}
			if(count==0) {
				isExist=false;
			}else {
				isExist=true;
			}
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
		return isExist;
	}
	
	
	// 카트 객체받아 db에 추가
	public  int add(Cart cart) throws Exception {
			Connection con = null;
			PreparedStatement pstmt = null;
			String insertQuery = "INSERT INTO cart VALUES (cart_cart_item_no_SEQ.nextval, ?, ?, ?)";
			try {
				con = dataSource.getConnection();
				pstmt = con.prepareStatement(insertQuery);
				pstmt.setInt(1, cart.getM_no());
				pstmt.setInt(2, cart.getP_no());
				pstmt.setString(3, cart.getM_niname());
				int rows = pstmt.executeUpdate();
				return rows;
			} finally {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			}
	}
	
	
	// 회원번호 인자로 받아 해당회원 카트 리스트 반환
	public  ArrayList<Cart> getCartItemList(int m_no) throws Exception{
		ArrayList<Cart> cartItemList= new ArrayList<Cart>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		/*
		select c.p_no,c.cart_qty,c.cart_tot_price ,p.p_name,p.p_price 
		from cart1 c join user1 u 
		on c.userid = u.userid join product1 p on c.p_no=p.p_no where u.userid='guard1';
		 */
		String selectQuery = "select c.cart_item_no, c.m_no, c.p_no, c.m_niname from cart c join member m on c.m_no = m.m_no join p_emo p on c.p_no=p.p_no where m.m_no=?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(selectQuery);
			pstmt.setInt(1, m_no);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				cartItemList.add(new Cart(
						rs.getInt("c.cart_item_no"),
						rs.getInt("m_no"),
						rs.getInt("p_no"),
						rs.getString("c.m_niname")
						));
			}
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
		return cartItemList;
		
	}
	
	// 회원번호 인자로받아 카트에 담은 이모티콘번호 리스트반환
	public  ArrayList<Integer> getCartEmoNoList(int m_no) throws Exception{
		ArrayList<Integer> cartEmoNoList= new ArrayList<Integer>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		/*
		select c.p_no,c.cart_qty,c.cart_tot_price ,p.p_name,p.p_price 
		from cart1 c join user1 u 
		on c.userid = u.userid join product1 p on c.p_no=p.p_no where u.userid='guard1';
		 */
		String selectQuery = "select c.p_no from cart c join member m on c.m_no = m.m_no join p_emo p on c.p_no=p.p_no where m.m_no=?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(selectQuery);
			pstmt.setInt(1, m_no);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				cartEmoNoList.add(rs.getInt("p_no"));
			}
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
		return cartEmoNoList;
		
	}
	
	// 카트번호 인자로받아 해당 카트 삭제 (업데이트행수 반환)
	public  int deleteCartItem(int cart_item_no) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		String removeQuery = "delete from cart where cart_item_no = ?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(removeQuery);
			pstmt.setInt(1, cart_item_no);
			int rows = pstmt.executeUpdate();
			return rows;
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
	}

	
	// 회원번호 인자로 받아 해당 카트 삭제 (업데이트행수 반환)
	public  int deleteCart(int m_no) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		String removeQuery = "delete from cart where m_no=?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(removeQuery);
			pstmt.setInt(1, m_no);
			int rows = pstmt.executeUpdate();
			return rows;
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
	}
	
	// 회원번호 이모티콘번호 인자로받아서 해당하는 카트삭제
	public  int deleteUserCart(int m_no, int p_no) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		String removeQuery = "delete from cart where m_no=? and p_no =?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(removeQuery);
			pstmt.setInt(1, m_no);
			pstmt.setInt(2, p_no);
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
