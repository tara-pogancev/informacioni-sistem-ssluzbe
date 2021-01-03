// #dodavanje_studenta
//
// Reference:
// https://docs.oracle.com/javase/tutorial/uiswing/layout/spring.html
// https://docs.oracle.com/javase/7/docs/api/javax/swing/BoxLayout.html
// https://stackoverflow.com/questions/20596020/jcombobox-is-a-raw-type-references-to-generic-type-jcomboboxe-should-be-param
// https://www.tutorialspoint.com/how-to-close-jframe-on-the-click-of-a-button-in-java
// https://stackoverflow.com/questions/43475953/jtextfield-reset-border-to-system-default
// https://www.tutorialspoint.com/how-to-compare-two-dates-in-java#:~:text=In%20Java%2C%20two%20dates%20can,if%20date1%20is%20before%20date2.


package dialog;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import javax.swing.UIManager;
import javax.swing.border.Border;

import controller.StudentController;
import gui.MainFrame;
import model.BazaStudenata;
import model.Student;
import model.Student.Status;

public class DodavanjeStudenta extends JDialog {

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

		final Color ERROR_COLOR = new Color(237, 121, 121);
		Border incorrect_input = BorderFactory.createLineBorder(ERROR_COLOR, 2);
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

		t1.setToolTipText("e.g. Sofija");

		JLabel l2 = new JLabel("Prezime*");
		JTextField t2 = new JTextField();
		t2.setToolTipText("e.g. Brkić");

		JLabel l3 = new JLabel("Datum rođenja*");
		JTextField t3 = new JTextField();
		t3.setToolTipText("e.g. 01/01/1996");

		JLabel l4 = new JLabel("Adresa stanovanja*");
		JTextField t4 = new JTextField();
		t4.setToolTipText("e.g. Trifuna Dimića 14a");

		JLabel l5 = new JLabel("Broj telefona*");
		JTextField t5 = new JTextField();
		t5.setToolTipText("0621231231");

		JLabel l6 = new JLabel("E-mail adresa*");
		JTextField t6 = new JTextField();
		t6.setToolTipText("e.g. ime.prezime@gmail.com");

		JLabel l7 = new JLabel("Broj indeksa*");
		JTextField t7 = new JTextField();
		t7.setToolTipText("e.g. ra-100-2020");

		JLabel l8 = new JLabel("Godina upisa");
		JTextField t8 = new JTextField();
		t8.setToolTipText("e.g. 2020");

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

		// BUTTONS
		JPanel buttons = new JPanel();
		buttons.setLayout(new FlowLayout());

		JButton accept = new JButton("Prihvati");
		JButton decline = new JButton("Odustani");

		accept.setEnabled(false);
		decline.addActionListener(e -> {
			this.dispose();
		});

		KeyListener l = new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				boolean check1 = Pattern.matches("[A-ZČĆŽĐŠa-zšđčćž][A-ZČĆŽĐŠa-zšđčćž -]+", t1.getText());
				boolean check2 = Pattern.matches("[A-ZČĆŽĐŠa-zšđčćž][A-ZČĆŽĐŠa-zšđčćž -]+", t2.getText());
				boolean check3 = Pattern.matches("[0-9]{1,2}(/)[0-9]{1,2}(/)[0-9]{4,4}", t3.getText());

				boolean check4 = (!t4.getText().isEmpty());
				boolean check5 = Pattern.matches("[+]?[0-9]+", t5.getText());
				boolean check6 = Pattern.matches("[a-z0-9.+-/_~]*[a-z0-9.+-/_~][@][a-z]+[.][a-z]+([a-z.]+[a-z])?",
						t6.getText());
				// boolean check7 = (Pattern.matches("[A-Za-z]+[-/]?[0-9]+([-/]?[A-Za-z0-9])*",
				// t7.getText())); //Vrlo generican unos (wip)
				boolean check7 = (Pattern.matches("[a-z]{2,2}[-][0-9]{1,3}[-][0-9]{4,4}", t7.getText())); // Unos iz
																											// specifikacije

