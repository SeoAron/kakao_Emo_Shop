package com.itwill.emo;

public class Emo {
	private int emo_no; // 이모티콘번호(PK)
	private String emo_name; // 이모티콘이름
	private int emo_price; // 이모티콘가격
	private String emo_context; // 이모티콘설명
	private int emo_gruopNo; // 이모티콘그룹넘버(FK)
	private int emo_viewCount; // 아이템조회수
	
	public Emo() {
		// TODO Auto-generated constructor stub
	}

	public Emo(int emo_no, String emo_name, int emo_price, String emo_context, int emo_gruopNo, int emo_viewCount) {
		super();
		this.emo_no = emo_no;
		this.emo_name = emo_name;
		this.emo_price = emo_price;
		this.emo_context = emo_context;
		this.emo_gruopNo = emo_gruopNo;
		this.emo_viewCount = emo_viewCount;
	}
	
	public Emo(String emo_name, int emo_price, String emo_context, int emo_gruopNo, int emo_viewCount) {
		super();
		
		this.emo_name = emo_name;
		this.emo_price = emo_price;
		this.emo_context = emo_context;
		this.emo_gruopNo = emo_gruopNo;
		this.emo_viewCount = emo_viewCount;
	}

	public int getEmo_no() {
		return emo_no;
	}

	public void setEmo_no(int emo_no) {
		this.emo_no = emo_no;
	}

	public String getEmo_name() {
		return emo_name;
	}

	public void setEmo_name(String emo_name) {
		this.emo_name = emo_name;
	}

	public int getEmo_price() {
		return emo_price;
	}

	public void setEmo_price(int emo_price) {
		this.emo_price = emo_price;
	}

	public String getEmo_context() {
		return emo_context;
	}

	public void setEmo_context(String emo_context) {
		this.emo_context = emo_context;
	}

	public int getEmo_gruopNo() {
		return emo_gruopNo;
	}

	public void setEmo_gruopNo(int emo_gruopNo) {
		this.emo_gruopNo = emo_gruopNo;
	}

	public int getEmo_viewCount() {
		return emo_viewCount;
	}

	public void setEmo_viewCount(int emo_viewCount) {
		this.emo_viewCount = emo_viewCount;
	}

	@Override
	public String toString() {
		return "Emo [emo_no=" + emo_no + ", emo_name=" + emo_name + ", emo_price=" + emo_price + ", emo_context="
				+ emo_context + ", emo_gruopNo=" + emo_gruopNo + ", emo_viewCount=" + emo_viewCount + "]";
	}
	
	
	
	
}
