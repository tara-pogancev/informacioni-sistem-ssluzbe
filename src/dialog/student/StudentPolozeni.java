// #prikaz_polozenih_ispita

// Reference:
// https://stackoverflow.com/questions/7378013/connect-a-list-of-objects-to-a-jtable/7379172
// https://www.tutorialspoint.com/how-to-change-each-column-width-of-a-jtable-in-java#:~:text=By%20default%20the%20width%20of,()%20method%20of%20JTable%20class.

package dialog.student;

import java.awt.Component;
import java.text.DecimalFormat;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;

import model.BazaPredmeta;
import model.Ocena;
import model.Predmet;
import model.Student;
import view.AbstractTableModelOcene;

public class StudentPolozeni extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6876346602333553775L;

	public StudentPolozeni(Student s) {
		
		//INIT OCENE
		List<Predmet> predmeti = BazaPredmeta.getInstance().getPredmeti();
		
		Ocena o1 = new Ocena(s, predmeti.get(1), 6, "12/02/2018");
		Ocena o2 = new Ocena(s, predmeti.get(2), 8, "03/04/2019");
		Ocena o3 = new Ocena(s, predmeti.get(3), 9, "30/01/2020");
		s.addOcena(o1);
		s.addOcena(o2);
		s.addOcena(o3);
				
		Border padding_panel = BorderFactory.createEmptyBorder(30, 30, 10, 30); // North, West, South, East
		Border padding_elements = BorderFactory.createEmptyBorder(0, 0, 15, 0); // North, West, South, East
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		//Elementi
		JButton ponisti = new JButton("Poništi ocenu");
		DecimalFormat df = new DecimalFormat("#.##");
		String pr = df.format(s.getProsek());
		JLabel prosek = new JLabel ("Prosečna ocena:     " + pr);
		JLabel espb = new JLabel ("Ukupno ESPB:     " + s.getEspb());
		
		
		//Tabela polozenih predmeta
		JTable polozeni_predmeti = new JTable();
		polozeni_predmeti.setModel(new AbstractTableModelOcene(s));
		polozeni_predmeti.getTableHeader().setReorderingAllowed(false);
		//polozeni_predmeti.setAutoCreateRowSorter(true);
		polozeni_predmeti.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		polozeni_predmeti.setColumnSelectionAllowed(false);
		polozeni_predmeti.setRowSelectionAllowed(true);
		
		polozeni_predmeti.getColumnModel().getColumn(0).setPreferredWidth(80);
		polozeni_predmeti.getColumnModel().getColumn(1).setPreferredWidth(180);
		
		JScrollPane scrollPane = new JScrollPane(polozeni_predmeti);
		
		//Paneli
		JPanel p1 = new JPanel ();
		p1.setBorder(padding_elements);
		p1.setLayout(new BoxLayout(p1, BoxLayout.X_AXIS));
		p1.add(ponisti);
		p1.add(Box.createHorizontalGlue());
		
		JPanel p2 = new JPanel ();
		p2.setBorder(padding_elements);
		p2.setLayout(new BoxLayout(p2, BoxLayout.X_AXIS));
		p2.add(Box.createHorizontalGlue());
		
		JPanel stavke = new JPanel();
		stavke.setLayout(new BoxLayout(stavke, BoxLayout.Y_AXIS));
		stavke.setBorder(padding_panel);
		prosek.setAlignmentX(Component.RIGHT_ALIGNMENT);
		espb.setAlignmentX(Component.RIGHT_ALIGNMENT);
		stavke.add(prosek);
		stavke.add(espb);

		
		p2.add(stavke);
		
		
		
		
		
		
		
		this.add(p1);
		this.add(scrollPane);
		this.add(p2);
		
		this.setBorder(padding_panel);
		
		
	}
	
}
