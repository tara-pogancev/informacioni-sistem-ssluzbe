// #izmena_profesora

package dialog.profesor;

import java.awt.BorderLayout;
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

import controller.ProfesoriController;
import gui.MainFrame;
import model.BazaProfesora;
import model.Profesor;
import model.Profesor.Titula;
import model.Profesor.Zvanje;

public class ProfesorInformacije extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 909338967525379398L;

	private Profesor bezIzmena = null;

	public ProfesorInformacije(Profesor p) {

		bezIzmena = new Profesor(p);

		JPanel fields = new JPanel();
		fields.setLayout(new GridLayout(10, 2, 5, 10)); // hgap,vgap
		fields.setBorder(BorderFactory.createEmptyBorder(30, 90, 10, 90));

		JLabel imeProf = new JLabel(MainFrame.getInstance().resourceBundle.getString("newIme"));
		JTextField unosIme = new JTextField(p.getIme());
		unosIme.setToolTipText(MainFrame.getInstance().resourceBundle.getString("ttIme"));

		JLabel przProf = new JLabel(MainFrame.getInstance().resourceBundle.getString("newPrezime"));
		JTextField unosPrz = new JTextField(p.getPrezime());
		unosPrz.setToolTipText(MainFrame.getInstance().resourceBundle.getString("ttPrz"));

		JLabel datProf = new JLabel(MainFrame.getInstance().resourceBundle.getString("newDatumRodjenja"));
		JTextField unosDat = new JTextField(p.getDatumRodjenjaString());
		unosDat.setToolTipText(MainFrame.getInstance().resourceBundle.getString("ttDatum"));

		JLabel adrProf = new JLabel(MainFrame.getInstance().resourceBundle.getString("newAdresaStanovanja"));
		JTextField unosAdr = new JTextField(p.getAdresaStanovanja());
		unosAdr.setToolTipText(MainFrame.getInstance().resourceBundle.getString("ttAdresaS"));

		JLabel telProf = new JLabel(MainFrame.getInstance().resourceBundle.getString("newBrojTelefona"));
		JTextField unosTel = new JTextField(p.getKontaktTelefon());
		unosTel.setToolTipText(MainFrame.getInstance().resourceBundle.getString("ttBrojTel"));

		JLabel emailProf = new JLabel(MainFrame.getInstance().resourceBundle.getString("newEmail"));
		JTextField unosEmail = new JTextField(p.getEmailAdresa());
		unosEmail.setToolTipText(MainFrame.getInstance().resourceBundle.getString("ttEmail"));

		JLabel adrKanc = new JLabel(MainFrame.getInstance().resourceBundle.getString("newAdresaKancelarije"));
		JTextField unosAdrK = new JTextField(p.getAdresaKancelarije());
		unosAdrK.setToolTipText(MainFrame.getInstance().resourceBundle.getString("ttAdresaK"));
		
		JLabel blcProf = new JLabel(MainFrame.getInstance().resourceBundle.getString("newBrojLicne"));
		JTextField unosBlc = new JTextField(p.getBrojLicneKarte());
		unosBlc.setToolTipText(MainFrame.getInstance().resourceBundle.getString("ttLicna"));

		String[] titule = { MainFrame.getInstance().resourceBundle.getString("newBoxBSc"),
				MainFrame.getInstance().resourceBundle.getString("newBoxMSc"),
				MainFrame.getInstance().resourceBundle.getString("newBoxMr"),
				MainFrame.getInstance().resourceBundle.getString("newBoxDr"),
				MainFrame.getInstance().resourceBundle.getString("newBoxProfDr"),
				MainFrame.getInstance().resourceBundle.getString("newBoxProf") };
		JLabel titProf = new JLabel(MainFrame.getInstance().resourceBundle.getString("newTitula"));
		JComboBox<String> titula = new JComboBox<>(titule);

		if(p.getTitula().equals(MainFrame.getInstance().getResourceBundle().getString("newBoxBSc"))) {
			titula.setSelectedIndex(0);
		}else if(p.getTitula().equals(MainFrame.getInstance().getResourceBundle().getString("newBoxMSc"))) {
			
			titula.setSelectedIndex(1);
		}else if(p.getTitula().equals(MainFrame.getInstance().getResourceBundle().getString("newBoxMr"))) {
			
			titula.setSelectedIndex(2);
		}else if(p.getTitula().equals(MainFrame.getInstance().getResourceBundle().getString("newBoxDr"))) {
			
			titula.setSelectedIndex(3);
		}else if(p.getTitula().equals(MainFrame.getInstance().getResourceBundle().getString("newBoxProfDr"))) {
			
			titula.setSelectedIndex(4);
		}else {
			
			titula.setSelectedIndex(5);
		}

		String[] zvanja = { MainFrame.getInstance().resourceBundle.getString("newBoxSaradnik"),
				MainFrame.getInstance().resourceBundle.getString("newBoxAsistent"),
				MainFrame.getInstance().resourceBundle.getString("newBoxAsistentSaDoktoratom"),
				MainFrame.getInstance().resourceBundle.getString("newBoxDocent"),
				MainFrame.getInstance().resourceBundle.getString("newBoxRedovni"),
				MainFrame.getInstance().resourceBundle.getString("newBoxVanredni"),
				MainFrame.getInstance().resourceBundle.getString("newBoxEmeritus"),
				MainFrame.getInstance().resourceBundle.getString("newBoxIstrazivac") };
		JLabel zvanjeProf = new JLabel(MainFrame.getInstance().resourceBundle.getString("newZvanje"));
		JComboBox<String> zvanje = new JComboBox<>(zvanja);

		if(p.getZvanje().equals(MainFrame.getInstance().getResourceBundle().getString("newBoxSaradnik"))) {
			
			zvanje.setSelectedIndex(0);
		}else if(p.getZvanje().equals(MainFrame.getInstance().getResourceBundle().getString("newBoxAsistent"))) {
			
			zvanje.setSelectedIndex(1);
		}else if(p.getZvanje().equals(MainFrame.getInstance().getResourceBundle().getString("newBoxAsistentSaDoktoratom"))) {
			
			zvanje.setSelectedIndex(2);
		}else if(p.getZvanje().equals(MainFrame.getInstance().getResourceBundle().getString("newBoxDocent"))) {
			
			zvanje.setSelectedIndex(3);
		}else if(p.getZvanje().equals(MainFrame.getInstance().getResourceBundle().getString("newBoxRedovni"))) {
			
			zvanje.setSelectedIndex(4);
		}else if(p.getZvanje().equals(MainFrame.getInstance().getResourceBundle().getString("newBoxVanredni"))) {
			
			zvanje.setSelectedIndex(5);
		}else if(p.getZvanje().equals(MainFrame.getInstance().getResourceBundle().getString("newBoxEmeritus"))) {
			
			zvanje.setSelectedIndex(6);
		}else {
			
			zvanje.setSelectedIndex(7);
		}
		
		inicijaliacija(bezIzmena, unosIme, unosPrz,unosDat,unosAdr,unosTel,unosEmail,unosAdrK,unosBlc,titula,zvanje);
		
		fields.add(imeProf);
		fields.add(unosIme);
		fields.add(przProf);
		fields.add(unosPrz);
		fields.add(datProf);
		fields.add(unosDat);
		fields.add(adrProf);
		fields.add(unosAdr);
		fields.add(telProf);
		fields.add(unosTel);
		fields.add(emailProf);
		fields.add(unosEmail);
		fields.add(adrKanc);
		fields.add(unosAdrK);
		fields.add(blcProf);
		fields.add(unosBlc);
		fields.add(titProf);
		fields.add(titula);
		fields.add(zvanjeProf);
		fields.add(zvanje);

		JPanel buttons = new JPanel();
		buttons.setLayout(new FlowLayout());

		JButton okBtn = new JButton(MainFrame.getInstance().resourceBundle.getString("buttonPrihvati"));
		JButton cancelBtn = new JButton(MainFrame.getInstance().resourceBundle.getString("buttonOdustani"));


		okBtn.setEnabled(false);

		cancelBtn.addActionListener(e -> {

			inicijaliacija(bezIzmena, unosIme, unosPrz,unosDat,unosAdr,unosTel,unosEmail,unosAdrK,unosBlc,titula,zvanje);
			validacija(unosIme, unosPrz,unosDat,unosAdr,unosTel,unosEmail,unosAdrK,unosBlc,titula,zvanje, okBtn);
			JOptionPane.showMessageDialog(this, MainFrame.getInstance().resourceBundle.getString("ponisteneIzmene"));

		});

		KeyListener provera = new KeyListener() {

			@Override
			public void keyTyped(KeyEvent arg0) {
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				validacija(unosIme, unosPrz,unosDat,unosAdr,unosTel,unosEmail,unosAdrK,unosBlc,titula,zvanje, okBtn);
			}

			@Override
			public void keyPressed(KeyEvent arg0) {
			}
		};

		unosIme.addKeyListener(provera);
		unosPrz.addKeyListener(provera);
		unosDat.addKeyListener(provera);
		unosAdr.addKeyListener(provera);
		unosTel.addKeyListener(provera);
		unosEmail.addKeyListener(provera);
		unosAdrK.addKeyListener(provera);
		unosBlc.addKeyListener(provera);

		MouseListener m = new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				validacija(unosIme, unosPrz,unosDat,unosAdr,unosTel,unosEmail,unosAdrK,unosBlc,titula,zvanje, okBtn);
			}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {
				validacija(unosIme, unosPrz,unosDat,unosAdr,unosTel,unosEmail,unosAdrK,unosBlc,titula,zvanje, okBtn);
			}
			
			
		};
		
		this.addMouseListener(m);
		
		okBtn.addActionListener(e -> {

			Titula titulaProf = null;

			switch (titula.getSelectedIndex()) {
			case 0:
				titulaProf = Titula.BSc;
				break;
			case 1:
				titulaProf = Titula.MSc;
				break;
			case 2:
				titulaProf = Titula.mr;
				break;
			case 3:
				titulaProf = Titula.dr;
				break;
			case 4:
				titulaProf = Titula.profDr;
				break;
			default:
				titulaProf = Titula.prof;
				break;

			}

			Zvanje zvanjeProfes = null;

			switch (zvanje.getSelectedIndex()) {
			case 0:
				zvanjeProfes = Zvanje.saradnikUNastavi;
				break;
			case 1:
				zvanjeProfes = Zvanje.asistent;
				break;
			case 2:
				zvanjeProfes = Zvanje.asistentSaDoktoratom;
				break;
			case 3:
				zvanjeProfes = Zvanje.docent;
				break;
			case 4:
				zvanjeProfes = Zvanje.redovniProfesor;
				break;
			case 5:
				zvanjeProfes = Zvanje.vanredniProfesor;
				break;
			case 6:
				zvanjeProfes = Zvanje.profesorEmeritus;
				break;
			default:
				zvanjeProfes = Zvanje.istrazivacPripravnik;
				break;
			}

			DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy.");

			Date datumRodjenja = null;
			boolean ispravanDatum = true;

			try {

				datumRodjenja = dateFormat.parse(unosDat.getText());

				if (datumRodjenja.compareTo(dateFormat.parse("01.01.2002.")) > 0) {

					ispravanDatum = false;
				}

			} catch (ParseException ex) {
				ex.printStackTrace();
			}

			Profesor izmenjen = new Profesor(unosPrz.getText(), unosIme.getText(), unosDat.getText(), unosAdr.getText(),
					unosTel.getText(), unosEmail.getText(), unosAdrK.getText(), unosBlc.getText(), titulaProf,
					zvanjeProfes);

			boolean postoji = BazaProfesora.getInstance().proveraJedinstvenostiBlc(unosBlc.getText());

			if (postoji && !p.getBrojLicneKarte().equals(unosBlc.getText())) {
				JOptionPane.showMessageDialog(null, MainFrame.getInstance().resourceBundle.getString("profPostoji"));
			} else if (!ispravanDatum) {

				JOptionPane.showMessageDialog(null, MainFrame.getInstance().resourceBundle.getString("datRodjNeValja"));

			} else {

				bezIzmena = new Profesor(izmenjen);
				okBtn.setEnabled(false);

				ProfesoriController.getInstance().izmeniProfesora(izmenjen, p.getBrojLicneKarte());
				JOptionPane.showMessageDialog(null, MainFrame.getInstance().resourceBundle.getString("InfProfIzmena"));
			}

		});

		buttons.add(okBtn);
		buttons.add(Box.createHorizontalStrut(10));
		buttons.add(cancelBtn);
		buttons.setBorder(BorderFactory.createEmptyBorder(20, 10, 15, 20));

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(fields, BorderLayout.CENTER);
		this.add(buttons, BorderLayout.SOUTH);

	}

	private void inicijaliacija(Profesor p, JTextField t1, JTextField t2, JTextField t3, JTextField t4, JTextField t5,
			JTextField t6, JTextField t7, JTextField t8, JComboBox<String> t9, JComboBox<String> t10) {

		t1.setText(p.getIme());
		t2.setText(p.getPrezime());
		t3.setText(p.getDatumRodjenjaString());
		t4.setText(p.getAdresaStanovanja());
		t5.setText(p.getKontaktTelefon());
		t6.setText(p.getEmailAdresa());
		t7.setText(p.getAdresaKancelarije());
		t8.setText(p.getBrojLicneKarte());

		if(p.getTitula().equals(MainFrame.getInstance().getResourceBundle().getString("newBoxBSc"))) {
			t9.setSelectedIndex(0);
		}else if(p.getTitula().equals(MainFrame.getInstance().getResourceBundle().getString("newBoxMSc"))) {
			
			t9.setSelectedIndex(1);
		}else if(p.getTitula().equals(MainFrame.getInstance().getResourceBundle().getString("newBoxMr"))) {
			
			t9.setSelectedIndex(2);
		}else if(p.getTitula().equals(MainFrame.getInstance().getResourceBundle().getString("newBoxDr"))) {
			
			t9.setSelectedIndex(3);
		}else if(p.getTitula().equals(MainFrame.getInstance().getResourceBundle().getString("newBoxProfDr"))) {
			
			t9.setSelectedIndex(4);
		}else {
			
			t9.setSelectedIndex(5);
		}
		
		if(p.getZvanje().equals(MainFrame.getInstance().getResourceBundle().getString("newBoxSaradnik"))) {
			
			t10.setSelectedIndex(0);
		}else if(p.getZvanje().equals(MainFrame.getInstance().getResourceBundle().getString("newBoxAsistent"))) {
			
			t10.setSelectedIndex(1);
		}else if(p.getZvanje().equals(MainFrame.getInstance().getResourceBundle().getString("newBoxAsistentSaDoktoratom"))) {
			
			t10.setSelectedIndex(2);
		}else if(p.getZvanje().equals(MainFrame.getInstance().getResourceBundle().getString("newBoxDocent"))) {
			
			t10.setSelectedIndex(3);
		}else if(p.getZvanje().equals(MainFrame.getInstance().getResourceBundle().getString("newBoxRedovni"))) {
			
			t10.setSelectedIndex(4);
		}else if(p.getZvanje().equals(MainFrame.getInstance().getResourceBundle().getString("newBoxVanredni"))) {
			
			t10.setSelectedIndex(5);
		}else if(p.getZvanje().equals(MainFrame.getInstance().getResourceBundle().getString("newBoxEmeritus"))) {
			
			t10.setSelectedIndex(6);
		}else {
			
			t10.setSelectedIndex(7);
		}

	}

	private void validacija(JTextField unosIme, JTextField unosPrz, JTextField unosDat, JTextField unosAdr,
			JTextField unosTel, JTextField unosEmail, JTextField unosAdrK, JTextField unosBlc, JComboBox<String> titula,
			JComboBox<String> zvanje, JButton okBtn) {

		boolean proveraIme = Pattern.matches("[A-ZČĆŽĐŠa-zšđčćž -]+", unosIme.getText());
		boolean proveraPrz = Pattern.matches("[A-ZČĆŽĐŠa-zšđčćž -]+", unosPrz.getText());
		boolean proveraDat = Pattern.matches(
				"(([0][1-9])|([1-2][0-9])|([3][01]))[.](([0][1-9])|([1][012]))[.]((19|2[0-9])[0-9]{2}[.])",
				unosDat.getText());
		boolean proveraAdr = (unosAdr.getText() != "");
		boolean proveraTel = Pattern.matches("[+]?[0-9-/]+", unosTel.getText());
		boolean proveraEmail = Pattern.matches(
				"[a-z0-9.!#$%&’*+-/=?^_`{|}~]*[a-z0-9!#$%&’*+-/=?^_`{|}~][@][a-z]+[.][a-z]+([a-z.]+[a-z])?",
				unosEmail.getText());
		boolean proveraAdrK = (unosAdrK.getText() != "");
		boolean proveraBlc = Pattern.matches("[0-9A-Za-z]+", unosBlc.getText()); // nisu samo brojevi zbog
																					// profesora koji nisu iz
																					// Srbije

		if (proveraIme && proveraPrz && proveraDat && proveraAdr && proveraTel && proveraEmail && proveraAdrK
				&& proveraBlc) {

			Titula titulaP = null;

			switch (titula.getSelectedIndex()) {
			case 0:
				titulaP = Titula.BSc;
				break;
			case 1:
				titulaP = Titula.MSc;
				break;
			case 2:
				titulaP = Titula.mr;
				break;
			case 3:
				titulaP = Titula.dr;
				break;
			case 4:
				titulaP = Titula.profDr;
				break;
			default:
				titulaP = Titula.prof;
				break;

			}

			Zvanje zvanjeP = null;

			switch (zvanje.getSelectedIndex()) {
			case 0:
				zvanjeP = Zvanje.saradnikUNastavi;
				break;
			case 1:
				zvanjeP = Zvanje.asistent;
				break;
			case 2:
				zvanjeP = Zvanje.asistentSaDoktoratom;
				break;
			case 3:
				zvanjeP = Zvanje.docent;
				break;
			case 4:
				zvanjeP = Zvanje.redovniProfesor;
				break;
			case 5:
				zvanjeP = Zvanje.vanredniProfesor;
				break;
			case 6:
				zvanjeP = Zvanje.profesorEmeritus;
				break;
			default:
				zvanjeP = Zvanje.istrazivacPripravnik;
				break;
			}

			Profesor izmenjen = new Profesor(unosPrz.getText(), unosIme.getText(), unosDat.getText(), unosAdr.getText(),
					unosTel.getText(), unosEmail.getText(), unosAdrK.getText(), unosBlc.getText(), titulaP, zvanjeP);

			if (izmenjen.equals(bezIzmena)) {

				okBtn.setEnabled(false);
			} else {
				okBtn.setEnabled(true);
			}
		} else {
			okBtn.setEnabled(false);
		}

		if (proveraIme || unosIme.getText().isEmpty()) {
			unosIme.setBackground(Color.WHITE);
			unosIme.setForeground(Color.BLACK);
		} else {
			unosIme.setBackground(Color.RED);
			unosIme.setForeground(Color.WHITE);
		}

		if (proveraPrz || unosPrz.getText().isEmpty()) {
			unosPrz.setBackground(Color.WHITE);
			unosPrz.setForeground(Color.BLACK);
		} else {
			unosPrz.setBackground(Color.RED);
			unosPrz.setForeground(Color.WHITE);
		}
		if (proveraDat || unosDat.getText().isEmpty()) {
			unosDat.setBackground(Color.WHITE);
			unosDat.setForeground(Color.BLACK);
		} else {
			unosDat.setBackground(Color.RED);
			unosDat.setForeground(Color.WHITE);
		}

		if (proveraAdr || unosAdr.getText().isEmpty()) {
			unosAdr.setBackground(Color.WHITE);
			unosAdr.setForeground(Color.BLACK);
		} else {
			unosAdr.setBackground(Color.RED);
			unosAdr.setForeground(Color.WHITE);
		}
		if (proveraTel || unosTel.getText().isEmpty()) {
			unosTel.setBackground(Color.WHITE);
			unosTel.setForeground(Color.BLACK);
		} else {
			unosTel.setBackground(Color.RED);
			unosTel.setForeground(Color.WHITE);
		}

		if (proveraEmail || unosEmail.getText().isEmpty()) {
			unosEmail.setBackground(Color.WHITE);
			unosEmail.setForeground(Color.BLACK);
		} else {
			unosEmail.setBackground(Color.RED);
			unosEmail.setForeground(Color.WHITE);
		}
		if (proveraAdrK || unosAdrK.getText().isEmpty()) {
			unosAdrK.setBackground(Color.WHITE);
			unosAdrK.setForeground(Color.BLACK);
		} else {
			unosAdrK.setBackground(Color.RED);
			unosAdrK.setForeground(Color.WHITE);
		}

		if (proveraBlc || unosBlc.getText().isEmpty()) {
			unosBlc.setBackground(Color.WHITE);
			unosBlc.setForeground(Color.BLACK);
		} else {
			unosBlc.setBackground(Color.RED);
			unosBlc.setForeground(Color.WHITE);
		}
	}
}
