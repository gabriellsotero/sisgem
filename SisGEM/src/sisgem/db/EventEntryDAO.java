package sisgem.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import sisgem.db.i.IEventEntryDAO;
import sisgem.model.EventEntry;

public class EventEntryDAO implements IEventEntryDAO {

	@Override
	public void create(EventEntry e) {
		//TODO 027
	}

	@Override
	public List<EventEntry> listAllByEvent(int eventCode) {
		//TODO 028
		return null;
	}

	@Override
	public EventEntry findByCode(int code) {
		//TODO 029
		return null;
	}

	@Override
	public void update(EventEntry e) {
		//TODO 030
		
	}

	@Override
	public void delete(EventEntry e) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		
		String sql = "DELETE FROM tb_event_entry WHERE cd_event_entry = ?";
		
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
