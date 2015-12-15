package sisgem.db;

import java.util.List;

import sisgem.db.i.IProviderEventRoleDAO;
import sisgem.model.ProviderEventRole;
import sisgem.model.ProviderEventRoleConcept;

public class ProviderEventRoleDAO implements IProviderEventRoleDAO {

	@Override
	public void create(ProviderEventRole p) {
		//TODO 55		
	}

	@Override
	public ProviderEventRole findByCode(int provider) {
		//TODO 56
		return null;
	}

	@Override
	public List<ProviderEventRoleConcept> listAllByConcept(int conceptCode) {
		//TODO 57
		return null;
	}

	@Override
	public List<ProviderEventRole> listAll() {
		//TODO 58
		return null;
	}

	@Override
	public void update(ProviderEventRole p) {
		//TODO 59		
	}

	@Override
	public void delete(ProviderEventRole p) {
		//TODO 60
		
	}

	
}
