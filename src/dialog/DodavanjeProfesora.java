//#dodavanje_profesora
//Reference:
// Projekat JTablveMVCAdvanced
// Projekat Dogadjaji

package dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import controller.ProfesoriController;
import gui.MainFrame;
import model.BazaProfesora;
import model.Profesor;
import model.Profesor.Titula;
import model.Profesor.Zvanje;

public class DodavanjeProfesora extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4973716326118229602L;

	public DodavanjeProfesora() {

		this.setTitle(MainFrame.getInstance().resourceBundle.getString("dodavanjeProf"));
		this.setResizable(false);
		this.setSize(450, 500);

		JPanel fields = new JPanel();
		fields.setLayout(new GridLayout(11, 2, 5, 10)); // hgap,vgap
		fields.setBorder(BorderFactory.createEmptyBorder(25, 50, 10, 50));

		JLabel imeProf = new JLabel(MainFrame.getInstance().resourceBundle.getString("newIme"));
		JTextField unosIme = new JTextField();
		unosIme.setToolTipText(MainFrame.getInstance().resourceBundle.getString("ttIme"));
		fields.add(imeProf);
		fields.add(unosIme);

		JLabel przProf = new JLabel(MainFrame.getInstance().resourceBundle.getString("newPrezime"));
		JTextField unosPrz = new JTextField();
		unosPrz.setToolTipText(MainFrame.getInstance().resourceBundle.getString("ttPrz"));
		fields.add(przProf);
		fields.add(unosPrz);

		JLabel datProf = new JLabel(MainFrame.getInstance().resourceBundle.getString("newDatumRodjenja"));
		JTextField unosDat = new JTextField();
		unosDat.setToolTipText(MainFrame.getInstance().resourceBundle.getString("ttDatum"));
		fields.add(datProf);
		fields.add(unosDat);

		JLabel adrProf = new JLabel(MainFrame.getInstance().resourceBundle.getString("newAdresaStanovanja"));
		JTextField unosAdr = new JTextField();
		unosAdr.setToolTipText(MainFrame.getInstance().resourceBundle.getString("ttAdresaS"));
		fields.add(adrProf);
		fields.add(unosAdr);

		JLabel telProf = new JLabel(MainFrame.getInstance().resourceBundle.getString("newBrojTelefona"));
		JTextField unosTel = new JTextField();
		unosTel.setToolTipText(MainFrame.getInstance().resourceBundle.getString("ttBrojTel"));
		fields.add(telProf);
		fields.add(unosTel);

		JLabel emailProf = new JLabel(MainFrame.getInstance().resourceBundle.getString("newEmail"));
		JTextField unosEmail = new JTextField();
		unosEmail.setToolTipText(MainFrame.getInstance().resourceBundle.getString("ttEmail"));
		fields.add(emailProf);
		fields.add(unosEmail);

		JLabel adrKanc = new JLabel(MainFrame.getInstance().resourceBundle.getString("newAdresaKancelarije"));
		JTextField unosAdrK = new JTextField();
		unosAdrK.setToolTipText(MainFrame.getInstance().resourceBundle.getString("ttAdresaK"));
		fields.add(adrKanc);
		fields.add(unosAdrK);

		JLabel blcProf = new JLabel(MainFrame.getInstance().resourceBundle.getString("newBrojLicne"));
		JTextField unosBlc = new JTextField();
		unosBlc.setToolTipText(MainFrame.getInstance().resourceBundle.getString("ttLicna"));
		fields.add(blcProf);
		fields.add(unosBlc);

		String[] titule = { MainFrame.getInstance().resourceBundle.getString("newBoxBSc"),
				MainFrame.getInstance().resourceBundle.getString("newBoxMSc"),
				MainFrame.getInstance().resourceBundle.getString("newBoxMr"),
				MainFrame.getInstance().resourceBundle.getString("newBoxDr"),
				MainFrame.getInstance().resourceBundle.getString("newBoxProfDr"),
				MainFrame.getInstance().resourceBundle.getString("newBoxProf") };
		JLabel titProf = new JLabel(MainFrame.getInstance().resourceBundle.getString("newTitula"));
		JComboBox<String> titula = new JComboBox<>(titule);
		fields.add(titProf);
		fields.add(titula);

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
		fields.add(zvanjeProf);
		fields.add(zvanje);

		JPanel buttons = new JPanel();
		buttons.setLayout(new FlowLayout());

		JButton okBtn = new JButton(MainFrame.getInstance().resourceBundle.getString("buttonPrihvati"));
		JButton cancelBtn = new JButton(MainFrame.getInstance().resourceBundle.getString("buttonOdustani"));

		okBtn.setEnabled(false);
		cancelBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				dispose();

			}
		});

		KeyListener provera = new KeyListener() {

			@Override
			public void keyTyped(KeyEvent arg0) {
			}

			@Override
			public void keyReleased(KeyEvent arg0) {

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
					okBtn.setEnabled(true);
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

			Profesor p = new Profesor(unosPrz.getText(), unosIme.getText(), unosDat.getText(), unosAdr.getText(),
					unosTel.getText(), unosEmail.getText(), unosAdrK.getText(), unosBlc.getText(), titulaProf,
					zvanjeProfes);

			boolean postoji = BazaProfesora.getInstance().proveraJedinstvenostiBlc(unosBlc.getText());

			if (postoji) {
				JOptionPane.showMessageDialog(null, MainFrame.getInstance().resourceBundle.getString("profPostoji"));
			} else if (!ispravanDatum) {

				JOptionPane.showMessageDialog(null, MainFrame.getInstance().resourceBundle.getString("datRodjNeValja"));

			} else {
				ProfesoriController.getInstance().dodajProfesora(p);
				// p.toString();
				JOptionPane.showMessageDialog(null, MainFrame.getInstance().resourceBundle.getString("dodatProfesor"));
				this.dispose();
			}

		});

		buttons.add(okBtn);
		buttons.add(Box.createHorizontalStrut(10));
		buttons.add(cancelBtn);
		buttons.setBorder(BorderFactory.createEmptyBorder(20, 10, 15, 20));

		this.add(fields, BorderLayout.CENTER);
		this.add(buttons, BorderLayout.SOUTH);
		this.setLocationRelativeTo(MainFrame.getInstance());
		this.setModal(true);

	}

}
