package sisgem.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sisgem.db.i.ITaskCommentDAO;
import sisgem.model.Task;
import sisgem.model.TaskComment;
import sisgem.model.User;

public class TaskCommentDAO implements ITaskCommentDAO{

	@Override
	public void create(TaskComment t) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		
		String sql = "INSERT INTO tb_task_comment(ds_task_comment, cd_user, cd_task)  VALUES (?, ?, ?)"; //TODO
		
		try
		{
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, t.getComment());
			stmt.setInt(2, t.getUser().getCode());
			stmt.setInt(3, t.getTask().getCode());
			
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

		String sql = "SELECT * FROM tb_task_comment";
		
		List<TaskComment> lst = new ArrayList<TaskComment>();

		try 
		{
			stmt = conn.prepareStatement(sql);

			rs = stmt.executeQuery();
			
			while (rs.next())
			{
				UserDAO userDAO = new UserDAO();
				User u = userDAO.findByCode(rs.getInt("cd_user"));
				
				TaskDAO taskDAO = new TaskDAO();
				Task t = taskDAO.findByCode(rs.getInt("cd_task"));
				
				TaskComment tc = new TaskComment(
									rs.getInt("cd_task_comment"),
									rs.getString("ds_task_comment"),
									u,
									t
				);
								
					
				lst.add(tc);
			}		
		}
		catch (SQLException e)
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
			stmt.setInt(2, t.getUser().getCode());
			stmt.setInt(3, t.getTask().getCode());
			
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