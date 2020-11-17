// #menu_bar

package gui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainMenu extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4905765460781590696L;


	public MainMenu() {
		
		JMenu file = new JMenu("File");
		JMenu edit = new JMenu("Edit");
		JMenu help = new JMenu("Help");
		
		JMenuItem new_m = new JMenuItem("New");
		JMenuItem close_m = new JMenuItem("Close");
		
		JMenuItem edit_m = new JMenuItem("Edit");
		JMenuItem delete_m = new JMenuItem("Delete");
		
		JMenuItem help_m = new JMenuItem("Help");
		JMenuItem about_m = new JMenuItem("About");
		
		file.add(new_m);
		file.addSeparator();
		file.add(close_m);
		
		edit.add(edit_m);
		edit.addSeparator();
		edit.add(delete_m);
		
		help.add(help_m);
		help.addSeparator();
		help.add(about_m);
		
		//TODO DODATI IKONICE I FUNKCIONALNOSTI
		
		add(file);
		add(edit);
		add(help);	
		
	}
	
}
