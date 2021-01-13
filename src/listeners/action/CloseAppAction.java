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

		putValue(NAME, MainFrame.getInstance().getResourceBundle().getString("close"));
		putValue(SHORT_DESCRIPTION, MainFrame.getInstance().getResourceBundle().getString("closeApp"));
		putValue(SMALL_ICON, new ImageIcon("images" + File.separator + "delete.png"));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		putValue(MNEMONIC_KEY, KeyEvent.VK_Z);

	}

	public void setName() {
		
		putValue(NAME, MainFrame.getInstance().getResourceBundle().getString("close"));
		putValue(SHORT_DESCRIPTION, MainFrame.getInstance().getResourceBundle().getString("closeApp"));
		
		if (MainFrame.getInstance().getResourceBundle().getString("English").equals("English")) {
			
			putValue(MNEMONIC_KEY, KeyEvent.VK_C);

			
		} else {
			
			putValue(MNEMONIC_KEY, KeyEvent.VK_Z);

		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {

		Object[] opcije = {MainFrame.getInstance().resourceBundle.getString("yesBtn"), MainFrame.getInstance().resourceBundle.getString("noBtn")};
		Object defaultChoice = opcije[0];

		int izbor = JOptionPane.showOptionDialog(MainFrame.getInstance(),
				MainFrame.getInstance().resourceBundle.getString("zatvaranjeApl"), MainFrame.getInstance().resourceBundle.getString("closeApp"),
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcije, defaultChoice);

		if (izbor == JOptionPane.YES_OPTION) {

			int serijalizacija = JOptionPane.showOptionDialog(MainFrame.getInstance(),
					MainFrame.getInstance().resourceBundle.getString("cuvanjePod"), MainFrame.getInstance().resourceBundle.getString("cuvanje"), JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, opcije, defaultChoice);

			if (serijalizacija == JOptionPane.YES_OPTION) {
				try {

					BazaStudenata.getInstance().saveDataStudent();
					BazaProfesora.getInstance().saveDataProfesor();
					BazaPredmeta.getInstance().saveDataPredmet();

				} catch (IOException e) {
					e.printStackTrace();
				}

				JOptionPane.showMessageDialog(MainFrame.getInstance(), MainFrame.getInstance().resourceBundle.getString("sacuvani"));
			}

			System.exit(0);

		}


	}

}
