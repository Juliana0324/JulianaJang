package com.spring.basic.ex02;

public class MemberDAO {
	private DataBaseInfo dbInfo;
	public void setDbInfo(DataBaseInfo dbInfo) {
		this.dbInfo = dbInfo;
	}
	public void showDbInfo() {
		System.out.println("URL: "+dbInfo.getUrl());
		System.out.println("Uid: "+dbInfo.getUid());
		System.out.println("Upw: "+dbInfo.getUpw());
	}
}
