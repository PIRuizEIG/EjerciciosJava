package matrixTest;

import java.util.concurrent.ThreadLocalRandom;
// ThreadLocalRandom permite generar números semi aleatorios de varios tipos. Soporta multiples hilos

/* Crea un array de 10 números enteros.
 *  • Llena este array con números aleatorios entre 1 y 100.
 *  • Usa un ciclo for-each para recorrer el array y:
 *   • Imprimir cada número.
 *   • Calcular el promedio de los números.
 *   • Contar cuántos números son mayores que el promedio.
 *   • Imprimir la cantidad de números mayores que el promedio
 * Autor: Pablo Illescas
 */

/**
 * Clase que contiene un array de enteros y permite calcular el promedio y
 * contar y mostrar elementos sobre el promedio.
 */
public class PromNumbers {
	/**
	 * Longitud del array
	 */
	public static final int SIZE = 10;

	/**
	 * Valor máximo para el array
	 */
	public static final int MAXVALUE = 100;

	/**
	 * Declaración de atributo
	 */
	private int[] array;

	/**
	 * Constructor que crea objeto de tamaño preestablecido
	 */
	public PromNumbers() {
		this(SIZE);
	}

	/**
	 * Constructor que crea objeto de tamaño recibido
	 * 
	 * @param size
	 */
	public PromNumbers(int size) {
		array = new int[size];
		fillArray(array);
	}

	/**
	 * Llena un array con valores aleatorios de 1 a MAXVALUE Usa Math.random y un
	 * casting para obtener enteros
	 * 
	 * @param array Array a rellenar
	 */
	public void oldFillArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) ((Math.random() * MAXVALUE) + 1);
		}
	}

	/**
	 * Llena un array con valores aleatorios de 1 a MAXVALUE Usa ThreadLocalRandom.
	 * No requiere casting ya que soporta varios tipos nativamente, no requiere
	 * multiplicar ya que pide los valores mínimo y máximo (máximo exclusivo) y
	 * soporta mejor apliciones con multiples hilos.
	 * 
	 * @param array Array a rellenar
	 */
	public void fillArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = ThreadLocalRandom.current().nextInt(1, MAXVALUE + 1);
		}
	}

	/**
	 * Muestra el contenido de un array
	 * 
	 * @param array Array a mostrar
	 */
	public void showAnArray(int[] array) {
		for (var num : array) {
			System.out.printf("%02d ", num);
		}
		System.out.println();
	}

	/**
	 * Muestra el contenido del array
	 */
	public void showArray() {
		showAnArray(array);
	}

	/**
	 * Calcula el promedio de los enteros del array
	 * 
	 * @return Double con el promedio
	 */
	public double average() {
		int sum = 0;

		for (var num : array) {
			sum += num;
		}

		return (double) sum / array.length;
	}

	/**
	 * Cuenta cuantos elementos del array superan la media
	 * 
	 * @return Entero con la cantidad de números superior a la media
	 */
	public int aboveAverage() {
		int amount = 0;

		double average = average();

		for (var num : array) {
			if (num > average)
				amount++;
		}

		return amount;
	}

	/**
	 * Cuenta cuantos elementos del array superan la media
	 * 
	 * @param average Media
	 * @return Entero con la cantidad de números superior a la media
	 */
	public int aboveAverage(double average) {
		int amount = 0;

		for (var num : array) {
			if (num > average)
				amount++;
		}

		return amount;
	}

	/**
	 * Muestra por consola los elementos del array superiores a la media
	 */
	public void showAboveAverage() {
		double average = average();

		showAboveAverage(average);
	}

	/**
	 * Muestra por consola los elementos del array superiores a la media
	 * 
	 * @param average Media
	 */
	public void showAboveAverage(double average) {
		for (var num : array) {
			if (num > average)
				System.out.printf("%02d ", num);
		}
		System.out.println();
	}

	public static void main(String args[]) {
		double average;

		var obj = new PromNumbers();
		obj.showArray();
		average = obj.average();
		System.out.printf("Promedio: %.2f%n", average);
		System.out.printf("Elementos sobre la media: %d%n", obj.aboveAverage(average));
		obj.showAboveAverage(average);
	}
}
