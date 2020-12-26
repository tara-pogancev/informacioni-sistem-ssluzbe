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
	
//	private JTable tabelaStudenata = new StudentiJTable();

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
}
