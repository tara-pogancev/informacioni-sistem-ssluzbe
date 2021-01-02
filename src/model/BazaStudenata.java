//#prikaz_studenata
//#brisanje_studenta
//#sortiranje_studenata
//
//Reference: Projekat JTableMVCSimple

package model;

import java.text.DecimalFormat;
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
		this.kolone.add("Index");
		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Godina studija");
		this.kolone.add("Status");
		this.kolone.add("Prosek");
		
	}

	private void initStudente() {
		this.studenti = new ArrayList<Student>();

		//Dodavnje studenata radi privremenog prikaza
		
		List<Ocena> ocene = new ArrayList<Ocena>();
		List<Predmet> predmeti = new ArrayList<Predmet>();
		
		studenti.add(new Student("Stojić", "Sofija", "18/05/1998", "Šekspirova 20",			 "0632485463", "ssofija@gmail.com", "ra-71-2017", 2017, 4, Status.B, 8.62, ocene, predmeti));
		studenti.add(new Student("Marković", "Filip", "20/02/1998", "Trifuna Dimića 14a",	 "0628421458", "filipm@uns.ac.rs", "it-135-2017", 2017, 4, Status.S, 6.23, ocene, predmeti));
		studenti.add(new Student("Brkić", "Milica", "17/01/1997", "Banatska 48",			 "0612549683", "mmmilicaa@gmail.com", "in-4-2016", 2016, 4, Status.B, 8.89, ocene, predmeti));
		studenti.add(new Student("Popov", "Vojin", "08/02/1999", "Dr Đorđa Jovanovića 158",	 "0601156584", "popov.vojin@gmail.com", "sq-26-2018", 2018, 3, Status.S, 7.42, ocene, predmeti));
		studenti.add(new Student("Kovačević", "Žarko", "17/08/1999", "Hajduk Veljkova 14/2", "0624546840", "kzarko99@yahoo.com", "gr-141-2018", 2018, 3, Status.S, 7.62, ocene, predmeti));
		studenti.add(new Student("Preić", "Ceca", "15/03/2000", "Bulevar cara Lazara 55/35", "0644564844", "cecaceca@gmail.com", "mp-223-2019", 2019, 2, Status.B, 9.63, ocene, predmeti));
		studenti.add(new Student("Andrejević", "Ankica", "03/06/2001", "Jozefa Marčoka 81",	 "0634445688", "ankicaa@uns.ac.rs", "pr-37-2020", 2020, 1, Status.B, 9.82, ocene, predmeti));
		
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
			DecimalFormat df = new DecimalFormat("#.##");
			String pr = df.format(student.getProsek());			
			return pr;
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
	
	public void izmeniStudenta(Student novo, String idx) {
		for (Student s : studenti) {
			if (s.getBrojIndeksa() == idx) {
				
				s.setIme(novo.getIme());
				s.setPrezime(novo.getPrezime());
				s.setDatumRodjenja(novo.getDatumRodjenja());
				s.setAdresaStanovanja(novo.getAdresaStanovanja());
				s.setKontaktTelefon(novo.getKontaktTelefon());
				s.setEmailAdresa(novo.getEmailAdresa());
				s.setBrojIndeksa(novo.getBrojIndeksa());
				s.setGodinaUpisa(novo.getGodinaUpisa());
				s.setTrenutnaGodina(novo.getTrenutnaGodina());
				s.setStatus(novo.getStatusEnum());
				
				return;
			}
		}
	
	}

	//Vraca TRUE ako je indeks jedinstven, a FALSE ako je vec u bazi
	public boolean isUnique(String idx) {
		
		for(Student s : studenti) {
			if (s.getBrojIndeksa().equals(idx))
				return false;
			
		}
		
		return true;
	}

	
	public Student getByIdx(String index) {
		for (Student s : studenti) {
			if(s.getBrojIndeksa() == index) {
				return s;
			}
		}
		return null;
	}
	
}
