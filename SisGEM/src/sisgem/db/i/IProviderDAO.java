package sisgem.db.i;

import java.util.List;

import sisgem.model.Provider;
import sisgem.model.ProviderEvent;

public interface IProviderDAO {
	
	/* CREATE */
	public void create(Provider p);
	
	/* RETRIEVE */
	public Provider findByCode(int provider);
	public List<ProviderEvent> listAllByEvent(int eventCode);
	public List<Provider> listAll();
	
	/* UPDATE */
	public void update(Provider p);
	
	/* DELETE */
	public void delete(Provider p);

}
