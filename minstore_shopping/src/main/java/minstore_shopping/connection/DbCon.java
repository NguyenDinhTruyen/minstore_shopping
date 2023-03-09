package minstore_shopping.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbCon {
	private static Connection connection = null;
	
	public static Connection getConnetion() throws ClassNotFoundException, SQLException {
		if(connection==null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/minstoredb","root","123456ab");
			System.out.print("Connected");
		}
		return connection;
	}
}
