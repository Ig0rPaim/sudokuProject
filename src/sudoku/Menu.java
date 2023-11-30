package sudoku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Menu extends JMenu{ 
	GameBoardPanel boarder;
	public Menu(GameBoardPanel boarder) {
		super();
		this.boarder = boarder;
		JMenuItem conferirJogoItem = new JMenuItem("Conferir Jogo");
        JMenuItem pausarItem = new JMenuItem("Pausar");
        JMenuItem statusItem = new JMenuItem("Status");
        
        conferirJogoItem.addActionListener(new conferirJogoEvent());
        
        add(conferirJogoItem);
        add(pausarItem);
        add(statusItem);
	}
	private class conferirJogoEvent implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if(boarder.isSolved()) {
				JOptionPane.showMessageDialog(
						null,
						"Parabéns arrombadinho, você conseguiu",
						"você é brabo",
						JOptionPane.PLAIN_MESSAGE
				);
			}
		}
	}
}
