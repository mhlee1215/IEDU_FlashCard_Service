package edu.iedu.flashcard.dao.domain;

/**
 * 
 * @author sutting
 * 
 */

//`id` INT NOT NULL AUTO_INCREMENT,
//`name` VARCHAR(16) NULL,
//`email` VARCHAR(255) NOT NULL,
//`password` VARCHAR(32) NOT NULL,
//`registereddate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
//`deleteddate` VARCHAR(45) NULL,
//`verifieddate` VARCHAR(45) NULL,
//`status` VARCHAR(45) NULL,
//`isverified` INT NOT NULL DEFAULT 0,

public class User {
	
	public final static int		STATUS_NOT_FOUNDED			= 1;
	public final static int		STATUS_FOUNDED				= 2;
	public final static int		STATUS_SUCCESS_REGISTER		= 3;
	public final static int		STATUS_SUCCESS_VERIFIED		= 4;
	public final static int		STATUS_SUCCESS_DELETED		= 5;
	public final static int		STATUS_ALREADY_REGISTEREDED	= 6;
	public final static int		STATUS_ALREADY_VERIFIED		= 7;
	public final static int		STATUS_ALREADY_DELETED		= 8;
	public final static int		STATUS_NOT_VERIFIED			= 9;
	public final static int		STATUS_DELTE_FAIL			= 10;
	public final static int		STATUS_LOGIN_SUCCESS		= 11;
	public final static int 	STATUS_LOGIN_FAIL			= 12;
	public final static int		SIGNUP_RESULT_SUCCESS 		= 13;
	public final static int		SIGNUP_RESULT_FAIL			= 14;
	
	public final static String		STATUS_VERIFIED				= "STATUS_VERIFIED";
	
	
	private int		id				= 0;	// ID
	private String 	name			= "";
	private String 	email 			= "";
	private String	password		= "";	// PASSWORD
		
	private int query_start = 0;
	private int query_number = 0;

	
	public User(){
	}
	
	public int getQuery_start() {
		return query_start;
	}
	public void setQuery_start(int query_start) {
		this.query_start = query_start;
	}
	public int getQuery_number() {
		return query_number;
	}
	public void setQuery_number(int query_number) {
		this.query_number = query_number;
	}

	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\",\"name\":\"" + name + "\",\"email\":\"" + email + "\",\"password\":\"" + password
				+ "\"}";
	}
	
	public String toStringSealize(){
		return "?name="+name+
				"&email="+email+
				"&password="+password;
	}
	
}
