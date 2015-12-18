package sisgem.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sisgem.db.i.IMaterialDAO;
import sisgem.model.EventOrderedAction;
import sisgem.model.Material;
import sisgem.model.MaterialConcept;
import sisgem.model.MaterialEvent;

@SuppressWarnings("unused")
public class MaterialDAO implements IMaterialDAO {

	@Override
	public void create(Material m) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		
		String sql = "INSERT INTO tb_material(nm_material, ph_material, "
					+ "ds_material_comment, nm_measure_unit) VALUES (?, ?, ?, ?)";
		
		try
		{
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, m.getName());
			stmt.setBytes(2, m.getPhoto());
			stmt.setString(3, m.getComments());
			stmt.setString(4, m.getMeasureUnit());
			
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
	public Material findByCode(int code) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM tb_material "
				+ "WHERE cd_material = ?";
		
		Material m = null;

		try 
		{
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, code);

			rs = stmt.executeQuery();
			
			if (rs.next())
			{
				m = new Material(
						code,
						rs.getString("nm_material"),
						rs.getBytes("ph_material"),
						rs.getString("ds_material_comment"),
						rs.getString("nm_measure_unit")						
				);				
			}
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}

		finally
		{
			Connect.close(conn, stmt, rs);
		}
		
		return m;			
	}

	@Override
	public List<MaterialConcept> listAllByConcept(int conceptCode) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM tb__concept__material "
				+ "NATURAL JOIN tb_material "
				+ "NATURAL JOIN tb_concept "
				+ "WHERE cd_concept = ?";
		
		List<MaterialConcept> lst =  new ArrayList<MaterialConcept>();

		try 
		{
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, conceptCode);

			rs = stmt.executeQuery();
			
			while (rs.next())
			{
				Material m = new Material(
								rs.getInt("cd_material"),
								rs.getString("nm_material"),
								rs.getBytes("ph_material"),
								rs.getString("ds_material_comment"),
								rs.getString("nm_measure_unit")
				);
				
				MaterialConcept mc = new MaterialConcept(m, rs.getInt("qt_material"));
						
				lst.add(mc);
			}
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}

		finally
		{
			Connect.close(conn, stmt, rs);
		}
		
		return lst;
	}

	@Override
	public List<MaterialEvent> listAllByEvent(int eventCode) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM tb__event__material "
				+ "NATURAL JOIN tb_material "
				+ "NATURAL JOIN tb_event "
				+ "WHERE cd_event = ?";
		
		List<MaterialEvent> lst =  new ArrayList<MaterialEvent>();

		try 
		{
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, eventCode);

			rs = stmt.executeQuery();
			
			while (rs.next())
			{
				Material m = new Material(
								rs.getInt("cd_material"),
								rs.getString("nm_material"),
								rs.getBytes("ph_material"),
								rs.getString("ds_material_comment"),
								rs.getString("nm_measure_unit")
				);
				
				MaterialEvent me = new MaterialEvent(m, rs.getInt("qt_material"), rs.getFloat("vl_material_event"));
						
				lst.add(me);
			}
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}

		finally
		{
			Connect.close(conn, stmt, rs);
		}
		
		return lst;
	}

	@Override
	public List<Material> listAll() {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM tb_material";
		
		List<Material> lst =  new ArrayList<Material>();

		try 
		{
			stmt = conn.prepareStatement(sql);
	
			rs = stmt.executeQuery();
			
			while (rs.next())
			{
				Material m = new Material(
								rs.getInt("cd_material"),
								rs.getString("nm_material"),
								rs.getBytes("ph_material"),
								rs.getString("ds_material_comment"),
								rs.getString("nm_measure_unit")
				);
				
				lst.add(m);
			}
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}

		finally
		{
			Connect.close(conn, stmt, rs);
		}
		
		return lst;
	}

	@Override
	public void update(Material m) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		
		String sql = "UPDATE tb_material SET nm_material=?, ph_material=?, "
				+ "ds_material_comment=?, nm_measure_unit=? WHERE cd_material=?";
		
		try
		{
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, m.getName());
			stmt.setBytes(2, m.getPhoto());
			stmt.setString(3, m.getComments());
			stmt.setString(4, m.getMeasureUnit());
			
			stmt.setInt(5, m.getCode());
			
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
	public void delete(Material m) {
		Connection conn = Connect.connect();
		PreparedStatement stmt = null;
		
		String sql = "DELETE FROM tb_material WHERE cd_material = ?";
		
		try
		{
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, m.getCode());
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
