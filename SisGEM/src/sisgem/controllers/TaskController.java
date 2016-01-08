package sisgem.controllers;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import sisgem.Login;
import sisgem.Main;
import sisgem.db.TaskCommentDAO;
import sisgem.db.UserDAO;
import sisgem.model.Task;
import sisgem.model.TaskComment;
import sisgem.model.enums.TaskTypes;
import sisgem.model.enums.UserProfiles;
import javafx.event.ActionEvent;

public class TaskController implements Initializable {
	
    @FXML
    private Label label_title;

    @FXML
    private Label label_description;

    @FXML
    private Label label_description_info;
    
    @FXML
    private Label label_code;

    @FXML
    private Label label_code_info;

    @FXML
    private Label label_accountable;

    @FXML
    private Label label_accountable_info;

    @FXML
    private Label label_creator;

    @FXML
    private Label label_target_date;

    @FXML
    private Label label_creator_info;

    @FXML
    private Label label_target_date_info;

    @FXML
    private Label label_type;

    @FXML
    private Label label_type_info;

    @FXML
    private Label label_status;

    @FXML
    private Label label_status_info;

    @FXML
    private Label label_comments;

    @FXML
    private TableView<TaskComment> tableview_comments;

    @FXML
    private TableColumn<TaskComment, String> tablecolumn_user;

    @FXML
    private TableColumn<TaskComment, String> tablecolumn_comment;

    @FXML
    private TableColumn<TaskComment, LocalDate> tablecolumn_date;

    @FXML
    private HBox hbox_buttons;
    
    @FXML
    private Button button_addcomment;

    @FXML
    private Button button_edittask;
    
    @FXML
    private Button button_completetask;

    private Task task;
    
	public void setTask(Task task)
	{
		this.task = task;
		fillInfo();
	}
	
	private void fillInfo()
	{
		DateTimeFormatter myDateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		UserDAO userDAO = new UserDAO();
		String creatorLogin = userDAO.findLoginByCode(task.getCreatorCode());
		String accountableLogin = userDAO.findLoginByCode(task.getAccountableCode());
		
		/* Prepare informations */				
		label_description_info.setText(task.getDescription());
		label_description_info.setTooltip(new Tooltip(task.getDescription()));
		label_code_info.setText(Integer.toString(task.getCode()));
		label_creator_info.setText(creatorLogin);
		label_accountable_info.setText(accountableLogin);
		label_target_date_info.setText(myDateFormatter.format(task.getTargetDate()));
		label_type_info.setText(task.getTypeText());
		label_status_info.setText(task.getStatusText());

		/* Prepare table */
		TaskCommentDAO taskCommentDAO = new TaskCommentDAO();
		List<TaskComment> lst = taskCommentDAO.listAllByTask(task.getCode());
		
		ObservableList<TaskComment> observableListTasks = FXCollections.observableArrayList(lst);
		tableview_comments.setItems(observableListTasks);
		
		tablecolumn_user.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<TaskComment, String>, ObservableValue<String>>() {
		    @Override
		    public ObservableValue<String> call(TableColumn.CellDataFeatures<TaskComment, String> t) {
		        UserDAO userDAO = new UserDAO();
		       	String login = userDAO.findLoginByCode(t.getValue().getUserCode());
		        return new SimpleStringProperty(login);
		    }
		});
		    
		tablecolumn_comment.setCellValueFactory(cellData -> cellData.getValue().commentProperty());
		tablecolumn_date.setCellValueFactory(cellData -> cellData.getValue().dateProperty());		
		tablecolumn_date.setCellFactory(column -> {
		    return new TableCell<TaskComment, LocalDate>() {
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
		            }
		        }
		    };
		});
		
		/* Prepare buttons */
		
		if (task.getAccountableCode() != Login.getLoggedUser().getCode())
		{
			hbox_buttons.getChildren().remove(button_completetask);
		}
		if (Login.getLoggedUser().getProfile() == UserProfiles.ADMINISTRADOR ||
			Login.getLoggedUser().getProfile() == UserProfiles.PRODUTOR_DE_EVENTOS)
		{
			
		}
		else
		{
			hbox_buttons.getChildren().remove(button_edittask);
		}
			
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{	
		tablecolumn_date.prefWidthProperty().bind(tableview_comments.widthProperty().multiply(0.25));
		tablecolumn_comment.prefWidthProperty().bind(tableview_comments.widthProperty().multiply(0.5));
		tablecolumn_user.prefWidthProperty().bind(tableview_comments.widthProperty().multiply(0.25));
	}

	@FXML 
	public void editTask(ActionEvent event)
	{ 
		//TODO
	};

	@FXML 
	public void completeTask(ActionEvent event)
	{
		TaskTypes type = task.getType();
		if(type == TaskTypes.MATERIAIS ||
			type == TaskTypes.PREST_SERVICO || 
			type == TaskTypes.REC_ARTISTICOS)
			openCompleteTaskScreen(true, type);
		else
			openCompleteTaskScreen(false, type);
	}

	private void openCompleteTaskScreen (boolean hasValue, TaskTypes taskType)
	{
			Parent root;
			
			try
			{
					FXMLLoader loader;
					
					if (hasValue)
					{
						loader = new FXMLLoader(Main.class.getResource("completetaskwithvalue.fxml"));
					}
					else
					{
						loader = new FXMLLoader(Main.class.getResource("completetaskwithoutvalue.fxml"));
					}
					
		            root = loader.load();

		            Stage stage = new Stage();
	
		            stage.setScene(new Scene(root, 450, 200));
		            stage.setResizable(false);
					loader.<CompleteTaskController>getController().setTask(task);
					
		            stage.setTitle("Deseja completar a tarefa?");
		            
		            stage.showAndWait();
		    }
			
			catch (Exception e) 
			{
				e.printStackTrace();
	        }
	}
	
	@FXML public void addComment(ActionEvent event)
	{
		//TODO
	}	

} 
