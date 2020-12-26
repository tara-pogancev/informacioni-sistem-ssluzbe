// #menu_bar

// Reference:
// https://alvinalexander.com/java/java-joptionpane-showoptiondialog-examples/

package listeners.action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

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
		
		int id = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da želite da zatvorite aplikaciju?", "Zatvaranje aplikacije?",
				JOptionPane.YES_NO_OPTION);
		if (id == JOptionPane.YES_OPTION)
			System.exit(0);
		
	}

}
