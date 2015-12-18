package sisgem.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import sisgem.db.i.IUserDAO;
import sisgem.model.User;

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
			System.out.println(e.getMessage());
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
		//TODO 075
		return null;
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
			System.out.println(e.getMessage());
		}
		
		finally
		{
			Connect.close(conn, stmt, null);
		}
		
		return;		
	}
	

}
