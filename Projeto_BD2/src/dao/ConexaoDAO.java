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
		criarTabelaPerfil();
		criarTabelaAmigos();
		criarTabelaPosts();
	}
	
	private void criarTabelaPerfil()throws SQLException {
		sql = "CREATE TABLE IF NOT EXISTS facebook_fql.Perfil("
				+" id VARCHAR(120) NOT NULL,"
				+" primeiroNome VARCHAR(120),"
				+" ultimoNome VARCHAR(120),"
				+" statusRelacionamento VARCHAR(120),"
				+" localidade VARCHAR(60),"
				+" aniversario VARCHAR(60),"
				+" genero VARCHAR (60),"
				+" PRIMARY KEY(id))"
				+" ENGINE = InnoDB"
				+" DEFAULT CHARACTER SET = utf8;";
		executar(sql);
				
	}
	
	private void criarTabelaAmigos() throws SQLException {
		sql = "CREATE TABLE IF NOT EXISTS facebook_fql.Amigos("
				+" id VARCHAR(120) NOT NULL,"
				+" nome VARCHAR(120),"
				+" amigo_id_perfil VARCHAR(120) NOT NULL,"
				+" PRIMARY KEY(id),"
				+" FOREIGN KEY(amigo_id_perfil)"
				+" REFERENCES facebook_fql.Perfil(id)"
				+" ON DELETE CASCADE ON UPDATE CASCADE)"
				+" ENGINE = InnoDB"
	            +" DEFAULT CHARACTER SET = utf8;";	
		executar(sql);
				
	}
	
	private void criarTabelaPosts() throws SQLException {
		sql = "CREATE TABLE IF NOT EXISTS facebook_fql.Posts("
				+" postId VARCHAR(120) NOT NULL,"
				+" corpo VARCHAR(120),"
				+" post_id_perfil VARCHAR(120) NOT NULL,"
				+" PRIMARY KEY(postId),"
				+" FOREIGN KEY(post_id_perfil)"
				+" REFERENCES facebook_fql.Perfil(id)"
				+" ON DELETE CASCADE ON UPDATE CASCADE)"
				+" ENGINE = InnoDB "
	            +" DEFAULT CHARACTER SET = utf8;";	
		executar(sql);
				
	}
	
	

}
