package minstore_shopping.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import minstore_shopping.dao.ProductDao;

/**
 * Servlet implementation class AddProduct
 */
@WebServlet("/AddProduct")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		// TODO Auto-generated method stub
		String pname = request.getParameter("name");
		String pcategory = request.getParameter("category");
		String pprice = request.getParameter("price");
		String pimage = request.getParameter("image");

//		HttpSession session = request.getSession();
//		User u = (User) session.getAttribute("auth");
//		int sid = u.getId();
		
		ProductDao pDao = new ProductDao();
		pDao.insertProduct(pname, pcategory, pprice, pimage);
		request.getRequestDispatcher("manager-product").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
