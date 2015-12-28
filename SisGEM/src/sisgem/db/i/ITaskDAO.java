package sisgem.db.i;

import java.util.List;

import sisgem.model.*;
import sisgem.model.enums.TaskStatus;

public interface ITaskDAO {
	
	/* CREATE */
	public void create(Task t);
	
	/* RETRIEVE */
	public List <Task> listAll();
	public List <Task> listAllPendingByAccUser(int userCode);
	public List <Task> listAllByEvent(int eventCode);
	public List <Task> listAllByStatus(TaskStatus ts);
	public Task findByCode(int code);
	
	/* UPDATE */
	public void update(Task t);
	
	/* DELETE */
	public void delete(Task t);
}
