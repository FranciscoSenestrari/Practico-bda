package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class prueba2 {

	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection cn = null;
		try {
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practico", "root", "root");
		} catch (SQLException e) {
		}
		Statement stm = null;
		try {
			stm = cn.createStatement();
		} catch (SQLException e) {
		}
		Scanner s = new Scanner(System.in);
		while (true) {
			try {
				System.out.print("sql> ");
				String sql = s.nextLine();

				if (sql.toLowerCase().trim().startsWith("select")) {
					ResultSet rs = stm.executeQuery(sql);

					mostrarSelect(rs);

				} else {
					int filasAfectadas=stm.executeUpdate(sql);
					System.out.printf("%s filas afectadas%n", filasAfectadas);
					
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static void mostrarSelect(ResultSet rs) throws SQLException {

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
