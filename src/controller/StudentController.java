//#izmena_studenta
//#brisanje_studenta
//#prikaz_studenata
//#sortiranje_studenata

//Reference: Projekat JTableMVCSimple

package controller;

import javax.swing.JOptionPane;

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
	
    public void izbrisiStudenta(String idx) {

		int id = JOptionPane.showConfirmDialog(null,
				"Da li ste sigurni da želite da obrišete studenta [" + idx + "]?",
				"Brisanje studenta", JOptionPane.YES_NO_OPTION);

		if (id == JOptionPane.YES_OPTION) {

			BazaStudenata.getInstance().izbrisiStudenta(idx);
			MainFrame.getTabbedPane().azurirajS();
		}
    }
	
	public void izmeniStudenta(Student promene, String idx) {

		BazaStudenata.getInstance().izmeniStudenta(promene, idx);

		MainFrame.getTabbedPane().azurirajS();
	}
	
	
}
