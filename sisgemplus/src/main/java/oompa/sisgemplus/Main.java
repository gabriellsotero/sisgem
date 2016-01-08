package oompa.sisgemplus;


import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import oompa.sisgemplus.controllers.MainController;
import oompa.sisgemplus.utils.Navigator;

/**
 * Main application class.
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
    	
		primaryStage.setTitle("SisGEM");
	    primaryStage.getIcons().add(new Image("http://files.softicons.com/download/toolbar-icons/glyphish-icons-by-joseph-wain/png/32x32/120-headphones.png"));

        primaryStage.setScene(
            createScene(
                loadMainPane()
            )
        );
	    primaryStage.setMinHeight(480.0);
	    primaryStage.setMinWidth(640.0);
	    
	    primaryStage.show();

	    primaryStage.setMaximized(true);

    }

    /**
     * Loads the main fxml layout.
     * Sets up the vista switching VistaNavigator.
     * Loads the first vista into the fxml layout.
     *
     * @return the loaded pane.
     * @throws IOException if the pane could not be loaded.
     */
    private Pane loadMainPane() throws IOException {
    	
    	URL url = getClass().getResource("main.fxml");
    	
    	FXMLLoader loader = new FXMLLoader(url);

    	Pane mainPane = (Pane) loader.load();
        
        MainController mainController = loader.getController();

        Navigator.setMainController(mainController);

        Navigator.loadVista("login.fxml");

        return mainPane ;
    }

    /**
     * Creates the main application scene.
     *
     * @param mainPane the main application layout.
     *
     * @return the created scene.
     */
    private Scene createScene(Pane mainPane) {
        Scene scene = new Scene(
            mainPane
        );

        return scene;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
