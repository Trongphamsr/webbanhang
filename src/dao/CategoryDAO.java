package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.ConnectionDB;
import model.Category;

public class CategoryDAO {

	// lay tat ca cac danh muc trong bang category role=0
	public ArrayList<Category> getListCategory(){
		
		// ket noi voi co so du lieu
		Connection con=ConnectionDB.openConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		// viet cau truy van lay tat ca cac danh sach co role =0
		String sql="SELECT * FROM category WHERE role=0";
		 ArrayList<Category> list = new ArrayList<>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Category category = new Category();
				category.setCategoryID(rs.getLong("categoryID"));
				category.setCategoryName(rs.getString("categoryName"));
				list.add(category);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionDB.closeConnect(con, ps, rs);
		}
		return list;
		
	}
	
	
	// lay cac danh muc co role=categoryid
	
	public ArrayList<Category> getListSupCateory(long categoryid){
		
		PreparedStatement ps=null;
		ResultSet rs=null;
		// ket noi voi csdl
		Connection con= ConnectionDB.openConnection();
		String sql="SELECT * FROM category where role='"+categoryid+"'";
		ArrayList<Category> list = new ArrayList<>();
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Category ca= new Category();
				ca.setCategoryID(rs.getLong("categoryID"));
				ca.setCategoryName(rs.getString("categoryName"));
				ca.setRole(rs.getLong("role"));
				list.add(ca);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionDB.closeConnect(con, ps, rs);
		}
		return list;
	}
	
	// lay ten thang danh muc cha khi ban chon danh muc
	
	public ArrayList<Category> getListSupperCategory(long categoryid){
        Connection con= null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        
        con = ConnectionDB.openConnection();
        String sql ="SELECT * FROM category WHERE categoryID='"+categoryid+"'";
        
        ArrayList<Category> list = new ArrayList<>();
        try {
             ps = con.prepareStatement(sql);
             rs = ps.executeQuery();
             while(rs.next()){
                 Category ca = new Category();
                 ca.setCategoryID(rs.getLong("categoryID"));
	 			 ca.setCategoryName(rs.getString("categoryName"));
	 			 ca.setRole(rs.getLong("role"));
                 list.add(ca);
             }
        } catch (SQLException ex) {
            System.out.println("khong ton tai");
        }finally {
        	ConnectionDB.closeConnect(con, ps, rs);
        }
        return list;
    }
	
	
	// lam viec voi admin
	
//	them moi danh muc
	public boolean insertcategory(Category c) {
		boolean bl=false;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = ConnectionDB.openConnection();
		String sql="insert into category values(?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, c.getCategoryName());
			ps.setLong(2, c.getRole());
			int i=ps.executeUpdate();
			if(i>0) {
				bl= true;
			}else {
				bl= false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionDB.closeConnect(con, ps, rs);
		}
		return bl;
		
	}
	
	// update category
	public boolean updateategory(Category c) {
		boolean bl = false;
		Connection con = ConnectionDB.openConnection();
		PreparedStatement ps=null;
		ResultSet rs = null;
		String sql ="update category set categoryName=?, role=? where categoryID=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1,c.getCategoryName());
			ps.setLong(2, c.getRole());
			ps.setLong(3, c.getCategoryID());
			int a =ps.executeUpdate();
			if(a>0) {
				bl=true;
			}else {
				bl=false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionDB.closeConnect(con, ps, rs);
		}
		return bl;
		
	}
	
	// delete 
	public boolean deleteCategory(long categoryID) {
		
		boolean bl = false;
		Connection con = ConnectionDB.openConnection();
		PreparedStatement ps=null;
		ResultSet rs = null;
		String sql="delete from category where categoryID=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setLong(1, categoryID);
			int a=ps.executeUpdate();
			if(a>0)
				bl = true;
			else
				bl=false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionDB.closeConnect(con, ps, rs);
		}
		return bl;
	}
	
	  public static void main(String[] args) throws SQLException {
	        CategoryDAO dao = new CategoryDAO();
//	        for (int i = 1; i < 10; i++) {
//	            dao.insertCategory(new Category(i, "Category " + i));
//	        }
//	        System.out.println(dao.updateCategory(new Category(8, "Tùng Dương")));
	        System.out.println(dao.deleteCategory(7));
	    } 
}
