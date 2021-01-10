//#profesor
//Reference:
//Projekat MVCExample
package model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Profesor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9111551716255474498L;


	public enum Titula {
		BSc, MSc, mr, dr, profDr, prof
	};

	public enum Zvanje {
		saradnikUNastavi, asistent, asistentSaDoktoratom, docent, redovniProfesor, vanredniProfesor, profesorEmeritus,
		istrazivacPripravnik
	};

	private String prezime;
	private String ime;
	private Date datumRodjenja;
	private String adresaStanovanja;
	private String kontaktTelefon;
	private String emailAdresa;
	private String adresaKancelarije;
	private String brojLicneKarte;
	private Titula titula;
	private Zvanje zvanje;
	private List<Predmet> predmeti;

	public Profesor() {
	}

	public Profesor(String prezime, String ime, String datumRodjenja, String adresaStanovanja, String kontaktTelefon,
			String emailAdresa, String adresaKancelarije, String brojLicneKarte, Titula titula, Zvanje zvanje) {
		super();

		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		this.prezime = prezime;
		this.ime = ime;
		try {
			this.datumRodjenja = dateFormat.parse(datumRodjenja);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.adresaStanovanja = adresaStanovanja;
		this.kontaktTelefon = kontaktTelefon;
		this.emailAdresa = emailAdresa;
		this.adresaKancelarije = adresaKancelarije;
		this.brojLicneKarte = brojLicneKarte;
		this.titula = titula;
		this.zvanje = zvanje;
		
		this.predmeti = new ArrayList<Predmet>();

	}

	public Profesor(String prezime, String ime, String datumRodjenja, String adresaStanovanja, String kontaktTelefon,
			String emailAdresa, String adresaKancelarije, String brojLicneKarte, Titula titula, Zvanje zvanje,
			List<Predmet> predmeti) {
		super();

		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		this.prezime = prezime;
		this.ime = ime;
		try {
			this.datumRodjenja = dateFormat.parse(datumRodjenja);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.adresaStanovanja = adresaStanovanja;
		this.kontaktTelefon = kontaktTelefon;
		this.emailAdresa = emailAdresa;
		this.adresaKancelarije = adresaKancelarije;
		this.brojLicneKarte = brojLicneKarte;
		this.titula = titula;
		this.zvanje = zvanje;
		this.predmeti = predmeti;
	}

	public Profesor(Profesor p) {

		super();

		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		this.prezime = p.getPrezime();
		this.ime = p.getIme();
		try {
			this.datumRodjenja = dateFormat.parse(p.getDatumRodjenjaString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.adresaStanovanja = p.getAdresaStanovanja();
		this.kontaktTelefon = p.getKontaktTelefon();
		this.emailAdresa = p.getEmailAdresa();
		this.adresaKancelarije = p.getAdresaKancelarije();
		this.brojLicneKarte = p.getBrojLicneKarte();
		this.titula = p.getTitulaE();
		this.zvanje = p.getZvanjeE();

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

	public Date getDatumRodjenja() {
		return datumRodjenja;
	}

	public String getDatumRodjenjaString() {

		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		return dateFormat.format(datumRodjenja);
	}

	public void setDatumRodjenja(Date datumRodjenja) {
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

		switch (titula) {

		case BSc:
			return "BSc";
		case MSc:
			return "MSc";
		case mr:
			return "mr";
		case dr:
			return "dr";
		case profDr:
			return "prof. dr";
		default:
			return "prof.";

		}
	}

	public Titula getTitulaE() {
		return titula;
	}

	public void setTitula(Titula titula) {
		this.titula = titula;
	}

	public String getZvanje() {

		switch (zvanje) {

		case saradnikUNastavi:
			return "saradnik u nastavi";
		case asistent:
			return "asistent";
		case asistentSaDoktoratom:
			return "asistent sa doktoratom";
		case docent:
			return "docent";
		case redovniProfesor:
			return "redovni profesor";
		case vanredniProfesor:
			return "vanredni prodesor";
		case profesorEmeritus:
			return "profesor emeritus";
		default:
			return "istazivac pripravnik";
		}
	}

	public Zvanje getZvanjeE() {
		return zvanje;
	}

	public void setZvanje(Zvanje zvanje) {
		this.zvanje = zvanje;
	}

	public List<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	@Override
	public String toString() {

		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		System.out.println(ime + " " + prezime + " " + dateFormat.format(datumRodjenja) + " " + adresaStanovanja + " "
				+ kontaktTelefon + " " + emailAdresa + " " + adresaKancelarije + " " + brojLicneKarte + " "
				+ getTitula() + " " + getZvanje());
		return super.toString();
	}


	public boolean equals(Profesor p) {
		
		if (this.getPrezime().equals(p.getPrezime()) && this.getIme().equals(p.getIme()) && this.getDatumRodjenjaString().equals(p.getDatumRodjenjaString()) && this.getAdresaStanovanja().equals(p.getAdresaStanovanja())
				&& this.getKontaktTelefon().equals(p.getKontaktTelefon())  && this.getEmailAdresa().equals(p.getEmailAdresa()) && this.getAdresaKancelarije().equals(p.getAdresaKancelarije())
				&& this.getBrojLicneKarte().equals(p.getBrojLicneKarte()) && this.getTitulaE().equals(p.getTitulaE()) && this.getZvanjeE().equals(p.getZvanjeE())) {
			return true;	
		}

		
		return false;
	}

}
