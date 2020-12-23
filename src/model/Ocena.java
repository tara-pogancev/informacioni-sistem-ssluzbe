//#ocena
package model;

public class Ocena {

	private Student student;
	private Predmet predmet;
	private int ocena;
	private String datum;
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Predmet getPredmet() {
		return predmet;
	}
	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}
	public int getOcena() {
		return ocena;
	}
	public void setOcena(int ocena) {
		//Provera validnosti bice naknadno dodata
		this.ocena = ocena;
	}
	public String getDatum() {
		return datum;
	}
	public void setDatum(String datum) {
		this.datum = datum;
	}
	
	public Ocena(Student student, Predmet predmet, int ocena, String datum) {
		super();
		this.student = student;
		this.predmet = predmet;
		this.ocena = ocena;
		this.datum = datum;
	}
	
}
