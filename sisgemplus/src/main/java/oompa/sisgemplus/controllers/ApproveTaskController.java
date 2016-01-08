package oompa.sisgemplus.controllers;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import oompa.sisgemplus.Login;
import oompa.sisgemplus.db.TaskCommentDAO;
import oompa.sisgemplus.db.TaskDAO;
import oompa.sisgemplus.model.Task;
import oompa.sisgemplus.model.TaskComment;

public class ApproveTaskController implements Initializable 
{
    @FXML
    private Label label_title;

    @FXML
    private Label label_message;

    @FXML
    private Label label_value;

    @FXML
    private HBox hbox_value;

    @FXML
    private Label label_rs;

    @FXML
    private TextField textfield_value;

    @FXML
    private Label label_addcomment;

    @FXML
    private TextField textfield_comment;

    @FXML
    private Button button_cancel;

    @FXML
    private Button button_confirm;

    @FXML
    private Label label_statusbar;
    
    private Task task;
    
    private String taskDescription;
    
    private String taskEvent;
    
	public void setTask(Task task)
	{
		this.task = task;
		this.taskDescription = task.getDescription();
		this.taskEvent = task.getEventName();
		
		fillInfo();
	}
	
	private void fillInfo()
	{		
		label_message.setText("Tarefa: " + taskDescription + " | Evento: " + taskEvent);
	}	

    @FXML
    private void cancelApproval(ActionEvent event) 
    {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.getDialogPane().getButtonTypes().remove(0);
    	alert.getDialogPane().getButtonTypes().add(ButtonType.YES);
    	alert.getDialogPane().getButtonTypes().add(ButtonType.NO);
    	
    	alert.initOwner(button_cancel.getScene().getWindow());
    	
    	alert.setTitle("Confirmação");
    	alert.setHeaderText(null);
    	alert.setContentText("Deseja cancelar a operação de aprovar tarefa?");

    	DialogPane dialogPane = alert.getDialogPane();
    	
    	dialogPane.getStylesheets().add(getClass().getResource("dialogs.css").toExternalForm());
    	
    	Optional<ButtonType> result = alert.showAndWait();
    	
    	if (result.get() == ButtonType.YES)
    	{
    		((Stage)alert.getOwner()).close();
    	} 
    	else if (result.get() == ButtonType.NO) 
    	{
    	    alert.close();
    	}
    }

    @FXML
    private void approveTask(ActionEvent event) 
    {    	
 	   	if (!((textfield_comment.getText()).equals("")))
	   	{
	   		TaskCommentDAO taskCommentDAO = new TaskCommentDAO();
	   		taskCommentDAO.create(new TaskComment(0, textfield_comment.getText(), Login.getLoggedUser().getCode(), task.getCode()));
	   	}
	   	
		TaskDAO taskDAO = new TaskDAO();
		taskDAO.approveTask(task.getCode(), Login.getLoggedUser().getCode());
				
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Sucesso!");
		alert.setHeaderText("Tarefa aprovada");
		alert.setContentText("Evento: " + taskEvent + "\nTarefa: " + taskDescription);
		
    	DialogPane dialogPane = alert.getDialogPane();
    	
    	dialogPane.getStylesheets().add(getClass().getResource("dialogs.css").toExternalForm());
    	
		alert.showAndWait();
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{

	}

}
