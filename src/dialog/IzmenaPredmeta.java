// #izmena_predmeta
// #dodavanje_profesora_na_predmet
// #uklanjanje_profesora_sa_predmeta
//
// Reference: 
// https://stackoverflow.com/questions/16257125/creating-square-buttons-in-swing

package dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;

import controller.PredmetiController;
import controller.ProfesoriController;
import dialog.predmet.OdaberiProfesora;
import gui.MainFrame;
import model.BazaPredmeta;
import model.Predmet;
import model.Predmet.Semestar;
import model.Profesor;

public class IzmenaPredmeta extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5786169429923291047L;

	private Profesor noviProfesor = null;

	final Color ERROR_COLOR = new Color(237, 121, 121);
	Border incorrectInput = BorderFactory.createLineBorder(ERROR_COLOR, 2);

	public IzmenaPredmeta(Predmet p) {

		this.setTitle(MainFrame.getInstance().getResourceBundle().getString("izmenaPredm"));
		this.setResizable(false);
		this.setSize(550, 350); // X, Y

		Border paddingForm = BorderFactory.createEmptyBorder(25, 50, 10, 50); // North, West, South, East
		Border paddingButtons = BorderFactory.createEmptyBorder(20, 10, 15, 20);

		// Unos forme
		JPanel content = new JPanel();
		content.setLayout(new GridLayout(6, 2, 5, 10)); // row, col, hgap, vgap
		content.setBorder(paddingForm);

		// Potrebni nizovi
		String[] semestar = { MainFrame.getInstance().getResourceBundle().getString("boxZimski"), MainFrame.getInstance().getResourceBundle().getString("boxLetnji") };
		String[] godStud = {MainFrame.getInstance().getResourceBundle().getString("newBoxPrva"), MainFrame.getInstance().getResourceBundle().getString("newBoxDruga"), 
				MainFrame.getInstance().getResourceBundle().getString("newBoxTreca"), MainFrame.getInstance().getResourceBundle().getString("newBoxCetvrta") };

		// ELEMENTI FORME
		JLabel l1 = new JLabel(MainFrame.getInstance().getResourceBundle().getString("newSifra"));
		JTextField t1 = new JTextField(p.getSifraPredmeta());
		t1.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("ttSifra"));

		JLabel l2 = new JLabel(MainFrame.getInstance().getResourceBundle().getString("newNaziv"));
		JTextField t2 = new JTextField(p.getNazivPredmeta());
		t2.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("ttNazivPredm"));

		JLabel l3 = new JLabel(MainFrame.getInstance().getResourceBundle().getString("newESPB"));
		JTextField t3 = new JTextField(Integer.toString(p.getESPB()));
		t3.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("ttESPB"));

		JLabel l4 = new JLabel(MainFrame.getInstance().getResourceBundle().getString("newSemestar"));
		JComboBox<String> t4 = new JComboBox<String>(semestar);

		switch (p.getSemestarE()) {
		case LETNJI:
			t4.setSelectedIndex(1);
			break;
		case ZIMSKI:
			t4.setSelectedIndex(0);
			break;
		}

		JLabel l5 = new JLabel(MainFrame.getInstance().getResourceBundle().getString("newGodStud"));
		JComboBox<String> t5 = new JComboBox<String>(godStud);
		t5.setSelectedIndex(p.getGodinaIzvodjenja() - 1);

		// DODAVANJE PROFESORA KOMPONENTE
		noviProfesor = p.getPredmetniProfesor();

		JLabel l6 = new JLabel(MainFrame.getInstance().getResourceBundle().getString("predmetProf"));
		JTextField t6 = new JTextField("");
		t6.setEditable(false);

		if (p.getPredmetniProfesor() != null)
			t6.setText(p.getPredmetniProfesor().getIme() + " " + p.getPredmetniProfesor().getPrezime());

		String imepStaro = t6.getText();

		JButton add = new JButton();
		add.setIcon(new ImageIcon("images" + File.separator + "add.png"));
		add.setPreferredSize(new Dimension(25, 25));
		add.setFocusPainted(false);
		JButton rm = new JButton();
		rm.setIcon(new ImageIcon("images" + File.separator + "remove.png"));
		rm.setPreferredSize(new Dimension(25, 25));
		rm.setFocusPainted(false);

		JPanel profesor = new JPanel();
		profesor.setLayout(new BoxLayout(profesor, BoxLayout.X_AXIS));
		profesor.add(t6);
		profesor.add(Box.createRigidArea(new Dimension(8, 0)));
		profesor.add(add);
		profesor.add(Box.createRigidArea(new Dimension(8, 0)));
		profesor.add(rm);

		dodavanjeProfesora(add, rm, t6);

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
		content.add(profesor);

		// BUTTONS
		JPanel buttons = new JPanel();
		buttons.setLayout(new FlowLayout());

		JButton accept = new JButton(MainFrame.getInstance().getResourceBundle().getString("buttonPrihvati"));
		JButton decline = new JButton(MainFrame.getInstance().getResourceBundle().getString("buttonOdustani"));

		accept.setEnabled(false);
		decline.addActionListener(e -> {
			this.dispose();
		});

		// Akcije dugmica
		add.addActionListener(e -> {

			new OdaberiProfesora().setVisible(true);
			if (BazaPredmeta.getInstance().getTempProfesor() != null) {
				noviProfesor = BazaPredmeta.getInstance().getTempProfesor();
				t6.setText(noviProfesor.getIme() + " " + noviProfesor.getPrezime());
			}
			dodavanjeProfesora(add, rm, t6);
			validate(t1, t2, t3, t4, t5, t6, accept, p, imepStaro);

		});

		rm.addActionListener(e -> {

			Object[] izbor = {MainFrame.getInstance().resourceBundle.getString("yesBtn"), MainFrame.getInstance().resourceBundle.getString("noBtn")};
			Object defaultChoice = izbor[0];

			int potvrda = JOptionPane.showOptionDialog(this, MainFrame.getInstance().getResourceBundle().getString("ukloniProfesora"),
					MainFrame.getInstance().getResourceBundle().getString("ukloniProf"), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, izbor,
					defaultChoice);

			if (potvrda == JOptionPane.YES_OPTION) {

				noviProfesor = null;
				t6.setText("");
			}

			dodavanjeProfesora(add, rm, t6);
			validate(t1, t2, t3, t4, t5, t6, accept, p, imepStaro);

		});

		KeyListener l = new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				dodavanjeProfesora(add, rm, t6);
				validate(t1, t2, t3, t4, t5, t6, accept, p, imepStaro);
			}

			@Override
			public void keyTyped(KeyEvent arg0) {

			}

		};

		MouseListener m = new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				dodavanjeProfesora(add, rm, t6);
				validate(t1, t2, t3, t4, t5, t6, accept, p, imepStaro);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
			}

		};

		// Dodavanje key listenera za sva polja
		t1.addKeyListener(l);
		t2.addKeyListener(l);
		t3.addKeyListener(l);
		t4.addMouseListener(m);
		t5.addMouseListener(m);
		this.addMouseListener(m);

		accept.addActionListener(e -> {

			int espb = Integer.parseInt(t3.getText());

			int godina = t5.getSelectedIndex() + 1;

			Semestar sem1 = Semestar.ZIMSKI;
			if (t4.getSelectedIndex() == 1)
				sem1 = Semestar.LETNJI;

			Predmet novo = new Predmet(t1.getText(), t2.getText(), sem1, godina, noviProfesor, espb);

			if (!BazaPredmeta.getInstance().isUnique(t1.getText()) && !p.getSifraPredmeta().equals(t1.getText())) {
				JOptionPane.showMessageDialog(this, MainFrame.getInstance().getResourceBundle().getString("predmPostoji"));
			}

			else if (espb < 1 || espb > 20) {
				JOptionPane.showMessageDialog(this, MainFrame.getInstance().getResourceBundle().getString("ESPBNeValja"));
			}

			else {

				if (noviProfesor != null && p.getPredmetniProfesor() != null) {	//1. zamena profesora, oba su postojala
					
					if (!noviProfesor.getBrojLicneKarte().equals(p.getPredmetniProfesor().getBrojLicneKarte())) {
						ProfesoriController.getInstance().dodajPredmet(noviProfesor.getBrojLicneKarte(), novo.getSifraPredmeta());
						ProfesoriController.getInstance().ukloniPredmet(p.getPredmetniProfesor().getBrojLicneKarte(), p.getSifraPredmeta());
					} else {	
						
						//ProfesoriController.getInstance().dodajPredmet(noviProfesor.getBrojLicneKarte(), novo.getSifraPredmeta());
						
					}
					
				}
				
				else if (noviProfesor == null && p.getPredmetniProfesor() != null) {	//samo stari profesor vise ne predaje

						ProfesoriController.getInstance().ukloniPredmet(p.getPredmetniProfesor().getBrojLicneKarte(), p.getSifraPredmeta());

				} else if (noviProfesor != null && p.getPredmetniProfesor() == null){	//samo novi predaje, stari nije bio
					
					ProfesoriController.getInstance().dodajPredmet(noviProfesor.getBrojLicneKarte(), novo.getSifraPredmeta());
					
				}
				
				PredmetiController.getInstance().izmeniPredmet(novo, p.getSifraPredmeta());
				JOptionPane.showMessageDialog(this, MainFrame.getInstance().getResourceBundle().getString("izmenjenPredmet"));
				accept.setEnabled(false);
			}

		});

		buttons.add(accept);
		buttons.add(Box.createHorizontalStrut(10));
		buttons.add(decline);
		buttons.setBorder(paddingButtons);

		this.add(content, BorderLayout.CENTER);
		this.add(buttons, BorderLayout.SOUTH);
		this.setLocationRelativeTo(MainFrame.getInstance());
		this.setModal(true);
	}

	// Vraca TRUE ako su postojale promene u odnosu na otvaranje prozora ili
	// prihvatanje izmene, ili FALSE ukoliko nisu
	private Boolean isChanged(Predmet p1, Predmet p2) {

		if (p1.getESPB() == p2.getESPB() && p1.getSifraPredmeta().equals(p2.getSifraPredmeta())
				&& p1.getNazivPredmeta().equals(p2.getNazivPredmeta())
				&& p1.getGodinaIzvodjenja() == p2.getGodinaIzvodjenja() && p1.getSemestar().equals(p2.getSemestar()))
			return false;

		return true;

	}

	private void validate(JTextField t1, JTextField t2, JTextField t3, JComboBox<String> t4, JComboBox<String> t5,
			JTextField t6, JButton accept, Predmet p, String imepStaro) {

		boolean check1 = Pattern.matches("[a-z0-9]{1,8}", t1.getText());
		boolean check2 = Pattern.matches("[A-ZČĆŽĐŠa-zšđčćž][0-9A-ZČĆŽĐŠa-zšđčćž -]+", t2.getText());
		boolean check3 = Pattern.matches("[0-9]{1,2}", t3.getText());

		if (check1 && check2 && check3) {
			int espb = Integer.parseInt(t3.getText());

			int godina = t5.getSelectedIndex() + 1;

			Semestar sem = Semestar.ZIMSKI;
			if (t4.getSelectedIndex() == 1)
				sem = Semestar.LETNJI;
		
			Predmet temp = new Predmet(t1.getText(), t2.getText(), sem, godina, null, espb);
			String imepNovo = t6.getText();

			if (!isChanged(temp, p) && imepNovo.equals(imepStaro))
				accept.setEnabled(false);
			else
				accept.setEnabled(true);
		} else {

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

	}

	private void dodavanjeProfesora(JButton add, JButton remove, JTextField t) {

		if (!t.getText().isEmpty()) {

			// 1. PROFESOR NE POSTOJI

			add.setEnabled(false);
			remove.setEnabled(true);

		} else {

			// 2. PROFESOR POSOTJI

			add.setEnabled(true);
			remove.setEnabled(false);

		}
	}

}