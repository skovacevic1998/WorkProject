package backend;

public class Users extends Controller {
	static int userId = 0;
	static String username = "username";
	static String password = "password";
	static String email = "email";
	static String ime = "ime";
	static String prezime = "prezime";
	static String drzava = "drzava";
	static String grad = "grad";
	static String brojMobitela = "brojMobitela";
	static String pozicija = "pozicija";
	static String placaProslogMjeseca = "placaProslogMjeseca";
	static String putniTroskovi = "putniTroskovi";
	static String bodovi = "bodovi";
	static String satiMjesecno = "satiMjesecno";
	static String ukupnoStecenihRadnihSati = "ukupnoStecenihRadnihSati";
	static String preostaliDaniGodisnjegOdmora = "preostaliDaniGodisnjegOdmora";
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
