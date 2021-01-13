//#prikaz_studenata
//Reference: Projekat JTableMVCSimple
package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import gui.MainFrame;
import model.BazaStudenata;
import model.Student;

public class AbstractTableModelStudenti extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7349770694737017202L;

	List<Student> studenti = new ArrayList<Student>();
	
	public AbstractTableModelStudenti() {
		studenti = BazaStudenata.getInstance().getStudenti();
		
	}
	
	@Override
	public int getColumnCount() {
		return BazaStudenata.getInstance().getColumnCount();
	}

	@Override
	public int getRowCount() {
		return BazaStudenata.getInstance().getStudenti().size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		
		Student st = this.studenti.get(row);
		
		switch (column) {
		
		case 0:
			return st.getBrojIndeksa();
		case 1:
			return st.getIme();
		case 2:
			return st.getPrezime();
		case 3:
			return st.getTrenutnaGodina();
		case 4:
			if (st.getStatusEnum() == Student.Status.S) {
				return MainFrame.getInstance().getResourceBundle().getString("newBoxSamofinansiranje");
			} else return MainFrame.getInstance().getResourceBundle().getString("newBoxBudzet");

		case 5:
			//double prosekD = st.getProsek();
			//int prosekInt = (int)prosekD * 100;
			//double newProsek = prosekInt / 100;
			//return newProsek;
			return st.getProsek();
			
		default:
			return null;

		}
		
	}
	
	public Class<?> getColumnClass(int colIdx) {

		if (colIdx == 3) {

			return Integer.class;

		} else if (colIdx == 5) {
			
			return Double.class;
			
		}	else {

			return String.class;
		}
	}
		
	
	@Override
	public String getColumnName(int column) {
		return BazaStudenata.getInstance().getColumnName(column);
	}
	

}
