package operationsWhile;
import java.util.Scanner;
/* Desarrollar un programa que permita la carga de 10 valores por teclado
 * y nos muestre posteriormente la suma de los valores ingresados y su promedio.
 * Autor: Pablo Illescas Ruiz
 */
public class AditionAverage {
	// Variable de configuración
	final static int AMOUNT = 10;
	public static void main(String args[]) {
		// Declaración de variables
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int value = 0;
		
		// Entrada de valores
		for (int i = 0; i < AMOUNT; i++) {
			System.out.printf("Introduzca el valor nº %d: ", i+1);
			value = sc.nextInt();
			sum += value;
		}
		
		// Mostrar el resultado
		System.out.printf("La suma de valores es %d y la media es %.2f%n",
				sum, (float)sum/AMOUNT);
		sc.close();
	}
}
