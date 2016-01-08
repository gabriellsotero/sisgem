package oompa.sisgemplus.model;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public class MaterialEvent {
	
	private ObjectProperty<Material> material;
	private IntegerProperty qty;
	private FloatProperty value;
	
	public MaterialEvent(Material cMaterial, int cQty, float cValue)
	{
		material = new SimpleObjectProperty<Material>(cMaterial);
		qty = new SimpleIntegerProperty(cQty);
		value = new SimpleFloatProperty(cValue);
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


	public FloatProperty valueProperty() {
		return this.value;
	}
	


	public float getValue() {
		return this.valueProperty().get();
	}
	


	public void setValue(final float value) {
		this.valueProperty().set(value);
	}
	
		
}
