package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Amigo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AmigoDAO {
	
	
	
	public ObservableList<Amigo> buscaAmigos(){
		ObservableList<Amigo> amigos;
		amigos = FXCollections.observableArrayList();
		
		ConexaoDAO cbd = new ConexaoDAO();
		Connection con = cbd.abreConexao();
		PreparedStatement stm;
		try {
			stm = con.prepareStatement("SELECT * FROM facebook_fql.Amigos;");
			ResultSet rs = stm.executeQuery();
			
			while (rs.next()){
				Amigo amigo = new Amigo();
				amigo.setId(rs.getString("id"));
				amigo.getPerfilId().setId(rs.getString("amigo_id_perfil"));
				amigo.setNome(rs.getString("nome"));
				amigos.add(amigo);
			}
			
			rs.close();
			stm.close();
			con.close();
			return amigos;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
	}

}
