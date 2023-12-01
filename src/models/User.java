package models;

public class User {
	private String nome;
	private int vitorias;
	private int derrotas;
	private String login;
	private String senha;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getVitorias() {
		return vitorias;
	}
	public void setVitorias(int vitorias) {
		this.vitorias = vitorias;
	}
	public int getDerrotas() {
		return derrotas;
	}
	public void setDerrotas(int derrotas) {
		this.derrotas = derrotas;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public User(String nome, int vitorias, int derrotas, String login, String senha) {
		this.nome = nome;
		this.vitorias = vitorias;
		this.derrotas = derrotas;
		this.login = login;
		this.senha = senha;
	}
}
