package oompa.sisgemplus.controllers;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import oompa.sisgemplus.Login;
import oompa.sisgemplus.Main;
import oompa.sisgemplus.db.EventDAO;
import oompa.sisgemplus.db.TaskDAO;
import oompa.sisgemplus.model.Event;
import oompa.sisgemplus.model.Task;
import oompa.sisgemplus.model.enums.TaskTypes;

public class ConceptsListController implements Initializable  {
	
	@FXML
    private VBox vbox_backlog;
    
    @FXML
    private HBox hbox_filter;
    
    @FXML
    private Label label_type;    

    @FXML
    private ComboBox<TaskTypes> combobox_type;

    @FXML
    private Label label_event;

    @FXML
    private ComboBox<Event> combobox_event; 

    @FXML
    private TableView<Task> tableview_backlog;

    @FXML
    private TableColumn<Task, String> tablecolumn_description;

    @FXML
    private TableColumn<Task, LocalDate> tablecolumn_targetdate;

    @FXML
    private TableColumn<Task, String> tablecolumn_status;

    @FXML
    private Tab tab_alerts;

	@FXML 
	private TableColumn<Task, String> tablecolumn_event;

	@FXML 
	private TableColumn<Task, String> tablecolumn_type;
	
	private ObservableList<Event> eventsList;
	
	private ObservableList<TaskTypes> typesList;
	
	private ObservableList<Task> tasksList;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		this.getTasks();
		
		combobox_event.setItems(eventsList);
		combobox_type.setItems(typesList);
		
		tablecolumn_event.setCellValueFactory(cellData -> cellData.getValue().eventNameProperty());
		tablecolumn_description.setCellValueFactory(cellData -> cellData.getValue().descriptionProperty());
		tablecolumn_targetdate.setCellValueFactory(cellData -> cellData.getValue().targetDateProperty());
		tablecolumn_status.setCellValueFactory(cellData -> cellData.getValue().statusTextProperty());
		tablecolumn_type.setCellValueFactory(cellData -> cellData.getValue().typeTextProperty());
		
		FilteredList<Task> tasksListFiltered = new FilteredList<Task>(tasksList, p -> true);
		
		combobox_event.valueProperty().addListener((observable, oldValue, newValue) ->
		{
			tasksListFiltered.setPredicate(task -> {
                if (combobox_event.getValue() == null)
                {
                	if (combobox_type.getValue() == null) 
	                    return true;
                   	else
                		return task.getType().equals(combobox_type.getValue());            
                }
                else
                {
                	if (combobox_event.getValue() == null)
                		return true;
                	else
                		return task.getEventName().equals(combobox_event.getValue().getName());
                }
			});
		}
		);
		
		combobox_type.valueProperty().addListener((observable, oldValue, newValue) ->
		{
			tasksListFiltered.setPredicate(task -> {
                if (combobox_event.getValue() == null)
                {
                	if (combobox_type.getValue() == null) 
	                    return true;
                   	else
                		return task.getType().equals(combobox_type.getValue());            
                }
                else
                {
                	if (combobox_event.getValue() == null)
                		return true;
                	else
                		return task.getEventName().equals(combobox_event.getValue().getName());
                }
			});
		}
		);
		
		tableview_backlog.setItems(tasksListFiltered);
		
		DateTimeFormatter myDateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		/* Conditional formatting of target date cell
		 * 
		 * red: task is late
		 * yellow: task is due today
		 * 
		 */
		tablecolumn_targetdate.setCellFactory(column -> {
		    return new TableCell<Task, LocalDate>() {
		        @Override
		        protected void updateItem(LocalDate item, boolean empty) {
		            super.updateItem(item, empty);
		            if (item == null || empty) 
		            {
		            	setText("");
		            } 
		            else 
		            {
		                // Format date.
		                setText(myDateFormatter.format(item));
		                
	                	this.getStyleClass().remove("todayTask");
	                	this.getStyleClass().remove("lateTask");
		                
		                if (item.isBefore(LocalDate.now())) 
		                {
			                this.getStyleClass().add("lateTask");
	                    }
		                else if (item.isEqual(LocalDate.now()))
		                {
		                	this.getStyleClass().add("todayTask");
		                }
		            }
		        }
		    };
		});
		
		
	}	
	
	private void getTasks()
	{
		TaskDAO taskDAO = new TaskDAO();
		EventDAO eventDAO = new EventDAO();
		ArrayList <Task> arrayListTasks = (ArrayList<Task>) taskDAO.listAllPendingByAccUser(Login.getLoggedUser().getCode());
		tasksList = FXCollections.observableArrayList(arrayListTasks);

		typesList = FXCollections.observableArrayList(taskDAO.listAllPendingTypesByAccUser(Login.getLoggedUser().getCode()));
		
		ArrayList<Integer> eventCodesArray = new ArrayList<Integer>();
		
		for (Task t: arrayListTasks)
			eventCodesArray.add(t.getEventCode());
		
		eventCodesArray = new ArrayList<Integer>(new HashSet<Integer>(eventCodesArray));
		
		ArrayList <Event> eventsArray = new ArrayList<Event>();
		
		for (int i: eventCodesArray)
			eventsArray.add(eventDAO.findByCode(i));
		
		eventsList = FXCollections.observableArrayList(eventsArray);

	}

	@FXML public void openTaskWindow(ActionEvent event)
	{
		Task task = tableview_backlog.getSelectionModel().getSelectedItem();

		if (task != null)
		{
			Parent root;
			
			try
			{
					FXMLLoader loader = new FXMLLoader(Main.class.getResource("task.fxml"));
		            root = loader.load();

		            Stage stage = new Stage();
	
		            stage.setScene(new Scene(root, 450, 450));
		            stage.setResizable(false);
					loader.<TaskController>getController().setTask(task);
					
					EventDAO eventDAO = new EventDAO();
					Event _event = eventDAO.findByCode(task.getEventCode());
					
		            stage.setTitle("Tarefa " + task.getCode() + " | Evento: " + _event.getName());
		            
		            stage.show();
		    }
			catch (Exception e) 
			{
				e.printStackTrace();
	        }
		}	
		
	}
	
    @FXML
    void cleanFilters(ActionEvent event) 
    {
    	//TODO
    }

}
