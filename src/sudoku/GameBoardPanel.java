package sudoku;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ultils.GamePhrases;
import ultils.PanelOptions;

public class GameBoardPanel extends JPanel {
	   private static final long serialVersionUID = 1L;  // to prevent serial warning
//	   private static SudokuMain sudoku;
	   private static GameBoardPanel instance;
	   // Define named constants for UI sizes
	   public static final int CELL_SIZE = 60;   // Cell width/height in pixels
	   public static final int BOARD_WIDTH  = CELL_SIZE * SudokuConstants.GRID_SIZE;
	   public static final int BOARD_HEIGHT = CELL_SIZE * SudokuConstants.GRID_SIZE;
	                                             // Board width/height in pixels
	   public static GameBoardPanel getInstance() {
		   if(instance == null)
			   instance = new GameBoardPanel();
		   return instance;
	   }
	   // Define properties
	   /** The game board composes of 9x9 Cells (customized JTextFields) */
	   private Cell[][] cells = new Cell[SudokuConstants.GRID_SIZE][SudokuConstants.GRID_SIZE];
	   /** It also contains a Puzzle with array numbers and isGiven */
	   private Puzzle puzzle = new Puzzle();

	   /** Constructor */
//	   private GameBoardPanel() {
//	      super.setLayout(new GridLayout(SudokuConstants.GRID_SIZE, SudokuConstants.GRID_SIZE));  // JPanel
//
//	      // Allocate the 2D array of Cell, and added into JPanel.
//	      for (int row = 0; row < SudokuConstants.GRID_SIZE; ++row) {
//	         for (int col = 0; col < SudokuConstants.GRID_SIZE; ++col) {
//	            cells[row][col] = new Cell(row, col);
//	            super.add(cells[row][col]);   // JPanel
//	         }
//	      }
	   
	   public GameBoardPanel() {
		      super.setLayout(new GridLayout(SudokuConstants.GRID_SIZE, SudokuConstants.GRID_SIZE));  // JPanel  

		      for (int row = 0; row < SudokuConstants.GRID_SIZE; ++row) {
		         for (int col = 0; col < SudokuConstants.GRID_SIZE; ++col) {
		            cells[row][col] = new Cell(row, col);
		            cells[row][col].setBorder(Edge.getStandardBorder());
		            if(row == 2 || row == 5) {           
		                cells[row][col].setBorder(Edge.getRowBorder());            
		            }
		            if(col == 3 || col == 6) {
		            	if(row == 2 || row == 5) {
		                    cells[row][col].setBorder(Edge.getCornerBorder());            
		            	}else {
		                    cells[row][col].setBorder(Edge.getColumnBorder());            
		            	}
		            }

		            super.add(cells[row][col]);  
		            // JPanel
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
	   
	   public void clearGame() {
		   for (int row = 0; row < SudokuConstants.GRID_SIZE; ++row) {
		         for (int col = 0; col < SudokuConstants.GRID_SIZE; ++col) {
		        	 
		        	 if(CellStatus.WRONG_GUESS.equals(cells[row][col].status) ||
		        			 CellStatus.CORRECT_GUESS.equals(cells[row][col].status)
		        			 ) {
		        		 cells[row][col].status = CellStatus.TO_GUESS; 
		        	 }
		        	 cells[row][col].paint();
		         }
		      }
	   }
	   
	   
	   public void newGame(int CellsToGuess) {
		      // Generate a new puzzle
		      puzzle.newPuzzle(CellsToGuess);

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
			 if(!sourceCell.getText().matches("\\d+")) {
				 Object[] options = {"Sair do jogo",
							"continuar jogando"};
					 		int reply = JOptionPane.showOptionDialog(null,
					 				"Entrada inválida", "Só aceitamos numeros",JOptionPane.YES_NO_OPTION,
				                    JOptionPane.QUESTION_MESSAGE,
				                    null,     //aqui colocam-se os icones
				                    options,  
				                    options[0]);
					 		if (reply == JOptionPane.YES_OPTION)
				                System.exit(0);
				            //NO_OPTION
				            if (reply == JOptionPane.NO_OPTION) {
				            	sourceCell.setText("");
				            	JOptionPane.getRootFrame().dispose();
				            	return;
				            }
			 }
				 

	         int numberIn = Integer.parseInt(sourceCell.getText());

//	         System.out.println("You entered " + numberIn);

	          if (numberIn == sourceCell.number) {
	             sourceCell.status = CellStatus.CORRECT_GUESS;
	          } else {
	             sourceCell.status = CellStatus.WRONG_GUESS;
	             SudokuMain.getInstance().contErros();
	          }
	          sourceCell.paint();
	          
	          if(isSolved()) {
	        	  PanelOptions.isSolvedGame(GamePhrases.SAIR,
	        			  GamePhrases.NOVO_JOGO,
	        			  GamePhrases.WINS_MESSAGE,
	        			  GamePhrases.WINS_TITLE,
	        			  GameBoardPanel.getInstance()
        			  );
	          }
	      }
	   }
	}


