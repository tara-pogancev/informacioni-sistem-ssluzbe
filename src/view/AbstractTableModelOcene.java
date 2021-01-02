//#prikaz_polozenih_ispita
package view;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Ocena;
import model.Student;

public class AbstractTableModelOcene extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3997656591847752563L;

	private List<Ocena> ocene = null;
	private String[] columnNames = {"Šifra predmeta", "Naziv predmeta", "ESPB", "Ocena", "Datum"};
	
	public AbstractTableModelOcene (Student s) {
		ocene = s.getOcene();
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
