package sisgem.model;

import javafx.beans.property.*;
import sisgem.model.enums.EventEntryTypes;

public class EventEntry {
	
	private IntegerProperty code;
	private ObjectProperty<EventEntryTypes> type;
	private StringProperty typeText; //notDB
	private StringProperty description;
	private FloatProperty value;
	private IntegerProperty qty;
	private IntegerProperty eventCode;
	
	public EventEntry (int cCode, EventEntryTypes cType, String cTypeText,
						float cValue, int cQty, int cEvent)
	{
		code = new SimpleIntegerProperty(cCode);
		type = new SimpleObjectProperty<EventEntryTypes>(cType);
		typeText = new SimpleStringProperty(cTypeText);
		value = new SimpleFloatProperty(cValue);
		qty = new SimpleIntegerProperty(cQty);
		eventCode = new SimpleIntegerProperty(cEvent);
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
	
	public ObjectProperty<EventEntryTypes> typeProperty() {
		return this.type;
	}
	
	public EventEntryTypes getType() {
		return this.typeProperty().get();
	}
	
	public void setType(final EventEntryTypes type) {
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
	

	public StringProperty descriptionProperty() {
		return this.description;
	}
	

	public java.lang.String getDescription() {
		return this.descriptionProperty().get();
	}
	

	public void setDescription(final java.lang.String description) {
		this.descriptionProperty().set(description);
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
	
	public IntegerProperty qtyProperty() {
		return this.qty;
	}
	
	public int getQty() {
		return this.qtyProperty().get();
	}
	
	public void setQty(final int qty) {
		this.qtyProperty().set(qty);
	}

	public IntegerProperty eventCodeProperty() {
		return this.eventCode;
	}
	

	public int getEventCode() {
		return this.eventCodeProperty().get();
	}
	

	public void setEventCode(final int eventCode) {
		this.eventCodeProperty().set(eventCode);
	}
}
