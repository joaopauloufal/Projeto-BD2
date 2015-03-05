package view;

import java.io.IOException;

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
import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TelaIncialController {
	
	@FXML
	private MenuItem menuItemSair;
	
	@FXML
	private MenuItem menuItemExibirPerfil;
	
	@FXML
	private MenuItem menuItemListarAmigos;
	
	@FXML
	private MenuItem menuItemListarPosts;
	
	@FXML
	private MenuItem menuItemPostarNoFeed;
	
	@FXML
	private MenuItem menuItemSobre;
	
	@FXML
	private ImageView image;
	
	private Main main;
	
	

	public TelaIncialController() {
		
	}
	
	@FXML
	private void initialize() {
		

	}
	
	@FXML
	private void sairEvent(){
		System.exit(0);
	}
	
	@FXML
	private void menuExibirPerfilEvent(){
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/view/TelaPerfil.fxml"));
		try {
			GridPane telaExibirPerfil = (GridPane) loader.load();
			TelaPerfilControler controller = loader.getController();
			Facebook facebook = new FacebookFactory().getInstance();
			facebook.setOAuthAppId("1374466546173686", "b0f45627d18948c1a6eaa1aa3ccd08ad");
			facebook.setOAuthAccessToken(new AccessToken("CAATiEe49hvYBABnuWLn4uMq9NvZB6p081OKioMFgGcwnDBAD676k1aNyZAX14ABrFdrAs8wuxaMWqtQZBYzBszxdeQ1ftT2HsPiWUBPmmNe3fhq8BSujcME1ZBe5HaCFrmjAwZCWQuyz7eCiCwHXU1V4t89JL3I5KGTRZBjIPlkOPfGwn9YVdvyrqeZBT8fnrgRaY2KvYqix7bWs6bjmAUQ"));
			
			try {
				controller.getLblIdValor().setText(facebook.getMe().getId());
				controller.getLblPrimeiroNomeValor().setText(facebook.getMe().getFirstName());
				controller.getLblUltimoNomeValor().setText(facebook.getMe().getLastName());
				controller.getLblAniversarioValor().setText(facebook.getMe().getBirthday());
				controller.getLblGeneroValor().setText(facebook.getMe().getGender());
				controller.getLblStatusRelacionamentoValor().setText(facebook.getMe().getRelationshipStatus());
				controller.getLblLocalidadeValor().setText(facebook.getMe().getLocale().toString());
			} catch (FacebookException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			controller.setController(this);
			Scene scene = new Scene(telaExibirPerfil);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Exibir Perfil");
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.showAndWait();

		} catch (IOException e){
			e.printStackTrace();
		}
		
	}
	
	@FXML
	private void telaPostagemEvent(){
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/view/TelaPostagem.fxml"));
		try {
			AnchorPane  telaPostagem = (AnchorPane) loader.load();
			TelaPostagemController controller = loader.getController();
			controller.setController(this);
			Scene scene = new Scene(telaPostagem);
			Stage stage = new Stage();
			stage.setTitle("Postar Status");
			stage.setScene(scene);
			stage.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}
	
	@FXML
	private void exibirTelaTabelaAmigosEvent(){
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/view/TelaTabelaAmigos.fxml"));
		try {
			BorderPane  telaTabelaAmigos = (BorderPane) loader.load();
			TelaTabelaAmigosController controller = loader.getController();
			controller.setController(this);
			Scene scene = new Scene(telaTabelaAmigos);
			Stage stage = new Stage();
			stage.setTitle("Lista de Amigos");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@FXML
	private void exibirTelaTabelaPostsEvent(){
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/view/TelaTabelaPosts.fxml"));
		try {
			BorderPane telaTabelaPosts = (BorderPane) loader.load();
			TelaTabelaPostsController controller = loader.getController();
			controller.setController(this);
			Scene scene = new Scene(telaTabelaPosts);
			Stage stage = new Stage();
			stage.setTitle("Lista de Postagens");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@FXML
	private void salvarDadosFacebookNoBanco(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("facebook_fql");
		EntityManager em = factory.createEntityManager();
		Facebook facebook = new FacebookFactory().getInstance();
		
		facebook.setOAuthAppId("1374466546173686", "b0f45627d18948c1a6eaa1aa3ccd08ad");
		facebook.setOAuthAccessToken(new AccessToken("CAACEdEose0cBAAJVODk9nEcBNNtVFZCVldBcldg0ZC4rVlnb3KUJiG6A2bU6YZBpgPAH5DAdKB34xyZCar1NaJtMSnHEZCyQ9nV2016eg9CZAimoFKypKEoEXZBUhZCkUFVEysGTY1Mj1IDBSDY2zhITZAgCGllRVrZAf4s03Ae4vnpZCleZAxrygIQFcAtipo2K2omdzlfrHQz1H17vZBkDvpdpI"));
		
		Perfil meuPerfil = new Perfil();
		try {
			meuPerfil.setId(facebook.getMe().getId());
			meuPerfil.setPrimeiroNome(facebook.getMe().getName());
			meuPerfil.setUltimoNome(facebook.getMe().getLastName());
			meuPerfil.setAniversario(facebook.getMe().getBirthday());
			meuPerfil.setLocalidade(facebook.getMe().getLocale().toString());
			meuPerfil.setStatusRelacionamento(facebook.getMe().getRelationshipStatus());
			meuPerfil.setGenero(facebook.getMe().getGender());
		
		em.getTransaction().begin();
		em.persist(meuPerfil);
		em.getTransaction().commit();
		
		em.getTransaction().begin();
		
			for (int i = 0; i < facebook.getFriends().size(); i++){
			Amigo a = new Amigo();
			a.setId(facebook.getFriends().get(i).getId());
			a.setNome(facebook.getFriends().get(i).getName());
			a.getPerfilId().setId(meuPerfil.getId());
			em.persist(a);
			em.flush();
			}
		
		em.getTransaction().commit();
		
		em.getTransaction().begin();
		
			for (int i = 0; i < facebook.getPosts().size(); i++){
				Post p = new Post();
				p.setCorpo(facebook.getPosts().get(i).getName());
				p.setPostId(facebook.getPosts().get(i).getId());
				p.getPerfilId().setId(meuPerfil.getId());
				em.flush();
				em.persist(p);
			}
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Inserção de Dados do Facebook p/ o Banco.");			
			alert.setHeaderText("Inserção Concuida.");
			alert.setContentText("Inserção Concluida.");
			alert.showAndWait();
		} catch (FacebookException e){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Inserção de Dados do Facebook p/ o Banco.");			
			alert.setHeaderText("Erro.");
			alert.setContentText("Erro ao inserir.");
			alert.showAndWait();
		}
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
	
	
	
	

}
