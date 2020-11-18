// #glavni-prozor
package gui;

import java.awt.Toolkit;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;

public class MainFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8026416994513756565L;

	public MainFrame() {
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		
		int windowHeight = (screenHeight /100) * 75;
		int windowWidth = (screenWidth / 100) * 75;
		
		setSize(windowWidth, windowHeight);
		setTitle("Studentska služba");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		MainMenu menu = new MainMenu();
		setJMenuBar(menu);
		
		Toolbar toolbar = new Toolbar();
		add(toolbar,BorderLayout.NORTH);
		
		StatusBar status = new StatusBar();
		add(status, BorderLayout.SOUTH);
		
	}

}
