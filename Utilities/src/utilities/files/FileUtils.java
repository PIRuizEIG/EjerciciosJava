package utilities.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Utilidades de archivos
 */
public class FileUtils {
	/**
	 * @param fileName Nombre del archivo
	 * @return True si el archivo existe
	 */
	public static boolean fileExist(String fileName) {
		return new File(fileName).exists();
	}

	/**
	 * Lee el archivo pasado como parametro
	 * 
	 * @param fileName Nombre del archivo
	 */
	public static void readFile(String fileName) {
		// Si no existe avisar
		if (!fileExist(fileName)) {
			System.err.println("No existe el archivo");
			return;
		}
		// Abrir archivo en try with resources
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			// Leer mientras queden lineas
			String linea;
			while ((linea = br.readLine()) != null) {
				// Mostrar linea por pantalla
				System.out.println(linea);
			}
			// Si hay error avisar
		} catch (IOException ioe) {
			System.err.println("Error al leer");
		}
	}

	/**
	 * @param fileName Archivo a leer
	 * @return Cadena con el contenido del archivo
	 */
	public static String fileToString(String fileName) {
		var string = "";
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = br.readLine()) != null) {
				string += line + "\n";
			}
		} catch (IOException e) {
			System.err.println("Error al leer archivo");
		}
		return string;
	}

	/**
	 * Escribir cadena a archivo sobreescribiendo existente
	 * 
	 * @param filename Archivo a escribir
	 * @param content  Contenido a escribir
	 */
	public static void writeFile(String filename, String content) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
			bw.write(content);
		} catch (IOException e) {
			System.err.println("Error al escribir archivo");
		}
	}

	/**
	 * Escribir cadena en el final del archivo
	 * 
	 * @param filename Archivo a escribir
	 * @param content  Contenido a escribir
	 */
	public static void appendFile(String filename, String content) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))) {
			bw.write(content);
			bw.newLine();
		} catch (IOException e) {
			System.err.println("Error al añadir al archivo");
		}
	}

	/**
	 * Crear archivo si no existe
	 * 
	 * @param fileName Nombre del archivo
	 */
	public static void createFile(String fileName) {
		try {
			new File(fileName).createNewFile();
		} catch (IOException e) {
			System.err.println("Error al crear archivo");
		}
	}

	/**
	 * Borrar archivo
	 * 
	 * @param fileName Nombre del archivo
	 * @return Confirmación
	 */
	public static boolean deleteFile(String fileName) {
		return new File(fileName).delete();
	}
}
