package sisgem.model;

import javafx.beans.property.*;

public class TaskComment {
	
	private IntegerProperty code;
	private StringProperty comment;
	private ObjectProperty<User> user;
	private ObjectProperty<Task> task;
	
	//TODO 096 - Constructor
	
	public IntegerProperty codeProperty() {
		return this.code;
	}
	
	public int getCode() {
		return this.codeProperty().get();
	}
	
	public void setCode(final int code) {
		this.codeProperty().set(code);
	}
	
	public StringProperty commentProperty() {
		return this.comment;
	}
	
	public java.lang.String getComment() {
		return this.commentProperty().get();
	}
	
	public void setComment(final java.lang.String comment) {
		this.commentProperty().set(comment);
	}
	
	public ObjectProperty<User> userProperty() {
		return this.user;
	}
	
	public sisgem.model.User getUser() {
		return this.userProperty().get();
	}
	
	public void setUser(final sisgem.model.User user) {
		this.userProperty().set(user);
	}
	
	public ObjectProperty<Task> taskProperty() {
		return this.task;
	}
	
	public sisgem.model.Task getTask() {
		return this.taskProperty().get();
	}
	
	public void setTask(final sisgem.model.Task task) {
		this.taskProperty().set(task);
	}
	
	
	
}
