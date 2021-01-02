// #prikaz_predmeta
// Reference:
// Projekat JTableMVCSimple

package model;

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
		predmeti.add(new Predmet("F1", "Fizika", Semestar.LETNJI, 1, profesori.get(2), 9, polozili, nisuPolozili));
		predmeti.add(new Predmet("PR1", "Objektno programiranje", Semestar.ZIMSKI, 2, profesori.get(3), 8, polozili,
				nisuPolozili));
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
}
