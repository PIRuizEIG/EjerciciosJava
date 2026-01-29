package Ejercicio4;

/**
 * <h1>Diseña una clase NIF que gestione un DNI con su letra.</h1>
 * <h2>Requisitos:</h2>
 * <p>
 * Atributos privados:
 * <ul>
 * <li>numero (int, 8 dígitos máximo).</li>
 * <li>letra (char).</li>
 * </ul>
 * <p>
 * Constructores:
 * <ul>
 * <li>NIF(int numero) que calcule automáticamente la letra.</li>
 * <li>Constructor de copia NIF(NIF otro).</li>
 * </ul>
 * <p>
 * Encapsulación: getters getNumero(), getLetra() y un método getNIFCompleto()
 * que devuelva algo como "12345678Z".
 * <p>
 * Métodos estáticos auxiliares:
 * <ul>
 * <li>static char calcularLetra(int numero) con el algoritmo típico.</li>
 * </ul>
 * <p>
 * Usa this para diferenciar parámetros de atributos en los constructores y
 * setters.
 * <h2>Autor: Pablo Illescas</h2>
 */
public class NIF {
	/**
	 * Número de hasta 8 dígitos
	 */
	private int numero;

	/**
	 * Carácter del DNI
	 */
	private char letra;

	/**
	 * Genera un DNI con el número asignado y calcula la letra
	 * 
	 * @param numero Número a asignar
	 */
	public NIF(int numero) {
		this.numero = numero;
		this.letra = calcularLetra(numero);
	}

	/**
	 * Duplica el DNI recibido
	 * 
	 * @param otro DNI a duplicar
	 */
	public NIF(NIF otro) {
		this(otro.numero);
	}

	/**
	 * Calcula la letra del DNI
	 * 
	 * @param num Número base
	 * @return Letra
	 */
	public static char calcularLetra(int num) {
		char carac = switch (num % 23) {
		case 0 -> 'T';
		case 1 -> 'R';
		case 2 -> 'W';
		case 3 -> 'A';
		case 4 -> 'G';
		case 5 -> 'M';
		case 6 -> 'Y';
		case 7 -> 'F';
		case 8 -> 'P';
		case 9 -> 'D';
		case 10 -> 'X';
		case 11 -> 'B';
		case 12 -> 'N';
		case 13 -> 'J';
		case 14 -> 'Z';
		case 15 -> 'S';
		case 16 -> 'Q';
		case 17 -> 'V';
		case 18 -> 'H';
		case 19 -> 'L';
		case 20 -> 'C';
		case 21 -> 'K';
		default -> 'E';
		};

		return carac;
	}

	/**
	 * Devolver número del DNI
	 * 
	 * @return Número
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * Devolver letra del DNI
	 * 
	 * @return Letra
	 */
	public char getLetra() {
		return letra;
	}

	/**
	 * Devolver NIF completo
	 * 
	 * @return Cadena con el NIF
	 */
	public String getNIFCompleto() {
		return Integer.toString(numero) + letra;
	}
}
