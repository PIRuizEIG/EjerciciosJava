package operationsFor;

import java.util.Scanner;

/* Muestra la tabla de multiplicar de un número introducido por teclado.
 * Autor: Pablo Illescas
 */
public class MultiTable {
	public static void main(String args[]) {
		// Variables
		Scanner sc = new Scanner(System.in);
		int value;

		do {
			// Guardar el valor a usar
			System.out.println("Intruzca un nº del 1 al 9");
			value = sc.nextInt();

			// Comprobar validez
			if (value < 1 || value > 9)
				System.out.println("Valor no valido");
		} while (value < 1 || value > 9);

		// Mostrar la tabla
		for (int i = 1; i <= 10; i++) {
			System.out.printf("%02d x %02d = %02d%n", value, i, value * i);
		}

		sc.close();
	}
}
