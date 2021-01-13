//#prikaz_polozenih_ispita
//#ponistavanje_ocene
package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import gui.MainFrame;
import model.BazaStudenata;
import model.Ocena;

public class AbstractTableModelOcene extends AbstractTableModel{


	/**
	 * 
	 */
	private static final long serialVersionUID = 7087621529336960708L;
	
	private List<Ocena> ocene = new ArrayList<Ocena>();
	private String[] columnNames = {MainFrame.getInstance().getResourceBundle().getString("colSifraProj"), MainFrame.getInstance().getResourceBundle().getString("colNazivProj"), 
			MainFrame.getInstance().getResourceBundle().getString("colESPB"), MainFrame.getInstance().getResourceBundle().getString("ocena"), MainFrame.getInstance().getResourceBundle().getString("polDatum")};
	
	public AbstractTableModelOcene (String idx) {
		ocene = BazaStudenata.getInstance().getByIdx(idx).getOcene();
	}
	
    @Override
    public String getColumnName(int columnIndex){
         return columnNames[columnIndex];
    }
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return ocene.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Ocena temp = ocene.get(row);
		switch (col) {
		case 0:
			return temp.getPredmet().getSifraPredmeta();

		case 1:
			return temp.getPredmet().getNazivPredmeta();
			
		case 2:
			return temp.getPredmet().getESPB();
			
		case 3:
			return temp.getOcena();
			
		case 4:
			return temp.getDatum();
		}
		return null;
	}

	 @Override
	   public Class<?> getColumnClass(int columnIndex){
	          switch (columnIndex){
	             case 0:
	               return String.class;
	             case 1:
	               return String.class;
	             case 2:
	               return Integer.class;
	             case 3:
	               return Integer.class;
	             case 4:
	               return String.class;
	             }
	             return null;
	      }
	
	
}
