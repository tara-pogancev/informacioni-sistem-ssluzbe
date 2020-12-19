// #profesor
package model;

import java.util.ArrayList;
import java.util.List;

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
		profesori.add(new Profesor("Kristina","Stojic","dr","Dekan"));
		profesori.add(new Profesor("Đorđe","Njegić","dr","Profesor"));
		profesori.add(new Profesor("Jelena","Hrnjak","dr","Profesor"));

	}
	
	public List<Profesor> getProfesori(){
		return profesori;
	}
	
	public void setProfesori(List<Profesor> profesori) {
		this.profesori=profesori;
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
		
		switch (column){
			
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

	
}
