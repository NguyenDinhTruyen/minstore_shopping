package minstore_shopping.model;

public class User {
	private int id;
	private String name;
	private String email;
	private String password;
	private int isSell;
	private int isAdmin;
	
	public User() {
	}
	
	
	public User(int id, String name, String email, String password, int isSell, int isAdmin) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.isSell = isSell;
		this.isAdmin = isAdmin;
		
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
	


	public int getIsSell() {
		return isSell;
	}


	public void setIsSell(int isSell) {
		this.isSell = isSell;
	}


	public int getIsAdmin() {
		return isAdmin;
	}


	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", isSell="
				+ isSell + ", isAdmin=" + isAdmin + "]";
	}	
}
