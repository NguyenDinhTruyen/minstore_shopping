package minstore_shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import minstore_shopping.connection.DbCon;
import minstore_shopping.model.*;

import minstore_shopping.model.Product;

public class ProductDao {
	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;

	public ProductDao(Connection con) {
		this.con = con;
	}
	public ProductDao() {
		// TODO Auto-generated constructor stub
	}

	public List<Product> getAllProducts() {
		
		List<Product> products = new ArrayList<Product>();

		try {
			con=DbCon.getConnetion();
			query = "select * from products";
			pst = this.con.prepareStatement(query);
			rs = pst.executeQuery();

			while (rs.next()) {
				Product row = new Product();
				row.setId(rs.getInt("id"));
				row.setName(rs.getNString("name"));
				row.setCategory(rs.getString("category"));
				row.setPrice(rs.getDouble("price"));
				row.setImage(rs.getString("image"));

				products.add(row);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return products;
	}
	
	
	public void insertProduct(String name, String category, String price, String image) {
		
		try {
			con=DbCon.getConnetion();
			query =  "insert into products (name, category, price, image, sell_ID) values (?, ?, ?, ?, ?);";
			pst = this.con.prepareStatement(query);
			pst.setString(1, name);
			pst.setString(2, category);
			pst.setString(3, price);
			pst.setString(4, image);
			pst.setInt(5, 0);
			pst.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	public List<Cart> getCartProducts(ArrayList<Cart> cartList) {
		List<Cart> products = new ArrayList<Cart>();

		try {
			if (cartList.size() > 0) {
				for (Cart item : cartList) {
					query = "select * from products where id=?";
					pst = this.con.prepareStatement(query);
					pst.setInt(1, item.getId());
					rs = pst.executeQuery();
					while (rs.next()) {
						Cart row = new Cart();
						row.setId(rs.getInt("id"));
						row.setName(rs.getString("name"));
						row.setCategory(rs.getString("category"));
						row.setPrice(rs.getDouble("price") * item.getQuantity());
						row.setQuantity(item.getQuantity());
						products.add(row);
					}
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
//			e.printStackTrace();
		}
		return products;
	}

	public Product getSingleProduct(int id) {
		Product row = null;

		try {
			query = "select * from products where id=?";
			pst = this.con.prepareStatement(query);
			pst.setInt(1, id);
			rs = pst.executeQuery();

			while (rs.next()) {
				row = new Product();
				row.setId(rs.getInt("id"));
				row.setName(rs.getString("name"));
				row.setCategory(rs.getString("category"));
				row.setPrice(rs.getDouble("price"));
				row.setImage(rs.getString("image"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return row;
	}

	public double getTotalCartPrice(ArrayList<Cart> cartList) {
		double sum = 0;

		try {
			if (cartList.size() > 0) {
				for (Cart item : cartList) {
					query = "select price from products where id=? ";
					pst = this.con.prepareStatement(query);
					pst.setInt(1, item.getId());
					rs = pst.executeQuery();

					while (rs.next()) {
						sum += rs.getDouble("price") * item.getQuantity();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return sum;
	}

	// search
	public List<Product> searchByName(String txtSearch) {
		List<Product> list = new ArrayList<>();
		try {
			con=DbCon.getConnetion();
			query = "SELECT * FROM products where name like ?";
			pst = this.con.prepareStatement(query);
			pst.setString(1, "%" + txtSearch + "%");
			rs = pst.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getDouble(4),
						rs.getString(5)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// manager_pd
	public List<Product> getProductBySellID(int id) {
		List<Product> list = new ArrayList<>();
		try {
			query = "SELECT * FROM products where sell_ID = ?";
			pst = this.con.prepareStatement(query);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while (rs.next()) {
				Product row = new Product();
				row.setId(rs.getInt("id"));
				row.setName(rs.getNString("name"));
				row.setCategory(rs.getString("category"));
				row.setPrice(rs.getDouble("price"));
				row.setImage(rs.getString("image"));

				list.add(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//delete
	public void deleteProduct(String pid) {
		
		try {
			con=DbCon.getConnetion();
			query = "delete from products where id = ?";
			pst = this.con.prepareStatement(query);
			pst.setString(1, pid);
			pst.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		ProductDao dao=new ProductDao();
		System.out.println(dao.getAllProducts());
	}
	
	/* edit
	public void editProductByID(String pid) {
		
		try {
			con=DbCon.getConnetion();
			query = "delete from products where id = ?";
			pst = this.con.prepareStatement(query);
			pst.setString(1, pid);
			pst.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	} */
}
