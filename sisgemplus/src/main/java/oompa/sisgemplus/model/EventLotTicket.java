package oompa.sisgemplus.model;

import javafx.beans.property.*;

public class EventLotTicket {

	private IntegerProperty code;
	private StringProperty name;
	private FloatProperty value;
	private FloatProperty sympla;
	private IntegerProperty qty;
	private IntegerProperty eventCode;
	
	public EventLotTicket(int cCode, String cName, float cValue,
							float cSympla, int cQty, int cEventCode)
	{
		code = new SimpleIntegerProperty(cCode);
		name = new SimpleStringProperty(cName);
		value = new SimpleFloatProperty(cValue);
		sympla = new SimpleFloatProperty(cSympla);
		qty = new SimpleIntegerProperty(cQty);
		eventCode = new SimpleIntegerProperty(cEventCode);
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
	
	public FloatProperty valueProperty() {
		return this.value;
	}
	
	public float getValue() {
		return this.valueProperty().get();
	}
	
	public void setValue(final float value) {
		this.valueProperty().set(value);
	}
	
	public FloatProperty symplaProperty() {
		return this.sympla;
	}
	
	public float getSympla() {
		return this.symplaProperty().get();
	}
	
	public void setSympla(final float sympla) {
		this.symplaProperty().set(sympla);
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
