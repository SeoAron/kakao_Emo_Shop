package com.itwill.jumun;

import java.sql.Date;

/*
 J_NO	NUMBER(10,0)	No		1	주문번호
 J_DATE	DATE	Yes	"sysdate		 "	2	주문날짜
 J_DESC	VARCHAR2(50 BYTE)	Yes		3	주문설명
 J_PRICE	NUMBER(10,0)	Yes		4	주문총가격
 M_NO	NUMBER(10,0)	Yes		5	회원번호
 */
public class Jumun {
	private int j_no;
	private Date j_date;
	private String j_desc;
	private int j_price;
	private int m_no;
	
	public Jumun() {
		
	}

	public Jumun(int j_no, Date j_date, String j_desc, int j_price, int m_no) {
		super();
		this.j_no = j_no;
		this.j_date = j_date;
		this.j_desc = j_desc;
		this.j_price = j_price;
		this.m_no = m_no;
	}

	public int getJ_no() {
		return j_no;
	}

	public void setJ_no(int j_no) {
		this.j_no = j_no;
	}

	public Date getJ_date() {
		return j_date;
	}

	public void setJ_date(Date j_date) {
		this.j_date = j_date;
	}

	public String getJ_desc() {
		return j_desc;
	}

	public void setJ_desc(String j_desc) {
		this.j_desc = j_desc;
	}

	public int getJ_price() {
		return j_price;
	}

	public void setJ_price(int j_price) {
		this.j_price = j_price;
	}

	public int getM_no() {
		return m_no;
	}

	public void setM_no(int m_no) {
		this.m_no = m_no;
	}

	
	

	
}
