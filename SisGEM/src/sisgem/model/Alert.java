package sisgem.model;

import java.time.LocalDateTime;

import javafx.beans.property.*;
import sisgem.model.enums.AlertTypes;

public class Alert {
	
	private IntegerProperty code;
	private StringProperty description;
	private ObjectProperty<LocalDateTime> date;
	private BooleanProperty read;
	private ObjectProperty<User> user;
	private ObjectProperty<AlertTypes> type;
	private StringProperty typeText; //not DB
	private ObjectProperty<Task> task;
	private ObjectProperty<Concept> concept;
	
	public Alert(int cCode, String cDescription, LocalDateTime cdate, boolean cRead,
					User cUser, AlertTypes cType, String cTypeText, Task cTask, Concept cConcept)
	{
		code = new SimpleIntegerProperty(cCode);
		description = new SimpleStringProperty(cDescription);
		date = new SimpleObjectProperty<LocalDateTime>(cdate);
		read = new SimpleBooleanProperty(cRead);
		user = new SimpleObjectProperty<User>(cUser);
		type = new SimpleObjectProperty<AlertTypes>(cType);
		typeText = new SimpleStringProperty(cTypeText);
		task = new SimpleObjectProperty<Task>(cTask);
		concept = new SimpleObjectProperty<Concept>(cConcept);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alert other = (Alert) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
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
	
	public StringProperty descriptionProperty() {
		return this.description;
	}
	
	public java.lang.String getDescription() {
		return this.descriptionProperty().get();
	}
	
	public void setDescription(final java.lang.String description) {
		this.descriptionProperty().set(description);
	}
	
	public ObjectProperty<LocalDateTime> dateProperty() {
		return this.date;
	}
	
	public java.time.LocalDateTime getDate() {
		return this.dateProperty().get();
	}
	
	public void setDate(final java.time.LocalDateTime date) {
		this.dateProperty().set(date);
	}
	
	public BooleanProperty readProperty() {
		return this.read;
	}
	
	public boolean isRead() {
		return this.readProperty().get();
	}
	
	public void setRead(final boolean read) {
		this.readProperty().set(read);
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
	
	public ObjectProperty<AlertTypes> typeProperty() {
		return this.type;
	}
	
	public sisgem.model.enums.AlertTypes getType() {
		return this.typeProperty().get();
	}
	
	public void setType(final sisgem.model.enums.AlertTypes type) {
		this.typeProperty().set(type);
	}
	
	public StringProperty typeTextProperty() {
		return this.typeText;
	}
	
	public java.lang.String getTypeText() {
		return this.typeTextProperty().get();
	}
	
	public void setTypeText(final java.lang.String typeText) {
		this.typeTextProperty().set(typeText);
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
	
	public ObjectProperty<Concept> conceptProperty() {
		return this.concept;
	}
	
	public sisgem.model.Concept getConcept() {
		return this.conceptProperty().get();
	}
	
	public void setConcept(final sisgem.model.Concept concept) {
		this.conceptProperty().set(concept);
	}	
	
}
