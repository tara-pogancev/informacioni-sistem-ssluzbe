// #pretraga_studenata
// #pretraga_profesora
// #pretraga_predmeta

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
import view.PretragaPredmeta;
import view.PretragaProfesora;
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
		
		int currentTab = temp.getSelectedIndex();
		switch (currentTab) {
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
			
			if (search != null && !search.equals("Search...")) {
				PretragaProfesora pretragaProf = new PretragaProfesora(search);
				MainFrame.getTabbedPane().setFilterProfesor(pretragaProf);
			} else {
				MainFrame.getTabbedPane().setFilterProfesor(null);
			}
			
			break;
		case 2: 
			
			if (search != null && !search.equals("Search...")) {
				PretragaPredmeta pretragaPredm = new PretragaPredmeta(search);
				MainFrame.getTabbedPane().setFilterPredmet(pretragaPredm);
			} else {
				MainFrame.getTabbedPane().setFilterPredmet(null);
			}
			
			break;
		}
		
		
	}
}
