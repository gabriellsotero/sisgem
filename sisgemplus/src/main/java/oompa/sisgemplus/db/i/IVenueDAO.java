package oompa.sisgemplus.db.i;

import java.util.List;

import oompa.sisgemplus.model.Venue;

public interface IVenueDAO {

	/* CREATE */
	public void create(Venue v);
	
	/* RETRIEVE */
	public List<Venue> listAllByConcept(int conceptCode);
	public List<Venue> listAll();
	public Venue findByCode(int code);
	
	/* UPDATE */
	public void update(Venue v);
	
	/* DELETE */
	public void delete(Venue v);
}
