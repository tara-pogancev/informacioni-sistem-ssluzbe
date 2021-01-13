// #menu_bar
// #lokalizacija_engleski
// #lokalizacija_srpski
// Reference:
// Projekat Dogadjaji

package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Locale;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import listeners.action.*;

public class MainMenu extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4905765460781590696L;

		private JCheckBoxMenuItem mniEngleski;
		private JCheckBoxMenuItem mniSrpski;
		private JMenu file;
		private JMenu edit;
		private JMenu help;
	
	public MainMenu() {
		
		//Bazna konstrukcija
		file = new JMenu(MainFrame.getInstance().getResourceBundle().getString("file"));
		edit = new JMenu(MainFrame.getInstance().getResourceBundle().getString("edit"));
		help = new JMenu(MainFrame.getInstance().getResourceBundle().getString("help"));
		
		AddNewAction addM = new AddNewAction();
		CloseAppAction closeM = new CloseAppAction();
		
		EditAction editM = new EditAction();
		DeleteAction deleteM = new DeleteAction();
			
		HelpAction helpM = new HelpAction();
		AboutAction aboutM = new AboutAction();
		
		JMenuItem jezikM = new JMenuItem(MainFrame.getInstance().getResourceBundle().getString("jezik"));
		
		addM.setName();
		editM.setName();
		deleteM.setName();
		
		mniEngleski = new JCheckBoxMenuItem(MainFrame.getInstance().getResourceBundle().getString("English"));
		mniSrpski = new JCheckBoxMenuItem(MainFrame.getInstance().getResourceBundle().getString("Serbian"));
		mniSrpski.setSelected(true);
		
		mniSrpski.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Locale.setDefault(new Locale("sr", "RS"));
				MainFrame.getInstance().changeLanguage();
				mniEngleski.setSelected(false);
			}
			
		});
		
		
		mniEngleski.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Locale.setDefault(new Locale("en", "US"));
				MainFrame.getInstance().changeLanguage();
				mniSrpski.setSelected(false);
				
			}
		}); 	
		
		//jezikM.setMnemonic(KeyEvent.VK_L);
		jezikM.add(mniSrpski);
		jezikM.add(mniEngleski);
		
		//Mnemonici
		file.setMnemonic(KeyEvent.VK_F);
		edit.setMnemonic(KeyEvent.VK_U);
		help.setMnemonic(KeyEvent.VK_P);


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
		help.addSeparator();
		help.add(mniSrpski);
		help.add(mniEngleski);
		
		add(file);
		add(edit);
		add(help);	
		
	}
	
	public void initMenu() {
		
		file.setText(MainFrame.getInstance().getResourceBundle().getString("file"));
		edit.setText(MainFrame.getInstance().getResourceBundle().getString("edit"));
		help.setText(MainFrame.getInstance().getResourceBundle().getString("help"));
		mniEngleski.setText(MainFrame.getInstance().getResourceBundle().getString("English"));
		mniSrpski.setText(MainFrame.getInstance().getResourceBundle().getString("Serbian"));
				
		if (MainFrame.getInstance().getResourceBundle().getString("English").equals("English")) {
			
			file.setMnemonic(KeyEvent.VK_F);
			edit.setMnemonic(KeyEvent.VK_E);
			help.setMnemonic(KeyEvent.VK_H);
			
			
		} else {
			
			file.setMnemonic(KeyEvent.VK_F);
			edit.setMnemonic(KeyEvent.VK_U);
			help.setMnemonic(KeyEvent.VK_P);
			
		}
		
	}
	
}
