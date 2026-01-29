package archivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountLines {

	public static void count(String filename) {
		// Contador de lineas
		int counter = 0;
		// En try catch por si hay error de lectura
		try {
			// Cargamos el buffer
			BufferedReader br = new BufferedReader(new FileReader(filename));
			// Leemos la primera linea
			String linea = br.readLine();
			// Mientras quedan lineas
			while (linea != null) {
				// Mostramos la última linea
				System.out.println(linea);
				// Aumentamos el contador
				counter++;
				// Leemos siguiente linea
				linea = br.readLine();
			}
			// Cerramos fichero
			br.close();
		} catch (IOException ioe) {
			System.out.println("Error al leer");
		}
		// Mostramos las lineas
		System.out.printf("El archivo contiene %d líneas%n", counter);
	}

}
