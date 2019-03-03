package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.ConnectionDB;
import model.Bill;

public class BillDAO {

	public void insertBill(Bill bill) throws SQLException {
        Connection connection = ConnectionDB.openConnection();
        String sql = "INSERT INTO bill1 VALUES(?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
//        ps.setLong(1, bill.getBillID());
        ps.setString(1, bill.getUsername());
        ps.setDouble(2, bill.getTotal());
        ps.setString(3, bill.getPayment());
        ps.setString(4, bill.getAddress());
        ps.setTimestamp(5, bill.getDate());
        ps.executeUpdate();
    }
    
    public static void main(String[] args) throws SQLException {
        
//        new BillDAO().insertBill(new Bill(0, 0, 0, "s", "s", new Timestamp(new Date().getTime())));
    }
}
