//#glavni_prozor
//#prikaz_studenata
//#prikaz_profesora
// #pretraga_profesora
// #pretraga_predmeta
// #lokalizacija_srpski
// Referenca: JTableMVCSimple
// Projekat JTableMVCSAdvanced
package gui;

import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.table.TableRowSorter;
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
		
		studTable.getColumnModel().getColumn(0).setHeaderValue(MainFrame.getInstance().resourceBundle.getString("colIdx"));
		studTable.getColumnModel().getColumn(1).setHeaderValue(MainFrame.getInstance().resourceBundle.getString("colName"));
		studTable.getColumnModel().getColumn(2).setHeaderValue(MainFrame.getInstance().resourceBundle.getString("colSurname"));
		studTable.getColumnModel().getColumn(3).setHeaderValue(MainFrame.getInstance().resourceBundle.getString("colGodina"));
		studTable.getColumnModel().getColumn(4).setHeaderValue(MainFrame.getInstance().resourceBundle.getString("colStatus"));
		studTable.getColumnModel().getColumn(5).setHeaderValue(MainFrame.getInstance().resourceBundle.getString("colProsek"));
		
		profTable = new TableTab(Entitet.PROFESORI);
		JScrollPane scrollPaneProf = new JScrollPane(profTable);
		this.add(MainFrame.getInstance().resourceBundle.getString("tabProfesori"), scrollPaneProf);
		
		profTable.getColumnModel().getColumn(0).setHeaderValue(MainFrame.getInstance().resourceBundle.getString("colName"));
		profTable.getColumnModel().getColumn(1).setHeaderValue(MainFrame.getInstance().resourceBundle.getString("colSurname"));
		profTable.getColumnModel().getColumn(2).setHeaderValue(MainFrame.getInstance().resourceBundle.getString("colTitula"));
		profTable.getColumnModel().getColumn(3).setHeaderValue(MainFrame.getInstance().resourceBundle.getString("colZvanje"));

		predmTable = new TableTab(Entitet.PREDMETI);
		JScrollPane scrollPanePredm = new JScrollPane(predmTable);
		this.add(MainFrame.getInstance().resourceBundle.getString("tabPredmeti"), scrollPanePredm);
		
		predmTable.getColumnModel().getColumn(0).setHeaderValue(MainFrame.getInstance().resourceBundle.getString("colSifraProj"));
		predmTable.getColumnModel().getColumn(1).setHeaderValue(MainFrame.getInstance().resourceBundle.getString("colNazivProj"));
		predmTable.getColumnModel().getColumn(2).setHeaderValue(MainFrame.getInstance().resourceBundle.getString("colESPB"));
		predmTable.getColumnModel().getColumn(3).setHeaderValue(MainFrame.getInstance().resourceBundle.getString("colGodPredm"));
		predmTable.getColumnModel().getColumn(4).setHeaderValue(MainFrame.getInstance().resourceBundle.getString("colSemestar"));

	}

	public int getSellectedTableRow() {
		
		 TabbedPane temp =  MainFrame.getTabbedPane();
		 int currentTab = temp.getSelectedIndex();
		 int idx = 0;
		 
		 switch (currentTab) {
		 case 0: 	idx = studTable.getSelectedRow();
		 			break;
		 case 1:	idx = profTable.getSelectedRow();
		 			break;
		 case 2:   	idx = predmTable.getSelectedRow();
			 		break;
		 }
		 
		return idx;
	}
	
	public String getStudentIdx() {
		String idx = (String) studTable.getValueAt(studTable.getSelectedRow(), 0);
		return idx;		
	}
	
	public String getProfesorBlc() {
		
		String blc = (String) profTable.getValueAt(profTable.getSelectedRow(), 4);
		return blc;
	}

	public String getPredmetSifra() {
		
		String sifra = (String) predmTable.getValueAt(predmTable.getSelectedRow(), 0);
		return sifra;
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
	
	public void setFilterPredmet(TableRowSorter<AbstractTableModelPredmeti> sorter) {
		
		predmTable.setRowSorter(sorter);
	}
	
	public void setFilterProfesor(TableRowSorter<AbstractTableModelProfesori> sorter) {
		
		profTable.setRowSorter(sorter);
	}
	
	public void tabbedPaneInit() {
				
		studTable.getColumnModel().getColumn(0).setHeaderValue(MainFrame.getInstance().resourceBundle.getString("colIdx"));
		studTable.getColumnModel().getColumn(1).setHeaderValue(MainFrame.getInstance().resourceBundle.getString("colName"));
		studTable.getColumnModel().getColumn(2).setHeaderValue(MainFrame.getInstance().resourceBundle.getString("colSurname"));
		studTable.getColumnModel().getColumn(3).setHeaderValue(MainFrame.getInstance().resourceBundle.getString("colGodina"));
		studTable.getColumnModel().getColumn(4).setHeaderValue(MainFrame.getInstance().resourceBundle.getString("colStatus"));
		studTable.getColumnModel().getColumn(5).setHeaderValue(MainFrame.getInstance().resourceBundle.getString("colProsek"));
		
		profTable.getColumnModel().getColumn(0).setHeaderValue(MainFrame.getInstance().resourceBundle.getString("colName"));
		profTable.getColumnModel().getColumn(1).setHeaderValue(MainFrame.getInstance().resourceBundle.getString("colSurname"));
		profTable.getColumnModel().getColumn(2).setHeaderValue(MainFrame.getInstance().resourceBundle.getString("colTitula"));
		profTable.getColumnModel().getColumn(3).setHeaderValue(MainFrame.getInstance().resourceBundle.getString("colZvanje"));
		
		predmTable.getColumnModel().getColumn(0).setHeaderValue(MainFrame.getInstance().resourceBundle.getString("colSifraProj"));
		predmTable.getColumnModel().getColumn(1).setHeaderValue(MainFrame.getInstance().resourceBundle.getString("colNazivProj"));
		predmTable.getColumnModel().getColumn(2).setHeaderValue(MainFrame.getInstance().resourceBundle.getString("colESPB"));
		predmTable.getColumnModel().getColumn(3).setHeaderValue(MainFrame.getInstance().resourceBundle.getString("colGodPredm"));
		predmTable.getColumnModel().getColumn(4).setHeaderValue(MainFrame.getInstance().resourceBundle.getString("colSemestar"));
		
	}
	
}
