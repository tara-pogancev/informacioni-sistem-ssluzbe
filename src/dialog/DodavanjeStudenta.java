// #dodavanje_studenta
//
// Reference:
// https://docs.oracle.com/javase/tutorial/uiswing/layout/spring.html
// https://docs.oracle.com/javase/7/docs/api/javax/swing/BoxLayout.html
// https://stackoverflow.com/questions/20596020/jcombobox-is-a-raw-type-references-to-generic-type-jcomboboxe-should-be-param
// https://www.tutorialspoint.com/how-to-close-jframe-on-the-click-of-a-button-in-java

package dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class DodavanjeStudenta extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3978453336369063755L;

	public DodavanjeStudenta() {
		this.setTitle("Dodavanje studenta");
		this.setResizable(false);
		this.setSize(450, 500);		// X, Y
		
		Border padding_form = BorderFactory.createEmptyBorder(25, 50, 10, 50);		// North, West, South, East
		Border padding_buttons = BorderFactory.createEmptyBorder(20, 10, 15, 20);

		//Unos forme
		JPanel content = new JPanel();
		content.setLayout(new GridLayout(10, 2, 5, 10));		//row, col, hgap, vgap
		content.setBorder(padding_form);
		
		//Potrebni nizovi
		String[] finansiranje = {"Budžet", "Samofinansiranje"};
		String[] god_stud = {"I (prva)", "II (druga)", "III (treća)", "IV (Četvrta)"};
		
		//ELEMENTI FORME	
		JLabel l1 = new JLabel("Ime*");
		JTextField t1 = new JTextField();
		
		JLabel l2 = new JLabel("Prezime*");
		JTextField t2 = new JTextField();
		
		JLabel l3 = new JLabel("Datum rođenja*");
		JTextField t3 = new JTextField();
		
		JLabel l4 = new JLabel("Adresa stanovanja*");
		JTextField t4 = new JTextField();
		
		JLabel l5 = new JLabel("Broj telefona*");
		JTextField t5 = new JTextField();
		
		JLabel l6 = new JLabel("E-mail adresa*");
		JTextField t6 = new JTextField();
		
		JLabel l7 = new JLabel("Broj indeksa*");
		JTextField t7 = new JTextField();
		
		JLabel l8 = new JLabel("Godina upisa");
		JTextField t8 = new JTextField();
		
		JLabel l9 = new JLabel("Trenutna godina studija*");
		JComboBox<String> t9 = new JComboBox<String>(god_stud);
		
		JLabel l10 = new JLabel("Način finansiranja*");
		JComboBox<String> t10 = new JComboBox<String>(finansiranje);
		
		//Dodavanje komponenti forme
		content.add(l1);
		content.add(t1);
		content.add(l2);
		content.add(t2);
		content.add(l3);
		content.add(t3);
		content.add(l4);
		content.add(t4);
		content.add(l5);
		content.add(t5);
		content.add(l6);
		content.add(t6);
		content.add(l7);
		content.add(t7);
		content.add(l8);
		content.add(t8);
		content.add(l9);
		content.add(t9);
		content.add(l10);
		content.add(t10);
			
		
		//BUTTONS
		JPanel buttons = new JPanel();
		buttons.setLayout(new FlowLayout());
		
		JButton accept = new JButton("Prihvati");
		JButton decline = new JButton("Odustani");
		
		decline.addActionListener( e -> {this.dispose();});
				
		accept.addActionListener(e -> {
			if (t1.getText().isEmpty() || t2.getText().isEmpty() || t3.getText().isEmpty() || t4.getText().isEmpty() || t5.getText().isEmpty() 
					|| t6.getText().isEmpty() || t7.getText().isEmpty() || t8.getText().isEmpty()) 
				JOptionPane.showMessageDialog(this, "Niste popunili sva neophodna pojla!", "Upozorenje", JOptionPane.WARNING_MESSAGE);
			else {
				System.out.println("Action: Dodavanje novog studenta");
				this.dispose();
			}
		
		});
		
		buttons.add(accept);
		buttons.add(Box.createHorizontalStrut(10));
		buttons.add(decline);
		buttons.setBorder(padding_buttons);
		
		this.add(content, BorderLayout.CENTER);
		this.add(buttons, BorderLayout.SOUTH);
		this.setLocationRelativeTo(null);
		this.setModal(true);
	}

}
