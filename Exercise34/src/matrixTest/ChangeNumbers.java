package matrixTest;

import java.util.Scanner;

/* Desarrolla un programa en Java que genere 30 números enteros aleatorios entre 0 y 20,
 * almacenados en un array que sea un atributo de la clase.
 * El programa debe mostrar estos números separados por espacios.
 * A continuación, mediante métodos y solicitando la entrada por teclado, el programa deberá
 * pedir dos valores: un número a reemplazar y el nuevo valor con el que sustituirlo.
 * Se sustituirán todas las ocurrencias del primer número por el segundo en el array.
 * Los números que hayan sido sustituidos deben mostrarse entrecomillados en la salida.
 * Autor: Pablo Illescas
 */

/**
 * Clase que crea un objeto con una matriz de enteros e incluye un método para
 * sustituir valores en el array.
 */
public class ChangeNumbers {
	/**
	 * Longitud del array
	 */
	public static final int SIZE = 30;

	/**
	 * Valor máximo para el array
	 */
	public static final int MAXVALUE = 20;

	/**
	 * Declaración de atributo
	 */
	private int[] array;

	/**
	 * Constructor que crea objeto de tamaño preestablecido
	 */
	public ChangeNumbers() {
		this(SIZE);
	}

	/**
	 * Constructor que crea objeto de tamaño recibido
	 * 
	 * @param size
	 */
	public ChangeNumbers(int size) {
		this.array = new int[size];
		fillArray(array);
	}

	/**
	 * Llena un array con valores aleatorios de 0 a MAXVALUE
	 * 
	 * @param array Array a rellenar
	 */
	public void fillArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * (MAXVALUE + 1));
		}
	}

	/**
	 * Muestra el contenido de un array
	 * 
	 * @param array Array a mostrar
	 */
	public void showArray(int[] array) {
		for (var num : array) {
			System.out.printf("%02d ", num);
		}
		System.out.println();
	}

	/**
	 * Reemplaza todas las ocurrencias de 'value' por 'newValue' en el array,
	 * mostrando entrecomillados los valores modificados.
	 * 
	 * @param num      Valor a reemplazar
	 * @param newValue Nuevo valor
	 */
	public void replace(int value, int newValue) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == value) {
				array[i] = newValue;
				System.out.printf("\"%02d\" ", array[i]);
			} else {
				System.out.printf("%02d ", array[i]);
			}
		}
		System.out.println();
	}

	/**
	 * Metodo auxiliar para pedir valores
	 * 
	 * @param message Mensaje para pedir dimensiones
	 * @param sc      Scanner para introducir los valores
	 * @return Entero con la dimensión de la matriz
	 */
	private static int getNum(String message, Scanner sc) {
		int num;
		do {
			System.out.println(message);
			num = sc.nextInt();
			if (num < 0)
				System.out.println("Error. El valor debe ser positivo.");
		} while (num < 0);
		return num;
	}

	public static void main(String args[]) {
		int value, newValue;
		Scanner sc = new Scanner(System.in);

		var obj = new ChangeNumbers();
		obj.showArray(obj.array);

		value = getNum("Valor a reemplazar: ", sc);
		newValue = getNum("Valor a nuevo valor: ", sc);

		obj.replace(value, newValue);
	}
}
