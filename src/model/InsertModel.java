package model;

import java.sql.Timestamp;

public class InsertModel {

	private int id,role;
	private String username, password;
	private Timestamp createdate;
	public InsertModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InsertModel(int id, int role, String username, String password, Timestamp createdate) {
		super();
		this.id = id;
		this.role = role;
		this.username = username;
		this.password = password;
		this.createdate = createdate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Timestamp getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}
	
}
