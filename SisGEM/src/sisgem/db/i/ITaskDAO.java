package sisgem.db.i;

import java.util.List;

import sisgem.model.*;
import sisgem.model.enums.TaskStatus;

public interface ITaskDAO {
	
	/* CREATE */
	public void create(Task t);
	
	/* RETRIEVE */
	public List <Task> listAll();
	public List <Task> listAllPendingByAccUser(User u);
	public List <Task> listAllByEvent(Event e);
	public List <Task> listAllByStatus(TaskStatus ts);
	public Task findByCode(int code);
	
	/* UPDATE */
	public List <Task> update();
	
	/* DELETE */
	public List <Task> delete();
}
