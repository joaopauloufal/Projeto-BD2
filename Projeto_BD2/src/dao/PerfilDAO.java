package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Perfil;

public class PerfilDAO {
	
	public Perfil retornaPerfil(){
		Perfil perfil = new Perfil();
		
		ConexaoDAO cbd = new ConexaoDAO();
		Connection con = cbd.abreConexao();
		PreparedStatement stm;
		
		try {
			stm = con.prepareStatement("SELECT * FROM facebook_fql.Perfil;");
			ResultSet rs = stm.executeQuery();
			
			rs.first();
			perfil.setId(rs.getString("id"));
			perfil.setAniversario(rs.getString("aniversario"));
			perfil.setGenero(rs.getString("genero"));
			perfil.setLocalidade(rs.getString("localidade"));
			perfil.setStatusRelacionamento(rs.getString("statusRelacionamento"));
			perfil.setPrimeiroNome(rs.getString("primeiroNome"));
			perfil.setUltimoNome(rs.getString("ultimoNome"));
			
			rs.close();
			stm.close();
			con.close();
			
			return perfil;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	

}
