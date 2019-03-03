package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.ConnectionDB;
import model.BillDetail;

public class BillDetailDAO {

	
	 public void insertBillDetail(BillDetail bd) throws SQLException {
	        Connection connection = ConnectionDB.openConnection();
	        String sql = "INSERT INTO bill_detail VALUES(?,?,?,?)";
	        PreparedStatement ps = connection.prepareCall(sql);
//	        ps.setLong(1, bd.getBillDetailID());
	        ps.setLong(1, bd.getBillID());
	        ps.setLong(2, bd.getProductID());
	        ps.setDouble(3, bd.getPrice());
	        ps.setInt(4, bd.getQuantity());
	        ps.executeUpdate();
	    }
	    
	    public static void main(String[] args) throws SQLException {
	        new BillDetailDAO().insertBillDetail(new BillDetail(0, 0, 0, 0, 0));
	    }
}
