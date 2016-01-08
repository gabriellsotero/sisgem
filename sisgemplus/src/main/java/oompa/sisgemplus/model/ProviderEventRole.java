package oompa.sisgemplus.model;

import javafx.beans.property.*;

public class ProviderEventRole {
	
	private IntegerProperty code;
	private StringProperty name;
	
	public ProviderEventRole(int cCode, String cName)
	{
		code = new SimpleIntegerProperty(cCode);
		name = new SimpleStringProperty(cName);
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

	@Override
	public String toString() {
		return this.getName();
	}
}
