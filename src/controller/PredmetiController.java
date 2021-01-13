/* #brisanje_predmeta
 * #dodavanje_predmeta
 * #izmena_predmeta
 * #sortiranje_predmeta
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

	public void izbrisiPredmet(String sifra) {

		Object[] izbor = { MainFrame.getInstance().resourceBundle.getString("yesBtn"), MainFrame.getInstance().resourceBundle.getString("noBtn") };
		Object defaultChoice = izbor[0];

		int potvrda = JOptionPane.showOptionDialog(MainFrame.getInstance(),
				MainFrame.getInstance().resourceBundle.getString("deletePredmetPoruka")  + sifra + "\"?",
				MainFrame.getInstance().resourceBundle.getString("ukloniPredmet"), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, izbor,
				defaultChoice);

		if (potvrda == JOptionPane.YES_OPTION) {

			BazaPredmeta.getInstance().izbrisiPredmet(sifra);

			MainFrame.getTabbedPane().azurirajPredmet();

		}
	}

	public void dodajPredmet(Predmet p) {
		BazaPredmeta.getInstance().dodajPredmet(p);
		MainFrame.getTabbedPane().azurirajPredmet();

	}

	public void izmeniPredmet(Predmet promene, String sifra) {

		BazaPredmeta.getInstance().izmeniPredmet(promene, sifra);
		MainFrame.getTabbedPane().azurirajPredmet();

	}

	public void ukloniNepolozenog(String idx,String sifra) {
		
		BazaPredmeta.getInstance().ukloniNepolozenog(idx,sifra);
		MainFrame.getTabbedPane().azurirajPredmet();
	}
	
	public void dodajPolozenog(String idx, String sifra) {
		
		BazaPredmeta.getInstance().dodajPolozenog(idx,sifra);
		MainFrame.getTabbedPane().azurirajPredmet();
	}
	
}
