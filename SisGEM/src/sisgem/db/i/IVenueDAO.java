package sisgem.db.i;

import java.util.List;

import sisgem.model.Concept;
import sisgem.model.Venue;

public interface IVenueDAO {

	/* CREATE */
	public void create(Venue v);
	
	/* RETRIEVE */
	public List<Venue> listAllByConcept(int conceptCode);
	public List<Venue> listAll();
	public Venue findByCode();
	
	/* UPDATE */
	public void update(Venue v);
	
	/* DELETE */
	public void delete(Venue v);
}
