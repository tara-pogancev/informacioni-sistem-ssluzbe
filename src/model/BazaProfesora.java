// #prikaz_profesora
// #brisanje_profesora
// #dodavanje_profesora
// #izmena_profesora
// #profesor_predaje_predmete
// #dodavanje_predmeta_profesoru
// #sortiranje_profesora
// #serijalizacija
// #deserijalizacija
// #uklanjanje_predmeta_sa_profesora
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

import gui.MainFrame;

public class BazaProfesora {

	private static BazaProfesora instance = null;

	public static BazaProfesora getInstance() {

		if (instance == null) {
			instance = new BazaProfesora();
		}
		return instance;
	}

	private List<Profesor> profesori;
	private List<String> kolone;

	private BazaProfesora() {

		this.profesori = new ArrayList<Profesor>();

		this.kolone = new ArrayList<String>();
		this.kolone.add(MainFrame.getInstance().resourceBundle.getString("colName"));
		this.kolone.add(MainFrame.getInstance().resourceBundle.getString("colSurname"));
		this.kolone.add(MainFrame.getInstance().resourceBundle.getString("colTitula"));
		this.kolone.add(MainFrame.getInstance().resourceBundle.getString("colZvanje"));
		this.kolone.add("Blc");
	}

	public List<Profesor> getProfesori() {
		return profesori;
	}

	public void setProfesori(List<Profesor> profesori) {
		this.profesori = profesori;
	}

	public int getColumnCount() {
		return 5;
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Profesor getRow(int rowIndex) {
		return this.profesori.get(rowIndex);
	}

	public String getValueAt(int row, int column) {

		Profesor profesor = this.profesori.get(row);

		switch (column) {

		case 0:
			return profesor.getIme();
		case 1:
			return profesor.getPrezime();
		case 2:
			switch (profesor.getTitulaE()) {

			case BSc:
				return MainFrame.getInstance().getResourceBundle().getString("newBoxBSc");

			case MSc:
				return MainFrame.getInstance().getResourceBundle().getString("newBoxMSc");

			case mr:
				return MainFrame.getInstance().getResourceBundle().getString("newBoxMr");

			case dr:
				return MainFrame.getInstance().getResourceBundle().getString("newBoxDr");

			case profDr:
				return MainFrame.getInstance().getResourceBundle().getString("newBoxProfDr");

			default:
				return MainFrame.getInstance().getResourceBundle().getString("newBoxProf");

			}
		case 3:
			switch (profesor.getZvanjeE()) {
			case saradnikUNastavi:
				return MainFrame.getInstance().getResourceBundle().getString("newBoxSaradnik");
			case asistent:
				return MainFrame.getInstance().getResourceBundle().getString("newBoxAsistent");
			case asistentSaDoktoratom:
				return MainFrame.getInstance().getResourceBundle().getString("newBoxAsistentSaDoktoratom");
			case docent:
				return MainFrame.getInstance().getResourceBundle().getString("newBoxDocent");
			case redovniProfesor:
				return MainFrame.getInstance().getResourceBundle().getString("newBoxRedovni");
			case vanredniProfesor:
				return MainFrame.getInstance().getResourceBundle().getString("newBoxVanredni");
			case profesorEmeritus:
				return MainFrame.getInstance().getResourceBundle().getString("newBoxEmeritus");
			default:
				return MainFrame.getInstance().getResourceBundle().getString("newBoxIstrazivas");
			}
		case 4:
			return profesor.getBrojLicneKarte();
		default:
			return null;

		}

	}

	public void dodajProfesora(Profesor p) {

		this.profesori.add(p);
	}

	public void izmenaProfesora(Profesor izmenjen, String blc) {

		for (Profesor p : profesori) {

			if (p.getBrojLicneKarte() == blc) {

				p.setPrezime(izmenjen.getPrezime());
				p.setIme(izmenjen.getIme());
				p.setDatumRodjenja(izmenjen.getDatumRodjenja());
				p.setAdresaStanovanja(izmenjen.getAdresaStanovanja());
				p.setKontaktTelefon(izmenjen.getKontaktTelefon());
				p.setEmailAdresa(izmenjen.getEmailAdresa());
				p.setAdresaKancelarije(izmenjen.getAdresaKancelarije());
				p.setBrojLicneKarte(izmenjen.getBrojLicneKarte());
				p.setTitula(izmenjen.getTitulaE());
				p.setZvanje(izmenjen.getZvanjeE());
				return;

			}

		}

	}

	public Profesor nadjiBlc(String blc) {

		for (Profesor p : profesori) {

			if (p.getBrojLicneKarte() == blc) {
				return p;
			}
		}
		return null;
	}

	public boolean proveraJedinstvenostiBlc(String blc) {

		Boolean povratna = false;

		for (Profesor p : profesori) {

			if (p.getBrojLicneKarte().equals(blc)) {
				povratna = true;
			}
		}

		return povratna;
	}

	public void izbrisiProfesora(String brlk) {

		List<Predmet> predmeti = BazaPredmeta.getInstance().getPredmeti();

		for (Profesor p : profesori) {
			if (p.getBrojLicneKarte() == brlk) {

				for (Predmet predmet : predmeti) {
					if (predmet.getPredmetniProfesor() != null)
						if (predmet.getPredmetniProfesor().getBrojLicneKarte().equals(brlk)) {
							predmet.setPredmetniProfesor(null);
						}
				}

				profesori.remove(p);
				break;
			}
		}
	}

	public void saveDataProfesor() throws IOException {

		ObjectOutputStream oos = null;
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("profesori.txt"));

		try {
			oos = new ObjectOutputStream(bos);

			for (Profesor p : profesori) {
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

	public void dodajPredmet(String blc, String sifra) {

		List<Predmet> predmeti = BazaPredmeta.getInstance().getPredmeti();

		for (Profesor p : profesori) {

			if (p.getBrojLicneKarte().equals(blc)) {

				for (Predmet prProf : predmeti) {

					if (prProf.getSifraPredmeta().equals(sifra)) {

						p.getPredmeti().add(prProf);

						return;
					}
				}
			}
		}
	}

	public void ukloniPredmet(String blc, String sifra) {

		for (Profesor p : profesori) {

			if (p.getBrojLicneKarte().equals(blc)) {

				int i = 0;

				for (Predmet prProf : p.getPredmeti()) {

					if (prProf.getSifraPredmeta().equals(sifra)) {

						p.getPredmeti().remove(i);

						return;
					}
				}
			}
		}

	}

	public void readDataProfesor(ObjectInputStream in) throws IOException, ClassNotFoundException {

		Profesor p = null;

		try {
			while ((p = (Profesor) in.readObject()) != null)
				profesori.add(p);
		} catch (EOFException e) {
			in.close();
		}

	}

}
