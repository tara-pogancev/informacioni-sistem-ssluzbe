//#izmena_studenta

package listeners.action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import dialog.IzmenaStudenta;
import gui.MainFrame;
import gui.TabbedPane;

public class EditAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7994641257537406598L;

	public EditAction() {

//		putValue(NAME, "Edit");
//		putValue(MNEMONIC_KEY, KeyEvent.VK_E);
		putValue(SHORT_DESCRIPTION, "Edit");
		putValue(SMALL_ICON,new ImageIcon("images" + File.separator + "edit.png"));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		putValue(MNEMONIC_KEY, KeyEvent.VK_E);
	}
	
	public void setName() {
		putValue(NAME, "Edit");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		// System.out.println("Action: Edit");
		 
		 TabbedPane temp =  MainFrame.getTabbedPane();
		 int current_tab = temp.getSelectedIndex();
		 
		 //Provera da je bilo koji red izabran
		 int sellected_row = temp.getSellectedTableIndex();
		 if (sellected_row == -1)
			 return;
		 
		 switch (current_tab) {
		 case 0: 	new IzmenaStudenta(temp.getStudentIdx()).setVisible(true);
		 			break;
		 case 1:	//...
		 			break;
		 case 2:   //...
			 		break;
		 }
	}

}
