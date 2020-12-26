//#ocena
package model;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ocena {

	private Student student;
	private Predmet predmet;
	private int ocena;
	private Date datum;
	
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
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(datum);
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	
	public Ocena(Student student, Predmet predmet, int ocena, String datum2) {
		super();
		this.student = student;
		this.predmet = predmet;
		this.ocena = ocena;

		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			this.datum = dateFormat.parse(datum2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	
}
