package DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.User;
import sudoku.SudokuConstants;

public class DAOGamesPostgreSql implements Games{
	private PreparedStatement prep;
	
	@Override
	public int[][] getGame() {
		try {
			int numberGame = getNumberGame();
			int[][] game = new int[SudokuConstants.GRID_SIZE][SudokuConstants.GRID_SIZE];
			int linha = 0;
			prep = ConnectionPostgreSql.getInstance().getConn().prepareStatement(
					"SELECT"
					+ "COL_1"
					+ "COL_2"
					+ "COL_3"
					+ "COL_4"
					+ "COL_5"
					+ "COL_6"
					+ "COL_7"
					+ "COL_8"
					+ "COL_9"
					+ "FROM GAME_?;"
					);
			prep.setInt(1, numberGame);
			ResultSet rs = prep.executeQuery();
			while(rs.next()) {
				game[linha][0] = rs.getInt("COL_1");
				game[linha][1] = rs.getInt("COL_2");
				game[linha][2] = rs.getInt("COL_3");
				game[linha][3] = rs.getInt("COL_4");
				game[linha][4] = rs.getInt("COL_5");
				game[linha][5] = rs.getInt("COL_6");
				game[linha][6] = rs.getInt("COL_7");
				game[linha][7] = rs.getInt("COL_8");
				game[linha][8] = rs.getInt("COL_9");
				linha += 1;
			}
			return game;
		}
		catch(SQLException er) {
			er.printStackTrace();
			return null;
		}
	}

	@Override
	public User getUsuario(String login, String senha) {
		try {
			prep = ConnectionPostgreSql.getInstance().getConn().prepareStatement(
					"SELECT *"
					+ "FROM USERS"
					+ "WHERE LOGIN = ?"
					+ "AND PASSWORD = ?;"
					);
			prep.setString(1, login);
			prep.setString(2, senha);
			ResultSet rs = prep.executeQuery();
			User user = null;
			if(rs.next()) {
				user = new User(
						rs.getString("NOME"),
						rs.getInt("VITORIAS"),
						rs.getInt("DERROTAS"),
						rs.getString("LOGIN"),
						rs.getString("PASSWORD")
						);
			}
			return user;
		}
		catch(SQLException er) {
			er.printStackTrace();
			return null;
		}
	}

	@Override
	public void setDataUser(String login, String senha, int vitorias, int derrotas) {
		
	}
	
// é possivel que esse método dê errado
	@Override
	public int getNumberGame() throws SQLException {
		prep = ConnectionPostgreSql.getInstance().getConn().prepareStatement(
				"SELECT ID_GAME"
				+ "FROM CONT_GAMES"
				+ "ORDER BY random()"
				+ "LIMIT 1"
				);
		ResultSet rs = prep.executeQuery();
		if(rs.next())
			return rs.getInt("ID_GAME");
		return (Integer) null;
	}
}
