// #menu_bar
// Reference:
// https://stackoverflow.com/questions/5165917/scrollable-html-jlabel
// Model frame-a preuzet:
// https://docs.oracle.com/javase/tutorial/uiswing/components/textfield.html
//
// https://www.baeldung.com/convert-file-to-input-stream
// https://www.java-examples.com/create-custom-color-using-rgb-example

package dialog;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.*;

import javax.swing.border.Border;

import gui.MainFrame;

public class AboutDialog extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2728055401775841791L;

	private JTextArea textArea;
	private JScrollPane scrollPane;
	
	public AboutDialog() {
	
		this.setTitle(MainFrame.getInstance().getResourceBundle().getString("about"));
		this.setResizable(false);
		
		textArea = new JTextArea();

		textArea.setColumns(40);
		textArea.setLineWrap(true);
		textArea.setRows(20);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		scrollPane = new JScrollPane(textArea);
		
		JPanel contentPanel = new JPanel();
		Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		contentPanel.setBorder(padding);
		this.setContentPane(contentPanel);
		contentPanel.add(scrollPane);
		this.setSize(450, 250);
		
		pack();
		
		//Inicijalizacija komponenti gotova
	    File initialFile = new File("res" + File.separator + MainFrame.getInstance().getResourceBundle().getString("aboutTxt"));
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
        
        this.setLocationRelativeTo(null);

	}
	
}
