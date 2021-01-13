//#dodavanje_studenta
//#dodavanje_predmeta
package listeners.action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import dialog.DodavanjePredmeta;
import dialog.DodavanjeProfesora;
import dialog.DodavanjeStudenta;
import gui.MainFrame;
import gui.TabbedPane;

public class AddNewAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2803910189619443600L;

	public AddNewAction() {

//		putValue(NAME, "Name");
//		putValue(MNEMONIC_KEY, KeyEvent.VK_N);
		putValue(SHORT_DESCRIPTION, MainFrame.getInstance().resourceBundle.getString("new"));
		putValue(SMALL_ICON, new ImageIcon("images" + File.separator + "add.png"));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		putValue(MNEMONIC_KEY, KeyEvent.VK_N);
		
	}
	
	public void setName() {
		putValue(NAME, "New");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
 
		 //TabbedPane temp = new TabbedPane();
		 TabbedPane temp =  MainFrame.getTabbedPane();
		 int currentTab = temp.getSelectedIndex();
		 
		 switch (currentTab) {
		 case 0: 	new DodavanjeStudenta().setVisible(true);
		 			break;
		 case 1:	new DodavanjeProfesora().setVisible(true);
		 			break;
		 case 2:   	new DodavanjePredmeta().setVisible(true);
			 		break;
		 }
	}

}
