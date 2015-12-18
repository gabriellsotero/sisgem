package sisgem.model;

import javafx.beans.property.*;
import sisgem.model.enums.*;

import java.time.LocalDate;
import java.util.List;

public class Task {

	private IntegerProperty code;
	private ObjectProperty<User> accountable;
	private ObjectProperty<Artist> artist;
	private ObjectProperty<User> creator;
	private ObjectProperty<User> evaluator;
	private ObjectProperty<Event> event;
	private ObjectProperty<Material> material;
	private ObjectProperty<Provider> provider;
	private ObjectProperty<TaskStatus> status;
	private ObjectProperty<TaskTypes> type;
	private StringProperty description;
	private ObjectProperty<LocalDate> targetDate;
	private ObjectProperty<LocalDate> completedDate;
	private StringProperty statusText; //not db
	private StringProperty typeText; //not db
	private BooleanProperty late;
	
	private ObjectProperty<List<TaskComment>> commentsList;

	public Task (int cCode, User cAccountable, Artist cArtist,
				User cCreator, User cEvaluator, Event cEvent,
				Material cMaterial, Provider cProvider, TaskStatus cStatus,
				TaskTypes cType, String cDescription, LocalDate cTargetDate,
				LocalDate cCompletedDate, String cStatusText, String cTypeText,
				boolean cLate)
	{
		code = new SimpleIntegerProperty(cCode);
		accountable = new SimpleObjectProperty<User>(cAccountable);
		artist = new SimpleObjectProperty<Artist>(cArtist);
		creator = new SimpleObjectProperty<User>(cCreator);
		evaluator = new SimpleObjectProperty<User>(cEvaluator);
		event = new SimpleObjectProperty<Event>(cEvent);
		material = new SimpleObjectProperty<Material>(cMaterial);
		provider = new SimpleObjectProperty<Provider>(cProvider);
		status = new SimpleObjectProperty<TaskStatus>(cStatus);
		type = new SimpleObjectProperty<TaskTypes>(cType);
		description = new SimpleStringProperty(cDescription);
		targetDate = new SimpleObjectProperty<LocalDate>(cTargetDate);
		completedDate = new SimpleObjectProperty<LocalDate>(cCompletedDate);
		statusText = new SimpleStringProperty(cStatusText);
		typeText = new SimpleStringProperty(cTypeText);
		late = new SimpleBooleanProperty(cLate);
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
	
	public ObjectProperty<User> accountableProperty() {
		return this.accountable;
	}
	
	public sisgem.model.User getAccountable() {
		return this.accountableProperty().get();
	}
	
	public void setAccountable(final sisgem.model.User accountable) {
		this.accountableProperty().set(accountable);
	}
	
	public ObjectProperty<Artist> artistProperty() {
		return this.artist;
	}
	
	public sisgem.model.Artist getArtist() {
		return this.artistProperty().get();
	}
	
	public void setArtist(final sisgem.model.Artist artist) {
		this.artistProperty().set(artist);
	}
	
	public ObjectProperty<User> creatorProperty() {
		return this.creator;
	}
	
	public sisgem.model.User getCreator() {
		return this.creatorProperty().get();
	}
	
	public void setCreator(final sisgem.model.User creator) {
		this.creatorProperty().set(creator);
	}
	
	public ObjectProperty<User> evaluatorProperty() {
		return this.evaluator;
	}
	
	public sisgem.model.User getEvaluator() {
		return this.evaluatorProperty().get();
	}
	
	public void setEvaluator(final sisgem.model.User evaluator) {
		this.evaluatorProperty().set(evaluator);
	}
	
	public ObjectProperty<Event> eventProperty() {
		return this.event;
	}
	
	public sisgem.model.Event getEvent() {
		return this.eventProperty().get();
	}
	
	public void setEvent(final sisgem.model.Event event) {
		this.eventProperty().set(event);
	}
	
	public ObjectProperty<Material> materialProperty() {
		return this.material;
	}
	
	public sisgem.model.Material getMaterial() {
		return this.materialProperty().get();
	}
	
	public void setMaterial(final sisgem.model.Material material) {
		this.materialProperty().set(material);
	}
	
	public ObjectProperty<Provider> providerProperty() {
		return this.provider;
	}
	
	public sisgem.model.Provider getProvider() {
		return this.providerProperty().get();
	}
	
	public void setProvider(final sisgem.model.Provider provider) {
		this.providerProperty().set(provider);
	}
	
	public ObjectProperty<TaskStatus> statusProperty() {
		return this.status;
	}
	
	public sisgem.model.enums.TaskStatus getStatus() {
		return this.statusProperty().get();
	}
	
	public void setStatus(final sisgem.model.enums.TaskStatus status) {
		this.statusProperty().set(status);
	}
	
	public ObjectProperty<TaskTypes> typeProperty() {
		return this.type;
	}
	
	public sisgem.model.enums.TaskTypes getType() {
		return this.typeProperty().get();
	}
	
	public void setType(final sisgem.model.enums.TaskTypes type) {
		this.typeProperty().set(type);
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
	
	public ObjectProperty<LocalDate> targetDateProperty() {
		return this.targetDate;
	}
	
	public java.time.LocalDate getTargetDate() {
		return this.targetDateProperty().get();
	}
	
	public void setTargetDate(final java.time.LocalDate targetDate) {
		this.targetDateProperty().set(targetDate);
	}
	
	public ObjectProperty<LocalDate> completedDateProperty() {
		return this.completedDate;
	}
	
	public java.time.LocalDate getCompletedDate() {
		return this.completedDateProperty().get();
	}
	
	public void setCompletedDate(final java.time.LocalDate completedDate) {
		this.completedDateProperty().set(completedDate);
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
	
	public StringProperty typeTextProperty() {
		return this.typeText;
	}
	
	public java.lang.String getTypeText() {
		return this.typeTextProperty().get();
	}
	
	public void setTypeText(final java.lang.String typeText) {
		this.typeTextProperty().set(typeText);
	}
	
	public BooleanProperty lateProperty() {
		return this.late;
	}
	
	public boolean isLate() {
		return this.lateProperty().get();
	}
	
	public void setLate(final boolean isLate) {
		this.lateProperty().set(isLate);
	}

	public ObjectProperty<List<TaskComment>> commentsListProperty() {
		return this.commentsList;
	}
	

	public java.util.List<sisgem.model.TaskComment> getCommentsList() {
		return this.commentsListProperty().get();
	}
	

	public void setCommentsList(final java.util.List<sisgem.model.TaskComment> commentsList) {
		this.commentsListProperty().set(commentsList);
	}
	
}
