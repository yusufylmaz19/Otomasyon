
package sqlbaglantý;

import java.sql.*;

import javax.swing.*;


public class girisbaglantý {
	public static Connection girisconnector(){

		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:sqlite:C://sqlite/login.db");
			return con;

		} catch (SQLException e) {
		JOptionPane.showMessageDialog(null, e);
			return null;
		}
		

	}
}