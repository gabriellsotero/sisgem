package oompa.sisgemplus.controllers;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import oompa.sisgemplus.Main;
import oompa.sisgemplus.db.EventDAO;
import oompa.sisgemplus.db.TaskDAO;
import oompa.sisgemplus.model.Event;
import oompa.sisgemplus.model.Task;

public class PendingApprovalTasksController implements Initializable  {
	
	@FXML
    private VBox vbox_backlog;
    
    @FXML
    private TableView<Task> tableview_backlog;

    @FXML
    private TableColumn<Task, String> tablecolumn_description;

    @FXML
    private TableColumn<Task, LocalDate> tablecolumn_completeddate;

    @FXML
    private TableColumn<Task, String> tablecolumn_accountable;

    @FXML
    private Tab tab_alerts;

	@FXML 
	private TableColumn<Task, String> tablecolumn_event;

	@FXML 
	private TableColumn<Task, String> tablecolumn_type;
	
	private ObservableList<Task> tasksList;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		this.getTasks();
		
		tablecolumn_event.setCellValueFactory(cellData -> cellData.getValue().eventNameProperty());
		tablecolumn_description.setCellValueFactory(cellData -> cellData.getValue().descriptionProperty());
		tablecolumn_completeddate.setCellValueFactory(cellData -> cellData.getValue().completedDateProperty());
		tablecolumn_accountable.setCellValueFactory(cellData -> cellData.getValue().accountableLoginProperty());
		tablecolumn_type.setCellValueFactory(cellData -> cellData.getValue().typeTextProperty());
	
		tableview_backlog.setItems(tasksList);
		
		DateTimeFormatter myDateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		/* Conditional formatting of target date cell
		 * 
		 * red: task is late
		 * yellow: task is due today
		 * 
		 */
		tablecolumn_completeddate.setCellFactory(column -> {
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
		            }
		        }
		    };
		});
		
		
	}	
	
	private void getTasks()
	{
		TaskDAO taskDAO = new TaskDAO();
		ArrayList <Task> arrayListTasks = (ArrayList<Task>) taskDAO.listAllPendingApproval();
		tasksList = FXCollections.observableArrayList(arrayListTasks);
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
