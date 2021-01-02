package dialog;

import javax.swing.JDialog;

import dialog.profesor.ProfesorTabbedPane;
import gui.MainFrame;
import model.Profesor;

public class IzmenaProfesora extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6546302963399565722L;

	public static IzmenaProfesora instance = null;
	private static String trenutniBlc = null;
	
	private IzmenaProfesora(Profesor p) {
		
		trenutniBlc = p.getBrojLicneKarte();
		initialise(p);
	}
	
	public void initialise(Profesor p) {
		
		this.setTitle("Izmena profesora");
		this.setResizable(false);
		this.setSize(650, 500);
		
		this.add(new ProfesorTabbedPane(p));
		
		this.setLocationRelativeTo(MainFrame.getInstance());
		this.setModal(true);
		
		
	}
	
	
	public void zatvoriDijalog() {
		
		this.dispose();
	}
	
	public static IzmenaProfesora getInstance(Profesor p) {
		
		String blc = p.getBrojLicneKarte();
		
		if(instance == null || !trenutniBlc.equals(blc)) {
			instance = new IzmenaProfesora(p);
		}
		
		return instance;
	}
}
