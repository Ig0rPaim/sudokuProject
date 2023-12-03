package sudoku;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ultils.Levels;

public class TelaInicial extends JFrame {

    private JComboBox<String> dropdownErros;
    private JComboBox<String> dropdownCellsToGuess;
    private JButton btnIniciar;
    private static TelaInicial instance;

    public static TelaInicial getInstance() {
    	if(instance == null)
    		instance = new TelaInicial();
    	return instance;
    }
    
    private TelaInicial() {
        setTitle("Tela Inicial");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] opcoes = { Levels.DIFFICULT, Levels.MEDIUM, Levels.EASY };
        dropdownErros = new JComboBox<>(opcoes);
        dropdownCellsToGuess = new JComboBox<>(opcoes);

        btnIniciar = new JButton("Iniciar");
        btnIniciar.addActionListener(new iniciarEvent());

        // JPanel para os rótulos
        JPanel labelsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10)); 
        labelsPanel.add(new JLabel("Quantidade de erros:"));
        labelsPanel.add(new JLabel("Quantidade de pistas:"));

        // JPanel para as dropdowns
        JPanel dropdownsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10)); 
        dropdownsPanel.add(dropdownErros);
        dropdownsPanel.add(dropdownCellsToGuess);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(btnIniciar);

        add(labelsPanel, BorderLayout.NORTH);
        add(dropdownsPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }    
    private class iniciarEvent implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			SudokuMain s = SudokuMain
					.getInstance(
							(String)dropdownErros
							.getSelectedItem(),
							(String) dropdownCellsToGuess
							.getSelectedItem()
							);
			TelaInicial.getInstance().dispose();
			
            s.setSize(900, 900);
            s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			s.setVisible(true);
			
		}
    	
    }
}
