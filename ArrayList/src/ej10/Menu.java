package ej10;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Menú de control de biblioteca
 */
public class Menu {
	/**
	 * Listado de opciones
	 */
	public static final String[] OPTIONS = { "1. Mostrar todos los libros\n", "2. Libros disponibles\n",
			"3. Prestar libro (pedir título)\n", "4. Devolver libro (pedir título)\n", "5. Estadísticas\n",
			"6. Añadir Libro\n", "7. Eliminar libro\n", "8. Guardar a fichero\n", "0. Salir\n" };

	/**
	 * Bucle de ejecución de menú
	 */
	private static void appLoop() {
		// Abrir Scanner en try para no tener que cerrarlo
		try (var sc = new Scanner(System.in);) {
			// Variable para almacenar la opción
			var option = -1;
			// Variable con la lista de libros
			var library = new Biblioteca();
			while (option != 0) {
				// Cadena con las opciones disponibles
				var label = "Introduzca:\n";
				for (var string : OPTIONS) {
					label += string;
				}

				// Pedimos la opción a usar
				option = CustomInput.requestInteger(sc, label);

				// Si la opción no es válida avisamos
				if (option < 0 || option > OPTIONS.length - 1) {
					System.err.println("Error, opción no válida");
					CustomInput.requestInput(sc, "Pulse intro para continuar");
					// Y volvemos a repetir el bucle
					continue;
				}

				// Dependiendo del valor de la opción selecionada
				switch (option) {
				// Mostrar todos los libros
				case 1:
					System.out.println(library.coloredString());
					break;
				// Libros disponibles
				case 2:
					showAvailable(library);
					break;
				// Prestar libro (pedir título)
				case 3:
					library.prestarLibro(CustomInput.requestInput(sc, "Título del libro a tomar prestado: "));
					break;
				// Devolver libro (pedir título)
				case 4:
					library.devolverLibro(CustomInput.requestInput(sc, "Título del libro a devolver: "));
					break;
				// Estadísticas
				case 5:
					library.mostrarEstadisticas();
					break;
				// Cierre de programa
				case 0:
					// Avisar
					System.out.println("Cerrando programa.");
					break;
				// Añadir libro
				case 6:
					addBook(sc, library);
					break;
				// Eliminar libro
				case 7:
					deleteBook(sc, library);
					break;
				// Guardar libreria a archivo
				case 8:
					writeLibrary(sc, library);
					break;
				default:
					System.err.println("Error, opción no válida.");
				}
				CustomInput.requestInput(sc, "Pulse intro para continuar");
			}
		}
	}

	/**
	 * Mostrar disponibles en la biblioteca
	 * 
	 * @param library Biblioteca
	 */
	private static void showAvailable(Biblioteca library) {
		System.out.println("Libros disponibles:");
		for (var libro : library.librosDisponibles()) {
			System.out.println("- " + libro);
		}
	}

	/**
	 * Eliminar libro de la biblioteca
	 * 
	 * @param sc      Scanner de entrada de texto
	 * @param library Biblioteca
	 */
	private static void deleteBook(Scanner sc, Biblioteca library) {
		var title = CustomInput.requestInput(sc, "Introduzca el título del libro a eliminar:");
		var author = CustomInput.requestInput(sc, "Introduzca el autor del libro a eliminar:");
		library.eliminarLibro(title, author);
	}

	/**
	 * Añadir libro a la biblioteca
	 * 
	 * @param sc      Scanner de entrada de texto
	 * @param library Biblioteca
	 */
	private static void addBook(Scanner sc, Biblioteca library) {
		// Crear libro
		var title = CustomInput.requestInput(sc, "Introduzca el título del libro a añadir:");
		var author = CustomInput.requestInput(sc, "Introduzca el autor del libro a añadir:");
		var newBook = new Libro(title, author);
		// Añadir libro
		library.anadirLibro(newBook);
	}

	/**
	 * Guardar lista de libros en fichero
	 * 
	 * @param sc      Scanner
	 * @param library Biblioteca
	 */
	private static void writeLibrary(Scanner sc, Biblioteca library) {
		var fileName = CustomInput.requestInput(sc, "Nombre del archivo:");
		writeFile(fileName, library.toString());
	}

	/**
	 * Escribir cadena a archivo
	 * 
	 * @param fileName Nombre del archivo
	 * @param content  Contenido a guardar
	 */
	private static void writeFile(String fileName, String content) {
		try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {
			pw.print(content);
		} catch (IOException e) {
			System.err.println("Error al leer el archivo");
		}
	}

	public static void main(String[] args) {
		appLoop();
	}
}
