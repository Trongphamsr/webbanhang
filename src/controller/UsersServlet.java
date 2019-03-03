package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connection.ConnectionDB;
import dao.InsertDao;
import model.InsertModel;
import tools.encryption;


/**
 * Servlet implementation class UsersServlet
 */
@WebServlet("/UsersServlet")
public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public UsersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        session.removeAttribute("user");
        response.sendRedirect("login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		HttpSession session = request.getSession();
		String s="select username from login where username='"+username+"'";
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		switch (command) {
		case "insert":
			
			Connection con =ConnectionDB.openConnection();
			try {
				ps=con.prepareStatement(s);
				rs=ps.executeQuery();
				if(rs.next()) {
//					request.setAttribute("status", "Add product failed!");
//					request.getRequestDispatcher("index.jsp").forward(request, response);
						
					response.sendRedirect("register.jsp");
				}
				else {
					InsertModel in = new InsertModel();
					in.setUsername(username);
					in.setPassword(encryption.MD5(password));
					Timestamp timestamp= new Timestamp(System.currentTimeMillis());
					in.setCreatedate(timestamp);
					in.setRole(1);
					boolean blAdd = new InsertDao().addInsert(in);
					if(blAdd){
						request.setAttribute("status", "Add product success!");
						request.getRequestDispatcher("index.jsp").forward(request, response);
					}else{
						request.setAttribute("status", "Add product failed!");
						request.getRequestDispatcher("register.jsp").forward(request, response);
					}
				}
			} catch (SQLException e) {
				System.out.println("loi xay ra"+e.getMessage());
			}
			break;

		case"login":
			InsertModel lg = new InsertModel();
			lg=InsertDao.Login(username, encryption.MD5(password));
			if(lg!=null){
	            session.setAttribute("user", lg);
	            request.getRequestDispatcher("index.jsp").include(request, response); 
	        }
	        else{
	             request.setAttribute("error", "error email or password or account over time");
	             request.getRequestDispatcher("login.jsp").include(request, response); 
	        }
			break;
			
		default:
			break;
		}
	}

}
