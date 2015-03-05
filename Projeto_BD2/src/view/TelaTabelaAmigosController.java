package view;

import dao.AmigoDAO;
import model.Amigo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TelaTabelaAmigosController {
	
	private TelaIncialController controller;
	
	@FXML
	private TableView<Amigo> amigosTabela;
	
	@FXML
	private TableColumn<Amigo, String> idColuna;
	
	@FXML
	private TableColumn<Amigo, String> idPefilColuna;
	
	@FXML
	private TableColumn<Amigo, String> nomeColuna;
	
	private ObservableList<Amigo> amigos;
	
	public TelaTabelaAmigosController() {
		amigos = FXCollections.observableArrayList();
		
		
	}
	
	@FXML
	private void initialize(){
		idColuna.setCellValueFactory(new PropertyValueFactory<Amigo, String>("id"));
		idPefilColuna.setCellValueFactory(new PropertyValueFactory<Amigo, String>("perfilId"));
		nomeColuna.setCellValueFactory(new PropertyValueFactory<Amigo, String>("nome"));
		AmigoDAO aDao = new AmigoDAO();
		amigos = aDao.buscaAmigos();
		amigosTabela.setItems(amigos);
		
	}

	public TelaIncialController getController() {
		return controller;
	}

	public void setController(TelaIncialController controller) {
		this.controller = controller;
	}
	
	
	
	

}
