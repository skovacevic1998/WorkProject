package backend;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Jdbc {
	public String sql;
	ResultSet rs;
	private ObservableList<ObservableList> data;
	private TableView tableview;
	ObservableList<Evidencija> oblist = FXCollections.observableArrayList();

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

	public String getUserName(String username) {
		String string = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/javaregistredusers?serverTimezone=UTC", "root", "");
			PreparedStatement stmt = con.prepareStatement("SELECT ime FROM users WHERE username=?");

			stmt.setString(1, username);

			rs = stmt.executeQuery();

			if (rs.next())
				string = rs.getString(1);

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return string;
	}

	public String getUserSurname(String username) {
		String string = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/javaregistredusers?serverTimezone=UTC", "root", "");
			PreparedStatement stmt = con.prepareStatement("SELECT prezime FROM users WHERE username=?");

			stmt.setString(1, username);

			rs = stmt.executeQuery();

			if (rs.next())
				string = rs.getString(1);

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return string;
	}

	public String getUserEmail(String username) {
		String string = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/javaregistredusers?serverTimezone=UTC", "root", "");
			PreparedStatement stmt = con.prepareStatement("SELECT email FROM users WHERE username=?");

			stmt.setString(1, username);

			rs = stmt.executeQuery();

			if (rs.next())
				string = rs.getString(1);

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return string;
	}

	public String getUserState(String username) {
		String string = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/javaregistredusers?serverTimezone=UTC", "root", "");
			PreparedStatement stmt = con.prepareStatement("SELECT drzava FROM users WHERE username=?");

			stmt.setString(1, username);

			rs = stmt.executeQuery();

			if (rs.next())
				string = rs.getString(1);

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return string;
	}

	public String getUserCity(String username) {
		String string = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/javaregistredusers?serverTimezone=UTC", "root", "");
			PreparedStatement stmt = con.prepareStatement("SELECT grad FROM users WHERE username=?");

			stmt.setString(1, username);

			rs = stmt.executeQuery();

			if (rs.next())
				string = rs.getString(1);

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return string;
	}

	public String getUserNumber(String username) {
		String string = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/javaregistredusers?serverTimezone=UTC", "root", "");
			PreparedStatement stmt = con.prepareStatement("SELECT brojMobitela FROM users WHERE username=?");

			stmt.setString(1, username);

			rs = stmt.executeQuery();

			if (rs.next())
				string = rs.getString(1);

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return string;
	}

	public String getUserPosition(String username) {
		String string = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/javaregistredusers?serverTimezone=UTC", "root", "");
			PreparedStatement stmt = con.prepareStatement("SELECT pozicija FROM users WHERE username=?");

			stmt.setString(1, username);

			rs = stmt.executeQuery();

			if (rs.next())
				string = rs.getString(1);

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return string;
	}

	public String getUserLastMonthPayment(String username) {
		String string = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/javaregistredusers?serverTimezone=UTC", "root", "");
			PreparedStatement stmt = con.prepareStatement("SELECT placaProslogMjeseca FROM users WHERE username=?");

			stmt.setString(1, username);

			rs = stmt.executeQuery();

			if (rs.next())
				string = rs.getString(1);

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return string;
	}

	public String getUserTravelExpenses(String username) {
		String string = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/javaregistredusers?serverTimezone=UTC", "root", "");
			PreparedStatement stmt = con.prepareStatement("SELECT putniTroskovi FROM users WHERE username=?");

			stmt.setString(1, username);

			rs = stmt.executeQuery();

			if (rs.next())
				string = rs.getString(1);

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return string;
	}

	public String getUserPoints(String username) {
		String string = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/javaregistredusers?serverTimezone=UTC", "root", "");
			PreparedStatement stmt = con.prepareStatement("SELECT bodovi FROM users WHERE username=?");

			stmt.setString(1, username);

			rs = stmt.executeQuery();

			if (rs.next())
				string = rs.getString(1);

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return string;
	}

	public String getUserWorkedHoursMonthly(String username) {
		String string = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/javaregistredusers?serverTimezone=UTC", "root", "");
			PreparedStatement stmt = con.prepareStatement("SELECT satiMjesecno FROM users WHERE username=?");

			stmt.setString(1, username);

			rs = stmt.executeQuery();

			if (rs.next())
				string = rs.getString(1);

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return string;
	}

	public String getUserTotalWorkingHours(String username) {
		String string = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/javaregistredusers?serverTimezone=UTC", "root", "");
			PreparedStatement stmt = con.prepareStatement("SELECT ukupnoStecenihRadnihSati FROM users WHERE username=?");

			stmt.setString(1, username);

			rs = stmt.executeQuery();

			if (rs.next())
				string = rs.getString(1);

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return string;
	}

	public String getUserFreeDays(String username) {
		String string = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/javaregistredusers?serverTimezone=UTC", "root", "");
			PreparedStatement stmt = con.prepareStatement("SELECT preostaliDaniGodisnjegOdmora FROM users WHERE username=?");

			stmt.setString(1, username);

			rs = stmt.executeQuery();

			if (rs.next())
				string = rs.getString(1);

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return string;
	}

	public void updateIme(String username, String source) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/javaregistredusers?serverTimezone=UTC", "root", "");
			PreparedStatement stmt = con.prepareStatement("UPDATE users SET ime=? WHERE username=?");

			stmt.setString(1, source);
			stmt.setString(2, username);

			stmt.executeUpdate();

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void updatePrezime(String username, String source) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/javaregistredusers?serverTimezone=UTC", "root", "");
			PreparedStatement stmt = con.prepareStatement("UPDATE users SET prezime=? WHERE username=?");

			stmt.setString(1, source);
			stmt.setString(2, username);

			stmt.executeUpdate();

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void updateEmail(String username, String source) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/javaregistredusers?serverTimezone=UTC", "root", "");
			PreparedStatement stmt = con.prepareStatement("UPDATE users SET email=? WHERE username=?");

			stmt.setString(1, source);
			stmt.setString(2, username);

			stmt.executeUpdate();

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void updateDrzava(String username, String source) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/javaregistredusers?serverTimezone=UTC", "root", "");
			PreparedStatement stmt = con.prepareStatement("UPDATE users SET drzava=? WHERE username=?");

			stmt.setString(1, source);
			stmt.setString(2, username);

			stmt.executeUpdate();

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void updateGrad(String username, String source) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/javaregistredusers?serverTimezone=UTC", "root", "");
			PreparedStatement stmt = con.prepareStatement("UPDATE users SET grad=? WHERE username=?");

			stmt.setString(1, source);
			stmt.setString(2, username);

			stmt.executeUpdate();

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void updateBrojMobitela(String username, String source) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/javaregistredusers?serverTimezone=UTC", "root", "");
			PreparedStatement stmt = con.prepareStatement("UPDATE users SET brojMobitela=? WHERE username=?");

			stmt.setString(1, source);
			stmt.setString(2, username);

			stmt.executeUpdate();

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void tableData(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/javaregistredusers?serverTimezone=UTC", "root", "");
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM evidencija");

			ResultSet rs = stmt.executeQuery();

			while (rs.next()){
				oblist.add(new Evidencija(rs.getInt("br"), rs.getString("vrijemeDolaska"),
						rs.getString("vrijemeOdlaska"),rs.getString("datumRada"),rs.getString("opisPosla"),
						rs.getString("ukupnoSatiRadnogDana")));
			}
		}catch (Exception e){
			System.out.println(e);
		}
	}

	public void tableDataByDate(String source){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/javaregistredusers?serverTimezone=UTC", "root", "");
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM evidencija WHERE datumPosla=?");

			stmt.setString(1, source);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()){
				oblist.add(new Evidencija(rs.getInt("br"), rs.getString("vrijemeDolaska"),
						rs.getString("vrijemeOdlaska"),rs.getString("datumRada"),rs.getString("opisPosla"),
						rs.getString("ukupnoSatiRadnogDana")));
			}
		}catch (Exception e){
			System.out.println(e);
		}
	}

	public String checkDate(){
		String source = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/javaregistredusers?serverTimezone=UTC", "root", "");
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM evidencija WHERE datumRada");

			rs = stmt.executeQuery();

			while (rs.next()){
				source = rs.getString(4);
			}


			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return source;
	}

	public int addEvidencija(String datum, String vrijemeOd, String vrijemeDo, String opisPosla, String ukupnoSati, String user) {
		int success = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/javaregistredusers?serverTimezone=UTC", "root", "");
			PreparedStatement stmt = con.prepareStatement("INSERT INTO evidencija (datumRada, vrijemeDolaska, vrijemeOdlaska, opisPosla, ukupnoSatiRadnogDana, user) " +
					"VALUES (?, ?, ?, ?, ?, ?)");

			stmt.setString(1, datum);
			stmt.setString(2, vrijemeOd);
			stmt.setString(3, vrijemeDo);
			stmt.setString(4, opisPosla);
			stmt.setString(5, ukupnoSati);
			stmt.setString(6, user);

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

	public int updateUkupnoSatiUsera(String sati, String user) {
		int success = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/javaregistredusers?serverTimezone=UTC", "root", "");
			PreparedStatement stmt = con.prepareStatement("UPDATE users SET ukupnoStecenihRadnihSati = ? WHERE username = ?");

			stmt.setString(1, sati);
			stmt.setString(2, user);

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