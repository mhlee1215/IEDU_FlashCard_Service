package edu.iedu.flashcard.dao.domain;

import java.util.List;

public class WordBookBin {
	List<WordBook> wordbooks;

	public List<WordBook> getWordBooks() {
		return wordbooks;
	}

	public void setGameResults(List<WordBook> wordbooks) {
		this.wordbooks = wordbooks;
	}

	@Override
	public String toString() {
		return "{\"wordBooks\":\"" + wordbooks + "\"}";
	}
}
