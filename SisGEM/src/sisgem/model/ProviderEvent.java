package sisgem.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public class ProviderEvent {
	
	private ObjectProperty<Provider> provider;
	private IntegerProperty qty;
	
	public ProviderEvent(Provider cProvider, int cQty)
	{
		provider = new SimpleObjectProperty<Provider>(cProvider);
		qty = new SimpleIntegerProperty(cQty);
	}
	public ObjectProperty<Provider> providerProperty() {
		return this.provider;
	}
	
	public sisgem.model.Provider getProvider() {
		return this.providerProperty().get();
	}
	
	public void setProvider(final sisgem.model.Provider provider) {
		this.providerProperty().set(provider);
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
	
}
