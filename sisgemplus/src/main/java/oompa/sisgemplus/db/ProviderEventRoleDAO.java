package oompa.sisgemplus.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oompa.sisgemplus.db.i.IProviderEventRoleDAO;
import oompa.sisgemplus.model.ProviderEventRole;
import oompa.sisgemplus.model.ProviderEventRoleConcept;

public class ProviderEventRoleDAO implements IProviderEventRoleDAO {

	@Override
	public void create(ProviderEventRole p) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		
		String sql = "INSERT INTO tb_provider_eventrole(nm_provider_eventrole) VALUES (?)";
		
		try
		{
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, p.getName());
			
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
	public ProviderEventRole findByCode(int code) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM tb_provider_eventrole "
				+ "WHERE cd_provider_eventrole = ?";
		
		ProviderEventRole p = null;

		try 
		{
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, code);

			rs = stmt.executeQuery();
			
			if (rs.next())
			{
				p = new ProviderEventRole(
						code, 
						rs.getString("nm_provider_eventrole")
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
	public List<ProviderEventRoleConcept> listAllByConcept(int conceptCode) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM tb__concept__provider_eventrole "
					+ "NATURAL JOIN tb_provider_eventrole "
					+ "NATURAL JOIN tb_concept "
					+ "WHERE cd_concept = ?";
		
		List<ProviderEventRoleConcept> lst = new ArrayList<ProviderEventRoleConcept>();

		try 
		{
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, conceptCode);

			rs = stmt.executeQuery();
			
			while (rs.next())
			{
				ProviderEventRole p = new ProviderEventRole(
											rs.getInt("cd_provider_eventrole"), 
											rs.getString("nm_provider_eventrole")
				);
				
				ProviderEventRoleConcept pc = new ProviderEventRoleConcept(p, rs.getInt("qt_provider_eventrole"));
				
				lst.add(pc);
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
	public List<ProviderEventRole> listAll() {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM tb_provider_eventrole ORDER BY nm_provider_eventrole asc";
		
		List<ProviderEventRole> lst = new ArrayList<ProviderEventRole>();

		try 
		{
			stmt = conn.prepareStatement(sql);

			rs = stmt.executeQuery();
			
			while (rs.next())
			{
				ProviderEventRole p = new ProviderEventRole(
											rs.getInt("cd_provider_eventrole"), 
											rs.getString("nm_provider_eventrole")
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
	public void update(ProviderEventRole p) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		
		String sql = "UPDATE tb_provider_eventrole SET nm_provider_eventrole=? WHERE cd_provider_eventrole=?";
		
		try
		{
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, p.getName());
			
			stmt.setInt(2, p.getCode());
			
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
	public void delete(ProviderEventRole p) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		
		String sql = "DELETE FROM tb_provider_eventrole WHERE cd_provider_eventrole = ?";
		
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
