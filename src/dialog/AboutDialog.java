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

public class AboutDialog extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2728055401775841791L;

	private JTextArea text_area;
	private JScrollPane scroll_pane;
	
	public AboutDialog() {
	
		this.setTitle("About");
		this.setResizable(false);
		
		text_area = new JTextArea();

		text_area.setColumns(40);
		text_area.setLineWrap(true);
		text_area.setRows(20);
		text_area.setWrapStyleWord(true);
		text_area.setEditable(false);
		scroll_pane = new JScrollPane(text_area);
		
		JPanel contentPanel = new JPanel();
		Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		contentPanel.setBorder(padding);
		this.setContentPane(contentPanel);
		contentPanel.add(scroll_pane);
		this.setSize(450, 250);
		
		pack();
		
		//Inicijalizacija komponenti gotova
	    File initialFile = new File("docs" + File.separator + "about.txt");
	    InputStream in = null;
		try {
			in = new FileInputStream(initialFile);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
        try {
            text_area.read(new InputStreamReader(in, "UTF-8"), null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        this.setLocationRelativeTo(null);

	}
	
}
