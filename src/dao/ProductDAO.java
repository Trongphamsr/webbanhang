package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionDB;
import model.Product;

public class ProductDAO {

	public List<Product> getListProductAll(){
		PreparedStatement ps=null;
		ResultSet rs=null;
		// ket noi voi co so du lieu
		Connection con = ConnectionDB.openConnection();
		List<Product> list = new  ArrayList<>();
		// viet lenh truy van 
		String sql="SELECT * FROM product";
		
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Product p = new Product();
				p.setProductID(rs.getLong("productID"));
				p.setProductName(rs.getString("productName"));
				p.setProductImage(rs.getString("productImage"));
				p.setProductPrice(rs.getFloat("productPrice"));
				p.setProductDescription("productDescription");
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionDB.closeConnect(con, ps, rs);
		}
		return list;
	}
	
	
	public ArrayList<Product> getListProductByCategory(long categoryid){
		PreparedStatement ps=null;
		ResultSet rs=null;
		// ket noi voi co so du lieu
		Connection con = ConnectionDB.openConnection();
		ArrayList<Product> list = new  ArrayList<>();
		// viet lenh truy van 
		String sql="SELECT * FROM product WHERE categoryID='"+categoryid+"'";
		
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Product p = new Product();
				p.setProductID(rs.getLong("productID"));
				p.setProductName(rs.getString("productName"));
				p.setProductImage(rs.getString("productImage"));
				p.setProductPrice(rs.getFloat("productPrice"));
				p.setProductDescription("productDescription");
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionDB.closeConnect(con, ps, rs);
		}
		return list;
	}
	
	
	public Product getProduct(long productID){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        con= ConnectionDB.openConnection();
        Product p = new Product();
        try {
            ps=con.prepareStatement("select * from product where productID='"+productID+"'");
           
            rs=ps.executeQuery();
            while(rs.next()){
             
				p.setProductID(rs.getLong("productID"));
				p.setProductName(rs.getString("productName"));
				p.setProductImage(rs.getString("productImage"));
				p.setProductPrice(rs.getFloat("productPrice"));
				p.setProductDescription(rs.getString("productDescription"));
            
            }
        } catch (SQLException ex) {
           System.out.println("loi xay ra");
        }finally {
        	ConnectionDB.closeConnect(con, ps, rs);
        }
        return p;  
    }
}
