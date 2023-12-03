package DAO;

import java.sql.SQLException;

import models.User;

public interface Games {
	public int getNumberGame() throws SQLException;
	public int[][] getGame() throws SQLException;
	public User getUsuario(String login, String senha) throws SQLException;
	public void setDataUser(String login, String senha, int vitorias, int derrotas) throws SQLException;
}
