package modele;

import java.util.Date;

public class Contest {

	private int idContest;
	private int gameId;
	private Date startDate;
	private int idWinner;
	public int getIdContest() {
		return idContest;
	}
	public void setIdContest(int idContest) {
		this.idContest = idContest;
	}
	public int getGameId() {
		return gameId;
	}
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public int getIdWinner() {
		return idWinner;
	}
	public void setIdWinner(int idWinner) {
		this.idWinner = idWinner;
	}
	public Contest(int idContest, int gameId, Date startDate, int idWinner) {
		super();
		this.idContest = idContest;
		this.gameId = gameId;
		this.startDate = startDate;
		this.idWinner = idWinner;
	}
	public Contest() {
		super();
	}
	
	
	
}
