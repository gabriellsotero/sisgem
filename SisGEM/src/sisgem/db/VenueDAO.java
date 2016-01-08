package sisgem.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sisgem.db.i.IVenueDAO;
import sisgem.model.Venue;

public class VenueDAO implements IVenueDAO{

	@Override
	public void create(Venue v) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		
		String sql = "INSERT INTO tb_venue(nm_venue, ds_venue_address, "
				+ "nr_venue_maxcapacity, cd_contact, ds_venue_comment) "
				+ "VALUES (?, ?, ?, ?, ?)";
	
		try
		{
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, v.getName());
			stmt.setString(2, v.getAddress());
			stmt.setInt(3, v.getMaxCapacity());
			stmt.setInt(4, v.getContactCode());
			stmt.setString(5, v.getComment());
			
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
	public List<Venue> listAllByConcept(int conceptCode) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM tb_venue "
					+ "NATURAL JOIN tb__concept__venue"
					+ "WHERE cd_concept = ?";
		
		List<Venue> lst = new ArrayList<Venue>();

		try 
		{
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, conceptCode);

			rs = stmt.executeQuery();

			while (rs.next())
			{
				Venue v = new Venue(
							rs.getInt("cd_venue"),
							rs.getString("nm_venue"),
							rs.getString("ds_venue_address"),
							rs.getInt("nr_venue_maxcapacity"),
							rs.getInt("cd_contact"),
							rs.getString("ds_venue_comment")
						);
				
				lst.add(v);
			}

		}
		catch (SQLException e)
		{
			System.out.println(this.getClass() + " Find By Code");
			System.err.println(e.getMessage());
		}
		finally
		{
			Connect.close(conn, stmt, rs);
		}

		return lst;
	}

	@Override
	public List<Venue> listAll() {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM tb_venue "
					+ "NATURAL JOIN tb__concept__venue";
		
		List<Venue> lst = new ArrayList<Venue>();

		try 
		{
			stmt = conn.prepareStatement(sql);

			rs = stmt.executeQuery();

			while (rs.next())
			{
				Venue v = new Venue(
							rs.getInt("cd_venue"),
							rs.getString("nm_venue"),
							rs.getString("ds_venue_address"),
							rs.getInt("nr_venue_maxcapacity"),
							rs.getInt("cd_contact"),
							rs.getString("ds_venue_comment")
						);
				
				lst.add(v);
			}

		}
		catch (SQLException e)
		{
			System.out.println(this.getClass() + " Find By Code");
			System.err.println(e.getMessage());
		}
		finally
		{
			Connect.close(conn, stmt, rs);
		}

		return lst;
	}

	@Override
	public Venue findByCode(int code) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM tb_venue"
				+ "WHERE cd_venue = ?";
		
		Venue v = null;

		try 
		{
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, code);

			rs = stmt.executeQuery();

			if (rs.next())
			{
				v = new Venue(
					rs.getInt("cd_venue"),
					rs.getString("nm_venue"),
					rs.getString("ds_venue_address"),
					rs.getInt("nr_venue_maxcapacity"),
					rs.getInt("cd_contact"),
					rs.getString("ds_venue_comment")
				);
			}

		}
		catch (SQLException e)
		{
			System.out.println(this.getClass() + " Find By Code");
			System.err.println(e.getMessage());
		}
		finally
		{
			Connect.close(conn, stmt, rs);
		}

		return v;
	}

	@Override
	public void update(Venue v) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		
		String sql = "UPDATE tb_venue SET nm_venue=?, ds_venue_address=?, "
				+ "nr_venue_maxcapacity=?, cd_contact=?, ds_venue_comment=? "
				+ "WHERE cd_venue=?";
	
		try
		{
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, v.getName());
			stmt.setString(2, v.getAddress());
			stmt.setInt(3, v.getMaxCapacity());
			stmt.setInt(4, v.getContactCode());
			stmt.setString(5, v.getComment());
			
			stmt.setInt(6, v.getCode());
			
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
	public void delete(Venue v) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		
		String sql = "DELETE FROM tb_venue WHERE cd_venue = ?";
		
		try
		{
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, v.getCode());
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
