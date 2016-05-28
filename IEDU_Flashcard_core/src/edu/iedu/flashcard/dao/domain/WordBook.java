package edu.iedu.flashcard.dao.domain;

import java.util.ArrayList;
import java.util.List;

public class WordBook {
	int id;
	String name;
	String author;
	List<Word> wordList;
	
	//for parameter
	int userid;

	public WordBook(){
		
	}
	
	public WordBook(String name){
		this.name = name;
		//this.wordList = new ArrayList<Word>();
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

	public List<Word> getWordList() {
		return wordList;
	}

	public void setWordList(List<Word> wordList) {
		this.wordList = wordList;
	}


	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\",\"name\":\"" + name + "\",\"author\":\"" + author + "\",\"wordList\":\""
				+ wordList + "\",\"userid\":\"" + userid + "\"}";
	}
	
	public String toStringSealize(){
		return "?name="+name+
				"&userid="+userid+
				"&author="+author+
				"&id="+id;
				
	}
	
	
}
