package sisgem.model;

import javafx.beans.property.*;

public class Artist {
	
	private IntegerProperty code;
	private StringProperty realName;
	private StringProperty stageName;
	private ObjectProperty<byte[]> photo;
	private StringProperty artistEventRole;
	private IntegerProperty contactCode;
	private FloatProperty avgValue;
	private StringProperty comment;
	
	public Artist (int cCode, String cRealName, String cStageName, byte[] cPhoto,
					String cArtistEventRole, int cContact, float cAvgValue, String cComment)
	{
		code = new SimpleIntegerProperty(cCode);
		realName = new SimpleStringProperty(cRealName);
		stageName = new SimpleStringProperty(cStageName);
		photo = new SimpleObjectProperty<byte[]>(cPhoto);
		artistEventRole = new SimpleStringProperty(cArtistEventRole);
		contactCode = new SimpleIntegerProperty(cContact);
		avgValue = new SimpleFloatProperty(cAvgValue);
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
	
	public StringProperty realNameProperty() {
		return this.realName;
	}
	
	public java.lang.String getRealName() {
		return this.realNameProperty().get();
	}
	
	public void setRealName(final java.lang.String realName) {
		this.realNameProperty().set(realName);
	}
	
	public StringProperty stageNameProperty() {
		return this.stageName;
	}
	
	public java.lang.String getStageName() {
		return this.stageNameProperty().get();
	}
	
	public void setStageName(final java.lang.String stageName) {
		this.stageNameProperty().set(stageName);
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
	
	public StringProperty artistEventRoleProperty() {
		return this.artistEventRole;
	}
	
	public java.lang.String getArtistEventRole() {
		return this.artistEventRoleProperty().get();
	}
	
	public void setArtistEventRole(final java.lang.String artistEventRole) {
		this.artistEventRoleProperty().set(artistEventRole);
	}
	
	public FloatProperty avgValueProperty() {
		return this.avgValue;
	}
	
	public float getAvgValue() {
		return this.avgValueProperty().get();
	}
	
	public void setAvgValue(final float avgValue) {
		this.avgValueProperty().set(avgValue);
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


	public IntegerProperty contactCodeProperty() {
		return this.contactCode;
	}
	


	public int getContactCode() {
		return this.contactCodeProperty().get();
	}
	


	public void setContactCode(final int contactCode) {
		this.contactCodeProperty().set(contactCode);
	}
		
}
