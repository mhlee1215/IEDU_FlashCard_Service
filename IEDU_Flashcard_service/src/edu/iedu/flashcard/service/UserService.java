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
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import edu.iedu.flashcard.dao.domain.User;
import edu.iedu.flashcard.dao.domain.UserBin;
import edu.iedu.flashcard.var.Env;

public class UserService {
	
	public static int login(User user) {

		try {
			user.setName(URLEncoder.encode(user.getName(), "UTF-8"));
			user.setEmail(URLEncoder.encode(user.getEmail(), "UTF-8"));
			user.setPassword(URLEncoder.encode(user.getPassword(), "UTF-8"));
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				


		HttpClient httpclient = new DefaultHttpClient();

		HttpGet httpget = new HttpGet(Env.url + "appLogin.do"
				+ user.toStringSealize());
		
		System.out.println(httpget.getURI());
		HttpResponse response;
		try {
			response = httpclient.execute(httpget);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				BufferedReader rd = new BufferedReader(new InputStreamReader(
						response.getEntity().getContent()));

				String line = "";
				while ((line = rd.readLine()) != null) {
					if (line.startsWith("fail")) {
				
						return User.STATUS_LOGIN_FAIL;
					} else if (line.equals("success")) {
						return User.STATUS_LOGIN_SUCCESS;
					} else {
						return User.STATUS_LOGIN_FAIL;
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
		return User.STATUS_LOGIN_FAIL;
		
	}
	
	
	public static List<User> getUsers() {
		User user = null;

		HttpClient httpclient = new DefaultHttpClient();
		ArrayList<User> users = null;
		
		try{
			InputStream in = new URL(Env.url + "userListQuery.do")
					.openStream();
			JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
			Gson gson = new Gson();
			UserBin userBin = gson.fromJson(reader,	UserBin.class);
			users = (ArrayList<User>) userBin.getUsers();

			
		}catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			httpclient.getConnectionManager().shutdown();
		}

		return users;
	}
	
	public static List<User> readUsers() {

		HttpClient httpclient = new DefaultHttpClient();
		ArrayList<User> users = null;
		
		try{
			InputStream in = new URL(Env.url + "userListQuery.do")
					.openStream();
			JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
			Gson gson = new Gson();
			UserBin userBin = gson.fromJson(reader,	UserBin.class);
			users = (ArrayList<User>) userBin.getUsers();

			
		}catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			httpclient.getConnectionManager().shutdown();
		}

		return users;
		
	}


	public static boolean addUser(User user)
			throws UnsupportedEncodingException {

		//For encoding to fit query format
		user.setName(URLEncoder.encode(user.getName(), "UTF-8"));
		user.setEmail(URLEncoder.encode(user.getEmail(), "UTF-8"));
		user.setPassword(URLEncoder.encode(user.getPassword(), "UTF-8"));
		
		HttpClient httpclient = new DefaultHttpClient();
		try {

			HttpGet httpget = new HttpGet(Env.url + "addUser.do"
					+ user.toStringSealize());

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
		System.out.println(UserService.getUsers());
//		User user = new User();
//		user.setEmail("pink@gmail.com");
//		user.setPassword("pink");
//		try {
//			//System.out.println(UserService.addUser(user));
//			System.out.println(UserService.login(user));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
