package controller;

import junit.framework.TestCase;
import entity.*;
import view.*;

public class TestResetController extends TestCase{
	
	SlidingPuzzleApp app;
	Puzzle p;
	
	@Override
	protected void setUp() {
		p = new Puzzle();
		app = new SlidingPuzzleApp(p);
		app.setVisible(true);
	}
	
	@Override
	protected void tearDown() {
		app.setVisible(false);
	}
	
	public void testReset() {
		for(Piece aPiece : p.getPieces()) {
			if(aPiece.getCol() == 105 && aPiece.getRow() == 305) {
				aPiece.selectPiece();
				p.setSelectedPiece(aPiece);
			}
		}
		
		p.movePiece(Direction.DOWN);
		app.revalidate();
		app.repaint();
		
		assertFalse(p.checkReset());
		
		ResetPuzzleController rc = new ResetPuzzleController(app, p);
		rc.resetPuzzle();
		
		assertTrue(p.checkReset());
		
		
	}


}
