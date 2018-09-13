package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Conectar {

    private Connection conn;
    private static Statement statement;
    
    public static  Conectar db;
    
    public static  Statement getStatement() {
    	return statement;
    }
    
    private Conectar() {
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            this.conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/practico","root","root");
        }
        catch (Exception sqle) {
            sqle.printStackTrace();
        }
    }
    

    public static synchronized Conectar obetenerConexion() {
        if ( db == null ) {
            db = new Conectar();
        }
        return db;
 
    }
    ///////////////////////////////////////////////////////////////
    
    
    
    public static void query(String consulta)
    {
    	
    	
    	try {
    		if (consulta.toLowerCase().trim().startsWith("select")) {
    			ResultSet rs = statement.executeQuery(consulta);

    			mostrarSelect(rs);
    			
    		} else {
    			int filasAfectadas=statement.executeUpdate(consulta);
    			System.out.printf("%s filas afectadas%n", filasAfectadas);
    			
    		}
    	}catch(SQLException e)
    	{
    		System.out.println(e.getMessage());
    		
    	}
    	
    	
    	
    }
    
    
    public  static void mostrarSelect(ResultSet rs) throws SQLException {

		ResultSetMetaData rsm = rs.getMetaData();

		System.out.println("--------------------------------------------------");
		for (int i = 0; i < rsm.getColumnCount(); i++) {
			System.out.print(rsm.getColumnName(i + 1) + "\t");
		}
		System.out.println("\n--------------------------------------------------");
		int contador = 0;
		while (rs.next()) {
			for (int i = 0; i < rsm.getColumnCount(); i++) {
				System.out.print(rs.getString(i + 1) + "\t");
			}
			System.out.println();
			contador++;
		}
		System.out.println("--------------------------------------------------");
		System.out.printf("%s filas%n", contador);
	}
}
