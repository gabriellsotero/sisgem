package oompa.sisgemplus.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.lang.Exception;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import oompa.sisgemplus.db.i.ITaskDAO;
import oompa.sisgemplus.model.Task;
import oompa.sisgemplus.model.enums.TaskStatus;
import oompa.sisgemplus.model.enums.TaskTypes;

public class TaskDAO implements ITaskDAO {

	@Override
	public void create(Task t) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		
		String sql = "INSERT INTO tb_task(cd_ task_type, "
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
			stmt.setInt(6, t.getEventCode());
			stmt.setInt(7, t.getCreatorCode());
			stmt.setInt(8, t.getEvaluatorCode());
			stmt.setInt(9, t.getProviderCode());
			stmt.setInt(10, t.getArtistCode());
			stmt.setInt(11, t.getMaterialCode());
			
			stmt.executeUpdate();
		}
		catch (Exception e)
		{
			System.err.println(this.getClass() + " " + e.getMessage());
		}
		
		finally
		{
			Connect.close(conn, stmt, null);
		}		
	}

	@Override
	public List<Task> listAll() {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM tb_task "
					+ "NATURAL JOIN tb_task_status "
					+ "NATURAL JOIN tb_task_type "
					+ "NATURAL JOIN tb_event "
					+ "JOIN tb_e";
			
		List<Task> lst = new ArrayList<Task>();
		
		try 
		{
			stmt = conn.prepareStatement(sql);

			rs = stmt.executeQuery();
			
			
			while (rs.next())
			{				
			   	TaskTypes type = TaskTypes.values()[rs.getInt("cd_task_type")];
			   	
			   	Date d = rs.getDate("dt_target");
				LocalDate ld = Instant.ofEpochMilli(d.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
				
			   	Date d2 = rs.getDate("dt_completed");
				LocalDate ld2 = Instant.ofEpochMilli(d2.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
				
				TaskStatus status = TaskStatus.values()[rs.getInt("cd_task_status")];
				
				Task t = new Task(rs.getInt("cd_task"),
						rs.getInt("cd_accountable"),
						rs.getInt("cd_artist"),
						rs.getInt("cd_creator"),
						rs.getInt("cd_evaluator"),
						rs.getInt("cd_event"),
						rs.getInt("cd_material"),
						rs.getInt("cd_provider"),
						status,
						type,
						rs.getString("ds_task"),
						ld,
						ld2,
						rs.getString("nm_task_status"),
						rs.getString("nm_task_type"),
						rs.getString("nm_event_name"),
						null
				);
										
				lst.add(t);
			}			
			
		}
		catch (Exception e)
		{
			System.err.println(this.getClass() + " " + e.getMessage());
		}
	
		finally
		{
			Connect.close(conn, stmt, rs);
		}
		
		return lst;
	}

	public List<Task> listAllPendingApproval() {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM tb_event, tb_task, tb_task_status, tb_task_type, tb_user "
				+ "WHERE tb_task.cd_task_status = 2 "
				+ "AND tb_task.cd_event = tb_event.cd_event "
				+ "AND tb_task.cd_task_type = tb_task_type.cd_task_type "
				+ "AND tb_task.cd_task_status = tb_task_status.cd_task_status "
				+ "AND tb_task.cd_accountable = tb_user.cd_user "
				+ "ORDER BY dt_completed asc";
		
		List<Task> lst = new ArrayList<Task>();
		
		try 
		{
			stmt = conn.prepareStatement(sql);
			
			rs = stmt.executeQuery();
						
			while (rs.next())
			{				
			   	TaskTypes type = TaskTypes.values()[rs.getInt("cd_task_type")];
			   	
			   	Date d = rs.getDate("dt_target");
				LocalDate ld = Instant.ofEpochMilli(d.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
				
			   	Date d2 = rs.getDate("dt_completed");
			   	
			   	LocalDate ld2 = null;
			   	
				if (d2 != null)
					ld2 = Instant.ofEpochMilli(d2.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
				
				TaskStatus status = TaskStatus.values()[rs.getInt("cd_task_status")];
				
				Task t = new Task(rs.getInt("cd_task"),
						rs.getInt("cd_accountable"),
						rs.getInt("cd_artist"),
						rs.getInt("cd_creator"),
						rs.getInt("cd_evaluator"),
						rs.getInt("cd_event"),
						rs.getInt("cd_material"),
						rs.getInt("cd_provider"),
						status,
						type,
						rs.getString("ds_task"),
						ld,
						ld2,
						rs.getString("nm_task_status"),
						rs.getString("nm_task_type"),
						rs.getString("nm_event"),
						rs.getString("ds_user_login")
				);
										
				lst.add(t);
			}			
			
		}
		catch (Exception e)
		{
			System.err.println(this.getClass() + " " + e.getMessage());
		}
	
		finally
		{
			Connect.close(conn, stmt, rs);
		}
		
		return lst;
	}
	
	@Override
	public List<Task> listAllPendingByAccUser(int userCode) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM tb_event, tb_task, tb_task_status, tb_task_type, tb_user "
				+ "WHERE cd_accountable = ? "
				+ "AND (tb_task.cd_task_status = 1 OR tb_task.cd_task_status = 4) "
				+ "AND tb_task.cd_event = tb_event.cd_event "
				+ "AND tb_task.cd_task_type = tb_task_type.cd_task_type "
				+ "AND tb_task.cd_task_status = tb_task_status.cd_task_status "
				+ "AND tb_task.cd_accountable = tb_user.cd_user "
				+ "ORDER BY dt_target asc";
		
		List<Task> lst = new ArrayList<Task>();
		
		try 
		{
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, userCode);

			rs = stmt.executeQuery();
						
			while (rs.next())
			{				
			   	TaskTypes type = TaskTypes.values()[rs.getInt("cd_task_type")];
			   	
			   	Date d = rs.getDate("dt_target");
				LocalDate ld = Instant.ofEpochMilli(d.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
				
			   	Date d2 = rs.getDate("dt_completed");
			   	
			   	LocalDate ld2 = null;
			   	
				if (d2 != null)
					ld2 = Instant.ofEpochMilli(d2.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
				
				TaskStatus status = TaskStatus.values()[rs.getInt("cd_task_status")];
				
				Task t = new Task(rs.getInt("cd_task"),
						rs.getInt("cd_accountable"),
						rs.getInt("cd_artist"),
						rs.getInt("cd_creator"),
						rs.getInt("cd_evaluator"),
						rs.getInt("cd_event"),
						rs.getInt("cd_material"),
						rs.getInt("cd_provider"),
						status,
						type,
						rs.getString("ds_task"),
						ld,
						ld2,
						rs.getString("nm_task_status"),
						rs.getString("nm_task_type"),
						rs.getString("nm_event"),
						rs.getString("ds_user_login")
				);
										
				lst.add(t);
			}			
			
		}
		catch (Exception e)
		{
			System.err.println(this.getClass() + " " + e.getMessage());
		}
	
		finally
		{
			Connect.close(conn, stmt, rs);
		}
		
		return lst;
	}
	
	public List<TaskTypes> listAllPendingTypesByAccUser(int userCode) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT DISTINCT tb_task_type.cd_task_type FROM tb_event, tb_task, tb_task_status, tb_task_type "
					+ "WHERE cd_accountable = ? "
					+ "AND (tb_task.cd_task_status = 1 OR tb_task.cd_task_status = 4) "
					+ "AND tb_task.cd_event = tb_event.cd_event "
					+ "AND tb_task.cd_task_type = tb_task_type.cd_task_type "
					+ "AND tb_task.cd_task_status = tb_task_status.cd_task_status";
		
		List<TaskTypes> lst = new ArrayList<TaskTypes>();
		
		try 
		{
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, userCode);

			rs = stmt.executeQuery();
						
			while (rs.next())
			{				
					lst.add(TaskTypes.values()[rs.getInt("cd_task_type")]);
			}			
			
		}
		catch (Exception e)
		{
			System.err.println(this.getClass() + " " + e.getMessage());
		}
	
		finally
		{
			Connect.close(conn, stmt, rs);
		}
		
		return lst;
	}

	@Override
	public List<Task> listAllByEvent(int eventCode) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM tb_task "
					+ "NATURAL JOIN tb_task_status "
					+ "NATURAL JOIN tb_task_type "
					+ "NATURAL JOIN tb_event"
					+ "WHERE cd_event = ?";
			
		List<Task> lst = new ArrayList<Task>();
		
		try 
		{
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, eventCode);

			rs = stmt.executeQuery();
						
			while (rs.next())
			{				
			   	TaskTypes type = TaskTypes.values()[rs.getInt("cd_task_type")];
			   	
			   	Date d = rs.getDate("dt_target");
				LocalDate ld = Instant.ofEpochMilli(d.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
				
			   	Date d2 = rs.getDate("dt_completed");
				LocalDate ld2 = Instant.ofEpochMilli(d2.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
				
				TaskStatus status = TaskStatus.values()[rs.getInt("cd_task_status")];
				
				Task t = new Task(rs.getInt("cd_task"),
						rs.getInt("cd_accountable"),
						rs.getInt("cd_artist"),
						rs.getInt("cd_creator"),
						rs.getInt("cd_evaluator"),
						rs.getInt("cd_event"),
						rs.getInt("cd_material"),
						rs.getInt("cd_provider"),
						status,
						type,
						rs.getString("ds_task"),
						ld,
						ld2,
						rs.getString("nm_task_status"),
						rs.getString("nm_task_type"),
						rs.getString("nm_event"),
						null
				);
					
					
				lst.add(t);
			}			
			
		}
		catch (Exception e)
		{
			System.err.println(this.getClass() + " " + e.getMessage());
		}
	
		finally
		{
			Connect.close(conn, stmt, rs);
		}
		
		return lst;
	}

	@Override
	public List<Task> listAllByStatus(TaskStatus ts) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM tb_task "
					+ "NATURAL JOIN tb_task_status "
					+ "NATURAL JOIN tb_task_type "
					+ "NATURAL JOIN tb_event "
					+ "WHERE cd_task_status = ?";
			
		List<Task> lst = new ArrayList<Task>();
		
		try 
		{
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, ts.ordinal());

			rs = stmt.executeQuery();
						
			while (rs.next())
			{				
			   	TaskTypes type = TaskTypes.values()[rs.getInt("cd_task_type")];
			   	
			   	Date d = rs.getDate("dt_target");
				LocalDate ld = Instant.ofEpochMilli(d.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
				
			   	Date d2 = rs.getDate("dt_completed");
				LocalDate ld2 = Instant.ofEpochMilli(d2.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
				
				TaskStatus status = TaskStatus.values()[rs.getInt("cd_task_status")];
				
				Task t = new Task(rs.getInt("cd_task"),
						rs.getInt("cd_accountable"),
						rs.getInt("cd_artist"),
						rs.getInt("cd_creator"),
						rs.getInt("cd_evaluator"),
						rs.getInt("cd_event"),
						rs.getInt("cd_material"),
						rs.getInt("cd_provider"),
						status,
						type,
						rs.getString("ds_task"),
						ld,
						ld2,
						rs.getString("nm_task_status"),
						rs.getString("nm_task_type"),
						rs.getString("nm_event"),
						null
				);
					
				lst.add(t);
			}			
			
		}
		catch (Exception e)
		{
			System.err.println(this.getClass() + " " + e.getMessage());
		}
	
		finally
		{
			Connect.close(conn, stmt, rs);
		}
		
		return lst;
	}

	@Override
	public Task findByCode(int code) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM tb_task "
					+ "NATURAL JOIN tb_task_status "
					+ "NATURAL JOIN tb_task_type "
					+ "NATURAL JOIN tb_event "
					+ "WHERE cd_task = ?";
			
		Task t = null;
		
		try 
		{
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, code);
			
			rs = stmt.executeQuery();			
			
			if (rs.next())
			{				
			   	TaskTypes type = TaskTypes.values()[rs.getInt("cd_task_type")];
			   	
			   	Date d = rs.getDate("dt_target");
				LocalDate ld = Instant.ofEpochMilli(d.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
				
			   	Date d2 = rs.getDate("dt_completed");
			   	LocalDate ld2 = null;
			   	
			   	if (d2 != null)
			   		ld2 = Instant.ofEpochMilli(d2.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
				
				TaskStatus status = TaskStatus.values()[rs.getInt("cd_task_status")];
				
				t = new Task(rs.getInt("cd_task"),
						rs.getInt("cd_accountable"),
						rs.getInt("cd_artist"),
						rs.getInt("cd_creator"),
						rs.getInt("cd_evaluator"),
						rs.getInt("cd_event"),
						rs.getInt("cd_material"),
						rs.getInt("cd_provider"),
						status,
						type,
						rs.getString("ds_task"),
						ld,
						ld2,
						rs.getString("nm_task_status"),
						rs.getString("nm_task_type"),
						rs.getString("nm_event"),
						null
				);
					
			}			
			
		}
		catch (Exception e)
		{
			System.err.println(this.getClass() + " " + e.getMessage());
		}
	
		finally
		{
			Connect.close(conn, stmt, rs);
		}
		
		return t;
	}

	@Override
	public void update(Task t) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		
		String sql = "UPDATE tb_task SET cd_task_type=?, ds_task=?, dt_target=?, dt_completed=?, "
				+ "cd_task_status=?, cd_event=?, cd_creator=?, cd_evaluator=?, cd_accountable=?, "
				+ "cd_provider=?, cd_artist=?, cd_material=?"
				+ "WHERE cd_task=?";

		
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
			stmt.setInt(6, t.getEventCode());
			stmt.setInt(7, t.getCreatorCode());
			stmt.setInt(8, t.getEvaluatorCode());
			stmt.setInt(9, t.getProviderCode());
			stmt.setInt(10, t.getArtistCode());
			stmt.setInt(11, t.getMaterialCode());
			
			stmt.setInt(12, t.getCode());
			stmt.executeUpdate();
		}
		catch (Exception e)
		{
			System.err.println(this.getClass() + " " + e.getMessage());
		}
		
		finally
		{
			Connect.close(conn, stmt, null);
		}
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
		catch (Exception e)
		{
			System.err.println(this.getClass() + " " + e.getMessage());
		}
		
		finally
		{
			Connect.close(conn, stmt, null);
		}
		
		return;	
	}

	public void completeTask(int taskCode)
	{
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		
		String sql = "UPDATE tb_task SET dt_completed=?, cd_task_status=? "
					+ "WHERE cd_task=?";	
		
		try
		{
			stmt = conn.prepareStatement(sql);
			
			Date date = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
			stmt.setDate(1, new java.sql.Date(date.getTime()));
			stmt.setInt(2, TaskStatus.PEND_APROVACAO.ordinal());
			stmt.setInt(3,taskCode);
			
			stmt.executeUpdate();
		}
		catch (Exception e)
		{
			System.err.println(this.getClass() + " " + e.getMessage());
		}
		
		finally
		{
			Connect.close(conn, stmt, null);
		}
	}

	public void approveTask(int taskCode, int approverCode) 
	{
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		
		String sql = "UPDATE tb_task SET cd_evaluator=?, cd_task_status=? "
					+ "WHERE cd_task=?";	
		
		try
		{
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, approverCode);
			stmt.setInt(2, TaskStatus.APROVADA.ordinal());
			stmt.setInt(3,taskCode);
			
			stmt.executeUpdate();
		}
		catch (Exception e)
		{
			System.err.println(this.getClass() + " " + e.getMessage());
		}
		
		finally
		{
			Connect.close(conn, stmt, null);
		}		
	}
}