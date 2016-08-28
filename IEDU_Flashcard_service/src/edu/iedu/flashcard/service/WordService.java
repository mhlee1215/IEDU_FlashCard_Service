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

import edu.iedu.flashcard.dao.domain.Word;
import edu.iedu.flashcard.dao.domain.WordBin;

import edu.iedu.flashcard.var.Env;

public class WordService {
	public static List<Word> getWordList(int wordbookId) {
		HttpClient httpclient = new DefaultHttpClient();
		ArrayList<Word> words = null;
		
		try{
			InputStream in = new URL(Env.url + "readWordList.do"
					+ "?wordbookId="+wordbookId)
					.openStream();
			JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
			Gson gson = new Gson();
			WordBin wordBin = gson.fromJson(reader,	WordBin.class);
			words = (ArrayList<Word>) wordBin.getWords();

		}catch (ClientProtocolException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			httpclient.getConnectionManager().shutdown();
		}
		return words;
	}
	
	public static void main(String[] args){
		List<Word> wordList = WordService.getWordList(9008);
		System.out.println(wordList.size());
		System.out.println(wordList);
	}
}

