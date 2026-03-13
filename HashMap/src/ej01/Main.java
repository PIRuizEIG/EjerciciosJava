package ej01;

import java.util.Scanner;
import formato.JavaFormat;

/**
 * Ejercicio 1: Control de acceso Implementa el control de acceso al área
 * restringida de un programa. Se debe pedir un nombre de usuario y una
 * contraseña. Si el usuario introduce los datos correctamente, el programa dirá
 * "Ha accedido al área restringida". El usuario tendrá un máximo de 3
 * oportunidades. Si se agotan las oportunidades el programa dirá "Lo siento, no
 * tiene acceso al área restringida". Los nombres de usuario con sus
 * correspondientes contraseñas deben estar almacenados en una estructura de la
 * clase HashMap.
 */
public class Main {
	/**
	 * Cantidad de intentos permitidos
	 */
	public static final int MAX_TRIES = 3;
	/**
	 * Mensaje de acceso
	 */
	private static final String SUCCESS = "Ha accedido al área restringida";
	/**
	 * Mensaje de fallo
	 */
	private static final String FAILED = "Lo siento, no tiene acceso al área restringida";

	/**
	 * Bucle de ejecución
	 */
	public static void appLoop() {
		// Iniciar los intentos
		var tries = MAX_TRIES;
		// Accesso concedido = falso
		var accessGranted = false;
		// Crear hashmap
		var dictionary = new Dictionary();
		// Cargar el scanner
		try (var sc = new Scanner(System.in);) {
			// Mientras queden intentos y no tengamos acceso
			while (tries > 0 && !accessGranted) {
				// Pedir usuario y contraseña
				var name = CustomInput.requestInput(sc, "Introduzca el nombre de usuario: ");
				var pw = CustomInput.requestInput(sc, "Introduzca la contraseña: ");
				System.out.print(JavaFormat.BOLD);
				// Si la respuesta es correcta informar de acceso concedido
				if (dictionary.checkPassword(name, pw)) {
					System.out.print(JavaFormat.GREEN);
					System.out.println(SUCCESS);
					accessGranted = true;
					// Informar de acceso NO concedido y restar intentos
				} else {
					System.out.print(JavaFormat.RED);
					System.out.println(FAILED);
					tries--;
					System.out.printf("Quedan %d intentos.%n", tries);
				}
				// Reiniciar formato
				System.out.print(JavaFormat.RESET);
			}
			// Dar mensaje dependiendo si se ha entrado o no
			if (accessGranted)
				System.out.println("Bienvenido");
			else
				System.out.println("Adios");
		}
	}

	/**
	 * Método de ejecución
	 */
	public static void main(String[] args) {
		appLoop();
	}

}
