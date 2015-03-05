package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Posts")
public class Post {
	
	@Id
	@Column(nullable = false)
	private String postId;
	
	@ManyToOne
	@JoinColumn(name = "post_id_perfil")
	private Perfil perfilId;
	
	@Column
	private String corpo;
	
	public Post() {
		this.perfilId = new Perfil();
	}
	
	
	
	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}


	public String getCorpo() {
		return corpo;
	}

	public Perfil getPerfilId() {
		return perfilId;
	}


	public void setPerfilId(Perfil perfilId) {
		this.perfilId = perfilId;
	}

	public String getPostId() {
		return postId;
	}


	public void setPostId(String postId) {
		this.postId = postId;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", perfilId=" + perfilId + ", corpo="
				+ corpo + "]";
	}
	
	
	

	
	
	
	
	
	

}
