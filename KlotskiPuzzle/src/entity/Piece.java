package entity;

public class Piece {
	private int width;
	private int height;
	private int row;
	private int col;
	private boolean keyPiece;
	private boolean isSelected;
	
	public Piece(int width, int height, int row, int col) {
		this.width = width;
		this.height = height;
		this.row = row;
		this.col = col;
		
		if(this.width == 190 && this.height == 190) 
			{this.keyPiece = true;}
		else 
			{keyPiece = false;}
		
		isSelected = false;
	}
	
	//gets keyPiece
	public boolean isKeyPiece() {
		return keyPiece;
	}
	
	//check selected
	public boolean isSelectedPiece() {
		return isSelected;
	}
	//sets selected piece to true
	public void selectPiece() {
		isSelected = true;
	}
	
	//deselects piece
	public void deSelectPiece() {
		isSelected = false;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public int getRow() {
		return this.row;
	}
	
	public int getCol() {
		return this.col;
	}
	
	public void moveLeft() {
		col -= 100;
	}
	
	public void moveRight() {
		col += 100;
	}
	
	public void moveUp() {
		row -= 100;
	}
	
	public void moveDown() {
		row += 100;
	}
}
