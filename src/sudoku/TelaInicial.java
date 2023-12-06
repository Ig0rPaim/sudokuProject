package sudoku;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ultils.DropdownLevels;
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
        setSize(600, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon initialImage = new ImageIcon(getClass().getResource("/images/sudoku_image_2.png"));
        JLabel imageLabel = new JLabel(initialImage);

//        String[] opcoes = { Levels.DIFFICULT, Levels.MEDIUM, Levels.EASY };
        dropdownErros = DropdownLevels.getDropdownerros();//new JComboBox<>(opcoes);
        dropdownCellsToGuess = DropdownLevels.getDropdowncellstoguess();//new JComboBox<>(opcoes);

        btnIniciar = new JButton("Iniciar");
        btnIniciar.addActionListener(new IniciarEvent());

        // JPanel para os rótulos
        JPanel labelsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        labelsPanel.add(new JLabel("Quantidade de erros:"));
        labelsPanel.add(new JLabel("Quantidade de pistas:"));

        // JPanel para as dropdowns
        JPanel dropdownsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        dropdownsPanel.add(dropdownErros);
        dropdownsPanel.add(dropdownCellsToGuess);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(btnIniciar);

        // Configuração do GridBagLayout
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 10, 0);  // Adiciona espaçamento entre os componentes
        mainPanel.add(imageLabel, gbc);

        gbc.gridy = 1;
        mainPanel.add(labelsPanel, gbc);

        gbc.gridy = 2;
        mainPanel.add(dropdownsPanel, gbc);

        gbc.gridy = 3;
        mainPanel.add(buttonPanel, gbc);

        add(mainPanel);
    }
    
    
    private class IniciarEvent implements ActionListener{

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
