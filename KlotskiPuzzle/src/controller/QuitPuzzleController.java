package controller;

import javax.swing.JOptionPane;
import javax.swing.JFrame;

/**
 * Controller to confirm request to exist application.
 */
public class QuitPuzzleController {

	JFrame app; 

	public QuitPuzzleController(JFrame app) {
		this.app = app;
	}

	public void process() {
		int c = JOptionPane.showConfirmDialog (app, "Do you wish to exit Application?");

		if (c == JOptionPane.OK_OPTION) {
			app.setVisible(false);
			app.dispose();
		}
	}

}
