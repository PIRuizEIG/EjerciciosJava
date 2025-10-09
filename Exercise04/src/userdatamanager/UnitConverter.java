package userdatamanager;

import java.util.Scanner;

/* Escribe un programa que pida al usuario ingresar:
 * • Una distancia en kilómetros (decimal)
 * • Una temperatura en grados Celsius (decimal)
 * El programa debe convertir: 
 * • Kilómetros a millas (1 km = 0.621371 millas) 
 * • Celsius a Fahrenheit (F = C * 9/5 + 32)
 * Finalmente muestra un resumen con las cantidades originales y convertidas, 
 * usando printf con formato avanzado para alinear columnas (de 20 caracteres) 
 * y controlar decimales.
 *	+----------------------+----------+
 *	|     Description      |  Value   |
 *	+----------------------+----------+
 *	|  Distance (km)       |    10,00 |
 *	|  Distance (miles)    |     6,21 |
 *	|  Temperature (ºC)    |    10,00 |
 *	|  Temperature (ºF)    |    50,00 |
 *	+----------------------+----------+
 *	Para un número decimal con 2 decimales que ocupe 8 espacios %8.2f
 * Autor: Pablo Illescas
 */

public class UnitConverter {
	public static void main(String[] args) {
		// Iniciar Scanner
		Scanner sc = new Scanner(System.in);

		// Ingresar: distancia en kilómetros y temperatura en grados Celsius
		System.out.println("Enter distance in kilometers: ");
		float distance = sc.nextFloat();
		System.out.println("Enter temperatura in Celsius: ");
		float temperature = sc.nextFloat();

		// Kilómetros a millas (1 km = 0.621371 millas)
		float miles = distance * 0.621371f;
		// Celsius a Fahrenheit (F = C * 9/5 + 32)
		float fahrenheit = temperature * 9 / 5 + 32;

		/*
		 * Finalmente muestra un resumen con las cantidades originales y convertidas,
		 * usando printf con formato avanzado para alinear columnas (de 20 caracteres) y
		 * controlar decimales. +----------------------+----------+ | Description |
		 * Value | +----------------------+----------+ | Distance (km) | 10,00 | |
		 * Distance (miles) | 6,21 | | Temperature (ºC) | 10,00 | | Temperature (ºF) |
		 * 50,00 | +----------------------+----------+ Para un número decimal con 2
		 * decimales que ocupe 8 espacios %8.2f
		 */
		/*
		 * System.out.printf("+----------------------+----------+%n" +
		 * "|     Description      |  Value   |%n" +
		 * "+----------------------+----------+%n" +
		 * "|  Distance (km)       | %8.2f |%n" + "|  Distance (miles)    | %8.2f |%n" +
		 * "|  Temperature (ºC)    | %8.2f |%n" + "|  Temperature (ºF)    | %8.2f |%n" +
		 * "+----------------------+----------+%n", distance, miles, temperature,
		 * fahrenheit);
		 */
		System.out.printf("+----------------------+----------------------+%n"
				+ "|      Description     |        Value         |%n"
				+ "+----------------------+----------------------+%n" + "| %-20s | %20.2f |%n" + "| %-20s | %20.2f |%n"
				+ "| %-20s | %20.2f |%n" + "| %-20s | %20.2f |%n" + "+----------------------+----------------------+%n",
				"Distance (km)", distance, "Distance (miles)", miles, "Temperature (ºC)", temperature,
				"Temperature (ºF)", fahrenheit);

		// Cerrar scanner
		sc.close();
	}
}
