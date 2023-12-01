package DAO;

import java.sql.SQLException;

import models.User;

public interface Games {
	public int[][] getGame() throws SQLException;
	public User getUsuario();
	public void setDataUser(String login, String senha);
}
