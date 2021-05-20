package backend;

public class Users extends Controller {
	static int userId = 0;
	static String username = "";
	static String password = "";
	static String email = "";
	static String ime = "";
	static String prezime = "";
	static String drzava = "";
	static String grad = "";
	static String brojMobitela = "";
	static String pozicija = "N/A";
	static String placaProslogMjeseca = "0";
	static String putniTroskovi = "0";
	static String bodovi = "0";
	static String satiMjesecno = "0";
	static String ukupnoStecenihRadnihSati = "0";
	static String preostaliDaniGodisnjegOdmora = "0" +
			"";
	static int roleId = 0;

	public Users(int userId, String username, String password, String email, String ime,
				 String prezime, String drzava, String grad, String brojMobitela,
				 String pozicija, String placaProslogMjeseca, String putniTroskovi,
				 String bodovi, String satiMjesecno, String ukupnoStecenihRadnihSati,
				 String preostaliDaniGodisnjegOdmora, int roleId) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.ime = ime;
		this.prezime = prezime;
		this.drzava = drzava;
		this.grad = grad;
		this.brojMobitela = brojMobitela;
		this.pozicija = pozicija;
		this.placaProslogMjeseca = placaProslogMjeseca;
		this.putniTroskovi = putniTroskovi;
		this.bodovi = bodovi;
		this.satiMjesecno = satiMjesecno;
		this.ukupnoStecenihRadnihSati = ukupnoStecenihRadnihSati;
		this.preostaliDaniGodisnjegOdmora = preostaliDaniGodisnjegOdmora;
		this.roleId = roleId;
	}
}
