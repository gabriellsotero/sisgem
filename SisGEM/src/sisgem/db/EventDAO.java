package sisgem.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import sisgem.db.i.IEventDAO;
import sisgem.model.Event;

public class EventDAO implements IEventDAO {

	@Override
	public void create(Event e) {
		//TODO 022
	}

	@Override
	public Event findByCode(int code) {
		//TODO 023
		return null;
	}

	@Override
	public List<Event> listAll() {
		//TODO 024
		return null;
	}

	@Override
	public void update(Event e) {
		//TODO 025
		
	}

	@Override
	public void delete(Event e) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		
		String sql = "DELETE FROM tb_event WHERE cd_event = ?";
		
		try
		{
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, e.getCode());
			stmt.executeUpdate();		
		}
		catch (SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
		
		finally
		{
			Connect.close(conn, stmt, null);
		}
		
		return;				
	}
}
