package entity;

import java.util.ArrayList;

public class Puzzle {
	private ArrayList<Piece> pieces;
	private int count;
	private boolean hasWon;
	private boolean reset;
	private Piece selected;
	
	public Puzzle() {
		count = 0;
		selected = null;
		hasWon = false;
		pieces = new ArrayList<Piece>();
		reset = true;
		this.goToInitialState();
	}
	
	public void goToInitialState() {
		pieces.clear();
		Piece piece1 = new Piece(190,190,5,105); // main Piece
		Piece piece2 = new Piece(90,190,5,5);
		Piece piece3 = new Piece(90,190,205,5);
		Piece piece4 = new Piece(90,90,405,5);
		Piece piece5 = new Piece(90,90,305,105);
		Piece piece6 = new Piece(90,90,405,305);
		Piece piece7 = new Piece(90,90,305,205);
		Piece piece8 = new Piece(90,190,5,305);
		Piece piece9 = new Piece(90,190,205,305);
		Piece piece10 = new Piece(190,90,205,105);
		

		pieces.add(piece1);
		pieces.add(piece2);
		pieces.add(piece3);
		pieces.add(piece4);
		pieces.add(piece5);
		pieces.add(piece6);
		pieces.add(piece7);
		pieces.add(piece8);
		pieces.add(piece9);
		pieces.add(piece10);
		
		count = 0;
		
		selected = null;
		
		hasWon = false;
		reset = true;
		
	}
	
	public boolean checkReset() {
		return reset;
	}
	
	public void movePiece(Direction direction) {
		//checks if a piece is selected - DONE
		//checks if the move is the winning move - DONE
		//checks if the piece can move in that direction
		//if it can, it will call selectedpiece.move
		
		
		if(selected == null) {return;}
		if(selected.isKeyPiece() == true) {
				if(selected.getCol() == 105 && selected.getRow() == 305) {
					if(direction == Direction.DOWN) {
						hasWon = true;
						this.pieces.remove(selected);
						return;
					}
				}
			}
		
		if(direction == Direction.UP) {
			if(this.isValidMove(selected, selected.getRow() - 100, selected.getCol())) {
				selected.moveUp();
				this.incrementCount();
				reset = false;
			}
		}
				
		else if(direction == Direction.DOWN) {
			if(this.isValidMove(selected, selected.getRow() + 100, selected.getCol())) {
				selected.moveDown();
				this.incrementCount();
				reset = false;
			}
		}
				
		else if(direction == Direction.LEFT) {
			if(this.isValidMove(selected, selected.getRow(), selected.getCol() - 100)) {
				selected.moveLeft();
				this.incrementCount();
				reset = false;
			}
		}
				
		else {
			if(this.isValidMove(selected, selected.getRow(), selected.getCol() + 100)) {
				selected.moveRight();
				this.incrementCount();
				reset = false;
			}
		}
	}
	
	public boolean hasWonGame() {
		return this.hasWon;
	}
		
	public boolean getReset() {
		return this.reset;
	}
	
	
	public int getCount() {
		return this.count;
	}
	
	public String countToString() {
		return "" + this.count;
	}
	
	
	public Piece getSelectedPiece() {
		return this.selected;
	}
	
	
	public ArrayList<Piece> getPieces(){
		return this.pieces;
	}
	
	public boolean isSolved() {
		for(Piece aPiece : pieces) {
			if(aPiece.isKeyPiece()) {
				if(aPiece.getRow() == 4 && aPiece.getCol() == 2) {
					return true;
				}
			}
		}
		return false;
	}

	public void incrementCount() {
		this.count++;
	}
	
	public void setSelectedPiece(Piece aPiece) {
		for(Piece selectedPiece : pieces) {
			if(selectedPiece.isSelectedPiece() && selectedPiece != aPiece) {
				selectedPiece.deSelectPiece();
			}
		}
		aPiece.selectPiece();
		selected = aPiece;
	}
	
	public void deSelectPieces() {
		this.selected = null;
	}
	
	public boolean isSelected(Piece aPiece) {
		return (aPiece != null && aPiece == this.selected);
	}
	
	public static boolean intersect(Piece piece1, Piece piece2) {
		return !(piece2.getCol() > (piece1.getCol() + piece1.getWidth()) || (piece2.getCol() + piece2.getWidth()) < piece1.getCol() ||
				 piece2.getRow() > (piece1.getRow() + piece1.getHeight())|| (piece2.getRow() + piece2.getHeight()) < piece1.getRow());
	}
	
	public boolean isValidMove(Piece movedPiece, int moveRow, int moveCol) {
		Piece tempPiece = new Piece(movedPiece.getWidth(), movedPiece.getHeight(), moveRow, moveCol);
		if(moveRow < 0 || moveCol < 0 || (moveRow + movedPiece.getHeight()) > 500 || (moveCol + movedPiece.getWidth()) > 400) {
			return false;
		}
		for(Piece aPiece : this.getPieces()) {
			if(aPiece != movedPiece) {
				if(intersect(aPiece, tempPiece)) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	
}
