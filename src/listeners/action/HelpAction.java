// #menu_bar
package listeners.action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import dialog.HelpDialog;
import gui.MainFrame;

public class HelpAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3095767591964418515L;

	public HelpAction() {
		
		putValue(NAME, MainFrame.getInstance().getResourceBundle().getString("help"));
		putValue(SHORT_DESCRIPTION, MainFrame.getInstance().getResourceBundle().getString("helpInstr"));
		putValue(SMALL_ICON, new ImageIcon("images" + File.separator + "alert.png"));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F1, ActionEvent.ALT_MASK));
		putValue(MNEMONIC_KEY, KeyEvent.VK_P);
		
	}
	
	public void updateName() {
		
		putValue(NAME, MainFrame.getInstance().getResourceBundle().getString("help"));
		putValue(SHORT_DESCRIPTION, MainFrame.getInstance().getResourceBundle().getString("helpInstr"));
		
		if (MainFrame.getInstance().getResourceBundle().getString("English").equals("English")) {
			
			putValue(MNEMONIC_KEY, KeyEvent.VK_H);

			
		} else {
			
			putValue(MNEMONIC_KEY, KeyEvent.VK_P);

		}
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		new HelpDialog().setVisible(true);
	}

}
