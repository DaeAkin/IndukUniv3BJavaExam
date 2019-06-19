package iducs.springboot.board.domain;

public class User {
	private long id; // primary key
	private String userId; // unique key
	private String userPw;	
	private String name;
	private String company;
	
	public User()  {}
	public User(String userId, String userPw, String name, String company) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.name = name;
		this.company = company;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
}
