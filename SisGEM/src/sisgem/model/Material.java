package sisgem.model;

import javafx.beans.property.*;
import javafx.scene.image.Image;

public class Material {
	
	private IntegerProperty code;
	private StringProperty name;
	private ObjectProperty<Image> photo;
	private StringProperty comments;
	private StringProperty measureUnit;
	
	//TODO 092 Constructor
	
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
	
	public ObjectProperty<Image> photoProperty() {
		return this.photo;
	}
	
	public javafx.scene.image.Image getPhoto() {
		return this.photoProperty().get();
	}
	
	public void setPhoto(final javafx.scene.image.Image photo) {
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
		
}
