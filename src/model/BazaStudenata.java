//#prikaz_studenata
//Reference: Projekat JTableMVCSimple
package model;

import java.util.ArrayList;
import java.util.List;

import model.Student.Status;

public class BazaStudenata {

	private static BazaStudenata instance = null;
	
	public static BazaStudenata getInstance() {
		if (instance == null ) {
			instance = new BazaStudenata();
		}
		return instance;
	}
		
	private List<Student> studenti;
	private List<String> kolone;
	
	private BazaStudenata() {

		initStudente();
		
		this.kolone = new ArrayList<String>();
		this.kolone.add("INDEX");
		this.kolone.add("IME");
		this.kolone.add("PREZIME");
		this.kolone.add("GODINA STUDIJA");
		this.kolone.add("STATUS");
		this.kolone.add("PROSEK");
		
	}

	private void initStudente() {
		this.studenti = new ArrayList<Student>();
		//Dodavnje studenata radi bilo cega
		studenti.add(new Student("Stojic", "Sofija", "20/2/1998", "Bulevar Cara Lazara 55", "062656565", "ssofija@gmail.com", "RA71/2017", 2017, 4, Status.B));
		studenti.add(new Student("Knezevic", "Anja", "20/2/1998", "Bulevar Cara Lazara 55", "062656565", "ssofija@gmail.com", "RA90/2016", 2017, 4, Status.S));
		studenti.add(new Student("Popov", "Ksenija", "20/2/1998", "Bulevar Cara Lazara 55", "062656565", "ssofija@gmail.com", "PSI40/2017", 2017, 4, Status.B));
	}
	
	public List<Student> getStudenti() {
		return studenti;
	}

	public void setStudenti(List<Student> studenti) {
		this.studenti = studenti;
	}

	public int getColumnCount() {
		return 6;
	}
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Student getRow(int rowIndex) {
		return this.studenti.get(rowIndex);
	}
	
	public String getValueAt(int row, int column) {
		Student student = this.studenti.get(row);
		switch (column) {
		case 0:
			return student.getBrojIndeksa();
		case 1:
			return student.getIme();
		case 2:
			return student.getPrezime();
		case 3:
			return Integer.toString(student.getTrenutnaGodina());
		case 4:
			return student.getStatus();
		case 5:
			return Float.toString(student.getProsek());
		case 6:
		default:
			return null;
		}
	}
	
	public void dodajStudenta(Student s) {
		this.studenti.add(s);
	}

	public void izbrisiStudenta(String index) {
		for (Student s : studenti) {
			if(s.getBrojIndeksa() == index) {
				studenti.remove(s);
				break;
			}
		}
		
	}
	
	public void izmeniStudenta(Student s) {
		//TODO implementirati
	
	}

	
	
	
	
}
