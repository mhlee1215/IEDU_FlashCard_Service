package edu.iedu.flashcard.dao.domain;

import java.util.List;

public class WordBook {
	String name;
	List<Word> wordList;

	public WordBook(String name){
		this.name = name;
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
}
