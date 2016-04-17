package edu.iedu.flashcard.dao.domain;

import java.util.List;

public class WordBin {
	List<Word> words;

	public List<Word> getWords() {
		return words;
	}

	public void setGameResults(List<Word> words) {
		this.words = words;
	}

	@Override
	public String toString() {
		return "{\"ords\":\"" + words + "\"}";
	}
}

