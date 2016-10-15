package edu.iedu.flashcard.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import edu.iedu.flashcard.dao.domain.User;
import edu.iedu.flashcard.dao.domain.UserBin;
import edu.iedu.flashcard.dao.domain.WordBook;
import edu.iedu.flashcard.dao.domain.WordBookBin;
import edu.iedu.flashcard.var.Env;

public class WordBookService {
	public static List<WordBook> getWordBooks(int userId) {
		HttpClient httpclient = new DefaultHttpClient();
		ArrayList<WordBook> wordbooks = null;
		
		try{
			String strUrl = Env.url + "readWordBookList.do"
					+ "?userId="+userId;
			InputStream in = new URL(strUrl)
					.openStream();
			
			System.out.println(strUrl);
			
			JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
			Gson gson = new Gson();
			WordBookBin wordbookBin = gson.fromJson(reader,	WordBookBin.class);
			wordbooks = (ArrayList<WordBook>) wordbookBin.getWordBooks();
 
		}catch (ClientProtocolException e) {
			e.printStackTrace();
		}catch (IOException e) { 
			e.printStackTrace();
		}finally {
			httpclient.getConnectionManager().shutdown();
		}
		return wordbooks;	
	}
	
	public static List<WordBook> searchWordBooks(String name) {
		HttpClient httpclient = new DefaultHttpClient();
		ArrayList<WordBook> wordbooks = new ArrayList<WordBook>();
		
		try{
			InputStream in = new URL(Env.url + "searchWordBookList.do"
					+ "?name="+name)
					.openStream();
			JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
			Gson gson = new Gson();
			WordBookBin wordbookBin = gson.fromJson(reader,	WordBookBin.class);
			wordbooks = (ArrayList<WordBook>) wordbookBin.getWordBooks();
 
		}catch (ClientProtocolException e) {
			e.printStackTrace();
		}catch (IOException e) { 
			e.printStackTrace();
		}finally {
			httpclient.getConnectionManager().shutdown();
		}
		return wordbooks;
	}
	
	public static boolean updateWordBook(WordBook wordBook){

		//For encoding to fit query format
		try {
			wordBook.setName(URLEncoder.encode(wordBook.getName(), "UTF-8"));
			wordBook.setIsfavorite(URLEncoder.encode(wordBook.getIsfavorite(), "UTF-8"));
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//user.setPassword(URLEncoder.encode(user.getPassword(), "UTF-8"));
		
		HttpClient httpclient = new DefaultHttpClient();
		try {

			HttpGet httpget = new HttpGet(Env.url + "updateWordBook.do"
					+ wordBook.toStringSealize());

			System.out.println("executing request " + httpget.getURI());

			HttpResponse response = httpclient.execute(httpget);
			HttpEntity entity = response.getEntity();

			if (entity != null) {
				BufferedReader rd = new BufferedReader(new InputStreamReader(
						response.getEntity().getContent()));

				String line = "";
				while ((line = rd.readLine()) != null) {
					if (line.startsWith("fail")) {
						// Error handling
						return false;
					} else if (line.equals("success")) {
						return true;
					} else {
						return false;
					}
				}
			}
			httpget.abort();
			httpclient.getConnectionManager().shutdown();

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
		return false;
	}
	
	public static void main(String[] args){
//		WordBook wb = new WordBook();
//		wb.setId(9007);
//		wb.setIsfavorite("Y");
//		WordBookService.updateWordBook(wb);
		System.out.println(WordBookService.getWordBooks(9030));
		//System.out.println(WordBookService.searchWordBooks("apple"));
	}
}
