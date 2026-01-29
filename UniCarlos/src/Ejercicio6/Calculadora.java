package Ejercicio6;

/**
 * <h1>Calculadora con métodos static y niveles de acceso</h1>
 * <p>
 * Crea una clase Calculadora como "caja de herramientas" con operaciones
 * matemáticas.
 * <h2>Requisitos:</h2>
 * <ul>
 * <li>Método static public double sumar(double a, double b): devuelve a + b.
 * </li>
 * <li>Método static protected double multiplicar(double a, double b): devuelve
 * a * b (solo subclases/paquete).</li>
 * <li>Método static private double raizCuadrada(double x): devuelve
 * Math.sqrt(x) si x >= 0, sino -1.</li>
 * <li>Método static public double hipotenusa(double cat1, double cat2):
 * <ul>
 * <li>Usa raizCuadrada(multiplicar(cat1,cat1) + multiplicar(cat2,cat2)).</li>
 * </ul>
 * </li>
 * <li>Atributo static final public double PI = 3.1416 (constante
 * compartida).</li>
 * </ul>
 * <h2>Autor: Pablo Illescas</h2>
 */
public class Calculadora {
	/**
	 * Suma los dos elementos recibidos
	 */
	public static double sumar(double a, double b) {
		return a + b;
	}

	/**
	 * Multiplica los dos elementos recibidos. Solo accesible desde subclases y el
	 * paquete
	 */
	protected static double multiplicar(double a, double b) {
		return a * b;
	}

	/**
	 * Devuelve la raiz cuadrada del elemento recibido si es mayor a 0, si no
	 * devuelve -1
	 */
	private static double raizCuadrada(double x) {
		if (x < 0)
			return -1;
		return Math.sqrt(x);
	}

	/**
	 * Devuelve la raíz cuadrada de la suma de los cuadrados de los catetos
	 */
	public static double hipotenusa(double cat1, double cat2) {
		return raizCuadrada(multiplicar(cat1, cat1) + multiplicar(cat2, cat2));
	}
	
	/**
	 * Valor de PI
	 */
	public static final double PI = Math.PI;
}
