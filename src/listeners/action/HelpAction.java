// #menu_bar
package listeners.action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import dialog.HelpDialog;

public class HelpAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3095767591964418515L;

	public HelpAction() {
		
		putValue(NAME, "Help");
		putValue(SHORT_DESCRIPTION, "Help and Instructions");
		putValue(SMALL_ICON, new ImageIcon("images" + File.separator + "alert.png"));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F1, ActionEvent.ALT_MASK));
		putValue(MNEMONIC_KEY, KeyEvent.VK_H);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		new HelpDialog().setVisible(true);
	}

}
