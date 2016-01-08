package sisgem.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import sisgem.db.i.ITaskCommentDAO;
import sisgem.model.TaskComment;

public class TaskCommentDAO implements ITaskCommentDAO{

	@Override
	public void create(TaskComment t) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		
		String sql = "INSERT INTO tb_task_comment(ds_task_comment, cd_user, cd_task)  VALUES (?, ?, ?)";
		
		try
		{
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, t.getComment());
			stmt.setInt(2, t.getUserCode());
			stmt.setInt(3, t.getTaskCode());
			
			stmt.executeUpdate();
		}
		catch (SQLException e)
		{
			System.err.println(this.getClass() + " " + e.getMessage());
		}
		
		finally
		{
			Connect.close(conn, stmt, null);
		}	
	}

	@Override
	public List<TaskComment> listAllByTask(int taskCode) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM tb_task_comment "
				+ " WHERE cd_task = ?";
		
		List<TaskComment> lst = new ArrayList<TaskComment>();

		try 
		{
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, taskCode);
			
			rs = stmt.executeQuery();
			
			while (rs.next())
			{
	
				Date d = rs.getDate("dt_task_comment");
				LocalDate ld = Instant.ofEpochMilli(d.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
				
				TaskComment tc = new TaskComment(
									rs.getInt("cd_task_comment"),
									rs.getString("ds_task_comment"),
									rs.getInt("cd_user"),
									rs.getInt("cd_task"),
									ld
				);
								
					
				lst.add(tc);
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
	public void update(TaskComment t) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		
		String sql = "UPDATE tb_task_comment SET ds_task_comment=?, cd_user=?, cd_task=? WHERE cd_task_comment=?";
		
		try
		{
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, t.getComment());
			stmt.setInt(2, t.getUserCode());
			stmt.setInt(3, t.getTaskCode());
			
			stmt.setInt(4, t.getCode());
			
			stmt.executeUpdate();
		}
		catch (SQLException e)
		{
			System.err.println(this.getClass() + " " + e.getMessage());
		}
		
		finally
		{
			Connect.close(conn, stmt, null);
		}		
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
			System.err.println(this.getClass() + " " + e.getMessage());
		}
		
		finally
		{
			Connect.close(conn, stmt, null);
		}
		
		return;		
	}
}