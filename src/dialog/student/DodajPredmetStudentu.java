// #dodavanje_predmeta_studentu

package dialog.student;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

import controller.StudentController;
import gui.MainFrame;
import model.BazaPredmeta;
import model.BazaStudenata;
import model.Ocena;
import model.Predmet;
import model.Student;

public class DodajPredmetStudentu extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4747005924640984439L;

	private Student s;
	
	public DodajPredmetStudentu(String idx) {
			this.setTitle("Dodavanje predmeta");
			this.setResizable(false);
			this.setSize(300, 375);	// X, Y
					
			Border paddingForm = BorderFactory.createEmptyBorder(25, 25, 25, 25); // North, West, South, East
					
			JPanel panel = new JPanel();
			panel.setBorder(paddingForm);
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
			JPanel buttons = new JPanel();
			JButton accept = new JButton("Potvrdi");
			JButton decline = new JButton("Odustani");
			buttons.add(accept);
			buttons.add(decline);
			
			//Lista predmeta
			s = BazaStudenata.getInstance().getByIdx(idx);
			
			List<Predmet> predmeti = BazaPredmeta.getInstance().getPredmeti();
			List<Predmet> predmetiDostupni = new ArrayList<Predmet>();
			DefaultListModel<String> model = new DefaultListModel<String>();
			for(Predmet p : predmeti) {
				String naziv = p.getNazivPredmeta();
				if (predmetOdgovara(p))	{			
					model.addElement(naziv);
					predmetiDostupni.add(p);
				}
			}

			JList<String> list = new JList<String>(model);
			list.setSelectedIndex(0);
			
			if (predmetiDostupni.size() == 0) 
				accept.setEnabled(false);
			
			accept.addActionListener( e -> {
				
				int rbrPredmeta = list.getSelectedIndex();
				
				String sellectedId = predmetiDostupni.get(rbrPredmeta).getSifraPredmeta();
				Predmet sellected = BazaPredmeta.getInstance().findById(sellectedId);
				
				StudentController.getInstance().dodajPredmet(idx, sellected);
				
				this.dispose();
				
			});
			
			decline.addActionListener( e -> {
				
				this.dispose();
				
			});
			
			JScrollPane pane = new JScrollPane(list);
			pane.setPreferredSize(pane.getMaximumSize());
			
			panel.add(pane);
			panel.add(buttons);
			
			this.add(panel);

			this.setLocationRelativeTo(MainFrame.getInstance());
			this.setModal(true);
			
		}
	
	private boolean predmetOdgovara(Predmet p) {
		
		if (p.getGodinaIzvodjenja() > s.getTrenutnaGodina())
			return false;
		
		for (Ocena polozen : s.getOcene()) {
			if (polozen.getPredmet().getSifraPredmeta().equals(p.getSifraPredmeta()))
				return false;
		}
		
		for (Predmet nepolozen : s.getNepolozeniIspiti()) {
			if (nepolozen.getSifraPredmeta().equals(p.getSifraPredmeta()))
				return false;
		}
		
		
		return true;
	}
}
