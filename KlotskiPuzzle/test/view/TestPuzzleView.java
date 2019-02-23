package view;


import view.SlidingPuzzleApp;
import view.PuzzleView;
import entity.Piece;
import entity.Puzzle;
import junit.framework.TestCase;

public class TestPuzzleView extends TestCase{
	
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
	
	public void testView() {
		try {Thread.sleep(1000); } catch (Exception e) {}
		
		for(Piece aPiece : p.getPieces()) {
			if(aPiece.getCol() == 5 && aPiece.getRow() == 205) {
				aPiece.selectPiece();
				p.setSelectedPiece(aPiece);
			}
		}
	}
	
	
}
