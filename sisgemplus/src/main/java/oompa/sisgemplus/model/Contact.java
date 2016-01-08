package oompa.sisgemplus.model;

import javafx.beans.property.*;

public class Contact {
	
	private IntegerProperty code;
	private StringProperty name;
	private StringProperty position;
	private StringProperty telephone;
	private StringProperty email;

	public Contact (int cCode, String cName, String cPosition,
					String cTelephone, String cEmail)
	{
		code = new SimpleIntegerProperty(cCode);
		name = new SimpleStringProperty(cName);
		position = new SimpleStringProperty(cPosition);
		telephone = new SimpleStringProperty(cTelephone);
		email = new SimpleStringProperty(cEmail);		
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
	
	public StringProperty positionProperty() {
		return this.position;
	}
	
	public java.lang.String getPosition() {
		return this.positionProperty().get();
	}
	
	public void setPosition(final java.lang.String position) {
		this.positionProperty().set(position);
	}
	
	public StringProperty telephoneProperty() {
		return this.telephone;
	}
	
	public java.lang.String getTelephone() {
		return this.telephoneProperty().get();
	}
	
	public void setTelephone(final java.lang.String telephone) {
		this.telephoneProperty().set(telephone);
	}
	
	public StringProperty emailProperty() {
		return this.email;
	}
	
	public java.lang.String getEmail() {
		return this.emailProperty().get();
	}
	
	public void setEmail(final java.lang.String email) {
		this.emailProperty().set(email);
	}
}
