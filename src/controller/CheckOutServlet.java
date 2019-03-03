package controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BillDAO;
import dao.BillDetailDAO;
import model.Bill;
import model.BillDetail;
import model.Cart;
import model.InsertModel;
import model.Item;
import tools.SendMail;

/**
 * Servlet implementation class CheckOutServlet
 */
@WebServlet("/CheckOutServlet")
public class CheckOutServlet extends HttpServlet {

	private final BillDAO billDAO = new BillDAO();
	private final BillDetailDAO billDetailDAO = new BillDetailDAO();


	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckOutServlet() {
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

		String payment = request.getParameter("payment");
		String address = request.getParameter("address");
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		InsertModel users = (InsertModel) session.getAttribute("user");
		try {
			long ID = new Date().getTime();
			Bill bill = new Bill();
			bill.setBillID(ID);
			bill.setAddress(address);
			bill.setPayment(payment);
			bill.setUsername(users.getUsername());
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			bill.setDate(timestamp);
			bill.setTotal(cart.totalCart());
			billDAO.insertBill(bill);
			for (Map.Entry<Long, Item> list : cart.getCartItems().entrySet()) {
				billDetailDAO.insertBillDetail(new BillDetail(0, ID,
						list.getValue().getProduct().getProductID(),
						list.getValue().getProduct().getProductPrice(),
						list.getValue().getQuantity()));
			}
			 SendMail sm = new SendMail();
//			 users.getUsername() thay bang users.getEmail do trong bai quen k co email
	            sm.sendMail(users.getUsername(), "Kenh Lap Trinh", "Hello, "+users.getUsername()+"\nTotal: "+cart.totalCart());
			cart = new Cart();
			session.setAttribute("cart", cart);
		} catch (Exception e) {
		}
		response.sendRedirect("/WebBanHang/index.jsp");

	}

}
