package lecturasRadar;

import java.util.Random;

/**
 * Representa una captura realizada por un radar con:
 * <ul>
 * <li>Velocidad del vehículo</li>
 * <li>Matrícula</li>
 * <li>Día de la semana</li>
 * </ul>
 *
 * Permite generar una captura aleatoria y mostrarla formateada. Autor: Pablo
 * Illescas
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
	 * Velocidad límite de multa
	 */
	public static final int SPEED_LIMIT = 120;

	/**
	 * Velocidad límite de multa de nivel 2
	 */
	public static final int LEVEL_2_FINE = 150;

	/**
	 * Velocidad límite de multa de nivel 3
	 */
	public static final int LEVEL_3_FINE = 180;

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
	 * Color del coche
	 */
	private Color color;

	/**
	 * Crear captura de velocidad
	 * 
	 * @param speed Velocidad del coche
	 * @param plate Matrícula del coche
	 * @param date  Fecha de captura
	 */
	public Captura(int speed, int plate, int date, Color color) {
		this.reading = speed;
		this.license = plate;
		this.day = date;
		this.color = color;
	}

	/**
	 * Crear objeto captura vacío
	 */
	public Captura() {
	}

	/**
	 * Tomar lectura de velocidad
	 */
	public void takeReading() {
		var rnd = new Random();
		reading = rnd.nextInt(MIN_SPEED, MAX_SPEED);
		license = rnd.nextInt(MIN_MAT, MAX_MAT);
		day = rnd.nextInt(MIN_DAY, MAX_DAY + 1);
		
		var colors = Color.values();
	    color = colors[rnd.nextInt(colors.length)];
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

	/**
	 * Muestra la información de la captura con colores
	 */
	public void showInfoColored() {
		if (reading >= 120) {
			// Poner "\u001B[<COLOR>m" antes de una cadena cambia el color del texto
			// siguiente
			System.out.print(JavaFormat.RED_BG);
			System.out.printf("Velocidad: %3d Km/h, Matrícula: %03d, Día: %s, Multa%n", reading, license, getDayName());
			// "\u001B[0m" restaura el color por defecto
			System.out.print(JavaFormat.RESET);
		} else {
			System.out.printf("Velocidad: %3d Km/h, Matrícula: %03d, Día: %s%n", reading, license, getDayName());
		}
	}

	/**
	 * Getter del color
	 * 
	 * @return Color del coche
	 */
	public Color getColor() {
		return color;
	}
}
