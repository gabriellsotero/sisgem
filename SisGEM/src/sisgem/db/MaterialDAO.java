package sisgem.db;

import java.util.List;

import sisgem.db.i.IMaterialDAO;
import sisgem.model.Concept;
import sisgem.model.Event;
import sisgem.model.Material;
import sisgem.model.MaterialConcept;
import sisgem.model.MaterialEvent;

public class MaterialDAO implements IMaterialDAO {

	@Override
	public void create(Material m) {
		//TODO 042
		
	}

	@Override
	public Material findByCode(int code) {
		//TODO 043
		return null;
	}

	@Override
	public List<MaterialConcept> listAllByConcept(int conceptCode) {
		//TODO 044
		return null;
	}

	@Override
	public List<MaterialEvent> listAllByEvent(int eventCode) {
		//TODO 045
		return null;
	}

	@Override
	public List<Material> listAll() {
		//TODO 046
		return null;
	}

	@Override
	public void update(Material m) {
		//TODO 047
		
	}

	@Override
	public void delete(Material m) {
		//TODO 048
		
	}

}
