package oompa.sisgemplus.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import oompa.sisgemplus.db.i.IConceptDAO;
import oompa.sisgemplus.model.*;
import oompa.sisgemplus.model.enums.ConceptStatus;

public class ConceptDAO implements IConceptDAO{

	@Override
	public void create(Concept c) {
		
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		
		String sql = "INSERT INTO tb_concept(nm_concept, ds_concept, ds_concept_comment, "
				+ "dt_concept_created, cd_concept_status, cd_creator) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		
		try
		{
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, c.getName());
			stmt.setString(2, c.getDescription());
			stmt.setString(3, c.getComment());
			Date date = Date.from(c.getCreatedDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
			stmt.setDate(4, new java.sql.Date(date.getTime()));
			stmt.setInt(5, c.getStatus().ordinal());
			stmt.setInt(6, c.getCreatorCode());
			
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
		
	}

	@Override
	public Concept findByCode(int code) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM tb_concept "
					+ "NATURAL JOIN tb_concept_status "
					+ "WHERE cd_concept = ?";
		
		Concept c = null;
		
		try 
		{
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, code);
			
			rs = stmt.executeQuery();
			
			if (rs.next())
			{
				Date d = rs.getDate("dt_concept_created");
				LocalDate ld = Instant.ofEpochMilli(d.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
				
				ConceptStatus status = ConceptStatus.values()[rs.getInt("cd_concept_status")];
				
				c = new Concept(
						rs.getInt("cd_concept"),
						rs.getString("nm_concept"),
						rs.getString("ds_concept"),
						rs.getString("ds_concept_comment"),
						ld,
						status,
						rs.getString("nm_concept_status"), 
						rs.getInt("cd_creator"),
						rs.getInt("cd_evaluator")
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
		
		return c;
			
	}

	@Override
	public List<Concept> findAll() {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM tb_concept, tb_concept_status "
					+ "WHERE tb_concept.cd_concept_status = tb_concept_status.cd_concept_status "
					+ "ORDER BY dt_concept_created desc ";
		
		List<Concept> lst = new ArrayList<Concept>();
		
		try 
		{
			stmt = conn.prepareStatement(sql);
				
			rs = stmt.executeQuery();
			
			while (rs.next())
			{
				Date d = rs.getDate("dt_concept_created");
				LocalDate ld = Instant.ofEpochMilli(d.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
				
				ConceptStatus status = ConceptStatus.values()[rs.getInt("cd_concept_status")];
				
				Concept c = new Concept(
						rs.getInt("cd_concept"),
						rs.getString("nm_concept"),
						rs.getString("ds_concept"),
						rs.getString("ds_concept_comment"),
						ld,
						status,
						rs.getString("nm_concept_status"), 
						rs.getInt("cd_creator"),
						rs.getInt("cd_evaluator")
				);
				
				lst.add(c);				
			}
		}
		
		catch (SQLException e)
		{
			System.out.println(this.getClass() + " Find All");
			System.err.println(e.getMessage());
		}
		
		finally
		{
			Connect.close(conn, stmt, rs);
		}
		
		return lst;
	}

	@Override
	public void update(Concept c) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		
		String sql = "UPDATE tb_concept SET nm_concept=?, ds_concept=?, ds_concept_comment=?, "
				+ "dt_concept_created=?, cd_concept_status=?, cd_creator=?, cd_evaluator=?"
				+ "WHERE cd_concept=?";
		
		try
		{
			stmt = conn.prepareStatement(sql);			

			stmt.setString(1, c.getName());
			stmt.setString(2, c.getDescription());
			stmt.setString(3, c.getComment());
			Date date = Date.from(c.getCreatedDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
			stmt.setDate(4, new java.sql.Date(date.getTime()));
			stmt.setInt(5, c.getStatus().ordinal());
			stmt.setInt(6, c.getCreatorCode());
			stmt.setInt(7, c.getEvaluatorCode());
			stmt.setInt(8, c.getCode());
			
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
	public void delete(Concept c) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		
		String sql = "DELETE FROM tb_concept WHERE cd_concept = ?";
		
		try
		{
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, c.getCode());
			stmt.executeUpdate();		
		}
		catch (SQLException e)
		{
			System.out.println(this.getClass() + " Concept");
			System.err.println(e.getMessage());
		}
		
		finally
		{
			Connect.close(conn, stmt, null);
		}
		
		return;		
	}
	
}
