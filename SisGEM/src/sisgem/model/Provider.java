package sisgem.model;

import javafx.beans.property.*;
import javafx.scene.image.Image;

public class Provider {
	
	private IntegerProperty code;
	private StringProperty name;
	private ObjectProperty<ProviderEventRole> eventRole;
	private ObjectProperty<Image> photo;
	private ObjectProperty<Contact> contact;
	private FloatProperty value;
	private StringProperty comment;
	
	//TODO 093 - Constructor
	
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
	
	public ObjectProperty<ProviderEventRole> eventRoleProperty() {
		return this.eventRole;
	}
	
	public sisgem.model.ProviderEventRole getEventRole() {
		return this.eventRoleProperty().get();
	}
	
	public void setEventRole(final sisgem.model.ProviderEventRole eventRole) {
		this.eventRoleProperty().set(eventRole);
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
	
	public ObjectProperty<Contact> contactProperty() {
		return this.contact;
	}
	
	public sisgem.model.Contact getContact() {
		return this.contactProperty().get();
	}
	
	public void setContact(final sisgem.model.Contact contact) {
		this.contactProperty().set(contact);
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
	
	/*
	 * 
	 * CREATE TABLE tb_provider (
	cd_provider serial primary key, -- código identificador do prestador de serviço
	nm_provider varchar(100) not null default '', -- nome do prestador de serviço
	cd_provider_eventrole integer not null references tb_provider_eventrole, -- código da função do prestador de serviço 
	ph_provider bytea, -- foto do prestador de serviço
	cd_contact integer references tb_contact, -- código identificador do contato associado ao prestador de serviço
	vl_provider_avg numeric, -- valor médio do prestador de serviço
	ds_provider_comment text -- observações sobre o prestador de serviço
);
	 */
}
