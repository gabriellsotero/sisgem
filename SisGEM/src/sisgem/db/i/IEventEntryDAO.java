package sisgem.db.i;

import java.util.List;

import sisgem.model.EventEntry;

public interface IEventEntryDAO {
	
	/* CREATE */
	public void create(EventEntry e);
	
	/* RETRIEVE */
	public List<EventEntry> listAllByEvent(int eventCode);
	public EventEntry findByCode(int code);

	/* UPDATE */
	public void update(EventEntry e);
	
	/* DELETE */
	public void delete(EventEntry e);
}
