package sisgem.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sisgem.db.i.IContactDAO;
import sisgem.model.Contact;

public class ContactDAO implements IContactDAO {

	@Override
	public void create(Contact c) {

		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		
		String sql = "INSERT INTO tb_contact(nm_contact, ds_contact_position, "
				+ "ds_contact_telephone,ds_contact_email) VALUES (?, ?, ?, ?)";
		
		try
		{
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, c.getName());
			stmt.setString(2, c.getPosition());
			stmt.setString(3, c.getTelephone());
			stmt.setString(4, c.getEmail());
			
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

	@Override
	public Contact findByCode(int code) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM tb_contact";
		
		Contact c = null;

		try 
		{
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, code);

			rs = stmt.executeQuery();

			if (rs.next())
			{
				c = new Contact(
					rs.getInt("cd_contact"),
					rs.getString("nm_contact"),
					rs.getString("ds_contact_position"),
					rs.getString("ds_contact_telephone"),
					rs.getString("ds_contact_email")						
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

		return c;
	}

	@Override
	public void update(Contact c) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		
		String sql = "UPDATE tb_contact SET nm_contact=?, ds_contact_position=?, ds_contact_telephone=?, ds_contact_email=? WHERE cd_contact = ?";
		
		try
		{
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, c.getName());
			stmt.setString(2, c.getPosition());
			stmt.setString(3, c.getTelephone());
			stmt.setString(4, c.getEmail());
			
			stmt.setInt(5,  c.getCode());
			
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

	@Override
	public void delete(Contact c) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		
		String sql = "DELETE FROM tb_contact WHERE cd_contact = ?";
		
		try
		{
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, c.getCode());
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
