package actEvalTri1;

import java.util.Scanner;

/**
 * <h1>Clínica de Análisis de Sangre – Lecturas de Colesterol</h1>
 * <p>
 * Una clínica de análisis de sangre realiza estudios para distintas empresas.
 * Cada día procesa las lecturas de colesterol de muchas personas, y quiere
 * automatizar parte del tratamiento de la información.
 * <p>
 * Se pide desarrollar un programa en Java que simule el procesamiento de 100
 * personas, generando datos aleatoriamente y mostrando distintos informes.
 * <h2>Datos a generar</h2>
 * <p>
 * El programa debe generar de forma aleatoria para cada persona:
 * <h3>a) DNI (sin letra)</h3>
 * <p>
 * Número entero entre 1 y 100.000.000.
 * <h3>b) Empresa Asignar aleatoriamente una de las siguientes empresas:</h3>
 * <ol>
 * <li>Empresa 1</li>
 * <li>Empresa 2</li>
 * <li>Empresa 3</li>
 * <li>Empresa 4</li>
 * <li>Empresa 5</li>
 * </ol>
 * <h3>c) Lectura de colesterol</h3>
 * <p>
 * Valor entero generado aleatoriamente entre 120 y 330 mg/dL.
 * <h2>Datos introducidos por teclado</h2>
 * <h3>a) Selección de empresa por teclado</h3>
 * <p>
 * El programa debe pedir al usuario por teclado:
 * <p>
 * Introduce una empresa (1–5):
 * <p>
 * Solo se aceptarán valores del 1 al 5.
 * <p>
 * Si el usuario introduce otro valor, se debe volver a pedir.
 * <h2>Clasificación del colesterol</h2>
 * <p>
 * Cada lectura debe clasificarse en uno de los siguientes niveles:
 * <h3>Nivel Rango (mg/dL)</h3>
 * <ul>
 * <li>Óptimo Menos de 200</li>
 * <li>Normal / Límite Entre 200 y 239 (incluidos)</li>
 * <li>Peligroso (Alto) 240 o más</li>
 * </ul>
 * <h2>Informes a mostrar</h2>
 * <p>
 * Estadísticas generales de todas las empresas
 * <ol>
 * <li>Colesterol medio de todas las personas.</li>
 * <li>Colesterol máximo registrado y el DNI de la persona que lo posee.</li>
 * <li>Número de personas clasificadas como: Óptimo, Normal, Peligroso</li>
 * </ol>
 * <h2>Informes específicos de la empresa seleccionada</h2>
 * <p>
 * Distribución por nivel de esa empresa:
 * <ul>
 * <li>Mostrar cuántas personas de esa empresa están en: Óptimo, Normal,
 * Peligroso</li>
 * <li>Listado de personas en nivel peligroso en esa empresa: Mostrar los DNI de
 * las personas de esa empresa cuyo colesterol está en nivel peligroso.</li>
 * </ul>
 * <h2>Autor: Pablo Illescas</h2>
 */
public class ActividadEvaluableTrimestre1 {
	/**
	 * Cantidad de personas a las que tomar medidas
	 */
	public static final int PEOPLE = 100;

	/**
	 * Nivel normal de colesterol
	 */
	public static final double NORMAL_READING = 200;

	/**
	 * Nivel peligroso de colesterol
	 */
	public static final double AT_RISK = 240;

	/**
	 * Cabecera
	 */
	private static final String HEADING = "=== PROCESAMIENTO DE LECTURAS DE COLESTEROL (" + PEOPLE + " PERSONAS) ===";

	/**
	 * Cabecera de empresa
	 */
	private static final String CORPORATE_HEADING = "=== INFORME PARA EMPRESA [NUMBER] ===";

	/**
	 * Cabecera general
	 */
	private static final String GENERAL = "--- Estadísticas generales ---";

	/**
	 * Cabecera niveles global
	 */
	private static final String G_LEVELS = "--- Distribución global por niveles ---";

	/**
	 * Cabecera niveles empresa
	 */
	private static final String CORPORATE_LEVELS = "--- Distribución por niveles en la Empresa [NUMBER] ---";

	/**
	 * Cabecera en peligro en empresa
	 */
	private static final String CORPORATE_AT_RISK = "--- Personas en nivel PELIGROSO (Empresa [NUMBER]) ---";

	/**
	 * Pie del informe
	 */
	private static final String FOOTER = "=== FIN DEL INFORME ===";

	/**
	 * Lista de lecturas médicas
	 */
	private Reading readings[];

	/**
	 * Crear objeto con las medidas médicas de PEOPLE personas
	 */
	public ActividadEvaluableTrimestre1() {
		// Generar array de medidas
		this.readings = new Reading[PEOPLE];
		// Rellenar el array
		for (int i = 0; i < readings.length; i++)
			readings[i] = new Reading();
	}

	/**
	 * Mostrar las medidas de todas las personas
	 */
	public void showReadings() {
		for (var reading : readings)
			System.out.printf("DNI: %0,10d Empresa %d Medida: %03.2f mg/dL%n", reading.getId(),
					reading.getCorporation(), reading.getReading());
	}

