// #pretraga_studenata
//
// Reference:
// https://docs.oracle.com/javase/7/docs/api/javax/swing/RowFilter.html
// http://www.java2s.com/Tutorials/Java/Swing/JTable/Filter_a_JTable_with_RowFilter_in_Java.htm
// https://www.logicbig.com/tutorials/java-swing/jtable-row-filter.html

package view;

import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;


public class StudentFilter extends TableRowSorter<AbstractTableModelStudenti>{
	
	private String idx_filter = "";
	private String ime_filter = "";
	private String prz_filter = "";
		
	private AbstractTableModelStudenti atmStudenti = new AbstractTableModelStudenti();
	
	public StudentFilter(String s) {
		
		//Inicijalizovanje filtera
		String[] filters = s.split(" ");
		
		if (filters.length >= 1)
			prz_filter = filters[0].toUpperCase();	
		if (filters.length >= 2)
			ime_filter = filters[1].toUpperCase();
		if (filters.length >= 3)
			idx_filter = filters[2].toUpperCase();
		
		RowFilter<Object, Object> filter = new RowFilter<Object, Object>() {
	        public boolean include(Entry<?, ?> entry) {
	          String ime = ((String) entry.getValue(1)).toUpperCase();
	          String prezime = ((String) entry.getValue(2)).toUpperCase();
	          String idx = ((String) entry.getValue(0)).toUpperCase();
	          return (prezimeCh(prezime)&&imeCh(ime)&&idxCh(idx));
	        }
	      };
	      
	      this.setModel(atmStudenti);
	      this.setRowFilter(filter);
	}

	private boolean prezimeCh(String prezime) {
		
		if (prezime.isEmpty()) 
			return true;
		else return (prezime.contains(prz_filter));
	
		
	}
	
	private boolean imeCh(String ime) {
		
		if (ime.isEmpty()) 
			return true;
		else return (ime.contains(ime_filter));
		
	}
	
	private boolean idxCh(String idx) {
		
		if (idx.isEmpty()) 
			return true;
		else return (idx.contains(idx_filter));
		
	}
	
	
}

