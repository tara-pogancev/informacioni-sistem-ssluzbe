//#izmena_studenta
//#brisanje_studenta
//#prikaz_studenata
//#sortiranje_studenata
//#ponistavanje_ocene
//#prikaz_nepolozenih_ispita
//#uklanjanje_predmeta_sa_studenta
//Reference: Projekat JTableMVCSimple

package controller;

import javax.swing.JOptionPane;

import gui.MainFrame;
import model.BazaStudenata;
import model.Predmet;
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

		Object[] choices = {"Da", "Ne"};
		Object defaultChoice = choices[0];
		
		int id = JOptionPane.showOptionDialog(MainFrame.getInstance(),
				"Da li ste sigurni da želite da obrišete studenta [" + idx + "]?",
				"Brisanje studenta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, choices, defaultChoice);

		if (id == JOptionPane.YES_OPTION) {

			BazaStudenata.getInstance().izbrisiStudenta(idx);
			MainFrame.getTabbedPane().azurirajS();
		}
    }
	
	public void izmeniStudenta(Student promene, String idx) {

		BazaStudenata.getInstance().izmeniStudenta(promene, idx);

		MainFrame.getTabbedPane().azurirajS();
	}
	
	public void ponistiOcenu(String student, Predmet p) {
		
		BazaStudenata.getInstance().ponistiOcenu(student, p);
		
		MainFrame.getTabbedPane().azurirajS();
		
	}
	
	public void ukloniPredmet(String student, String p) {
		
		BazaStudenata.getInstance().ukloniPredmet(student, p);
		
		MainFrame.getTabbedPane().azurirajS();
	}
	
	public void dodajPredmet(String student, Predmet p) {
		
		BazaStudenata.getInstance().dodajPredmet(student, p);
		
		MainFrame.getTabbedPane().azurirajS();
		
	}
	
	
	
}
