//#prikaz_studenata
//Reference: Projekat JTableMVCSimple
package view;

import javax.swing.table.AbstractTableModel;

import model.BazaStudenata;

public class AbstractTableModelStudenti extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7349770694737017202L;


	public AbstractTableModelStudenti() {
		
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
		return BazaStudenata.getInstance().getValueAt(row, column);
	}
	
	@Override
	public String getColumnName(int column) {
		return BazaStudenata.getInstance().getColumnName(column);
	}
	

}
