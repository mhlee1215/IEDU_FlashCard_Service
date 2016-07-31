package edu.iedu.flashcard.dao.domain;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QuizletCatalog  {

//	class SetData  {
//		
//		class Term {
//			
//			int id;
//			String term;
//			String definition;
//			int rank;
//		}
//		
//		int id;
//		String url;
//		String title;
//		int term_count;	
//	}

	private static final String QUIZLET_CLIENT_ID = "MbR64YFWKb";

	private String setId;
//	private int setUrl;
//	private String setTitle;
//	private int setTermCount;

	public String setApiUrl = "";//"https://api.quizlet.com/2.0/sets/"+setId+"?client_id="+QUIZLET_CLIENT_ID+"&whitespace=1";

	
	public QuizletCatalog(String setId) {
		this.setId = setId ;
		this.setApiUrl = "https://api.quizlet.com/2.0/sets/"+setId+"?client_id="+QUIZLET_CLIENT_ID+"&whitespace=1";

	}
	
	
}
