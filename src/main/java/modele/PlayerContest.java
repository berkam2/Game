package modele;

public class PlayerContest {

	private int idPlayerContest;
	private Player player;
	private Contest contest;
	public int getIdPlayerContest() {
		return idPlayerContest;
	}
	public void setIdPlayerContest(int idPlayerContest) {
		this.idPlayerContest = idPlayerContest;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public Contest getContest() {
		return contest;
	}
	public void setContest(Contest contest) {
		this.contest = contest;
	}
	public PlayerContest(int idPlayerContest, Player player, Contest contest) {
		super();
		this.idPlayerContest = idPlayerContest;
		this.player = player;
		this.contest = contest;
	}
	public PlayerContest() {
		super();
	}
	public PlayerContest(int idPlayerContest) {
		super();
		this.idPlayerContest = idPlayerContest;
	}
	
	
}
