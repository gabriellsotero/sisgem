package sisgem.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import sisgem.db.i.IUserDAO;
import sisgem.model.Task;
import sisgem.model.User;
import sisgem.model.enums.TaskStatus;
import sisgem.model.enums.UserProfiles;

public class UserDAO implements IUserDAO {

	@Override
	public void create(User u) {
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
			System.err.println(this.getClass() + " " + e.getMessage());
		}
		
		finally
		{
			Connect.close(conn, stmt, null);
		}	
	}

	@Override
	public List<User> listAll() {
		//TODO 073
		return null;
	}

	@Override
	public User findByCode(int code) {
		//TODO 074
		return null;
	}

	@Override
	public User findByLogin(String login) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM tb_user "
					+ "NATURAL JOIN tb_user_profile "
					+ "WHERE ds_user_login = ?";
			
		User u = null;
		
		try 
		{
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, login);
			
			rs = stmt.executeQuery();			
			
			if (rs.next())
			{
				
				UserProfiles profile = UserProfiles.values()[rs.getInt("cd_user_profile")];
				
				u = new User(
						rs.getInt("cd_user"),
						rs.getString("nm_user"),
						rs.getBytes("ph_user"),
						login,
						rs.getString("ds_user_password"),
						rs.getString("ds_user_salt"),
						rs.getString("ds_user_email"),
						profile,
						rs.getString("nm_user_profile")
				);
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
		
		return u;
		
	}

	@Override
	public void update(User u) {
		//TODO 076		
	}

	@Override
	public void delete(User u) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		
		String sql = "DELETE FROM tb_user WHERE cd_user = ?";
		
		try
		{
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, u.getCode());
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
