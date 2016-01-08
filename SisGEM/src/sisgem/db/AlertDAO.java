package sisgem.db;

import java.sql.*;
import java.lang.Exception;
import java.time.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import sisgem.db.i.IAlertDAO;
import sisgem.model.*;
import sisgem.model.enums.AlertTypes;

public class AlertDAO implements IAlertDAO {

	@Override
	public void create(Alert a) {
		
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		
		String sql = "INSERT INTO tb_alert(ds_alert, dt_alert, fl_read, cd_user, cd_alert_type, cd_task, cd_concept) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		try
		{
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, a.getDescription());
			Instant instant = a.getDate().toInstant(ZoneOffset.UTC);
		    Date date = Date.from(instant);
			stmt.setDate(2, new java.sql.Date(date.getTime()));
			stmt.setBoolean(3, a.isRead());
			stmt.setInt(4, a.getUserCode());
			stmt.setInt(5, a.getType().ordinal());
			stmt.setInt(6, a.getTaskCode());
			stmt.setInt(7, a.getConceptCode());
			stmt.executeUpdate();
		}
		
		catch (Exception e)
		{
			System.out.println(this.getClass() + " Create");
			System.err.println(e.getMessage());
		}
		
		finally
		{
			Connect.close(conn, stmt, null);
		}
		
		return;
		
	}

	@Override
	public Alert findByCode(int code) 
	{
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM tb_alert "
					+ "NATURAL JOIN tb_alert_type "
					+ "WHERE cd_alert = ?";
		
		Alert a = null;
		
		try 
		{
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, code);
			
			rs = stmt.executeQuery();
			
			if (rs.next())
			{
				AlertTypes types = AlertTypes.values()[rs.getInt("cd_alert_type")];
				
				Instant instant = Instant.ofEpochMilli(rs.getDate("dt_alert").getTime());
			    LocalDateTime ldt = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);

				a = new Alert(
						rs.getInt("cd_alert"), 
						rs.getString("ds_alert"),
						ldt,
						rs.getBoolean("fl_read"),
						rs.getInt("cd_user"),
						types,
						rs.getString("nm_alert_type"),
						rs.getInt("cd_task"),
						rs.getInt("cd_concept")
				);
						
			}
		}
		
		catch (Exception e)
		{
			System.out.println(this.getClass() + " Find By Code");
			System.err.println(e.getMessage());
		}		
		finally
		{
			Connect.close(conn, stmt, rs);
		}
		
		return a;
	}

	@Override
	public List<Alert> listAllByUser(int userCode) {

		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM tb_alert "
				+ "NATURAL JOIN tb_alert_type "
				+ "WHERE cd_user = ?";
		
		List<Alert> lst = new ArrayList<Alert>();
		
		try 
		{
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, userCode);
			
			rs = stmt.executeQuery();
			
			while (rs.next())
			{
				AlertTypes types = AlertTypes.values()[rs.getInt("cd_alert_type")];
						
				Instant instant = Instant.ofEpochMilli(rs.getDate("dt_alert").getTime());
			    LocalDateTime ldt = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);

				Alert a = new Alert(
						rs.getInt("cd_alert"), 
						rs.getString("ds_alert"),
						ldt,
						rs.getBoolean("fl_read"),
						rs.getInt("cd_user"),
						types,
						rs.getString("nm_alert_type"),
						rs.getInt("cd_task"),
						rs.getInt("cd_concept")
				);
				
				lst.add(a);						
			}
		}
		
		catch (Exception e)
		{
			System.out.println(this.getClass() + " List All By User");
			System.err.println(e.getMessage());
		}
		
		finally
		{
			Connect.close(conn, stmt, rs);
		}
		
		return lst;		
	}
	
	@Override
	public void update(Alert a) {
		
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;

		String sql = "UPDATE tb_alert SET ds_alert=?, dt_alert=?, fl_read=?, cd_user=?, "
					+ "cd_alert_type=?, cd_task=?, cd_concept=? WHERE cd_alert=?";
		
		try
		{
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, a.getDescription());
			Instant instant = a.getDate().toInstant(ZoneOffset.UTC);
		    Date date = Date.from(instant);
			stmt.setDate(2, new java.sql.Date(date.getTime()));
			stmt.setBoolean(3, a.isRead());
			stmt.setInt(4, a.getUserCode());
			stmt.setInt(5, a.getType().ordinal());
			stmt.setInt(6, a.getTaskCode());
			stmt.setInt(7, a.getConceptCode());
			stmt.setInt(8, a.getCode());
			
			stmt.executeUpdate();
		}
		
		catch (Exception e)
		{
			System.out.println(this.getClass() + " Update");
			System.err.println(e.getMessage());
		}
		
		finally
		{
			Connect.close(conn, stmt, null);
		}
	}

	@Override
	public void delete(Alert a) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		
		String sql = "DELETE FROM tb_alert WHERE cd_alert = ?";
		
		try
		{
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, a.getCode());
			stmt.executeUpdate();		
		}
		catch (Exception e)
		{
			System.out.println(this.getClass() + " Delete");
			System.err.println(e.getMessage());
		}
		
		finally
		{
			Connect.close(conn, stmt, null);
		}
		
		return;				
	}

}
