package sisgem.model;

import java.time.LocalDateTime;

import javafx.beans.property.*;
import sisgem.model.enums.AlertTypes;

public class Alert {
	
	private IntegerProperty code;
	private StringProperty description;
	private ObjectProperty<LocalDateTime> date;
	private BooleanProperty read;
	private IntegerProperty userCode;
	private ObjectProperty<AlertTypes> type;
	private StringProperty typeText; //not DB
	private IntegerProperty taskCode;
	private IntegerProperty conceptCode;
	
	public Alert(int cCode, String cDescription, LocalDateTime cdate, boolean cRead,
					int cUser, AlertTypes cType, String cTypeText, int cTask, int cConcept)
	{
		code = new SimpleIntegerProperty(cCode);
		description = new SimpleStringProperty(cDescription);
		date = new SimpleObjectProperty<LocalDateTime>(cdate);
		read = new SimpleBooleanProperty(cRead);
		userCode = new SimpleIntegerProperty(cUser);
		type = new SimpleObjectProperty<AlertTypes>(cType);
		typeText = new SimpleStringProperty(cTypeText);
		taskCode = new SimpleIntegerProperty(cTask);
		conceptCode = new SimpleIntegerProperty(cConcept);
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
	

	public IntegerProperty userCodeProperty() {
		return this.userCode;
	}
	

	public int getUserCode() {
		return this.userCodeProperty().get();
	}
	

	public void setUserCode(final int userCode) {
		this.userCodeProperty().set(userCode);
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
	

	public IntegerProperty taskCodeProperty() {
		return this.taskCode;
	}
	

	public int getTaskCode() {
		return this.taskCodeProperty().get();
	}
	

	public void setTaskCode(final int taskCode) {
		this.taskCodeProperty().set(taskCode);
	}
	

	public IntegerProperty conceptCodeProperty() {
		return this.conceptCode;
	}
	

	public int getConceptCode() {
		return this.conceptCodeProperty().get();
	}
	

	public void setConceptCode(final int conceptCode) {
		this.conceptCodeProperty().set(conceptCode);
	}

}
