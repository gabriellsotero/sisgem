package sisgem.db.i;

import java.util.List;

import sisgem.model.Event;

public interface IEventDAO {
	
	/* CREATE */
	public void create(Event e);
	
	/* RETRIEVE */
	public Event findByCode(int code);
	public List <Event> listAll();
	
	/* UPDATE */
	public void update(Event e);
	
	/* DELETE */
	public void delete(Event e);
}
