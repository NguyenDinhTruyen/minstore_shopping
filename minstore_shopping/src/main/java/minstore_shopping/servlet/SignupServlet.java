package minstore_shopping.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import minstore_shopping.dao.UserDao;
import minstore_shopping.model.User;


@WebServlet("/sign-up")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String email= request.getParameter("email");
		String password = request.getParameter("pass");
		String password1 = request.getParameter("pass1");
		if(!password.equals(password1)) {
			response.sendRedirect("Signup.jsp");
		}
		else {
			UserDao uDao = new UserDao();
			User u = uDao.checkEmailSignup(email);
			if(u == null) {
				uDao.singup(user,email,password);
				response.sendRedirect("login.jsp");
			}else {
				response.sendRedirect("Signup.jsp");
			}
		}
		
		
	}

}
