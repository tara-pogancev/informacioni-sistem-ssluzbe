package view;

import javax.swing.table.AbstractTableModel;

import model.BazaProfesora;

public class AbstractTableModelProfesori extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2369167269332597465L;

	public AbstractTableModelProfesori() {
	}

	@Override
	public int getColumnCount() {
		return BazaProfesora.getInstance().getColumnCount();
	}

	@Override
	public String getColumnName(int column) {
		return BazaProfesora.getInstance().getColumnName(column);
	}

	@Override
	public int getRowCount() {
		return BazaProfesora.getInstance().getProfesori().size();
	}

	@Override
	public Object getValueAt(int rowIdx, int columnIdx) {
		return BazaProfesora.getInstance().getValueAt(rowIdx, columnIdx);
	}

}
