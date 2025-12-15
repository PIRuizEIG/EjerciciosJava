package lecturasRadar;

import java.util.Scanner;

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
 * <p>
 * Pedir día de la semana, para dicho día dar velocidad máxima, mínima, media y
 * mostrar matriculas de coches multados
 * </p>
 * <ul>
 * <li>Rango: 120 a 150. Restar 1 punto del carnet</li>
 * <li>Rango: 150 a 180. Restar 2 puntos del carnet</li>
 * <li>Rango: Mayor a 180. Restar 3 puntos del carnet</li>
 * </ul>
 * <p>
 * Mostrar:
 * </p>
 * <ol>
 * <li>Día con más multas</li>
 * <li>Día con la velocidad media más alta</li>
 * <li>Añadir atributo color(Claro, Oscuro) y decir que color tiene mayor
 * velocidad media</li>
 * </ol>
 * 
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
	 * Velocidad límite de multa de nivel 2
	 */
	public static final int LEVEL_2_FINE = 150;

	/**
	 * Velocidad límite de multa de nivel 3
	 */
	public static final int LEVEL_3_FINE = 180;

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

	/**
	 * Mostrar contenido del array con color
	 */
	public void ShowReadingsWithColor() {
		for (var reading : radar) {
			reading.showInfoColored();
		}
	}

	/**
	 * Mostrar contenido del array
	 */
	public void ShowReadings(int day) {
		for (var reading : radar) {
			if (reading.getDay() == day)
				reading.showInfo();
		}
	}

	/**
	 * Mostrar las multas
	 * 
	 * @param day Día que buscar
	 */
	public void ShowFinesBasic(int day) {
		for (var reading : radar) {
			if (reading.getSpeed() >= SPEED_LIMIT && reading.getDay() == day)
				reading.showInfo();
		}
	}

	/**
	 * Mostrar las multas y los puntos eliminados del carnet
	 * 
	 * @param day Día que buscar
	 */
	public void ShowFines(int day) {
		for (var reading : radar) {
			var speed = reading.getSpeed();
			if (speed >= SPEED_LIMIT && reading.getDay() == day) {
				reading.showInfo();
				if (speed >= LEVEL_3_FINE) {
					System.out.print(JavaFormat.BRIGHT_YELLOW + JavaFormat.RED_BG + JavaFormat.BOLD);
					System.out.println("Se han quitado 3 puntos del carnet");
				} else if (speed >= LEVEL_2_FINE) {
					System.out.print(JavaFormat.BRIGHT_RED);
					System.out.println("Se han quitado 2 puntos del carnet");
				} else {
					System.out.print(JavaFormat.YELLOW);
					System.out.println("Se ha quitado 1 punto del carnet");
				}
				System.out.print(JavaFormat.RESET);
			}
		}
	}

	/**
	 * Mostrar contenido del array con color
	 */
	public void ShowReadingsWithColor(int day) {
		for (var reading : radar) {
			if (reading.getDay() == day)
				reading.showInfoColored();
		}
	}

	/**
	 * Calcular velocidad media
	 * 
	 * @return Velocidad media
	 */
	public int average() {
		int sum = 0;
		int size = radar.length;
		for (int i = 0; i < size; i++) {
			sum += radar[i].getSpeed();
		}
		if (size == 0)
			return 0;
		return sum / size;
	}

	/**
	 * Calcular velocidad media de un día
	 * 
	 * @param day Día
	 * @return Velocidad media
	 */
	public int average(int day) {
		int sum = 0;
		int size = 0;
		for (var reading : radar) {
			if (reading.getDay() == day) {
				sum += reading.getSpeed();
				size++;
			}
		}
		if (size == 0)
			return 0;
		return sum / size;
	}

	/**
	 * Encontrar velocidad mínima
	 * 
	 * @return Velocidad mínima
	 */
	public int minimum() {
		int min = Integer.MAX_VALUE;
		for (var reading : radar) {
			var speed = reading.getSpeed();
			if (speed < min)
				min = speed;
		}
		if (min == Integer.MAX_VALUE)
			return 0;
		return min;
	}

	/**
	 * Encontrar velocidad máxima de un día
	 * 
	 * @param day Día
	 * @return Velocidad mínima
	 */
	public int minimum(int day) {
		int min = Integer.MAX_VALUE;
		for (var reading : radar) {
			var speed = reading.getSpeed();
			if (speed < min && reading.getDay() == day)
				min = speed;
		}
		if (min == Integer.MAX_VALUE)
			return 0;
		return min;
	}

	/**
	 * Encontrar velocidad máxima
	 * 
	 * @return Velocidad máxima
	 */
	public int maximum() {
		int max = Integer.MIN_VALUE;
		for (var reading : radar) {
			var speed = reading.getSpeed();
			if (speed > max)
				max = speed;
		}
		if (max == Integer.MIN_VALUE)
			return 0;
		return max;
	}

	/**
	 * Encontrar velocidad máxima de un día
	 * 
	 * @param day Día
	 * @return Velocidad máxima
	 */
	public int maximum(int day) {
		int max = Integer.MIN_VALUE;
		for (var reading : radar) {
			var speed = reading.getSpeed();
			if (speed > max && reading.getDay() == day)
				max = speed;
		}
		if (max == Integer.MIN_VALUE)
			return 0;
		return max;
	}

	/**
	 * Mostrar información de un día
	 * 
	 * @param day Día
	 */
	public void showDayInfo(int day) {
		var min = minimum(day);
		var max = maximum(day);
		var avg = average(day);
		System.out.printf(
				"%s, Velocidad mínima: %d Km/h, Velocidad máxima: %d Km/h, Velocidad media: %d Km/h, Capturas: %n",
				Captura.NAMES[day - 1], min, max, avg);
		ShowFines(day);
	}

	/**
	 * Mostrar información por días
	 */
	public void showDailyInfo() {
		for (int i = Captura.MIN_DAY; i <= Captura.MAX_DAY; i++) {
			showDayInfo(i);
		}
	}

	/**
	 * Pedir día sobre el que mostrar información
	 */
	public void askForDayInfo() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int day;
		do {
			System.out.println("Introduzca día del que mostrar la información:");
			day = sc.nextInt();
			if (day < Captura.MIN_DAY || day > Captura.MAX_DAY)
				System.out.printf("Error, el valor debe estar entre %d y %d%n", Captura.MIN_DAY, Captura.MAX_DAY);
		} while (day < Captura.MIN_DAY || day > Captura.MAX_DAY);
		showDayInfo(day);
	}

	/**
	 * Contar las multas en un día
	 * 
	 * @param day Día a mirar
	 * @return Multas en el día
	 */
	public int countFines(int day) {
		int fines = 0;
		for (var reading : radar) {
			if (reading.getSpeed() > SPEED_LIMIT && reading.getDay() == day) {
				fines++;
			}
		}
		return fines;
	}

	/**
	 * Muestra el día con mayor número de multas
	 */
	public void showMaxFines() {
		int day = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < Captura.MAX_DAY; i++) {
			int fines = countFines(i);
			if (fines > max) {
				day = i;
				max = fines;
			}
		}
		System.out.printf("El día con más multas fue el %s con %d multas%n", Captura.NAMES[day - 1], max);
	}

	/**
	 * Muestra el día con mayor velocidad media
	 */
	public void showMaxAverage() {
		int day = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < Captura.MAX_DAY; i++) {
			int avg = average(i);
			if (avg > max) {
				max = avg;
				day = i;
			}
		}
		System.out.printf("El día con mayor velocidad media fue el %s con %d km/h%n", Captura.NAMES[day - 1], max);
	}

	/**
	 * Muestra el color con mayor velocidad media
	 */
	/*
	 * public void showMaxAverageColor() { int sumDark = 0; int sumLight = 0; int
	 * sizeDark = 0; int sizeLight = 0; for (var reading : radar) { if
	 * (reading.getColor() == Color.Claro) { sumLight += reading.getSpeed();
	 * sizeLight++; } else { sumDark += reading.getSpeed(); sizeDark++; } }
	 * 
	 * // Si el tamaño es 0 ponemos tamaño a 1 para evitar division por 0 if
	 * (sizeDark == 0) sizeDark = 1; if (sizeLight == 0) sizeLight = 1;
	 * 
	 * var avgLight = sumLight / sizeLight; var avgDark = sumDark / sizeDark; if
	 * (avgLight > avgDark) {
	 * System.out.printf("El color %s tiene mayor velocidad media con %d Km/h%n",
	 * Color.Claro.toString(), avgLight); } else if (avgDark > avgLight) {
	 * System.out.printf("El color %s tiene mayor velocidad media con %d Km/h%n",
	 * Color.Oscuro.toString(), avgDark); } else { System.out.
	 * printf("Ambos colores tienen la misma velocidad media con %d Km/h%n",
	 * avgDark); } }
	 */

	/**
	 * Muestra el color con mayor velocidad
	 */
	public void arrayMaxAverageColor() {
		// Inicializar los colores
		var colors = Color.values();
		ColorGroup struct[] = new ColorGroup[colors.length];
		
		// Inicializar la estructura
		int i = 0;
		for (var color : colors) {
			struct[i] = new ColorGroup(color);
			i++;
		}
		
		// Leer los valores tomados por el radar
		for (var reading : radar) {
			for (var value : struct) {
				if (value.color == reading.getColor()) {
					value.sum += reading.getSpeed();
					value.size++;
					break;
				}
			}
		}

		// Encontrar la media mayor
		Color bestColor = null;
		int bestAvg = Integer.MIN_VALUE;
		for (var value : struct) {
			int avg;
			if (value.size == 0)
				avg = 0;
			else
				avg = value.sum / value.size;
			if (avg > bestAvg) {
				bestColor = value.color;
				bestAvg = avg;
			}
		}

		// Mostrar el resultado
		System.out.printf("El color %s tiene mayor velocidad media con %d Km/h%n", bestColor.toString(), bestAvg);
	}

	public class ColorGroup {
		public Color color;
		public int sum;
		public int size;

		public ColorGroup(Color color) {
			this.color = color;
			this.sum = 0;
			this.size = 0;
		}
	}

	public static void main(String args[]) {
		var obj = new Radar();
		obj.askForDayInfo();
		obj.showMaxFines();
		obj.showMaxAverage();
		obj.arrayMaxAverageColor();
	}
}
