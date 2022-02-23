package modele;

public class Player {

	private int idPlayer;
	private String email;
	private String nickname;
	public int getIdPlayer() {
		return idPlayer;
	}
	public void setIdPlayer(int idPlayer) {
		this.idPlayer = idPlayer;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Player(int idPlayer, String email, String nickname) {
		super();
		this.idPlayer = idPlayer;
		this.email = email;
		this.nickname = nickname;
	}
	public Player() {
		super();
	}
	
	
}
