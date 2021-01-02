//#izmena_studenta
//#prikaz_polozenih_ispita
//#prikaz_neplozenih_ispita


package dialog;

import javax.swing.JDialog;

import dialog.student.StudentTabbedPane;
import gui.MainFrame;
import model.BazaStudenata;
import model.Student;

public class IzmenaStudenta extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6768600238220813587L;
		
	public static IzmenaStudenta instance = null;
	private static String current_idx = null;

	private IzmenaStudenta(String idx) {
		current_idx = idx;
		initialise(idx);
	}
	
	public void initialise(String idx) {
		
		this.setTitle("Izmena studenta");
		this.setResizable(false);
		this.setSize(700, 550); // X, Y
		
		Student s = BazaStudenata.getInstance().getByIdx(idx);
		this.add(new StudentTabbedPane(s));
		
	//	this.setDefaultCloseOperation(IzmenaStudenta.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(MainFrame.getInstance());
		this.setModal(true);
	}
	
	public void closeDialog() {
		this.dispose();
	}
	
	public static IzmenaStudenta getInstance(String idx) {
		
		if (instance == null || !current_idx.equals(idx))
			instance = new IzmenaStudenta(idx);

		return instance;
	}
	
	

}
