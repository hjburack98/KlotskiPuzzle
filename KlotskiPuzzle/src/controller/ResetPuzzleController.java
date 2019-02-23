package controller;

import java.util.ArrayList;

import entity.*;
import view.*;

public class ResetPuzzleController {
	SlidingPuzzleApp app;
	Puzzle puzzle;
	
	public ResetPuzzleController(SlidingPuzzleApp app, Puzzle puzzle) {
		this.app = app;
		this.puzzle = puzzle;
	}
	
	public void resetPuzzle(){
		
		puzzle.goToInitialState();
		app.revalidate();
		app.repaint();
		
	}

}
