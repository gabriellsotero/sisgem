package sisgem.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Connect {
	
	public static Connection connect ()
	{
	      Connection c = null;
	      try 
	      {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	            .getConnection("jdbc:postgresql://localhost:5432/sisgem",
	            "postgres", "sisgem#123");
	      } 
	      
	      catch (Exception e) 
	      {
	    	  return null;
	      }
	      
	      return c;
	}
	
	public static void close (Connection conn, PreparedStatement stmt, ResultSet rs)
	{
	    try { if (rs != null) rs.close(); } catch (Exception e) {};
	    try { if (stmt != null) stmt.close(); } catch (Exception e) {};
	    try { if (conn != null) conn.close(); } catch (Exception e) {};
	}
}

