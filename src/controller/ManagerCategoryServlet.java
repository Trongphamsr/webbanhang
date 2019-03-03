package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDAO;
import model.Category;

/**
 * Servlet implementation class ManagerCategoryServlet
 */
@WebServlet("/ManagerCategoryServlet")
public class ManagerCategoryServlet extends HttpServlet {
	 CategoryDAO categoryDAO = new CategoryDAO();
	 
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	String command = request.getParameter("command");
	        String categoryID = request.getParameter("categoryID");
	        String url = "";
	        
	        try {
	            switch (command) {
	                case "delete":
	                    categoryDAO.deleteCategory(Long.parseLong(categoryID));
	                    url = "/admin/manager_category.jsp";
	                    break;
	            }
	        } catch (Exception e) {
	        
	        }
	        
	        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
	        rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
        String tenDanhMuc = request.getParameter("tenDanhMuc");
        String url = "", error = "";
        String role=request.getParameter("role");
        Long role1= Long.parseLong(role);
        if (tenDanhMuc.equals("")) {
            error = "Vui lòng nhập tên danh mục!";
            request.setAttribute("error", error);
        }
        if(role.equals("")) {
        	error = "Vui lòng nhap role!";
        	request.setAttribute("error", error);
        }
        
        try {
            if (error.length() == 0) {
                switch (command) {
                    case "insert":
                        
                    	Category ca = new Category();
                    	ca.setCategoryName(tenDanhMuc);
                    	ca.setRole(role1);
                    	boolean bl= new CategoryDAO().insertcategory(ca);
                    	if(bl) {
                    		url = "/admin/manager_category.jsp";
//                    		response.sendRedirect("index.jsp");
//                			request.setAttribute("status", "Add product success!");
//                			request.getRequestDispatcher("index.jsp").forward(request, response);
                    	}else {
                    		url = "/admin/insert_category.jsp";
//                    		request.setAttribute("status", "Add product failed!");
//                			request.getRequestDispatcher("insert.jsp").forward(request, response);
                    	}
                        
                        break;
                        
                    case "update":
//                        categoryDAO.updateCategory(new Category(Long.parseLong(request.getParameter("category_id")),
//                               tenDanhMuc));
                    	Category c = new Category();
                    	c.setCategoryName(tenDanhMuc);
                    	c.setRole(role1);
                    	c.setCategoryID(Long.parseLong(request.getParameter("categoryID")));
                    	boolean blUpdate = new CategoryDAO().updateategory(c);
                    	if(blUpdate) {
                    		url = "/admin/manager_category.jsp";
                    	}else {
                    		url = "/admin/update_category.jsp";
                    	}
                        
                        break;
                }
            } else {
                url = "/admin/insert_category.jsp";
            }
        } catch (Exception e) {
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);
        
        
	}

}
