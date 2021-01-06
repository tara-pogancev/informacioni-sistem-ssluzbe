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
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.BazaPredmeta;
import model.BazaProfesora;
import model.Predmet;
import model.Profesor;

public class DodajPredmet extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5698936362275579254L;

	public DodajPredmet(String blc) {

		this.setTitle("Dodaj predmet");
		this.setResizable(false);
		this.setSize(400, 400);

		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		// Lista predmeta na kojima profesor ne predaje

		List<Predmet> sviPredmeti = BazaPredmeta.getInstance().getPredmeti();
		List<Predmet> profNePredaje = new ArrayList<Predmet>();
		Profesor p = BazaProfesora.getInstance().nadjiBlc(blc);

		for (Predmet pr : sviPredmeti) {

			if (pr.getPredmetniProfesor() == null) {

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

		JButton potvrdi = new JButton("Potvrdi");
		JButton odustani = new JButton("Odustani");

		buttons.add(Box.createHorizontalGlue());
		buttons.add(potvrdi);
		buttons.add(Box.createHorizontalStrut(10));
		buttons.add(odustani);

		odustani.addActionListener(e -> {

			this.dispose();

		});

		panel.add(scrollPane);
		panel.add(buttons);

		this.add(panel);

		this.setLocationRelativeTo(rootPane);
		this.setModal(true);
	}

}
