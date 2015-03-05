package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Post;

public class PostDAO {
	
	public ObservableList<Post> buscaPosts(){
		ObservableList<Post> posts;
		posts = FXCollections.observableArrayList();
		
		ConexaoDAO cbd = new ConexaoDAO();
		Connection con = cbd.abreConexao();
		PreparedStatement stm;
		try {
			stm = con.prepareStatement("SELECT * FROM facebook_fql.Posts;");
			ResultSet rs = stm.executeQuery();
			
			while (rs.next()){
				Post post = new Post();
				post.setPostId(rs.getString("postId"));
				post.getPerfilId().setId(rs.getString("post_id_perfil"));
				post.setCorpo(rs.getString("corpo"));
				posts.add(post);
			}
			
			rs.close();
			stm.close();
			con.close();
			return posts;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
	}

}
