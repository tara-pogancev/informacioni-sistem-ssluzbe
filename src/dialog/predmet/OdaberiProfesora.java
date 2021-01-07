// #dodavanje_profesora_na_predmet
//
// Reference:
// https://stackoverflow.com/questions/6420623/how-to-bind-arraylist-to-jlist/16774255

package dialog.predmet;

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

import gui.MainFrame;
import model.BazaPredmeta;
import model.BazaProfesora;
import model.Profesor;

public class OdaberiProfesora extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4747005924640984439L;

	public OdaberiProfesora() {
		this.setTitle("Odaberi profesora");
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
		
		//Lista profesora
		List<Profesor> profesori = BazaProfesora.getInstance().getProfesori();
		DefaultListModel<String> model = new DefaultListModel<String>();
		for(Profesor profesor : profesori) {
			String ime = profesor.getIme() + " " + profesor.getPrezime();
			model.addElement(ime);
		}

		JList<String> list = new JList<String>(model);
		list.setSelectedIndex(0);
		
		if (profesori.size() == 0) 
			accept.setEnabled(false);
		
		accept.addActionListener( e -> {
			
			int idx = list.getSelectedIndex();
			
			Profesor temp = new Profesor(profesori.get(idx));
			BazaPredmeta.getInstance().setTempProfesor(temp);
			
			this.dispose();
			
		});
		
		decline.addActionListener( e -> {
			
			BazaPredmeta.getInstance().setTempProfesor(null);
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
}
