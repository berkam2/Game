package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.Connect.GetConnection;
import modele.Contest;


public class ContestDao implements IDAO<Contest> {

	PlayerDao playDao = new PlayerDao();
	GameDao gameDao = new GameDao();
	Connection connect = GetConnection.getConnection();
	ResultSet rs = null;
	@Override
	public boolean create(Contest Object) {
		// TODO Auto-generated method stub
		boolean msg = false;
		PreparedStatement sql;
		try {
			sql = connect.prepareStatement("INSERT INTO contest (game_id,start_date) VALUE (?,?)");
			sql.setInt(1,Object.getGame().getIdGame());
			sql.setDate(2, Object.getStartDate());
			sql.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return msg;
	}

	@Override
	public List<Contest> read() {
		// TODO Auto-generated method stub
		List<Contest> listeContest = new ArrayList<>();
		try {
			PreparedStatement req = connect.prepareStatement("SELECT*FROM contest");
			ResultSet rs = req.executeQuery();
			while(rs.next()) {
				Contest contest = new Contest();
			
					contest.setIdContest(rs.getInt("id"));
					
					contest.setJoueur(playDao.findById(rs.getInt("winner_id")));
					contest.setGame(gameDao.findById(rs.getInt("game_id")));
					contest.setStartDate(rs.getDate("start_date"));
					listeContest.add(contest);
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return listeContest;
	}

	@Override
	public boolean delete(Contest Object) {
		// TODO Auto-generated method stub
		boolean msg = false;
		try {
			PreparedStatement req = connect.prepareStatement("DELETE FROM contest"
					+ " WHERE id=?");
			req.setInt(1, Object.getIdContest());
			
			
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
	public Contest findById(int id) {
		// TODO Auto-generated method stub
		Contest contest =null;
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM contest WHERE id=?");
			req.setInt(1, id);
			
			ResultSet rs = req.executeQuery();
			
			if(rs.next()) {
				
				contest =  new Contest(rs.getInt("id"),gameDao.findById(rs.getInt("game_id")),rs.getDate("start_date"),playDao.findById(rs.getInt("winner_id")));
						
			}
			System.out.println(contest);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("aaaaa KO - KO - KO");
		}
		return contest;
	}

	public Boolean update(Contest Object) {
		// TODO Auto-generated method stub
		
		boolean msg = false;
		try {
			PreparedStatement req = connect.prepareStatement("UPDATE contest SET winner_id=?"
					+ " WHERE id_contest=?");
			req.setInt(2, Object.getIdContest());
			req.setInt(1,Object.getJoueur().getIdPlayer());
			
			
			req.executeUpdate();
			
			System.out.println("l'élément  a été bien updaté en base");
			msg = true;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Insertion KO");
		}
		return msg;

	}
	
}
