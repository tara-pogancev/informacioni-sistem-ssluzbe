// #menu_bar
// Reference:
// https://stackoverflow.com/questions/5165917/scrollable-html-jlabel
// Model frame-a preuzet:
// https://docs.oracle.com/javase/tutorial/uiswing/components/textfield.html
//
// https://www.baeldung.com/convert-file-to-input-stream
// https://www.java-examples.com/create-custom-color-using-rgb-example

package dialog;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.*;
import javax.swing.text.*;

import gui.MainFrame;

import javax.swing.event.*;
import javax.swing.GroupLayout.*;

public class HelpDialog extends JFrame implements DocumentListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3640861247170902722L;

	private JTextField entry;
	private JLabel text;
	private JTextArea textArea;
	private JLabel status;
	private JScrollPane scrollPane;
	
	
	final static Color HILIT_COLOR = Color.LIGHT_GRAY;
	final static Color ERROR_COLOR = new Color(237, 121, 121);
	final static String CANCEL_ACTION = "cancel-action";
	
	final Color entryBg;
	final Highlighter hilit;
	final Highlighter.HighlightPainter painter;
	
	public HelpDialog() {

		//Frame basics
		this.setTitle(MainFrame.getInstance().getResourceBundle().getString("help"));
		this.setResizable(false);
		
		entry = new JTextField();
		text = new JLabel();
		textArea = new JTextArea();
		status = new JLabel();
		
		textArea.setColumns(20);
		textArea.setLineWrap(true);
		textArea.setRows(5);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		
		scrollPane = new JScrollPane(textArea);
		
		text.setText(MainFrame.getInstance().getResourceBundle().getString("pretraziTekst"));
		
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		
		ParallelGroup hgroup = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
		
		SequentialGroup h1 = layout.createSequentialGroup();
		ParallelGroup h2 = layout.createParallelGroup(GroupLayout.Alignment.TRAILING);
		
		h1.addContainerGap();
		
		h2.addComponent(scrollPane, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE);
		h2.addComponent(status, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE);
		
		SequentialGroup h3 = layout.createSequentialGroup();
		h3.addComponent(text);
		h3.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED);
		h3.addComponent(entry, GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE);
		
		h2.addGroup(h3);
		h1.addGroup(h2);
		h1.addContainerGap();
		
		hgroup.addGroup(GroupLayout.Alignment.TRAILING, h1);
		layout.setHorizontalGroup(hgroup);
		
		ParallelGroup vgroup = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
		SequentialGroup v1 = layout.createSequentialGroup();
		v1.addContainerGap();
		
		ParallelGroup v2 = layout.createParallelGroup(GroupLayout.Alignment.BASELINE);
		v2.addComponent(text);
		v2.addComponent(entry, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);
		
		v1.addGroup(v2);
		v1.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
		v1.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE);
		v1.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
		v1.addComponent(status);
		v1.addContainerGap();
		
		vgroup.addGroup(v1);
		layout.setVerticalGroup(vgroup);
		pack();
		
		//Inicijalizacija komponenti gotova
		
		//RAD SA TXT FAJLOM
		
	    File initialFile = new File("res" + File.separator + MainFrame.getInstance().getResourceBundle().getString("helpTxt"));
	    InputStream in = null;
		try {
			in = new FileInputStream(initialFile);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
        try {
            textArea.read(new InputStreamReader(in, "UTF-8"), null);
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		
		hilit = new DefaultHighlighter();
		painter = new DefaultHighlighter.DefaultHighlightPainter(HILIT_COLOR);
		textArea.setHighlighter(hilit);
		
		entryBg = entry.getBackground();
		entry.getDocument().addDocumentListener(this);
		
		InputMap im = entry.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap am = entry.getActionMap();
        im.put(KeyStroke.getKeyStroke("ESCAPE"), CANCEL_ACTION);
        am.put(CANCEL_ACTION, new CancelAction());

		this.setLocationRelativeTo(null);
        
	}

	public void search() {
		hilit.removeAllHighlights();

		String s = entry.getText().toUpperCase();
		if (s.length() <= 0) {
			message(MainFrame.getInstance().getResourceBundle().getString("nistaZaPretragu"));
			return;
		}

		String content = textArea.getText().toUpperCase();
		int index = content.indexOf(s, 0);
		if (index >= 0) { // match found
			try {
				int end = index + s.length();
				hilit.addHighlight(index, end, painter);
				textArea.setCaretPosition(end);
				entry.setBackground(entryBg);
				message("'" + s + MainFrame.getInstance().getResourceBundle().getString("pronadjen"));
			} catch (BadLocationException e) {
				e.printStackTrace();
			}
		} else {
			entry.setBackground(ERROR_COLOR);
			message("'" + s + MainFrame.getInstance().getResourceBundle().getString("nijePronadjen"));
		}

	}
	
	public void message(String msg) {
		status.setText(msg);
	}
	
	
	@Override
	public void changedUpdate(DocumentEvent arg0) {	
	}


	@Override
	public void insertUpdate(DocumentEvent arg0) {	
		search();
	}


	@Override
	public void removeUpdate(DocumentEvent arg0) {
		search();
	}
	
	class CancelAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 3407053550822654316L;

		public void actionPerformed(ActionEvent ev) {
			hilit.removeAllHighlights();
			entry.setText("");
			entry.setBackground(entryBg);
		}
	}
	
}
