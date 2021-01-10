// #menu_bar

// Reference:
// https://alvinalexander.com/java/java-joptionpane-showoptiondialog-examples/

package listeners.action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import gui.MainFrame;
import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaStudenata;

public class CloseAppAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3033092348783819161L;
	
	public CloseAppAction() {
		
		putValue(NAME, "Close");
		putValue(SHORT_DESCRIPTION, "Close Application");
		putValue(SMALL_ICON, new ImageIcon("images" + File.separator + "delete.png"));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		putValue(MNEMONIC_KEY, KeyEvent.VK_C);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
//		Object[] choices = {"Da", "Ne"};
//		Object defaultChoice = choices[0];
//		
//		int id = JOptionPane.showOptionDialog(MainFrame.getInstance(), "Da li ste sigurni da želite da zatvorite aplikaciju?", "Zatvaranje aplikacije",
//				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, choices, defaultChoice);
//		if (id == JOptionPane.YES_OPTION)
//			System.exit(0);

		Object[] opcije = { "Da", "Ne" };
		Object defaultChoice = opcije[0];

		int izbor = JOptionPane.showOptionDialog(MainFrame.getInstance(),
				"Da li ste sigurni da želite da zatvorite aplikaciju?", "Zatvaranje aplikacije",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcije, defaultChoice);

		if (izbor == JOptionPane.YES_OPTION) {

			int serijalizacija = JOptionPane.showOptionDialog(MainFrame.getInstance(),
					"Da li želite da sačuvate izmenjene podatke?", "Čuvanje podataka", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, opcije, defaultChoice);

			if (serijalizacija == JOptionPane.YES_OPTION) {
				try {

					BazaStudenata.getInstance().saveDataStudent();
					BazaProfesora.getInstance().saveDataProfesor();
					BazaPredmeta.getInstance().saveDataPredmet();

				} catch (IOException e) {
					e.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(MainFrame.getInstance(), "Podaci su uspešno sačuvani!");
			}
			
			System.exit(0);
			
		}
		
		
	}

}
