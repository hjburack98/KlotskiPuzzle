import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import controller.QuitPuzzleController;
import entity.*;
import view.*;
import controller.*;

public class Main {
	
	

	public static void main(String[] args) {
		
		Puzzle mainPuzzle = new Puzzle();
		
		final SlidingPuzzleApp app = new SlidingPuzzleApp(mainPuzzle);
		
		//Quit Application
		app.addWindowListener (new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				new QuitPuzzleController(app).process();
			}

		});
		
		
		app.setVisible(true);
		
	}

}
