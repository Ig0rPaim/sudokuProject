package sudoku;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.SwingUtilities;

public class SudokuMain extends JFrame {
	   private static final long serialVersionUID = 1L;  // to prevent serial warning

	   // private variables
	   GameBoardPanel board = new GameBoardPanel();
	   JButton btnNewGame = new JButton("New Game");
	   Menu menu = new Menu("teste", board);
	   private JLabel cont = new JLabel("Contagem");
	   JMenuBar menuBar = new JMenuBar();
	   private static SudokuMain instance;
	   // Constructor
	   private SudokuMain() {
		   
		   
		   
		   setJMenuBar(menuBar);
		   menuBar.add(menu);   
		   menuBar.add(cont);
		   Container cp = getContentPane();
	        cp.setLayout(new BorderLayout());
	      cp.add(board, BorderLayout.CENTER);
	      
	      // Add a button to the south to re-start the game via board.newGame()
	      // ......

	      // Initialize the game board to start the game
	      board.newGame();

	      pack();     // Pack the UI components, instead of using setSize()
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // to handle window-closing
	      setTitle("Sudoku");
	      setVisible(true);
	   }
	   
	   public static SudokuMain getInstance() {
	       if (instance == null) {
	           instance = new SudokuMain();
	       }
	       return instance;
	   }

	   
	   public void reinitGame() {
		    SwingUtilities.invokeLater(() -> {
		        cont.setText("cont ++");
		    });
		}


	   /** The entry main() entry method */
	   public static void main(String[] args) {
		   SwingUtilities.invokeLater(() -> {
	            SudokuMain sudoku = getInstance();
	            sudoku.setSize(900, 900);
	            sudoku.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				sudoku.setVisible(true);
	        });
			/*
			 * SudokuMain sudoku = new SudokuMain();
			 * sudoku.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); sudoku.setSize(900,
			 * 900); sudoku.setVisible(true);
			 */
	      // [TODO 1] Check "Swing program template" on how to run
	      //  the constructor of "SudokuMain"
	      // .........
	   }
	}