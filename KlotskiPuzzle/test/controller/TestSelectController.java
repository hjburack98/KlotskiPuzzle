package controller;

import junit.framework.TestCase;
import entity.*;
import view.*;

public class TestSelectController extends TestCase{
	
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
	
	public void testFailedSelect() {
		SelectPieceController sc = new SelectPieceController(app, p, 0, 0);
		assertFalse(sc.selectPiece());
	}
	
	public void testSuccessSelect() {
		SelectPieceController sc = new SelectPieceController(app, p, 10, 10);
		assertTrue(sc.selectPiece());
	}
}
