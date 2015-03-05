package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import javafx.collections.ObservableList;

@Entity
@Table(name = "Perfis")
public class Perfil {
	
	@Id
	@Column(nullable = false)
	private String id;
	
	@Column
	private String primeiroNome;
	
	@Column
	private String ultimoNome;
	
	@Column
	private String statusRelacionamento;
	
	@Column
	private String localidade;
	
	@Column
	private String aniversario;
	
	@Column
	private String genero;
	
	@OneToMany(mappedBy = "perfilId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Transient
	private ObservableList<Amigo> amigos;
	
	@OneToMany(mappedBy = "postsIds", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Transient
	private ObservableList<Post> posts;
	
	public Perfil() {
		
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	
	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}
	
	
	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}
	
	
	public void setStatusRelacionamento(String statusRelacionamento) {
		this.statusRelacionamento = statusRelacionamento;
	}
	
	
	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}
	
	
	public void setAniversario(String aniversario) {
		this.aniversario = aniversario;
	}
	
	
	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getId() {
		return id;
	}


	public String getPrimeiroNome() {
		return primeiroNome;
	}


	public String getUltimoNome() {
		return ultimoNome;
	}


	public String getStatusRelacionamento() {
		return statusRelacionamento;
	}


	public String getLocalidade() {
		return localidade;
	}


	public String getAniversario() {
		return aniversario;
	}


	public String getGenero() {
		return genero;
	}


	@Override
	public String toString() {
		return "Perfil [id=" + id + ", primeiroNome=" + primeiroNome
				+ ", ultimoNome=" + ultimoNome + ", statusRelacionamento="
				+ statusRelacionamento + ", localidade=" + localidade
				+ ", aniversario=" + aniversario + ", genero=" + genero + "]";
	}
	
	
	
	
	
	
	

}
