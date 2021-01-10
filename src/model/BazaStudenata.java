// #prikaz_studenata
// #brisanje_studenta
// #sortiranje_studenata
// #ponistavanje_ocene
// #prikaz_polozenih_ispita
// #prikaz_nepolozenih_ispita
// #serijalizacija
// #deserijalizacija
// #uklanjanje_predmeta_sa_studenta
//
// Reference: Projekat JTableMVCSimple

package model;

import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class BazaStudenata {

	private static BazaStudenata instance = null;

	public static BazaStudenata getInstance() {
		if (instance == null) {
			instance = new BazaStudenata();
		}
		return instance;
	}

	private List<Student> studenti;
	private List<String> kolone;

	private BazaStudenata() {
		

		this.studenti = new ArrayList<Student>();

		this.kolone = new ArrayList<String>();
		this.kolone.add("Index");
		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Godina studija");
		this.kolone.add("Status");
		this.kolone.add("Prosek");

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
			if (s.getBrojIndeksa() == index) {
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

	// Vraca TRUE ako je indeks jedinstven, a FALSE ako je vec u bazi
	public boolean isUnique(String idx) {

		for (Student s : studenti) {
			if (s.getBrojIndeksa().equals(idx))
				return false;

		}

		return true;
	}

	public Student getByIdx(String index) {
		for (Student s : studenti) {
			if (s.getBrojIndeksa().equals(index)) {
				return s;
			}
		}
		return null;
	}

	// Ponistavanje ocene
	public void ponistiOcenu(String student, Predmet p) {
		for (Student s : studenti) {
			if (s.getBrojIndeksa().equals(student))
				for (Ocena o : s.getOcene()) {
					if (o.getPredmet().getSifraPredmeta().equals(p.getSifraPredmeta())) {
						s.getOcene().remove(o);
						s.refreshProsek();
						s.refreshEspb();
						s.getNepolozeniIspiti().add(p);

						return;
					}
				}
		}
	}

	public void ukloniPredmet(String student, String p) {
		for (Student s : studenti) {
			if (s.getBrojIndeksa().equals(student)) {

				// if (s.getNepolozeniIspiti().remove(p)) System.out.println("obrisano");
				int i = 0;

				for (Predmet nepolozen : s.getNepolozeniIspiti()) {

					if (nepolozen.getSifraPredmeta().equals(p)) {
						s.getNepolozeniIspiti().remove(i);
						return;
					}

					i++;

				}
			}
		}
	}

	
	// Pomocna metoda za debagovanje
	public void ispisOcena(String idx) {

		for (Student student : studenti) {
			System.out.print("\n\n---" + student.getBrojIndeksa() + "  =?  " + idx + "---\n");
			for (Ocena o : student.getOcene())
				System.out.print(o.getPredmet().getNazivPredmeta() + "  ");
		}
	}

	public void saveDataStudent() throws IOException {

		ObjectOutputStream oos = null;
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("Studenti.txt"));

		try {
			oos = new ObjectOutputStream(bos);

			for (Student s : studenti) {
				oos.writeObject(s);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (oos != null) {
				try {
					oos.close();
				} catch (Exception e) {

					e.printStackTrace();
				}
			}
		}
	}
	
	public void readDataStudent(ObjectInputStream in) throws IOException, ClassNotFoundException {

		Student s = null;

		try {
			while ((s = (Student) in.readObject()) != null)
				studenti.add(s);
		} catch (EOFException e) {
			in.close();
		}

	}

	public void dodajPredmet(String student, Predmet p) {
		for (Student s : studenti) {
			if (s.getBrojIndeksa().equals(student)) {
				s.getNepolozeniIspiti().add(p);
				return;
			}

		}
	}


}
