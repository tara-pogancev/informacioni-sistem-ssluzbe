//#glavni_prozor
//#prikaz_studenata
//#prikaz_profesora
// Referenca: JTableMVCSimple
// Projekat JTableMVCSAdvanced
package gui;

import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.table.TableRowSorter;

import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaStudenata;
import model.Predmet;
import model.Profesor;
import model.Student;
import view.AbstractTableModelPredmeti;
import view.AbstractTableModelProfesori;
import view.AbstractTableModelStudenti;

public class TabbedPane extends JTabbedPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7566425700154666023L;

	enum Entitet {
		STUDENTI, PROFESORI, PREDMETI
	}

	JPanel studPanel = new JPanel();
	static TableTab studTable;
	JPanel profPanel = new JPanel();
	static TableTab profTable;
	JPanel predmPanel = new JPanel();
	static TableTab predmTable;
	public static Entitet ent = Entitet.STUDENTI;
	
	public TabbedPane() {

		studTable = new TableTab(Entitet.STUDENTI);
		JScrollPane scrollPaneStud = new JScrollPane(studTable);
		this.add("Studenti", scrollPaneStud);
		
		profTable = new TableTab(Entitet.PROFESORI);
		JScrollPane scrollPaneProf = new JScrollPane(profTable);
		this.add("Profesori", scrollPaneProf);

		predmTable = new TableTab(Entitet.PREDMETI);
		JScrollPane scrollPanePredm = new JScrollPane(predmTable);
		this.add("Predmeti", scrollPanePredm);

	}

	public int getSellectedTableRow() {
		
		 TabbedPane temp =  MainFrame.getTabbedPane();
		 int current_tab = temp.getSelectedIndex();
		 int idx = 0;
		 
		 //TODO: Popuniti za profesora i predmete
		 switch (current_tab) {
		 case 0: 	idx = studTable.getSelectedRow();
		 			break;
		 case 1:	//...
		 			break;
		 case 2:   	//...
			 		break;
		 }
		 
		return idx;
	}
	
	public String getStudentIdx() {
		String idx = (String) studTable.getValueAt(studTable.getSelectedRow(), 0);
		return idx;		
	}
	
	//TODO: Napraviti tako da funkcija vraca profesora nezavisno od sortiranja
	public Profesor getIzabraniProfesor() {
		
		if(profTable.getSelectedRow() < 0) {
			
			return null;

		}
		
		Profesor p = BazaProfesora.getInstance().getRow(profTable.getSelectedRow());
		return p;
	}
	
	public Predmet getIzabraniPredmet() {
		
		if(predmTable.getSelectedRow() < 0) {
			
			return null;
		}
		
		Predmet p = BazaPredmeta.getInstance().getRow(predmTable.getSelectedRow());
		return p;
	}

	public void addTab(String title, Component component) {
		super.addTab(title, null, component);
	}

	// Ref: public void azurirajPrikaz(String akcija, int vrednost)
	public void azurirajS() {
		AbstractTableModelStudenti model = (AbstractTableModelStudenti) studTable.getModel();
		model.fireTableDataChanged();
		validate();
	}


	public void azurirajProfesora() {
		
		AbstractTableModelProfesori atmProf = (AbstractTableModelProfesori) profTable.getModel();
		atmProf.fireTableDataChanged();
		validate();
		
		
	}

	public void azurirajPredmet() {
		
		AbstractTableModelPredmeti atmPredmet = (AbstractTableModelPredmeti) predmTable.getModel();
		atmPredmet.fireTableDataChanged();
		validate();
		
	}
	
	//Pretraga
	public void setFilterS(TableRowSorter<AbstractTableModelStudenti> sorter) {
		
		studTable.setRowSorter(sorter);
		
	}

	public Student getIzabraniStudent() {
		
		if(studTable.getSelectedRow() < 0) {
			
			return null;
		}
		
		Student s = BazaStudenata.getInstance().getRow(studTable.getSelectedRow());
		return s;
	}

	
}
