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

import dao.ListUserDAO;
import model.User;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		ListUserDAO dao = new ListUserDAO();

		String username = request.getParameter("mail");
		String password = request.getParameter("password");

		try {
			HttpSession session = request.getSession();
			User u = dao.getUser(username, password);
			
			if (u == null) {
				session.setAttribute("message", "wrong username or password");
				request.getRequestDispatcher("login.jsp").forward(request, response);

			} else {
				session.setAttribute("logon", true);
				if (u.getRole() == 0) {
					
					session.setAttribute("user", u);
					request.getRequestDispatcher("productPage").forward(request, response);
					
				} else if (u.getRole() == 1) {
					session.setAttribute("user", u);
					
					request.getRequestDispatcher("productPage").forward(request, response);
					
				}
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
