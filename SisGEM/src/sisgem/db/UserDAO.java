package sisgem.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.lang.Exception;
import java.util.ArrayList;
import java.util.List;

import sisgem.db.i.IUserDAO;
import sisgem.model.User;
import sisgem.model.enums.UserProfiles;

public class UserDAO implements IUserDAO {

	@Override
	public void create(User u) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		
		String sql = "INSERT INTO tb_user(nm_user, "
					+ "ph_user, ds_user_login, ds_user_password, "
					+ "ds_user_salt, ds_user_email, cd_user_profile) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?)";				
		try
		{
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, u.getName());
			stmt.setBytes(2, u.getPhoto());
			stmt.setString(3, u.getLogin());
			stmt.setString(4, u.getPassword());
			stmt.setString(5, u.getSalt());
			stmt.setString(6, u.getEmail());
			stmt.setInt(7, u.getProfile().ordinal());
			
			stmt.executeUpdate();
		}
		catch (Exception e)
		{
			System.out.println(this.getClass() + " Create");
			System.err.println(e.getMessage());
		}
		
		finally
		{
			Connect.close(conn, stmt, null);
		}	
	}

	@Override
	public List<User> listAll() {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM tb_user "
					+ "NATURAL JOIN tb_user_profile ";
			
		List<User> lst = new ArrayList<User>();
		
		try 
		{
			stmt = conn.prepareStatement(sql);
			
			rs = stmt.executeQuery();			
			
			if (rs.next())
			{
				
				UserProfiles profile = UserProfiles.values()[rs.getInt("cd_user_profile")];
				
				User u = new User(
						rs.getInt("cd_user"),
						rs.getString("nm_user"),
						rs.getBytes("ph_user"),
						rs.getString("ds_user_login"),
						rs.getString("ds_user_password"),
						rs.getString("ds_user_salt"),
						rs.getString("ds_user_email"),
						profile,
						rs.getString("nm_user_profile")
				);
				
				lst.add(u);
			}
			
		}
		catch (Exception e)
		{
			System.out.println(this.getClass() + " List All");
			e.printStackTrace();
		}
	
		finally
		{
			Connect.close(conn, stmt, rs);
		}
		
		return lst;
	}

	@Override
	public User findByCode(int code) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM tb_user "
					+ "NATURAL JOIN tb_user_profile "
					+ "WHERE cd_user = ?";
			
		User u = null;
		
		try 
		{
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, code);
			
			rs = stmt.executeQuery();			
			
			if (rs.next())
			{
				
				UserProfiles profile = UserProfiles.values()[rs.getInt("cd_user_profile")];
				
				u = new User(
						rs.getInt("cd_user"),
						rs.getString("nm_user"),
						rs.getBytes("ph_user"),
						rs.getString("ds_user_login"),
						rs.getString("ds_user_password"),
						rs.getString("ds_user_salt"),
						rs.getString("ds_user_email"),
						profile,
						rs.getString("nm_user_profile")
				);
			}
			
		}
		catch (Exception e)
		{
			System.out.println(this.getClass() + " Find By Login");
			e.printStackTrace();
		}
	
		finally
		{
			Connect.close(conn, stmt, rs);
		}
		
		return u;
	}

	@Override
	public String findLoginByCode(int code) 
	{
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM tb_user "
					+ "NATURAL JOIN tb_user_profile "
					+ "WHERE cd_user = ?";
			
		String login = null;
		
		try 
		{
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, code);
			
			rs = stmt.executeQuery();			
						
			if (rs.next())
			{
				login = rs.getString("ds_user_login");
			}
			
		}
		catch (Exception e)
		{
			System.out.println(this.getClass() + " Find By Login");
			e.printStackTrace();
		}
	
		finally
		{
			Connect.close(conn, stmt, rs);
		}
		
		return login;
	}
	
	@Override
	public User findByLogin(String login) 
	{
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
		catch (Exception e)
		{
			System.out.println(this.getClass() + " Find By Login");
			e.printStackTrace();		
		}	
		finally
		{
			Connect.close(conn, stmt, rs);
		}
		
		return u;
		
	}

	@Override
	public void update(User u) {
		
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		
		String sql = "UPDATE tb_user SET nm_user=?, ph_user=?, "
				+ "ds_user_login=?, ds_user_password=?, ds_user_salt=?, "
				+ "ds_user_email=?, cd_user_profile=? WHERE cd_user=?";
		
		try
		{
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, u.getName());
			stmt.setBytes(2, u.getPhoto());
			stmt.setString(3, u.getLogin());
			stmt.setString(4, u.getPassword());
			stmt.setString(5, u.getSalt());
			stmt.setString(6, u.getEmail());
			stmt.setInt(7, u.getProfile().ordinal());
			
			stmt.setInt(8, u.getCode());
		}
		catch (Exception e)
		{
			System.out.println(this.getClass() + " Update");
			e.printStackTrace();
		}
	
		finally
		{
			Connect.close(conn, stmt, null);
		}
		
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
		catch (Exception e)
		{
			System.out.println(this.getClass() + " Delete");
			System.err.println(e.getMessage());
		}
		
		finally
		{
			Connect.close(conn, stmt, null);
		}
		
		return;		
	}
}
