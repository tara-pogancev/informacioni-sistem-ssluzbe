// #prikaz_nepolozenih_ispita
// #uklanjanje_predmeta_sa_studenta
// #dodavanje_predmeta_studentu

package dialog.student;

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

import controller.StudentController;
import model.Student;
import view.AbstractTableModelNepolozeniIspiti;

public class StudentNepolozeni extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3980379718494142906L;
	
	JTable nepolozeniIspiti = new JTable();
	String idx;

	public StudentNepolozeni(Student s) {
		
		idx = s.getBrojIndeksa();
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel buttons = new JPanel();
		buttons.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));
		BoxLayout box = new BoxLayout(buttons, BoxLayout.X_AXIS);
		buttons.setLayout(box);
		
		JButton dodaj = new JButton("Dodaj");
		dodaj.setPreferredSize(new Dimension(90,25));
		JButton obrisi = new JButton("Ukloni");
		obrisi.setPreferredSize(new Dimension(90,25));
		JButton polaganje = new JButton("Polaganje");
		polaganje.setPreferredSize(new Dimension(90,25));
		
		buttons.add(dodaj);
		buttons.add(Box.createHorizontalStrut(10));
		buttons.add(obrisi);
		buttons.add(Box.createHorizontalStrut(10));
		buttons.add(polaganje);
		buttons.add(Box.createHorizontalGlue());
		
		AbstractTableModelNepolozeniIspiti atmNepolozeni = new AbstractTableModelNepolozeniIspiti(idx);
		nepolozeniIspiti.setModel(atmNepolozeni);
		nepolozeniIspiti.setAutoCreateRowSorter(true);
		nepolozeniIspiti.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		nepolozeniIspiti.setColumnSelectionAllowed(false);
		nepolozeniIspiti.setRowSelectionAllowed(true);
		nepolozeniIspiti.setColumnSelectionAllowed(false);
		nepolozeniIspiti.getTableHeader().setReorderingAllowed(false);
		nepolozeniIspiti.getColumnModel().getColumn(1).setPreferredWidth(120);
		
		dodaj.addActionListener( e-> {
			
			new DodajPredmetStudentu(s.getBrojIndeksa()).setVisible(true);
			azurirajPrikaz();
			
		});
		
		obrisi.addActionListener( e-> {
			
			if (nepolozeniIspiti.getSelectedRow() != -1) {
				
				Object[] choices = {"Da", "Ne"};
				Object defaultChoice = choices[0];
				
				int id = JOptionPane.showOptionDialog(this, "Da li ste sigurni da želite da uklonite predmet?", "Uklanjanje predmeta",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, choices, defaultChoice);
				if (id == JOptionPane.YES_OPTION) {
					
					String idPredmeta = (String) nepolozeniIspiti.getValueAt(nepolozeniIspiti.getSelectedRow(), 0);
					StudentController.getInstance().ukloniPredmet(s.getBrojIndeksa(), idPredmeta);

					azurirajPrikaz();
					
				}
				
			}
		});
		
				
		JScrollPane scrollPane = new JScrollPane(nepolozeniIspiti);
		azurirajPrikaz();
		
		this.setBorder(BorderFactory.createEmptyBorder(30, 30, 90, 30));
		this.add(buttons);
		this.add(scrollPane);
		
	}

	private void azurirajPrikaz() {

		AbstractTableModelNepolozeniIspiti atmNepolozeni = (AbstractTableModelNepolozeniIspiti) nepolozeniIspiti.getModel();
		atmNepolozeni.fireTableDataChanged();
		validate();
		
	}

	
}
