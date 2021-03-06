package backend;

public class Evidencija {
    int br = 0;
    String vrijemeDolaska = "";
    String vrijemeOdlaska = "";
    String datumRada = "";
    String opisPosla = "";
    String ukupnoSatiRadnogDana = "";

    public Evidencija(int br, String vrijemeDolaska, String vrijemeOdlaska, String datumRada, String opisPosla, String ukupnoSatiRadnogDana) {
        this.br = br;
        this.vrijemeDolaska = vrijemeDolaska;
        this.vrijemeOdlaska = vrijemeOdlaska;
        this.datumRada = datumRada;
        this.opisPosla = opisPosla;
        this.ukupnoSatiRadnogDana = ukupnoSatiRadnogDana;
    }

    public Evidencija(){
        
    }

    public int getBr() {
        return br;
    }

    public void setBr(int br) {
        this.br = br;
    }

    public String getVrijemeDolaska() {
        return vrijemeDolaska;
    }

    public void setVrijemeDolaska(String vrijemeDolaska) {
        this.vrijemeDolaska = vrijemeDolaska;
    }

    public String getVrijemeOdlaska() {
        return vrijemeOdlaska;
    }

    public void setVrijemeOdlaska(String vrijemeOdlaska) {
        this.vrijemeOdlaska = vrijemeOdlaska;
    }

    public String getDatumRada() {
        return datumRada;
    }

    public void setDatumRada(String datumRada) {
        this.datumRada = datumRada;
    }

    public String getOpisPosla() {
        return opisPosla;
    }

    public void setOpisPosla(String opisPosla) {
        this.opisPosla = opisPosla;
    }

    public String getUkupnoSatiRadnogDana() {
        return ukupnoSatiRadnogDana;
    }

    public void setUkupnoSatiRadnogDana(String ukupnoSatiRadnogDana) {
        this.ukupnoSatiRadnogDana = ukupnoSatiRadnogDana;
    }
}
