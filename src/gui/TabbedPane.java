//#glavni_prozor
//#prikaz_studenata
// Referenca: JTableMVCSimple
package gui;

import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import view.AbstractTableModelProfesori;
import view.AbstractTableModelStudenti;
import view.StudentiJTable;

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

	private JTable tabelaStudenata = new StudentiJTable();
	
	public TabbedPane() {

		studTable = new TableTab(Entitet.STUDENTI);
		JScrollPane scrollPaneStud = new JScrollPane(tabelaStudenata);
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
		AbstractTableModelStudenti model = (AbstractTableModelStudenti) tabelaStudenata.getModel();
		model.fireTableDataChanged();
		validate();
	}


	public void azurirajProfesora() {
		
		AbstractTableModelProfesori atmProf = (AbstractTableModelProfesori) profTable.getModel();
		atmProf.fireTableDataChanged();
		validate();
		
		
	}
}
