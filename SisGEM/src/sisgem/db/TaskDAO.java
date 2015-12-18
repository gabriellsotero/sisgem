package sisgem.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import sisgem.db.i.ITaskDAO;
import sisgem.model.Event;
import sisgem.model.Task;
import sisgem.model.User;
import sisgem.model.enums.TaskStatus;

public class TaskDAO implements ITaskDAO {

	@Override
	public void create(Task t) {
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
	public List<Task> update(Task t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Task t) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		
		String sql = "DELETE FROM tb_task WHERE cd_task = ?";
		
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
