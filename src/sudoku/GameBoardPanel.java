package sudoku;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameBoardPanel extends JPanel {
	   private static final long serialVersionUID = 1L;  // to prevent serial warning
//	   private static SudokuMain sudoku;
	   // Define named constants for UI sizes
	   public static final int CELL_SIZE = 60;   // Cell width/height in pixels
	   public static final int BOARD_WIDTH  = CELL_SIZE * SudokuConstants.GRID_SIZE;
	   public static final int BOARD_HEIGHT = CELL_SIZE * SudokuConstants.GRID_SIZE;
	                                             // Board width/height in pixels

	   // Define properties
	   /** The game board composes of 9x9 Cells (customized JTextFields) */
	   private Cell[][] cells = new Cell[SudokuConstants.GRID_SIZE][SudokuConstants.GRID_SIZE];
	   /** It also contains a Puzzle with array numbers and isGiven */
	   private Puzzle puzzle = new Puzzle();

	   /** Constructor */
	   public GameBoardPanel() {
	      super.setLayout(new GridLayout(SudokuConstants.GRID_SIZE, SudokuConstants.GRID_SIZE));  // JPanel

	      // Allocate the 2D array of Cell, and added into JPanel.
	      for (int row = 0; row < SudokuConstants.GRID_SIZE; ++row) {
	         for (int col = 0; col < SudokuConstants.GRID_SIZE; ++col) {
	            cells[row][col] = new Cell(row, col);
	            super.add(cells[row][col]);   // JPanel
	         }
	      }

	   // [TODO 3]
	      CellInputListener listener = new CellInputListener();

	   // [TODO 4]
	      for (int row = 0; row < SudokuConstants.GRID_SIZE; row++) {
	         for (int col = 0; col < SudokuConstants.GRID_SIZE; col++) {
	            if (cells[row][col].isEditable()) {
	               cells[row][col].addActionListener(listener);   // For all editable rows and cols
	            }
	         }
	      }

	      super.setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
	   }

	   /**
	    * Generate a new puzzle; and reset the gameboard of cells based on the puzzle.
	    * You can call this method to start a new game.
	    */
	   public void newGame() {
	      // Generate a new puzzle
	      puzzle.newPuzzle(2);

	      // Initialize all the 9x9 cells, based on the puzzle.
	      for (int row = 0; row < SudokuConstants.GRID_SIZE; ++row) {
	         for (int col = 0; col < SudokuConstants.GRID_SIZE; ++col) {
	            cells[row][col].newGame(puzzle.numbers[row][col], puzzle.isGiven[row][col]);
	         }
	      }
	   }

	   /**
	    * Return true if the puzzle is solved
	    * i.e., none of the cell have status of TO_GUESS or WRONG_GUESS
	    */
	   public boolean isSolved() {
	      for (int row = 0; row < SudokuConstants.GRID_SIZE; ++row) {
	         for (int col = 0; col < SudokuConstants.GRID_SIZE; ++col) {
	            if (cells[row][col].status == CellStatus.TO_GUESS || cells[row][col].status == CellStatus.WRONG_GUESS) {
	               return false;
	            }

	         }
	      }
	      return true;
	   }

	   // [TODO 2] Define a Listener Inner Class for all the editable Cells
	   private class CellInputListener implements ActionListener {
	      
	      public void actionPerformed(ActionEvent e) {
	         // Get a reference of the JTextField that triggers this action event
	         Cell sourceCell = (Cell)e.getSource();
			 
	         // Retrieve the int entered
	         int numberIn = Integer.parseInt(sourceCell.getText());
	         // For debugging
	         System.out.println("You entered " + numberIn);

	         /*
	          * [TODO 5] (later - after TODO 3 and 4)
	          * Check the numberIn against sourceCell.number.
	          * Update the cell status sourceCell.status,
	          * and re-paint the cell via sourceCell.paint().
	          */
	          if (numberIn == sourceCell.number) {
	             sourceCell.status = CellStatus.CORRECT_GUESS;
	          } else {
	             sourceCell.status = CellStatus.WRONG_GUESS;
	          }
	          sourceCell.paint();   // re-paint this cell based on its status

	         /*
	          * [TODO 6] (later)
	          * Check if the player has solved the puzzle after this move,
	          *   by calling isSolved(). Put up a congratulation JOptionPane, if so.
	          */
	          if(isSolved()) {
	        	  Object[] options = {"Sair do Jogo",
					"Novo Jogo"};
			 		int reply = JOptionPane.showOptionDialog(null,
			 				"Você venceu!", "Jogo Finalizado",JOptionPane.YES_NO_OPTION,
		                    JOptionPane.QUESTION_MESSAGE,
		                    null,     //do not use a custom Icon
		                    options,  //the titles of buttons
		                    options[0]);
			 		if (reply == JOptionPane.YES_OPTION)
		                System.exit(0);
		            //NO_OPTION
		            if (reply == JOptionPane.NO_OPTION) {
		            	newGame();
		            	SudokuMain.getInstance().reinitGame();
//		            	MusicPlayer.restartSong();
		            }
	          }
	      }
	   }
	}


