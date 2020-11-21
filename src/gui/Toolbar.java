// #Toolbar

package gui;

import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import listeners.action.AddNewAction;
import listeners.action.DeleteAction;
import listeners.action.EditAction;


public class Toolbar extends JToolBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5707394191276063225L;

	public Toolbar() {

		// Orijentacija toolbar-a
		super(SwingConstants.HORIZONTAL);
		setFloatable(false);

		// Za ivice ikonica
		Border emptyBorder = BorderFactory.createEmptyBorder();

		// Akceleratori

		AddNewAction ana = new AddNewAction();
		EditAction ea = new EditAction();
		DeleteAction da = new DeleteAction();

		// Kreiranje dugmadi
//		JButton addNew = new JButton();
//		addNew.setIcon(new ImageIcon("images/add.png"));
//		addNew.setToolTipText("New");
//		addNew.setBorder(emptyBorder);
//		addNew.setOpaque(false);
//		addNew.setContentAreaFilled(false);
//		addNew.setBorderPainted(false);
//
//		JButton edit = new JButton();
//		edit.setIcon(new ImageIcon("images/edit.png"));
//		edit.setToolTipText("Edit");
//		edit.setBorder(emptyBorder);
//		edit.setOpaque(false);
//		edit.setContentAreaFilled(false);
//		edit.setBorderPainted(false);
//
//		JButton delete = new JButton();
//		delete.setIcon(new ImageIcon("images/trash-icon.png"));
//		delete.setToolTipText("Delete");
//		delete.setBorder(emptyBorder);
//		delete.setOpaque(false);
//		delete.setContentAreaFilled(false);
//		delete.setBorderPainted(false);

		JButton search = new JButton();
		search.setIcon(new ImageIcon("images/search-icon2.png"));
		search.setToolTipText("Search");
		search.setBorder(emptyBorder);
		search.setOpaque(false);
		search.setContentAreaFilled(false);
		search.setBorderPainted(false);

		// Kreiranje tekstualnog polja za pretragu
		JTextField searchText = new JTextField("Search...", 15);
		searchText.setMaximumSize(new Dimension(20, 20));
		searchText.setToolTipText("Search...");
		searchText.setName("searchText");

		// Dodavanje elemenata na toolbar
		add(Box.createHorizontalStrut(5));
		add(ana);
//		add(addNew);
		addSeparator();
		add(ea);
//		add(edit);
		addSeparator();
		add(da);
//		add(delete);
		add(Box.createGlue());
		add(searchText);
		addSeparator();
		add(search);
		add(Box.createHorizontalStrut(10));

		validate();
	}

}
