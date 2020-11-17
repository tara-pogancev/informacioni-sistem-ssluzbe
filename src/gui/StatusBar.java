// #status_bar

// Reference:
// https://www.javatpoint.com/java-simpledateformat
// https://stackoverflow.com/questions/40706748/live-clock-in-java-application
// https://docs.oracle.com/javase/tutorial/uiswing/layout/box.html

package gui;

import java.awt.Color;
import java.awt.Component;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;


public class StatusBar extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1696597433259221588L;

	public StatusBar() {

		setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY), new EmptyBorder(5, 10, 5, 10)));

		JLabel name = new JLabel(" Studentska služba");

		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss | dd/MM/yyyy");
		Date time = new Date(System.currentTimeMillis());
		JLabel current_time = new JLabel(formatter.format(time));
		current_time.setAlignmentX(Component.LEFT_ALIGNMENT);
//
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				while (true) {

					Date time = new Date(System.currentTimeMillis());
					String dateString = new String(formatter.format(time));
					current_time.setText(dateString);

					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};

		Thread t = new Thread(runnable);
		t.start();
		
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		add(name);
		add(Box.createHorizontalGlue());	
		add(current_time);

	}

}
