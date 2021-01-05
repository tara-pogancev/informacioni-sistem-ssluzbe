// #prikaz_profesora
//#brisanje_profesora
// #dodavanje_profesora
// #izmena_profesora
// Reference:
// Projekat JTableMVCSimple

package model;

import java.util.ArrayList;
import java.util.List;

import model.Profesor.Titula;
import model.Profesor.Zvanje;

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

		inicijalizacijaProfesora();

		this.kolone = new ArrayList<String>();
		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Titula");
		this.kolone.add("Zvanje");
	}

	private void inicijalizacijaProfesora() {

		this.profesori = new ArrayList<Profesor>();
		profesori.add(
				new Profesor("Stojic", "Kristina", "12/02/1999", "Pericka 12", "0653687596", "krisstojic@gmail.com",
						"Moja kancelarija 2", "995876258", Titula.mr, Zvanje.asistent, new ArrayList<Predmet>()));
		profesori.add(new Profesor("Njegić", "Đorđe", "05/09/1999", "Dositejeva 23", "0658469586",
				"djordjenjegic@gmail.com", "Moja kancelarija 1", "985632584", Titula.dr, Zvanje.redovniProfesor,
				new ArrayList<Predmet>()));
		profesori.add(new Profesor("Marković", "Predrag", "07/08/1985", "Kućanska 12", "+381638596958",
				"pedjica@uns.ac.rs", "Moja kancelarija 5", "965236985", Titula.profDr, Zvanje.profesorEmeritus,
				new ArrayList<Predmet>()));
		profesori.add(new Profesor("Anđelić", "Stevan", "25/12/1959", "Rimska 2", "0635985632", "andjeo.steva@yahoo.rs",
				"Moja kancelarija 4", "TT522587", Titula.BSc, Zvanje.docent, new ArrayList<Predmet>()));
		profesori.add(new Profesor("Vladić", "Marija", "12/10/1991", "Vladareva 15", "+381635269658",
				"marijavlada12@gmail.rs", "Moja kancelarija 9", "9965852AM", Titula.prof, Zvanje.saradnikUNastavi,
				new ArrayList<Predmet>()));
	}

	public List<Profesor> getProfesori() {
		return profesori;
	}

	public void setProfesori(List<Profesor> profesori) {
		this.profesori = profesori;
	}

	public int getColumnCount() {
		return 4;
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
			return profesor.getTitula();
		case 3:
			return profesor.getZvanje();
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

		Boolean povratna = true;

		for (Profesor p : profesori) {

			if (p.getBrojLicneKarte().equals(blc)) {
				povratna = false;
			}
		}

		return povratna;
	}

	public void izbrisiProfesora(String brlk) {
		for (Profesor p : profesori) {
			if (p.getBrojLicneKarte() == brlk) {
				profesori.remove(p);
				break;
			}
		}
	}

	public void initPredmeti(String blc) {

		List<Predmet> predmeti = BazaPredmeta.getInstance().getPredmeti();

		for (Profesor p : profesori) {
			if (p.getBrojLicneKarte().equals(blc)) {

				p.getPredmeti().add(predmeti.get(1));
				p.getPredmeti().add(predmeti.get(3));

				if (blc.equals("995876258")) {
					
					p.getPredmeti().add(predmeti.get(0));
				}
				
				return;
			}
			
			

		}
	}
}
