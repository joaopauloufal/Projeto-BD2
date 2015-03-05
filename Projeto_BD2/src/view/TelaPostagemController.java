package view;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.auth.AccessToken;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

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
		facebook.setOAuthAccessToken(new AccessToken("CAACEdEose0cBAB7J2IN1cWRV9ZBZCcm26LJNFV0tttHmfIDZAZBZCMpRVPFZAWOszMHMUk33mZALBM80nEldyDLL9vg1Hvfe2IRgDpusJhqYgObPitgESZCQ5pHTNNBuCul9Btf8tufmvdbPOFXHTT0WmaQzqyAlXDftbFTUHZCC8QXLGrmeWp0cLUSaYGI7PTRekPJZACJyX9camHi8dO6JPG"));
		
		try {
			facebook.postStatusMessage(txtTexto.getText());
			System.out.println("Postou.");
			
		} catch (FacebookException e) {
			// TODO Auto-generated catch block
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
