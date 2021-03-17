package backend;

import java.sql.*;
import java.util.List;

public class Jdbc {
	public String sql;
	ResultSet rs;
	String user;

	public String dbConnec() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/javaregistredusers?serverTimezone=UTC", "root", "");
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String username = rs.getString(2);
				String password = rs.getString(3);
				String email = rs.getString(4);

				user = username + "," + password + "," + email;
			}

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return user;
	}

	public int getCount(String username, String password) {
		int count = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/javaregistredusers?serverTimezone=UTC", "root", "");
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2, password);
			rs = stmt.executeQuery();

			if (rs.next())
				count = rs.getInt(1);

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return count;
	}
}
