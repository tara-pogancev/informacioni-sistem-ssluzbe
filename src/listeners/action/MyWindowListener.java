//#glavni_prozor
package listeners.action;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import gui.MainFrame;

public class MyWindowListener implements WindowListener {

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent arg0) {

		JFrame frame = (JFrame) arg0.getComponent();

		Object[] opcije = { "Da", "Ne" };
		Object defaultChoice = opcije[0];

		int izbor = JOptionPane.showOptionDialog(MainFrame.getInstance(),
				"Da li ste sigurni da želite da zatvorite aplikaciju?", "Zatvaranje aplikacije?",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcije, defaultChoice);

		if (izbor == JOptionPane.YES_OPTION) {

			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		} else {

			frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		}

	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

}
