package view;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class TelaPerfilControler extends GridPane {
	
	private Main main;
	
	
	@FXML
	private Label lblIdValor;
	
	@FXML
	private Label lblPrimeiroNomeValor;
	
	@FXML
	private Label lblUltimoNomeValor;
	
	@FXML
	private Label lblStatusRelacionamentoValor;
	
	

	@FXML
	private Label lblLocalidadeValor;
	
	@FXML
	private Label lblAniversarioValor;
	
	@FXML
	private Label lblGeneroValor;
	
	
	private TelaIncialController controller;
	
	public TelaPerfilControler() {
		lblIdValor = new Label();
		lblPrimeiroNomeValor = new Label();
		lblUltimoNomeValor = new Label();
		lblStatusRelacionamentoValor = new Label();
		lblLocalidadeValor = new Label();
		lblAniversarioValor = new Label();
		lblGeneroValor = new Label();
		
		
		
	}
	
	@FXML
	private void initialize() {
		

	}
	
	@FXML
	private void btnOkEvent(){
		
	}
	
	

	public TelaIncialController getController() {
		return controller;
	}

	public void setController(TelaIncialController controller) {
		this.controller = controller;
	}

	public Label getLblIdValor() {
		return lblIdValor;
	}

	public void setLblIdValor(Label lblIdValor) {
		this.lblIdValor = lblIdValor;
	}

	public Label getLblPrimeiroNomeValor() {
		return lblPrimeiroNomeValor;
	}

	public void setLblPrimeiroNomeValor(Label lblPrimeiroNomeValor) {
		this.lblPrimeiroNomeValor = lblPrimeiroNomeValor;
	}

	public Label getLblUltimoNomeValor() {
		return lblUltimoNomeValor;
	}

	public void setLblUltimoNomeValor(Label lblUltimoNomeValor) {
		this.lblUltimoNomeValor = lblUltimoNomeValor;
	}

	public Label getLblStatusRelacionamentoValor() {
		return lblStatusRelacionamentoValor;
	}

	public void setLblStatusRelacionamentoValor(Label lblStatusRelacionamentoValor) {
		this.lblStatusRelacionamentoValor = lblStatusRelacionamentoValor;
	}

	public Label getLblAniversarioValor() {
		return lblAniversarioValor;
	}

	public void setLblAniversarioValor(Label lblAniversarioValor) {
		this.lblAniversarioValor = lblAniversarioValor;
	}

	public Label getLblGeneroValor() {
		return lblGeneroValor;
	}

	public void setLblGeneroValor(Label lblGeneroValor) {
		this.lblGeneroValor = lblGeneroValor;
	}
	
	public Label getLblLocalidadeValor() {
		return lblLocalidadeValor;
	}

	public void setLblLocalidadeValor(Label lblLocalidadeValor) {
		this.lblLocalidadeValor = lblLocalidadeValor;
	}
	
	
	

}
