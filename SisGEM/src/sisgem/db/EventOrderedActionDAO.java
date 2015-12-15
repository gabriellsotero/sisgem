package sisgem.db;

import java.util.List;

import sisgem.db.i.IEventOrderedActionDAO;
import sisgem.model.EventOrderedAction;

public class EventOrderedActionDAO implements IEventOrderedActionDAO {

	@Override
	public void create(EventOrderedAction e) {
		//TODO 037		
	}

	@Override
	public List<EventOrderedAction> listAllByEvent(int eventCode) {
		//TODO 038
		return null;
	}

	@Override
	public EventOrderedAction findByCode(int code) {
		//TODO 039
		return null;
	}

	@Override
	public void update(EventOrderedAction e) {
		//TODO 040		
	}

	@Override
	public void delete(EventOrderedAction e) {
		//TODO 041
	}


	
}
