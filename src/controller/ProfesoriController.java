//#brisanje_profesora
//Reference:
//Projekat JTableMVCSimple
//Projekat MVCExample

package controller;

import javax.swing.JOptionPane;

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
	
	public void izbrisiProfesora(Profesor p) {
		
		Object[] choices = {"Da", "Ne"};
		Object defaultChoice = choices[0];
		
		int id = JOptionPane.showOptionDialog(MainFrame.getInstance(),
				"Da li ste sigurni da želite da obrišete profesora [" + p.getIme() + " " + p.getPrezime() + "]?",
				"Brisanje profesora", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, choices, defaultChoice);

		if (id == JOptionPane.YES_OPTION) {

			BazaProfesora.getInstance().izbrisiProfesora(p.getBrojLicneKarte());
			MainFrame.getTabbedPane().azurirajProfesora();
		}
	}

}
