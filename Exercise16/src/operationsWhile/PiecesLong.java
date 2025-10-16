package operationsWhile;
import java.util.Scanner;
/* Confeccionar un programa que pida ingresar por teclado la cantidad
 * de piezas a procesar y luego ingrese la longitud de cada perfil.
 * Sabiendo que la pieza cuya longitud este comprendida en el rango
 * de 1,20 y 1,30 son aptas, imprimir por pantalla la cantidad de
 * piezas aptas que hay en el lote.
 * Autor: Pablo Illescas
 */
public class PiecesLong {
	// Constantes de configuración
	final static double MIN = 1.20;
	final static double MAX = 1.30;
	
	// Metodo de ejecución
	public static void main(String args[]) {
		// Declaración de variables
		Scanner sc = new Scanner(System.in);
		int amount;
		double length;
		int valid = 0;
		
		// Pedimos la cantidad de piezas en el lote
		System.out.print("Introduzca el tamaño del lote: ");
		amount = sc.nextInt();
		
		// Bucle del tamaño del lote
		for (int i = 0; i < amount; i++) {
			
			// Pedimos la longitud de la pieza y la comprobamos
			System.out.printf("Introduzca la longitud de la pieza %d: ", i+1);
			length = sc.nextDouble();
			
			if (length >= MIN && length <= MAX) {
				valid++;
			}
		}
		
		// Indicamos cuantas piezas eran buenas
		if (valid == 1) System.out.printf("Había %d pieza del tamaño correcto%n", valid);
		else 		System.out.printf("Había %d piezas del tamaño correcto%n", valid);
		sc.close();
	}
}
