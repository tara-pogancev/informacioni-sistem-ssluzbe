//#dodavanje_profesora
package dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import controller.ProfesoriController;
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

		this.setTitle("Dodavanje profesora");
		this.setResizable(false);
		this.setSize(450, 500);

		JPanel fields = new JPanel();
		fields.setLayout(new GridLayout(11, 2, 5, 10)); // hgap,vgap
		fields.setBorder(BorderFactory.createEmptyBorder(25, 50, 10, 50));
		

		JLabel imeProf = new JLabel("Ime*");
		JTextField unosIme = new JTextField();
		fields.add(imeProf);
		fields.add(unosIme);
		
		JLabel przProf = new JLabel("Prezime*");
		JTextField unosPrz = new JTextField();
		fields.add(przProf);
		fields.add(unosPrz);

		JLabel datProf = new JLabel("Datum rođenja*");
		JTextField unosDat = new JTextField();
		fields.add(datProf);
		fields.add(unosDat);
		
		JLabel adrProf = new JLabel("Adresa stanovanja*");
		JTextField unosAdr = new JTextField();
		fields.add(adrProf);
		fields.add(unosAdr);
		
		JLabel telProf = new JLabel("Kontakt telefon*");
		JTextField unosTel = new JTextField();
		fields.add(telProf);
		fields.add(unosTel);

		JLabel emailProf = new JLabel("E-mail*");
		JTextField unosEmail = new JTextField();
		fields.add(emailProf);
		fields.add(unosEmail);

		JLabel adrKanc = new JLabel("Adresa kancelarije*");
		JTextField unosAdrK = new JTextField();
		fields.add(adrKanc);
		fields.add(unosAdrK);

		JLabel blcProf = new JLabel("Broj lične karte*");
		JTextField unosBlc = new JTextField();
		fields.add(blcProf);
		fields.add(unosBlc);

		String[] titule = {"BSc", "MSc", "mr","dr","prof. dr","dipl. inž.","prof."};
		JLabel titProf = new JLabel("Titula*");
		JComboBox<String> titula = new JComboBox<>(titule);
		fields.add(titProf);
		fields.add(titula);

		String[] zvanja = {"saradnik u nastavi", "asistent","asistent sa doktoratom", "docent",
							"redivni profesor", "vanredni profesor", "profesor emeritus", "istrazivac pripravnik"};
		JLabel zvanjeProf = new JLabel("Zvanje*");
		JComboBox<String> zvanje = new JComboBox<>(zvanja);
		fields.add(zvanjeProf);
		fields.add(zvanje);
		

		JPanel buttons = new JPanel();
		buttons.setLayout(new FlowLayout());

		JButton okBtn = new JButton("Potvrdi");
		JButton cancelBtn = new JButton("Odustani");

		okBtn.setEnabled(false);
		cancelBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				dispose();

			}
		});

		KeyListener provera = new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
			
				boolean proveraIme = Pattern.matches("[A-ZČĆŽĐŠ][a-zšđčćž]+", unosIme.getText());
				boolean proveraPrz = Pattern.matches("[A-ZČĆŽĐŠ][a-zšđčćž]+", unosPrz.getText());
				boolean proveraDat = Pattern.matches("(([0][1-9])|([1-2][0-9])|([3][01]))[/](([0][1-9])|([1][012]))[/]((19|2[0-9])[0-9]{2})", unosDat.getText());
				boolean proveraAdr = ( unosAdr.getText() != "");
				boolean proveraTel = Pattern.matches("[+]?[0-9]+", unosTel.getText());
				boolean proveraEmail = Pattern.matches("[a-z0-9.!#$%&’*+-/=?^_`{|}~]*[a-z0-9!#$%&’*+-/=?^_`{|}~][@][a-z]+[.][a-z]+([a-z.]+[a-z])?", unosEmail.getText());
				boolean proveraAdrK = ( unosAdrK.getText() != "");
				boolean proveraBlc = Pattern.matches("[0-9A-Za-z]+", unosBlc.getText()); //nisu samo brojevi zbog profesora koji nisu iz Srbije
				

				if(proveraIme && proveraPrz && proveraDat && proveraAdr && proveraTel && proveraEmail && proveraAdrK && proveraBlc)
					okBtn.setEnabled(true);
				else okBtn.setEnabled(false);
				
			if(proveraIme || unosIme.getText().equals(""))	{
				unosIme.setBackground(Color.WHITE);
			}
			else {
				unosIme.setBackground(Color.RED);
			}
			
			if(proveraPrz || unosPrz.getText().equals("") )	{
				unosPrz.setBackground(Color.WHITE);
			}
			else {
				unosPrz.setBackground(Color.RED);
			}
			if(proveraDat || unosDat.getText().equals(""))	{
				unosDat.setBackground(Color.WHITE);
			}
			else {
				unosDat.setBackground(Color.RED);
			}
			
			if(proveraAdr || unosAdr.getText().equals("") )	{
				unosAdr.setBackground(Color.WHITE);
			}
			else {
				unosAdr.setBackground(Color.RED);
			}
			if(proveraTel || unosTel.getText().equals(""))	{
				unosTel.setBackground(Color.WHITE);
			}
			else {
				unosTel.setBackground(Color.RED);
			}
			
			if(proveraEmail || unosEmail.getText().equals("") )	{
				unosEmail.setBackground(Color.WHITE);
			}
			else {
				unosEmail.setBackground(Color.RED);
			}
			if(proveraAdrK || unosAdrK.getText().equals(""))	{
				unosAdrK.setBackground(Color.WHITE);
			}
			else {
				unosAdrK.setBackground(Color.RED);
			}
			
			if(proveraBlc || unosBlc.getText().equals("") )	{
				unosBlc.setBackground(Color.WHITE);
			}
			else {
				unosBlc.setBackground(Color.RED);
			}
			
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {}};
			
			unosIme.addKeyListener(provera);			
			unosPrz.addKeyListener(provera);
			unosDat.addKeyListener(provera);
			unosAdr.addKeyListener(provera);
			unosTel.addKeyListener(provera);
			unosEmail.addKeyListener(provera);
			unosAdrK.addKeyListener(provera);
			unosBlc.addKeyListener(provera);

			okBtn.addActionListener(e -> {
				
				Titula titulaProf = Titula.BSc;
				switch(titula.getSelectedIndex()) {
				case 1:
					titulaProf = Titula.MSc;
				case 2:
					titulaProf = Titula.mr;
				case 3:
					titulaProf = Titula.dr;
				case 4:
					titulaProf = Titula.profDr;
				case 5:
					titulaProf = Titula.diplIng;
				case 6:
					titulaProf = Titula.prof;
				
				}
				
	
				Zvanje zvanjeProfes = Zvanje.saradnikUNastavi;
				
				switch(zvanje.getSelectedIndex()) {
				case 1:
					zvanjeProfes = Zvanje.asistent;
				case 2:
					zvanjeProfes = Zvanje.asistentSaDoktoratom;
				case 3:
					zvanjeProfes = Zvanje.docent;
				case 4:
					zvanjeProfes = Zvanje.redovniProfesor;
				case 5:
					zvanjeProfes = Zvanje.vanredniProfesor;
				case 6:
					zvanjeProfes = Zvanje.profesorEmeritus;
				case 7:
					zvanjeProfes = Zvanje.istrazivacPripravnik;
				}
				
				Profesor p = new Profesor(unosPrz.getText(),unosIme.getText(),unosDat.getText(),unosAdr.getText(),unosTel.getText(),unosEmail.getText()
						,unosAdrK.getText(), unosBlc.getText(),titulaProf,zvanjeProfes);
				
				boolean postoji = false;
				
				for(int i = 0; i < BazaProfesora.getInstance().getProfesori().size();i++) {
				
						if((p.getBrojLicneKarte().equals(BazaProfesora.getInstance().getProfesori().get(i).getBrojLicneKarte()))) {
							
							postoji = true;
						}
				}

				if(postoji) {
					JOptionPane.showMessageDialog(null, "Profesor sa ovim brojem lične karte je već u sistemu!");
				}else {
					ProfesoriController.getInstance().dodajProfesora(p);
					p.toString();
					this.dispose();
				}
				
			});
			
		buttons.add(okBtn);
		buttons.add(Box.createHorizontalStrut(10));
		buttons.add(cancelBtn);
		buttons.setBorder(BorderFactory.createEmptyBorder(20, 10, 15, 20));

		this.add(fields, BorderLayout.CENTER);
		this.add(buttons, BorderLayout.SOUTH);
		this.setLocationRelativeTo(null);
		this.setModal(true);

	}

}
