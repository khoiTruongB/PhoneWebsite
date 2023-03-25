package controller;

import java.io.IOException;
import java.sql.SQLException;

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
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
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
		
		ListUserDAO dao = new ListUserDAO();
		
		String Username = request.getParameter("Username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String re_password = request.getParameter("re-password");
		HttpSession session = request.getSession(true);
		if(password.equals(re_password)) {
			User u = new User(email,password,0,Username, "", "");
			try {
				dao.createUser(u);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RequestDispatcher rd = request.getRequestDispatcher("productPage");
			response.getWriter().println("<script type=\"text/javascript\">");
			response.getWriter().println("alert('dang ki thanh cong');");
			response.getWriter().println("location='productPage';");
			response.getWriter().println("</script>");
			
			rd.include(request, response);
		}else {
			session.setAttribute("", "wrong username or password");
			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
			
			response.getWriter().println("<script type=\"text/javascript\">");
			response.getWriter().println("alert('wrong username or password');");
			response.getWriter().println("location='register.jsp';");
			response.getWriter().println("</script>");
			
			rd.include(request, response);
		}
		
 	}

}
