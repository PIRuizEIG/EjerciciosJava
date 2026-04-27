package exam;

/**
 * <h1>3. Clase Equipo</h1>
 * <p>
 * Hereda de Participante y representa a un grupo de jugadores:
 * <p>
 * Atributo específico: numIntegrantes (int).
 * <p>
 * Constructor y obtenerResumen() mostrando el nombre del equipo y cuántos
 * integrantes tiene.
 * <h2>Autor: Pablo Illescas</h2>
 */
public class Equipo extends Participante {
	/** Cantidad de Jugadores en el equipo */
	private int numIntegrantes;

	/**
	 * Genera un Equipo con los atributos recibidos
	 * 
	 * @param id             ID del equipo
	 * @param nombre         Nombre del equipo
	 * @param puntuacion     Puntuación del equipo
	 * @param numIntegrantes Cantidad de Jugadores en el equipo
	 */
	public Equipo(String id, String nombre, int puntuacion, int numIntegrantes) {
		super(id, nombre, puntuacion);
		this.numIntegrantes = numIntegrantes;
	}

	@Override
	/** String con la presentación del equipo */
	public String obtenerResumen() {
		return String.format("Equipo: %s\t- %d integrantes", super.nombre, numIntegrantes);
	}

}
