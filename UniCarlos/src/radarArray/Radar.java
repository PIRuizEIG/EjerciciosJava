package radarArray;

import java.util.Random;

/**
 * <h1>Crear objeto captura de radar con 4 atributos array de tamaño 100:</h1>
 * <ul>
 * <li>Lectura de velocidad - entero</li>
 * <li>Matrícula - entero</li>
 * <li>Día - entero</li>
 * <li>Color (Claro o osucro)</li>
 * <li>Crear constante NUM_COCHES para tomar 100 lecturas.</li>
 * </ul>
 * <p>
 * Rellenar con datos aleatorios:
 * <ul>
 * <li>Lecturas de 70 - 200</li>
 * <li>Matrícula de 1 a 1000</li>
 * <li>Día de 1 a 7</li>
 * <li>Color(Claro, Oscuro)</li>
 * </ul>
 * <p>
 * Si la velocidad supera 120 imprimir matricula y día de la multa.
 * <p>
 * Pedir día de la semana, para dicho día dar velocidad máxima, mínima, media y
 * mostrar matriculas de coches multados
 * <p>
 * Rango: 120 a 150. Restar 1 punto del carnet
 * <p>
 * Rango: 150 a 180. Restar 2 puntos del carnet
 * <p>
 * Rango: Mayor a 180. Restar 3 puntos del carnet
 * <p>
 * Mostrar: Día con más multas
 * <p>
 * Día con la velocidad media más alta
 * <p>
 * Decir que color tiene mayor velocidad media
 * <p>
 * Autor: Pablo Illescas
 */
public class Radar {
	/**
	 * Tamaño del array de lecturas
	 */
	public static final int NUM_COCHES = 100;

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
	 * Nombre de los días de la semana
	 */
	public static final String DAY_NAME[] = { "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sabado",
			"Domingo" };

	/**
	 * Nombre de los colores
	 */
	public static final String COLOR_NAME[] = { "Claro", "Oscuro" };

	/**
	 * Velocidad de la captura
	 */
	private int speed[];

	/**
	 * Matrícula del coche
	 */
	private int license[];

	/**
	 * Día de la captura
	 */
	private int day[];

	/**
	 * Color del coche
	 */
	private int color[];

	/**
	 * Crear objeto radar con 100 capturas
	 */
	public Radar() {
		this.speed = new int[NUM_COCHES];
		this.license = new int[NUM_COCHES];
		this.day = new int[NUM_COCHES];
		this.color = new int[NUM_COCHES];
		fillData();
	}

	/**
	 * Llenar los array con datos aleatorios
	 */
	public void fillData() {
		var rnd = new Random();
		for (int i = 0; i < speed.length; i++) {
			speed[i] = rnd.nextInt(MIN_SPEED, MAX_SPEED);
			license[i] = rnd.nextInt(MIN_MAT, MAX_MAT);
			day[i] = rnd.nextInt(0, DAY_NAME.length);
			color[i] = rnd.nextInt(0, COLOR_NAME.length);
		}
	}

	/**
	 * Obtener nombre del día
	 * 
	 * @param num Día
	 * @return Cadena con el nombre
	 */
	private String getDayName(int num) {
		return DAY_NAME[num];
	}

	/**
	 * Obtener nombre del color
	 * 
	 * @param num Color
	 * @return Cadena con el nombre
	 */
	private String getColorName(int num) {
		return COLOR_NAME[num];
	}

	/**
	 * Mostrar el contenido de todos los array
	 */
	public void showAllData() {
		for (int i = 0; i < speed.length; i++) {
			System.out.printf("Velocidad: %3d Km/h, Matrícula: %03d, Día: %9s, Color: %s%n", speed[i], license[i],
					getDayName(day[i]), getColorName(color[i]));
		}
	}

	/**
	 * Contar las multas de un día
	 * 
	 * @param weekDay día a buscar
	 * @return multas en el día
	 */
	public int countFines(int weekDay) {
		int fines = 0;
		for (int i = 0; i < speed.length; i++) {
			if (day[i] == weekDay)
				fines++;
		}
		return fines;
	}

	/**
	 * Mostrar el día con más multas
	 */
	public void showMaxFines() {
		int max = 0;
		int weekDay = 0;
		for (int i = 0; i < DAY_NAME.length; i++) {
			int fines = countFines(i);
			if (fines > max) {
				max = fines;
				weekDay = i;
			}
		}
		System.out.printf("El día con más multas es el %s con %d multas%n", getDayName(weekDay), max);
	}

	/**
	 * Calcular la media de un día
	 * 
	 * @param weekDay día a medir
	 * @return Double con la media
	 */
	public double getAverage(int weekDay) {
		double sum = 0;
		int c = 0;

		for (int i = 0; i < day.length; i++) {
			if (day[i] == weekDay) {
				sum += speed[i];
				c++;
			}
		}
		if (c == 0)
			return 0;
		return sum / c;
	}

	/**
	 * Mostrar el día con mayor velocidad
	 */
	public void showMaxAverage() {
		double max = 0;
		int weekDay = 0;
		for (int i = 0; i < DAY_NAME.length; i++) {
			double avg = getAverage(i);
			if (avg > max) {
				max = avg;
				weekDay = i;
			}
		}
		System.out.printf("El día con mayor velocidad media es el %s con %.2f km/h%n", getDayName(weekDay), max);
	}
	
	/**
	 * Calcular la media de un color
	 * 
	 * @param col Color a medir
	 * @return Double con la media
	 */
	public double getColorAverage(int col) {
		double sum = 0;
		int c = 0;

		for (int i = 0; i < day.length; i++) {
			if (color[i] == col) {
				sum += speed[i];
				c++;
			}
		}
		if (c == 0)
			return 0;
		return sum / c;
	}
	
	/**
	 * Mostrar el color con mayor velocidad
	 */
	public void showColorMaxAverage() {
		double max = 0;
		int col = 0;
		for (int i = 0; i < COLOR_NAME.length; i++) {
			double avg = getColorAverage(i);
			if (avg > max) {
				max = avg;
				col = i;
			}
		}
		System.out.printf("El día con mayor velocidad media es el %s con %.2f km/h%n", getColorName(col), max);
	}

	public static void main(String args[]) {
		var obj = new Radar();
		obj.showMaxFines();
		obj.showMaxAverage();
		obj.showColorMaxAverage();
	}
}
