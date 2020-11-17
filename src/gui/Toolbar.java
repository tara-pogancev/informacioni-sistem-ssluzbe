// #Toolbar

package gui;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;


public class Toolbar extends JToolBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5707394191276063225L;
	
	public Toolbar() {
		
		super(SwingConstants.HORIZONTAL);
		setFloatable(false);
		
		JButton addNew = new JButton();
		addNew.setIcon(new ImageIcon("images/round_plus_icon16.png"));
		addNew.setToolTipText("Add New");
		
		add(addNew);
		addSeparator();
		
		JButton edit = new JButton();
		edit.setIcon(new ImageIcon("images/pencil_icon16.png"));
		edit.setToolTipText("Edit");
		
		add(edit);
		addSeparator();
		
		JButton delete = new JButton();
		delete.setIcon(new ImageIcon("images/trash_icon16.png"));
		delete.setToolTipText("Delete");
		
		add(delete);
		addSeparator();
		
		JButton search = new JButton();
		search.setIcon(new ImageIcon("images/zoom_icon16.png"));
		search.setToolTipText("Search");
		
		JTextArea search_text = new JTextArea("Search...");
		search_text.setLineWrap(false);
		
		addSeparator();
		add(search_text);
		addSeparator();
		add(search);

	}

}
