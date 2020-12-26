// #Toolbar
//
// Reference:
// https://stackoverflow.com/questions/16303916/how-to-make-jtextfield-text-disappear-when-tabbed-into-netbeans
// https://alvinalexander.com/java/java-action-abstractaction-actionlistener/
//
// https://docs.oracle.com/javase/tutorial/uiswing/components/border.html
// Projekat Termin3 
// https://docs.oracle.com/javase/8/docs/api/javax/swing/BorderFactory.html#createEmptyBorder-int-int-int-int-

package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

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


		// Akceleratori

		AddNewAction ana = new AddNewAction();
		EditAction ea = new EditAction();
		DeleteAction da = new DeleteAction();

		// Kreiranje dugmadi
		JButton addNew = new JButton(ana);
		addNew.setBorder(new EmptyBorder(3,3,3,3));
		addNew.setOpaque(false);
		addNew.setContentAreaFilled(true);
		addNew.setFocusPainted(false);

		JButton edit = new JButton(ea);
		edit.setBorder(new EmptyBorder(3,3,3,3));
		edit.setOpaque(false);
		edit.setContentAreaFilled(true);
		edit.setFocusPainted(false);

		JButton delete = new JButton(da);
		delete.setBorder(new EmptyBorder(3,3,3,3));
		delete.setOpaque(false);
		delete.setContentAreaFilled(true);
		delete.setFocusPainted(false);

		JButton search = new JButton();
		search.setIcon(new ImageIcon("images" + File.separator + "search-icon2.png"));
		search.setToolTipText("Search");
		search.setBorder(new EmptyBorder(3, 3, 3, 3));
		search.setOpaque(false);
		search.setContentAreaFilled(true);
		search.setFocusPainted(false);

		// Kreiranje tekstualnog polja za pretragu
		JTextField searchText = new JTextField("Search...", 15);
		searchText.setMaximumSize(new Dimension(20, 20));
		searchText.setToolTipText("Search...");
		searchText.setName("searchText");
		
		//Precica za fokusiranje polja za pretragu
		KeyStroke keyS = KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK);
		searchText.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyS, "s");
		searchText.getActionMap().put("s", new AbstractAction() {

			/**
			 * 
			 */
			private static final long serialVersionUID = -8081595819862154746L;

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				searchText.requestFocus();
				
			}
		});
		
		
		//Listener zbog koga se ocisti polje za pretragu kada se fokusira
		searchText.addFocusListener(new FocusListener(){

		    @Override
		    public void focusGained(FocusEvent e) {
		    	searchText.setText(null); 
		    }

		    @Override
		    public void focusLost(FocusEvent e) {
		    	searchText.setText("Search..."); 
		    }

		});

		// Dodavanje elemenata na toolbar
		add(Box.createHorizontalStrut(5));
		add(addNew);
		addSeparator();
		add(edit);
		addSeparator();
		add(delete);
		add(Box.createGlue());
		add(searchText);
		addSeparator();
		add(search);
		add(Box.createHorizontalStrut(10));

		validate();
	}

}