				/*
				 * Za ogranicenje unosa indeksa, ostavljena je originalna forma, ista kao u
				 * specifikaciji iz razloga sto bi drugacija slobodna forma dovela do mogucnosti
				 * unosa nevalidnih indeksa, ili dozvolila veliku raznolikost formata koji
				 * odgovaraju. Po potrebi je moguce prosiriti prihvatanje dodatnih formata.
				 */

				boolean check8 = Pattern.matches("[0-9]{4,4}", t8.getText());

				if (check1 && check2 && check3 && check4 && check5 && check6 && check7 && check8)
					accept.setEnabled(true);
				else {
					accept.setEnabled(false);
				}

				// CRVENITI DEO KOJI NIJE DOBRO UKUCAN
				if (check1 || t1.getText().isEmpty()) {
					t1.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
				} else {
					t1.setBorder(incorrect_input);
				}

				if (check2 || t2.getText().isEmpty()) {
					t2.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
				} else {
					t2.setBorder(incorrect_input);
				}

				if (check3 || t3.getText().isEmpty()) {
					t3.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
				} else {
					t3.setBorder(incorrect_input);
				}

				if (check5 || t5.getText().isEmpty()) {
					t5.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
				} else {
					t5.setBorder(incorrect_input);
				}

				if (check6 || t6.getText().isEmpty()) {
					t6.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
				} else {
					t6.setBorder(incorrect_input);
				}

				if (check7 || t7.getText().isEmpty()) {
					t7.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
				} else {
					t7.setBorder(incorrect_input);
				}

				if (check8 || t8.getText().isEmpty()) {
					t8.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
				} else {
					t8.setBorder(incorrect_input);
				}


			}

			@Override
			public void keyTyped(KeyEvent arg0) {

			}

		};

		// Dodavanje key listenera za sva polja
		t1.addKeyListener(l);
		t2.addKeyListener(l);
		t3.addKeyListener(l);
		t4.addKeyListener(l);
		t5.addKeyListener(l);
		t6.addKeyListener(l);
		t7.addKeyListener(l);
		t8.addKeyListener(l);

		accept.addActionListener(e -> {

			int godina_upisa_st = Integer.parseInt(t8.getText());

			int trenutna_godina = t9.getSelectedIndex() + 1;

			Status status_st = Status.B;
			if (t10.getSelectedIndex() == 1)
				status_st = Status.S;

			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date datumRodjenja = null;
			boolean rodjenje_bool = true;
			try {
				datumRodjenja = dateFormat.parse(t3.getText());
				if (datumRodjenja.compareTo(dateFormat.parse("1/1/2004")) > 0
						|| datumRodjenja.compareTo(dateFormat.parse("31/12/1900")) < 0) {
					rodjenje_bool = false;
				}

			} catch (ParseException ex) {
				ex.printStackTrace();
			}

			Student s = new Student(t2.getText(), t1.getText(), t3.getText(), t4.getText(), t5.getText(), t6.getText(),
					t7.getText(), godina_upisa_st, trenutna_godina, status_st);

			if (!BazaStudenata.getInstance().isUnique(t7.getText())) {
				JOptionPane.showMessageDialog(this, "Student sa ovim brojem indeksa je već u sistemu!");
			}

			else if (godina_upisa_st < 2000 || godina_upisa_st > 2025) {
				JOptionPane.showMessageDialog(this, "Godina upisa nije validna!");
			}

			else if (!rodjenje_bool) {
				JOptionPane.showMessageDialog(this, "Datum rođenja nije validan!");
			}
			
			else {

				StudentController.getInstance().addStudent(s);
				this.dispose();
				JOptionPane.showMessageDialog(this, "Student uspešno dodat!");
			}

		});

		buttons.add(accept);
		buttons.add(Box.createHorizontalStrut(10));
		buttons.add(decline);
		buttons.setBorder(padding_buttons);

		this.add(content, BorderLayout.CENTER);
		this.add(buttons, BorderLayout.SOUTH);
		this.setLocationRelativeTo(MainFrame.getInstance());
		this.setModal(true);
	}

}
