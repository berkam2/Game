package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.Connect.GetConnection;
import modele.Player;

public class PlayerDao implements IDAO<Player>{
	Connection connect = GetConnection.getConnection();
	ResultSet rs = null;
	
	@Override
	public boolean create(Player Object) {
		// TODO Auto-generated method stub
		boolean msg = false;
		PreparedStatement sql;
		try {
			sql = connect.prepareStatement("INSERT INTO player (email,nickname) VALUE (?,?)");
			sql.setString(1,Object.getEmail());
			sql.setString(2, Object.getNickname());
			sql.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return msg;
	}

	@Override
	public List<Player> read() {
		// TODO Auto-generated method stub
List<Player> listePlayer = new ArrayList<>();
		
		try {
		PreparedStatement req = connect.prepareStatement("SELECT*FROM player");
		ResultSet rs = req.executeQuery();
		while(rs.next()) {
			Player player = new Player();
		
				player.setIdPlayer(rs.getInt("id"));
				player.setEmail(rs.getString("email"));
				player.setNickname(rs.getString("nickname"));
				
				listePlayer.add(player);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listePlayer;
	}

	@Override
	public boolean delete(Player Object) {
		// TODO Auto-generated method stub
		boolean msg = false;
		try {
			PreparedStatement req = connect.prepareStatement("DELETE FROM player"
					+ " WHERE id=?");
			req.setInt(1, Object.getIdPlayer());
			
			
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
	public Player findById(int id) {
		// TODO Auto-generated method stub
		Player player =null;
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM player WHERE id=?");
			req.setInt(1, id);
			
			ResultSet rs = req.executeQuery();
			
			if(rs.next()) {
				
				player =  new Player(rs.getInt("id"),rs.getString("email"),rs.getString("nickname"));
						
			}
			System.out.println(player);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("aaaaa KO - KO - KO");
		}
		return player;

	}
	public List<Player> readPlayerBanc(int id) {
		// TODO Auto-generated method stub
List<Player> listePlayer = new ArrayList<>();
		
		try {
		PreparedStatement req = connect.prepareStatement("SELECT * FROM player as p LEFT JOIN (SELECT * FROM player_contest WHERE contest_id =?) as pc ON p.id=pc.player_id WHERE pc.player_id IS NULL");
		req.setInt(1, id);
		ResultSet rs = req.executeQuery();
		while(rs.next()) {
			Player player = new Player();
		
				player.setIdPlayer(rs.getInt("id"));
				player.setEmail(rs.getString("email"));
				player.setNickname(rs.getString("nickname"));
				
				listePlayer.add(player);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listePlayer;
	}
	
}
