package oompa.sisgemplus.model;

import javafx.beans.property.*;

public class MaterialConcept {
	
	private ObjectProperty<Material> material;
	private IntegerProperty qty;
	
	public MaterialConcept(Material cMaterial, int cQty)
	{
		material = new SimpleObjectProperty<Material>(cMaterial);
		qty = new SimpleIntegerProperty(cQty);
	}
	
	public ObjectProperty<Material> materialProperty() {
		return this.material;
	}
	
	public oompa.sisgemplus.model.Material getMaterial() {
		return this.materialProperty().get();
	}
	
	public void setMaterial(final oompa.sisgemplus.model.Material material) {
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

	public String toString() {
		return this.getMaterial().getName() + " (" + this.getQty() + " " + this.getMaterial().getMeasureUnit() + ")";  
	}	
	
}
