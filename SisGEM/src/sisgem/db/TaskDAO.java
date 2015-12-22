package sisgem.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.Date;
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
		
		String sql = "INSERT INTO tb_task(cd_task_type, "
					+ "ds_task, dt_target, dt_completed, "
					+ "cd_task_status, cd_event, cd_creator, "
					+ "cd_evaluator, cd_accountable, cd_provider, "
					+ "cd_artist, cd_material)"
					+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try
		{
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, t.getType().ordinal());
			stmt.setString(2, t.getDescription());
			Date date = Date.from(t.getTargetDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
			stmt.setDate(3, new java.sql.Date(date.getTime()));
			Date date2 = Date.from(t.getCompletedDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
			stmt.setDate(4, new java.sql.Date(date2.getTime()));
			stmt.setInt(5, t.getStatus().ordinal());
			stmt.setInt(6, t.getEvent().getCode());
			stmt.setInt(7, t.getCreator().getCode());
			stmt.setInt(8, t.getEvaluator().getCode());
			stmt.setInt(9, t.getProvider().getCode());
			stmt.setInt(10, t.getArtist().getCode());
			stmt.setInt(11, t.getMaterial().getCode());
			
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