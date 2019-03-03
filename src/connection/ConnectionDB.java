package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConnectionDB {

	// mo ket noi voi csdl
	public static Connection openConnection() {
		Connection con=null;
		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","");
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con=DriverManager.getConnection("jdbc:sqlserver://localhost:52824;databaseName=shop","sa","123456");
		} catch (ClassNotFoundException e) {
			System.out.println("loi forname"+e.getMessage());
		}catch (SQLException e) {
			System.out.println("loi driver"+e.getMessage());
		}
	
		return con;
	}
	
	public static void closeConnect(Connection con, PreparedStatement ps, ResultSet rs){
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(ps!=null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Connection con= openConnection();
		if(con!=null) {
			System.out.println("ok");
		}else {
			System.out.println("no ok");
		}

	}

}
