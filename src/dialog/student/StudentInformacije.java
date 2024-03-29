package dialog.student;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
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

public class StudentInformacije extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7231920207752882662L;
	
	private Student staro = null;
	final Color ERROR_COLOR = new Color(237, 121, 121);
	Border incorrectInput = BorderFactory.createLineBorder(ERROR_COLOR, 2);

	public StudentInformacije(Student s) {

		Border paddingForm = BorderFactory.createEmptyBorder(30, 90, 10, 90); // North, West, South, East
		Border paddingButtons = BorderFactory.createEmptyBorder(20, 10, 30, 20);

		// Unos forme
		JPanel content = new JPanel();
		content.setLayout(new GridLayout(10, 2, 5, 10)); // row, col, hgap, vgap
		content.setBorder(paddingForm);

		//Parent string
		staro = new Student(s);
		
		// Potrebni nizovi
		String[] finansiranje = { MainFrame.getInstance().getResourceBundle().getString("newBoxBudzet"), MainFrame.getInstance().getResourceBundle().getString("newBoxSamofinansiranje") };
		String[] godStud = {MainFrame.getInstance().getResourceBundle().getString("newBoxPrva"), MainFrame.getInstance().getResourceBundle().getString("newBoxDruga"), 
				MainFrame.getInstance().getResourceBundle().getString("newBoxTreca"), MainFrame.getInstance().getResourceBundle().getString("newBoxCetvrta") };

		// ELEMENTI FORME
		JLabel l1 = new JLabel(MainFrame.getInstance().getResourceBundle().getString("newIme"));
		JTextField t1 = new JTextField(s.getIme());

		t1.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("ttIme"));

		JLabel l2 = new JLabel(MainFrame.getInstance().getResourceBundle().getString("newPrezime"));
		JTextField t2 = new JTextField(s.getPrezime());
		t2.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("ttPrz"));

		JLabel l3 = new JLabel(MainFrame.getInstance().getResourceBundle().getString("newDatumRodjenja"));
		JTextField t3 = new JTextField(s.getDatumRodjenjaString());
		t3.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("ttDatum"));

		JLabel l4 = new JLabel(MainFrame.getInstance().getResourceBundle().getString("newAdresaStanovanja"));
		JTextField t4 = new JTextField(s.getAdresaStanovanja());
		t4.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("ttAdresaS"));

		JLabel l5 = new JLabel(MainFrame.getInstance().getResourceBundle().getString("newBrojTelefona"));
		JTextField t5 = new JTextField(s.getKontaktTelefon());
		t5.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("ttBrojTel"));

		JLabel l6 = new JLabel(MainFrame.getInstance().getResourceBundle().getString("newEmail"));
		JTextField t6 = new JTextField(s.getEmailAdresa());
		t6.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("ttEmail"));

		JLabel l7 = new JLabel(MainFrame.getInstance().getResourceBundle().getString("newBrojInd"));
		JTextField t7 = new JTextField(s.getBrojIndeksa());
		t7.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("ttBrIdx"));

		JLabel l8 = new JLabel(MainFrame.getInstance().getResourceBundle().getString("newGodinaUpisa"));
		JTextField t8 = new JTextField(Integer.toString(s.getGodinaUpisa()));
		t8.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("ttGodUp"));

		JLabel l9 = new JLabel(MainFrame.getInstance().getResourceBundle().getString("newTrenutnaGodinaStudija"));
		JComboBox<String> t9 = new JComboBox<String>(godStud);
		t9.setSelectedIndex(s.getTrenutnaGodina()-1);

		JLabel l10 = new JLabel(MainFrame.getInstance().getResourceBundle().getString("newNacinFinansiranja"));
		JComboBox<String> t10 = new JComboBox<String>(finansiranje);

		if (s.getStatus().equals(MainFrame.getInstance().getResourceBundle().getString("newBoxBudzet"))) 
			t10.setSelectedIndex(0);
		else
			t10.setSelectedIndex(1);
		
		
		initData(staro, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10);

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

		JButton accept = new JButton(MainFrame.getInstance().getResourceBundle().getString("buttonPrihvati"));
		JButton decline = new JButton(MainFrame.getInstance().getResourceBundle().getString("buttonOdustani"));
		accept.setEnabled(false);

		decline.addActionListener(e -> {
			initData(staro, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10);
			validate(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, accept);
			JOptionPane.showMessageDialog(this, MainFrame.getInstance().getResourceBundle().getString("ponisteneIzmene"));
		});

		// KEY-LISTENERS
		KeyListener l = new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				validate(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, accept);
			}

			@Override
			public void keyTyped(KeyEvent arg0) {

			}

		};
		
		MouseListener m = new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				validate(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, accept);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				validate(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, accept);
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
		this.addMouseListener(m);

		accept.addActionListener(e -> {

			int godinaUpisaSt = Integer.parseInt(t8.getText());

			int trenutnaGodina = t9.getSelectedIndex() + 1;

			Status statusSt = Status.B;
			if (t10.getSelectedIndex() == 1)
				statusSt = Status.S;

			DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy.");
			Date datumRodjenja = null;
			boolean rodjenjeBool = true;
			try {
				datumRodjenja = dateFormat.parse(t3.getText());
				if (datumRodjenja.compareTo(dateFormat.parse("1.1.2004.")) > 0
						|| datumRodjenja.compareTo(dateFormat.parse("31.12.1900.")) < 0) {
					rodjenjeBool = false;
				}

			} catch (ParseException ex) {
				ex.printStackTrace();
			}

			Student novo = new Student(t2.getText(), t1.getText(), t3.getText(), t4.getText(), t5.getText(),
					t6.getText(), t7.getText(), godinaUpisaSt, trenutnaGodina, statusSt);

			if (!BazaStudenata.getInstance().isUnique(t7.getText()) && !s.getBrojIndeksa().equals( t7.getText())) {
				JOptionPane.showMessageDialog(this, MainFrame.getInstance().getResourceBundle().getString("studentPostoji"));
			}

			else if (godinaUpisaSt < 2000 || godinaUpisaSt > 2025) {
				JOptionPane.showMessageDialog(this, MainFrame.getInstance().getResourceBundle().getString("godUpisaNeValja"));
			}

			else if (!rodjenjeBool) {
				JOptionPane.showMessageDialog(this, MainFrame.getInstance().getResourceBundle().getString("datRodjNeValja"));
			}

			else {
				
				staro = new Student(novo);
				accept.setEnabled(false);
				
				StudentController.getInstance().izmeniStudenta(novo, s.getBrojIndeksa());
				JOptionPane.showMessageDialog(this, MainFrame.getInstance().getResourceBundle().getString("izmenjenStudent"));
				
			}

		});

		
		buttons.add(accept);
		buttons.add(Box.createHorizontalStrut(10));
		buttons.add(decline);
		buttons.setBorder(paddingButtons);
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(content);
		this.add(buttons);

	}
	
	private void initData (Student s, JTextField t1, JTextField t2, JTextField t3, JTextField t4, JTextField t5, JTextField t6, 
			JTextField t7, JTextField t8, JComboBox<String> t9, JComboBox<String> t10) {
		
		t1.setText(s.getIme());
		t2.setText(s.getPrezime());
		t3.setText(s.getDatumRodjenjaString());
		t4.setText(s.getAdresaStanovanja());
		t5.setText(s.getKontaktTelefon());
		t6.setText(s.getEmailAdresa());
		t7.setText(s.getBrojIndeksa());
		t8.setText(Integer.toString(s.getGodinaUpisa()));
		t9.setSelectedIndex(s.getTrenutnaGodina() - 1);
		
		switch (s.getStatus()) {
		case "Budžet":
			t10.setSelectedIndex(0);
			break;
		case "Samofinansiranje":
			t10.setSelectedIndex(1);
			break;
		}
			
		
	}
	
	private void validate (JTextField t1, JTextField t2, JTextField t3, JTextField t4, JTextField t5, JTextField t6, JTextField t7, JTextField t8, JComboBox<String> t9, JComboBox<String> t10, JButton accept) {
		
		boolean check1 = Pattern.matches("[A-ZČĆŽĐŠa-zšđčćž][A-ZČĆŽĐŠa-zšđčćž -]+", t1.getText());
		boolean check2 = Pattern.matches("[A-ZČĆŽĐŠa-zšđčćž][A-ZČĆŽĐŠa-zšđčćž -]+", t2.getText());
		boolean check3 = Pattern.matches("[0-9]{2,2}(.)[0-9]{2,2}(.)[0-9]{4,4}(.)", t3.getText());

		boolean check4 = (!t4.getText().isEmpty());
		boolean check5 = Pattern.matches("[0-9]{3,3}(/)[0-9]{3,4}(-)[0-9]{3,4}", t5.getText());
		boolean check6 = Pattern.matches("[a-z0-9.+-/_~]*[a-z0-9.+-/_~][@][a-z]+[.][a-z]+([a-z.]+[a-z])?",
				t6.getText());
		boolean check7 = (Pattern.matches("[A-Z]{2,2}( )[0-9]{1,3}[/][0-9]{4,4}", t7.getText())); // Unos iz specifikacije
		/*
		 * Za ogranicenje unosa indeksa, ostavljena je originalna forma, ista kao u
		 * specifikaciji iz razloga sto bi drugacija slobodna forma dovela do mogucnosti
		 * unosa nevalidnih indeksa, ili dozvolila veliku raznolikost formata koji
		 * odgovaraju. Po potrebi je moguce prosiriti prihvatanje dodatnih formata.
		 */
		boolean check8 = Pattern.matches("[0-9]{4,4}", t8.getText());
		
		//NIJE DOZVOLJENO AKO PROMENA NEMA
		if (check1 && check2 && check3 && check4 && check5 && check6 && check7 && check8) {
			Status statusSt = Status.B;
			if (t10.getSelectedIndex() == 1)
				statusSt = Status.S;
			
			int godinaUpisaSt = Integer.parseInt(t8.getText());
			int trenutnaGodina = t9.getSelectedIndex() + 1;
			
			Student novo = new Student(t2.getText(), t1.getText(), t3.getText(), t4.getText(), t5.getText(),
					t6.getText(), t7.getText(), godinaUpisaSt, trenutnaGodina, statusSt);
			if (novo.equals(staro)) {
				accept.setEnabled(false);
			} else	accept.setEnabled(true);
		}					
		else {
			accept.setEnabled(false);
		}

		// CRVENITI DEO KOJI NIJE DOBRO UKUCAN
		if (check1 || t1.getText().isEmpty()) {
			t1.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
		} else {
			t1.setBorder(incorrectInput);
		}

		if (check2 || t2.getText().isEmpty()) {
			t2.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
		} else {
			t2.setBorder(incorrectInput);
		}

		if (check3 || t3.getText().isEmpty()) {
			t3.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
		} else {
			t3.setBorder(incorrectInput);
		}

		if (check5 || t5.getText().isEmpty()) {
			t5.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
		} else {
			t5.setBorder(incorrectInput);
		}

		if (check6 || t6.getText().isEmpty()) {
			t6.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
		} else {
			t6.setBorder(incorrectInput);
		}

		if (check7 || t7.getText().isEmpty()) {
			t7.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
		} else {
			t7.setBorder(incorrectInput);
		}

		if (check8 || t8.getText().isEmpty()) {
			t8.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
		} else {
			t8.setBorder(incorrectInput);
		}
		
	}

}