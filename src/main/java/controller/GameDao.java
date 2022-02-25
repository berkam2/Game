package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.Connect.GetConnection;
import modele.Game;

public class GameDao implements IDAO<Game>{

	Connection connect = GetConnection.getConnection();
	ResultSet rs = null;
	
	@Override
	public boolean create(Game Object) {
		// TODO Auto-generated method stub
		boolean msg = false;
		PreparedStatement sql;
		try {
			sql = connect.prepareStatement("INSERT INTO game (title, min_players, max_players) VALUE (?,?,?)");
			sql.setString(1,Object.getTitle());
			sql.setInt(2, Object.getMinPlayers());
			sql.setInt(3, Object.getMaxPlayers());
			
			sql.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return msg;
	}

	@Override
	public List<Game> read() {
		// TODO Auto-generated method stub
List<Game> listeGame = new ArrayList<>();
		
		try {
		PreparedStatement req = connect.prepareStatement("SELECT*FROM game");
		ResultSet rs = req.executeQuery();
		while(rs.next()) {
			Game game = new Game();
		
			game.setIdGame(rs.getInt("id"));
			game.setTitle(rs.getString("title"));
			game.setMinPlayers(rs.getInt("min_players"));
			game.setMaxPlayers(rs.getInt("max_players"));
				listeGame.add(game);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listeGame;
	}

	@Override
	public boolean delete(Game Object) {
		// TODO Auto-generated method stub
		boolean msg = false;
		try {
			PreparedStatement req = connect.prepareStatement("DELETE FROM game"
					+ " WHERE id=?");
			req.setInt(1, Object.getIdGame());
			
			
			req.executeUpdate();
			
			System.out.println( "l'element a été bien updaté en base");
			msg = true;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Insertion KO");
		}
		return msg;
	}

	@Override
	public Game findById(int id) {
		// TODO Auto-generated method stub
		Game game =null;
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM game WHERE id=?");
			req.setInt(1, id);
			
			ResultSet rs = req.executeQuery();
			
			if(rs.next()) {
				
				game =  new Game(rs.getInt("id"),rs.getString("title"),rs.getInt("min_players"),rs.getInt("max_players"));
						
			}
			System.out.println(game);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("aaaaa KO - KO - KO");
		}
		return game;
	}

}
