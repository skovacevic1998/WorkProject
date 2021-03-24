package backend;

import com.sun.javafx.charts.Legend;
import com.sun.javafx.menu.MenuItemBase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Users extends Controller {
	String username;
	String password;
	String email;
	String ime;
	String prezime;
	String drzava;
	String grad;
	String brojMobitela;
	int pozicija;
	float placaProslogMjeseca;
	float putniTroskovi;
	float bodovi;
	float satiMjesecno;
	float ukupnoStecenihRadnihSati;
	int preostaliDaniGodisnjegOdmora;

	public Users(String username, String password, String email, String ime, String prezime, String drzava, String grad, String brojMobitela, int pozicija, float placaProslogMjeseca, float putniTroskovi, float bodovi, float satiMjesecno, float ukupnoStecenihRadnihSati, int preostaliDaniGodisnjegOdmora) {
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
	}
}
