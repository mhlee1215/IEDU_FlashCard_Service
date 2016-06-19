package edu.iedu.flashcard.dao.domain;

import java.util.ArrayList;
import java.util.List;

public class WordBook {
	
	static final String WORDBOOK_DELIMTETER = "///";
	
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
		String rtnStr = "{\"id\":\"" + id + "\",\"name\":\"" + name + "\",\"author\":\"" + author + "\",\"wordList\":";
		if(wordList == null) rtnStr += "[]";
		else rtnStr += wordList;
		rtnStr += ",\"userid\":\"" + userid + "\"}";
		return rtnStr;
		//return "{\"id\":\"" + id + "\",\"name\":\"" + name + "\",\"author\":\"" + author + "\",\"wordList\":"
		//		+ wordList + ",\"userid\":\"" + userid + "\"}";
	}
	
	public String toStringSealize(){
		return "?name="+name+
				"&userid="+userid+
				"&author="+author+
				"&id="+id;
	
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	
}
