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
	public Object getValueAt(int rowIdx, int columnIdx) {
		
		//return BazaPredmeta.getInstance().getValueAt(rowIdx, columnIdx);
		
		Predmet predmet = this.predmeti.get(rowIdx);

		switch (columnIdx) {

		case 0:
			return predmet.getSifraPredmeta();
		case 1:
			return predmet.getNazivPredmeta();
		case 2:
			return predmet.getESPB();
		case 3:
			return predmet.getGodinaIzvodjenja(); 
		case 4:
			return predmet.getSemestar();
		default:
			return null;

		}
		
	}
	
	public Class<?> getColumnClass(int colIdx){
		
		if(colIdx == 2 || colIdx == 3) {
			
			return Integer.class;
			
		}else {
			
			return String.class;
		}
	}


	@Override
	public int getRowCount() {
		return predmeti.size();
	}

}
