package sisgem.model;

import java.awt.Image;

import javafx.beans.property.*;
import sisgem.model.enums.UserProfiles;

public class User {
	
	private IntegerProperty code;
	private StringProperty name;
	private ObjectProperty<byte[]> photo;
	private StringProperty login;
	private StringProperty password;
	private StringProperty salt;
	private StringProperty email;
	private ObjectProperty<UserProfiles> profile;
	private StringProperty profileText;
	
	public User (int cCode, String cName, byte[] bs, String cLogin,
					String cPassword, String cSalt, String cEmail,
					UserProfiles cProfile , String cProfileText)
	{		
		code = new SimpleIntegerProperty(cCode);
		name = new SimpleStringProperty(cName);
		photo = new SimpleObjectProperty<byte[]>(bs);
		login = new SimpleStringProperty(cLogin);
		password = new SimpleStringProperty(cPassword);
		salt = new SimpleStringProperty(cSalt);
		email = new SimpleStringProperty(cEmail);
		profile = new SimpleObjectProperty<UserProfiles>(cProfile);
		profileText = new SimpleStringProperty(cProfileText);
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
	

	public StringProperty loginProperty() {
		return this.login;
	}
	

	public java.lang.String getLogin() {
		return this.loginProperty().get();
	}
	

	public void setLogin(final java.lang.String login) {
		this.loginProperty().set(login);
	}
	

	public StringProperty passwordProperty() {
		return this.password;
	}
	

	public java.lang.String getPassword() {
		return this.passwordProperty().get();
	}
	

	public void setPassword(final java.lang.String password) {
		this.passwordProperty().set(password);
	}
	

	public StringProperty saltProperty() {
		return this.salt;
	}
	

	public java.lang.String getSalt() {
		return this.saltProperty().get();
	}
	

	public void setSalt(final java.lang.String salt) {
		this.saltProperty().set(salt);
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
	

	public ObjectProperty<UserProfiles> profileProperty() {
		return this.profile;
	}
	

	public sisgem.model.enums.UserProfiles getProfile() {
		return this.profileProperty().get();
	}
	

	public void setProfile(final sisgem.model.enums.UserProfiles profile) {
		this.profileProperty().set(profile);
	}
	

	public StringProperty profileTextProperty() {
		return this.profileText;
	}
	

	public java.lang.String getProfileText() {
		return this.profileTextProperty().get();
	}
	

	public void setProfileText(final java.lang.String profileText) {
		this.profileTextProperty().set(profileText);
	}
	
}
