package listeners.action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

public class AddNewAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2803910189619443600L;

	public AddNewAction() {

		putValue(NAME, "New");
		putValue(SHORT_DESCRIPTION, "New");
//		putValue(MNEMONIC_KEY, KeyEvent.VK_F);
		putValue(SMALL_ICON, new ImageIcon("images/add.png"));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.ALT_MASK + ActionEvent.SHIFT_MASK));

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
