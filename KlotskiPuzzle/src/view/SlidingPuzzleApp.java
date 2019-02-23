package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;

import entity.*;
import controller.*;
import view.*;

public class SlidingPuzzleApp extends JFrame {

	private JPanel contentPane;

	PuzzleView panel;
	
	public PuzzleView getPuzzleView() {return panel;} 
	
	//take puzzle in constructor
	public SlidingPuzzleApp(Puzzle aPuzzle) {
		setTitle("SlidingPuzzleApp");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblMoves = new JLabel("Moves:");
		JLabel countLabel = new JLabel(aPuzzle.getCount() + "");
		
		panel = new PuzzleView(aPuzzle);
		panel.setBackground(Color.yellow);
		panel.setSize(new Dimension(400, 500));
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//create new resetPieceController

				new ResetPuzzleController(SlidingPuzzleApp.this, aPuzzle).resetPuzzle();
				panel.repaint();
				countLabel.setText(aPuzzle.countToString());
			}});
		
		
		JButton button = new JButton("^");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//create new movePieceController for up
				new MovePieceController(SlidingPuzzleApp.this, aPuzzle, Direction.UP).movePiece();
				countLabel.setText(aPuzzle.countToString());
				
			}});
		
		JButton button_1 = new JButton("<");
		button_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new MovePieceController(SlidingPuzzleApp.this, aPuzzle, Direction.LEFT).movePiece();
				countLabel.setText(aPuzzle.countToString());
				
			}});

		
		JButton button_2 = new JButton(">");
		button_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new MovePieceController(SlidingPuzzleApp.this, aPuzzle, Direction.RIGHT).movePiece();
				countLabel.setText(aPuzzle.countToString());
				
			}});
		
		JButton btnV = new JButton("V");
		btnV.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new MovePieceController(SlidingPuzzleApp.this, aPuzzle, Direction.DOWN).movePiece();
				countLabel.setText(aPuzzle.countToString());
				
			}});
		
		panel.addMouseListener(new MouseAdapter() { 
			@Override
			public void mousePressed(MouseEvent me) {
				new SelectPieceController(SlidingPuzzleApp.this, aPuzzle, me.getX(), me.getY()).selectPiece();
			}
		});
		

		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(button_1)
										.addGap(48)
										.addComponent(button_2))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(btnReset)
										.addGap(15)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblMoves)
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(button)
										.addComponent(countLabel)))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(80)
							.addComponent(btnV)))
					.addContainerGap(31, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMoves)
								.addComponent(countLabel))
							.addGap(189)
							.addComponent(button)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(button_2)
								.addComponent(button_1))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnV)
							.addPreferredGap(ComponentPlacement.RELATED, 211, Short.MAX_VALUE)
							.addComponent(btnReset)))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	

}
