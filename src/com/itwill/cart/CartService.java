package com.itwill.cart;

import java.util.ArrayList;

public class CartService {
	ArrayList<Integer> bLoginCart = null;
	private CartDao cartDao;
	
	public CartService() throws Exception {
		cartDao = new CartDao();
		bLoginCart = new ArrayList<Integer>();
	}
	
	// 회원 번호 , 이모티콘상품 번호 인자로 받아 해당 회원 카트에 해당이모티콘 존재여부 반환 (존재true, 없음false)
	public boolean isProductExist(int m_no,int p_no) throws Exception {
		return cartDao.isProductExist(m_no, p_no);
	}
	
	// 카트 객체받아 db에 추가
	public int add(Cart cart) throws Exception {
		return cartDao.add(cart);
	}
	
	// 회원번호 인자로 받아 해당회원 카트 리스트 반환
	public ArrayList<Cart> getCartItemList(int m_no) throws Exception{
		return cartDao.getCartItemList(m_no);
	}
	
	// 회원번호 인자로받아 카트에 담은 이모티콘번호 리스트반환
	public  ArrayList<Integer> getCartEmoNoList(int m_no) throws Exception{
		return cartDao.getCartEmoNoList(m_no);
	}
	
	// 카트번호 인자로받아 해당 카트 삭제 (업데이트행수 반환)
	public int deleteCartItem(int cart_item_no) throws Exception{
		return cartDao.deleteCartItem(cart_item_no);
	}
	
	// 회원번호 인자로 받아 해당 카트 삭제 (업데이트행수 반환)
	public int deleteCart(int m_no) throws Exception{
		return cartDao.deleteCart(m_no);
	}
	
	
	
	//비회원 카트에 상품번호 저장
	public void bLoginCartAdd(int p_no) {
		bLoginCart.add(p_no);
	}
	
	
	//비회원 카트 상품번호 한개 지우기
	public void bLoginCartDelete(int p_no) {
		for (int i = 0; i < bLoginCart.size(); i++) {
			if (bLoginCart.get(i) == p_no) {
				bLoginCart.remove(i);
				return;
			}
		}
	}
	
	//비회원 카트 비우기
	public void bLoginCartClear() {
		bLoginCart.clear();
	}
	
	
	// 회원번호 이모티콘번호 인자로받아서 해당하는 카트삭제
	public void deleteUserCart(int m_no, int p_no) throws Exception{
		cartDao.deleteUserCart(m_no, p_no);
	}
	
	//비회원 카트 전체제품번호리스트 반환
	public ArrayList<Integer> bLoginGetCartList() {
		return bLoginCart;
	}
	
}
