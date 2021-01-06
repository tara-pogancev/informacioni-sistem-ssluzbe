// #prikaz_predmeta
// #dodavanje_predmeta
// #izmena_predmeta
// #ponistavanje_ocene
// #dodavanje_profesora_na_predmet
// #sortiranje_predmeta
//
// Reference:
// Projekat JTableMVCSimple

package model;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import model.Predmet.Semestar;

public class BazaPredmeta {

	private static BazaPredmeta instance = null;

	public static BazaPredmeta getInstance() {

		if (instance == null) {
			instance = new BazaPredmeta();
		}
		return instance;
	}

	private Profesor temp_profesor; // Polje radi pravilne izmene profesora
	private List<Predmet> predmeti;
	private List<String> kolone;

	private BazaPredmeta() {

		inicijalizacijaPredmeta();

		this.kolone = new ArrayList<String>();
		this.kolone.add("Šifra predmeta");
		this.kolone.add("Naziv predmeta");
		this.kolone.add("ESPB");
		this.kolone.add("Godina studija");
		this.kolone.add("Semestar");

	}

	private void inicijalizacijaPredmeta() {

		this.predmeti = new ArrayList<Predmet>();

		// privremeni profesori i studenti
		List<Profesor> profesori = BazaProfesora.getInstance().getProfesori();
		List<Student> nisuPolozili = new ArrayList<Student>();
		List<Student> polozili = new ArrayList<Student>();

		predmeti.add(new Predmet("MA2", "Matematička analiza 2", Semestar.ZIMSKI, 2, profesori.get(0), 9, polozili,
				nisuPolozili));
		predmeti.add(new Predmet("SE3", "OISISI", Semestar.ZIMSKI, 3, profesori.get(1), 6, polozili, nisuPolozili));
		predmeti.add(new Predmet("F1", "Fizika", Semestar.LETNJI, 1, null, 9, polozili, nisuPolozili));
		predmeti.add(new Predmet("PR1", "Objektno programiranje", Semestar.ZIMSKI, 2, profesori.get(0), 8, polozili,
				nisuPolozili));
		predmeti.add(new Predmet("E225", "Operativni sistemi", Semestar.LETNJI, 2, null, 8, polozili, nisuPolozili));
	}

	public List<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	public int getColumnCount() {
		return 5;
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Predmet getRow(int rowIndex) {
		return this.predmeti.get(rowIndex);
	}

	public String getValueAt(int row, int column) {

		Predmet predmet = this.predmeti.get(row);

		switch (column) {

		case 0:
			return predmet.getSifraPredmeta();
		case 1:
			return predmet.getNazivPredmeta();
		case 2:
			return Integer.toString(predmet.getESPB());
		case 3:
			return Integer.toString(predmet.getGodinaIzvodjenja());
		case 4:
			return predmet.getSemestar();
		default:
			return null;

		}
	}

	public void dodajPredmet(Predmet p) {
		this.predmeti.add(p);
	}

	public void izbrisiPredmet(String sifra) {

		for (Predmet p : predmeti) {
			if (p.getSifraPredmeta().equals(sifra)) {
				predmeti.remove(p);
				break;
			}
		}
	}

	// Vraca TRUE ako predmet ima jedinstvenu sifru, ili FALSE ako nema
	public boolean isUnique(String p) {

		for (Predmet predmet : predmeti) {
			if (predmet.getSifraPredmeta().equals(p))
				return false;
		}
		return true;

	}

	public void izmeniPredmet(Predmet promene, String sifra) {
		for (Predmet p : predmeti) {
			if (p.getSifraPredmeta().equals(sifra)) {

				p.setESPB(promene.getESPB());
				p.setNazivPredmeta(promene.getNazivPredmeta());
				p.setGodinaIzvodjenja(promene.getGodinaIzvodjenja());
				p.setSemestar(p.getSemestarE());
				p.setSifraPredmeta(promene.getSifraPredmeta());

				// TODO: Profesor
				p.setPredmetniProfesor(promene.getPredmetniProfesor());
			}
		}
	}

	public Predmet findById(String sifra) {
		for (Predmet p : predmeti) {
			if (p.getSifraPredmeta().equals(sifra)) {

				return p;

			}
		}
		return null;

	}

	public Profesor getTemp_profesor() {
		return temp_profesor;
	}

	public void setTemp_profesor(Profesor temp_profesor) {
		this.temp_profesor = temp_profesor;
	}

	public void saveDataPredmet() throws IOException {

		ObjectOutputStream oos = null;
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("predmeti.txt"));

		try {
			oos = new ObjectOutputStream(bos);

			for (Predmet p : predmeti) {
				oos.writeObject(p);
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

}
