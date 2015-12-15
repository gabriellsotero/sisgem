package sisgem.model;

import javafx.beans.property.*;

public class Venue {
	
	private IntegerProperty code;
	private StringProperty name;
	private StringProperty description;
	private IntegerProperty maxCapacity;
	private ObjectProperty<Contact> contact;
	private StringProperty comment;
	
	//TODO 097 - Constructor
	
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
	
	public IntegerProperty maxCapacityProperty() {
		return this.maxCapacity;
	}
	
	public int getMaxCapacity() {
		return this.maxCapacityProperty().get();
	}
	
	public void setMaxCapacity(final int maxCapacity) {
		this.maxCapacityProperty().set(maxCapacity);
	}
	
	public ObjectProperty<Contact> contactProperty() {
		return this.contact;
	}
	
	public sisgem.model.Contact getContact() {
		return this.contactProperty().get();
	}
	
	public void setContact(final sisgem.model.Contact contact) {
		this.contactProperty().set(contact);
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
