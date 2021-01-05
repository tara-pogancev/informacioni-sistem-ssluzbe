// #prikaz_nepolozenih_predmeta
package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.BazaNepolozenihIspita;
import model.Predmet;


public class AbstractTableModelNepolozeniIspiti extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9107386218458096017L;
	
	private List<Predmet> predmeti = new ArrayList<Predmet>();
	
	public AbstractTableModelNepolozeniIspiti(String idx) {
		
		predmeti = BazaNepolozenihIspita.getInstance().getNepolozeni(idx);
	}
	
	
	@Override
	public int getColumnCount() {
		return BazaNepolozenihIspita.getInstance().getColumnCount();
	}

	@Override
	public String getColumnName(int column) {
		return BazaNepolozenihIspita.getInstance().getColumnName(column);
	}
	

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaNepolozenihIspita.getInstance().getValueAt(rowIndex, columnIndex);
	}


	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
