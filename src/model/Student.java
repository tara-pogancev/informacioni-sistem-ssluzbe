//#student
// Reference:
// https://www.tutorialspoint.com/java/java_date_time.htm

package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Student {

	public enum Status {B, S};
	
	private String prezime;
	private String ime;
	private Date datumRodjenja;
	private String adresaStanovanja;
	private String kontaktTelefon;
	private String emailAdresa;
	private String brojIndeksa;
	private int godinaUpisa;
	private int trenutnaGodina;
	private Status status;
	private double prosek;
	private List<Ocena> ocene;
	private List<Predmet> nepolozeniIspiti;
	
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
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
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
	public String getBrojIndeksa() {
		return brojIndeksa;
	}
	public void setBrojIndeksa(String brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
	}
	public int getGodinaUpisa() {
		return godinaUpisa;
	}
	public void setGodinaUpisa(int godinaUpisa) {
		this.godinaUpisa = godinaUpisa;
	}
	public int getTrenutnaGodina() {
		return trenutnaGodina;
	}
	public void setTrenutnaGodina(int trenutnaGodina) {
		this.trenutnaGodina = trenutnaGodina;
	}
	public String getStatus() {
		if (this.status == Status.B) return "Budžet";
		return "Samofinansiranje";
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public double getProsek() {
		return prosek;
	}
	public void setProsek(double prosek) {
		this.prosek = prosek;
	}
	public List<Ocena> getOcene() {
		return ocene;
	}
	public void setOcene(List<Ocena> ocene) {
		this.ocene = ocene;
	}
	public List<Predmet> getNepolozeniIspiti() {
		return nepolozeniIspiti;
	}
	public void setNepolozeniIspiti(List<Predmet> nepolozeniIspiti) {
		this.nepolozeniIspiti = nepolozeniIspiti;
	}
	
	public Student(String prezime, String ime, String datumRodjenja, String adresaStanovanja, String kontaktTelefon,
			String emailAdresa, String brojIndeksa, int godinaUpisa, int trenutnaGodina, Status status) {
		super();
		this.prezime = prezime;
		this.ime = ime;
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			this.datumRodjenja = dateFormat.parse(datumRodjenja);
		} catch (ParseException e) {
			e.printStackTrace();
		}
				
		//System.out.println(this.datumRodjenja);
		
		this.adresaStanovanja = adresaStanovanja;
		this.kontaktTelefon = kontaktTelefon;
		this.emailAdresa = emailAdresa;
		this.brojIndeksa = brojIndeksa;
		this.godinaUpisa = godinaUpisa;
		this.trenutnaGodina = trenutnaGodina;
		this.status = status;
		this.prosek = 0;
	}
	
	public Student(String prezime, String ime, String datumRodjenja, String adresaStanovanja, String kontaktTelefon,
			String emailAdresa, String brojIndeksa, int godinaUpisa, int trenutnaGodina, Status status, double prosek,
			List<Ocena> ocene, List<Predmet> nepolozeniIspiti) {
		super();
		this.prezime = prezime;
		this.ime = ime;
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			this.datumRodjenja = dateFormat.parse(datumRodjenja);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		this.adresaStanovanja = adresaStanovanja;
		this.kontaktTelefon = kontaktTelefon;
		this.emailAdresa = emailAdresa;
		this.brojIndeksa = brojIndeksa;
		this.godinaUpisa = godinaUpisa;
		this.trenutnaGodina = trenutnaGodina;
		this.status = status;
		this.prosek = prosek;
		this.ocene = ocene;
		this.nepolozeniIspiti = nepolozeniIspiti;
	}
	//TODO Odraditi metode za ispite
	public void addOcena() {
		
	}
	
	public void addPredmet() {
		
	}
	
	
}
