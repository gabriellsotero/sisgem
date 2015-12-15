package sisgem.controllers;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import sisgem.model.User;
import sisgem.model.enums.UserProfiles;
import sisgem.utils.Navigator;

/** JavaFX fxml controller for SisGEM. */
public class MainController implements Initializable {

	@FXML
	private BorderPane borderpane_root;

	@FXML
	private BorderPane borderpane_footer;

	@FXML
	private Label label_userdata;

	@FXML
	private Label label_version;

	@FXML
	private VBox vbox_header;

	@FXML
	private MenuBar menubar_main;

	@FXML
	private Menu menu_home;

	@FXML
	private Menu menu_concepts;

	@FXML
	private MenuItem menuitem_new_concept;

	@FXML
	private MenuItem menuitem_list_concepts;

	@FXML
	private Menu menu_events;

	@FXML
	private MenuItem menuitem_list_events;

	@FXML
	private Menu menu_tasks;

	@FXML
	private MenuItem menu_pending_tasks;

	@FXML
	private MenuItem menu_pending_approval_tasks;

	@FXML
	private MenuItem menu_alerts;

	@FXML
	private Menu menu_register;

	@FXML
	private MenuItem menuitem_venues;

	@FXML
	private MenuItem menuitem_artists;

	@FXML
	private MenuItem menuitem_positions;

	@FXML
	private MenuItem menuitem_providers;

	@FXML
	private MenuItem menuitem_materials;

	@FXML
	private MenuItem menuitem_users;

	@FXML
	private Menu menu_system;

	@FXML
	private MenuItem menuitem_about;

	@FXML
	private MenuItem menuitem_exit;

	@FXML
	private BorderPane borderpane_title;

	@FXML
	private Text text_title;

	@FXML
	private AnchorPane anchorpane_main;


	@Override // This method is called by the FXMLLoader when initialization is complete
	public void initialize(URL fxmlFileLocation, ResourceBundle resources) {

	}

	@FXML
	void dosomething(ActionEvent event) {
		Navigator.loadVista("registeruser.fxml");
	}		

	/**
	 * Replaces the vista displayed in the vista holder with a new vista.
	 *
	 * @param node the vista node to be swapped in.
	 */
	public void setVista(Pane pane) {
		borderpane_root.setCenter(pane);
	}

	public void setMenuVisibilityAndFooter(User user)
	{
		UserProfiles profile = user.getProfile();

		menu_home.setVisible(true);
		menu_system.setVisible(true);
		menuitem_about.setVisible(true);
		menuitem_exit.setVisible(true);
		menu_concepts.setVisible(true);
		menuitem_list_concepts.setVisible(true);
		menu_events.setVisible(true);
		menuitem_list_events.setVisible(true);
		menu_tasks.setVisible(true);
		menu_pending_tasks.setVisible(true);
		menu_alerts.setVisible(true);

		switch (profile)
		{
		case ADMINISTRADOR:
			menuitem_users.setVisible(true);
		case PRODUTOR_DE_EVENTOS:	     	 	
			menuitem_new_concept.setVisible(true);
			menu_pending_approval_tasks.setVisible(true);
			menu_register.setVisible(true);
			menuitem_venues.setVisible(true);
			menuitem_artists.setVisible(true);
			menuitem_positions.setVisible(true);
			menuitem_providers.setVisible(true);
			menuitem_materials.setVisible(true);
			break;
		case AN_PREST_DE_SERVICO:
			menu_register.setVisible(true);	
			menuitem_positions.setVisible(true);
			menuitem_providers.setVisible(true);
			break;
		case AN_REC_ARTISTICOS:
			menu_register.setVisible(true);	
			menuitem_artists.setVisible(true);
			break;
		case COMPRADOR:
			menu_register.setVisible(true);
			menuitem_materials.setVisible(true);
			break;
		case AN_MARKETING_DIGITAL:
			break;
		default:
			break;
		}

		label_userdata.setText("Login: " + user.getLogin() + " | " + "Perfil: " + user.getProfileText());
		label_userdata.setVisible(true);
	}

	@FXML
	void aboutSystem(ActionEvent event) 
	{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Sobre o SisGEM");
		alert.setHeaderText("Sobre");
		alert.setContentText("O sistema SisGEM é um sistema para a gestão de eventos musicais desenvolvido por Gabriel Loyola Sotero "
				+ "para a disciplina Projeto Final II no semestre de 2015.2, sob a orientação do prof. Edmundo Torreão.");

		alert.showAndWait();
	}

	@FXML
	void exitSystem(ActionEvent event) 
	{
		System.exit(0);

	}
}