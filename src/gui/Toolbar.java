// #toolbar
// #lokalizacija_srpski
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

import javax.swing.AbstractAction;
import javax.swing.Box;
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
import listeners.action.SearchAction;

public class Toolbar extends JToolBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5707394191276063225L;

	public static JTextField searchText;
	
	private AddNewAction ana;
	private EditAction ea;
	private DeleteAction da;
	private SearchAction sr;
	
	
	
	public Toolbar() {

		
		// Orijentacija toolbar-a
		super(SwingConstants.HORIZONTAL);
		setFloatable(false);


		// Akceleratori

		ana = new AddNewAction();
		ea = new EditAction();
		da = new DeleteAction();
		sr = new SearchAction();

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

		JButton search = new JButton(sr);
//		search.setIcon(new ImageIcon("images" + File.separator + "search-icon2.png"));
//		search.setToolTipText("Search");
		search.setBorder(new EmptyBorder(3, 3, 3, 3));
		search.setOpaque(false);
		search.setContentAreaFilled(true);
		search.setFocusPainted(false);

		// Kreiranje tekstualnog polja za pretragu
		searchText = new JTextField(15);
		searchText.setText(MainFrame.getInstance().getResourceBundle().getString("searchField"));
		searchText.setMaximumSize(new Dimension(20, 20));
		searchText.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("searchField"));
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
		    	if (searchText.getText().isEmpty())
		    		searchText.setText(MainFrame.getInstance().getResourceBundle().getString("searchField")); 
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

	public static String getSearchText() {
		return searchText.getText();
	}
	
	public void toolbarInit() {
		
		searchText.setText(MainFrame.getInstance().getResourceBundle().getString("searchField"));
		searchText.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("searchField"));
		
		ana.updateName();
		ea.updateName();
		da.updateName();
		sr.updateName();
	
		
		
	}
	
}
