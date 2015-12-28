package sisgem.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sisgem.db.i.IEventOrderedActionDAO;
import sisgem.model.Event;
import sisgem.model.EventOrderedAction;

public class EventOrderedActionDAO implements IEventOrderedActionDAO {

	@Override
	public void create(EventOrderedAction e) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		
		String sql = "INSERT INTO tb_event_ordered_actions(nr_event_ordered_action_order, " 
				+ "ds_event_ordered_action, cd_event) VALUES (?, ?, ?)";		
		
		try
		{
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, e.getOrder());
			stmt.setString(2, e.getDescription());
			stmt.setInt(3, e.getEvent().getCode());			
			
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
	public List<EventOrderedAction> listAllByEvent(int eventCode) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM tb_event_ordered_actions "
				+ "WHERE cd_event=?";
		
		List<EventOrderedAction> lst = new ArrayList<EventOrderedAction>();
		
		try
		{
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, eventCode);

			rs = stmt.executeQuery();	
			
			while (rs.next())
			{
				EventDAO eventDAO = new EventDAO();
				Event e = eventDAO.findByCode(rs.getInt("cd_event"));

				EventOrderedAction eoa = new EventOrderedAction
										(rs.getInt("cd_ordered_action"),
										rs.getInt("nm_ordered_action_order"),
										rs.getString("ds_event_ordered_action"),
										e
										);
				
				lst.add(eoa);					
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
	public EventOrderedAction findByCode(int code) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM tb_event_ordered_action "
				+ "WHERE cd_event_ordered_action = ?";
		
		EventOrderedAction eoa = null;
		
		try 
		{
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, code);
			
			rs = stmt.executeQuery();
			
			if (rs.next())
			{
				EventDAO eventDAO = new EventDAO();
				Event e = eventDAO.findByCode(rs.getInt("cd_event"));

				eoa = new EventOrderedAction
						(rs.getInt("cd_ordered_action"),
						rs.getInt("nm_ordered_action_order"),
						rs.getString("ds_event_ordered_action"),
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
		
		return eoa;
	}

	@Override
	public void update(EventOrderedAction e) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		
		String sql = "UPDATE tb_event_ordered_actions SET nr_event_ordered_action_order=?, "
				+ "ds_event_ordered_action=?, cd_event=? WHERE cd_event_ordered_action=?";		
		
		try
		{
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, e.getOrder());
			stmt.setString(2, e.getDescription());
			stmt.setInt(3, e.getEvent().getCode());	
			
			stmt.setInt(4, e.getCode());
			
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
	public void delete(EventOrderedAction e) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		
		String sql = "DELETE FROM tb_event_ordered_action WHERE cd_event_ordered_action = ?";
		
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
