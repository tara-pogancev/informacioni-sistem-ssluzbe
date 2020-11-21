//#glavni_prozor
package gui;

import java.awt.Color;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CentralPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7566425700154666023L;
	
	public CentralPanel(){
	
	Box boxToDo = Box.createHorizontalBox();
	JLabel lblToDo = new JLabel("TODO: ");
	lblToDo.setForeground(Color.RED);
	JLabel lblToDo2 = new JLabel("Prikaz entiteta sistema.");
	lblToDo2.setForeground(Color.DARK_GRAY);
	
	boxToDo.add(lblToDo);
	boxToDo.add(lblToDo2);
	add(boxToDo);
	}

}
