package bd;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class prueba5 {

	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
///////////////////////////////////////////////////////////////////////////
		Class.forName("com.mysql.jdbc.Driver");
		Connection cn = null;
		Statement stm = null;
		try {
			 cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practico", "root", "root");
			 stm = cn.createStatement();
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	//////////////////////////////////////////////////////////////////////	
		
	//////////////////////////////////////////////////////////////////////	
		Scanner menuScanner;

		int op = 0;
		do {
			mostrarMenu();
			menuScanner = new Scanner(System.in);//
			op = (int) menuScanner.nextInt();

			switch (op) {
			case 1:
				Query();
				break;
			case 2:
				QueryFromFile(stm);
				break;

			case 6:
				System.out.print("Adios!");
				break;
			default:
				System.out.print("Opcion no valida");
			}
		} while (op != 6);
		
		
	}

	private static void Query() throws SQLException {
		Conexion.obetenerConexion();
		Scanner s;
		String sql = "";
		Boolean a = false;

		System.out.println(" ************************************************");
		System.out.println("|\t\t<<Gestor de consultas Mysql\t\t|");
		System.out.println(" ************************************************");
		System.out.println("|<<Escriba exit para salir al menu principal>>|");

		do {
			s = new Scanner(System.in);//
			System.out.print("sql>");
			sql = s.nextLine();

			if (!sql.equals("exit")) {
				Conexion.consultar(sql);
			
			} else {
				a = true;
			}
		} while (!a);
		
	}

	private static void QueryFromFile(Statement stm) throws IOException, SQLException {
		


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
					System.out.printf("Ejecutando: %s%n", g+";");
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

	private static void mostrarMenu() {
		
		System.out.println("Sleccione la opcion deseada>");
		System.out.println("1> Generar consulta");
		System.out.println("2> Leer de archivo");
		System.out.println("6> Salir del programa ");
	}

}
