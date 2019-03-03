package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import connection.ConnectionDB;
import model.InsertModel;
import tools.encryption;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InsertDao {

	// kiem tra xem username ton tai chua
	
    public boolean checkusername(String username) {
        Connection connection = ConnectionDB.openConnection();
        String sql = "SELECT * FROM login WHERE username = '" + username + "'";
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                connection.close();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(InsertDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
	
	// them tai khoan
	public boolean addInsert(model.InsertModel i) {
		boolean bl=false;
		Connection con;
		PreparedStatement ps=null;
		
		con=ConnectionDB.openConnection();
		try {
			ps=con.prepareStatement("insert into login values(?,?,?,?)");
			ps.setString(1, i.getUsername());
			ps.setString(2, i.getPassword());
			ps.setTimestamp(3, i.getCreatedate());
			ps.setInt(4, i.getRole());
			int a=ps.executeUpdate();
			if(a>0) {
				bl=true;
			}else {
				bl=false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bl;
	}
	
	// login
	public static InsertModel Login(String username, String password) {
		
		
		Connection con;
		PreparedStatement ps;
		ResultSet rs;
		con=ConnectionDB.openConnection();
		String re="2017-2-14 ";

		String sql1 = "select createdate from login where username='"+username+"'";
		try
		{
			PreparedStatement bbb = con.prepareStatement(sql1);
			
			ResultSet aaa = bbb.executeQuery();
			aaa.next();
			String a = aaa.getString("createdate");
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			String st = String.valueOf(timestamp);
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
			Date d1=null;
			Date d2=null;
			try {
				d1 = format.parse(a);
				d2=format.parse(st);
				System.out.println(d1);
				System.out.println(d2);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			long diff=d1.getTime();
			long dif=d2.getTime();
			long gg =dif-diff;
			long seconds = TimeUnit.MILLISECONDS.toHours(diff);
			long seconds1 = TimeUnit.MILLISECONDS.toHours(dif);
			long g = TimeUnit.MILLISECONDS.toSeconds(gg);
			System.out.println(seconds);
			System.out.println(seconds1);
			System.out.println(g);
			
			
			if(g<=1000000) {
			// kiem tra nhap username va password
			
			String sql="select * from login where username='"+username+"' and password='"+password+"'";
			try {
				ps=con.prepareCall(sql);
				rs=ps.executeQuery();
				
				while(rs.next()) {
					InsertModel md= new InsertModel();
					md.setUsername(rs.getString("username"));
					md.setPassword(rs.getString("password"));
					con.close();
					return md;
				}
			} catch (SQLException e) {
				Logger.getLogger(InsertDao.class.getName()).log(Level.SEVERE,null,e);
			}
		}	
		
		else {
				System.out.println("tai khoan cua ban da qua tg dang ky");
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("34534534");
		}
		return null;
	}
		
}
