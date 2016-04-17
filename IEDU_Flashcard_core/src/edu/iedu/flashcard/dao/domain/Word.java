package edu.iedu.flashcard.dao.domain;

public class Word {
	int id;
	int wordbookid;
	String word;
	String meaning;
	
	public Word(String word, String meaning){
		this.word = word;
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
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getMeaning() {
		return meaning;
	}
	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}
	
	
}
