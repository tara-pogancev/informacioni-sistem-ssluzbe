package gui;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import gui.TabbedPane.Entitet;
import model.AbstractTableModelProfesori;

public class TableTab extends JTable {

	
	private static final long serialVersionUID = 7816932867726992196L;

	public TableTab(Entitet ent) {
		
		switch(ent) {
		
		case STUDENTI:
			break;
			
		case PROFESORI:
			AbstractTableModelProfesori atmProfesori = new AbstractTableModelProfesori();
			//this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			this.setModel(atmProfesori);
			break;
			
		case PREDMETI:
			break;
			
		}
		
	}
	
	
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		
		Component c = super.prepareRenderer(renderer, row, column);
		// selektovani red ce imati drugaciju boju od ostalih
		if (isRowSelected(row)) {
			c.setBackground(Color.LIGHT_GRAY);
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
		
	}
}
