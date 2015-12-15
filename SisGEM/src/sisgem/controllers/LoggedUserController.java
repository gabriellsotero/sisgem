package sisgem.controllers;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import sisgem.Login;
import sisgem.db.TaskDAO;
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
    private TableColumn<Task, Boolean> tablecolumn_late;

    @FXML
    private Tab tab_alerts;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		tableview_backlog.setItems(getTasks());
		
		tablecolumn_description.setCellValueFactory(cellData -> cellData.getValue().descriptionProperty());
		tablecolumn_targetdate.setCellValueFactory(cellData -> cellData.getValue().targetDateProperty());
		tablecolumn_status.setCellValueFactory(cellData -> cellData.getValue().statusTextProperty());
		tablecolumn_late.setCellValueFactory(cellData -> cellData.getValue().lateProperty());
		
	}
	
	private ObservableList<Task> getTasks()
	{
		TaskDAO taskDAO = new TaskDAO();
		ArrayList <Task> arrayListTasks = (ArrayList<Task>) taskDAO.listAllPendingByAccUser(Login.getLoggedUser());
		ObservableList<Task> observableListTasks = FXCollections.observableArrayList(arrayListTasks);
		return observableListTasks;
	}

}
