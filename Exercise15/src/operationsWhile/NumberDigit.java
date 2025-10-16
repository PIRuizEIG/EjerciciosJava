package operationsWhile;
import java.util.Scanner;
/* Escribir un programa que solicite la carga de un número
 * entre 0 y 999, y nos muestre un mensaje de cuántos dígitos
 * tiene el mismo. Finalizar el programa cuando se cargue el valor 0.
 * Autor: Pablo Illescas Ruiz
 */
public class NumberDigit {
	// Constantes de configuración
	final static int ESCAPE = 0;
	final static int MIN = 0;
	final static int MAX = 999;
	public static void main(String args[]) {
		// Declaración de variables
		Scanner sc = new Scanner(System.in);
		int value;
		
		do {
			// Introducción de valor
			System.out.printf("Introduzca un valor entre %d y %d. Introduzca %d para salir%n", 
					MIN, MAX, ESCAPE);
			value = sc.nextInt();
			
			// Comprobación de errores
			if (value < MIN || value > MAX) {
				System.out.println("Valor no valido");
			} else {
				
				// Comprobar el valor
				int tmp;
				
				if (value < 10) tmp = 1;
				else if (value < 100) tmp = 2;
				else tmp = 3;
				
				System.out.printf("El número %d tiene %d cifras%n", value, tmp);
			}
		} while (value != ESCAPE);
		sc.close();
	}
}
