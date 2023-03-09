package minstore_shopping.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import minstore_shopping.dao.ProductDao;
import minstore_shopping.model.Product;
import minstore_shopping.model.User;

/**
 * Servlet implementation class ManagerProduct
 */
@WebServlet("/manager-product")
public class ManagerProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("auth");
//		int id = u.getId();
		ProductDao pDao = new ProductDao();
		List<Product> list = pDao.getAllProducts();
	//	System.out.println(list);
		request.setAttribute("products", list);
		request.getRequestDispatcher("ManagerProduct.jsp").forward(request, response);
		
	}
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			super.doPost(req, resp);
		}
}
