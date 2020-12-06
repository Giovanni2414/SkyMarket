
package GUI;

import java.io.FileInputStream;
import java.io.IOException;

import Model.SkyMarket;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application{

	private SkyMarket skymarket;
	private SkyMarketGUI skymarketGUI;
	
	public Main() {
		skymarket = new SkyMarket();
		skymarketGUI = new SkyMarketGUI(skymarket);
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main-panel.fxml")); 
		fxmlLoader.setController(skymarketGUI);
		Parent root = fxmlLoader.load();
		primaryStage.getIcons().add(new Image(new FileInputStream("data/picturesApp/skymarket-icon.png")));
		skymarketGUI.loadProgressBar();
	

		
		
		Scene scene = new Scene(root,600,450);
		
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("SkyMarket");
		primaryStage.show();
		
	}

}
