package minstore_shopping.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/log-out")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		session.removeAttribute("auth");
		response.sendRedirect("index.jsp"); 
		
	/*	try(PrintWriter out = response.getWriter()){
			if(request.getSession().getAttribute("auth") != null ) {
				request.getSession().removeAttribute("auth");
				response.sendRedirect("login.jsp");
			}else {
				response.sendRedirect("index.jsp");
			}
		} */
	}
}
