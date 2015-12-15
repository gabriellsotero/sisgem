package sisgem.db;

import java.util.List;

import sisgem.db.i.ITaskDAO;
import sisgem.model.Event;
import sisgem.model.Task;
import sisgem.model.User;
import sisgem.model.enums.TaskStatus;

public class TaskDAO implements ITaskDAO {

	@Override
	public void create(Task t) {
		//TODO 66
		
	}

	@Override
	public List<Task> listAll() {
		//TODO 67
		return null;
	}

	@Override
	public List<Task> listAllPendingByAccUser(User u) {
		//TODO 68
		return null;
	}

	@Override
	public List<Task> listAllByEvent(Event e) {
		//TODO 69
		return null;
	}

	@Override
	public List<Task> listAllByStatus(TaskStatus ts) {
		//TODO 70
		return null;
	}

	@Override
	public Task findByCode(int code) {
		//TODO 71
		return null;
	}

	@Override
	public List<Task> update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> delete() {
		// TODO Auto-generated method stub
		return null;
	}

}
