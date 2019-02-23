package entity;

import junit.framework.*;

public class TestPuzzle extends TestCase{

	public void testVerticleMove() {
		Puzzle p = new Puzzle();
		
		for(Piece aPiece : p.getPieces()) {
			if(aPiece.getCol() == 105 && aPiece.getRow() == 305) {
				aPiece.selectPiece();
				p.setSelectedPiece(aPiece);
			}
		}
			
			p.movePiece(Direction.UP);
			
			assertEquals(p.getSelectedPiece().getRow(), 305);
			
			p.movePiece(Direction.DOWN);
			
			assertEquals(p.getSelectedPiece().getRow(), 405);
			
			p.movePiece(Direction.DOWN);
			
			assertEquals(p.getSelectedPiece().getRow(), 405);
			
			p.movePiece(Direction.UP);
			
			assertEquals(p.getSelectedPiece().getRow(), 305);
		}
	
	public void testHorizonalMove() {
		Puzzle p = new Puzzle();
		
		for(Piece aPiece : p.getPieces()) {
			if(aPiece.getCol() == 5 && aPiece.getRow() == 405) {
				aPiece.selectPiece();
				p.setSelectedPiece(aPiece);
			}
		}
			
			p.movePiece(Direction.LEFT);
			
			assertEquals(p.getSelectedPiece().getCol(), 5);
			
			p.movePiece(Direction.RIGHT);
			
			p.movePiece(Direction.RIGHT);
			
			assertEquals(p.getSelectedPiece().getCol(), 205);
			
			p.movePiece(Direction.RIGHT);
			
			assertEquals(p.getSelectedPiece().getCol(), 205);
			
			assertFalse(p.hasWonGame());
		}
	
	public void testTopPieceMove() {
		Puzzle p = new Puzzle();
		
		Piece pieceHolder = null;
		
		for(Piece aPiece : p.getPieces()) {
			if(aPiece.getCol() == 5 && aPiece.getRow() == 5) {
				aPiece.selectPiece();
				p.setSelectedPiece(aPiece);
				
				pieceHolder = aPiece;
			}
		}
		
		p.movePiece(Direction.UP);
		
		assertEquals(p.getSelectedPiece().getRow(), 5);
		
		p.movePiece(Direction.DOWN);
		
		assertEquals(p.getSelectedPiece().getRow(), 5);
		
		p.movePiece(Direction.LEFT);
		
		assertEquals(p.getSelectedPiece().getCol(), 5);
		
		p.movePiece(Direction.RIGHT);
		
		assertEquals(p.getSelectedPiece().getCol(), 5);
		
		assertFalse(p.isSolved());
		
		assertTrue(p.isSelected(pieceHolder));
		
		p.deSelectPieces();
		
		for(Piece aPiece : p.getPieces()) {
			if(aPiece.getCol() == 5 && aPiece.getRow() == 5) {
				pieceHolder = aPiece;
			}
		}
		
		assertFalse(p.isSelected(pieceHolder));
	}
	
	public void testKeyPiece() {
		Puzzle p = new Puzzle();
		
		Piece pieceHolder = null;
		
		for(Piece aPiece : p.getPieces()) {
			if(aPiece.getCol() == 105 && aPiece.getRow() == 5) {
				aPiece.selectPiece();
				p.setSelectedPiece(aPiece);
				
				pieceHolder = aPiece;
			}
		}
		
		assertTrue(pieceHolder.isKeyPiece());
	}
	
	public void testToString() {
		Puzzle p = new Puzzle();
		 assertEquals(p.countToString(), "0");
	}
	
	public void testReselectPiece() {
		Puzzle p = new Puzzle();
		
		Piece deSelected = null;
		Piece reSelected = null;
		
		for(Piece aPiece : p.getPieces()) {
			if(aPiece.getCol() == 5 && aPiece.getRow() == 205) {
				aPiece.selectPiece();
				p.setSelectedPiece(aPiece);
				
				deSelected = aPiece;
			}
		}
		
		for(Piece anotherPiece : p.getPieces()) {
			if(anotherPiece.getCol() == 5 && anotherPiece.getRow() == 5) {
				anotherPiece.selectPiece();
				p.setSelectedPiece(anotherPiece);
				
				reSelected = anotherPiece;
			}
		}
		
		assertTrue(reSelected.isSelectedPiece());
		assertFalse(deSelected.isSelectedPiece());
	}
		
}
	
		
		
	
	

