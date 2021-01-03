//#brisanje_studenta
//#brisanje_profesora
package listeners.action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import controller.PredmetiController;
import controller.ProfesoriController;
import controller.StudentController;
import gui.MainFrame;
import gui.TabbedPane;
import model.Predmet;
import model.Profesor;

public class DeleteAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6760985195515950519L;

	public DeleteAction() {

//		putValue(NAME, "Delete");
//		putValue(MNEMONIC_KEY, KeyEvent.VK_E);
		putValue(SHORT_DESCRIPTION, "Delete");
		putValue(SMALL_ICON, new ImageIcon("images" + File.separator + "trash-icon.png"));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		putValue(MNEMONIC_KEY, KeyEvent.VK_D);
	}

	public void setName() {
		putValue(NAME, "Delete");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		// System.out.println("Action: Delete");

		TabbedPane temp = MainFrame.getTabbedPane();
		int current_tab = temp.getSelectedIndex();

		// Provera da je bilo koji red izabran
		int sellected_row = MainFrame.getTabbedPane().getSellectedTableRow();
		
		if (sellected_row != -1) 
			switch (current_tab) {
			case 0: 
				StudentController.getInstance().izbrisiStudenta(temp.getStudentIdx());
				break;
			case 1:
				Profesor p = temp.getIzabraniProfesor();
				
				if (p != null) 
					ProfesoriController.getInstance().izbrisiProfesora(temp.getIzabraniProfesor());
				break;
			case 2: 
				Predmet predmet = temp.getIzabraniPredmet();
				
				if(predmet != null)
					PredmetiController.getInstance().izbrisiPredmet(temp.getIzabraniPredmet());
				
				break;
			}
		
	}

}
