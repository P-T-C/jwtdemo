package jwtdemo.model;

public class User {
	private String userName;
	private String password;
	private String fullName;
	private int age;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public User(String userName, String password, String fullName, int age) {
		super();
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.age = age;
	}
	public String getUserName() {
		return userName;
	}
	public void setUsername(String username) {
		this.userName = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	

}
