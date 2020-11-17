// #Toolbar

package gui;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
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
//		addNew.setIcon(new ImageIcon("images/round_plus_icon16.png"));
		addNew.setIcon(new ImageIcon("images/add-icon.png"));
		addNew.setToolTipText("New");
		
		add(addNew);
		addSeparator();
		
		JButton edit = new JButton();
//		edit.setIcon(new ImageIcon("images/pencil_icon16.png"));
		edit.setIcon(new ImageIcon("images/edit-icon.png"));
		edit.setToolTipText("Edit");
		
		add(edit);
		addSeparator();
		
		JButton delete = new JButton();
//		delete.setIcon(new ImageIcon("images/trash_icon16.png"));
		delete.setIcon(new ImageIcon("images/trash-icon.png"));
		delete.setToolTipText("Delete");
		
		add(delete);
		
		JButton search = new JButton();
//		search.setIcon(new ImageIcon("images/zoom_icon16.png"));
		search.setIcon(new ImageIcon("images/find-icon.png"));
		search.setToolTipText("Search");
		
		
		JTextField search_text = new JTextField(15);
		search_text.setMaximumSize(getPreferredSize());
		search_text.setToolTipText("Search...");
		
		add(Box.createGlue());
		add(search_text);
		addSeparator();
		add(search);

	}

}
