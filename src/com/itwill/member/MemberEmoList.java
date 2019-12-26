package com.itwill.member;

public class MemberEmoList {
	private String p_name;
	private int p_price;
	
	public MemberEmoList() {
		// TODO Auto-generated constructor stub
	}

	public MemberEmoList(String p_name, int p_price) {
		super();
		this.p_name = p_name;
		this.p_price = p_price;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public int getP_price() {
		return p_price;
	}

	public void setP_price(int p_price) {
		this.p_price = p_price;
	}

	@Override
	public String toString() {
		return "MemberEmoList [p_name=" + p_name + ", p_price=" + p_price + "]";
	}
	
	
}
