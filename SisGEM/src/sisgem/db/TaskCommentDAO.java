package sisgem.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import sisgem.db.i.ITaskCommentDAO;
import sisgem.model.TaskComment;

public class TaskCommentDAO implements ITaskCommentDAO{

	@Override
	public void create(TaskComment t) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		
		String sql = ""; //TODO
		
		try
		{
			stmt = conn.prepareStatement(sql);
			
			//TODO
			
			stmt.executeUpdate();
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
		finally
		{
			Connect.close(conn, stmt, null);
		}	
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
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		
		String sql = "DELETE FROM tb_task_comment WHERE cd_task_comment = ?";
		
		try
		{
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, t.getCode());
			stmt.executeUpdate();		
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
		finally
		{
			Connect.close(conn, stmt, null);
		}
		
		return;		
	}
}
