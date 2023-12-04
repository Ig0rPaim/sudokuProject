package sudoku;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

import ultils.GamePhrases;
import ultils.Levels;
import ultils.PanelOptions;

public class SudokuMain extends JFrame {
	   private static final long serialVersionUID = 1L;  // to prevent serial warning

	   // private variables
	   GameBoardPanel board = GameBoardPanel.getInstance();
	   JButton btnNewGame = new JButton("New Game");
	   Menu menu = new Menu("teste", board);
	   private JLabel cont = new JLabel("Contagem de jogos");
	   private int errosLevel;
	   private int cellsToGuess;
	   private JLabel errosLabel = new JLabel();
	   JMenuBar menuBar = new JMenuBar();
	   private static SudokuMain instance;
	   private int erros = 0;
	   private Timer timer;
	   

	   public SudokuMain(String levelErros, String levelCellsToGuess) {
	        errosLabel = new JLabel("Erros 0/" + errosLevel);
	        menuBar = new JMenuBar();

	        switch (levelErros) {
	            case Levels.DIFFICULT:
	                errosLevel = 3;
	                break;
	            case Levels.MEDIUM:
	                errosLevel = 6;
	                break;
	            case Levels.EASY:
	                errosLevel = 9;
	                break;
	        }

	        switch (levelCellsToGuess) {
	            case Levels.DIFFICULT:
	                cellsToGuess = 81 - 10;
	                break;
	            case Levels.MEDIUM:
	                cellsToGuess = 81 - 35;
	                break;
	            case Levels.EASY:
	                cellsToGuess = 81 - 50;
	                break;
	        }

	        errosLabel.setText("Erros 0/" + errosLevel);
	        setJMenuBar(menuBar);
	        menuBar.add(errosLabel);


	        Container cp = getContentPane();
	        cp.setLayout(new BorderLayout());
	        cp.add(board, BorderLayout.CENTER);

	        // Adiciona um botão ao sul para reiniciar o jogo através de board.newGame()
	        // ......

	        // Inicializa o tabuleiro do jogo para iniciar o jogo
	        board.newGame(cellsToGuess);

	        // Adiciona um item de menu para o cronômetro
	        JMenuItem timerMenuItem = new JMenuItem("Tempo: 00:00");
	        menuBar.add(timerMenuItem);
	        timer = new Timer(timerMenuItem);
	        timer.startTimer();	        
	        
	        JButton startButton = new JButton("Iniciar");
	        JButton stopButton = new JButton("Parar");
	        JButton restartButton = new JButton("Reiniciar");

	        // Adiciona os botões ao menu
	        menuBar.add(startButton);
	        menuBar.add(stopButton);
	        menuBar.add(restartButton);

	        // Adiciona ouvintes de ação aos botões
	        startButton.addActionListener(e -> {
	        	timer.restartTimer();
	        	timer.run();
	        });
	        stopButton.addActionListener(e -> timer.customStop());
	        restartButton.addActionListener(e -> {
	            timer.customStop();
	            timer.reset();
	            timer.start();
	        });
	        
	        // Inicializa o cronômetro
	        

	        pack();  // Empacota os componentes da interface do usuário
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Lidar com o fechamento da janela
	        setTitle("Sudoku");
	        setVisible(true);
	    }
	   
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
	   
	   public static SudokuMain getInstance(String levelErros, String levelCellsToGuess) {
	       if (instance == null) {
	           instance = new SudokuMain(levelErros, levelCellsToGuess);
	       }
	       return instance;
	   }

	   public void reinitGame() {
		    SwingUtilities.invokeLater(() -> {
		        errosLabel.setText("Erros 0/3");
		    });
		}
	   
	   public void contErros() {
		   if(erros >= errosLevel) {
			   PanelOptions.isSolvedGame(GamePhrases.SAIR,
					   GamePhrases.REINICIAR,
					   GamePhrases.ERRORS_MESSAGE,
					   GamePhrases.ERROS_TITLE,
					   board
				   );
		   }
		   erros += 1;
		   errosLabel.setText("Erros " + Integer.toString(erros) + "/"   + Integer.toString(errosLevel));
	   }


	   /** The entry main() entry method */
	   public static void main(String[] args) {
		   
		   TelaInicial telaInicial = TelaInicial.getInstance();
		   telaInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   telaInicial.setVisible(true);
	   }
	}