package actEvalTri1;

import java.util.Random;

/**
 * <h1>Lectura médica</h1>
 * <p>
 * Clase que simula una lectura de datos médicos contiene:
 * <ul>
 * <li>DNI - id Entero</li>
 * <li>Empresa - Corporation Entero</li>
 * <li>Lectura de colesterol - reading Double</li>
 * </ul>
 */
public class Reading {
	/**
	 * Valor mínimo
	 */
	public static final int MIN = 1;

	/**
	 * Varlor máximo DNI
	 */
	public static final int ID_MAX = 100000000;

	/**
	 * Valor máximo de Empresa
	 */
	public static final int CORP_MAX = 5;

	/**
	 * Valor mínimo de la lectura de Colesterol
	 */
	public static final double READ_MIN = 120;

	/**
	 * Valor máximo de la lectora de Colesterol
	 */
	public static final double READ_MAX = 330;

	/**
	 * DNI del empleado
	 */
	private int id;

	/**
	 * Empresa del empleado
	 */
	private int corporation;

	/**
	 * Lectura de colesterol
	 */
	private double reading;

	/**
	 * Generar una lectura médica de un empleado
	 */
	public Reading() {
		var rnd = new Random();
		
		this.id = rnd.nextInt(MIN, ID_MAX);
		this.corporation = rnd.nextInt(MIN, CORP_MAX + 1);
		this.reading = rnd.nextDouble(READ_MIN, READ_MAX);
	}

	/**
	 * Obtener el DNI del empleado
	 * 
	 * @return Entero con el DNI del empleado sin letra
	 */
	public int getId() {
		return id;
	}

	/**
	 * Obtener la empresa del empleado
	 * 
	 * @return Entero con el número de empresa del empleado
	 */
	public int getCorporation() {
		return corporation;
	}

	/**
	 * Obtener la medida de colesterol del empleado
	 * 
	 * @return Double con la medida de colesterol
	 */
	public double getReading() {
		return reading;
	}
}
