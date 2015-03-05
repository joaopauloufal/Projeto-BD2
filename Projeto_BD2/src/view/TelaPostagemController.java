package view;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.auth.AccessToken;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;

public class TelaPostagemController {
	
	@FXML
	private TextArea txtTexto;
	
	@FXML
	private Button btnPostar;
	
	private TelaIncialController controller;
	
	
	
	
	
	public TelaPostagemController() {
		txtTexto = new TextArea();
	}
	
	@FXML
	private void btnPostarEvent(){
		Facebook facebook = new FacebookFactory().getInstance();
		facebook.setOAuthAppId("1374466546173686", "b0f45627d18948c1a6eaa1aa3ccd08ad");
		facebook.setOAuthAccessToken(new AccessToken("CAACEdEose0cBAAJVODk9nEcBNNtVFZCVldBcldg0ZC4rVlnb3KUJiG6A2bU6YZBpgPAH5DAdKB34xyZCar1NaJtMSnHEZCyQ9nV2016eg9CZAimoFKypKEoEXZBUhZCkUFVEysGTY1Mj1IDBSDY2zhITZAgCGllRVrZAf4s03Ae4vnpZCleZAxrygIQFcAtipo2K2omdzlfrHQz1H17vZBkDvpdpI"));
		
		try {
			facebook.postStatusMessage(txtTexto.getText());
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Postagem de Status");			
			alert.setHeaderText("Sucesso");
			alert.setContentText("Seu status foi postado!");
			alert.showAndWait();
			
		} catch (FacebookException e) {			
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Postagem de Status");			
			alert.setHeaderText("Erro");
			alert.setContentText("Erro ao postar.");
			alert.showAndWait();
			e.printStackTrace();
		}
	}

	public TelaIncialController getController() {
		return controller;
	}

	public void setController(TelaIncialController controller) {
		this.controller = controller;
	}
	
	

}
