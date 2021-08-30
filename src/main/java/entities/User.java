package entities;

public class User {
	private String userName;
	private String password;
	private int role;
	private int bookcase;
	
	
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public int getBookcase() {
		return bookcase;
	}

	public void setBookcase(int bookcase) {
		this.bookcase = bookcase;
	}

	public User(String userName, String password, int role, int bookcase) {
		super();
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.bookcase = bookcase;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + "]";
	}
	
	
}
