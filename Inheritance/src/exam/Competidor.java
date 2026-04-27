package exam;

/**
 * <h1>1. Interfaz Competidor</h1>
 * <p>
 * Define el contrato para los participantes que pueden entrar y salir de una
 * partida activa:
 * <p>
 * Métodos: entrarPartida(), salirPartida() e isActivo() (devuelve boolean).
 * <h2>Autor: Pablo Illescas</h2>
 */
public interface Competidor {
	/** Entrar a la partida */
	public void entrarPartida();

	/** Salir de la partida */
	public void salirPartida();

	/** @return true si el Competidor está en una partida */
	public boolean isActivo();
}
