package minstore_shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import minstore_shopping.connection.DbCon;
import minstore_shopping.model.User;

public class UserDao {
	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	public UserDao(Connection con, String query, PreparedStatement pst, ResultSet rs) {
		super();
		this.con = con;
		this.query = query;
		this.pst = pst;
		this.rs = rs;
	}
	public UserDao() {
		// TODO Auto-generated constructor stub
	}
	public UserDao(Connection con) {
		this.con = con;
	}
	
	public User checkEmailSignup(String email) {
		try {
			con = DbCon.getConnetion();
			query = "SELECT email from users";
			pst = this.con.prepareStatement(query);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				return new User(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getInt(5),
						rs.getInt(6));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public void singup(String user, String email, String password) {
		try {
			con = DbCon.getConnetion();
			query = "INSERT INTO `minstoredb`.`users` (`name`, `email`, `password`, `isSell`, `isAdmin`) VALUES (?, ?, ?, ?, ?);\r\n"
					+ "";
			pst = this.con.prepareStatement(query);
			pst.setString(1, user);
			pst.setString(2, email);
			pst.setString(3, password);
			pst.setString(4, "0");
			pst.setString(5, "0");
			pst.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public User userLogin(String email,String password) {
		try {
			query = "select * from users where email=? and password=?";
			pst = this.con.prepareStatement(query);
			pst.setString(1, email);
			pst.setString(2, password);
			rs = pst.executeQuery();
			
			if(rs.next()) {
				return new User(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getInt(5),
						rs.getInt(6));	
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
		
		return null;
	}	
}
