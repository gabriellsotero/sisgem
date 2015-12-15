package sisgem.db;

import java.util.List;

import sisgem.db.i.ITaskCommentDAO;
import sisgem.model.TaskComment;

public class TaskCommentDAO implements ITaskCommentDAO{

	@Override
	public void create(TaskComment t) {
		//TODO 61		
	}

	@Override
	public List<TaskComment> listAllByTask(int taskCode) {
		//TODO 62
		return null;
	}

	@Override
	public TaskComment listAllByCode() {
		//TODO 63
		return null;
	}

	@Override
	public void update(TaskComment t) {
		//TODO 64		
	}

	@Override
	public void delete(TaskComment t) {
		//TODO 65		
	}
}
