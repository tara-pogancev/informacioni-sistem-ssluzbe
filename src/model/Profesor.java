//#profesor
package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Profesor {

	public enum Titula {BSc,MSc, mr, dr, profDr, diplIng, prof};
	public enum Zvanje {saradnikUNastavi, asistent, asistentSaDoktoratom, docent,
						redovniProfesor, vanredniProfesor,profesorEmeritus,istrazivacPripravnik};
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

	public Profesor() {
	}

	public Profesor(String prezime, String ime, String datumRodjenjaS, String adresaStanovanja, String kontaktTelefon,
			String emailAdresa, String adresaKancelarije, String brojLicneKarte, Titula titula, Zvanje zvanje) {
		super();

		DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
		this.prezime = prezime;
		this.ime = ime;
		try {
			this.datumRodjenja = dateFormat.parse(datumRodjenjaS);	
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
		
	    DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");  
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

		switch(titula) {
		
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
		case diplIng:
			return "dip. inž.";
		default:
			return "prof.";
		
		}
	}

	public void setTitula(Titula titula) {
		this.titula = titula;
	}

	public String getZvanje() {
		
		switch(zvanje) {
		
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

	public void setZvanje(Zvanje zvanje) {
		this.zvanje = zvanje;
	}

	
	@Override
	public String toString() {
		
		DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");  
		System.out.println(ime + " " + prezime + " " + dateFormat.format(datumRodjenja) + " " + adresaStanovanja + " " + kontaktTelefon 
				+ " " + emailAdresa + " " + adresaKancelarije + " " +  brojLicneKarte + " " + getTitula() + " " + getZvanje());
		return super.toString();
	}
	
}
