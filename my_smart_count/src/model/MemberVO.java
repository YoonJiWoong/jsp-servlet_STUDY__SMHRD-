package model;

public class MemberVO {
	
	private String id;
	private String pw;
	private String nick;
	private String height;
	private String kg;
	private String gender;
	private String age;
	private String bmi;
	
	public MemberVO(String id, String pw, String nick, String height, 
			String kg, String gender, String age,
			String bmi) {
		this.id = id;
		this.pw = pw;
		this.nick = nick;
		this.height = height;
		this.kg = kg;
		this.gender = gender;
		this.age = age;
		this.bmi = bmi;
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

	public String getGender() {
		return gender;
	}

	public String getAge() {
		return age;
	}

	public String getBMI() {
		return bmi;
	}

	
	
	
	
	
	
	
	

}
