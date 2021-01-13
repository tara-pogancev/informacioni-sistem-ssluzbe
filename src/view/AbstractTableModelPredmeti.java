//#prikaz_predmeta
//Reference
//Projekat JTableMVCSimple

package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import gui.MainFrame;
import model.BazaPredmeta;
import model.Predmet;

public class AbstractTableModelPredmeti extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8454002200965331257L;
	
	List<Predmet> predmeti = new ArrayList<Predmet>();

	public AbstractTableModelPredmeti() {
		
		predmeti = BazaPredmeta.getInstance().getPredmeti();
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
	public int getRowCount() {
		return BazaPredmeta.getInstance().getPredmeti().size();
	}

	@Override
	public Object getValueAt(int rowIdx, int columnIdx) {

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
			
			if (predmet.getSemestarE() == Predmet.Semestar.LETNJI) {

				return MainFrame.getInstance().getResourceBundle().getString("boxLetnji");
			} else {

				return MainFrame.getInstance().getResourceBundle().getString("boxZimski");

			}
			
		default:
			return null;

		}
	}

	public Class<?> getColumnClass(int colIdx) {

		if (colIdx == 2 || colIdx == 3) {

			return Integer.class;

		} else {

			return String.class;
		}
	}

}
