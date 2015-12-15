package sisgem.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;

public class MaterialConcept {
	
	private ObjectProperty<Material> material;
	private IntegerProperty qty;
	
	//TODO 098 - Constructor
	
	public ObjectProperty<Material> materialProperty() {
		return this.material;
	}
	
	public sisgem.model.Material getMaterial() {
		return this.materialProperty().get();
	}
	
	public void setMaterial(final sisgem.model.Material material) {
		this.materialProperty().set(material);
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
