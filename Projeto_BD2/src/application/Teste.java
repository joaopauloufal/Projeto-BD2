package application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Amigo;
import model.Perfil;
import model.Post;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.auth.AccessToken;

public class Teste {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("facebook_fql");
		EntityManager em = factory.createEntityManager();
		Facebook facebook = new FacebookFactory().getInstance();
		
		facebook.setOAuthAppId("1374466546173686", "b0f45627d18948c1a6eaa1aa3ccd08ad");
		facebook.setOAuthAccessToken(new AccessToken("CAACEdEose0cBAJFhNkXIbfZA7AXiSpA4XxSZBvThU54uYio9CzROFDtZCjCxkn6Q9ZAdSle5R2bNRgZCARcmfTIDpBzCLySkaK8vJZB4ZB2ZB1WvMZCTzZBRr6ZCyJtxJFGjoiNUasUWc9b8acpVy8P3zwmD8QcJVOX9EJKPfZBaR99MroJQ13lAvHjn3Bxav7c5JsTpG3sKZAideMqzYYHTlDRg2"));
		
		Perfil meuPerfil = new Perfil();
		try {
			meuPerfil.setId(facebook.getMe().getId());
			meuPerfil.setPrimeiroNome(facebook.getMe().getName());
			meuPerfil.setUltimoNome(facebook.getMe().getLastName());
			meuPerfil.setAniversario(facebook.getMe().getBirthday());
			meuPerfil.setLocalidade(facebook.getMe().getLocale().toString());
			meuPerfil.setStatusRelacionamento(facebook.getMe().getRelationshipStatus());
			meuPerfil.setGenero(facebook.getMe().getGender());
		} catch (FacebookException e) {
			e.printStackTrace();
		}
		em.getTransaction().begin();
		em.persist(meuPerfil);
		em.getTransaction().commit();
		
		em.getTransaction().begin();
		try {
			for (int i = 0; i < facebook.getFriends().size(); i++){
			Amigo a = new Amigo();
			a.setId(facebook.getFriends().get(i).getId());
			a.setNome(facebook.getFriends().get(i).getName());
			a.getPerfilId().setId(meuPerfil.getId());
			em.persist(a);
			}
		} catch (FacebookException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		em.getTransaction().commit();
		
		em.getTransaction().begin();
		try {
			for (int i = 0; i < facebook.getPosts().size(); i++){
				Post p = new Post();
				p.setCorpo(facebook.getPosts().get(i).getName());
				p.setPostId(facebook.getPosts().get(i).getId());
				p.getPerfilId().setId(meuPerfil.getId());
				em.persist(p);
			}
		} catch (FacebookException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		em.getTransaction().commit();
		em.close();
		factory.close();

	}

}
