// #prikaz_nepolozenih_ispita
// #uklanjanje_predmeta_sa_studenta
// #dodavanje_predmeta_studentu
// #upis_ocene

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
import gui.MainFrame;
import model.Student;
import view.AbstractTableModelNepolozeniIspiti;

public class StudentNepolozeni extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3980379718494142906L;
	
	static JTable nepolozeniIspiti = new JTable();
	private String idx;

	public StudentNepolozeni(Student s) {
		
		idx = s.getBrojIndeksa();
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel buttons = new JPanel();
		buttons.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));
		BoxLayout box = new BoxLayout(buttons, BoxLayout.X_AXIS);
		buttons.setLayout(box);
		
		JButton dodaj = new JButton(MainFrame.getInstance().resourceBundle.getString("btnDodaj"));
		dodaj.setPreferredSize(new Dimension(90,25));
		JButton obrisi = new JButton(MainFrame.getInstance().resourceBundle.getString("btnUkloni"));
		obrisi.setPreferredSize(new Dimension(90,25));
		JButton polaganje = new JButton(MainFrame.getInstance().resourceBundle.getString("btnPolaganje"));
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
		
		nepolozeniIspiti.getColumnModel().getColumn(1).setPreferredWidth(180);
		
		nepolozeniIspiti.getColumnModel().getColumn(0).setHeaderValue(MainFrame.getInstance().resourceBundle.getString("colSifraProj"));
		nepolozeniIspiti.getColumnModel().getColumn(1).setHeaderValue(MainFrame.getInstance().resourceBundle.getString("colNazivProj"));
		nepolozeniIspiti.getColumnModel().getColumn(2).setHeaderValue(MainFrame.getInstance().resourceBundle.getString("colESPB"));
		nepolozeniIspiti.getColumnModel().getColumn(3).setHeaderValue(MainFrame.getInstance().resourceBundle.getString("colGodPredm"));
		nepolozeniIspiti.getColumnModel().getColumn(4).setHeaderValue(MainFrame.getInstance().resourceBundle.getString("colSemestar"));
		
		dodaj.addActionListener( e-> {
			
			new DodajPredmetStudentu(s.getBrojIndeksa()).setVisible(true);
			azurirajPrikaz();
			
		});
		
		obrisi.addActionListener( e-> {
			
			if (nepolozeniIspiti.getSelectedRow() != -1) {
				
				Object[] choices = {MainFrame.getInstance().resourceBundle.getString("yesBtn"),MainFrame.getInstance().resourceBundle.getString("noBtn")};
				Object defaultChoice = choices[0];
				
				int id = JOptionPane.showOptionDialog(this,MainFrame.getInstance().resourceBundle.getString("potvrdaUkloniPredm"), MainFrame.getInstance().resourceBundle.getString("ukloniPredmet"),
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, choices, defaultChoice);
				if (id == JOptionPane.YES_OPTION) {
					
					String idPredmeta = (String) nepolozeniIspiti.getValueAt(nepolozeniIspiti.getSelectedRow(), 0);
					StudentController.getInstance().ukloniPredmet(s.getBrojIndeksa(), idPredmeta);

					azurirajPrikaz();
					
					
				}
				
			}
		});
		
		polaganje.addActionListener(e -> {
			
			if (nepolozeniIspiti.getSelectedRow() != -1) {
				
				String idPredmeta = (String) nepolozeniIspiti.getValueAt(nepolozeniIspiti.getSelectedRow(), 0);
				new UpisOcene(s.getBrojIndeksa(),idPredmeta).setVisible(true);
				azurirajPrikaz();
				StudentPolozeni.azuriraj();
			}
			
			
		});
		
				
		JScrollPane scrollPane = new JScrollPane(nepolozeniIspiti);
		azurirajPrikaz();
		
		this.setBorder(BorderFactory.createEmptyBorder(30, 30, 90, 30));
		this.add(buttons);
		this.add(scrollPane);
		
	}

	public static void azurirajPrikaz() {

		AbstractTableModelNepolozeniIspiti atmNepolozeni = (AbstractTableModelNepolozeniIspiti) nepolozeniIspiti.getModel();
		atmNepolozeni.fireTableDataChanged();
		
	}

	
}
