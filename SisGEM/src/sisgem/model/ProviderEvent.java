package sisgem.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;

public class ProviderEvent {
	
	private ObjectProperty<Provider> provider;
	private IntegerProperty qty;
	
	//TODO 102 - Constructor	
	
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
