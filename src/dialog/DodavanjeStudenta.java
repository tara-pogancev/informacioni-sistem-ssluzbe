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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Pattern;

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

import controller.StudentController;
import model.Student;
import model.Student.Status;


public class DodavanjeStudenta extends JDialog implements KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3978453336369063755L;

	public DodavanjeStudenta() {
		this.setTitle("Dodavanje studenta");
		this.setResizable(false);
		this.setSize(450, 500); // X, Y

		Border padding_form = BorderFactory.createEmptyBorder(25, 50, 10, 50); // North, West, South, East
		Border padding_buttons = BorderFactory.createEmptyBorder(20, 10, 15, 20);

		// Unos forme
		JPanel content = new JPanel();
		content.setLayout(new GridLayout(10, 2, 5, 10)); // row, col, hgap, vgap
		content.setBorder(padding_form);

		// Potrebni nizovi
		String[] finansiranje = { "Budžet", "Samofinansiranje" };
		String[] god_stud = { "I (prva)", "II (druga)", "III (treća)", "IV (Četvrta)" };

		// ELEMENTI FORME
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

		// Dodavanje komponenti forme
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
			if (!correctParams(t1.getText(), t2.getText(), t3.getText(), t4.getText(), t5.getText(), t6.getText(),
					t7.getText(), t8.getText())) 
				JOptionPane.showMessageDialog(this, "Niste popunili sva neophodna pojla!", "Upozorenje", JOptionPane.WARNING_MESSAGE);
			else {
				
				int godina_upisa_st = Integer.parseInt(t8.getText());
				
				int trenutna_godina = t9.getSelectedIndex() + 1;
				
				Status status_st = Status.B;
				if (t10.getSelectedIndex() == 1) status_st = Status.S;
				
				Student s = new Student(t1.getText(), t2.getText(), t3.getText(), t4.getText(), t5.getText(), t6.getText(), t7.getText(), godina_upisa_st, trenutna_godina, status_st);
				StudentController.getInstance().addStudent(s);
				
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

	private boolean correctParams(String t1, String t2, String t3, String t4, String t5, String t6, String t7,
			String t8) {
		
		boolean check1 = Pattern.matches("[A-ZČĆŽĐŠ][A-ZČĆŽĐŠa-zŠĐČĆŽ]+", t1);
		boolean check2 = Pattern.matches("[A-ZČĆŽĐŠ][A-ZČĆŽĐŠa-zŠĐČĆŽ]+", t2);
		boolean check3 = Pattern.matches("[0-9]{1,2}(/)[0-9]{1,2}(/)[0-9]{4,4}", t3);
		boolean check4 = (t4 != "");
		boolean check5 = Pattern.matches("[0-9]+", t5);
		boolean check6 = (t6 != "");
		boolean check7 = Pattern.matches("[A-Z]{2,3}[0-9]{1,3}/20[0-9]{2,2}", t7);
		boolean check8 = Pattern.matches("[0-9]{4,4}", t8);

		return (check1 && check2 && check3 && check4 && check5 && check6 && check7 && check8);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
		
	}

}
