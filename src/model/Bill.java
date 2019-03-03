package model;

import java.sql.Timestamp;

public class Bill {

	private long billID;
//    private int id;
    private String username;
    private double total;
    private String payment;
    private String address;
    private Timestamp date;
	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bill(long billID, String username, double total, String payment, String address, Timestamp date) {
		super();
		this.billID = billID;
		this.username = username;
		this.total = total;
		this.payment = payment;
		this.address = address;
		this.date = date;
	}
	public long getBillID() {
		return billID;
	}
	public void setBillID(long billID) {
		this.billID = billID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	
    
}
