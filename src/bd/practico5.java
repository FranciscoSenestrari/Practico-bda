package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class practico5 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver");
        Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/practico","root","root");
        
        
        
        cn.createStatement().executeUpdate("DROP TABLE  IF EXISTS temporal");

        cn.createStatement().executeUpdate("CREATE  TABLE  temporal (c1 INT,c2 VARCHAR(20))");
        
        cn.setAutoCommit(false);
        PreparedStatement pst = cn.prepareStatement(" INSERT INTO temporal (c1, c2) VALUES (?,?)");
        
        for(int t=0;t<10;t++)
        {
        	pst.setInt(1, t+1);
        	pst.setString(2, "fila "+(t+1));
        	pst.execute();
        }
        if(Math.random()<0.5)
        {
        	cn.commit();
        	System.out.println("COMMIT");
        }else {
        	cn.rollback();
        	System.out.println("ROLLBACK");
        }
        
        ResultSet rs = cn.createStatement().executeQuery("SELECT * FROM temporal");
       
        bd.prueba2.mostrarSelect(rs);

        // crear exit prueba 3 
	}
	

}
