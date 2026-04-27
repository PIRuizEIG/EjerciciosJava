package exercises.ex04;

import java.util.Scanner;

import utilities.console.ConsoleUI;
import utilities.console.Icons;
import utilities.input.CustomInput;

/**
 * Prueba las clases creadas mediante un programa con un menú como el que se
 * muestra a continuación:<br>
 * VEHÍCULOS =========<br>
 * 1. Anda con la bicicleta<br>
 * 2. Haz el caballito con la bicicleta<br>
 * 3. Anda con el coche<br>
 * 4. Quema rueda con el coche<br>
 * 5. Ver kilometraje de la bicicleta<br>
 * 6. Ver kilometraje del coche<br>
 * 7. Ver kilometraje total<br>
 * 8. Salir Elige una opción (1-8):<br>
 * 
 */
public class Main {

	public static final String[] OPTIONS = { Icons.PLAY + "\t1. Anda con la bicicleta\n",
			Icons.ARROW_UP + "\t2. Haz el caballito con la bicicleta\n", Icons.PLAY + "\t3. Anda con el coche\n",
			Icons.FIRE + "\t4. Quema rueda con el coche\n", Icons.CLOCK + "\t5. Ver kilometraje de la bicicleta\n",
			Icons.CLOCK + "\t6. Ver kilometraje del coche\n", Icons.CLOCK + "\t7. Ver kilometraje total\n",
			Icons.CENSOR + "\t0. Salir\n" };

	/** Programa */
	public static void app() {
		// Abrir scanner
		try (var sc = new Scanner(System.in);) {
			// Crear e inicializar variables
			int option = -1;
			var bici = new Bicicleta();
			var coche = new Coche();
			while (option != 0) {
				ConsoleUI.header("VEHÍCULOS");
				// var label = "";
				// for (var string : OPTIONS) { label += string; }
				// label += "Opción (0-" + (OPTIONS.length - 1) + "): ";
				// Pedimos opción
				System.out.print(String.join("", OPTIONS));
				var label = String.format("Opción (0-%d): ", (OPTIONS.length - 1));
				option = CustomInput.requestInteger(sc, label);
				// Si la opción no es válida avisamos
				if (option < 0 || option > OPTIONS.length - 1) {
					ConsoleUI.error("Error, opción no válida");
					continue;
				}
				switch (option) {
				// Anda con la bicicleta
				case 1:
					bici.andar();
					break;
				// Haz el caballito con la bicicleta
				case 2:
					bici.hacerCaballito();
					break;
				// Anda con el coche
				case 3:
					coche.andar();
					break;
				// Quema rueda con el coche
				case 4:
					coche.quemarRueda();
					break;
				// Ver kilometraje de la bicicleta
				case 5:
					label = String.format("La bicicleta ha recorrido %.3f Km", bici.getKilometrosRecorridos());
					System.out.println(label);
					break;
				// Ver kilometraje del coche
				case 6:
					label = String.format("El coche ha recorrido %.3f Km", coche.getKilometrosRecorridos());
					System.out.println(label);
					break;
				// Ver kilometraje total
				case 7:
					label = String.format("En total los vehiculos han recorrido %.3f Km", Vehiculo.getKilometrosTotales());
					System.out.println(label);
					break;
				// Cierre de programa
				case 0:
					// Avisar
					ConsoleUI.info("Cerrando");
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		app();
	}

}
