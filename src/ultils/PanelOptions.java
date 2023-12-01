package ultils;

import javax.swing.JOptionPane;

import sudoku.GameBoardPanel;
import sudoku.SudokuMain;

public class PanelOptions {
	
	public static void isSolvedGame(String option1, String option2, String message, String title, GameBoardPanel board) {
//		   if(board.isSolved()) {
	        	  Object[] options = {option1,
					option2};
			 		int reply = JOptionPane.showOptionDialog(null,
			 				title, message,JOptionPane.YES_NO_OPTION,
		                    JOptionPane.QUESTION_MESSAGE,
		                    null,     //do not use a custom Icon
		                    options,  //the titles of buttons
		                    options[0]);
			 		if (reply == JOptionPane.YES_OPTION)
		                System.exit(0);
		            //NO_OPTION
		            if (reply == JOptionPane.NO_OPTION) {
		            	board.newGame();
		            	SudokuMain.getInstance().reinitGame();
//		            	MusicPlayer.restartSong();
		            }
//	          }
	   }
	
}
