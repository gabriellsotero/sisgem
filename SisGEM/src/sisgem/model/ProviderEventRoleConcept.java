package sisgem.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;

public class ProviderEventRoleConcept {
	
	private ObjectProperty<ProviderEventRole> role;
	private IntegerProperty qty;
	public ObjectProperty<ProviderEventRole> roleProperty() {
		return this.role;
	}
	
	public sisgem.model.ProviderEventRole getRole() {
		return this.roleProperty().get();
	}
	
	public void setRole(final sisgem.model.ProviderEventRole role) {
		this.roleProperty().set(role);
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
