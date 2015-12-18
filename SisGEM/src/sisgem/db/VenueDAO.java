package sisgem.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import sisgem.db.i.IVenueDAO;
import sisgem.model.Venue;

public class VenueDAO implements IVenueDAO{

	@Override
	public void create(Venue v) {
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
	public List<Venue> listAllByConcept(int conceptCode) {
		//TODO 079
		return null;
	}

	@Override
	public List<Venue> listAll() {
		//TODO 080
		return null;
	}

	@Override
	public Venue findByCode(int code) {
		//TODO 081
		return null;
	}

	@Override
	public void update(Venue v) {
		//TODO 082		
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
