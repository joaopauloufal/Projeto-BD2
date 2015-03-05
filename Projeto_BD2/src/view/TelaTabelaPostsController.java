package view;

import dao.PostDAO;
import model.Post;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TelaTabelaPostsController {
	
	private TelaIncialController controller;
	
	@FXML
	private TableView<Post> tabelaPosts;
	
	@FXML
	private TableColumn<Post, String> idPostColuna;
	
	@FXML
	private TableColumn<Post, String> perfilIdColuna;
	
	@FXML
	private TableColumn<Post, String> corpoColuna;
	
	@FXML
	private ObservableList<Post> posts;
	
	public TelaTabelaPostsController() {
		posts = FXCollections.observableArrayList();
		
		
		
		
	}
	
	@FXML
	private void initialize() {
		
		idPostColuna.setCellValueFactory(new PropertyValueFactory<Post, String>("postId"));
		perfilIdColuna.setCellValueFactory(new PropertyValueFactory<Post, String>("perfilId"));
		corpoColuna.setCellValueFactory(new PropertyValueFactory<Post, String>("corpo"));
		PostDAO pDao = new PostDAO();
		posts = pDao.buscaPosts();
		tabelaPosts.setItems(posts);

	}

	public TelaIncialController getController() {
		return controller;
	}

	public void setController(TelaIncialController controller) {
		this.controller = controller;
	}
	
	

}
