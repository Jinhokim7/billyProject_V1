package com.billy.VO;

public class VillageVO {
	private int vNum;
	private String vTitle;
	private String vText;
	private String vId;
	private String vIndate;
	private int vCnt;
	private String name;
	private String[] files = null;
	private String[] delFiles = null;
	private int reply = 0;
	
	
	public int getReply() {
		return reply;
	}
	public void setReplyCnt(int reply) {
		this.reply = reply;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getDelFiles() {
		return delFiles;
	}
	public void setDelFiles(String[] delFiles) {
		this.delFiles = delFiles;
	}
	public String[] getFiles() {
		return files;
	}
	public void setFiles(String[] files) {
		this.files = files;
	}
	public int getvNum() {
		return vNum;
	}
	public void setvNum(int vNum) {
		this.vNum = vNum;
	}
	public String getvTitle() {
		return vTitle;
	}
	public void setvTitle(String vTitle) {
		this.vTitle = vTitle;
	}
	public String getvText() {
		return vText;
	}
	public void setvText(String vText) {
		this.vText = vText;
	}
	public String getvId() {
		return vId;
	}
	public void setvId(String vId) {
		this.vId = vId;
	}
	public String getvIndate() {
		return vIndate;
	}
	public void setvIndate(String vIndate) {
		this.vIndate = vIndate;
	}
	public int getvCnt() {
		return vCnt;
	}
	public void setvCnt(int vCnt) {
		this.vCnt = vCnt;
	}
	
}
