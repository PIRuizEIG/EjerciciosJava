package exam;

/**
 * <h1>1. Clase Abstracta Participante</h1>
 * <p>
 * Crea una clase abstracta que represente a cualquier entidad que pueda
 * competir en un torneo:
 * <p>
 * Atributos protegidos: id (String), nombre (String) y puntuacion (int).
 * <p>
 * Un constructor que inicialice los tres atributos.
 * <p>
 * Un método abstracto obtenerResumen() que devuelva un String con la
 * presentación del participante.
 * <p>
 * Sobrescribe toString() mostrando id, nombre y puntuación
 * <h2>Autor: Pablo Illescas Ruiz</h2>
 */
public abstract class Participante {
	/** ID de participante */
	protected String id;
	/** Nombre de particimante */
	protected String nombre;
	/** Puntuación */
	protected int puntuacion;

	/**
	 * Genera un participante con los atributos recibidos
	 * 
	 * @param id         ID del participante
	 * @param nombre     Nombre del participante
	 * @param puntuacion Puntuación del participante
	 */
	public Participante(String id, String nombre, int puntuacion) {
		this.id = id;
		this.nombre = nombre;
		this.puntuacion = puntuacion;
	}

	/** String con la presentación del participante */
	public abstract String obtenerResumen();

	/** Muestra la información del participante */
	@Override
	public String toString() {
		return String.format("[%s]\t%s\t| Puntuación: %d", id, nombre, puntuacion);
	}

	/** @return ID del participante */
	public String getId() {
		return id;
	}

	/** @return Nombre del participante */
	public String getNombre() {
		return nombre;
	}

	/** @return Puntuación del participante */
	public int getPuntuacion() {
		return puntuacion;
	}

	/** Añadir puntuación */
	public void addScore() {
		puntuacion++;
	}
}
