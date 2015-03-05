package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoDAO {
	
	private Connection c;
	private String sql;
	private Statement stm;
	
	public ConexaoDAO() {
		try {
			criarBanco();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public Connection abreConexao(){
		
		try {
			c = DriverManager.getConnection("jdbc:mysql://localhost/","root","35216493");
			return c;
		} catch (SQLException e){
			return null;
		}
		
	}
	
	public void desconectar() throws SQLException{
		c.close();
	}
	
	public void executar(String sql) throws SQLException {
		abreConexao();
		stm = null;
		stm = c.createStatement();
		stm.executeUpdate(sql);
		desconectar();
	}
	
	private void criarBanco() throws SQLException {
		sql = "CREATE DATABASE IF NOT EXISTS facebook_fql DEFAULT CHARACTER SET utf8 ";
		executar(sql);
	}
	
	

}
