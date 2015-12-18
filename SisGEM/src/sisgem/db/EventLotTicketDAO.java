package sisgem.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sisgem.db.i.IEventLotTicketDAO;
import sisgem.model.Event;
import sisgem.model.EventLotTicket;

public class EventLotTicketDAO implements IEventLotTicketDAO {

	@Override
	public void create(EventLotTicket e) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		
		String sql = "INSERT INTO tb_event_lot_ticket(nm_event_lot_ticket, vl_event_lot_ticket, "
					+ "vl_event_lot_ticket_sympla_perc, qt_event_lot_ticket, cd_event) "
					+ "VALUES (?, ?, ?, ?, ?)";
		
		try
		{
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, e.getName());
			stmt.setFloat(2, e.getValue());
			stmt.setFloat(3,e.getSympla());
			stmt.setInt(4, e.getQty());
			stmt.setInt(5, e.getEvent().getCode());
			
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
		
}

	@Override
	public List<EventLotTicket> listAllByEvent(int eventCode) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM tb_event_lot_ticket"
					+ "WHERE cd_event=?";
		
		List<EventLotTicket> lst = new ArrayList<EventLotTicket>();
		
		try 
		{
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, eventCode);

			rs = stmt.executeQuery();
			
			EventDAO eventDAO = new EventDAO();
			Event e = eventDAO.findByCode(rs.getInt("cd_event"));
			
			EventLotTicket elt = new EventLotTicket(
										eventCode,
										rs.getString("nm_event_lot_ticket"),
										rs.getFloat("vl_event_lot_ticket"),
										rs.getFloat("vl_event_lot_ticket_sympla_perc"),
										rs.getInt("qt_event_lot_ticket"),
										e
										);
			
			lst.add(elt);
		}
		catch (SQLException ex)
		{
			System.out.println(ex.getMessage());
		}

		finally
		{
			Connect.close(conn, stmt, rs);
		}
		
		return lst;
	}

	@Override
	public EventLotTicket findByCode(int code) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM tb_event_entry "
					+ "WHERE cd_event_entry = ?";
		
		EventLotTicket elt = null;
				
		try 
		{
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, code);

			rs = stmt.executeQuery();
			
			if (rs.next())
			{

				EventDAO eventDAO = new EventDAO();
				Event e = eventDAO.findByCode(rs.getInt("cd_event"));
				
				elt = new EventLotTicket(
						code,
						rs.getString("nm_event_lot_ticket"),
						rs.getFloat("vl_event_lot_ticket"),
						rs.getFloat("vl_event_lot_ticket_sympla_perc"),
						rs.getInt("qt_event_lot_ticket"),
						e
						);				
			}

		}
		catch (SQLException ex)
		{
			System.out.println(ex.getMessage());
		}

		finally
		{
			Connect.close(conn, stmt, rs);
		}
		
		return elt;
	}
	
	@Override
	public void update(EventLotTicket e) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		
		String sql = "UPDATE tb_event_lot_ticket SET nm_event_lot_ticket=?, vl_event_lot_ticket=?, "
					+ "vl_event_lot_ticket_sympla_perc=?, qt_event_lot_ticket=?, cd_event=? "
					+ "WHERE cd_event_lot_ticket = ?";
		
		try
		{
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, e.getName());
			stmt.setFloat(2, e.getValue());
			stmt.setFloat(3,e.getSympla());
			stmt.setInt(4, e.getQty());
			stmt.setInt(5, e.getEvent().getCode());
			
			stmt.setInt(6, e.getCode());
			
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
	}

	@Override
	public void delete(EventLotTicket e) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		
		String sql = "DELETE FROM tb_event_lot_ticket WHERE cd_event_lot_ticket = ?";
		
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
