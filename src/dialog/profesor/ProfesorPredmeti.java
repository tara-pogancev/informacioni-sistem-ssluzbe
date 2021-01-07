// #profesor_predaje_predmete
// #uklanjanje_predmeta_sa_profesora
// #dodavanje_predmeta_profesoru

package dialog.profesor;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import controller.ProfesoriController;
import model.BazaPredmeta;
import model.Profesor;
import view.AbstractTableModelPredmetiProfesora;

public class ProfesorPredmeti extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8780426491062345772L;

	JTable predmeti = new JTable();
	String blc;

	public ProfesorPredmeti(Profesor p) {

		blc = p.getBrojLicneKarte();

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel buttons = new JPanel();
		buttons.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));
		BoxLayout box = new BoxLayout(buttons, BoxLayout.X_AXIS);
		buttons.setLayout(box);

		JButton dodaj = new JButton("Dodaj predmet");
		dodaj.setPreferredSize(new Dimension(120, 25));
		JButton ukloni = new JButton("Ukloni predmet");
		ukloni.setPreferredSize(new Dimension(120, 25));

		buttons.add(dodaj);
		buttons.add(Box.createHorizontalStrut(25));
		buttons.add(ukloni);
		buttons.add(Box.createHorizontalGlue());

		AbstractTableModelPredmetiProfesora atmPredmProf = new AbstractTableModelPredmetiProfesora(blc);
		predmeti.setModel(atmPredmProf);
		predmeti.setAutoCreateRowSorter(true);
		predmeti.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		predmeti.setColumnSelectionAllowed(false);
		predmeti.setRowSelectionAllowed(true);

		predmeti.getColumnModel().getColumn(1).setPreferredWidth(120);

		dodaj.addActionListener(e -> {

			DodajPredmet dp = new DodajPredmet(blc);
			dp.setVisible(true);
			azurirajPrikaz();
			
		});
		
		ukloni.addActionListener(e -> {

			if (predmeti.getSelectedRow() != -1) {

				Object[] choices = { "Da", "Ne" };
				Object defaultChoice = choices[0];

				int id = JOptionPane.showOptionDialog(this, "Da li ste sigurni da želite da uklonite predmet?",
						"Uklanjanje predmeta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, choices,
						defaultChoice);
				if (id == JOptionPane.YES_OPTION) {

					String idPredmeta = (String) predmeti.getValueAt(predmeti.getSelectedRow(), 0);
					BazaPredmeta.getInstance().findById(idPredmeta).setPredmetniProfesor(null);
					ProfesoriController.getInstance().ukloniPredmet(p.getBrojLicneKarte(), idPredmeta);
					
					azurirajPrikaz();

				}
			}
		});
		

		JScrollPane scrollPane = new JScrollPane(predmeti);
		azurirajPrikaz();

		this.setBorder(BorderFactory.createEmptyBorder(30, 30, 90, 30));
		this.add(buttons);
		this.add(scrollPane);

	}

	private void azurirajPrikaz() {

		AbstractTableModelPredmetiProfesora atmPredmProf = (AbstractTableModelPredmetiProfesora) predmeti.getModel();
		atmPredmProf.fireTableDataChanged();
		validate();

	}
}
