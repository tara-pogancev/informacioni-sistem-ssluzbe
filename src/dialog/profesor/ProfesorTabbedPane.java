// #izmena_profesora
//#profesor_predaje_predmete

package dialog.profesor;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import gui.MainFrame;
import model.Profesor;

public class ProfesorTabbedPane extends JTabbedPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1579588927709457821L;
	
	JPanel profInfo = new JPanel();
	JPanel predmeti = new JPanel();

	public ProfesorTabbedPane(Profesor p) {

		profInfo = new ProfesorInformacije(p);
		predmeti = new ProfesorPredmeti(p);

		this.add(MainFrame.getInstance().resourceBundle.getString("informacijeTab"), profInfo);
		this.add(MainFrame.getInstance().resourceBundle.getString("tabPredmeti"), predmeti);

	}

}
