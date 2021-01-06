// #izmena_profesora
// #profesor_predaje_predmete

package dialog;

import javax.swing.JDialog;

import controller.ProfesoriController;
import dialog.profesor.ProfesorTabbedPane;
import gui.MainFrame;
import model.Profesor;

public class IzmenaProfesora extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6546302963399565722L;

	
	public IzmenaProfesora(Profesor p) {
		
		ProfesoriController.getInstance().initPredmet(p.getBrojLicneKarte());
		
		this.setTitle("Izmena profesora");
		this.setResizable(false);
		this.setSize(650, 500);
		
		this.add(new ProfesorTabbedPane(p));
		
		this.setLocationRelativeTo(MainFrame.getInstance());
		this.setModal(true);
		
	}
	
}
