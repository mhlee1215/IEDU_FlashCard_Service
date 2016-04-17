package edu.iedu.flashcard.dao.domain;

public class User2WordBook {
	int userid;
	int wordbookid;
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getWordbookid() {
		return wordbookid;
	}
	public void setWordbookid(int wordbookid) {
		this.wordbookid = wordbookid;
	}
	@Override
	public String toString() {
		return "{\"userid\":\"" + userid + "\",\"wordbookid\":\"" + wordbookid + "\"}";
	}
}
