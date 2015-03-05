package view;

import java.io.IOException;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.auth.AccessToken;
import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
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
			facebook.setOAuthAccessToken(new AccessToken("CAACEdEose0cBAFJYbuXi5vqgk93CPM3rTnemlbs8BAkXAJYB1puekobHYpgxmaP9LqdWCLhjLjEr3VPfJ3bg0ZBwmVBBsfnL95ViSapAhaLqnkAnEihRZCxwRghMFtm4G07ZB52B5CWeXNk0fOgRt8RrUyaKyKU4W4faZBZBz9qZC3b2vxZCi1BhCEPmOfbsAd8eHepJWybhOPpQqWsbXOO"));
			
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
	
	

}
