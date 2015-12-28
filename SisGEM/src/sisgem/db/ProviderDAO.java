package sisgem.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sisgem.db.i.IProviderDAO;
import sisgem.model.Contact;
import sisgem.model.Provider;
import sisgem.model.ProviderEvent;
import sisgem.model.ProviderEventRole;

public class ProviderDAO implements IProviderDAO {

	@Override
	public void create(Provider p) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		
		String sql = "INSERT INTO tb_provider(nm_provider, cd_provider_eventrole, ph_provider, "
				+ "cd_contact, vl_provider_avg, ds_provider_comment) VALUES (?, ?, ?, ?, ?, ?)";
		
		try
		{
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, p.getName());
			stmt.setInt(2, p.getEventRole().getCode());
			stmt.setBytes(3, p.getPhoto());
			stmt.setInt(4, p.getContact().getCode());
			stmt.setFloat(5, p.getValue());
			stmt.setString(6, p.getName());
			
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
	public Provider findByCode(int code) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM tb_provider "
				+ "WHERE cd_provider = ?";
		
		Provider p = null;

		try 
		{
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, code);

			rs = stmt.executeQuery();
			
			if (rs.next())
			{
				ProviderEventRoleDAO providereventroleDAO = new ProviderEventRoleDAO();
				ProviderEventRole per = providereventroleDAO.findByCode(rs.getInt("cd_provider_eventrole"));
				
				ContactDAO contactDAO = new ContactDAO();
				Contact c = contactDAO.findByCode(rs.getInt("cd_contact"));
				
				p = new Provider(
						code,
						rs.getString("nm_provider"),
						per,
						rs.getBytes("ph_provider"),
						c,
						rs.getFloat("vl_provider_avg"),
						rs.getString("ds_provider_comment")							
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
		
		return p;					
	}

	@Override
	public List<ProviderEvent> listAllByEvent(int eventCode) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM tb_provider "
				+ "NATURAL JOIN tb__event__provider "
				+ "WHERE cd_event = ?";
		
		List<ProviderEvent> lst = new ArrayList<ProviderEvent>();
		
		try 
		{
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, eventCode);

			rs = stmt.executeQuery();
			
			while (rs.next())
			{			
				ProviderEventRoleDAO providereventroleDAO = new ProviderEventRoleDAO();
				ProviderEventRole per = providereventroleDAO.findByCode(rs.getInt("cd_provider_eventrole"));
				
				ContactDAO contactDAO = new ContactDAO();
				Contact c = contactDAO.findByCode(rs.getInt("cd_contact"));
				
				Provider p = new Provider(
							rs.getInt("cd_provider"),
							rs.getString("nm_provider"),
							per,
							rs.getBytes("ph_provider"),
							c,
							rs.getFloat("vl_provider_avg"),
							rs.getString("ds_provider_comment")				
						
				);
				
				ProviderEvent pe = new ProviderEvent(p, rs.getInt("vl_provider_event"));
				
				lst.add(pe);
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
	public List<Provider> listAll() {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM provider";
		
		List<Provider> lst = new ArrayList<Provider>();
		
		try 
		{
			stmt = conn.prepareStatement(sql);

			rs = stmt.executeQuery();
			
			while (rs.next())
			{			
				ProviderEventRoleDAO providereventroleDAO = new ProviderEventRoleDAO();
				ProviderEventRole per = providereventroleDAO.findByCode(rs.getInt("cd_provider_eventrole"));
				
				ContactDAO contactDAO = new ContactDAO();
				Contact c = contactDAO.findByCode(rs.getInt("cd_contact"));
				
				Provider p = new Provider(
							rs.getInt("cd_provider"),
							rs.getString("nm_provider"),
							per,
							rs.getBytes("ph_provider"),
							c,
							rs.getFloat("vl_provider_avg"),
							rs.getString("ds_provider_comment")							
				);
				
				lst.add(p);
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
	public void update(Provider p) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		
		String sql = "UPDATE tb_provider SET nm_provider=?, cd_provider_eventrole=?, ph_provider=?, "
					+ "cd_contact=?, vl_provider_avg=?, ds_provider_comment=? WHERE cd_provider=?";

		try
		{
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, p.getName());
			stmt.setInt(2, p.getEventRole().getCode());
			stmt.setBytes(3, p.getPhoto());
			stmt.setInt(4, p.getContact().getCode());
			stmt.setFloat(5, p.getValue());
			stmt.setString(6, p.getName());
			
			stmt.setInt(7, p.getCode());
			
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
	public void delete(Provider p) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		
		String sql = "DELETE FROM tb_provider WHERE cd_provider = ?";
		
		try
		{
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, p.getCode());
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
