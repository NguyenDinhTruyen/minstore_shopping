package minstore_shopping.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import minstore_shopping.connection.DbCon;
import minstore_shopping.dao.OrderDao;
import minstore_shopping.model.*;

/**
 * Servlet implementation class CheckOutServlet
 */
@WebServlet("/cart-check-out")
public class CheckOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter out = response.getWriter()){

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			
			//lay lai tat ca san pham trong gio hang
			@SuppressWarnings("unchecked")
			ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
			//xac thuc nguoi dung
			User auth = (User) request.getSession().getAttribute("auth");
			
			//kiem tra xac thuc va gio hang
			if(cart_list != null && auth != null) {
				
				for(Cart c:cart_list) {
					Order order = new Order();
					order.setId(c.getId());
					order.setUid(auth.getId());
					order.setQuantity(c.getQuantity());
					order.setDate(formatter.format(date));
					
					//khoi tao lop dao
					OrderDao oDao = new OrderDao(DbCon.getConnetion());
					//goi phuong thuc chen
					boolean result = oDao.insertOrder(order);
					if(!result) break;
					
				}
				
				cart_list.clear();
				response.sendRedirect("orders.jsp");
				
			}else {
				if(auth == null) response.sendRedirect("login.jsp");
				response.sendRedirect("cart.jsp");
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
