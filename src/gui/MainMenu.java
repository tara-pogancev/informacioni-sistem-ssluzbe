// #menu_bar

// Reference:
// Projekat Dogadjaji

package gui;

import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import listeners.action.*;

public class MainMenu extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4905765460781590696L;
	private static final String NAME = null;


	public MainMenu() {
		
		//Bazna konstrukcija
		JMenu file = new JMenu("File");
		JMenu edit = new JMenu("Edit");
		JMenu help = new JMenu("Help");
		
		AddNewAction add_m = new AddNewAction();
		CloseAppAction close_m = new CloseAppAction();
		
		EditAction edit_m = new EditAction();
		DeleteAction delete_m = new DeleteAction();
			
		HelpAction help_m = new HelpAction();
		AboutAction about_m = new AboutAction();
		
		add_m.setName();
		edit_m.setName();
		delete_m.setName();
		
		//Mnemonici
		file.setMnemonic(KeyEvent.VK_F);
		edit.setMnemonic(KeyEvent.VK_E);
		help.setMnemonic(KeyEvent.VK_H);


		//Dodavanje elemenata
		file.add(add_m);	
		file.addSeparator();
		file.add(close_m);
		
		edit.add(edit_m);
		edit.addSeparator();
		edit.add(delete_m);
		
		help.add(help_m);
		help.addSeparator();
		help.add(about_m);
		
		add(file);
		add(edit);
		add(help);	
		
	}
	
}
