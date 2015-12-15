package sisgem.model;

import javafx.beans.property.*;
import sisgem.model.enums.EventStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Event {
	private IntegerProperty code;
	private StringProperty name;
	private IntegerProperty venue;
	private ObjectProperty<LocalDateTime> dateTime;
	private StringProperty description;
	private ObjectProperty<EventStatus> status;
	private StringProperty statusText; //not DB
	private ObjectProperty<LocalDate> dateCreated;
	private StringProperty comments;
	private IntegerProperty attending;
	private IntegerProperty paying;
	private IntegerProperty fbAttendees;
	private IntegerProperty birthdayLists;
	private StringProperty competitors;
	private StringProperty evaluation;
	private ObjectProperty<User> creator;
	private ObjectProperty<User> evaluator;
	private ObjectProperty<Concept> originator;

	private ObjectProperty<List<ArtistEvent>> artistsList;
	private ObjectProperty<List<MaterialEvent>> materialsList;
	private ObjectProperty<List<ProviderEvent>> providersList;
	private ObjectProperty<List<EventEntry>> entriesList;
	private ObjectProperty<List<EventLotTicket>> ticketsList;
	private ObjectProperty<List<EventOrderedAction>> actionsList;
	
	//TODO 088 - Constructor
	
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
	
	public IntegerProperty venueProperty() {
		return this.venue;
	}
	
	public int getVenue() {
		return this.venueProperty().get();
	}
	
	public void setVenue(final int venue) {
		this.venueProperty().set(venue);
	}
	
	public ObjectProperty<LocalDateTime> dateTimeProperty() {
		return this.dateTime;
	}
	
	public java.time.LocalDateTime getDateTime() {
		return this.dateTimeProperty().get();
	}
	
	public void setDateTime(final java.time.LocalDateTime dateTime) {
		this.dateTimeProperty().set(dateTime);
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
	
	public ObjectProperty<EventStatus> statusProperty() {
		return this.status;
	}
	
	public sisgem.model.enums.EventStatus getStatus() {
		return this.statusProperty().get();
	}
	
	public void setStatus(final sisgem.model.enums.EventStatus status) {
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
	
	public ObjectProperty<LocalDate> dateCreatedProperty() {
		return this.dateCreated;
	}
	
	public java.time.LocalDate getDateCreated() {
		return this.dateCreatedProperty().get();
	}
	
	public void setDateCreated(final java.time.LocalDate dateCreated) {
		this.dateCreatedProperty().set(dateCreated);
	}
	
	public StringProperty commentsProperty() {
		return this.comments;
	}
	
	public java.lang.String getComments() {
		return this.commentsProperty().get();
	}
	
	public void setComments(final java.lang.String comments) {
		this.commentsProperty().set(comments);
	}
	
	public IntegerProperty attendingProperty() {
		return this.attending;
	}
	
	public int getAttending() {
		return this.attendingProperty().get();
	}
	
	public void setAttending(final int attending) {
		this.attendingProperty().set(attending);
	}
	
	public IntegerProperty payingProperty() {
		return this.paying;
	}
	
	public int getPaying() {
		return this.payingProperty().get();
	}
	
	public void setPaying(final int paying) {
		this.payingProperty().set(paying);
	}
	
	public IntegerProperty fbAttendeesProperty() {
		return this.fbAttendees;
	}
	
	public int getFbAttendees() {
		return this.fbAttendeesProperty().get();
	}
	
	public void setFbAttendees(final int fbAttendees) {
		this.fbAttendeesProperty().set(fbAttendees);
	}
	
	public IntegerProperty birthdayListsProperty() {
		return this.birthdayLists;
	}
	
	public int getBirthdayLists() {
		return this.birthdayListsProperty().get();
	}
	
	public void setBirthdayLists(final int birthdayLists) {
		this.birthdayListsProperty().set(birthdayLists);
	}
	
	public StringProperty competitorsProperty() {
		return this.competitors;
	}
	
	public java.lang.String getCompetitors() {
		return this.competitorsProperty().get();
	}
	
	public void setCompetitors(final java.lang.String competitors) {
		this.competitorsProperty().set(competitors);
	}
	
	public StringProperty evaluationProperty() {
		return this.evaluation;
	}
	
	public java.lang.String getEvaluation() {
		return this.evaluationProperty().get();
	}
	
	public void setEvaluation(final java.lang.String evaluation) {
		this.evaluationProperty().set(evaluation);
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
	
	public ObjectProperty<Concept> originatorProperty() {
		return this.originator;
	}
	
	public sisgem.model.Concept getOriginator() {
		return this.originatorProperty().get();
	}
	
	public void setOriginator(final sisgem.model.Concept originator) {
		this.originatorProperty().set(originator);
	}
	
	public ObjectProperty<List<ArtistEvent>> artistsListProperty() {
		return this.artistsList;
	}
	
	public java.util.List<sisgem.model.ArtistEvent> getArtistsList() {
		return this.artistsListProperty().get();
	}
	
	public void setArtistsList(final java.util.List<sisgem.model.ArtistEvent> artistsList) {
		this.artistsListProperty().set(artistsList);
	}
	
	public ObjectProperty<List<MaterialEvent>> materialsListProperty() {
		return this.materialsList;
	}
	
	public java.util.List<sisgem.model.MaterialEvent> getMaterialsList() {
		return this.materialsListProperty().get();
	}
	
	public void setMaterialsList(final java.util.List<sisgem.model.MaterialEvent> materialsList) {
		this.materialsListProperty().set(materialsList);
	}
	
	public ObjectProperty<List<ProviderEvent>> providersListProperty() {
		return this.providersList;
	}
	
	public java.util.List<sisgem.model.ProviderEvent> getProvidersList() {
		return this.providersListProperty().get();
	}
	
	public void setProvidersList(final java.util.List<sisgem.model.ProviderEvent> providersList) {
		this.providersListProperty().set(providersList);
	}
	
	public ObjectProperty<List<EventEntry>> entriesListProperty() {
		return this.entriesList;
	}
	
	public java.util.List<sisgem.model.EventEntry> getEntriesList() {
		return this.entriesListProperty().get();
	}
	
	public void setEntriesList(final java.util.List<sisgem.model.EventEntry> entriesList) {
		this.entriesListProperty().set(entriesList);
	}
	
	public ObjectProperty<List<EventLotTicket>> ticketsListProperty() {
		return this.ticketsList;
	}
	
	public java.util.List<sisgem.model.EventLotTicket> getTicketsList() {
		return this.ticketsListProperty().get();
	}
	
	public void setTicketsList(final java.util.List<sisgem.model.EventLotTicket> ticketsList) {
		this.ticketsListProperty().set(ticketsList);
	}
	
	public ObjectProperty<List<EventOrderedAction>> actionsListProperty() {
		return this.actionsList;
	}
	
	public java.util.List<sisgem.model.EventOrderedAction> getActionsList() {
		return this.actionsListProperty().get();
	}
	
	public void setActionsList(final java.util.List<sisgem.model.EventOrderedAction> actionsList) {
		this.actionsListProperty().set(actionsList);
	}	
	
}
