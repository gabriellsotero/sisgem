package sisgem.model;

import javafx.beans.property.*;

public class EventOrderedAction {
	
	private IntegerProperty code;
	private IntegerProperty order;
	private StringProperty description;
	private ObjectProperty<Event> event;
	
	public EventOrderedAction (int cCode, int cOrder,
								String cDescription, Event cEvent)
	{
		code = new SimpleIntegerProperty(cCode);
		order = new SimpleIntegerProperty(cOrder);
		description = new SimpleStringProperty(cDescription);
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
