package application;
	
import java.io.IOException;

import dao.ConexaoDAO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	private Stage primaryStage;
	private BorderPane rootLayout;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			this.primaryStage = primaryStage;
			this.primaryStage.setTitle("Facebook FQL FX 1.0");
			initRootLayout();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void initRootLayout(){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/view/TelaInicial.fxml"));
			rootLayout = (BorderPane) loader.load();
			
			Scene scene = new Scene(rootLayout);
			scene.getStylesheets().add("/application/application.css");
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public static void main(String[] args) {
		new ConexaoDAO();
		launch(args);
	}
}
