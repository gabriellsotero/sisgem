package oompa.sisgemplus.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oompa.sisgemplus.db.i.IArtistDAO;
import oompa.sisgemplus.model.Artist;
import oompa.sisgemplus.model.ArtistEvent;

public class ArtistDAO implements IArtistDAO {

	@Override
	public void create(Artist a) {
		
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		
		String sql = "INSERT INTO tb_artist(cd_artist, nm_artist_real, nm_artist_nick, ph_artist, "
				+ "ds_artist_eventrole, cd_contact, vl_artist_avg, ds_artist_comment) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		try
		{
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(2, a.getRealName());
			stmt.setString(3,  a.getStageName());
			stmt.setBytes(4, a.getPhoto());
			stmt.setString(5, a.getArtistEventRole());
			stmt.setInt(6, a.getContactCode());
			stmt.setFloat(7, a.getAvgValue());
			stmt.setString(8, a.getComment());
			
			stmt.executeUpdate();			
		}
		catch (SQLException e)
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
	public Artist findByCode(int code) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM tb_artist "
					+ "WHERE cd_artist = ?";
		
		Artist a = null;
		
		try 
		{
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, code);
			
			rs = stmt.executeQuery();
			
			if (rs.next())
			{

				a = new Artist
						(rs.getInt("cd_artist"), 
						rs.getString("nm_artist_real"),
						rs.getString("nm_artist_nick"), 
						rs.getBytes("ph_artist"),
						rs.getString("ds_artist_eventrole"),
						rs.getInt("cd_contact"),
						rs.getFloat("vl_artist_avg"),
						rs.getString("ds_artist_comment")
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
		
		return a;
	}

	@Override
	public List<Artist> listAll() {
		
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM tb_artist ORDER BY ds_artist_eventrole asc, nm_artist_nick asc";
		
		List<Artist> lst = new ArrayList<Artist>();
				
		try 
		{
			stmt = conn.prepareStatement(sql);
			
			rs = stmt.executeQuery();
			
			while (rs.next())
			{
				Artist a = new Artist
						(rs.getInt("cd_artist"), 
						rs.getString("nm_artist_real"),
						rs.getString("nm_artist_nick"), 
						rs.getBytes("ph_artist"),
						rs.getString("ds_artist_eventrole"),
						rs.getInt("cd_contact"),
						rs.getFloat("vl_artist_avg"),
						rs.getString("ds_artist_comment")
				);
				
				lst.add(a);
						
			}
		}
		
		catch (SQLException e)
		{
			System.out.println(this.getClass() + " List All");
			System.err.println(e.getMessage());
		}
		
		finally
		{
			Connect.close(conn, stmt, rs);
		}
		
		return lst;
	}

	@Override
	public List<Artist> listAllByConcept(int conceptCode) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM tb__concept__artist "
					+ "NATURAL JOIN tb_artist "
					+ "NATURAL JOIN tb_concept "
					+ "WHERE cd_concept = ?";
		
		List<Artist> lst = new ArrayList<Artist>();
				
		try 
		{
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, conceptCode);
			
			rs = stmt.executeQuery();
			
			while (rs.next())
			{
		
				Artist a = new Artist
						(rs.getInt("cd_artist"), 
						rs.getString("nm_artist_real"),
						rs.getString("nm_artist_nick"), 
						rs.getBytes("ph_artist"),
						rs.getString("ds_artist_eventrole"),
						rs.getInt("cd_contact"),
						rs.getFloat("vl_artist_avg"),
						rs.getString("ds_artist_comment")
				);
				
				lst.add(a);
						
			}
		}
		
		catch (SQLException e)
		{
			System.out.println(this.getClass() + " List All By Concept");
			System.err.println(e.getMessage());
		}
		
		finally
		{
			Connect.close(conn, stmt, rs);
		}
		
		return lst;
	}

