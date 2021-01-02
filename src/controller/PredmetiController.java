/* #brisanje_predmeta
	Reference:
	Projekat JTableMVCSimple
*/
package controller;

import javax.swing.JOptionPane;

import gui.MainFrame;
import model.BazaPredmeta;
import model.Predmet;

public class PredmetiController {

	private static PredmetiController instance = null;

	public static PredmetiController getInstance() {

		if (instance == null) {
			instance = new PredmetiController();
		}

		return instance;
	}

	private PredmetiController() {
	}

	public void izbrisiPredmet(Predmet p) {

		int potvrda = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da želite da obrišete predmet sa šifrom \"" + p.getSifraPredmeta() + "\"?",
				"Brisanje predmeta", JOptionPane.YES_NO_OPTION);
		
		if(potvrda == JOptionPane.YES_OPTION) {
			
			BazaPredmeta.getInstance().izbrisiPredmet(p.getSifraPredmeta());

			MainFrame.getTabbedPane().azurirajPredmet();
			
		}

		
	}

}
