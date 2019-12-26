package com.itwill.cart;

public class Cart {
	private int cart_item_no;
	private int m_no;
	private int p_no;
	private String m_niname;
	
	
	public Cart() {
		
	}
	
	public Cart(int cart_item_no, int m_no) {
		super();
		this.cart_item_no = cart_item_no;
		this.m_no = m_no;
	}

	public Cart(int cart_item_no, int m_no, int p_no, String m_niname) {
		super();
		this.cart_item_no = cart_item_no;
		this.m_no = m_no;
		this.p_no = p_no;
		this.m_niname = m_niname;
	}

	public Cart(int m_no, int p_no, String m_niname) {
		super();
		this.m_no = m_no;
		this.p_no = p_no;
		this.m_niname = m_niname;
	}
	
	public int getCart_item_no() {
		return cart_item_no;
	}


	public void setCart_item_no(int cart_item_no) {
		this.cart_item_no = cart_item_no;
	}


	public int getM_no() {
		return m_no;
	}


	public void setM_no(int m_no) {
		this.m_no = m_no;
	}


	public int getP_no() {
		return p_no;
	}


	public void setP_no(int p_no) {
		this.p_no = p_no;
	}


	public String getM_niname() {
		return m_niname;
	}


	public void setM_niname(String m_niname) {
		this.m_niname = m_niname;
	}

	
	@Override
	public String toString() {
		return "Cart [cart_item_no=" + cart_item_no + ", m_no=" + m_no + ", p_no=" + p_no + ", m_niname=" + m_niname
				+ "]";
	}

	 
	
	
	
	
		
}
