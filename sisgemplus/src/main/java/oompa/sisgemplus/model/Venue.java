package oompa.sisgemplus.model;

import javafx.beans.property.*;

public class Venue {
	
	private IntegerProperty code;
	private StringProperty name;
	private StringProperty address;
	private IntegerProperty maxCapacity;
	private IntegerProperty contactCode;
	private StringProperty comment;
	
	public Venue (int cCode, String cName, String cAddress,
				int cMaxCapacity, int cContactCode, String cComment)
	{
		code = new SimpleIntegerProperty(cCode);
		name = new SimpleStringProperty(cName);
		address = new SimpleStringProperty(cAddress);
		maxCapacity = new SimpleIntegerProperty(cMaxCapacity);
		contactCode = new SimpleIntegerProperty(cContactCode);
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
	
	public StringProperty addressProperty() {
		return this.address;
	}
	
	public java.lang.String getAddress() {
		return this.addressProperty().get();
	}
	
	public void setAddress(final java.lang.String address) {
		this.addressProperty().set(address);
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
	
	public IntegerProperty contactCodeProperty() {
		return this.contactCode;
	}
	

	public int getContactCode() {
		return this.contactCodeProperty().get();
	}
	

	public void setContactCode(final int contactCode) {
		this.contactCodeProperty().set(contactCode);
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
	
	@Override
	public String toString() {
		return this.getName();
	}

}