	@Override
	public List<ArtistEvent> listAllByEvent(int eventCode) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT tb_artist.*, tb__event__artist.* FROM tb__event__artist "
					+ "NATURAL JOIN tb_artist "
					+ "NATURAL JOIN tb_event "
					+ "WHERE cd_event = ?";
		
		List<ArtistEvent> lst = new ArrayList<ArtistEvent>();
				
		try 
		{
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, eventCode);
			
			rs = stmt.executeQuery();
			
			while (rs.next())
			{
				Artist a = new Artist
						(rs.getInt("cd_artist"), 
						rs.getString("nm_artist_real"),
						rs.getString("nm_artist_nick"), 
						rs.getBytes("ph_artist"),
						rs.getString("ds_artist_eventrole"),
						rs.getInt("cd_contact"),
						rs.getFloat("vl_artist_avg"),
						rs.getString("ds_artist_comment")
				);
										
				ArtistEvent ae = new ArtistEvent(a, rs.getFloat("vl_artist_event"));
				
				lst.add(ae);
						
			}
		}
		
		catch (SQLException e)
		{
			System.out.println(this.getClass() + " List All By Event");
			System.err.println(e.getMessage());
		}
		
		finally
		{
			Connect.close(conn, stmt, rs);
		}
		
		return lst;
	}

	@Override
	public void update(Artist a) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		
		String sql = "UPDATE tb_artist SET nm_artist_real=?, nm_artist_nick=?, ph_artist=?, "
				+ "ds_artist_eventrole=?, cd_contact=?, vl_artist_avg=?, ds_artist_comment=? WHERE cd_artist=?";
		
		try
		{
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, a.getRealName());
			stmt.setString(2,  a.getStageName());
			stmt.setBytes(3, a.getPhoto());
			stmt.setString(4, a.getArtistEventRole());
			stmt.setInt(5, a.getContactCode());
			stmt.setFloat(6, a.getAvgValue());
			stmt.setString(7, a.getComment());
			
			stmt.setInt(8, a.getCode());
			
			stmt.executeUpdate();			
		}
		catch (SQLException e)
		{
			System.out.println(this.getClass() + " Update");
			System.err.println(e.getMessage());
		}
		
		finally
		{
			Connect.close(conn, stmt, null);
		}
		
		return;
	}

	@Override
	public void delete(Artist a) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		
		String sql = "DELETE FROM tb_artist WHERE cd_artist = ?";
		
		try
		{
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, a.getCode());
			stmt.executeUpdate();		
		}
		catch (SQLException e)
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
	
	public void associateToEvent (int artistCode, int eventCode, float value)
	{
		
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		
		String sql = "UPDATE tb__event__artist SET vl_artist_event=? "
				+ "WHERE cd_artist=? AND cd_event=?";
		
		try
		{
			stmt = conn.prepareStatement(sql);
			
			stmt.setFloat(1, value);
			stmt.setInt(2, artistCode);
			stmt.setInt(3, eventCode);			
		
			stmt.executeUpdate();			
		}
		catch (SQLException e)
		{
			System.out.println(e.getClass());
			System.out.println(this.getClass() + " Associate to Event");
			e.printStackTrace();
		}
		
		finally
		{
			Connect.close(conn, stmt, null);
		}
		
		return;		
	}
	
	public void toggleConfirmInEvent (int artistCode, int eventCode, boolean confirmed)
	{
		
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		
		String sql = "UPDATE tb__event__artist SET fl_confirmed "
				+ "VALUES (?) WHERE cd_artist=? AND cd_event=?";
		
		try
		{
			stmt = conn.prepareStatement(sql);
			
			stmt.setBoolean(1, confirmed);
			stmt.setInt(2, artistCode);
			stmt.setInt(3, eventCode);
			
			stmt.executeUpdate();			
		}
		catch (SQLException e)
		{
			System.out.println(this.getClass() + " Toggle Confirm in Event");
			System.err.println(e.getMessage());
		}
		
		finally
		{
			Connect.close(conn, stmt, null);
		}
		
		return;		
	}
	
}
