package oompa.sisgemplus.db.i;

import java.util.List;

import oompa.sisgemplus.model.*;

public interface IMaterialDAO {
	
	/* CREATE */
	public void create(Material m);
	
	/* RETRIEVE */
	public Material findByCode(int code);
	public List<MaterialConcept> listAllByConcept(int conceptCode);
	public List<MaterialEvent> listAllByEvent(int eventCode);
	public List<Material> listAll();
	
	/* UPDATE */
	public void update(Material m);
	
	/* DELETE */
	public void delete(Material m);

}
