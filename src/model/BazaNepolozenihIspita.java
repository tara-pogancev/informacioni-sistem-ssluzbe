// #prikaz_nepolozenih_predmeta

package model;

import java.util.ArrayList;
import java.util.List;

import gui.MainFrame;

public class BazaNepolozenihIspita {

	private static BazaNepolozenihIspita instance = null;

	public static BazaNepolozenihIspita getInstance() {

		if (instance == null) {

			instance = new BazaNepolozenihIspita();
		}

		return instance;
	}

	private List<Predmet> nepolozeni;
	private List<String> kolone;

	private BazaNepolozenihIspita() {

		inicijalizacijaNepolozenihPredmeta();

		this.kolone = new ArrayList<String>();
		this.kolone.add("Šifra predmeta");
		this.kolone.add("Naziv predmeta");
		this.kolone.add("ESPB");
		this.kolone.add("Godina studija");
		this.kolone.add("Semestar");

	}

	private void inicijalizacijaNepolozenihPredmeta() {

		this.nepolozeni = new ArrayList<Predmet>();

		Student s = MainFrame.getTabbedPane().getIzabraniStudent();
		try {
			for (Predmet p : s.getNepolozeniIspiti()) {
				nepolozeni.add(p);
			}
		} catch (NullPointerException e) {

		}
	}

	public List<Predmet> getNepolozeni(String idx) {
		
		this.nepolozeni = new ArrayList<Predmet>();

		Student s = BazaStudenata.getInstance().getByIdx(idx);
		
		try {
			for (Predmet p : s.getNepolozeniIspiti()) {
				nepolozeni.add(p);
			}
		} catch (NullPointerException e) {

		}
		
		return nepolozeni;
	}

	public void setNepolozeni(List<Predmet> nepolozeni) {
		this.nepolozeni = nepolozeni;
	}

	public int getColumnCount() {
		return 5;
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Predmet getRow(int rowIndex) {
		return this.nepolozeni.get(rowIndex);
	}

	public String getValueAt(int row, int column) {

		Predmet predmet = this.nepolozeni.get(row);

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
