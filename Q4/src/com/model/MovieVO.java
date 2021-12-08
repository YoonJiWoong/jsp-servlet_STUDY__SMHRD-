package com.model;

public class MovieVO {
	
	
	String id;
	String pw;
	int age;
	String nick;
	String tel;
	
	
	public MovieVO(String id, String pw) {
		
		this.id = id;
		this.pw = pw;
	}
	
	
	public MovieVO(String id, String pw, int age, String nick, String tel) {
		
		this.id = id;
		this.pw = pw;
		this.age = age;
		this.nick = nick;
		this.tel = tel;
	}

	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public int getAge() {
		return age;
	}

	public String getNick() {
		return nick;
	}

	public String getTel() {
		return tel;
	}
	
	
	

}
