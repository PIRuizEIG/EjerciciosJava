package ej10;

/*
 * private String titulo, autor 
 * private boolean prestado = false
 * Constructor Libro(String titulo, String autor)
 * boolean isPrestado(), void prestar(), void devolver()
 * @Override String toString() → "Don Quijote (Cervantes)"
 */
/**
 * Clase que almacena la información de un libro
 */
public class Libro {
	/**
	 * Título del libro
	 */
	private String titulo;
	/**
	 * Autor del libro
	 */
	private String autor;
	/**
	 * Está prestado el libro
	 */
	private boolean prestado;

	/**
	 * Crear libro
	 * 
	 * @param titulo Título del libro
	 * @param autor  Autor del libro
	 */
	public Libro(String titulo, String autor) {
		this.titulo = titulo;
		this.autor = autor;
		this.prestado = false;
	}

	@Override
	public String toString() {
		return String.format("%s (%s)", titulo, autor);
	}

	/**
	 * @return Titulo del libro
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @return Autor del libro
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * @return True si el libro está prestado
	 */
	public boolean isPrestado() {
		return prestado;
	}

	/**
	 * Tomar prestado el libro
	 */
	public void prestar() {
		if (!prestado)
			prestado = true;
		else
			throw new IllegalStateException("El libro ya está prestado");
	}

	/**
	 * Devolver el libro
	 */
	public void devolver() {
		if (prestado)
			prestado = false;
		else
			throw new IllegalStateException("El libro no está prestado");
	}

	@Override
	public boolean equals(Object obj) {
		// Si el libro y el objeto a comparar apuntan al mismo objeto en memoria, son
		// iguales
		if (this == obj)
			return true;

		// Si el objeto a comparar no es un libro, no pueden ser iguales
		if (!(obj instanceof Libro))
			return false;

		// Convertimos el objeto a Libro para poder compararlo
		var other = (Libro) obj;

		// Dos libros son iguales si tienen mismo autor, título y estado de prestamo
		return this.titulo.equalsIgnoreCase(other.titulo) && this.autor.equalsIgnoreCase(other.autor);
	}

	@Override
	public int hashCode() {
		// El hash code del libro es la suma de los hash del título y autor. Como
		// equals ignora mayúsculas pasamos autor y título a mayúsculas
		return autor.toUpperCase().hashCode() + titulo.toUpperCase().hashCode();
	}
}
