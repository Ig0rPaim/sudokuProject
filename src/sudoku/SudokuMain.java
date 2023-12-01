package sudoku;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import ultils.PanelOptions;

public class SudokuMain extends JFrame {
	   private static final long serialVersionUID = 1L;  // to prevent serial warning

	   // private variables
	   GameBoardPanel board = GameBoardPanel.getInstance();
	   JButton btnNewGame = new JButton("New Game");
	   Menu menu = new Menu("teste", board);
	   private JLabel cont = new JLabel("Contagem de jogos");
	   private JLabel errosLabel = new JLabel("Erros 0/3");
	   JMenuBar menuBar = new JMenuBar();
	   private static SudokuMain instance;
	   private int erros = 0;
	   // Constructor
	   private SudokuMain() {
		   
		   
		   
		   setJMenuBar(menuBar);
//		   menuBar.add(menu);   
//		   menuBar.add(cont);
		   menuBar.add(errosLabel);
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
		        errosLabel.setText("Erros 0/3");
		    });
		}
	   
	   public void contErros() {
		   if(erros >= 3) {
			   PanelOptions.isSolvedGame("sair", "reiniciar","Que merda, hein", "errou de mais, parceiro", board);
		   }
		   erros += 1;
		   errosLabel.setText("Erros " + Integer.toString(erros) + "/3");
	   }


	   /** The entry main() entry method */
	   public static void main(String[] args) {
		   
		   TelaInicial telaInicial = TelaInicial.getInstance();
		   telaInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   telaInicial.setVisible(true);
//		   SwingUtilities.invokeLater(() -> {
//	            SudokuMain sudoku = getInstance();
//	            sudoku.setSize(900, 900);
//	            sudoku.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//				sudoku.setVisible(true);
//	        });
			
	      // [TODO 1] Check "Swing program template" on how to run
	      //  the constructor of "SudokuMain"
	      // .........
	   }
	}