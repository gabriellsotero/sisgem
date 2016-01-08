package oompa.sisgemplus.model;

import javafx.beans.property.*;

public class Provider {
	
	private IntegerProperty code;
	private StringProperty name;
	private IntegerProperty eventRoleCode;
	private ObjectProperty<byte[]> photo;
	private IntegerProperty contactCode;
	private FloatProperty value;
	private StringProperty comment;
	
	public Provider(int cCode, String cName, int cEventRoleCode,
					byte[] cPhoto, int cContactCode, float cValue, String cComment)
	{
		code = new SimpleIntegerProperty(cCode);
		name = new SimpleStringProperty(cName);
		eventRoleCode = new SimpleIntegerProperty(cEventRoleCode);
		photo = new SimpleObjectProperty<byte[]>(cPhoto);
		contactCode = new SimpleIntegerProperty(cContactCode);
		value = new SimpleFloatProperty(cValue);
		comment = new SimpleStringProperty(cComment);		
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
	

	public IntegerProperty eventRoleCodeProperty() {
		return this.eventRoleCode;
	}
	

	public int getEventRoleCode() {
		return this.eventRoleCodeProperty().get();
	}
	

	public void setEventRoleCode(final int eventRoleCode) {
		this.eventRoleCodeProperty().set(eventRoleCode);
	}
	

	public ObjectProperty<byte[]> photoProperty() {
		return this.photo;
	}
	

	public byte[] getPhoto() {
		return this.photoProperty().get();
	}
	

	public void setPhoto(final byte[] photo) {
		this.photoProperty().set(photo);
	}
	

	public IntegerProperty contactCodeProperty() {
		return this.contactCode;
	}
	

	public int getContactCode() {
		return this.contactCodeProperty().get();
	}
	

	public void setContactCode(final int contactCode) {
		this.contactCodeProperty().set(contactCode);
	}
	

	public FloatProperty valueProperty() {
		return this.value;
	}
	

	public float getValue() {
		return this.valueProperty().get();
	}
	

	public void setValue(final float value) {
		this.valueProperty().set(value);
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
	
}
