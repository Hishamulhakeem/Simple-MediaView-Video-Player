package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage stage) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene.fxml"));
			Parent root = loader.load();
			Controller controller = loader.getController();
			Scene scene = new Scene(root);
			
			scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

				@Override
				public void handle(KeyEvent event) {
					
					switch(event.getCode()) {
					case ENTER:controller.playMedia();
					break;
					case CONTROL:controller.pauseMedia();;
					break;
					case ALT:controller.restMedia();
					break;
					
					default:break;					
					}
				}
				
			});
			
			stage.setTitle("Mediaview");
			stage.setScene(scene);
			stage.show();		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

