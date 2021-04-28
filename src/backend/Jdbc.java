package backend;

import java.sql.*;

public class Jdbc {
	public String sql;
	ResultSet rs;

	public int dbLogin(String username, String password) {
		int count = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/javaregistredusers?serverTimezone=UTC", "root", "");
			PreparedStatement stmt = con.prepareStatement("SELECT COUNT(*) FROM users WHERE username=? AND password=?");

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
	public int dbGetUserId(String username) {
		int userId = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/javaregistredusers?serverTimezone=UTC", "root", "");
			PreparedStatement stmt = con.prepareStatement("SELECT id FROM users WHERE username=?");

			stmt.setString(1,username);

			rs = stmt.executeQuery();

			if (rs.next())
				userId = rs.getInt(1);

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return userId;
	}

	public String dbGetRoleName(int roleId){
		String roleName = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/javaregistredusers?serverTimezone=UTC", "root", "");
			PreparedStatement stmt = con.prepareStatement("SELECT roleName FROM role WHERE id=?");

			stmt.setInt(1, roleId);

			rs = stmt.executeQuery();

			if (rs.next())
				roleName = rs.getString(1);

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return roleName;
	}

	public int dbGetRoleId(String username){
		int roleId = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/javaregistredusers?serverTimezone=UTC", "root", "");
			PreparedStatement stmt = con.prepareStatement("SELECT roleId FROM users WHERE username=?");

			stmt.setString(1, username);

			rs = stmt.executeQuery();

			if (rs.next())
				roleId = rs.getInt(1);

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return roleId;
	}

	public int checkUsernameExistence(String username) {
		int count = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/javaregistredusers?serverTimezone=UTC", "root", "");
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM users WHERE username=?");

			stmt.setString(1, username);

			rs = stmt.executeQuery();

			if (rs.next())
				count = rs.getInt(1);

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return count;
	}

	public int checkEmailExistence(String email) {
		int count = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/javaregistredusers?serverTimezone=UTC", "root", "");
			PreparedStatement stmt = con.prepareStatement("SELECT COUNT(*) FROM users WHERE email=?");

			stmt.setString(1, email);

			rs = stmt.executeQuery();

			if (rs.next())
				count = rs.getInt(1);

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return count;
	}

	public int addUserRegister(String username, String password, String email, String ime,
							   String prezime, String drzava, String grad, String brojMobitela,
							   String pozicija, String placaProslogMjeseca, String putniTroskovi,
							   String bodovi, String satiMjesecno, String ukupnoStecenihRadnihSati,
							   String preostaliDaniGodisnjegOdmora, int roleId) {
		int success = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/javaregistredusers?serverTimezone=UTC", "root", "");
			PreparedStatement stmt = con.prepareStatement("INSERT INTO users (username, password, email, ime, prezime, " +
					"drzava, grad, brojMobitela, pozicija, placaProslogMjeseca, putniTroskovi, bodovi, satiMjesecno," +
					"ukupnoStecenihRadnihSati, preostaliDaniGodisnjegOdmora, roleId) " +
					"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

			stmt.setString(1, username);
			stmt.setString(2, password);
			stmt.setString(3, email);
			stmt.setString(4, ime);
			stmt.setString(5, prezime);
			stmt.setString(6, drzava);
			stmt.setString(7, grad);
			stmt.setString(8, brojMobitela);
			stmt.setString(9, pozicija);
			stmt.setString(10, placaProslogMjeseca);
			stmt.setString(11, putniTroskovi);
			stmt.setString(12, bodovi);
			stmt.setString(13, satiMjesecno);
			stmt.setString(14, ukupnoStecenihRadnihSati);
			stmt.setString(15, preostaliDaniGodisnjegOdmora);
			stmt.setInt(16, roleId);

			int rb = stmt.executeUpdate();

			if(rb == 1){
				success = rb;
			}

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return success;
	}
}
