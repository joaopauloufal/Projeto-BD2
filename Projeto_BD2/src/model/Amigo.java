package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Amigos")
public class Amigo {
	
	@Id
	@Column(nullable = false)
	private String id;
	
	@Column
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "amigo_id_perfil")
	private Perfil perfilId;
	
	public Amigo() {
		this.perfilId = new Perfil();
		
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	

	public Perfil getPerfilId() {
		return perfilId;
	}

	public void setPerfilId(Perfil perfilId) {
		this.perfilId = perfilId;
	}

	@Override
	public String toString() {
		return "Amigo [id=" + id + ", nome=" + nome + "]";
	}
	

}
