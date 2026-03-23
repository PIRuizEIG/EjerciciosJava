package utilities.input;

import java.util.Scanner;

/**
 * Entrada personalizada
 */
public class CustomInput {
	/**
	 * Pedir texto al usuario
	 * 
	 * @param sc    Scanner
	 * @param label Mensaje al usuario
	 * @return Cadena de respuesta
	 */
	public static String requestInput(Scanner sc, String label) {
		System.out.print(label);
		return sc.nextLine().trim();
	}

	/**
	 * Pedir un entero al usuario
	 * 
	 * @param sc    Scanner
	 * @param label Mensaje al usuario
	 * @return Entero introducido por el usuario
	 */
	public static int requestInteger(Scanner sc, String label) {
		while (true) {
			try {
				return Integer.parseInt(requestInput(sc, label));
			} catch (NumberFormatException e) {
				System.err.println("Error, introduce un número válido");
			}
		}
	}

	/**
	 * Pedir un entero al usuario con valor mínimo aceptable
	 * 
	 * @param sc    Scanner
	 * @param label Mensaje al usuario
	 * @param min   Valor mínimo
	 * @return Entero introducido por el usuario
	 */
	public static int requestInteger(Scanner sc, String label, int min) {
		int value;
		do {
			value = requestInteger(sc, label);
			if (value < min) {
				System.err.println("Debe ser superior a " + min);
			}
		} while (value < min);
		return value;
	}

	/**
	 * Pedir un entero al usuario con valor con rango aceptable
	 * 
	 * @param sc    Scanner
	 * @param label Mensaje al usuario
	 * @param min   Valor mínimo
	 * @param max   Valor máximo
	 * @return Entero introducido por el usuario
	 */
	public static int requestInteger(Scanner sc, String label, int min, int max) {
		int value;
		do {
			value = requestInteger(sc, label);
			if (value < min || value > max) {
				System.err.println("Debe estar entre " + min + " y " + max);
			}
		} while (value < min || value > max);
		return value;
	}

	/**
	 * Pedir un valor decimal al usuario
	 * 
	 * @param sc    Scanner
	 * @param label Mensaje al usuario
	 * @return Entero introducido por el usuario o -1 al encontrar errores
	 */
	public static double requestDouble(Scanner sc, String label) {
		while (true) {
			try {
				return Double.parseDouble(requestInput(sc, label));
			} catch (NumberFormatException e) {
				System.err.println("Error, introduce un número válido");
			}
		}
	}

	/**
	 * Pedir un valor decimal al usuario con valor mínimo aceptable
	 * 
	 * @param sc    Scanner
	 * @param label Mensaje al usuario
	 * @param min   Valor mínimo
	 * @return Decimal introducido por el usuario
	 */
	public static double requestDouble(Scanner sc, String label, double min) {
		double value;
		do {
			value = requestDouble(sc, label);
			if (value < min) {
				System.err.println("Debe ser superior a " + min);
			}
		} while (value < min);
		return value;
	}

	/**
	 * Pedir un valor decimal al usuario con rango aceptable
	 * 
	 * @param sc    Scanner
	 * @param label Mensaje al usuario
	 * @param min   Valor mínimo
	 * @param max   Valor máximo
	 * @return Decimal introducido por el usuario
	 */
	public static double requestDouble(Scanner sc, String label, double min, double max) {
		double value;
		do {
			value = requestDouble(sc, label);
			if (value < min || value > max) {
				System.err.println("Debe estar entre " + min + " y " + max);
			}
		} while (value < min || value > max);
		return value;
	}

	/**
	 * @param sc    Entrada por teclado
	 * @param label Mensaje al usuario
	 * @return Confirmación
	 */
	public static boolean confirm(Scanner sc, String label) {
		while (true) {
			String input = requestInput(sc, label + " (s/n): ").toLowerCase();
			if (input.equals("s"))
				return true;
			if (input.equals("n"))
				return false;
			System.err.println("Introduce 's' o 'n'");
		}
	}

	/**
	 * Pausar
	 * 
	 * @param sc Entrada por teclado
	 */
	public static void pause(Scanner sc) {
		System.out.println("Pulsa ENTER para continuar...");
		sc.nextLine();
	}
}
