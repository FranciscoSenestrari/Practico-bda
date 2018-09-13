package bd;

import java.sql.SQLException;
import java.util.Scanner;

public class prueba7 {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		
		Conectar.obetenerConexion();

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

				break;
			case 3:

				break;
			case 6:
				System.out.print("Adios!");
				break;
			default:
				System.out.print("Opcion no valida");
			}
		} while (op != 6);

	}

	private static void Query() throws SQLException  {

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

	private static void mostrarMenu() {
		System.out.println("Sleccione la opcion deseada>");
		System.out.println("1> Generar consulta");
		System.out.println("2> Leer de archivo");
		System.out.println("6> Salir del programa ");

	}
}
