package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.Connect.GetConnection;
import modele.Contest;
import modele.Player;
import modele.PlayerContest;

public class PlayerContestDao implements IDAO<PlayerContest> {

	PlayerDao playDao = new PlayerDao();
	ContestDao cDao = new ContestDao();
	GameDao gameDao = new GameDao();
	Connection connect = GetConnection.getConnection();
	ResultSet rs = null;
	
	@Override
	public boolean create(PlayerContest Object) {
		// TODO Auto-generated method stub
		boolean msg = false;
		PreparedStatement sql;
		try {
			sql = connect.prepareStatement("INSERT INTO player_contest (player_id,contest_id) VALUE (?,?)");
			sql.setInt(1,Object.getPlayer().getIdPlayer());
			sql.setInt(2, Object.getContest().getIdContest());
			sql.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return msg;
	}

	@Override
	public List<PlayerContest> read() {
		// TODO Auto-generated method stub
		List<PlayerContest> listePC = new ArrayList<>();
		try {
			PreparedStatement req = connect.prepareStatement("SELECT*FROM player_contest");
			ResultSet rs = req.executeQuery();
			while(rs.next()) {
				PlayerContest pc = new PlayerContest();
			
					pc.setIdPlayerContest(rs.getInt("id"));
					pc.setContest(cDao.findById(rs.getInt("contest_id")));
					pc.setPlayer(playDao.findById(rs.getInt("player_id")));
					listePC.add(pc);
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return listePC;
	}

	@Override
	public boolean delete(PlayerContest Object) {
		// TODO Auto-generated method stub
		boolean msg = false;
		try {
			PreparedStatement req = connect.prepareStatement("DELETE FROM player_contest"
					+ " WHERE id=?");
			req.setInt(1, Object.getIdPlayerContest());
			
			
			req.executeUpdate();
			
			System.out.println( "l'élement a bien été updaté en base");
			msg = true;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Insertion KO");
		}
		return msg;
	}

	@Override
	public PlayerContest findById(int id) {
		// TODO Auto-generated method stub
		PlayerContest pc =null;
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM player_contest WHERE id=?");
			req.setInt(1, id);
			
			ResultSet rs = req.executeQuery();
			
			if(rs.next()) {
				
				pc =  new PlayerContest(rs.getInt("id"),playDao.findById(rs.getInt("player_id")),cDao.findById(rs.getInt("contest_id")));
						
			}
			System.out.println(pc);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("aaaaa KO - KO - KO");
		}
		return pc;
	}

	public List<PlayerContest> readJoueur(int id) {
		// TODO Auto-generated method stub
		List<PlayerContest> listeContestJoueur = new ArrayList<>();
		try {
			PreparedStatement req = connect.prepareStatement("SELECT*FROM player_contest WHERE contest_id=?");
			req.setInt(1, id);
			ResultSet rs = req.executeQuery();
			while(rs.next()) {
				PlayerContest pc = new PlayerContest();
			
					pc.setIdPlayerContest(rs.getInt("id"));
					pc.setContest(cDao.findById(rs.getInt("contest_id")));
					pc.setPlayer(playDao.findById(rs.getInt("player_id")));
					listeContestJoueur.add(pc);
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return listeContestJoueur;
	}
	public List<PlayerContest> readPlayerContest(int id) {
		// TODO Auto-generated method stub
List<PlayerContest> listePlayer = new ArrayList<>();
		
		try {
		PreparedStatement req = connect.prepareStatement("SELECT * FROM player_contest WHERE contest_id =?");
		req.setInt(1, id);
		ResultSet rs = req.executeQuery();
		while(rs.next()) {
			PlayerContest pc = new PlayerContest();
		
			pc.setIdPlayerContest(rs.getInt("id"));
			pc.setContest(cDao.findById(rs.getInt("contest_id")));
			pc.setPlayer(playDao.findById(rs.getInt("player_id")));
			
				listePlayer.add(pc);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listePlayer;
	}
	
	public List<PlayerContest> readPlayerBanc(int id) {
		// TODO Auto-generated method stub
List<PlayerContest> listePlayer = new ArrayList<>();
		
		try {
		PreparedStatement req = connect.prepareStatement("SELECT * FROM player_contest WHERE contest_id !=?");
		req.setInt(1, id);
		ResultSet rs = req.executeQuery();
		while(rs.next()) {
			PlayerContest pc = new PlayerContest();
		
			pc.setIdPlayerContest(rs.getInt("id"));
			pc.setContest(cDao.findById(rs.getInt("contest_id")));
			pc.setPlayer(playDao.findById(rs.getInt("player_id")));
			
				listePlayer.add(pc);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listePlayer;
	}


}
