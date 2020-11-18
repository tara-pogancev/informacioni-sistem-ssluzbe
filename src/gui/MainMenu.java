// #menu_bar
// Reference:
// Projekat Dogadjaji
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

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
		
		JMenuItem new_m = new JMenuItem("New");
		JMenuItem close_m = new JMenuItem("Close");
		
		JMenuItem edit_m = new JMenuItem("Edit");
		JMenuItem delete_m = new JMenuItem("Delete");
		
		JMenuItem help_m = new JMenuItem("Help");
		JMenuItem about_m = new JMenuItem("About");
		
		//Mnemonici, akceleratori, ikonice
		file.setMnemonic(KeyEvent.VK_F);
		edit.setMnemonic(KeyEvent.VK_E);
		help.setMnemonic(KeyEvent.VK_H);
		
		new_m.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.ALT_MASK + ActionEvent.SHIFT_MASK));
		close_m.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.ALT_MASK + ActionEvent.SHIFT_MASK));
		edit_m.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		delete_m.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, ActionEvent.CTRL_MASK));
		help_m.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, ActionEvent.CTRL_MASK));
		about_m.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.ALT_MASK));
		
		new_m.setIcon(new ImageIcon("images/add.png"));
		close_m.setIcon(new ImageIcon("images/delete.png"));
		edit_m.setIcon(new ImageIcon("images/edit.png"));
		delete_m.setIcon(new ImageIcon("images/trash-icon.png"));
		help_m.setIcon(new ImageIcon("images/alert.png"));
		about_m.setIcon(new ImageIcon("images/information.png"));
		
		//Dodavanje funkcionalnosti
		help_m.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new HelpDialog().setVisible(true);
			}
		});
		
		about_m.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new AboutDialog().setVisible(true);
			}
		});
		
		//Dodavanje elemenata
		file.add(new_m);
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
