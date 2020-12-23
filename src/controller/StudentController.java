//#izmena_studenta
//#brisanje_studenta
//#prikaz_studenta

//Reference: Projekat JTableMVCSimple

package controller;

import gui.MainFrame;
import model.BazaStudenata;
import model.Student;
public class StudentController {

	private static StudentController instance = null;
	
	public static StudentController getInstance() {
		if (instance == null) {
			instance = new StudentController();
		}
		return instance;
	}
	
	private StudentController() {}

	public void addStudent(Student s) {
		BazaStudenata.getInstance().dodajStudenta(s);
		MainFrame.getTabbedPane().azurirajS();
		
	}
	
    public void izbrisiStudenta(int rowSelectedIndex) {
    	if (rowSelectedIndex < 0) {
			return;
		}
    	Student student = BazaStudenata.getInstance().getRow(rowSelectedIndex);
		BazaStudenata.getInstance().izbrisiStudenta(student.getBrojIndeksa());
		MainFrame.getTabbedPane().azurirajS();
    }
	
	public void izmeniStudenta(int rowSelectedIndex) {
		if (rowSelectedIndex < 0) {
			return;
		}
		Student student = BazaStudenata.getInstance().getRow(rowSelectedIndex);
		BazaStudenata.getInstance().izmeniStudenta(student);

		MainFrame.getTabbedPane().azurirajS();
	}
	
	
	
}
