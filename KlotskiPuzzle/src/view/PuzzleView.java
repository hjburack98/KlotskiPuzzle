package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JPanel;

import entity.*;

/** 
 * Knows how to visually present the puzzle. 
 */
public class PuzzleView extends JPanel {
	Puzzle puzzle;
	int offset = 10;

	 
	public PuzzleView(Puzzle puzzle) {
		this.puzzle = puzzle;
	}


	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		
			// copy image into place.
			g.fillRect(0, 0, 400, 500); 
			for(Piece piece : puzzle.getPieces()) {
				if(piece.isKeyPiece()) {
					g.setColor(Color.red);
				}
				else {
					g.setColor(Color.gray);
				}
				if(piece.isSelectedPiece()) {
					g.setColor(Color.blue);
				}
				
				g.fillRect(piece.getCol(), piece.getRow(), piece.getWidth(), piece.getHeight());
			}


	}
	

	
}
