package ultils;

import javax.swing.JComboBox;

public class DropdownLevels {
	private static final String[] opcoes = { Levels.DIFFICULT, Levels.MEDIUM, Levels.EASY };
	private static final JComboBox<String> dropdownErros = new JComboBox<>(opcoes);
	private static final JComboBox<String> dropdownCellsToGuess = new JComboBox<>(opcoes);
	
	public static JComboBox<String> getDropdowncellstoguess() {
		return dropdownCellsToGuess;
	}
	
	public static JComboBox<String> getDropdownerros() {
		return dropdownErros;
	}
	
}
