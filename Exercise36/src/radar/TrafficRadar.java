package radar;

import java.util.Random;
/* Desarrolla un programa en Java que simule la lectura de un radar de tráfico
 * en un tramo de carretera con velocidad máxima permitida de 120 km/h.
 * Los datos de velocidad se generan aleatoriamente entre 70 y 200 km/h.
 * El programa debe realizar las siguientes acciones:
 * 1.- Simular la lectura diaria durante una semana completa (7 días), considerando 100 coches por día.
 * 2.- Almacenar las velocidades registradas cada día.
 * 3.- Al finalizar la semana, mostrar la siguiente información:
 *	* Por cada día:
 *		▪ La máxima velocidad registrada.
 *		▪ La velocidad media.
 *		▪ Número de multas a enviar (coches que superan 120 km/h).
 *	* A nivel semanal:
 *		▪ La máxima velocidad registrada.
 *		▪ La velocidad media de la semana completa.
 *		▪ Número total de multas a enviar.
 *		▪ El día de la semana con más multas emitidas.
 * Autor: Pablo Illescas
 */

/**
 * Clase que genera un objeto que simula el comportamiento de un Radar de
 * tráfico
 */
public class TrafficRadar {
	/**
	 * Cantidad de lecturas a tomar
	 */
	private static final int AMOUNT = 100;

	/**
	 * Valor aleatorio mínimo
	 */
	private static final double MIN = 70;

	/**
	 * Valor aleatorio máximo
	 */
	private static final double MAX = 200;

	/**
	 * Valor límite para multa
	 */
	private static final double LIMIT = 120;

	/**
	 * Lista con los nombres de los días por defecto
	 */
	private static final String[] NAMES = { "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo" };

	/**
	 * Lista con los nombres de los días
	 */
	private String[] names;

	/**
	 * 
	 */
	double[][] readings;

	/**
	 * Constructor vacío
	 */
	public TrafficRadar() {
		this(NAMES, AMOUNT);
	}

	/**
	 * Constructor con días y cantidad de vehículos
	 * 
	 * @param days   Array con los nombres de los días a medir
	 * @param amount Cantidad de lecturas a tomar por día
	 */
	public TrafficRadar(String[] names, int amount) {
		this.names = names;
		readings = new double[names.length][amount];
		fillReadings();
	}

	/**
	 * Método para contar las filas de una matriz
	 * 
	 * @param mat Matriz a analizar
	 * @return Entero con la cantidad de filas de la matriz
	 */
	public int getRows(double mat[][]) {
		return mat.length;
	}

	/**
	 * Método para contar las columnas de una matriz
	 * 
	 * @param mat Matriz a analizar
	 * @return Entero con la cantidad de columnas de la matriz
	 */
	public int getColumns(double mat[][]) {
		return mat[0].length;
	}

	/**
	 * Método para contar las filas de la matriz atributo
	 * 
	 * @return Entero con la cantidad de filas
	 */
	public int getRows() {
		return getRows(readings);
	}

	/**
	 * Método para contar las columnas de la matriz atributo
	 * 
	 * @return Entero con la cantidad de columnas
	 */
	public int getColumns() {
		return getColumns(readings);
	}

	/**
	 * Método para rellenar una matriz de Double de valores aleatorios
	 * 
	 * @param array Array a rellenar
	 */
	public void fillReadings(double array[][]) {
		var rnd = new Random();
		for (int day = 0; day < getRows(array); day++) {
			for (int reading = 0; reading < getColumns(array); reading++) {
				array[day][reading] = rnd.nextDouble(MIN, MAX);
			}
		}
	}

	/**
	 * Método para rellenar la matriz atributo con valores aleatorios
	 */
	public void fillReadings() {
		fillReadings(readings);
	}

	/**
	 * Mostrar las estadísticas por día
	 */
	public void showDailyStatistics() {
		System.out.println("--- ESTADÍSTICAS POR DÍA ---\n");
		for (int day = 0; day < getRows(); day++) {
			System.out.printf("Día %d (%s):%n", day + 1, names[day]);
			double max = Double.NEGATIVE_INFINITY;
			double avg = 0;
			int tickets = 0;
			for (int reading = 0; reading < getColumns(); reading++) {
				var newRead = readings[day][reading];
				avg += newRead;
				if (newRead > max)
					max = newRead;
				if (newRead > LIMIT)
					tickets++;
			}
			System.out.printf("Máxima velocidad: %.0f km/h%n", max);
			System.out.printf("Velocidad media: %.1f km/h%n", avg / getColumns());
			System.out.printf("Multas: %d%n", tickets);
			System.out.println();
		}
	}

	/**
	 * Mostrar las estadísticas por semana
	 */
	public void showWeekStatistics() {
		System.out.println("--- ESTADÍSTICAS SEMANALES ---");
		double max = Double.NEGATIVE_INFINITY;
		double avg = 0;
		int total = 0;
		int maxFines = 0;
		String maxDay = names[0];
		for (int day = 0; day < getRows(); day++) {
			int amount = 0;
			for (int reading = 0; reading < getColumns(); reading++) {
				var newRead = readings[day][reading];
				avg += newRead;
				if (newRead > max)
					max = newRead;
				if (newRead > LIMIT)
					amount++;
			}
			total += amount;
			if (amount > maxFines) {
				maxFines = amount;
				maxDay = names[day];
			}
		}
		System.out.printf("Máxima velocidad registrada: %.0f km/h%n", max);
		System.out.printf("Velocidad media semanal: %.1f km/h%n", avg / (getColumns() * getRows()));
		System.out.printf("Total multas a enviar: %d%n", total);
		System.out.printf("Día con más multas: %s (%d multas)", maxDay, maxFines);
	}

	public static void main(String args[]) {
		System.out.println("=== INFORME RADAR DE TRÁFICO - SEMANA 1 ===");
		System.out.println("Velocidad máxima permitida: 120 km/h\n");
		var obj = new TrafficRadar();
		obj.showDailyStatistics();
		obj.showWeekStatistics();
	}
}
