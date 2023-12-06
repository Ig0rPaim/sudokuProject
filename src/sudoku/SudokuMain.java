package sudoku;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import ultils.DropdownLevels;
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

	        
	        board.newGame(cellsToGuess);

	        JMenuItem timerMenuItem = new JMenuItem("Tempo: 00:00");
	        
	        Box verticalBox = Box.createVerticalBox();
	        verticalBox.add(Box.createVerticalGlue());  // Espaço superior
	        Box horizontalBox = Box.createHorizontalBox();
	        horizontalBox.add(Box.createHorizontalGlue());  // Espaço à esquerda
	        horizontalBox.add(timerMenuItem);
	        horizontalBox.add(Box.createHorizontalGlue());  // Espaço à direita
	        verticalBox.add(horizontalBox);
	        verticalBox.add(Box.createVerticalGlue());  
	        
	        menuBar.add(verticalBox);
	        
//	        menuBar.add(timerMenuItem);
	         
	        
	        timer = Timer.getInstance(timerMenuItem);
	        timer.startTimer();	        
	        
	        JButton startButton = new JButton("Novo Jogo");
//	        JButton stopButton = new JButton("Parar");
	        JButton restartButton = new JButton("Reiniciar");

	        // Adiciona os botões ao menu
	        menuBar.add(startButton);
//	        menuBar.add(stopButton);
	        menuBar.add(restartButton);

	       
	        startButton.addActionListener(e -> {
	        	Object[] options = {"Sair", "Novo Jogo"};

	            // Criar um painel com dois JComboBox
	            JPanel panel = new JPanel(new GridLayout(2, 2));
	            JComboBox<String> dropErros = DropdownLevels.getDropdownerros();
	            JComboBox<String> dropCells = DropdownLevels.getDropdowncellstoguess();
	            panel.add(new JLabel("Dropdown Erros:"));
	            panel.add(dropErros);
	            panel.add(new JLabel("Dropdown Células para Adivinhar:"));
	            panel.add(dropCells);

	            int reply = JOptionPane.showOptionDialog(
	                    null,
	                    panel,
	                    "Escolha os filtros",
	                    JOptionPane.YES_NO_OPTION,
	                    JOptionPane.QUESTION_MESSAGE,
	                    null,
	                    options,
	                    options[0]);

	            if (reply == JOptionPane.YES_OPTION) {
//	                System.exit(0);
	            	JOptionPane.getRootFrame().dispose();
	            }

	            if (reply == JOptionPane.NO_OPTION) {
	                String selectedErros = (String) dropErros.getSelectedItem();
	                String selectedCells = (String) dropCells.getSelectedItem();
	                
	    	        switch (selectedErros) {
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
	    	        erros = 0;
	    	        errosLabel.setText("Erros 0/" + errosLevel);
	    	        
	                switch (selectedCells) {
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
	                timer.reset();
	                board.newGame(cellsToGuess);
	            }
	        });
//	        stopButton.addActionListener(e -> timer.customStop());
	        restartButton.addActionListener(e -> {
	        	timer.reset();
	        	erros = 0;
	        	errosLabel.setText("Erros 0/" + errosLevel);
	            board.clearGame();
	        });

	        pack();  // Empacota os componentes da interface do usuário
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
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