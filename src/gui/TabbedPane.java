//#glavni_prozor
package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TabbedPane extends JTabbedPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7566425700154666023L;
	
	JPanel studentPanel = new JPanel();
	JPanel profesorPanel = new JPanel();
	JPanel predmetPanel = new JPanel();
	
	public TabbedPane(){
	
	super();
	
	studentPanel.setLayout(new BorderLayout());
	profesorPanel.setLayout(new BorderLayout());
	predmetPanel.setLayout(new BorderLayout());
	
	TableTab student = new TableTab("Student");
	addTab("Student", student);
	TableTab profesor = new TableTab("Profesor");
	addTab("Profesor", profesor);
	TableTab predmet = new TableTab("Predmet");
	addTab("Predmet", predmet);
	
	}
	

	public void addTab(String title, Component component) {
		
		super.addTab(title,null,component);
	}
}
