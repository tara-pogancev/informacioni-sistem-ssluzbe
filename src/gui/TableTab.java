//#prikaz_profesora
//#prikaz_studenata
//#prikaz_predmeta
// #sortiranje_predmeta
// #sortiranje_profesora
//#sortiranje_profesora

package gui;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

import gui.TabbedPane.Entitet;
import view.AbstractTableModelPredmeti;
import view.AbstractTableModelProfesori;
import view.AbstractTableModelStudenti;

public class TableTab extends JTable {

	private static final long serialVersionUID = 7816932867726992196L;

	public TableTab(Entitet ent) {

		switch (ent) {

		case STUDENTI:

			this.setRowSelectionAllowed(true);
			this.setColumnSelectionAllowed(true);
			this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			this.setAutoCreateRowSorter(true);
			this.getTableHeader().setReorderingAllowed(false);
			this.setModel(new AbstractTableModelStudenti());
			break;

		case PROFESORI:

			this.setRowSelectionAllowed(true);
			this.setColumnSelectionAllowed(true);
			this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			this.setAutoCreateRowSorter(true);
			this.getTableHeader().setReorderingAllowed(false);
			AbstractTableModelProfesori atmProfesori = new AbstractTableModelProfesori();
			this.setModel(atmProfesori);
			this.getColumn("Blc").setMinWidth(0);
			this.getColumn("Blc").setMaxWidth(0);
			this.getColumn("Blc").setWidth(0);
			break;

		case PREDMETI:

			this.setRowSelectionAllowed(true);
			this.setColumnSelectionAllowed(true);
			this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			this.setAutoCreateRowSorter(true);
			this.getTableHeader().setReorderingAllowed(false);
			AbstractTableModelPredmeti atmPredmeti = new AbstractTableModelPredmeti();
			this.setModel(atmPredmeti);
			break;

		}

	}

	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {

		Component c = super.prepareRenderer(renderer, row, column);
		if (isRowSelected(row)) {
			c.setBackground(Color.LIGHT_GRAY);
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}

}
