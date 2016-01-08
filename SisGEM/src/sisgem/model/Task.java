package sisgem.model;

import javafx.beans.property.*;
import sisgem.model.enums.*;

import java.lang.reflect.Field;
import java.time.LocalDate;

public class Task {

	private IntegerProperty code;
	private IntegerProperty accountableCode;
	private IntegerProperty artistCode;
	private IntegerProperty creatorCode;
	private IntegerProperty evaluatorCode;
	private IntegerProperty eventCode;
	private IntegerProperty materialCode;
	private IntegerProperty providerCode;
	private ObjectProperty<TaskStatus> status;
	private ObjectProperty<TaskTypes> type;
	private StringProperty description;
	private ObjectProperty<LocalDate> targetDate;
	private ObjectProperty<LocalDate> completedDate;
	private StringProperty statusText; //not db
	private StringProperty typeText; //not db
	private StringProperty eventName; //not db
	
	public Task (int cCode, int cAccountableCode, int cArtistCode,
				int cCreatorCode, int cEvaluatorCode, int cEventCode,
				int cMaterialCode, int cProviderCode, TaskStatus cStatus,
				TaskTypes cType, String cDescription, LocalDate cTargetDate,
				LocalDate cCompletedDate, String cStatusText, String cTypeText
				)
	{
		code = new SimpleIntegerProperty(cCode);
		accountableCode = new SimpleIntegerProperty(cAccountableCode);
		artistCode = new SimpleIntegerProperty(cArtistCode);
		creatorCode = new SimpleIntegerProperty(cCreatorCode);
		evaluatorCode = new SimpleIntegerProperty(cEvaluatorCode);
		eventCode = new SimpleIntegerProperty(cEventCode);
		materialCode = new SimpleIntegerProperty(cMaterialCode);
		providerCode = new SimpleIntegerProperty(cProviderCode);
		status = new SimpleObjectProperty<TaskStatus>(cStatus);
		type = new SimpleObjectProperty<TaskTypes>(cType);
		description = new SimpleStringProperty(cDescription);
		targetDate = new SimpleObjectProperty<LocalDate>(cTargetDate);
		completedDate = new SimpleObjectProperty<LocalDate>(cCompletedDate);
		statusText = new SimpleStringProperty(cStatusText);
		typeText = new SimpleStringProperty(cTypeText);
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
	

	public IntegerProperty accountableCodeProperty() {
		return this.accountableCode;
	}
	

	public int getAccountableCode() {
		return this.accountableCodeProperty().get();
	}
	

	public void setAccountableCode(final int accountableCode) {
		this.accountableCodeProperty().set(accountableCode);
	}
	

	public IntegerProperty artistCodeProperty() {
		return this.artistCode;
	}
	

	public int getArtistCode() {
		return this.artistCodeProperty().get();
	}
	

	public void setArtistCode(final int artistCode) {
		this.artistCodeProperty().set(artistCode);
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
	

	public IntegerProperty eventCodeProperty() {
		return this.eventCode;
	}
	

	public int getEventCode() {
		return this.eventCodeProperty().get();
	}
	

	public void setEventCode(final int eventCode) {
		this.eventCodeProperty().set(eventCode);
	}
	

	public IntegerProperty materialCodeProperty() {
		return this.materialCode;
	}
	

	public int getMaterialCode() {
		return this.materialCodeProperty().get();
	}
	

	public void setMaterialCode(final int materialCode) {
		this.materialCodeProperty().set(materialCode);
	}
	

	public IntegerProperty providerCodeProperty() {
		return this.providerCode;
	}
	

	public int getProviderCode() {
		return this.providerCodeProperty().get();
	}
	

	public void setProviderCode(final int providerCode) {
		this.providerCodeProperty().set(providerCode);
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

	public StringProperty eventNameProperty() {
		return this.eventName;
	}
	

	public java.lang.String getEventName() {
		return this.eventNameProperty().get();
	}
	

	public void setEventName(final java.lang.String eventName) {
		this.eventNameProperty().set(eventName);
	}
	
	@Override
	public String toString() {
		  StringBuilder result = new StringBuilder();
		  String newLine = System.getProperty("line.separator");

		  result.append( this.getClass().getName() );
		  result.append( " Object {" );
		  result.append(newLine);

		  //determine fields declared in this class only (no fields of superclass)
		  Field[] fields = this.getClass().getDeclaredFields();

		  //print field names paired with their values
		  for ( Field field : fields  ) {
		    result.append("  ");
		    try {
		      result.append( field.getName() );
		      result.append(": ");
		      //requires access to private field:
		      result.append( field.get(this) );
		    } catch ( IllegalAccessException ex ) {
		      System.out.println(ex);
		    }
		    result.append(newLine);
		  }
		  result.append("}");

		  return result.toString();
		}
}
