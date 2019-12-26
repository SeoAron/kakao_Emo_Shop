package com.itwill.jumun;

public class JumunDetail {
	private int jd_no;
	private int j_no;
	private String jd_emoname;
	private int jd_emoprice;
	
	public JumunDetail() {
		
	}
	
	
	
	
	public JumunDetail(int jd_no, int j_no, String jd_emoname, int jd_emoprice) {
		super();
		this.jd_no = jd_no;
		this.j_no = j_no;
		this.jd_emoname = jd_emoname;
		this.jd_emoprice = jd_emoprice;
	}
	public JumunDetail(String jd_emoname, int jd_emoprice) {
		super();
		this.jd_emoname = jd_emoname;
		this.jd_emoprice = jd_emoprice;
	}




	public int getJd_no() {
		return jd_no;
	}
	public void setJd_no(int jd_no) {
		this.jd_no = jd_no;
	}
	public int getJ_no() {
		return j_no;
	}
	public void setJ_no(int j_no) {
		this.j_no = j_no;
	}
	public String getJd_emoname() {
		return jd_emoname;
	}
	public void setJd_emoname(String jd_emoname) {
		this.jd_emoname = jd_emoname;
	}
	public int getJd_emoprice() {
		return jd_emoprice;
	}
	public void setJd_emoprice(int jd_emoprice) {
		this.jd_emoprice = jd_emoprice;
	}
	
	
	@Override
	public String toString() {
		return "JumunDetail [jd_no=" + jd_no + ", j_no=" + j_no + ", jd_emoname=" + jd_emoname + ", jd_emoprice="
				+ jd_emoprice + "]";
	}
	
	
	
}
