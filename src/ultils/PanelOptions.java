package ultils;

import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import sudoku.GameBoardPanel;
import sudoku.SudokuMain;

public class PanelOptions {
	
	public static void isSolvedGame(String option1, String option2, String message, String title, GameBoardPanel board) {
//		   if(board.isSolved()) {
				JPanel panel;
				JLabel label = new JLabel("Reiniciar");
		        JComboBox<String> dropErros = DropdownLevels.getDropdownerros();
		        JComboBox<String> dropCells = DropdownLevels.getDropdowncellstoguess();
				if(!option2.equals(GamePhrases.REINICIAR)) {
					panel = new JPanel(new GridLayout(2, 2));
			        panel.add(new JLabel("Dropdown Erros:"));
			        panel.add(dropErros);
			        panel.add(new JLabel("Dropdown Células para Adivinhar:"));
			        panel.add(dropCells);
				}
				else {
					
					panel = new JPanel();
					panel.add(label);
				}
        
	        	  Object[] options = {option1,
					option2};
			 		int reply = JOptionPane.showOptionDialog(null,
			 				panel,
			 				message,
			 				JOptionPane.YES_NO_OPTION,
		                    JOptionPane.QUESTION_MESSAGE,
		                    null,     //do not use a custom Icon
		                    options,  //the titles of buttons
		                    options[0]);
			 		if (reply == JOptionPane.YES_OPTION)
		                System.exit(0);
		            //NO_OPTION
  	            if (reply == JOptionPane.NO_OPTION) {
		            	if(option2.equals(GamePhrases.REINICIAR))
		            		SudokuMain.getInstance().reinitGame();
		            	else {
		            		String selectedErros = (String) dropErros.getSelectedItem();
			                String selectedCells = (String) dropCells.getSelectedItem();
			                
			    	        switch (selectedErros) {
				            case Levels.DIFFICULT:
				            	SudokuMain.getInstance().setErrosLevel(3);
				                break;
				            case Levels.MEDIUM:
				            	SudokuMain.getInstance().setErrosLevel(6);
				                break;
				            case Levels.EASY:
				            	SudokuMain.getInstance().setErrosLevel(9);
				                break;
			    	        }
			    	        SudokuMain.getInstance().setErros(0);
			    	        SudokuMain.getInstance().setErrosLabel("Erros 0/" + SudokuMain.getInstance().getErrosLevel());
			    	        
			                switch (selectedCells) {
				            case Levels.DIFFICULT:
				            	SudokuMain.getInstance().setCellsToGuess(81 - 10);
				                break;
				            case Levels.MEDIUM:
				            	SudokuMain.getInstance().setCellsToGuess(81 - 35);
				                break;
				            case Levels.EASY:
				            	SudokuMain.getInstance().setCellsToGuess(81 - 50);
				                break;
				        }
			                SudokuMain.getInstance().getTimer().reset();
			                board.newGame(SudokuMain.getInstance().getCellsToGuess());
			            }
		            }
		        }
//	          }778
	   }
	

