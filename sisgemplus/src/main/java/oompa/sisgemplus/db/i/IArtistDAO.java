package oompa.sisgemplus.db.i;

import java.util.List;

import oompa.sisgemplus.model.*;

public interface IArtistDAO {
	
	/* CREATE */
	public void create (Artist a);
	
	/* RETRIEVE */
	public Artist findByCode(int code);
	public List<Artist> listAll();
	public List<Artist> listAllByConcept(int conceptCode);
	public List<ArtistEvent> listAllByEvent(int eventCode);
	
	/* UPDATE */
	public void update (Artist a);
	
	/* DELETE */
	public void delete (Artist a);
	
}
