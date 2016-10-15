package edu.iedu.flashcard.dao.domain;

public class Word {
	int id;
	int wordbookid;
	String name;
	String meaning;
	String isfavorite;
	int position;
	
	public Word(){
		this.id = 0;
		this.name = "";
		this.meaning = "";
	}
	
	public Word(String name, String meaning){
		this(name, meaning, 0);
	}
	
	public Word(String name, String meaning, int position){
		this.name = name;
		this.meaning = meaning;
		this.position = position;
	}
	
	
	public String getIsfavorite() {
		return isfavorite;
	}

	public void setIsfavorite(String isfavorite) {
		this.isfavorite = isfavorite;
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
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	
	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\",\"wordbookid\":\"" + wordbookid + "\",\"name\":\"" + name.replace("\"", "\\\"") + "\",\"meaning\":\""
				+ meaning.replace("\"", "\\\"") + "\",\"isfavorite\":\"" + isfavorite + "\"}";
	}	
}
