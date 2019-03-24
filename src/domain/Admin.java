package domain;

public class Admin {
	private int id;
	private boolean isLogin = false;
	private int item_id;
	private String password;
	private String type;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isLogin() {
		return isLogin;
	}
	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}	
	
}
