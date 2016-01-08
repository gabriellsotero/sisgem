package oompa.sisgemplus.db.i;

import java.util.List;

import oompa.sisgemplus.model.ProviderEventRole;
import oompa.sisgemplus.model.ProviderEventRoleConcept;

public interface IProviderEventRoleDAO {

	/* CREATE */
	public void create(ProviderEventRole p);
	
	/* RETRIEVE */
	public ProviderEventRole findByCode(int provider);
	public List<ProviderEventRoleConcept> listAllByConcept(int conceptCode);
	public List<ProviderEventRole> listAll();
	
	/* UPDATE */
	public void update(ProviderEventRole p);
	
	/* DELETE */
	public void delete(ProviderEventRole p);
}
