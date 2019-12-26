package com.itwill.member;

public class Member {
/*
 M_NO	NUMBER(10,0)	No		1	회원번호
M_NINAME	VARCHAR2(50 BYTE)	No		2	회원닉네임
M_ID	VARCHAR2(50 BYTE)	No		3	회원아이디
M_PASS	VARCHAR2(50 BYTE)	No		4	회원비밀번호
MD_NO	NUMBER(10,0)	Yes		5	회원상세번호
  
 */
	private int m_no;
	private String m_niname;
	private String m_id;
	private String m_pass;
	private String m_phone;
	private String md_no;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}
	
	public Member(int m_no, String m_niname, String m_id, String m_pass) {
		this.m_no = m_no;
		this.m_niname = m_niname;
		this.m_id = m_id;
		this.m_pass = m_pass;
		
	}
	
	public Member(int m_no, String m_niname, String m_id, String m_pass,String m_phone) {
		this.m_no = m_no;
		this.m_niname = m_niname;
		this.m_id = m_id;
		this.m_pass = m_pass;
		this.m_phone = m_phone;
	}

	public Member(String m_niname, String m_id, String m_pass, String m_phone) {
		this.m_niname = m_niname;
		this.m_id = m_id;
		this.m_pass = m_pass;
		this.m_phone = m_phone;
	}


	public String getM_phone() {
		return m_phone;
	}

	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}

	public int getM_no() {
		return m_no;
	}

	public void setM_no(int m_no) {
		this.m_no = m_no;
	}

	public String getM_niname() {
		return m_niname;
	}

	public void setM_niname(String m_niname) {
		this.m_niname = m_niname;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getM_pass() {
		return m_pass;
	}

	public void setM_pass(String m_pass) {
		this.m_pass = m_pass;
	}

	
	public boolean MatchPass(String m_pass){
		boolean Match=false;
		if(this.m_pass.equals(m_pass)){
			Match=true;
		}
		return Match;
	}

	@Override
	public String toString() {
		return "Member [m_no=" + m_no + ", m_niname=" + m_niname + ", m_id=" + m_id + ", m_pass=" + m_pass
				+ ", m_phone=" + m_phone + ", md_no=" + md_no + "]";
	}
	
	
	
	
	
}
