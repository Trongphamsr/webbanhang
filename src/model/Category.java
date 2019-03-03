package model;

public class Category {

	private long categoryID;
	private String categoryName;
	private long role;
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(long categoryID, String categoryName, long role) {
		super();
		this.categoryID = categoryID;
		this.categoryName = categoryName;
		this.role = role;
	}
	public long getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(long categoryID) {
		this.categoryID = categoryID;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public long getRole() {
		return role;
	}
	public void setRole(long role) {
		this.role = role;
	}
	
}
