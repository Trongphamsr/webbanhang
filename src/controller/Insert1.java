package controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.InsertDao;
import model.InsertModel;
import tools.encryption;

/**
 * Servlet implementation class Insert1
 */
@WebServlet("/Insert1")
public class Insert1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insert1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
 
		InsertModel in = new InsertModel();
		in.setUsername(username);
		in.setPassword(encryption.MD5(password));
		Timestamp timestamp= new Timestamp(System.currentTimeMillis());
		in.setCreatedate(timestamp);
		in.setRole(1);
		boolean blAdd = new InsertDao().addInsert(in);
		
		if(blAdd){
//			response.sendRedirect("index.jsp");
			request.setAttribute("status", "Add product success!");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else{
			request.setAttribute("status", "Add product failed!");
			request.getRequestDispatcher("insert.jsp").forward(request, response);
		}
	}

}
