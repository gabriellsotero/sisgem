package sisgem.db;

import java.util.List;

import sisgem.db.i.IVenueDAO;
import sisgem.model.Concept;
import sisgem.model.Venue;

public class VenueDAO implements IVenueDAO{

	@Override
	public void create(Venue v) {
		//TODO 078
	}

	@Override
	public List<Venue> listAllByConcept(int conceptCode) {
		//TODO 079
		return null;
	}

	@Override
	public List<Venue> listAll() {
		//TODO 080
		return null;
	}

	@Override
	public Venue findByCode() {
		//TODO 081
		return null;
	}

	@Override
	public void update(Venue v) {
		//TODO 082		
	}

	@Override
	public void delete(Venue v) {
		//TODO 083	
	}
}
