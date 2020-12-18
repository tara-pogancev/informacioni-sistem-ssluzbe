package dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DodavanjeProfesora extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4973716326118229602L;
	
	public DodavanjeProfesora() {
		
		this.setTitle("Dodavanje profesora");
		this.setResizable(false);
		this.setSize(450, 500);
		
		JPanel fields = new JPanel();
		fields.setLayout(new GridLayout(10,2,5,10));
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
		
		JLabel titProf = new JLabel("Titula*");
		JTextField unosTit = new JTextField();
		fields.add(titProf);
		fields.add(unosTit);
		
		JLabel zvanjeProf = new JLabel("Zvanje*");
		JTextField unosZvanje = new JTextField();
		fields.add(zvanjeProf);
		fields.add(unosZvanje);
		
		JPanel buttons = new JPanel();
		buttons.setLayout(new FlowLayout());
		
		JButton okBtn = new JButton("Potvrdi");
		JButton cancelBtn = new JButton("Otkaži");
		
		cancelBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				
			}
		});
		
		okBtn.addActionListener(e -> {
			
			//@Override
			//public void actionPerformed(ActionEvent arg0) {
				
				if(unosIme.getText().isEmpty() || unosPrz.getText().isEmpty() || 
				   unosDat.getText().isEmpty() || unosAdr.getText().isEmpty() ||
				   unosTel.getText().isEmpty() || unosEmail.getText().isEmpty() ||
				   unosAdrK.getText().isEmpty() || unosBlc.getText().isEmpty() ||
				   unosTit.getText().isEmpty() || unosZvanje.getText().isEmpty()) {
					
					JOptionPane.showMessageDialog(this, "Sva polja moraju biti popunjena!", "Upozorenje", JOptionPane.WARNING_MESSAGE);
					
				}else {
					System.out.println("Uspešno dodavanje profesora!");
					dispose();
				}
				
			//}
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
