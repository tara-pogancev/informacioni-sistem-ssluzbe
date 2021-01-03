// #pretraga_studenata

package listeners.action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import gui.MainFrame;
import gui.TabbedPane;
import gui.Toolbar;
import view.StudentFilter;

public class SearchAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5832550447814405219L;

	public SearchAction() {
		putValue(SHORT_DESCRIPTION, "Search");
		putValue(SMALL_ICON, new ImageIcon("images" + File.separator + "search-icon2.png"));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		String search = Toolbar.getSearchText();
		
		TabbedPane temp = MainFrame.getTabbedPane();
		
		int current_tab = temp.getSelectedIndex();
		switch (current_tab) {
		case 0: 
			//PRETRAGA STUDENATA
			
			if (search != null && !search.equals("Search...")) {
				StudentFilter sorter = new StudentFilter(search);
				MainFrame.getTabbedPane().setFilterS(sorter);
			} else {
				MainFrame.getTabbedPane().setFilterS(null);
			}
			
			break;
		case 1:
			// TODO: Sortiranje profesora
			break;
		case 2: 
			// TODO: Sortiranje predmeta
			break;
		}
		
		
	}
}
