package edu.iedu.flashcard.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import edu.iedu.flashcard.dao.domain.User;
import edu.iedu.flashcard.dao.domain.UserBin;
import edu.iedu.flashcard.dao.domain.WordBook;
import edu.iedu.flashcard.dao.domain.WordBookBin;
import edu.iedu.flashcard.var.Env;

public class WordBookService {
	public static List<WordBook> getWordBooks() {
		WordBook wordbook = null;
		HttpClient httpclient = new DefaultHttpClient();
		ArrayList<WordBook> wordbooks = null;
		
		try{
			InputStream in = new URL(Env.url + "readWordBookList.do"
					+ "")
					.openStream();
			JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
			Gson gson = new Gson();
			WordBookBin wordbookBin = gson.fromJson(reader,	WordBookBin.class);
			wordbooks = (ArrayList<WordBook>) wordbookBin.getWordBooks();

		}catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			httpclient.getConnectionManager().shutdown();
		}

		return wordbooks;
	}
	
	public static void main(String[] args){
		List<WordBook> wordBookList = WordBookService.getWordBooks();
		System.out.println(wordBookList);
	}
}
