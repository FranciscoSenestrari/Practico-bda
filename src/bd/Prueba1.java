package bd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Prueba1 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/practico","root","root");
        Statement stm = cn.createStatement();
        ResultSet rs=stm.executeQuery("select idzona,zona from zonas "); // rs es nuestro puntero a una fila
        
        System.out.println("________________");
        System.out.println("id Zona|Zonas");
        System.out.println("----------------");
        int count = 0;
        
    while(rs.next())
    {
     System.out.printf("%s\t%s%n", rs.getString(1),rs.getString(2)) ;// %s es que viene una cadena

        count ++;
        
	}
    System.out.println("----------------");
    System.out.printf("%s filas",count);
    System.out.println("\n----------------");


}

}
