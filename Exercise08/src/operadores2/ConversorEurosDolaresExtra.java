package operadores2;

import java.util.Scanner;

public class ConversorEurosDolaresExtra {
	/*  conversor Euros-Dólares y Dólares-Euros.
	 * Se pide por pantalla antes de pedir la cantidad de entrada
	 * si se quiere convertir E->D introduzca
	 * E y si se quiere cambiar de D->E introduzca D.
	 * Se debe controlar si no mete la conversión correcta
	 * pues se toma por defecto E->D.
	 * 
	 * Autor: Pablo Illescas
	 */
	// Creamos una tasa de conversión fija con una constante
	final static float TASA = 1.17f;
	public static void main (String[] args)
	{
		// Declaración de variables
		Scanner sc = new Scanner(System.in);
		float euros, dolares;
		// Preguntamos el tipo de operación
		char operacion;
		/*do { Versión control de errores NO VALIDO
			System.out.println("Introduzca \"E\" para conversión Euro -> Dolar "
					+ "o introduzca \"D\" para conversión Dolar -> Euro");
			operacion = sc.next().charAt(0);
			if (operacion != 'E' && operacion != 'D' && operacion != 'e' && operacion != 'd')
				System.out.println("Error. \"" +operacion + "\" no es una respuesta valida");
		} while (operacion != 'E' && operacion != 'D' && operacion != 'e' && operacion != 'd');*/
		System.out.println("Introduzca \"E\" para conversión Euro -> Dolar "
				+ "o introduzca \"D\" para conversión Dolar -> Euro");
		/* String.toUpperCase() pasa toda la cadena a mayusculas para reducir comprobaciones logicas y 
		 * String.charAt(0) devuelve el carácter en la posición 0, el primer carácter, de la cadena.
		 */
		operacion = sc.next().toUpperCase().charAt(0);
		// Comprobación de errores
		if (operacion != 'E' && operacion != 'D') {
			System.out.println("Error. \"" + operacion + "\" no es una respuesta valida. "
					+ "Calculando conversión Euro -> Dolar");
			operacion = 'E';
		}
		// Si calculamos Euros -> Dolares
		if (operacion == 'E')
		{
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
				dolares = euros * TASA;
				System.out.printf("%.2f€ son %.2f$%n", euros, dolares);
			}
		}
		// Si calculamos Dolares -> Euros
		else
		{
			// Pedimos el valor en dolares
			System.out.println("Introduzca un valor en Dolares: ");
			dolares = sc.nextFloat();
			// Comprobamos si el valor es valido
			if (dolares < 0) {
				System.out.println("ERROR. No se puede convertir un valor negativo.");
			}
			else {
				// Si el valor es valido realizamos la conversión y mostramos resultado
				euros = dolares / TASA;
				System.out.printf("%.2f$ son %.2f€%n", dolares, euros);
			}
		}
		// Cerramos el scanner
		sc.close();
	}
}
