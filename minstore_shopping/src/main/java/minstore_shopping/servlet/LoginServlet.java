package minstore_shopping.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import minstore_shopping.connection.DbCon;
import minstore_shopping.dao.UserDao;
import minstore_shopping.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/user-login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		try(PrintWriter out = response.getWriter()){
			String email = request.getParameter("login-email");
			String password = request.getParameter("login-password");
			
			try {
				UserDao udao = new UserDao(DbCon.getConnetion());
				User user = udao.userLogin(email, password);
				
				if(user != null) {
					HttpSession session = request.getSession();
					session.setAttribute("auth", user);
					response.sendRedirect("index.jsp");
				}else {
					request.setAttribute("mess", "Wrong email or pass");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
		}
	}

}
