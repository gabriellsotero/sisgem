package sisgem.model;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleObjectProperty;

public class ArtistEvent {
	
	private ObjectProperty<Artist> artist;
	private FloatProperty value;
	
	public ArtistEvent (Artist cArtist, float cValue)
	{
		artist = new SimpleObjectProperty<Artist>(cArtist);
		value = new SimpleFloatProperty(cValue);
	}
	
	public ObjectProperty<Artist> artistProperty() {
		return this.artist;
	}
	
	public sisgem.model.Artist getArtist() {
		return this.artistProperty().get();
	}
	
	public void setArtist(final sisgem.model.Artist artist) {
		this.artistProperty().set(artist);
	}
	
	public FloatProperty valueProperty() {
		return this.value;
	}
	
	public float getValue() {
		return this.valueProperty().get();
	}
	
	public void setQty(final float value) {
		this.valueProperty().set(value);
	}
	
	
	

}
