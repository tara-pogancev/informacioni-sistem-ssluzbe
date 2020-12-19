//#profesor
package model;

public class Profesor {
	
	private String prezime;
	private String ime;
	private String datumRodjenja;
	private String adresaStanovanja;
	private String kontaktTelefon;
	private String emailAdresa;
	private String adresaKancelarije;
	private String brojLicneKarte;
	private String titula;
	private String zvanje;

	
	public Profesor() {}
	
	public Profesor(String prezime, String ime, String datumRodjenja, String adresaStanovanja, String kontaktTelefon,
			String emailAdresa, String adresaKancelarije, String brojLicneKarte, String titula, String zvanje) {
		super();
		
		this.prezime = prezime;
		this.ime = ime;
		this.datumRodjenja = datumRodjenja;
		this.adresaStanovanja = adresaStanovanja;
		this.kontaktTelefon = kontaktTelefon;
		this.emailAdresa = emailAdresa;
		this.adresaKancelarije = adresaKancelarije;
		this.brojLicneKarte = brojLicneKarte;
		this.titula = titula;
		this.zvanje = zvanje;
		
		
	}
	
	public String getPrezime() {
		return prezime;
	}
	
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	
	public String getIme() {
		return ime;
	}
	
	public void setIme(String ime) {
		this.ime = ime;
	}
	
	public String getDatumRodjenja() {
		return datumRodjenja;
	}
	
	public void setDatumRodjenja(String datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}
	
	public String getAdresaStanovanja() {
		return adresaStanovanja;
	}
	
	public void setAdresaStanovanja(String adresaStanovanja) {
		this.adresaStanovanja = adresaStanovanja;
	}
	
	public String getKontaktTelefon() {
		return kontaktTelefon;
	}
	
	public void setKontaktTelefon(String kontaktTelefon) {
		this.kontaktTelefon = kontaktTelefon;
	}
	
	public String getEmailAdresa() {
		return emailAdresa;
	}
	
	public void setEmailAdresa(String emailAdresa) {
		this.emailAdresa = emailAdresa;
	}
	
	public String getAdresaKancelarije() {
		return adresaKancelarije;
	}
	
	public void setAdresaKancelarije(String adresaKancelarije) {
		this.adresaKancelarije = adresaKancelarije;
	}
	
	public String getBrojLicneKarte() {
		return brojLicneKarte;
	}
	
	public void setBrojLicneKarte(String brojLicneKarte) {
		this.brojLicneKarte = brojLicneKarte;
	}
	
	public String getTitula() {
		return titula;
	}
	
	public void setTitula(String titula) {
		this.titula = titula;
	}
	
	public String getZvanje() {
		return zvanje;
	}
	
	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
	}

	
}
