// #prikaz_profesora
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
		profesori.add(new Profesor("Stojic","Kristina", "12/02/1999","Pericka 12","0653687596","krisstojic@gmail.com","Moja kancelarija 2","995876258",Titula.mr,Zvanje.asistent));
		profesori.add(new Profesor("Njegić","Đorđe", "05/09/1999","Dositejeva 23","0658469586","djordjenjegic@gmail.com","Moja kancelarija 1","985632584",Titula.dr,Zvanje.redovniProfesor));

	}


	public void setProfesori(List<Profesor> profesori) {
		this.profesori = profesori;
	}

	public List<Profesor> getProfesori() {
		return profesori;
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

}
