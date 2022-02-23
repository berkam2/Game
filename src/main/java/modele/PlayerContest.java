package modele;

public class PlayerContest {

	private int idPlayerContest;
	private int idPlayer;
	private int idContest;
	public int getIdPlayerContest() {
		return idPlayerContest;
	}
	public void setIdPlayerContest(int idPlayerContest) {
		this.idPlayerContest = idPlayerContest;
	}
	public int getIdPlayer() {
		return idPlayer;
	}
	public void setIdPlayer(int idPlayer) {
		this.idPlayer = idPlayer;
	}
	public int getIdContest() {
		return idContest;
	}
	public void setIdContest(int idContest) {
		this.idContest = idContest;
	}
	public PlayerContest(int idPlayerContest, int idPlayer, int idContest) {
		super();
		this.idPlayerContest = idPlayerContest;
		this.idPlayer = idPlayer;
		this.idContest = idContest;
	}
	public PlayerContest() {
		super();
	}
	
	
}
