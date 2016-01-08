/**
 * Sample Skeleton for 'login.fxml' Controller Class
 */

package oompa.sisgemplus.controllers;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import oompa.sisgemplus.Login;
import oompa.sisgemplus.db.ArtistDAO;
import oompa.sisgemplus.db.ConceptDAO;
import oompa.sisgemplus.db.MaterialDAO;
import oompa.sisgemplus.db.ProviderEventRoleDAO;
import oompa.sisgemplus.db.VenueDAO;
import oompa.sisgemplus.model.Artist;
import oompa.sisgemplus.model.Concept;
import oompa.sisgemplus.model.Material;
import oompa.sisgemplus.model.MaterialConcept;
import oompa.sisgemplus.model.ProviderEventRole;
import oompa.sisgemplus.model.ProviderEventRoleConcept;
import oompa.sisgemplus.model.Venue;
import oompa.sisgemplus.model.enums.ConceptStatus;
import oompa.sisgemplus.utils.Navigator;

public class CreateConceptController implements Initializable {

    @FXML
    private TabPane tabpane_main;

    @FXML
    private Tab tab_backlog;

    @FXML
    private Label label_name;

    @FXML
    private TextField textfield_name;

    @FXML
    private Label label_description;

    @FXML
    private TextArea textarea_description;

    @FXML
    private Label label_comments;

    @FXML
    private TextArea textarea_comments;

    @FXML
    private Tab tab_venues;

    @FXML
    private ListView<Venue> listview_venues_available;

    @FXML
    private Button button_venues_right;

    @FXML
    private Button button_venues_left;

    @FXML
    private ListView<Venue> listview_venues_selected;

    @FXML
    private Label label_venues_available;

    @FXML
    private Label label_venues_selected;

    @FXML
    private Tab tab_materials;

    @FXML
    private ListView<Material> listview_materials_available;

    @FXML
    private Button button_materials_right;

    @FXML
    private Button button_materials_left;

    @FXML
    private ListView<MaterialConcept> listview_materials_selected;

    @FXML
    private Label label_materials_available;

    @FXML
    private Label label_materials_selected;
    
    @FXML
    private Label label_materials_filter;

    @FXML
    private TextField textfield_materials_filter;

    @FXML
    private Tab tab_artists;

    @FXML
    private ListView<Artist> listview_artists_available;

    @FXML
    private Button button_artists_right;

    @FXML
    private Button button_artists_left;

    @FXML
    private ListView<Artist> listview_artists_selected;

    @FXML
    private Label label_artists_available;

    @FXML
    private Label label_artists_selected;

    @FXML
    private Label label_artists_filter;
    
    @FXML
    private TextField textfield_artists_filter;
    
    @FXML
    private Tab tab_roles;

    @FXML
    private ListView<ProviderEventRole> listview_roles_available;

    @FXML
    private Button listview_roles_right;

    @FXML
    private Button listview_roles_left;

    @FXML
    private ListView<ProviderEventRole> listview_roles_selected;
    
    @FXML
    private Label label_roles_filter;

    @FXML
    private TextField textfield_roles_filter;

    @FXML
    private Label label_roles_available;

    @FXML
    private Label label_roles_selected;

    @FXML
    private Label label_venues_filter;

    @FXML
    private TextField textfield_venues_filter;
    
    @FXML
    private Button button_create; 
    
    ArrayList<Venue> venuesArrayList;
    ArrayList<Artist> artistsArrayList;
    ArrayList<Material> materialsArrayList;
    ArrayList<ProviderEventRole> eventRolesArrayList;
    
    ObservableList<Venue> venuesList;
	ObservableList<Artist> artistsList;
	ObservableList<Material> materialsList;
	ObservableList<ProviderEventRole> eventRolesList;
	
    FilteredList<Venue> venuesListFiltered;
    FilteredList<Artist> artistsListFiltered;    
    FilteredList<Material> materialsListFiltered;
    FilteredList<ProviderEventRole> eventRolesListFiltered;
    
