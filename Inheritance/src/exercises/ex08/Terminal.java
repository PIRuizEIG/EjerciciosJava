package exercises.ex08;

/**
 * <h1>Ejercicio 8</h1> Implementa la clase Terminal. Un terminal tiene asociado
 * un número. Los terminales se pueden llamar unos a otros y el tiempo de
 * conversación corre para ambos.<br>
 * A continuación se proporciona el contenido del main y el resultado que debe
 * aparecer por pantalla.
 * <h2>Autor: Pablo Illescas</h2>
 */
public class Terminal {
	/** Nº de teléfono */
	private String number;
	/** Tiempo hablado */
	private int seconds;

	/** Generar terminal con 0s usados */
	public Terminal(String number) {
		this.number = number;
		this.seconds = 0;
	}

	/** Llama a otro terminal */
	public void llama(Terminal terminal, int amount) {
		this.seconds += amount;
		terminal.seconds += amount;
	}

	/** Cadena de terminal con formato Nº Número - Tiempo s de conversación */
	@Override
	public String toString() {
		return String.format("Nº %s - %ds de conversación", number, seconds);
	}
}
