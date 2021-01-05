// #prikaz_nepolozenih_predmeta
package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.BazaPredmeta;
import model.BazaStudenata;
import model.Predmet;


public class AbstractTableModelNepolozeniIspiti extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9107386218458096017L;
	
	private List<Predmet> predmeti = new ArrayList<Predmet>();
	
	public AbstractTableModelNepolozeniIspiti(String idx) {
		
		predmeti = BazaStudenata.getInstance().getByIdx(idx).getNepolozeniIspiti();
	}
	
	
	@Override
	public int getColumnCount() {
		return BazaPredmeta.getInstance().getColumnCount();
	}

	@Override
	public String getColumnName(int column) {
		return BazaPredmeta.getInstance().getColumnName(column);
	}
	

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Predmet p = predmeti.get(rowIndex);
		
		switch(columnIndex) {
		case 0:
			return p.getSifraPredmeta();
		case 1:
			return p.getNazivPredmeta();
		case 2:
			return p.getESPB();
		case 3:
			return p.getGodinaIzvodjenja();
		case 4:
			return p.getSemestar();
		}
		
		return null;
	}


	@Override
	public int getRowCount() {
		return predmeti.size();
	}

}
