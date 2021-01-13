// #menu_bar
package listeners.action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import dialog.AboutDialog;
import gui.MainFrame;

public class AboutAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4356466344233825956L;

	public AboutAction() {
		
		putValue(NAME, MainFrame.getInstance().getResourceBundle().getString("about"));
		putValue(SHORT_DESCRIPTION, MainFrame.getInstance().getResourceBundle().getString("abApp"));
		putValue(SMALL_ICON, new ImageIcon("images" + File.separator + "information.png"));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.ALT_MASK));
		putValue(MNEMONIC_KEY, KeyEvent.VK_O);
		
	}
	
	public void updateName() {
		
		putValue(NAME, MainFrame.getInstance().getResourceBundle().getString("about"));
		putValue(SHORT_DESCRIPTION, MainFrame.getInstance().getResourceBundle().getString("abApp"));
		
		if (MainFrame.getInstance().getResourceBundle().getString("English").equals("English")) {
			
			putValue(MNEMONIC_KEY, KeyEvent.VK_A);

			
		} else {
			
			putValue(MNEMONIC_KEY, KeyEvent.VK_O);

		}
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		new AboutDialog().setVisible(true);
	}

}
