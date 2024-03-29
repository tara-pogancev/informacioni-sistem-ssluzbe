//#izmena_studenta
//#izmena_predmeta
//#izmena_profesora

package listeners.action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import dialog.IzmenaPredmeta;
import dialog.IzmenaProfesora;
import dialog.IzmenaStudenta;
import gui.MainFrame;
import gui.TabbedPane;
import model.BazaPredmeta;
import model.Predmet;

public class EditAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7994641257537406598L;

	public EditAction() {
		
		putValue(SHORT_DESCRIPTION, MainFrame.getInstance().resourceBundle.getString("edit"));
		putValue(SMALL_ICON, new ImageIcon("images" + File.separator + "edit.png"));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		putValue(MNEMONIC_KEY, KeyEvent.VK_U);
	}

	public void setName() {
		putValue(NAME, MainFrame.getInstance().resourceBundle.getString("edit"));
	}
	
	public void updateName() {
		
		putValue(SHORT_DESCRIPTION, MainFrame.getInstance().getResourceBundle().getString("edit"));
		
		if (MainFrame.getInstance().getResourceBundle().getString("English").equals("English")) {
			
			putValue(MNEMONIC_KEY, KeyEvent.VK_E);

			
		} else {
			
			putValue(MNEMONIC_KEY, KeyEvent.VK_U);

		}
		
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		// System.out.println("Action: Edit");

		TabbedPane temp = MainFrame.getTabbedPane();
		int currentTab = temp.getSelectedIndex();

		// Provera da je bilo koji red izabran
		int sellectedRow = temp.getSellectedTableRow();
		if (sellectedRow != -1)
			switch (currentTab) {
			case 0:
				new IzmenaStudenta(temp.getStudentIdx()).setVisible(true);
				break;
				
			case 1:
				new IzmenaProfesora(temp.getProfesorBlc()).setVisible(true);
				break;
				
			case 2:

				Predmet p = BazaPredmeta.getInstance().findById(temp.getPredmetSifra());
				
				new IzmenaPredmeta(p).setVisible(true);

				break;
			}
	}

}
