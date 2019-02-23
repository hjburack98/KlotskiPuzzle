package controller;

import entity.*;
import view.*;

public class SelectPieceController {
	SlidingPuzzleApp app;
	Puzzle puzzle;
	int x;
	int y; 
	
	public SelectPieceController(SlidingPuzzleApp app, Puzzle puzzle, int x, int y) {
		this.app = app;
		this.puzzle = puzzle;
		this.x = x;
		this.y = y;
	}
	
	public boolean selectPiece() {
		for(Piece aPiece : puzzle.getPieces()) {
			if(aPiece.getCol() <= this.x && this.x <= (aPiece.getCol() + aPiece.getWidth())) {
				if(aPiece.getRow() <= this.y && this.y <= (aPiece.getRow() + aPiece.getHeight())) {
					aPiece.selectPiece();
					puzzle.setSelectedPiece(aPiece);
					
					app.revalidate();
					app.repaint();
					return true;
					
				}
			}
		}

		return false;
	}

}
