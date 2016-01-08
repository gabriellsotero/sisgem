package oompa.sisgemplus.db.i;

import java.util.List;

import oompa.sisgemplus.model.Concept;

public interface IConceptDAO {

	/* CREATE */
	public void create(Concept c);
	
	/* RETRIEVE */
	public Concept findByCode(int code);
	public List<Concept> findAll();
	
	/* UPDATE */
	public void update(Concept c);
	
	/* DELETE */
	public void delete(Concept c);
}
