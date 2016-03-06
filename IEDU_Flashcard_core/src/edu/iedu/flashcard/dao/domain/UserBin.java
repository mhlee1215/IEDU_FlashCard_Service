package edu.iedu.flashcard.dao.domain;

import java.util.List;

public class UserBin {
	List<User> users;

	public List<User> getUsers() {
		return users;
	}

	public void setGameResults(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "{\"Users\":\"" + users + "\"}";
	}
}
