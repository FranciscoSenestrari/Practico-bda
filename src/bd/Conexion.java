package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;






public final class Conexion {
	
	    private Connection conn;
	    private static Statement statement;
	    
	    public static  Conexion db;
	    
	    public static  Statement getStatement() {
	    	return statement;
	    }
	    
	    private Conexion() {
	        
	        try {
	            Class.forName("com.mysql.jdbc.Driver").newInstance();
	            this.conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/practico","root","root");
	        }
	        catch (Exception sqle) {
	            sqle.printStackTrace();
	        }
	    }
	   
	    public static synchronized Conexion obetenerConexion() {
	        if ( db == null ) {
	            db = new Conexion();
	        }
	        return db;
	 
	    }
	
	    public static  ResultSet query(String query) throws SQLException{
	        statement = db.conn.createStatement();
	        ResultSet res = statement.executeQuery(query);
	        return res;
	    }
	
	    
	    public static int insert(String insertQuery) throws SQLException {
	        statement = db.conn.createStatement();
	        int result = statement.executeUpdate(insertQuery);
	        return result;
	 
	    }
	    
	    
	    
	    
	    
	    public static void consultar(String sql) throws SQLException
	    {
	    	if (sql.toLowerCase().trim().startsWith("select")) 
	    	{
	    		mostrarSelect(query(sql));
	    		
	    	}
	    	else
	    	{
	    		
	    		System.out.println("Filas afectadas: ["+insert(sql)+"]");
	    		
	    	}
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    public static void mostrarSelect(ResultSet rs) throws SQLException {

			ResultSetMetaData rsm = rs.getMetaData();

			System.out.println("--------------------------------------------------");
			for (int i = 0; i < rsm.getColumnCount(); i++) {
				System.out.print("|\t"+rsm.getColumnName(i + 1) + "\t|\t");
			}
			System.out.println("\n--------------------------------------------------");
			int contador = 0;
			while (rs.next()) {
				for (int i = 0; i < rsm.getColumnCount(); i++) {
					System.out.print("|\t"+rs.getString(i + 1) + "\t|\t");
				}
				System.out.println();
				contador++;
			}
			System.out.println("--------------------------------------------------");
			System.out.printf("%s filas%n", contador);
		}
	 
	}

