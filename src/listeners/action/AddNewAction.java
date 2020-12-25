package listeners.action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

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
		putValue(SHORT_DESCRIPTION, "New");
		putValue(SMALL_ICON, new ImageIcon("images" + File.separator + "add.png"));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		putValue(MNEMONIC_KEY, KeyEvent.VK_N);
		
	}
	
	public void setName() {
		putValue(NAME, "New");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		// System.out.println("Action: Add New");
		 
		 //TODO Napraviti switch-case koji u zavisnosti od aktivnog taba prikaze tacno dodavanje, trenunto je ovako zbog testiranja
		 //new DodavanjeStudenta().setVisible(true);
		 
		 //TabbedPane temp = new TabbedPane();
		 TabbedPane temp =  MainFrame.getTabbedPane();
		 int current_tab = temp.getSelectedIndex();
		 
		 switch (current_tab) {
		 case 0: 	new DodavanjeStudenta().setVisible(true);
		 			break;
		 case 1:	new DodavanjeProfesora().setVisible(true);
		 			break;
		 case 2:   //..
			 		break;
		 }
	}

}
