// #izmena_profesora
// #profesor_predaje_predmete

package dialog;

import javax.swing.JDialog;

import dialog.profesor.ProfesorTabbedPane;
import gui.MainFrame;
import model.BazaProfesora;
import model.Profesor;

public class IzmenaProfesora extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6546302963399565722L;

	
	public IzmenaProfesora(String blc) {
		
		this.setTitle(MainFrame.getInstance().resourceBundle.getString("izmenaProf"));
		this.setResizable(false);
		this.setSize(650, 500);
		
		Profesor p = BazaProfesora.getInstance().nadjiBlc(blc);
		
		this.add(new ProfesorTabbedPane(p));
		
		this.setLocationRelativeTo(MainFrame.getInstance());
		this.setModal(true);
		
	}
	
	
}
