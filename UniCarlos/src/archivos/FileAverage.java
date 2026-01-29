package archivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase que lee un fichero de texto con números y devuelve la media
 */
public class FileAverage {
	/**
	 * Devuelve la media de los números en el fichero pasado como parametro
	 * 
	 * @param filename Nombre del archivo a leer
	 * @return Media de los números
	 */
	public static int average(String filename) {
		int sum = 0;
		int amount = 0;

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
				// Leemos el número en la linea
				try {
					sum += Integer.parseInt(linea);
					// Si se lee el número aumentamos el contador
					amount++;
				} catch (NumberFormatException e) {
					// Si no es un número lanzamos error y cerramos el archivo
					System.out.println("Error, el archivo contiene carácteres no numéricos");
					br.close();
					return 0;
				}
				// Leemos siguiente linea
				linea = br.readLine();
			}
			// Cerramos fichero
			br.close();
		} catch (IOException ioe) {
			System.out.println("Error al leer");
		}
		// Si existen números devolvemos la media, si no devolvemos 0
		if (amount > 0)
			return sum / amount;
		else
			return 0;
	}

}
