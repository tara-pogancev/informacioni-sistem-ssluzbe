package dialog.profesor;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

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

		this.add("Informacije", profInfo);
		this.add("Predmeti", predmeti);

	}

}
