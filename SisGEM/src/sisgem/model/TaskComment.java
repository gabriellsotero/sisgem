package sisgem.model;

import java.time.LocalDate;

import javafx.beans.property.*;

public class TaskComment {
	
	private IntegerProperty code;
	private StringProperty comment;
	private IntegerProperty userCode;
	private IntegerProperty taskCode;
	private ObjectProperty<LocalDate> date;
	
	public TaskComment(int cCode, String cComment, int cUserCode, int cTaskCode)
	{
		code = new SimpleIntegerProperty(cCode);
		comment = new SimpleStringProperty(cComment);
		userCode = new SimpleIntegerProperty(cUserCode);
		taskCode = new SimpleIntegerProperty(cTaskCode);		
	}
	
	public TaskComment(int cCode, String cComment, int cUserCode, int cTaskCode, LocalDate cDate)
	{
		this(cCode, cComment, cUserCode, cTaskCode);
		date = new SimpleObjectProperty<LocalDate>(cDate);
	}

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
	

	public IntegerProperty userCodeProperty() {
		return this.userCode;
	}
	

	public int getUserCode() {
		return this.userCodeProperty().get();
	}
	

	public void setUserCode(final int userCode) {
		this.userCodeProperty().set(userCode);
	}
	

	public IntegerProperty taskCodeProperty() {
		return this.taskCode;
	}
	

	public int getTaskCode() {
		return this.taskCodeProperty().get();
	}
	

	public void setTaskCode(final int taskCode) {
		this.taskCodeProperty().set(taskCode);
	}
	

	public ObjectProperty<LocalDate> dateProperty() {
		return this.date;
	}
	

	public java.time.LocalDate getDate() {
		return this.dateProperty().get();
	}
	

	public void setDate(final java.time.LocalDate date) {
		this.dateProperty().set(date);
	}
	
}
