//Reference:
//Projekat JTableMVCSimple
//Projekat MVCExample

package controller;

import gui.MainFrame;
import model.BazaProfesora;
import model.Profesor;

public class ProfesoriController {
	
	private static ProfesoriController instance = null;
	
	public static ProfesoriController getInstance() {
		
		if(instance == null) {
			instance = new ProfesoriController();
		}
		return instance;
	}
	
	private ProfesoriController() {}
	
	public void dodajProfesora(Profesor p) {
		
		BazaProfesora.getInstance().dodajProfesora(p);
		MainFrame.getTabbedPane().azurirajProfesora();
	}

	public void izmeniProfesora(Profesor izmene, String brojLicneKarte) {
		
		BazaProfesora.getInstance().izmenaProfesora(izmene, brojLicneKarte);
		MainFrame.getTabbedPane().azurirajProfesora();
	}

}
