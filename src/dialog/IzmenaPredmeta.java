// #izmena_predmeta
// #dodavanje_profesora_na_predmet
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
import dialog.predmet.odaberiProfesora;
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
	Border incorrect_input = BorderFactory.createLineBorder(ERROR_COLOR, 2);
	
	public IzmenaPredmeta(Predmet p) {
		this.setTitle("Izmena predmeta");
		this.setResizable(false);
		this.setSize(550, 350); // X, Y

		Border padding_form = BorderFactory.createEmptyBorder(25, 50, 10, 50); // North, West, South, East
		Border padding_buttons = BorderFactory.createEmptyBorder(20, 10, 15, 20);

		// Unos forme
		JPanel content = new JPanel();
		content.setLayout(new GridLayout(6, 2, 5, 10)); // row, col, hgap, vgap
		content.setBorder(padding_form);

		// Potrebni nizovi
		String[] semestar = { "Zimski", "Letnji" };
		String[] god_stud = { "I (prva)", "II (druga)", "III (treća)", "IV (Četvrta)" };

		// ELEMENTI FORME
		JLabel l1 = new JLabel("Šifra*");
		JTextField t1 = new JTextField(p.getSifraPredmeta());
		t1.setToolTipText("e.g. E223A");

		JLabel l2 = new JLabel("Naziv*");
		JTextField t2 = new JTextField(p.getNazivPredmeta());
		t2.setToolTipText("e.g. Matematička analiza 2");

		JLabel l3 = new JLabel("ESPB");
		JTextField t3 = new JTextField(Integer.toString(p.getESPB()));
		t3.setToolTipText("e.g. 6");

		JLabel l4 = new JLabel("Semestar*");
		JComboBox<String> t4 = new JComboBox<String>(semestar);
		
		switch (p.getSemestarE()) {
		case LETNJI: 
			t4.setSelectedIndex(1);
			break;
		case ZIMSKI:
			t4.setSelectedIndex(0);
			break;
		}

		JLabel l5 = new JLabel("Godina studija*");
		JComboBox<String> t5 = new JComboBox<String>(god_stud);
		t5.setSelectedIndex(p.getGodinaIzvodjenja() - 1);
		
		//DODAVANJE PROFESORA KOMPONENTE	
		noviProfesor = p.getPredmetniProfesor();
		
		JLabel l6 = new JLabel("Profesor*");
		JTextField t6 = new JTextField("");
		t6.setEditable(false);
		
		if (p.getPredmetniProfesor() != null) t6.setText(p.getPredmetniProfesor().getIme()+" "+p.getPredmetniProfesor().getPrezime());
		
		String imep_staro = t6.getText();
		
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

		JButton accept = new JButton("Prihvati");
		JButton decline = new JButton("Odustani");

		accept.setEnabled(false);
		decline.addActionListener(e -> {
			this.dispose();
		});
		
		//Akcije dugmica
		add.addActionListener(e -> {
			
			new odaberiProfesora().setVisible(true);
			if (BazaPredmeta.getInstance().getTemp_profesor() != null) {
				noviProfesor = BazaPredmeta.getInstance().getTemp_profesor();
				t6.setText(noviProfesor.getIme() + " " + noviProfesor.getPrezime());
			}
			dodavanjeProfesora(add, rm, t6);
			validate(t1, t2, t3, t4, t5, t6, accept, p, imep_staro);
			
		});
		
		rm.addActionListener(e -> {
			
			//TODO: #uklanjanje_profesora_sa_predmeta
			
		});
		
		
		
		KeyListener l = new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				dodavanjeProfesora(add, rm, t6);
				validate(t1, t2, t3, t4, t5, t6, accept, p, imep_staro);
			}

			@Override
			public void keyTyped(KeyEvent arg0) {

			}

		};
		
		MouseListener m = new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				dodavanjeProfesora(add, rm, t6);
				validate(t1, t2, t3, t4, t5, t6, accept, p, imep_staro);
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

			Semestar sem = Semestar.ZIMSKI;
			if (t4.getSelectedIndex() == 1)
				sem = Semestar.LETNJI;

			Predmet novo = new Predmet(t1.getText(), t2.getText(), sem, godina, noviProfesor, espb);

			if (!BazaPredmeta.getInstance().isUnique(t1.getText()) && !p.getSifraPredmeta().equals(t1.getText())) {
				JOptionPane.showMessageDialog(this, "Predmet sa ovom šifrom je već u sistemu!");
			}

			else if (espb < 1 || espb > 20) {
				JOptionPane.showMessageDialog(this, "Broj ESPB bodova nije validan!");
			}

			else {

				//TODO: registar promene
				
				PredmetiController.getInstance().izmeniPredmet(novo, p.getSifraPredmeta());
				JOptionPane.showMessageDialog(this, "Predmet uspešno izmenjen!");
				accept.setEnabled(false);
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
	
	//Vraca TRUE ako su postojale promene u odnosu na otvaranje prozora ili prihvatanje izmene, ili FALSE ukoliko nisu
	private Boolean isChanged(Predmet p1, Predmet p2) {
		
		if (p1.getESPB() == p2.getESPB() && p1.getSifraPredmeta().equals(p2.getSifraPredmeta()) && p1.getNazivPredmeta().equals(p2.getNazivPredmeta())
				&& p1.getGodinaIzvodjenja() == p2.getGodinaIzvodjenja() && p1.getSemestar().equals(p2.getSemestar()))
			return false;
		
		return true;
		
	}
	
	private void validate(JTextField t1, JTextField t2, JTextField t3, JComboBox<String> t4, JComboBox<String> t5, JTextField t6, JButton accept, Predmet p, String imep_staro) {
		
		boolean check1 = Pattern.matches("[A-Z0-9.-]{1,8}", t1.getText());
		boolean check2 = Pattern.matches("[A-ZČĆŽĐŠa-zšđčćž][0-9A-ZČĆŽĐŠa-zšđčćž -]+", t2.getText());
		boolean check3 = Pattern.matches("[0-9]{1,2}", t3.getText());

		if (check1 && check2 && check3) {
			int espb = Integer.parseInt(t3.getText());

			int godina = t5.getSelectedIndex() + 1;

			Semestar sem = Semestar.ZIMSKI;
			if (t4.getSelectedIndex() == 1)
				sem = Semestar.LETNJI;

		Predmet temp = new Predmet(t1.getText(), t2.getText(), sem, godina, null, espb);
		String imep_novo = t6.getText();
		
		if (!isChanged(temp, p) && imep_novo.equals(imep_staro))
			accept.setEnabled(false);
		else	accept.setEnabled(true);
		} 
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
		
	}
	
	private void dodavanjeProfesora (JButton add, JButton remove, JTextField t) {
		
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