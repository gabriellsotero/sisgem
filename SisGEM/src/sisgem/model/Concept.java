package sisgem.model;

import java.time.LocalDate;
import java.util.List;

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
	private ObjectProperty<User> creator;
	private ObjectProperty<User> evaluator;
	private ObjectProperty<List<Artist>> artistsList;
	private ObjectProperty<List<MaterialConcept>> materialsList;
	private ObjectProperty<List<ProviderEventRoleConcept>> eventRolesList;
	private ObjectProperty<List<Venue>> venuesList;
	
	public Concept (int cCode, String cName, String cDescription,
						String cComment, LocalDate cCreatedDate, ConceptStatus cStatus,
						String cStatusText, User cCreator, User cEvaluator, 
						List<Artist> cArtistsList, List<MaterialConcept> cMaterialsList, 
						List<ProviderEventRoleConcept> cEventRolesList,	List<Venue> cVenuesList)
	{
		code = new SimpleIntegerProperty(cCode);
		name = new SimpleStringProperty(cName);
		description = new SimpleStringProperty(cDescription);
		comment = new SimpleStringProperty(cComment);
		createdDate = new SimpleObjectProperty<LocalDate>(cCreatedDate);
		status = new SimpleObjectProperty<ConceptStatus>(cStatus);
		statusText = new SimpleStringProperty(cStatusText);
		creator = new SimpleObjectProperty<User>(cCreator);
		evaluator = new SimpleObjectProperty<User>(cEvaluator);
		artistsList = new SimpleObjectProperty<List<Artist>>(cArtistsList);
		materialsList = new SimpleObjectProperty<List<MaterialConcept>>(cMaterialsList);
		eventRolesList = new SimpleObjectProperty<List<ProviderEventRoleConcept>>(cEventRolesList);
		venuesList = new SimpleObjectProperty<List<Venue>>(cVenuesList);
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
	
	public ObjectProperty<List<Artist>> artistsListProperty() {
		return this.artistsList;
	}
	
	public java.util.List<sisgem.model.Artist> getArtistsList() {
		return this.artistsListProperty().get();
	}
	
	public void setArtistsList(final java.util.List<sisgem.model.Artist> artistsList) {
		this.artistsListProperty().set(artistsList);
	}
	
	public ObjectProperty<List<MaterialConcept>> materialsListProperty() {
		return this.materialsList;
	}
	
	public java.util.List<sisgem.model.MaterialConcept> getMaterialsList() {
		return this.materialsListProperty().get();
	}
	
	public void setMaterialsList(final java.util.List<sisgem.model.MaterialConcept> materialsList) {
		this.materialsListProperty().set(materialsList);
	}
	
	public ObjectProperty<List<ProviderEventRoleConcept>> eventRolesListProperty() {
		return this.eventRolesList;
	}
	
	public java.util.List<sisgem.model.ProviderEventRoleConcept> getEventRolesList() {
		return this.eventRolesListProperty().get();
	}
	
	public void setEventRolesList(final java.util.List<sisgem.model.ProviderEventRoleConcept> eventRolesList) {
		this.eventRolesListProperty().set(eventRolesList);
	}

	public ObjectProperty<List<Venue>> venuesListProperty() {
		return this.venuesList;
	}
	

	public java.util.List<sisgem.model.Venue> getVenuesList() {
		return this.venuesListProperty().get();
	}
	

	public void setVenuesList(final java.util.List<sisgem.model.Venue> venuesList) {
		this.venuesListProperty().set(venuesList);
	}

	public IntegerProperty codeProperty() {
		return this.code;
	}
	
}
