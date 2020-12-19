//#glavni_prozor
package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TabbedPane extends JTabbedPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7566425700154666023L;
	
	enum Entitet { STUDENTI, PROFESORI, PREDMETI }
	
	JPanel studPanel = new JPanel();
	static TableTab studTable;
	JPanel profPanel = new JPanel();
	static TableTab profTable;
	JPanel predmPanel = new JPanel();
	static TableTab predmTable;
	
	public static Entitet ent = Entitet.STUDENTI;
	
	public TabbedPane(){
	
	
	studPanel.setLayout(new BorderLayout());
	studTable = new TableTab(Entitet.STUDENTI);
	JScrollPane scrollPaneStud = new JScrollPane(studTable);
	studPanel.add(scrollPaneStud, BorderLayout.CENTER);
	add("Studenti",studPanel);
	
	profPanel.setLayout(new BorderLayout());
	profTable = new TableTab(Entitet.STUDENTI);
	JScrollPane scrollPaneProf = new JScrollPane(profTable);
	profPanel.add(scrollPaneProf, BorderLayout.CENTER);
	add("Profesori",profPanel);
	
	predmPanel.setLayout(new BorderLayout());
	predmTable = new TableTab(Entitet.STUDENTI);
	JScrollPane scrollPanePredm = new JScrollPane(predmTable);
	predmPanel.add(scrollPanePredm, BorderLayout.CENTER);
	add("Predmeti",predmPanel);
	
//	addChangeListener((ChangeListener) new ChangeListener() {
//		
//		@Override
//		public void stateChanged(ChangeEvent arg0) {
//			
//			switch(getSelectedIndex())
//			{
//			
//			case 0:
//				ent = Entitet.STUDENTI;
//				break;
//			case 1:
//				ent = Entitet.PROFESORI;
//				break;
//			case 2:
//				ent = Entitet.PREDMETI;
//				break;
//			default:
//				break;
//			
//			}
//		}
//	});
//
//	
	}
	

	public void addTab(String title, Component component) {
		
		super.addTab(title,null,component);
	}
}
