package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ListProductDAO;
import dao.OrdersDAO;
import model.Cart;
import model.Orders;
import model.Product;

/**
 * Servlet implementation class PayController
 */
@WebServlet("/PayController")
public class PayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession(true);
		String Discount = request.getParameter("Discount");
		Cart c = (Cart) session.getAttribute("cart");
		session.setAttribute("Discount", Discount);
		if(session.getAttribute("user")==null) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else if(c.getSize()==0){
			
			RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
			response.getWriter().println("<script type=\"text/javascript\">");
			response.getWriter().println("alert('Chưa có sản phẩm nào trong cart');");
			response.getWriter().println("location='cart.jsp';");
			response.getWriter().println("</script>");
			
			rd.include(request, response);
			
			

		}else {
			response.sendRedirect("pay.jsp");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession(true);
		OrdersDAO dao = new OrdersDAO();
		Cart c = (Cart) session.getAttribute("cart");
		List<Product> l = c.getItems();
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String discount = request.getParameter("discount");
		
		Orders o = new Orders(email, 2 , discount, address);
		
		try {
			dao.insertOrder(o, c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(session.getAttribute("cart") != null ) {
			session.setAttribute("cart", new Cart());
		}
		RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
		response.getWriter().println("<script type=\"text/javascript\">");
		response.getWriter().println("alert('tao don thanh cong');");
		response.getWriter().println("location='cart.jsp';");
		response.getWriter().println("</script>");
		
		rd.include(request, response);
		

	}

}
