// #pretraga_profesora

// Reference:
// https://docs.oracle.com/javase/7/docs/api/javax/swing/RowFilter.html
// http://www.java2s.com/Tutorials/Java/Swing/JTable/Filter_a_JTable_with_RowFilter_in_Java.htm
// https://www.logicbig.com/tutorials/java-swing/jtable-row-filter.html

package view;

import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

public class PretragaProfesora extends TableRowSorter<AbstractTableModelProfesori> {

	private String prezimeFilter = "";
	private String imeFilter = "";

	private AbstractTableModelProfesori atmProfesori = new AbstractTableModelProfesori();

	public PretragaProfesora(String unetTekst) {

		String[] podela = unetTekst.split(" ");

		if (podela.length >= 1) {
			prezimeFilter = podela[0].toUpperCase();
		}

		if (podela.length >= 2) {
			imeFilter = podela[1].toUpperCase();
		}

		RowFilter<Object, Object> filter = new RowFilter<Object, Object>() {
			public boolean include(Entry<?, ?> entry) {

				String prezime = ((String) entry.getValue(1)).toUpperCase();
				String ime = ((String) entry.getValue(0)).toUpperCase();

				return (proveraPrezime(prezime) && proveraIme(ime));
			}

		};

		this.setModel(atmProfesori);
		this.setRowFilter(filter);

	}

	private boolean proveraPrezime(String prezime) {

		if (prezime.isEmpty()) {
			return true;
		}

		return (prezime.contains(prezimeFilter));
	}

	private boolean proveraIme(String ime) {

		if (ime.isEmpty()) {
			return true;
		}

		return (ime.contains(imeFilter));
	}
}
