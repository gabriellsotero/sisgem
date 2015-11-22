package sisgem;

import java.io.IOException;
import java.net.URL;

import sisgem.SisGEMApplication;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SisGEMApplication extends Application  {
	
	private Stage primaryStage;

	@Override
	public void start(Stage primaryStage) throws IOException {
		primaryStage.setTitle("SisGEM");
	    primaryStage.getIcons().add(new Image("http://files.softicons.com/download/application-icons/pixelophilia-icons-by-omercetin/png/32/apple-green.png"));
	
	    BorderPane layout = FXMLLoader.load(
	    	      new URL(SisGEMApplication.class.getResource("view/Main.fxml").toExternalForm())
	    	    );
	    
	    primaryStage.setScene(new Scene(layout));
	    primaryStage.setMinWidth(640.0);
	    primaryStage.setMinHeight(480.0);
	    primaryStage.show();
	    
	    
	}

	public static void main(String[] args) {
		launch(args);
	}
}
