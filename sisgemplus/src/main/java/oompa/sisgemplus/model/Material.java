package oompa.sisgemplus.model;

import javafx.beans.property.*;

public class Material {
	
	private IntegerProperty code;
	private StringProperty name;
	private ObjectProperty<byte[]> photo;
	private StringProperty comments;
	private StringProperty measureUnit;
	
	public Material(int cCode, String cName, byte[] cPhoto,
					String cComments, String cMeasureUnit)
	{
		code = new SimpleIntegerProperty(cCode);
		name = new SimpleStringProperty(cName);
		photo = new SimpleObjectProperty<byte[]>(cPhoto);
		comments = new SimpleStringProperty(cComments);
		measureUnit = new SimpleStringProperty(cMeasureUnit);		
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
	
	public ObjectProperty<byte[]> photoProperty() {
		return this.photo;
	}
	
	public byte[] getPhoto() {
		return this.photoProperty().get();
	}
	
	public void setPhoto(final byte[] photo) {
		this.photoProperty().set(photo);
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

	public StringProperty measureUnitProperty() {
		return this.measureUnit;
	}
	

	public java.lang.String getMeasureUnit() {
		return this.measureUnitProperty().get();
	}
	

	public void setMeasureUnit(final java.lang.String measureUnit) {
		this.measureUnitProperty().set(measureUnit);
	}

	@Override
	public String toString() {
		return this.getName();
	}	
	
	
		
}
