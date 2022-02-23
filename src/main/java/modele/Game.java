package modele;

public class Game {

	private int idGame;
	private String title;
	private int minPlayers;
	private int maxPlayers;
	public int getIdGame() {
		return idGame;
	}
	public void setIdGame(int idGame) {
		this.idGame = idGame;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getMinPlayers() {
		return minPlayers;
	}
	public void setMinPlayers(int minPlayers) {
		this.minPlayers = minPlayers;
	}
	public int getMaxPlayers() {
		return maxPlayers;
	}
	public void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}
	public Game() {
		super();
	}
	public Game(int idGame, String title, int minPlayers, int maxPlayers) {
		super();
		this.idGame = idGame;
		this.title = title;
		this.minPlayers = minPlayers;
		this.maxPlayers = maxPlayers;
	}
	
	
}
