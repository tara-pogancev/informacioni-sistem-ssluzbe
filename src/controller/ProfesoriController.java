// #dodavanje_profesora
// #dodavane_predmeta_profesoru
// #izmena_profesora
// #brisanje_profesora
// #profesor_predaje_predmete
// #sortiranje_profesora
// #uklanjanje_predmeta_sa_profesora
// Reference:
// Projekat JTableMVCSimple
// Projekat MVCExample

package controller;

import javax.swing.JOptionPane;

import gui.MainFrame;
import model.BazaProfesora;
import model.Profesor;

public class ProfesoriController {

	private static ProfesoriController instance = null;

	public static ProfesoriController getInstance() {

		if (instance == null) {
			instance = new ProfesoriController();
		}
		return instance;
	}

	private ProfesoriController() {
	}

	public void dodajProfesora(Profesor p) {

		BazaProfesora.getInstance().dodajProfesora(p);
		MainFrame.getTabbedPane().azurirajProfesora();
	}

	public void izmeniProfesora(Profesor izmene, String brojLicneKarte) {

		BazaProfesora.getInstance().izmenaProfesora(izmene, brojLicneKarte);
		MainFrame.getTabbedPane().azurirajProfesora();
	}

	public void izbrisiProfesora(String blc) {

		Object[] choices = {MainFrame.getInstance().resourceBundle.getString("yesBtn"), MainFrame.getInstance().resourceBundle.getString("noBtn")};
		Object defaultChoice = choices[0];

		Profesor p = BazaProfesora.getInstance().nadjiBlc(blc);

		int id = JOptionPane.showOptionDialog(MainFrame.getInstance(),
				MainFrame.getInstance().getResourceBundle().getString("deleteProfesorPoruka") + p.getIme() + " " + p.getPrezime() + "]?",
				MainFrame.getInstance().getResourceBundle().getString("obrisiProfesora"), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, choices,
				defaultChoice);

		if (id == JOptionPane.YES_OPTION) {

			BazaProfesora.getInstance().izbrisiProfesora(blc);
			MainFrame.getTabbedPane().azurirajProfesora();
		}
	}

	public void dodajPredmet(String blc, String sifra) {

		BazaProfesora.getInstance().dodajPredmet(blc, sifra);

		MainFrame.getTabbedPane().azurirajProfesora();

	}

	public void ukloniPredmet(String id, String p) {

		BazaProfesora.getInstance().ukloniPredmet(id, p);

		MainFrame.getTabbedPane().azurirajProfesora();

	}

}
