package sisgem.model;

import javafx.beans.property.*;

public class EventOrderedAction {
	
	private IntegerProperty code;
	private IntegerProperty order;
	private StringProperty description;
	private IntegerProperty eventCode;
	
	public EventOrderedAction (int cCode, int cOrder,
								String cDescription, int cEventCode)
	{
		code = new SimpleIntegerProperty(cCode);
		order = new SimpleIntegerProperty(cOrder);
		description = new SimpleStringProperty(cDescription);
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
	
	public IntegerProperty orderProperty() {
		return this.order;
	}
	
	public int getOrder() {
		return this.orderProperty().get();
	}
	
	public void setOrder(final int order) {
		this.orderProperty().set(order);
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
