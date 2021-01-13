// #glavni_prozor
// #lokalizacija_engleski
// #lokalizacija_srpski
// Reference:
// Projekat Termin3
// Projekat Dogadjaji

package gui;

import java.awt.Toolkit;
import java.io.File;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import listeners.action.MyWindowListener;

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
	
	public ResourceBundle resourceBundle;
	
	private static TabbedPane tabbedPane;

	// Singleton pattern
	private static MainFrame instance = null;

	private MainFrame() {

		Locale.setDefault(new Locale("sr", "RS"));
		resourceBundle = ResourceBundle.getBundle("MessageResources.MessageResources", Locale.getDefault());
		
	}

	private void initialise() {

		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;

		int windowHeight = (screenHeight / 100) * 75;
		int windowWidth = (screenWidth / 100) * 75;

		// ikonica programa
		ImageIcon img = new ImageIcon("images" + File.separator + "addressbook.png");

		this.setIconImage(img.getImage());

		setSize(windowWidth, windowHeight);
		setTitle(MainFrame.getInstance().resourceBundle.getString("sluzba"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// centriranje
		setLocationRelativeTo(null);
		setVisible(true);
		
		addWindowListener(new MyWindowListener());

		this.createToolbar();
		this.createMainMenu();
		this.createStatusBar();
		this.createTabbedPane();
		validate();


	}

	public static MainFrame getInstance() {
		if (instance == null) {

			instance = new MainFrame();
			instance.initialise();
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

	private void createTabbedPane() {

		MainFrame.tabbedPane = new TabbedPane();
		this.add(MainFrame.tabbedPane, BorderLayout.CENTER);

	}

	public static TabbedPane getTabbedPane() {
		return tabbedPane;
	}
	
	public ResourceBundle getResourceBundle() {
		
		return resourceBundle;
	}

	public void changeLanguage() {

		resourceBundle = ResourceBundle.getBundle("MessageResources.MessageResources", Locale.getDefault());
		setTitle(resourceBundle.getString("sluzba"));
		
		menu.initMenu();
		status.statusInit();
		tabbedPane.tabbedPaneInit();		//TODO: samo prva kolona se promeni, ostale moraju da se refreshuju
		validate();
		
		
	}
}
