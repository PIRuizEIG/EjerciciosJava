package operadores2;
import java.util.Scanner;

public class ConversorEurosDolares {
	/* Programa de Conversión de Euros a Dolares
	 * Pide por pantalla la cantidad de euros y 
	 * debe devolver la cantidad de dólares
	 * Se debe controlar que la cantidad introducida
	 * sea un número positivo o mostrar error
	 * 1 € = 1,17 $
	 * 
	 * Autor: Pablo Illescas
	 */
	public static void main (String[] args)
	{
		// Declaración de variables
		Scanner sc = new Scanner(System.in);
		float euros, dolares;
		// Pedimos el valor en euros
		System.out.println("Introduzca un valor en Euros: ");
		euros = sc.nextFloat();
		// Comprobamos si el valor es valido
		if (euros < 0)
		{
			System.out.println("ERROR. No se puede convertir un valor negativo.");
		}
		else
		{
			// Si el valor es valido realizamos la conversión y mostramos resultado
			dolares = euros * 1.17f;
			System.out.printf("%.2f€ son %.2f$%n", euros, dolares);
		}
		// Cerramos el scanner
		sc.close();
	}
}
