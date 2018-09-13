package bd;
import java.awt.SystemColor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.sun.prism.paint.Color;

public class testFile {

	public static void main(String[] args) throws IOException{
	
		BufferedReader reader = new BufferedReader(new FileReader("D://Facu//Tercero 2018//BDA//BD Practico//Base de datos aplicada//comando.sql"));
		String linea = "";
		String query = ""; 
		StringBuilder sb = new StringBuilder();

		try {
			while ((linea = reader.readLine()) != null) {
				
				sb.append(linea);
			}
			
			query = sb.substring(sb.indexOf(";"),sb.indexOf(";"));
			
			
			
			System.out.println(query);
		} catch (IOException e) {
			e.printStackTrace();
		}
		reader.close();
		    
		
	}
}
	
