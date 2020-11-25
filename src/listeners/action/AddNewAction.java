package listeners.action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

public class AddNewAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2803910189619443600L;

	public AddNewAction() {

//		putValue(NAME, "Name");
//		putValue(MNEMONIC_KEY, KeyEvent.VK_N);
		putValue(SHORT_DESCRIPTION, "New");
		putValue(SMALL_ICON, new ImageIcon("images/add.png"));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		
	}
	
	public void setName() {
		putValue(NAME, "New");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		 System.out.println("Action: Add New");
	}

}
