//#izmena_studenta
//#prikaz_polozenih_ispita
//#prikaz_neplozenih_ispita

package dialog.student;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import model.Student;

public class StudentTabbedPane extends JTabbedPane{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6633310045086742052L;

	public StudentTabbedPane(Student s) {
		
		JPanel info = new StudentInformacije(s);
		JPanel polozeni = new StudentPolozeni(s);
		JPanel nepolozeni = new StudentNepolozeni(s);
		
		this.add("Informacije", info);
		this.add("Položeni", polozeni);
		this.add("Nepoloženi", nepolozeni);
		
	}
}
