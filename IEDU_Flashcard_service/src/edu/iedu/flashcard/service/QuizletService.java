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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

//import com.google.gson.Gson;
//import com.google.gson.stream.JsonReader;

import edu.iedu.flashcard.dao.domain.QuizletCatalog;
import edu.iedu.flashcard.dao.domain.QuizletCatalogBin;
import edu.iedu.flashcard.dao.domain.Word;
import edu.iedu.flashcard.utils.JsonReader;
import edu.iedu.flashcard.var.Env;

public class QuizletService {
	
	private static JsonReader js;
	
	public static List<Word> getWords(String setId) throws IOException, JSONException{
		QuizletCatalog qc = new QuizletCatalog(setId);
		JSONObject setUrl = js.readJsonFromUrl(qc.setApiUrl);
		
		System.out.println(setUrl.toString());
		
		return null;
	}
	
	public static void main (String[] args) throws IOException, JSONException{
		List<Word> x = getWords("415");
	}
}
