package sisgem.controller.fx;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/** JavaFX fxml controller for SisGEM. */
public class MainController implements Initializable {

    @FXML // fx:id="anchorpane_mainpane"
    private AnchorPane anchorpane_mainpane; // Value injected by FXMLLoader

    @FXML // fx:id="borderpane_footer"
    private BorderPane borderpane_footer; // Value injected by FXMLLoader

    @FXML // fx:id="label_userdata"
    private Label label_userdata; // Value injected by FXMLLoader

    @FXML // fx:id="label_version"
    private Label label_version; // Value injected by FXMLLoader

    @FXML // fx:id="vbox_main"
    private VBox vbox_main; // Value injected by FXMLLoader

    @FXML // fx:id="menubar_main"
    private MenuBar menubar_main; // Value injected by FXMLLoader

    @FXML // fx:id="menu_home"
    private Menu menu_home; // Value injected by FXMLLoader

    @FXML // fx:id="menu_concepts"
    private Menu menu_concepts; // Value injected by FXMLLoader

    @FXML // fx:id="menuitem_new_concept"
    private MenuItem menuitem_new_concept; // Value injected by FXMLLoader

    @FXML // fx:id="menuitem_list_concepts"
    private MenuItem menuitem_list_concepts; // Value injected by FXMLLoader

    @FXML // fx:id="menu_events"
    private Menu menu_events; // Value injected by FXMLLoader

    @FXML // fx:id="menuitem_list_events"
    private MenuItem menuitem_list_events; // Value injected by FXMLLoader

    @FXML // fx:id="menu_register"
    private Menu menu_register; // Value injected by FXMLLoader

    @FXML // fx:id="menuitem_venues"
    private MenuItem menuitem_venues; // Value injected by FXMLLoader

    @FXML // fx:id="menuitem_artists"
    private MenuItem menuitem_artists; // Value injected by FXMLLoader

    @FXML // fx:id="menuitem_positions"
    private MenuItem menuitem_positions; // Value injected by FXMLLoader

    @FXML // fx:id="menuitem_providers"
    private MenuItem menuitem_providers; // Value injected by FXMLLoader

    @FXML // fx:id="menuitem_materials"
    private MenuItem menuitem_materials; // Value injected by FXMLLoader

    @FXML // fx:id="menuitem_users"
    private MenuItem menuitem_users; // Value injected by FXMLLoader

    @FXML // fx:id="menu_exit"
    private Menu menu_exit; // Value injected by FXMLLoader

    @FXML // fx:id="borderpane_title"
    private BorderPane borderpane_title; // Value injected by FXMLLoader

    @FXML // fx:id="text_title"
    private Text text_title; // Value injected by FXMLLoader

	@Override // This method is called by the FXMLLoader when initialization is complete
	public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
	
		menu_home.showingProperty().addListener(new ChangeListener<Boolean>() {
		     @Override
		     public void changed(ObservableValue<? extends Boolean> observableValue, Boolean oldValue, Boolean newValue) 
		     {
		          if(newValue.booleanValue())
		               System.out.println("Showing|Clicked");
		          else
		               System.out.println("Not showing|Clicked again");
		     }
		               
		});
	  
	}
	
}