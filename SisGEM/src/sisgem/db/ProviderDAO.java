package sisgem.db;

import java.util.List;

import sisgem.db.i.IProviderDAO;
import sisgem.model.Provider;
import sisgem.model.ProviderEvent;

public class ProviderDAO implements IProviderDAO {

	@Override
	public void create(Provider p) {
		//TODO 49		
	}

	@Override
	public Provider findByCode(int provider) {
		//TODO 50
		return null;
	}

	@Override
	public List<ProviderEvent> listAllByEvent() {
		//TODO 51
		return null;
	}

	@Override
	public List<Provider> listAll() {
		//TODO 52
		return null;
	}

	@Override
	public void update(Provider p) {
		//TODO 53		
	}

	@Override
	public void delete(Provider p) {
		//TODO 54		
	}



}