	/**
	 * Obtener número de empresa a mostrar
	 * 
	 * @return Entero con el número de empresa
	 */
	public int getCorporationId() {
		@SuppressWarnings("resource")
		var sc = new Scanner(System.in);
		int id = 0;

		// Mientras el valor no sea valido
		while (id < Reading.MIN || id > Reading.CORP_MAX) {
			// Pedimos una empresa
			System.out.printf("Introduzca una empresa (%d-%d)%n", Reading.MIN, Reading.CORP_MAX);
			id = sc.nextInt();
			// Si no es valido mostrar mensaje de error
			if (id < Reading.MIN || id > Reading.CORP_MAX) {
				System.out.println("Error. Valor no valido.");
			}
		}

		return id;
	}

	/**
	 * Obtener la media de las medidas de colesterol
	 * 
	 * @return Double con la media de colesterol
	 */
	public double getAverage() {
		double sum = 0;
		// Recorremos todas las medidas y sumamos sus niveles
		for (var reading : readings)
			sum += reading.getReading();
		// Devolvemos la media (Suma de niveles dividido por cantidad de medidas)
		return sum / readings.length;
	}

	/**
	 * Encontrar la persona con la mayor medida de colesterol
	 * 
	 * @return Reading de la personal con mayor nivel de colesterol
	 */
	public Reading findMax() {
		double max = 0;
		Reading reading = null;

		for (var nextReading : readings) {
			// Para cada medida comparamos con el valor máximo almacenado
			if (nextReading.getReading() > max) {
				// Si la nueva medida es el valor más alto lo guardamos
				max = nextReading.getReading();
				reading = nextReading;
			}
		}

		return reading;
	}

	/**
	 * Mostrar niveles globales
	 */
	public void showGlobalLevels() {
		int optimum = 0;
		int normal = 0;
		int risk = 0;

		// Para cada medida miramos si es inferior a nivel normal o superior al valor de
		// riesgo
		for (var nextReading : readings) {

			if (nextReading.getReading() < NORMAL_READING)
				optimum++;

			else if (nextReading.getReading() >= AT_RISK)
				risk++;

			else
				normal++;
		}

		System.out.println(G_LEVELS);
		System.out.println();

		System.out.printf("Óptimo (<%.0f): %d personas%n", NORMAL_READING, optimum);
		System.out.printf("Normal (%.0f-%.0f): %d personas%n", NORMAL_READING, AT_RISK - 1, normal);
		System.out.printf("Peligroso (>=%.0f): %d personas%n", AT_RISK, risk);
	}

	/**
	 * Mostrar estadísticas generales
	 */
	public void showGeneralInfo() {
		System.out.println(HEADING);
		System.out.println();

		System.out.println(GENERAL);
		System.out.println();

		System.out.printf("Colesterol medio de todas las personas: %.2f mg/dL%n", getAverage());
		var reading = findMax();

		System.out.printf("Colesterol máximo: %.2f mg/dL (DNI: %0,10d)%n", reading.getReading(), reading.getId());
		System.out.println();

		showGlobalLevels();
	}

	/**
	 * Mostrar niveles de la empresa
	 * 
	 * @param corporation Empresa a mostrar
	 */
	public void showCorporateLevels(int corporation) {
		int optimum = 0;
		int normal = 0;
		int risk = 0;

		// Para cada medida miramos si es inferior a nivel normal o superior al valor de riesgo
		for (var nextReading : readings) {
			// Si la medida no es de un miembro de la empresa saltamos a la siguiente
			if (nextReading.getCorporation() != corporation)
				continue;

			if (nextReading.getReading() < NORMAL_READING)
				optimum++;

			else if (nextReading.getReading() >= AT_RISK)
				risk++;

			else
				normal++;
		}
		// Reemplazamos [NUMBER] por el número de empresa
		var heading = CORPORATE_LEVELS.replace("[NUMBER]", Integer.toString(corporation));
		System.out.println(heading);

		System.out.println();
		System.out.printf("Óptimo (<%.0f): %d personas%n", NORMAL_READING, optimum);
		System.out.printf("Normal (%.0f-%.0f): %d personas%n", NORMAL_READING, AT_RISK - 1, normal);
		System.out.printf("Peligroso (>=%.0f): %d personas%n", AT_RISK, risk);
	}

	/**
	 * Mostrar personas en peligro de la empresa
	 * 
	 * @param corporation Empresa a analizar
	 */
	public void showAtRish(int corporation) {
		// Reemplazamos [NUMBER] por el número de empresa
		var heading = CORPORATE_AT_RISK.replace("[NUMBER]", Integer.toString(corporation));
		System.out.println(heading);
		System.out.println();
		
		for (var nextReading : readings) {
			// Si la medida no es de un miembro de la empresa saltamos a la siguiente
			if (nextReading.getCorporation() != corporation)
				continue;
			// Si el nivel de la medida esta en el rango de riesgo mostramos la información
			if (nextReading.getReading() >= AT_RISK) {
				System.out.printf("DNI: %0,10d%n", nextReading.getId());
			}
		}
	}

	/**
	 * Mostrar estadísticas de la empresa
	 * 
	 * @param corporation Empresa a mostrar
	 */
	public void showCorporateInfo(int corporation) {
		// Reemplazamos [NUMBER] por el número de empresa
		var heading = CORPORATE_HEADING.replace("[NUMBER]", Integer.toString(corporation));
		System.out.println(heading);
		System.out.println();

		showCorporateLevels(corporation);
		System.out.println();

		showAtRish(corporation);
		System.out.println();

		System.out.println(FOOTER);
	}

	public static void main(String args[]) {
		var obj = new ActividadEvaluableTrimestre1();

		var corp = obj.getCorporationId();
		System.out.println();

		obj.showGeneralInfo();
		System.out.println();

		obj.showCorporateInfo(corp);
	}
}
