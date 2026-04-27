package exam;

/**
 * <h1>2. Clase Jugador</h1>
 * <p>
 * Hereda de Participante y representa a un competidor individual:
 * <p>
 * Atributo específico: activo (boolean), que debe ser false por defecto al
 * crearse (el jugador empieza fuera de partida).
 * <p>
 * Constructor con super().
 * <p>
 * Implementa obtenerResumen() indicando que es un jugador individual y
 * mostrando su nombre y puntuación.
 * <h2>Implementación en Jugador</h2>
 * <p>
 * Haz que Jugador implemente Competidor:
 * <p>
 * entrarPartida(): Si el jugador no está activo, cambia el estado a true e
 * incrementa el contador estático (Parte 3). Si ya está activo, muestra: "El
 * jugador ya está en partida.".
 * <p>
 * salirPartida(): Cambia el estado a false y decrementa el contador
 * <h2>Contador Estático</h2>
 * <p>
 * En Jugador, declara un atributo estático jugadoresEnPartida que registre
 * cuántos jugadores individuales están compitiendo en este momento en todo el
 * torneo. Gestiona su valor correctamente desde entrarPartida() y
 * salirPartida().
 * <h2>Autor: Pablo Illescas</h2>
 */
public class Jugador extends Participante implements Competidor {
	/** Estado de actividad */
	private boolean activo;
	/** Cuántos jugadores individuales están compitiendo en este momento */
	private static int jugadoresEnPartida = 0;

	/** Genera un Jugador con los atributos recibidos en estado inactivo */
	public Jugador(String id, String nombre, int puntuacion) {
		super(id, nombre, puntuacion);
		this.activo = false;
	}

	@Override
	/** @return String con la presentación del participante */
	public String obtenerResumen() {
		return String.format("Jugador individual: %s\t(%d pts)", super.nombre, super.puntuacion);
	}

	@Override
	/** @return true si el Jugador está en una partida */
	public boolean isActivo() {
		return activo;
	}

	@Override
	/** Entrar a la partida */
	public void entrarPartida() {
		if (!activo) {
			System.out.println(super.nombre + "\tha entrado en partida.");
			activo = true;
			jugadoresEnPartida++;
		} else {
			System.err.println("El jugador " + super.nombre + " ya está en partida.");
		}
	}

	@Override
	/** Salir de la partida */
	public void salirPartida() {
		if (activo) {
			System.out.println(super.nombre + "\tha salido de su partida.");
			activo = false;
			jugadoresEnPartida--;
		} else {
			System.err.println("El jugador " + super.nombre + " no está en partida.");
		}
	}

	/**
	 * @return Cuántos jugadores individuales están compitiendo en este momento
	 */
	public static int getJugadoresEnPartida() {
		return jugadoresEnPartida;
	}
}
