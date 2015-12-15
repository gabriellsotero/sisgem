package sisgem.model;

import javafx.beans.property.*;

public class EventEntry {
	
	private IntegerProperty code;
	private ObjectProperty<EventEntry> type;
	private StringProperty typeText; //notDB
	private FloatProperty vl;
	private IntegerProperty qty;
	private ObjectProperty<Event> event;
	
	public EventEntry (int cCode, EventEntry cType, String cTypeText,
						float cValue, int cQty, Event cEvent)
	{
		code = new SimpleIntegerProperty(cCode);
		type = new SimpleObjectProperty<EventEntry>(cType);
		typeText = new SimpleStringProperty(cTypeText);
		vl = new SimpleFloatProperty(cValue);
		qty = new SimpleIntegerProperty(cQty);
		event = new SimpleObjectProperty<Event>(cEvent);
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
	
	public ObjectProperty<EventEntry> typeProperty() {
		return this.type;
	}
	
	public sisgem.model.EventEntry getType() {
		return this.typeProperty().get();
	}
	
	public void setType(final sisgem.model.EventEntry type) {
		this.typeProperty().set(type);
	}
	
	public StringProperty typeTextProperty() {
		return this.typeText;
	}
	
	public java.lang.String getTypeText() {
		return this.typeTextProperty().get();
	}
	
	public void setTypeText(final java.lang.String typeText) {
		this.typeTextProperty().set(typeText);
	}
	
	public FloatProperty valueProperty() {
		return this.vl;
	}
	
	public float getValue() {
		return this.valueProperty().get();
	}
	
	public void setValue(final float value) {
		this.valueProperty().set(value);
	}
	
	public IntegerProperty qtyProperty() {
		return this.qty;
	}
	
	public int getQty() {
		return this.qtyProperty().get();
	}
	
	public void setQty(final int qty) {
		this.qtyProperty().set(qty);
	}
	
	public ObjectProperty<Event> eventProperty() {
		return this.event;
	}
	
	public sisgem.model.Event getEvent() {
		return this.eventProperty().get();
	}
	
	public void setEvent(final sisgem.model.Event event) {
		this.eventProperty().set(event);
	}
	
	
	
	

}
