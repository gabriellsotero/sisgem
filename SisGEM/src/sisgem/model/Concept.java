package sisgem.model;

import java.time.LocalDate;
import javafx.beans.property.*;
import sisgem.model.enums.ConceptStatus;

public class Concept {
	
	private IntegerProperty code;
	private StringProperty name;
	private StringProperty description;
	private StringProperty comment;
	private ObjectProperty<LocalDate> createdDate;
	private ObjectProperty<ConceptStatus> status;
	private StringProperty statusText; //not DB
	private IntegerProperty creatorCode;
	private IntegerProperty evaluatorCode;
	
	public Concept (int cCode, String cName, String cDescription,
						String cComment, LocalDate cCreatedDate, ConceptStatus cStatus,
						String cStatusText, int cCreatorCode, int cEvaluatorCode)
	{
		code = new SimpleIntegerProperty(cCode);
		name = new SimpleStringProperty(cName);
		description = new SimpleStringProperty(cDescription);
		comment = new SimpleStringProperty(cComment);
		createdDate = new SimpleObjectProperty<LocalDate>(cCreatedDate);
		status = new SimpleObjectProperty<ConceptStatus>(cStatus);
		statusText = new SimpleStringProperty(cStatusText);
		creatorCode = new SimpleIntegerProperty(cCreatorCode);
		evaluatorCode = new SimpleIntegerProperty(cEvaluatorCode);
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
	

	public StringProperty nameProperty() {
		return this.name;
	}
	

	public java.lang.String getName() {
		return this.nameProperty().get();
	}
	

	public void setName(final java.lang.String name) {
		this.nameProperty().set(name);
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
	

	public StringProperty commentProperty() {
		return this.comment;
	}
	

	public java.lang.String getComment() {
		return this.commentProperty().get();
	}
	

	public void setComment(final java.lang.String comment) {
		this.commentProperty().set(comment);
	}
	

	public ObjectProperty<LocalDate> createdDateProperty() {
		return this.createdDate;
	}
	

	public java.time.LocalDate getCreatedDate() {
		return this.createdDateProperty().get();
	}
	

	public void setCreatedDate(final java.time.LocalDate createdDate) {
		this.createdDateProperty().set(createdDate);
	}
	

	public ObjectProperty<ConceptStatus> statusProperty() {
		return this.status;
	}
	

	public sisgem.model.enums.ConceptStatus getStatus() {
		return this.statusProperty().get();
	}
	

	public void setStatus(final sisgem.model.enums.ConceptStatus status) {
		this.statusProperty().set(status);
	}
	

	public StringProperty statusTextProperty() {
		return this.statusText;
	}
	

	public java.lang.String getStatusText() {
		return this.statusTextProperty().get();
	}
	

	public void setStatusText(final java.lang.String statusText) {
		this.statusTextProperty().set(statusText);
	}
	

	public IntegerProperty creatorCodeProperty() {
		return this.creatorCode;
	}
	

	public int getCreatorCode() {
		return this.creatorCodeProperty().get();
	}
	

	public void setCreatorCode(final int creatorCode) {
		this.creatorCodeProperty().set(creatorCode);
	}
	

	public IntegerProperty evaluatorCodeProperty() {
		return this.evaluatorCode;
	}
	

	public int getEvaluatorCode() {
		return this.evaluatorCodeProperty().get();
	}
	

	public void setEvaluatorCode(final int evaluatorCode) {
		this.evaluatorCodeProperty().set(evaluatorCode);
	}
	
}
