package com.javaex.vo;

public class AuthorVo {

	private String authorName;
	private String authorDesc;
	private int authorid;
	
	
	
	public AuthorVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AuthorVo(String authorName, String authorDesc) {
		super();
		
		this.authorName = authorName;
		this.authorDesc = authorDesc;
	}
	public AuthorVo(int authorid,String authorName, String authorDesc) {
		super();
		this.authorid = authorid;
		this.authorName = authorName;
		this.authorDesc = authorDesc;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getAuthorDesc() {
		return authorDesc;
	}
	public void setAuthorDesc(String authorDesc) {
		this.authorDesc = authorDesc;
	}
	
	public String toString() {
		return "AuthorVo [authorName=" + authorName + ", authorDesc="+ authorDesc+"]";
	}
	public int getAuthorid() {
		return authorid;
	}
	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}
	
	
}