    ArrayList<Venue> selectedVenuesArrayList;
    ArrayList<Artist> selectedArtistsArrayList;
    ArrayList<MaterialConcept> selectedMaterialsArrayList;
    ArrayList<ProviderEventRoleConcept> selectedEventRolesArrayList;
    
	ObservableList<Venue> selectedVenuesList;
	ObservableList<Artist> selectedArtistsList;
	ObservableList<MaterialConcept> selectedMaterialsList;
	ObservableList<ProviderEventRoleConcept> selectedEventRolesList;
	
	@Override 
	public void initialize(URL fxmlFileLocation, ResourceBundle resources) 
	{		
		VenueDAO venueDAO = new VenueDAO();
		ArtistDAO artistDAO = new ArtistDAO();
		MaterialDAO materialDAO = new MaterialDAO();
		ProviderEventRoleDAO eventRoleDAO = new ProviderEventRoleDAO();
		
		venuesArrayList = (ArrayList<Venue>) venueDAO.listAll();
		artistsArrayList = (ArrayList<Artist>) artistDAO.listAll();
		materialsArrayList = (ArrayList<Material>) materialDAO.listAll();
		eventRolesArrayList = (ArrayList<ProviderEventRole>) eventRoleDAO.listAll();
		
		venuesList = FXCollections.observableArrayList(venueDAO.listAll());
		artistsList = FXCollections.observableArrayList(artistDAO.listAll());
		materialsList = FXCollections.observableArrayList(materialDAO.listAll());
		eventRolesList = FXCollections.observableArrayList(eventRoleDAO.listAll());
		
		venuesListFiltered = new FilteredList<Venue>(venuesList, p -> true);
		artistsListFiltered = new FilteredList<Artist>(artistsList, p -> true); 
		eventRolesListFiltered = new FilteredList<ProviderEventRole>(eventRolesList, p -> true);
		
		selectedMaterialsArrayList = new ArrayList<MaterialConcept>();
		
		selectedVenuesList = FXCollections.observableArrayList();
		selectedArtistsList = FXCollections.observableArrayList();
		selectedMaterialsList = FXCollections.observableArrayList();
		selectedEventRolesList = FXCollections.observableArrayList();
		
		textfield_venues_filter.textProperty().addListener((observable, oldValue, newValue) -> {
			
			venuesListFiltered.setPredicate(venue -> {

				if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (venue.getName().toLowerCase().contains(lowerCaseFilter)) 
                {
                    return true;
                }
                return false;
                
            });		
		});
		
		textfield_artists_filter.textProperty().addListener((observable, oldValue, newValue) -> {
			
			artistsListFiltered.setPredicate(artist -> {

				if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (artist.getStageName().toLowerCase().contains(lowerCaseFilter)) 
                {
                    return true;
                }
                return false; 
                
            });		
		});
		
		textfield_roles_filter.textProperty().addListener((observable, oldValue, newValue) -> {
			
			eventRolesListFiltered.setPredicate(eventrole -> {

				if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (eventrole.getName().toLowerCase().contains(lowerCaseFilter)) 
                {
                    return true;
                }
                return false; 
                
            });		
		});
		
		treatMaterialsList();
		
		listview_venues_available.setItems(venuesListFiltered);
		listview_artists_available.setItems(artistsListFiltered);
		listview_roles_available.setItems(eventRolesListFiltered);
	}
	
	private void treatMaterialsList()
    {
		materialsListFiltered = new FilteredList<Material>(materialsList, p -> true);
		
		textfield_materials_filter.textProperty().addListener((observable, oldValue, newValue) -> {
			
			materialsListFiltered.setPredicate(material -> {

				if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (material.getName().toLowerCase().contains(lowerCaseFilter)) 
                {
                    return true;
                }
                return false; 
                
            });		
		});
		
		System.out.println(materialsListFiltered.size());
		listview_materials_available.setItems(materialsListFiltered);
	}
    
