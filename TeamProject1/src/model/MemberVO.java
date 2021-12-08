package model;

public class MemberVO {
	
	private String id;
	private String pw;
	private String nick;
	private String height;
	private String kg;
	private String age;
	private String gender;
	
	public MemberVO(String id, String pw, String height, String kg, String age, String gender) {
		
		this.id = id;
		this.pw = pw;
		this.nick = nick;
		this.height = height;
		this.kg = kg;
		this.age = age;
		this.gender = gender;
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

	public String getHeight() {
		return height;
	}

	public String getKg() {
		return kg;
	}

	public String getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}
	
	
	
	
	
	
	

}
