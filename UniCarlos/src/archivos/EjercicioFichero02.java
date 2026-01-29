package archivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * <h1>Ejercicio 2 : Media de edades</h1>
 * <p>
 * Crea una aplicación que lea un fichero de texto llamado "entrada.txt" (supón
 * que existe y contiene nombres y edades separados por comas, una por línea,
 * como "Juan,25"). Procesa los datos para calcular la edad media de las
 * personas, guárdala en un nuevo fichero "resultado.txt" junto con un mensaje
 * como "La edad media es: X.X años", y muestra por consola el contenido del
 * fichero de salida.
 * <h2>Pasos Sugeridos</h2>
 * <p>
 * Abre "entrada.txt" y lee línea por línea.
 * <p>
 * Suma las edades y cuenta las personas.
 * <p>
 * Calcula la media (suma / conteo).
 * <p>
 * Escribe en "resultado.txt" la media con printf("%.2f").
 * <p>
 * Lee y muestra "resultado.txt" para verificar.
 */
public class EjercicioFichero02 {

	/**
	 * Lee el archivo y calcula la media de edades
	 * 
	 * @param filename Nombre del archivo
	 * @return Media de edades
	 */
	private static double readAverage(String filename) {
		double sum = 0;
		int amount = 0;

		// En try catch por si hay error de lectura
		try {
			// Cargamos el buffer
			BufferedReader br = new BufferedReader(new FileReader(filename));
			// Leemos la primera linea
			String linea = br.readLine();
			// Mientras quedan lineas
			while (linea != null) {
				// Leemos el número en la linea
				try {
					var number = linea.split(",")[1];
					sum += Double.parseDouble(number);
					// Si se lee el número aumentamos el contador
					amount++;
				} catch (NumberFormatException e) {
					// Si no es un número lanzamos error y cerramos el archivo
					System.out.println("Error, la edad contiene carácteres no numéricos");
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

	/**
	 * Escribe la cadena text en el archivo filename
	 * 
	 * @param filename Nombre del archivo destino
	 * @param text     Texto a escribir
	 */
	private static void writeToFile(String filename, String text) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
			bw.write(text);
			bw.close();
		} catch (IOException ioe) {
			System.out.println("No se ha podido escribir");
		}
	}

	/**
	 * Lee el archivo pasado como parametro
	 * 
	 * @param filename Nombre del archivo
	 */
	private static void readFile(String filename) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String linea = br.readLine();
			while (linea != null) {
				System.out.println(linea);
				linea = br.readLine();
			}
			br.close(); // ¡IMPORTANTE CERRAR EL FICHERO!
		} catch (IOException ioe) {
			System.out.println("Error al leer");
		}
	}

	public static void main(String[] args) {
		double average = readAverage("entrada.txt");
		var result = String.format("La edad media es: %.2f años%n", average);
		writeToFile("resultado.txt", result);
		readFile("resultado.txt");
	}

}
