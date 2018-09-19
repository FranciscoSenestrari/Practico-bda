package bd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.sun.prism.paint.Color;

public class testFile {

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		Connection cn = null;
		Statement stm = null;
		try {
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practico", "root", "root");
			stm = cn.createStatement();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		fromFile(stm);

	}

	
	public static void fromFile(Statement stm) throws IOException {

		BufferedReader reader = new BufferedReader(
				new FileReader("D://Facu//Tercero 2018//BDA//BD Practico//Base de datos aplicada//comando.sql"));
		String linea = "";
		String temp = "";

		StringBuilder sb = new StringBuilder();

		try {
			while ((linea = reader.readLine()) != null) {

				sb.append(linea);

			}

			temp = sb.toString();

			temp.split("[\n]");
			String[] sd = temp.split(";");

			for (String g : sd) {
				if (g.trim().length() > 0 && !g.trim().startsWith("#")) {
					System.out.printf("Ejecutando: %s%n", g);
					if (stm.execute(g + ";")) {
						prueba2.mostrarSelect(stm.getResultSet());

					} else {
						stm.executeUpdate(g + ";");
					}

				}

			}

		} catch (IOException | SQLException e) {
			System.out.println(e.getMessage());
		}
		reader.close();
	}

}
