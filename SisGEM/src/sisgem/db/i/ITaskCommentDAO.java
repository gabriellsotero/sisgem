package sisgem.db.i;

import java.util.List;

import sisgem.model.TaskComment;

public interface ITaskCommentDAO {
	
	/* CREATE */
	public void create(TaskComment t);
	
	/* RETRIEVE */
	public List<TaskComment> listAllByTask(int taskCode);
	
	/* UPDATE */
	public void update(TaskComment t);
	
	/* DELETE */
	public void delete(TaskComment t);

}
