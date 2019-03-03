package model;

public class Product {

	private long productID,categoryID;
	private Float productPrice;
	private String ProductName,productImage,productDescription;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(long productID, long categoryID, Float productPrice, String productName, String productImage,
			String productDescription) {
		super();
		this.productID = productID;
		this.categoryID = categoryID;
		this.productPrice = productPrice;
		ProductName = productName;
		this.productImage = productImage;
		this.productDescription = productDescription;
	}
	public long getProductID() {
		return productID;
	}
	public void setProductID(long productID) {
		this.productID = productID;
	}
	public long getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(long categoryID) {
		this.categoryID = categoryID;
	}
	public Float getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Float productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

}
