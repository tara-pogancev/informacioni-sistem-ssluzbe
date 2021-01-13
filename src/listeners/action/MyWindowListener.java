// #glavni_prozor
// #serijalizacija
package listeners.action;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import gui.MainFrame;
import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaStudenata;

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

		Object[] opcije = {MainFrame.getInstance().resourceBundle.getString("yesBtn"), MainFrame.getInstance().resourceBundle.getString("noBtn")};
		Object defaultChoice = opcije[0];

		int izbor = JOptionPane.showOptionDialog(MainFrame.getInstance(),
				MainFrame.getInstance().resourceBundle.getString("zatvaranjeApl"), MainFrame.getInstance().resourceBundle.getString("closeApp"),
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcije, defaultChoice);

		if (izbor == JOptionPane.YES_OPTION) {

			int serijalizacija = JOptionPane.showOptionDialog(MainFrame.getInstance(),
					MainFrame.getInstance().resourceBundle.getString("cuvanjePod"), MainFrame.getInstance().resourceBundle.getString("cuvanje"), JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, opcije, defaultChoice);

			if (serijalizacija == JOptionPane.YES_OPTION) {
				try {

					BazaStudenata.getInstance().saveDataStudent();
					BazaProfesora.getInstance().saveDataProfesor();
					BazaPredmeta.getInstance().saveDataPredmet();

				} catch (IOException e) {
					e.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(MainFrame.getInstance(), "Podaci su uspešno sačuvani!");
			}
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		} else

		{

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
