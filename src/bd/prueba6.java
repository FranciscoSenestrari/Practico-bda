package bd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class prueba6 {

	public static void main(String[] args) throws SQLException, IOException {
		// TODO Auto-generated method stub

		Conexion.obetenerConexion();

		Scanner menuScanner;

		int op = 0;
		do {
			mostrarMenu();
			menuScanner = new Scanner(System.in);//
			op = (int) menuScanner.nextInt();

			switch (op) {
			case 1:
				QuerySelect();
				break;
			case 2:
				QueryInsert();
				break;
			case 3:
				ReadFile();
				break;
			case 6:
				System.out.print("Adios!");
				break;
			default:
				System.out.print("Opcion no valida");
			}
		} while (op != 6);

	}

	private static void ReadFile() throws SQLException, IOException {
		BufferedReader reader = new BufferedReader(new FileReader("D://Facu//Tercero 2018//BDA//BD Practico//Base de datos aplicada//comando.sql"));
		String linea = "";
		String query = ""; 
		StringBuilder stringBuilder = new StringBuilder();

		try {
			while ((linea = reader.readLine()) != null) {
				
				query += linea; 
			//	Conexion.insert(linea);
			//	stringBuilder.append(linea);
				
				
			}
			
				//Conexion.insert(query);

			System.out.println(query);
		} catch (IOException e) {
			e.printStackTrace();
		}
		reader.close();

	}

	private static void QuerySelect() {
		Scanner s;
		String sql = "";
		Boolean a = false;
		

		System.out.println(" ************************************************");
		System.out.println("|\t\t<<Query Select>>\t\t|");
		System.out.println(" ************************************************");
		System.out.println("|<<Escriba exit para salir al menu principal>>|");


		do {
			s = new Scanner(System.in);//
			System.out.print("sql>");
			sql = s.nextLine();

			if (!sql.equals("exit")) {
				try {
					Conexion.mostrarSelect(Conexion.obetenerConexion().query(sql + " ;"));

				} catch (SQLException e) {
				
					System.out.println(e.getMessage());
				}
			} else {
				a = true;
			}
		} while (!a);

	}

	private static void QueryInsert() {
		Scanner s;
		String sql = "";
		Boolean a = false;
		System.out.println(" ************************************************");
		System.out.println("|\t\t<<Query Select>>\t\t|");
		System.out.println(" ************************************************");
		System.out.println("|<<Escriba exit para salir al menu principal>>|");;
		do {
			s = new Scanner(System.in);//
			System.out.print("sql>");
			sql = s.nextLine();

			if (!sql.equals("exit")) {
			} else {
				a = true;

			}
		} while (!a);

	}

	private static void mostrarMenu() {
		System.out.println("Sleccione la opcion deseada>");
		System.out.println("1> Select Query");
		System.out.println("2> Insert Query");
		System.out.println("3> Leer de archivo");
		System.out.println("6> Salir del programa ");

	}

}
