package oompa.sisgemplus.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.lang.Exception;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import oompa.sisgemplus.db.i.IEventDAO;
import oompa.sisgemplus.model.Event;
import oompa.sisgemplus.model.enums.EventStatus;

public class EventDAO implements IEventDAO {

	@Override
	public void create(Event e) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		
		String sql = "INSERT INTO tb_event(nm_event, cd_event_venue,"
					+ "dt_event, ds_event, cd_status, "
					+ "dt_event_created, ds_event_comments, nm_event_attending, "
					+ "nm_event_paying, nm_event_fb_attendees, nm_event_birthday_lists, "
					+ "ds_event_competitors, ds_event_evaluation, cd_creator,"
					+ "cd_evaluator, cd_concept)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		
		try
		{
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, e.getName());
			stmt.setInt(2, e.getVenueCode());
			Instant instant = e.getDateTime().toInstant(ZoneOffset.UTC);
		    Date date = Date.from(instant);
			stmt.setDate(3, new java.sql.Date(date.getTime()));
			stmt.setString(4, e.getDescription());
			stmt.setInt(5, e.getStatus().ordinal());
			Date date2 = Date.from(e.getDateCreated().atStartOfDay(ZoneId.systemDefault()).toInstant());
			stmt.setDate(6, new java.sql.Date(date2.getTime()));
			stmt.setString(7, e.getComments());
			stmt.setInt(8, e.getAttending());
			stmt.setInt(9, e.getPaying());
			stmt.setInt(10, e.getFbAttendees());
			stmt.setInt(11, e.getBirthdayLists());
			stmt.setString(12, e.getCompetitors());
			stmt.setString(13, e.getEvaluation());
			stmt.setInt(14, e.getCreatorCode());
			stmt.setInt(15, e.getEvaluatorCode());
			stmt.setInt(16,  e.getOriginatorCode());
			
