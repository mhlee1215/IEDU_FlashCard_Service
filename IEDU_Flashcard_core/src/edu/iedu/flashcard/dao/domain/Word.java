package edu.iedu.flashcard.dao.domain;

public class Word {
	int id;
	int wordbookid;
	String name;
	String meaning;
	
	public Word(String name, String meaning){
		this.name = name;
		this.meaning = meaning;
	}
	
	public int getWordbookid() {
		return wordbookid;
	}

	public void setWordbookid(int wordbookid) {
		this.wordbookid = wordbookid;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMeaning() {
		return meaning;
	}
	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}

	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\",\"wordbookid\":\"" + wordbookid + "\",\"name\":\"" + name + "\",\"meaning\":\""
				+ meaning + "\"}";
	}	
	
	
}
