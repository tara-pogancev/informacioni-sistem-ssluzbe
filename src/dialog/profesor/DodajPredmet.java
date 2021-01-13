// #dodavanje_predmeta_profesoru

package dialog.profesor;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.ProfesoriController;
import gui.MainFrame;
import model.BazaPredmeta;
import model.BazaProfesora;
import model.Predmet;
import model.Profesor;

public class DodajPredmet extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5698936362275579254L;

	Predmet dodat = null;

	public DodajPredmet(String blc) {

		this.setTitle(MainFrame.getInstance().resourceBundle.getString("dodajPredmet"));
		this.setResizable(false);
		this.setSize(400, 400);

		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		// Lista predmeta na kojima profesor ne predaje

		List<Predmet> sviPredmeti = BazaPredmeta.getInstance().getPredmeti();
		List<Predmet> profNePredaje = new ArrayList<Predmet>();

		for (Predmet pr : sviPredmeti) {

			if (pr.getPredmetniProfesor() == null || !pr.getPredmetniProfesor().getBrojLicneKarte().equals(blc)) {

				profNePredaje.add(pr);
			}
		}

		DefaultListModel<String> model = new DefaultListModel<String>();

		for (Predmet predm : profNePredaje) {
			String ispis = predm.getSifraPredmeta() + " - " + predm.getNazivPredmeta();
			model.addElement(ispis);
		}

		JList<String> lista = new JList<String>(model);
		lista.setSelectedIndex(0);

		JScrollPane scrollPane = new JScrollPane(lista);
		scrollPane.setPreferredSize(scrollPane.getMaximumSize());

		JPanel buttons = new JPanel();
		buttons.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));
		BoxLayout box = new BoxLayout(buttons, BoxLayout.X_AXIS);
		buttons.setLayout(box);

		JButton potvrdi = new JButton(MainFrame.getInstance().resourceBundle.getString("buttonPrihvati"));
		JButton odustani = new JButton(MainFrame.getInstance().resourceBundle.getString("buttonOdustani"));


		buttons.add(Box.createHorizontalGlue());
		buttons.add(potvrdi);
		buttons.add(Box.createHorizontalStrut(10));
		buttons.add(odustani);

		// Profesor kom se dodaje predmet
		Profesor p = BazaProfesora.getInstance().nadjiBlc(blc);

		potvrdi.addActionListener(e -> {

			int indeksIzabranog = lista.getSelectedIndex();

			dodat = new Predmet(profNePredaje.get(indeksIzabranog));

			if (dodat.getPredmetniProfesor() != null) {

				Object[] izbor = { MainFrame.getInstance().resourceBundle.getString("yesBtn"),MainFrame.getInstance().resourceBundle.getString("noBtn")};
				Object defaultChoice = izbor[0];

				int potvrda = JOptionPane.showOptionDialog(rootPane,
						MainFrame.getInstance().resourceBundle.getString("dodajPredmetProf1")
								+ dodat.getPredmetniProfesor().getIme() + " "
								+ dodat.getPredmetniProfesor().getPrezime()
								+ MainFrame.getInstance().resourceBundle.getString("dodajPredmetProf2")
								+ dodat.getSifraPredmeta() + "\"?",
						MainFrame.getInstance().resourceBundle.getString("dodavanjePredm"), JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, izbor, defaultChoice);

				if (potvrda == JOptionPane.YES_OPTION) {

					ProfesoriController.getInstance().ukloniPredmet(dodat.getPredmetniProfesor().getBrojLicneKarte(),
							dodat.getSifraPredmeta());
					ProfesoriController.getInstance().dodajPredmet(blc, dodat.getSifraPredmeta());
					BazaPredmeta.getInstance().findById(dodat.getSifraPredmeta()).setPredmetniProfesor(p);
					JOptionPane.showMessageDialog(this, MainFrame.getInstance().resourceBundle.getString("dodatPredmet"));
					this.dispose();

				}
			} else {

				ProfesoriController.getInstance().dodajPredmet(blc, dodat.getSifraPredmeta());
				BazaPredmeta.getInstance().findById(dodat.getSifraPredmeta()).setPredmetniProfesor(p);
				JOptionPane.showMessageDialog(this, MainFrame.getInstance().resourceBundle.getString("dodatPredmet"));
				this.dispose();
			}

		});

		odustani.addActionListener(e -> {

			this.dispose();

		});

		panel.add(scrollPane);
		panel.add(buttons);

		this.add(panel);

		this.setLocationRelativeTo(rootPane);
		this.setModal(true);
	}

	public Predmet getDodatPredmet() {

		return dodat;
	}

}
