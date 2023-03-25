package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ListProductDAO;
import model.Cart;
import model.Product;
import model.User;

/**
 * Servlet implementation class AddToCartController
 */
@WebServlet("/AddToCartController")
public class AddToCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");

		ListProductDAO dao = new ListProductDAO();
		
		
	
		try {
			HttpSession session = request.getSession(true);
			
			session.setAttribute("buy", "Continue buy");
			String id = request.getParameter("id");
			if(id == null) {
				id = "0";
			}
			String action = request.getParameter("action");
			int idd = Integer.parseInt(id);
			if(action !=null && action.equals("add")) {
				if(session.getAttribute("cart") == null ) {
					session.setAttribute("cart", new Cart());
				}
				if(idd!=0) {
					Product p = dao.getInfoProduct(idd);
					
					Cart c = (Cart) session.getAttribute("cart");
					
					c.addItem(new Product(p.getId(),p.getName(),p.getDescription(),p.getPrice(),p.getSrc(),p.getType(),p.getBrand(),1));
				}
				
				Cart c = (Cart) session.getAttribute("cart");
			}else if(action != null && action.equals("delete")) {
				Cart c = (Cart) session.getAttribute("cart");
				c.remove(idd);
			}else if(action != null && action.equals("minus")) {
				Cart c = (Cart) session.getAttribute("cart");
				Product p = dao.getInfoProduct(idd);
				int num =p.getNumber()-1;
				if(c.getQuantily(idd)<=1) {
					c.remove(idd);
				}else {
					c.addItem(new Product(p.getId(),p.getName(),p.getDescription(),p.getPrice(),p.getSrc(),p.getType(),p.getBrand(),num));
				}
				
				
			}
			
			response.sendRedirect("cart.jsp");


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




	}

}
