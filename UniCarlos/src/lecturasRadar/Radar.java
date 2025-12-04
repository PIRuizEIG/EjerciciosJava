package lecturasRadar;

/**
 * <h1>Crear objeto captura de radar con 3 atributos:</h1>
 * <ol>
 * <li>Lectura de velocidad - entero</li>
 * <li>Matrícula - entero</li>
 * <li>Día - entero</li>
 * </ol>
 * <p>
 * Crear constante NUM_COCHES para tomar 100 lecturas.
 * </p>
 * <p>
 * Crear un array de capturas del tamaño de la constante llamado radar.
 * </p>
 * <p>
 * Rellenar con datos aleatorios:
 * </p>
 * <ul>
 * <li>Lecturas de 70 - 200</li>
 * <li>Matrícula de 1 a 1000</li>
 * <li>Día de 1 a 7</li>
 * </ul>
 * <p>
 * Si la velocidad supera 120 imprimir matricula y día de la multa.
 * </p>
 * Autor: Pablo Illescas
 */
public class Radar {
	/**
	 * Tamaño del array de lecturas
	 */
	public static final int NUM_COCHES = 100;

	/**
	 * Velocidad límite de multa
	 */
	public static final int SPEED_LIMIT = 120;

	/**
	 * Array de capturas
	 */
	private Captura[] radar;

	/**
	 * Crear array de capturas
	 */
	public Radar() {
		this.radar = new Captura[NUM_COCHES];
		for (int i = 0; i < radar.length; i++) {
			radar[i] = new Captura();
			radar[i].takeReading();
		}
	}

	/**
	 * Mostrar contenido del array
	 */
	public void ShowReadings() {
		for (var reading : radar) {
			reading.showInfo();
		}
	}

	/**
	 * Mostrar las multas
	 */
	public void ShowFines() {
		for (var reading : radar) {
			if (reading.getSpeed() >= SPEED_LIMIT)
				reading.showInfo();
		}
	}

	public static void main(String args[]) {
		var obj = new Radar();
		obj.ShowFines();
	}
}
