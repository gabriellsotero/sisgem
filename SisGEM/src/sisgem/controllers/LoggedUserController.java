package sisgem.controllers;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import sisgem.Login;
import sisgem.Main;
import sisgem.db.EventDAO;
import sisgem.db.TaskDAO;
import sisgem.model.Event;
import sisgem.model.Task;

public class LoggedUserController implements Initializable  {
	
	@FXML
    private TabPane tabpane_main;

    @FXML
    private Tab tab_backlog;

    @FXML
    private VBox vbox_backlog;

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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
				
		tableview_backlog.setItems(getTasks());
		
		tablecolumn_event.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Task, String>, ObservableValue<String>>() {
		    @Override
		    public ObservableValue<String> call(TableColumn.CellDataFeatures<Task, String> t) {
		        EventDAO eventDAO = new EventDAO();
		        String eventName = eventDAO.findNameByCode(t.getValue().getEventCode());
		        return new SimpleStringProperty(eventName);
		    }
		});
		tablecolumn_description.setCellValueFactory(cellData -> cellData.getValue().descriptionProperty());
		tablecolumn_targetdate.setCellValueFactory(cellData -> cellData.getValue().targetDateProperty());
		tablecolumn_status.setCellValueFactory(cellData -> cellData.getValue().statusTextProperty());
		tablecolumn_type.setCellValueFactory(cellData -> cellData.getValue().typeTextProperty());
		
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
	
	private ObservableList<Task> getTasks()
	{
		TaskDAO taskDAO = new TaskDAO();
		ArrayList <Task> arrayListTasks = (ArrayList<Task>) taskDAO.listAllPendingByAccUser(Login.getLoggedUser().getCode());
		ObservableList<Task> observableListTasks = FXCollections.observableArrayList(arrayListTasks);
		return observableListTasks;
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

}
