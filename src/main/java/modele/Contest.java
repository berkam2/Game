package modele;

import java.util.Date;

public class Contest {

	private int idContest;
	private Game game;
	private Date startDate;
	private Player joueur;
	public int getIdContest() {
		return idContest;
	}
	public void setIdContest(int idContest) {
		this.idContest = idContest;
	}
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Player getJoueur() {
		return joueur;
	}
	public void setJoueur(Player joueur) {
		this.joueur = joueur;
	}
	public Contest(int idContest, Game game, Date startDate, Player joueur) {
		super();
		this.idContest = idContest;
		this.game = game;
		this.startDate = startDate;
		this.joueur = joueur;
	}
	public Contest() {
		super();
	}
	
	
	
	
}
