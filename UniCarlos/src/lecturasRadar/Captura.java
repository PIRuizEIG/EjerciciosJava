package lecturasRadar;

import java.util.Random;

/**
 * Representa una captura realizada por un radar con:
 * <ul>
 *   <li>Velocidad del vehículo</li>
 *   <li>Matrícula</li>
 *   <li>Día de la semana</li>
 * </ul>
 *
 * Permite generar una captura aleatoria y mostrarla formateada.
 * Autor: Pablo Illescas
 */
public class Captura {
	/**
	 * Velocidad mínima
	 */
	public static final int MIN_SPEED = 70;

	/**
	 * Velocidad máxima
	 */
	public static final int MAX_SPEED = 200;

	/**
	 * Matrícula mínima
	 */
	public static final int MIN_MAT = 1;

	/**
	 * Matrícula máxima
	 */
	public static final int MAX_MAT = 1000;

	/**
	 * Día mínimo
	 */
	public static final int MIN_DAY = 1;

	/**
	 * Día máximo
	 */
	public static final int MAX_DAY = 7;

	/**
	 * Nombre de los días de la semana
	 */
	public static final String NAMES[] = { "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sabado", "Domingo" };

	/**
	 * Lectura de velocidad
	 */
	private int reading;

	/**
	 * Matricula del vehiculo
	 */
	private int license;

	/**
	 * Día de la lectura
	 */
	private int day;

	/**
	 * Crear captura de velocidad
	 * 
	 * @param speed Velocidad del coche
	 * @param plate Matrícula del coche
	 * @param date  Fecha de captura
	 */
	public Captura(int speed, int plate, int date) {
		this.reading = speed;
		this.license = plate;
		this.day = date;
	}
	
	/**
	 * Crear objeto captura vacío
	 */
	public Captura() {}


	/**
	 * Tomar lectura de velocidad
	 */
	public void takeReading() {
		var rnd = new Random();
		reading = rnd.nextInt(MIN_SPEED, MAX_SPEED);
		license = rnd.nextInt(MIN_MAT, MAX_MAT);
		day = rnd.nextInt(MIN_DAY, MAX_DAY + 1);
	}

	/**
	 * Getter de la lectura de velocidad
	 * 
	 * @return Velocidad
	 */
	public int getSpeed() {
		return reading;
	}

	/**
	 * Getter de la matrícula
	 * 
	 * @return Matrícula
	 */
	public int getLicense() {
		return license;
	}

	/**
	 * Getter con el número de día
	 * 
	 * @return Día
	 */
	public int getDay() {
		return day;
	}

	/**
	 * Getter con el nombre del día
	 * 
	 * @return Nombre del día
	 */
	public String getDayName() {
		return NAMES[day - 1];
	}

	/**
	 * Mostrar información de la captura
	 */
	public void showInfo() {
		System.out.printf("Velocidad: %3d Km/h, Matrícula: %03d, Día: %s%n", reading, license, getDayName());
	}
}
