package bd;

import java.sql.SQLException;
import java.util.Scanner;

public class test3 {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

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

}
