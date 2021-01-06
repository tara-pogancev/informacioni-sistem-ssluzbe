// #pretraga_predmeta

// Reference:
// https://docs.oracle.com/javase/7/docs/api/javax/swing/RowFilter.html
// http://www.java2s.com/Tutorials/Java/Swing/JTable/Filter_a_JTable_with_RowFilter_in_Java.htm
// https://www.logicbig.com/tutorials/java-swing/jtable-row-filter.html

package view;

import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

public class PretragaPredmeta extends TableRowSorter<AbstractTableModelPredmeti>{

	private String unetTekst = "";

	private AbstractTableModelPredmeti atmPredmeti = new AbstractTableModelPredmeti();

	public PretragaPredmeta(String searchTxt) {

		unetTekst = searchTxt.toUpperCase();

		RowFilter<Object, Object> filter = new RowFilter<Object, Object>() {
			public boolean include(Entry<?, ?> entry) {

				String nazivPredmeta = ((String) entry.getValue(1)).toUpperCase();

				if (nazivPredmeta.isEmpty()) {
					return true;
				} else {
					return (nazivPredmeta.contains(unetTekst));
				}

			}
		};

		this.setModel(atmPredmeti);
		this.setRowFilter(filter);
	}
}
