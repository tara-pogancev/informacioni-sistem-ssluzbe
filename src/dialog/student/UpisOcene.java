// #upis_ocene
package dialog.student;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.StudentController;
import model.BazaPredmeta;
import model.Predmet;

public class UpisOcene extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5560296370134176923L;

	public UpisOcene(String idx, String idPredmeta) {

		this.setTitle("Unos ocene");
		this.setResizable(false);
		this.setSize(480, 305);

		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(15, 20, 20, 20));
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JPanel fields = new JPanel();
		fields.setLayout(new GridLayout(4, 2, 5, 10)); // vrsta,kolona
		fields.setBorder(BorderFactory.createEmptyBorder(25, 50, 10, 50));

		Predmet p = BazaPredmeta.getInstance().findById(idPredmeta);

		JLabel sifraL = new JLabel("Šifra*");
		JTextField sifraTxt = new JTextField(p.getSifraPredmeta());
		sifraTxt.setEditable(false);
		fields.add(sifraL);
		fields.add(sifraTxt);

		JLabel naziv = new JLabel("Naziv*");
		JTextField nazivTxt = new JTextField(p.getNazivPredmeta());
		nazivTxt.setEditable(false);
		fields.add(naziv);
		fields.add(nazivTxt);

		Integer[] izborOcena = { 6, 7, 8, 9, 10 };
		JLabel ocenaL = new JLabel("Ocena*");
		JComboBox<Integer> unosOcena = new JComboBox<Integer>(izborOcena);
		unosOcena.setSelectedIndex(0);
		fields.add(ocenaL);
		fields.add(unosOcena);

		JLabel datum = new JLabel("Datum*");
		JTextField unosDat = new JTextField();
		unosDat.setToolTipText("Primer: 13.05.2020.");
		fields.add(datum);
		fields.add(unosDat);

		JPanel buttons = new JPanel();
		buttons.setLayout(new FlowLayout());

		JButton potvrdi = new JButton("Potvrdi");
		JButton odustani = new JButton("Odustani");

		buttons.add(potvrdi);
		buttons.add(Box.createHorizontalStrut(10));
		buttons.add(odustani);
		buttons.setBorder(BorderFactory.createEmptyBorder(20, 10, 15, 20));

		potvrdi.setEnabled(false);

		odustani.addActionListener(e -> {

			this.dispose();

		});

		KeyListener provera = new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				boolean proveraDat = Pattern.matches(
						"(([0][1-9])|([1-2][0-9])|([3][01]))[.](([0][1-9])|([1][012]))[.]((19|2[0-9])[0-9]{2}[.])",
						unosDat.getText());

				if (proveraDat) {
					potvrdi.setEnabled(true);
				} else {
					potvrdi.setEnabled(false);
				}

				if (proveraDat || unosDat.getText().isEmpty()) {
					unosDat.setBackground(Color.WHITE);
					unosDat.setForeground(Color.BLACK);
				} else {
					unosDat.setBackground(Color.RED);
					unosDat.setForeground(Color.WHITE);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}
		};

		unosDat.addKeyListener(provera);

		potvrdi.addActionListener(e -> {

			Integer ocena = 6;

			switch (unosOcena.getSelectedIndex()) {

			case 1:
				ocena = 7;
				break;
			case 2:
				ocena = 8;
				break;
			case 3:
				ocena = 9;
				break;
			case 4:
				ocena = 10;
				break;

			}
			
			DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy.");

			Date datumPolaganja = null;
			boolean ispravanDatum = true;

			try {

				datumPolaganja = dateFormat.parse(unosDat.getText());

				if (datumPolaganja.compareTo(dateFormat.parse("01.01.2015.")) < 0) {

					ispravanDatum = false;
				}

			} catch (ParseException ex) {
				ex.printStackTrace();
			}
			
			if (!ispravanDatum) {

				JOptionPane.showMessageDialog(null, "Datum polaganja nije validan!");

			}else {
				
				StudentController.getInstance().upisiOcenu(idx, idPredmeta, ocena, unosDat.getText());
			
				JOptionPane.showMessageDialog(null, "Ocena uspešno upisana!");
				this.dispose();
			}

		});

		panel.add(fields, BorderLayout.CENTER);
		panel.add(buttons, BorderLayout.SOUTH);

		this.add(panel);
		this.setLocationRelativeTo(rootPane);
		this.setModal(true);

	}

}
