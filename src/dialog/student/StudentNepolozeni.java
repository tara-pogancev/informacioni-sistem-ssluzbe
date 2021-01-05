//#prikaz_nepolozenih_ispita

package dialog.student;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

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
		JButton obrisi = new JButton("Obriši");
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
