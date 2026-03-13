package ej10;

import java.util.ArrayList;

import formato.JavaFormat;

/**
 * Clase que guarda una lista de varios libros
 */
public class Biblioteca {
	/**
	 * Lista de libros
	 */
	private ArrayList<Libro> libros = new ArrayList<>();

	/**
	 * Inicializa Biblioteca con ESTOS 8 libros EXACTOS:"Don Quijote" (Cervantes),
	 * "1984" (Orwell), "El Alquimista" (Coelho), "Harry Potter" (Rowling), "Cien
	 * años de soledad" (García Márquez), "El Principito" (Saint-Exupéry), "Sapiens"
	 * (Harari), "1984" (Orwell)
	 */
	public Biblioteca() {
		libros.add(new Libro("Don Quijote", "Cervantes"));
		libros.add(new Libro("1984", "Orwell"));
		libros.add(new Libro("El Alquimista", "Coelho"));
		libros.add(new Libro("Harry Potter", "Rowling"));
		libros.add(new Libro("Cien años de soledad", "García Márquez"));
		libros.add(new Libro("El Principito", "Saint-Exupéry"));
		libros.add(new Libro("Sapiens", "Harari"));
		libros.add(new Libro("1984", "Orwell"));
	}

	/**
	 * Toma un libro prestado. Buscar con for-each
	 * 
	 * @param titulo Título del libro a tomar prestado
	 */
	public void prestarLibro(String titulo) {
		// Recorrer la lista
		for (var libro : libros) {
			// Si el libro existe y no está prestado lo tomamos prestado y salimos del
			// método
			if (libro.getTitulo().trim().equalsIgnoreCase(titulo.trim()) && !libro.isPrestado()) {
				libro.prestar();
				System.out.printf("Has tomado prestado el libro %s.%n", libro.toString());
				return;
			}
		}
		// Si no hay copias disponibles, no se han encontrado en el bucle, avisamos.
		System.out.println("No hay copias disponibles de: " + titulo);
	}

	/**
	 * Devuelve un libro a la biblioteca. Buscar con for-each
	 * 
	 * @param titulo Título del libro a devolver
	 */
	public void devolverLibro(String titulo) {
		for (var libro : libros) {
			// Si el libro existe y está prestado lo devolvemos y salimos del método
			if (libro.getTitulo().trim().equalsIgnoreCase(titulo.trim()) && libro.isPrestado()) {
				libro.devolver();
				System.out.printf("Has devuelto el libro %s.%n", libro.toString());
				return;
			}
		}
		// Si no hay copias prestadas, no se han encontrado en el bucle, avisamos.
		System.out.println("No hay copias prestadas de: " + titulo);
	}

	/**
	 * Devolver nueva ArrayList
	 * 
	 * @return Copia del contenido disponible de la biblioteca
	 */
	public ArrayList<Libro> librosDisponibles() {
		// Creamos una nueva lista
		ArrayList<Libro> available = new ArrayList<>();
		// Comprobamos cada libro de la biblioteca, si están disponibles los añadimos a
		// la lista
		for (var libro : libros) {
			if (!libro.isPrestado()) {
				available.add(libro);
			}
		}
		// Devolvemos la lista
		return available;
	}

	/**
	 * Mostrar estadísticas de la biblioteca total, prestados, disponibles
	 */
	public void mostrarEstadisticas() {
		int borrowed = 0;
		int available = 0;
		// Recorremos la lista de libros y sumamos los prestados y los disponibles
		for (var libro : libros) {
			if (libro.isPrestado())
				borrowed++;
			else
				available++;
		}
		// Mostramos las estadísticas de la biblioteca
		System.out.printf("Estadísticas: Total=%d, Prestados=%d, Disponibles=%d%n", libros.size(), borrowed, available);
	}

	@Override
	public String toString() {
		String string = "";
		for (var libro : libros) {
			string += "- " + libro.toString() + (libro.isPrestado() ? " - Prestado" : " - Disponible") + '\n';
		}
		return string;
	}

	/**
	 * @return toString con color
	 */
	public String coloredString() {
		String string = "";
		for (var libro : libros) {
			string += "- " + libro.toString() + JavaFormat.BOLD
					+ (libro.isPrestado() ? JavaFormat.RED + " - Prestado" : JavaFormat.GREEN + " - Disponible")
					+ JavaFormat.RESET + '\n';
		}
		return string;
	}

	/**
	 * Añadir nuevo libro
	 * 
	 * @param nuevoLibro Libro a añadir
	 */
	public void anadirLibro(Libro nuevoLibro) {
		libros.add(nuevoLibro);
	}

	/**
	 * Eliminar libro
	 * 
	 * @param titulo Título del libro a eliminar
	 * @param autor  Autor del libro a eliminar
	 */
	public void eliminarLibro(String titulo, String autor) {
		// Creamos copia de libro a eliminar
		var targetBook = new Libro(titulo, autor);
		// Recorremos la lista de libros
		for (int index = 0; index < libros.size(); index++) {
			var tempBook = libros.get(index);
			// Si se encuentra el libro y está disponible se elimina y salimos del bucle
			if (tempBook.equals(targetBook) && !tempBook.isPrestado()) {
				libros.remove(index);
				return;
			}
		}
		// Si no se ha encontrado copia del libro avisamos
		System.err.println("Error, no se han encontrado copias disponibles de " + targetBook);
	}
}
