// #menu_bar

// Reference:
// Projekat Dogadjaji

package gui;

import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

import listeners.action.*;

public class MainMenu extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4905765460781590696L;

	public MainMenu() {
		
		//Bazna konstrukcija
		JMenu file = new JMenu("File");
		JMenu edit = new JMenu("Edit");
		JMenu help = new JMenu("Help");
		
		AddNewAction addM = new AddNewAction();
		CloseAppAction closeM = new CloseAppAction();
		
		EditAction editM = new EditAction();
		DeleteAction deleteM = new DeleteAction();
			
		HelpAction helpM = new HelpAction();
		AboutAction aboutM = new AboutAction();
		
		addM.setName();
		editM.setName();
		deleteM.setName();
		
		//Mnemonici
		file.setMnemonic(KeyEvent.VK_F);
		edit.setMnemonic(KeyEvent.VK_E);
		help.setMnemonic(KeyEvent.VK_H);


		//Dodavanje elemenata
		file.add(addM);	
		file.addSeparator();
		file.add(closeM);
		
		edit.add(editM);
		edit.addSeparator();
		edit.add(deleteM);
		
		help.add(helpM);
		help.addSeparator();
		help.add(aboutM);
		
		add(file);
		add(edit);
		add(help);	
		
	}
	
}
