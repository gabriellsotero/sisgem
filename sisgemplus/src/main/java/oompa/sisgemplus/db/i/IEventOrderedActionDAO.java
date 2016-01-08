package oompa.sisgemplus.db.i;

import java.util.List;

import oompa.sisgemplus.model.EventOrderedAction;

public interface IEventOrderedActionDAO {
	
	/* CREATE */
	public void create(EventOrderedAction e);
	
	/* RETRIEVE */
	public List<EventOrderedAction> listAllByEvent(int eventCode);
	public EventOrderedAction findByCode(int code);

	/* UPDATE */
	
	public void update(EventOrderedAction e);
	
	/* DELETE */
	public void delete(EventOrderedAction e);
}
