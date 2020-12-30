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
		
//	public static IzmenaStudenta close = return IzmenaStudenta;

	public IzmenaStudenta(String idx) {
		
		this.setTitle("Izmena studenta");
		this.setResizable(false);
		this.setSize(650, 550); // X, Y
		
		Student s = BazaStudenata.getInstance().getByIdx(idx);
		this.add(new StudentTabbedPane(s));
		
		this.setLocationRelativeTo(MainFrame.getInstance());
		this.setModal(true);
	}
	
	public void closeDialog() {
		this.dispose();
	}
	
}
