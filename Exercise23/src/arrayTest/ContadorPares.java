package arrayTest;

/* Crea una clase llamada ContadorPares que tenga un atributo privado de tipo array de enteros.
 * La clase debe incluir:
 *  • Un constructor que reciba un array de enteros y lo asigne al atributo.
 *  • Un método público contarPares() que recorra el array del atributo y 
 *  	devuelva la cantidad de números pares que contiene.
 *  • Métodos getter y setter para acceder y modificar el array.
 *  • En el método main, crea una instancia de la clase con un array de 
 *  	ejemplo, y llama al método contarPares() para mostrar el resultado por pantalla.
 * Autor: Pablo Illescas
 */
import java.util.Scanner;

/**
 * Clase con array de enteros que cuenta cuantos pares contiene
 */
public class ContadorPares {
	/**
	 * Tamaño del array
	 */
	static final int SIZE = 5;

	/**
	 * Array de enteros
	 */
	private int intArray[];

	/**
	 * Constructor con Array recibido
	 * 
	 * @param array Array de enteros
	 */
	public ContadorPares(int array[]) {
		init(array);
	}

	/**
	 * Inicializar la clase con un Array
	 * 
	 * @param array Array a asignar
	 */
	private void init(int array[]) {
		this.intArray = array;
	}

	/**
	 * Devuelva la cantidad de números pares que contiene la clase
	 * 
	 * @return Cantidad de pares
	 */
	public int contarPares() {
		int c = 0;

		for (int value : intArray) {
			if (value % 2 == 0)
				c++;
		}
		return c;
	}

	/**
	 * Setter del Array
	 * 
	 * @param Array nuevo array
	 */
	public void setArray(int array[]) {
		this.intArray = array;
	}

	/**
	 * Getter del Array
	 * 
	 * @return Array de la clase
	 */
	public int[] getArray() {
		return intArray;
	}

	/**
	 * Método que crea un array y lo llena de valores introducidos por teclado
	 * @return Array de enteros lleno
	 */
	private static int[] inputArray() {
		@SuppressWarnings("resource")
		// Entrada por teclado @SuppressWarnings quita el warning por no cerrar Scanner
		Scanner sc = new Scanner(System.in);
		// Crear Array de enteros
		var array = new int[SIZE];

		// Introducimos valores
		for (int i = 0; i < array.length; i++) {
			System.out.printf("Introduzca el valor %d de %d: ", i + 1, SIZE);
			array[i] = sc.nextInt();
		}

		return array;

	}

	public static void main(String args[]) {

		// Crear Array de enteros
		int[] miArray;

		miArray = inputArray();
		
		// Creamos objeto con el array creado
		ContadorPares c = new ContadorPares(miArray);

		System.out.printf("El array contiene %d pares.\n", c.contarPares());
	}
}
