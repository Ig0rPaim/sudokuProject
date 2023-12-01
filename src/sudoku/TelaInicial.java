package sudoku;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ultils.Levels;

public class TelaInicial extends JFrame {

    private JComboBox<String> dropdown;
    private JButton btnIniciar;
    private static TelaInicial instance;

    public static TelaInicial getInstance() {
    	if(instance == null)
    		instance = new TelaInicial();
    	return instance;
    }
    
    private TelaInicial() {
        // Configurações básicas do JFrame
        setTitle("Tela Inicial");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Criação da dropdown
        String[] opcoes = {Levels.DIFFICULT, Levels.MEDIUM, Levels.EASY};
//        HashMap<Levels, String> opcoes = new HashMap<>();
//        opcoes.put(Levels.DIFFICULT, "Dificíl");
//        opcoes.put(Levels.MEDIUM, "Intermediário");
//        opcoes.put(Levels.EASY, "Fácil");
//        String[] t = opcoes.values().toArray(new String[0]);
        dropdown = new JComboBox<>(opcoes);

        // Criação do botão
        btnIniciar = new JButton("Iniciar");
        btnIniciar.addActionListener(new iniciarEvent());
        // Configuração do layout
        JPanel panel = new JPanel();
        panel.add(dropdown);
        panel.add(btnIniciar);

        // Adiciona o painel ao centro do JFrame
        add(panel, BorderLayout.CENTER);
    }

	private class iniciarEvent implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			SudokuMain s = SudokuMain.getInstance((String)dropdown.getSelectedItem());
			TelaInicial.getInstance().dispose();
			
//			SudokuMain sudoku = getInstance();
            s.setSize(900, 900);
            s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			s.setVisible(true);
			
//			s.setVisible(true);
		}
    	
    }
}
