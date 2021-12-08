package com.model;

/**
 * @author smhrd
 *
 */
public class BookDTO {
	
	String id;
	String pw;
	String nick;
	String email;
	String tel;
	

	public BookDTO(String id, String pw, String nick, String email, String tel) {
		
		this.id = id;
		this.pw = pw;
		this.nick = nick;
		this.email = email;
		this.tel = tel;
	}
	public BookDTO(String id, String pw) {
		
		this.id = id;
		this.pw = pw;
	
	}
	
	public BookDTO(String nick) {
		
		this.nick = nick;
		
	}
	
	
	public String getId() {
		return id;
	}
	public String getPw() {
		return pw;
	}
	public String getNick() {
		return nick;
	}
	public String getEmail() {
		return email;
	}
	public String getTel() {
		return tel;
	}

}
