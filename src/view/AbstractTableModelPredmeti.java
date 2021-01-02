//#prikaz_predmeta
//Reference
//Projekat JTableMVCSimple

package view;

import javax.swing.table.AbstractTableModel;

import model.BazaPredmeta;

public class AbstractTableModelPredmeti extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8454002200965331257L;
	
	public AbstractTableModelPredmeti() {}

	@Override
	public int getColumnCount() {
		return BazaPredmeta.getInstance().getColumnCount();
	}

	@Override
	public String getColumnName(int column) {
		return BazaPredmeta.getInstance().getColumnName(column);
	}
	
	@Override
	public int getRowCount() {
		return BazaPredmeta.getInstance().getPredmeti().size();
	}

	@Override
	public Object getValueAt(int rowIdx, int columnIdx) {
		return BazaPredmeta.getInstance().getValueAt(rowIdx, columnIdx);
	}

}