    @FXML
    void selectMaterial(ActionEvent event)
    {
    	Material selected = null;
    	selected = listview_materials_available.getSelectionModel().getSelectedItem();
    	System.out.println(selected.toString());
    	MaterialConcept materialConcept = new MaterialConcept(selected, 0);

    	int qty = openMaterialDialog(false, selected.getMeasureUnit());
    	materialConcept.setQty(qty);

    	try
    	{
    		materialsList.remove(selected);
    	}
    	catch (Exception e)
    	{
    		System.out.println("EXCECAO");
    	}
    	treatMaterialsList();
    	selectedMaterialsArrayList.add(materialConcept);
    	selectedMaterialsList = FXCollections.observableArrayList(selectedMaterialsArrayList);
    	listview_materials_selected.setItems(selectedMaterialsList);

    }

    private int openMaterialDialog(boolean error, String measureUnit)
    {
    	
    	TextInputDialog dialog = new TextInputDialog();
    
    	DialogPane dialogPane = dialog.getDialogPane();
    	
    	dialogPane.getStylesheets().add(getClass().getResource("dialogs.css").toExternalForm());
    	
    	dialog.setTitle("Insira a quantidade do material");
    	dialog.setHeaderText(null);
    	dialog.setContentText("Quantidade (em " + measureUnit + "):");
    	if (error)
    		dialog.setContentText("Quantidade (em " + measureUnit + "): " + "\nAtenção: apenas valores numéricos");

    	Optional<String> result = dialog.showAndWait();

    	if (result.isPresent())
    	{
    		try
    		{
    			int qty = Integer.parseInt(result.get());
    			return qty;
    		}
    		catch (NumberFormatException e)
    		{
    			return openMaterialDialog(true, measureUnit);
    		}
    	}
    	else
    		return openMaterialDialog(true, measureUnit);
    }
    
    @FXML
    void deselectMaterial(ActionEvent event) 
    {
    	MaterialConcept selected = null;
    	selected = listview_materials_selected.getSelectionModel().getSelectedItem();
    	materialsList.add(selected.getMaterial());
    	treatMaterialsList();
    	selectedMaterialsArrayList.remove(selected);
    	selectedMaterialsList = FXCollections.observableArrayList(selectedMaterialsArrayList);
    	listview_materials_selected.setItems(selectedMaterialsList);
    }

    @FXML
    void selectArtist(ActionEvent event) 
    {

    }
    
    @FXML
    void deselectArtist(ActionEvent event) 
    {

    }
    
    @FXML
    void selectRole(ActionEvent event) 
    {

    }

    @FXML
    void deselectRole(ActionEvent event) 
    {

    }
    
    @FXML
    void selectVenue(ActionEvent event)
    {

    }

    @FXML
    void deselectVenue(ActionEvent event) 
    {

    }	
    
    @FXML
    void createConcept(ActionEvent event)
    {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.getDialogPane().getButtonTypes().remove(0);
    	alert.getDialogPane().getButtonTypes().add(ButtonType.YES);
    	alert.getDialogPane().getButtonTypes().add(ButtonType.NO);
    	
    	alert.initOwner(button_create.getScene().getWindow());
    	
    	alert.setTitle("Confirmação");
    	alert.setHeaderText(null);
    	alert.setContentText("Deseja confirmar a criação do conceito " + textfield_name.getText() + "?");

    	DialogPane dialogPane = alert.getDialogPane();
    	
    	dialogPane.getStylesheets().add(getClass().getResource("dialogs.css").toExternalForm());
    	
    	Optional<ButtonType> result = alert.showAndWait();
    	
    	if (result.get() == ButtonType.YES)
    	{
        	
        	ConceptDAO conceptDAO = new ConceptDAO();
        	
        	Concept c = new Concept(
        					-1,
        					textfield_name.getText(),
        					textarea_description.getText(),
        					textarea_comments.getText(),
        					LocalDate.now(),
        					ConceptStatus.PENDENTE,
        					"",
        					Login.getLoggedUser().getCode(),
        					-1
        					);

        	conceptDAO.create(c);
        	
        	Navigator.loadVista("conceptlist.fxml");
    	} 
    	
    	else if (result.get() == ButtonType.NO) 
    	{
    	    alert.close();
    	}

    }
}