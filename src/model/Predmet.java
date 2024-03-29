//#predmet
//Reference:
//Projekat MVCExample

package model;

import java.io.Serializable;
import java.util.List;

public class Predmet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3796665093730540570L;

	public enum Semestar {
		LETNJI, ZIMSKI
	};

	private String sifraPredmeta;
	private String nazivPredmeta;
	private Semestar semestar;
	private int godinaIzvodjenja;
	private Profesor predmetniProfesor;
	private int ESPB;
	private List<Student> studentiPolozili;
	private List<Student> studentiNisuPolozili;

	public Predmet() {
	}

	public Predmet(String sifraPredmeta, String nazivPredmeta, Semestar semestar, int godinaIzvodjenja,
			Profesor predmetniProfesor, int ESPB) {

		super();
		this.sifraPredmeta = sifraPredmeta;
		this.nazivPredmeta = nazivPredmeta;
		this.semestar = semestar;
		this.godinaIzvodjenja = godinaIzvodjenja;
		this.predmetniProfesor = predmetniProfesor;
		this.ESPB = ESPB;

	}

	public Predmet(String sifraPredmeta, String nazivPredmeta, Semestar semestar, int godinaIzvodjenja,
			Profesor predmetniProfesor, int eSPB, List<Student> studentiPolozili, List<Student> studentiNisuPolozili) {
		super();
		this.sifraPredmeta = sifraPredmeta;
		this.nazivPredmeta = nazivPredmeta;
		this.semestar = semestar;
		this.godinaIzvodjenja = godinaIzvodjenja;
		this.predmetniProfesor = predmetniProfesor;
		ESPB = eSPB;
		this.studentiPolozili = studentiPolozili;
		this.studentiNisuPolozili = studentiNisuPolozili;
	}

	public Predmet(Predmet p) {

		super();

		this.sifraPredmeta = p.getSifraPredmeta();
		this.nazivPredmeta = p.getNazivPredmeta();
		this.semestar = p.getSemestarE();
		this.godinaIzvodjenja = p.getGodinaIzvodjenja();
		this.predmetniProfesor = p.getPredmetniProfesor();
		ESPB = p.getESPB();
		this.studentiPolozili = p.getStudentiPolozili();
		this.studentiNisuPolozili = p.getStudentiNisuPolozili();

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

		if (semestar == Semestar.LETNJI) {
			return "Letnji";
		}

		return "Zimski";
	}

	public Semestar getSemestarE() {
		return semestar;
	}

	public void setSemestar(Semestar semestar) {
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

	public List<Student> getStudentiPolozili() {
		return studentiPolozili;
	}

	public void setStudentiPolozili(List<Student> studentiPolozili) {
		this.studentiPolozili = studentiPolozili;
	}

	public List<Student> getStudentiNisuPolozili() {
		return studentiNisuPolozili;
	}

	public void setStudentiNisuPolozili(List<Student> studentiNisuPolozili) {
		this.studentiNisuPolozili = studentiNisuPolozili;
	}
	

}