			stmt.executeUpdate();			
		}		
		catch (Exception ex)
		{
			System.out.println(this.getClass() + " Create");
			System.err.println(ex.getMessage());
		}
		
		finally
		{
			Connect.close(conn, stmt, null);
		}
		
	}

	@Override
	public Event findByCode(int code) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM tb_event "
					+ "NATURAL JOIN tb_event_status "
					+ "WHERE cd_event = ?";
		
		Event e = null;
		
		try 
		{
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, code);

			rs = stmt.executeQuery();
			
			if (rs.next())
			{
				Instant instant = Instant.ofEpochMilli(rs.getDate("dt_event").getTime());
			    LocalDateTime ldt = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);	
			    
			   	EventStatus status = EventStatus.values()[rs.getInt("cd_status")];
			   	
			   	Date d = rs.getDate("dt_event_created");
				LocalDate ld = Instant.ofEpochMilli(d.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
				
				e = new Event(
						rs.getInt("cd_event"),
						rs.getString("nm_event"),
						rs.getInt("cd_venue"),
						ldt,
						rs.getString("ds_event"),
						status,
						rs.getString("nm_event_status"),
						ld,
						rs.getString("ds_event_comments"),
						rs.getInt("nm_event_attending"),
						rs.getInt("nm_event_paying"),
						rs.getInt("nm_event_fb_attendees"),
						rs.getInt("nm_event_birthday_lists"),
						rs.getString("ds_event_competitors"),
						rs.getString("ds_event_evaluation"),
						rs.getInt("cd_creator"),
						rs.getInt("cd_evaluator"),
						rs.getInt("cd_concept")
					);
			}
		}

		catch (Exception ex)
		{
			System.out.println(this.getClass() + " Find By Code");
			ex.printStackTrace();
		}

		finally
		{
			Connect.close(conn, stmt, rs);
		}

		return e;		
	}

	@Override
	public List<Event> listAll() {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM tb_event, tb_event_status "
					+ "WHERE tb_event.cd_status = tb_event_status.cd_event_status";
		
		List<Event> lst = new ArrayList<Event>();
		
		try 
		{
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while (rs.next())
			{
			
				Instant instant = Instant.ofEpochMilli(rs.getDate("dt_event").getTime());
			    LocalDateTime ldt = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);	
			    
			   	EventStatus status = EventStatus.values()[rs.getInt("cd_status")];
			   	
			   	Date d = rs.getDate("dt_event_created");
				LocalDate ld = Instant.ofEpochMilli(d.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();

				Event e = new Event(
						rs.getInt("cd_event"),
						rs.getString("nm_event"),
						rs.getInt("cd_venue"),
						ldt,
						rs.getString("ds_event"),
						status,
						rs.getString("nm_event_status"),
						ld,
						rs.getString("ds_event_comments"),
						rs.getInt("nm_event_attending"),
						rs.getInt("nm_event_paying"),
						rs.getInt("nm_event_fb_attendees"),
						rs.getInt("nm_event_birthday_lists"),
						rs.getString("ds_event_competitors"),
						rs.getString("ds_event_evaluation"),
						rs.getInt("cd_creator"),
						rs.getInt("cd_evaluator"),
						rs.getInt("cd_concept")
					);
				
				lst.add(e);
			}
		}

		catch (Exception ex)
		{
			System.out.println(this.getClass() + " List All");
			System.err.println(ex.getMessage());
		}

		finally
		{
			Connect.close(conn, stmt, rs);
		}

		return lst;	
	}

	@Override
	public void update(Event e) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		
		String sql = "UPDATE tb_event SET nm_event=?, cd_event_venue=?, dt_event=?, "
				+ "ds_event=?, cd_status=?, dt_event_created=?, ds_event_comments=?, "
				+ "nm_event_attending=?, nm_event_paying=?, nm_event_fb_attendees=?, "
				+ "nm_event_birthday_lists=?, ds_event_competitors=?, ds_event_evaluation=?, "
				+ "cd_creator=?, cd_evaluator=?, cd_concept=? WHERE cd_event=?";
		
		try
		{
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, e.getName());
			stmt.setInt(2, e.getVenueCode());
			Instant instant = e.getDateTime().toInstant(ZoneOffset.UTC);
		    Date date = Date.from(instant);
			stmt.setDate(3, new java.sql.Date(date.getTime()));
			stmt.setString(4, e.getDescription());
			stmt.setInt(5, e.getStatus().ordinal());
			Date date2 = Date.from(e.getDateCreated().atStartOfDay(ZoneId.systemDefault()).toInstant());
			stmt.setDate(6, new java.sql.Date(date2.getTime()));
			stmt.setString(7, e.getComments());
			stmt.setInt(8, e.getAttending());
			stmt.setInt(9, e.getPaying());
			stmt.setInt(10, e.getFbAttendees());
			stmt.setInt(11, e.getBirthdayLists());
			stmt.setString(12, e.getCompetitors());
			stmt.setString(13, e.getEvaluation());
			stmt.setInt(14, e.getCreatorCode());
			stmt.setInt(15,  e.getOriginatorCode());
			
			stmt.setInt(16, e.getCode());
			
			stmt.executeUpdate();			
		}		
		catch (Exception ex)
		{
			System.out.println(this.getClass() + " Update");
			System.err.println(ex.getMessage());
		}
		
		finally
		{
			Connect.close(conn, stmt, null);
		}		
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
		catch (Exception ex)
		{
			System.err.println(this.getClass() + " " + ex.getMessage());
		}
		
		finally
		{
			Connect.close(conn, stmt, null);
		}
		
		return;				
	}

	public String findNameByCode(int code) 
	{
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM tb_event "
					+ "NATURAL JOIN tb_event_status "
					+ "WHERE cd_event = ?";
		
		String name = null;
		
		try 
		{
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, code);

			rs = stmt.executeQuery();
			
			if (rs.next())
			{
				name = rs.getString("nm_event");
			}
		}

		catch (Exception ex)
		{
			System.out.println(this.getClass() + " Find By Code");
			ex.printStackTrace();
		}

		finally
		{
			Connect.close(conn, stmt, rs);
		}

		return name;		
	}
}
