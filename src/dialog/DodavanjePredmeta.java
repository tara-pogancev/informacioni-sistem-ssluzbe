//#dodavanje_predmeta

package dialog;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.UIManager;
import javax.swing.border.Border;

import controller.PredmetiController;
import gui.MainFrame;
import model.BazaPredmeta;
import model.Predmet;
import model.Predmet.Semestar;

public class DodavanjePredmeta extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2701902775235786713L;

	public DodavanjePredmeta() {
		this.setTitle("Dodavanje predmeta");
		this.setResizable(false);
		this.setSize(450, 320); // X, Y

		Border padding_form = BorderFactory.createEmptyBorder(25, 50, 10, 50); // North, West, South, East
		Border padding_buttons = BorderFactory.createEmptyBorder(20, 10, 15, 20);

		final Color ERROR_COLOR = new Color(237, 121, 121);
		Border incorrect_input = BorderFactory.createLineBorder(ERROR_COLOR, 2);

		// Unos forme
		JPanel content = new JPanel();
		content.setLayout(new GridLayout(5, 2, 5, 10)); // row, col, hgap, vgap
		content.setBorder(padding_form);

		// Potrebni nizovi
		String[] semestar = { "Zimski", "Letnji" };
		String[] god_stud = { "I (prva)", "II (druga)", "III (treća)", "IV (Četvrta)" };

		// ELEMENTI FORME
		JLabel l1 = new JLabel("Šifra*");
		JTextField t1 = new JTextField();
		t1.setToolTipText("e.g. E223A");

		JLabel l2 = new JLabel("Naziv*");
		JTextField t2 = new JTextField();
		t2.setToolTipText("e.g. Matematička analiza 2");

		JLabel l3 = new JLabel("ESPB");
		JTextField t3 = new JTextField();
		t3.setToolTipText("e.g. 6");

		JLabel l4 = new JLabel("Semestar*");
		JComboBox<String> t4 = new JComboBox<String>(semestar);

		JLabel l5 = new JLabel("Godina studija*");
		JComboBox<String> t5 = new JComboBox<String>(god_stud);

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
				boolean check1 = Pattern.matches("[A-Z0-9.-]{1,8}", t1.getText());
				boolean check2 = Pattern.matches("[A-ZČĆŽĐŠa-zšđčćž][0-9A-ZČĆŽĐŠa-zšđčćž -]+", t2.getText());
				boolean check3 = Pattern.matches("[0-9]{1,2}", t3.getText());

				if (check1 && check2 && check3)
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

			}

			@Override
			public void keyTyped(KeyEvent arg0) {

			}

		};

		// Dodavanje key listenera za sva polja
		t1.addKeyListener(l);
		t2.addKeyListener(l);
		t3.addKeyListener(l);

		accept.addActionListener(e -> {

			int espb = Integer.parseInt(t3.getText());

			int godina = t5.getSelectedIndex() + 1;

			Semestar sem = Semestar.ZIMSKI;
			if (t4.getSelectedIndex() == 1)
				sem = Semestar.LETNJI;

			Predmet p = new Predmet(t1.getText(), t2.getText(), sem, godina, null, espb);

			if (!BazaPredmeta.getInstance().isUnique(t1.getText())) {
				JOptionPane.showMessageDialog(null, "Predmet sa ovom šifrom je već u sistemu!");
			}

			else if (espb < 1 || espb > 20) {
				JOptionPane.showMessageDialog(null, "Broj ESPB bodova nije validan!");
			}

			else {

				PredmetiController.getInstance().dodajPredmet(p);
				this.dispose();
				JOptionPane.showMessageDialog(null, "Predmet uspešno dodat!");
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