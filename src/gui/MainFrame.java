// #glavni-prozor
package gui;

import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8026416994513756565L;

	private Toolbar toolbar;
	private MainMenu menu;
	private StatusBar status;
	private CentralPanel centralPan;
	
	// Singleton pattern
	private static MainFrame instance = null;
	
	private MainFrame() {
		
		initialise();
	}
	
	private void initialise() {
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;

		int windowHeight = (screenHeight / 100) * 75;
		int windowWidth = (screenWidth / 100) * 75;
		
		//ikonica programa
		ImageIcon img = new ImageIcon("images/addressbook.png");
		this.setIconImage(img.getImage());

		setSize(windowWidth, windowHeight);
		setTitle("Studentska služba");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// centriranje
		setLocationRelativeTo(null);
		setVisible(true);
		

		this.centralPan = new CentralPanel();
		this.add(this.centralPan, BorderLayout.CENTER);
		
		this.createToolbar();
		this.createMainMenu();
		this.createStatusBar();
	}
	
	public static MainFrame getInstance() {
		if( instance == null) {
			
			instance = new MainFrame();
		}
		return instance;
	}
	
	private void createToolbar() {
		
		// kreiranje instance klase Toolbar
		this.toolbar = new Toolbar();
		this.add(this.toolbar, BorderLayout.NORTH);
	}
	
	private void createMainMenu() {
		
		this.menu = new MainMenu();
		this.setJMenuBar(this.menu);
	}
	
	private void createStatusBar() {
		
		this.status = new StatusBar();
		this.add(this.status, BorderLayout.SOUTH);
		
	}
}
