package model;

public class Predmet {
	
	private String sifraPredmeta;
	private String nazivPredmeta;
	private String semestar; //Mozda prebaciti u enum
	private int godinaIzvodjenja;
	private Profesor predmetniProfesor;
	private int ESPB;
	//studenti
	
	public Predmet() {}
	
	public Predmet(String sifraPredmeta, String nazivPredmeta, String semestar, int godinaIzvodjenja, Profesor predmetniProfesor, int ESPB) {
		
		super();
		this.sifraPredmeta = sifraPredmeta;
		this.nazivPredmeta = nazivPredmeta;
		this.semestar = semestar;
		this.godinaIzvodjenja = godinaIzvodjenja;
		this.predmetniProfesor = predmetniProfesor;	
		this.ESPB = ESPB;
		
	}
	
	public String getSifraPredmeta() {
		return sifraPredmeta;
	}
	
	public void setSifraPredmeta(String sifraPredmeta) {
		this.sifraPredmeta = sifraPredmeta;
	}
	
	public String getNazivPredmeta() {
		return nazivPredmeta;
	}
	
	public void setNazivPredmeta(String nazivPredmeta) {
		this.nazivPredmeta = nazivPredmeta;
	}
	
	public String getSemestar() {
		return semestar;
	}
	
	public void setSemestar(String semestar) {
		this.semestar = semestar;
	}
	
	public int getGodinaIzvodjenja() {
		return godinaIzvodjenja;
	}
	
	public void setGodinaIzvodjenja(int godinaIzvodjenja) {
		this.godinaIzvodjenja = godinaIzvodjenja;
	}
	

	public Profesor getPredmetniProfesor() {
		return predmetniProfesor;
	}
	
	public void setPredmetniProfesor(Profesor predmetniProfesor) {
		this.predmetniProfesor = predmetniProfesor;
	}
	
	public int getESPB() {
		return ESPB;
	}
	
	public void setESPB(int ESPB) {
		this.ESPB = ESPB;
	}
}
