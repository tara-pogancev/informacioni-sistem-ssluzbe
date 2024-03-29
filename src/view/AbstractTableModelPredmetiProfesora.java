//#profesor_predaje_predmete
package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import gui.MainFrame;
import model.BazaPredmeta;
import model.BazaProfesora;
import model.Predmet;

public class AbstractTableModelPredmetiProfesora extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3637639587431835078L;

	private List<Predmet> predmeti = new ArrayList<Predmet>();
	private String[] kolone = { MainFrame.getInstance().resourceBundle.getString("colSifraProj"),
			MainFrame.getInstance().resourceBundle.getString("colNazivProj"),
			MainFrame.getInstance().resourceBundle.getString("colGodPredm"),
			MainFrame.getInstance().resourceBundle.getString("colSemestar") };

	public AbstractTableModelPredmetiProfesora(String blc) {

		predmeti = BazaProfesora.getInstance().nadjiBlc(blc).getPredmeti();
	}

	public void dodajPredmet(String sifra) {

		Predmet p = BazaPredmeta.getInstance().findById(sifra);

		predmeti.add(p);

	}

	@Override
	public String getColumnName(int columnIndex) {
		return kolone[columnIndex];
	}

	@Override
	public int getColumnCount() {
		return kolone.length;
	}

	@Override
	public int getRowCount() {
		return predmeti.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Predmet p = predmeti.get(rowIndex);

		switch (columnIndex) {
		case 0:
			return p.getSifraPredmeta();
		case 1:
			return p.getNazivPredmeta();
		case 2:
			return p.getGodinaIzvodjenja();
		case 3:
			if (p.getSemestarE() == Predmet.Semestar.LETNJI) {

				return MainFrame.getInstance().getResourceBundle().getString("boxLetnji");
			} else {

				return MainFrame.getInstance().getResourceBundle().getString("boxZimski");

			}
		default:
			return null;
		}

	}

	public Class<?> getColumnClass(int colIdx) {

		if (colIdx == 2) {

			return Integer.class;

		} else {

			return String.class;
		}
	}
}
