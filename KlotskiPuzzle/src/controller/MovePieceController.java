package controller;

import view.SlidingPuzzleApp;

import javax.swing.JOptionPane;

import entity.*;


import entity.*;

public class MovePieceController {
	
	Puzzle puzzle;
	SlidingPuzzleApp app;
	Direction direction;
	 
	public MovePieceController(SlidingPuzzleApp app, Puzzle puzzle, Direction direction) {
		this.app = app;
		this.puzzle = puzzle;
		this.direction = direction;
	}

	public void movePiece() {
		puzzle.movePiece(direction);
		app.revalidate();
		app.repaint();
		
		if(puzzle.hasWonGame()) {
			puzzle.goToInitialState();
			JOptionPane.showMessageDialog (app, "Congratulations!! You Won!!");
		}
		
		app.revalidate();
		app.repaint();
	}
	
}
