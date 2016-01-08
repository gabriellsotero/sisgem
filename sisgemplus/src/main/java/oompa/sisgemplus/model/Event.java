package oompa.sisgemplus.model;

import javafx.beans.property.*;
import oompa.sisgemplus.model.enums.EventStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Event {
	private IntegerProperty code;
	private StringProperty name;
	private IntegerProperty venueCode;
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
	private IntegerProperty creatorCode;
	private IntegerProperty evaluatorCode;
	private IntegerProperty originatorCode;
	
	public Event (int cCode, String cName, int cVenueCode,
					LocalDateTime cDateTime, String cDescription, EventStatus cStatus,
					String cStatusText, LocalDate cDateCreated, String cComments,
					int cAttending, int cPaying, int cFbAttendees,
					int cBirthdayLists, String cCompetitors, String cEvaluation,
					int cCreatorCode, int cEvaluatorCode, int cOriginatorCode)
	{
		code = new SimpleIntegerProperty(cCode);
		name = new SimpleStringProperty(cName);
		venueCode = new SimpleIntegerProperty(cVenueCode);
		dateTime = new SimpleObjectProperty<LocalDateTime>(cDateTime);
		description = new SimpleStringProperty(cDescription);
		status = new SimpleObjectProperty<EventStatus>(cStatus);
		statusText = new SimpleStringProperty(cStatusText);
		dateCreated = new SimpleObjectProperty<LocalDate>(cDateCreated);
		comments = new SimpleStringProperty(cComments);
		attending = new SimpleIntegerProperty(cAttending);
		paying = new SimpleIntegerProperty(cPaying);
		fbAttendees = new SimpleIntegerProperty(cFbAttendees);
		birthdayLists = new SimpleIntegerProperty(cBirthdayLists);
		competitors = new SimpleStringProperty(cCompetitors);
		evaluation = new SimpleStringProperty(cEvaluation);
		creatorCode = new SimpleIntegerProperty(cCreatorCode);
		evaluatorCode = new SimpleIntegerProperty(cEvaluatorCode);
		originatorCode = new SimpleIntegerProperty(cOriginatorCode);
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
	

	public IntegerProperty venueCodeProperty() {
		return this.venueCode;
	}
	

	public int getVenueCode() {
		return this.venueCodeProperty().get();
	}
	

	public void setVenueCode(final int venueCode) {
		this.venueCodeProperty().set(venueCode);
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
	

	public oompa.sisgemplus.model.enums.EventStatus getStatus() {
		return this.statusProperty().get();
	}
	

	public void setStatus(final oompa.sisgemplus.model.enums.EventStatus status) {
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
	

	public IntegerProperty originatorCodeProperty() {
		return this.originatorCode;
	}
	

	public int getOriginatorCode() {
		return this.originatorCodeProperty().get();
	}
	

	public void setOriginatorCode(final int originatorCode) {
		this.originatorCodeProperty().set(originatorCode);
	}

	@Override
	public String toString() {
		return this.getName();
	}	
}
