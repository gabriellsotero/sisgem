package sisgem.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import sisgem.model.Task;

public class CompleteTaskController implements Initializable 
{
    @SuppressWarnings("unused")
	private Task task;

	public void setTask(Task task)
	{
		this.task = task;
		fillInfo();
	}
	
	private void fillInfo()
	{
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		// TODO Auto-generated method stub
		
	}
	
}
