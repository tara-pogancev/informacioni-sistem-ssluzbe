// #prikaz_predmeta
// #dodavanje_predmeta
// #izmena_predmeta
// #ponistavanje_ocene
// #dodavanje_profesora_na_predmet
// #sortiranje_predmeta
// #serijalizacija
// #deserijalizacija
//
// Reference:
// Projekat JTableMVCSimple

package model;

import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class BazaPredmeta {

	private static BazaPredmeta instance = null;

	public static BazaPredmeta getInstance() {

		if (instance == null) {
			instance = new BazaPredmeta();
		}
		return instance;
	}

	private Profesor tempProfesor; // Polje radi pravilne izmene profesora
	private List<Predmet> predmeti;
	private List<String> kolone;

	private BazaPredmeta() {
		
		this.predmeti = new ArrayList<Predmet>();

		this.kolone = new ArrayList<String>();
		this.kolone.add("Šifra predmeta");
		this.kolone.add("Naziv predmeta");
		this.kolone.add("ESPB");
		this.kolone.add("Godina studija");
		this.kolone.add("Semestar");

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

	public Object getValueAt(int row, int column) {

		Predmet predmet = this.predmeti.get(row);

		switch (column) {

		case 0:
			return predmet.getSifraPredmeta();
		case 1:
			return predmet.getNazivPredmeta();
		case 2:
			return predmet.getESPB(); //Integer.toString(predmet.getESPB());
		case 3:
			return predmet.getGodinaIzvodjenja(); //Integer.toString(predmet.getGodinaIzvodjenja());
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

	public Profesor getTempProfesor() {
		return tempProfesor;
	}

	public void setTempProfesor(Profesor tempProfesor) {
		this.tempProfesor = tempProfesor;
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
	
	
	public void readDataPredmet(ObjectInputStream in) throws IOException, ClassNotFoundException {

		Predmet p = null;

		try {
			while ((p = (Predmet) in.readObject()) != null)
				predmeti.add(p);
		} catch (EOFException e) {
			in.close();
		}

	}

}
