package operadores2;

import java.util.Scanner;

/* Dolares	1,17
 * Yen		175,81
 * Libras	0,87
 * Sol		4,04
 * Florines	2,10
 * Conversor con un switch, case 1 Euros a Dolares
 * Case 2 a yenes, case 3 a libras, case 4 a soles
 * Case 5 a florines
 * Autor: Pablo Illescas
 */
public class ConversorSwitch {
	// Valores de las monedas
	final static double DOLAR = 1.17f;
	final static double YEN = 175.81f;
	final static double LIBRA = 0.87f;
	final static double FLORIN = 2.10f;
	final static double SOL = 4.04f;
	
	public static void main (String[] args)
	{
		// Declaración de variables
		Scanner sc = new Scanner(System.in);
		double euros;
		int operacion;
		
		// Elegimos operacion		
		System.out.println("Introduzca: \n\"1\" para conversión (€)Euro -> ($)Dolar\n"
				+ "\"2\" para conversión (€)Euro -> (¥)Yen\n"
				+ "\"3\" para conversión (€)Euro -> (£)Libra\n"
				+ "\"4\" para conversión (€)Euro -> (S/)Sole  s\n"
				+ "\"5\" para conversión (€)Euro -> (ƒ)Florin");
		operacion = sc.nextInt();
		
		// Comprobamos si el valor es valido
		if (operacion < 1 || operacion > 5)
		{
			System.out.println("ERROR. Moneda no aceptada.");
			sc.close();
			// Return cierra función, sin valor por que el main es tipo void, o sin tipo
			return;
		}
		
		// Pedimos el valor en euros
		System.out.println("Introduzca un valor en Euros: ");
		euros = sc.nextDouble();
		
		// Comprobamos si el valor es valido
		if (euros < 0)
		{
			System.out.println("ERROR. No se puede convertir un valor negativo.");
			sc.close();
			// Return cierra función, sin valor por que el main es tipo void, o sin tipo
			return;
		}
		
		switch(operacion)
		{
		// Caso 1 conversión a dolar
		case 1:
			System.out.printf("%.2f (€) son %.2f ($)%n", euros, euros * DOLAR);
			break;
		// Caso 2 conversión a Yenes		
		case 2:
			System.out.printf("%.2f (€) son %.2f (¥)%n", euros, euros * YEN);
			break;
		// Caso 3 conversión a Libras
		case 3:
			System.out.printf("%.2f (€) son %.2f (£)%n", euros, euros * LIBRA);
			break;
		// Caso 4 conversión a Soles
		case 4:
			System.out.printf("%.2f (€) son %.2f (S/)%n", euros, euros * SOL);
			break;
		// Caso 5 conversión a Florines
		case 5:
			System.out.printf("%.2f (€) son %.2f (ƒ)%n", euros, euros * FLORIN);
			break;
		// Otra opción
		default:
			System.out.println("Moneda no aceptada");
		}
		
		sc.close();
	}
}
