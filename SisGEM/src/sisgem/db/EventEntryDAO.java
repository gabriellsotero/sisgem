package sisgem.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sisgem.db.i.IEventEntryDAO;
import sisgem.model.Event;
import sisgem.model.EventEntry;
import sisgem.model.enums.EventEntryTypes;

public class EventEntryDAO implements IEventEntryDAO {

	@Override
	public void create(EventEntry e) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		
		String sql = "INSERT INTO tb_event_entry(cd_event_entry_type, ds_event_entry, "
				+ "vl_event_entry, qt_event_entry, cd_event) VALUES (?, ?, ?, ?, ?);";
		
		try
		{
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1,e.getType().ordinal());
			stmt.setString(2, e.getDescription());
			stmt.setFloat(3,e.getValue());
			stmt.setInt(4, e.getQty());
			stmt.setInt(5, e.getEvent().getCode());
			
			stmt.executeUpdate();			
		}		
		catch (SQLException ex)
		{
			System.err.println(this.getClass() + " " + ex.getMessage());
		}
		
		finally
		{
			Connect.close(conn, stmt, null);
		}
		
	}

	@Override
	public List<EventEntry> listAllByEvent(int eventCode) {

		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM tb_event_entry "
				+ "NATURAL JOIN tb_event_entry_type "
				+ "WHERE cd_event = ?";
		
		List<EventEntry> lst = new ArrayList<EventEntry>();
		
		try
		{
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, eventCode);
	
			rs = stmt.executeQuery();		
		
			while (rs.next())
			{
				
				EventEntryTypes type = EventEntryTypes.values()[rs.getInt("cd_event_entry_type")];			
				EventDAO eventDAO = new EventDAO();
				Event e = eventDAO.findByCode(rs.getInt("cd_event"));
				
				EventEntry ee = new EventEntry
								(rs.getInt("cd_event_entry_code"), 
								type,
								rs.getString("nm_event_entry_type"),
								rs.getFloat("vl_event_entry"),
								rs.getInt("qt_event_entry"),
								e					
								);		
				
				lst.add(ee);
			}
			
		}
		catch (SQLException ex)
		{
			System.err.println(this.getClass() + " " + ex.getMessage());
		}
	
		finally
		{
			Connect.close(conn, stmt, rs);
		}
		
		return lst;
}

	@Override
	public EventEntry findByCode(int code) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM tb_event_entry "
					+ "NATURAL JOIN tb_event_entry_type "
					+ "WHERE cd_event_entry = ?";
		
		EventEntry ee = null;
		
		try 
		{
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, code);

			rs = stmt.executeQuery();
			
			if (rs.next())
			{				
				EventEntryTypes type = EventEntryTypes.values()[rs.getInt("cd_event_entry_type")];			
				EventDAO eventDAO = new EventDAO();
				Event e = eventDAO.findByCode(rs.getInt("cd_event"));
				
				ee = new EventEntry
						(code, 
						type,
						rs.getString("nm_event_entry_type"),
						rs.getFloat("vl_event_entry"),
						rs.getInt("qt_event_entry"),
						e					
						);				
			}
			
		}
		catch (SQLException ex)
		{
			System.err.println(this.getClass() + " " + ex.getMessage());
		}

		finally
		{
			Connect.close(conn, stmt, rs);
		}
		
		return ee;
	}

	@Override
	public void update(EventEntry e) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		
		String sql = "UPDATE tb_event_entry SET cd_event_entry_type=?, ds_event_entry=?, "
				+ "vl_event_entry=?, qt_event_entry=?, cd_event=? WHERE cd_event_entry=?;";
		
		try
		{
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1,e.getType().ordinal());
			stmt.setString(2, e.getDescription());
			stmt.setFloat(3,e.getValue());
			stmt.setInt(4, e.getQty());
			stmt.setInt(5, e.getEvent().getCode());
			
			stmt.setInt(6, e.getCode());
			
			stmt.executeUpdate();			
		}		
		catch (SQLException ex)
		{
			System.err.println(this.getClass() + " " + ex.getMessage());
		}
		
		finally
		{
			Connect.close(conn, stmt, null);
		}		
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
			System.err.println(this.getClass() + " " + ex.getMessage());
		}
		
		finally
		{
			Connect.close(conn, stmt, null);
		}
		
		return;		
		
	}

}
