package operationsFor;
import java.util.Scanner;
/* Escribe un programa que muestre en tres columnas, el cuadrado y el cubo de
 * los 5 primeros números enteros a partir de uno que se introduce por teclado.
 * Autor: Pablo Illescas
 */
public class SquareTriple {
	static final int AMOUNT = 5;
	public static void main (String args[]) {
		// Declaración de variables
		Scanner sc = new Scanner(System.in);
		int value;
		
		// Introducimos número inicial
		System.out.println("Intruzca un número: ");
		value = sc.nextInt();
		
		// Mostramos la tabla
		System.out.printf("%10s%10s%10s%n", "Número", "Cuadrado", "Cubo");
		for (int i = value; i < AMOUNT + value; i++) {
			System.out.printf("%10d%10d%10d%n", i, i * i, i * i * i);
		}
		
		sc.close();
	}
}
