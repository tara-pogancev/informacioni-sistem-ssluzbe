// #menu_bar
package listeners.action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import dialog.AboutDialog;

public class AboutAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4356466344233825956L;

	public AboutAction() {
		
		putValue(NAME, "About");
		putValue(SHORT_DESCRIPTION, "About Application");
		putValue(SMALL_ICON, new ImageIcon("images/information.png"));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.ALT_MASK));
		putValue(MNEMONIC_KEY, KeyEvent.VK_A);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		new AboutDialog().setVisible(true);
	}

}
