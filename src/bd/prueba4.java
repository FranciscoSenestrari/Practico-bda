package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class prueba4 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException {

		Class.forName("com.mysql.jdbc.Driver");
		Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practico", "root", "root");

		Scanner s = new Scanner(new File("D://Facu//Tercero 2018//BDA//BD Practico//Base de datos aplicada//comando.sql"));
		Statement stm = cn.createStatement();
		while (s.hasNextLine()) {
			String linea = s.nextLine();
			if (linea.trim().length() > 0 && !linea.trim().startsWith("#")) {
				System.out.printf("Ejecutando: %s%n", linea);
				if (stm.execute(linea)) {
					prueba2.mostrarSelect(stm.getResultSet());

				} else {
					stm.executeUpdate(linea);
				}
			}
		}
	}
}
