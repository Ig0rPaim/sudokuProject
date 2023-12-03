package sudoku;

import java.util.Random;

import DAO.DAOGamesPostgreSql;

public class Puzzle {
	   // All variables have package access
	   // The numbers on the puzzle
	   int[][] numbers = new int[SudokuConstants.GRID_SIZE][SudokuConstants.GRID_SIZE];
	   // The clues - isGiven (no need to guess) or need to guess
	   boolean[][] isGiven = new boolean[SudokuConstants.GRID_SIZE][SudokuConstants.GRID_SIZE];
	   private DAOGamesPostgreSql db = new DAOGamesPostgreSql();
	   // Constructor
	   public Puzzle() {
	      super();
	   }
	   
	   public void newPuzzle(int cellsToGuess) {
		  
	      int[][] hardcodedNumbers =
	         {{5, 3, 4, 6, 7, 8, 9, 1, 2},
	          {6, 7, 2, 1, 9, 5, 3, 4, 8},
	          {1, 9, 8, 3, 4, 2, 5, 6, 7},
	          {8, 5, 9, 7, 6, 1, 4, 2, 3},
	          {4, 2, 6, 8, 5, 3, 7, 9, 1},
	          {7, 1, 3, 9, 2, 4, 8, 5, 6},
	          {9, 6, 1, 5, 3, 7, 2, 8, 4},
	          {2, 8, 7, 4, 1, 9, 6, 3, 5},
	          {3, 4, 5, 2, 8, 6, 1, 7, 9}};

	      // Copy from hardcodedNumbers into the array "numbers"
	      for (int row = 0; row < SudokuConstants.GRID_SIZE; ++row) {
	         for (int col = 0; col < SudokuConstants.GRID_SIZE; ++col) {
	            numbers[row][col] = hardcodedNumbers[row][col];
	         }
	      }
			/*
			 * pegando o jogo do banco
			 * int [][] gameDb = db.getGame();
			 * 
			 * ao inves de fazer o for acima com "hardcodedNumbers" simplismente faça numbers receber 
			 * o retorno de db.getGame()
			 */
	      
	      // Need to use input parameter cellsToGuess!
	      // Hardcoded for testing, only 2 cells of "8" is NOT GIVEN
	      
	      boolean[][] hardcodedIsGiven =
	         {{true, true, true, true, true, true, true, true, true},
	          {true, true, true, true, true, true, true, true, true},
	          {true, true, true, true, true, true, true, true, true},
	          {true, true, true, true, true, true, true, true, true},
	          {true, true, true, true, true, true, true, true, true},
	          {true, true, true, true, true, true, true, true, true},
	          {true, true, true, true, true, true, true, true, true},
	          {true, true, true, true, true, true, true, true, true},
	          {true, true, true, true, true, true, true, true, true}};
	      
			/*
			 * sortenado quais numeros serão dados
			 * 
			 * boolean[][] isGivenHeadquarters = new boolean[SudokuConstants.GRID_SIZE][SudokuConstants.GRID_SIZE];
			 *  for(int i = 0; i < SudokuConstants.GRID_SIZE; i++) { 
			 *  	for(int j = 0; j < SudokuConstants.GRID_SIZE; j++) {
			 *  		 isGivenHeadquarters[i][j] = true; 
			 *  		}
		 *  	 }
			 * 
			 * Random rd = new Random();
			 * for(int i = 0; i < cellsToGuess; i++) {
			 * 		int col = rd.nextInt(9) + 1; 
			 * 		int row = rd.nextInt(9) + 1; 
			 * 		hardcodedIsGiven[col][row] = false;
			 *  }
			 */
	      
	        Random rd = new Random();
			  for(int i = 0; i < cellsToGuess; i++) {
			  		int col = rd.nextInt(9); 
			  		int row = rd.nextInt(9); 
			  		hardcodedIsGiven[col][row] = false;
			   }

	      // Copy from hardcodedIsGiven into array "isGiven"
			/*
			 * Nota importante: não esquecer de preencher isGiven com isGivenHeadquarters e
			 * não com hardcodedIsGiven
			 */
	      for (int row = 0; row < SudokuConstants.GRID_SIZE; ++row) {
	         for (int col = 0; col < SudokuConstants.GRID_SIZE; ++col) {
	            isGiven[row][col] = hardcodedIsGiven[row][col];
	         }
	      }
	   }

	   //(For advanced students) use singleton design pattern for this class
	}