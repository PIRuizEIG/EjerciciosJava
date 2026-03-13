package ej01_09;

import java.util.Scanner;

public class Executable {
	/**
	 * Listado de opciones
	 */
	public static final String[] OPTIONS = { " 1.- Crear y modificar\n", " 2.- Acceder y consultar\n",
			" 3.- Eliminar por Índice y Valor\n", " 4.- Filtrar\n", " 5.- Recorrer\n", " 6.- Ordenar Enteros\n",
			" 7.- Ordenar Cadenas\n", " 8.- Lista de cartas aleatorias\n", " 9.- Lista de cartas ordenadas\n",
			" 0.- Salir \n" };

	/**
	 * Crear y modificar
	 */
	public static void ex01() {
		System.out.println("Ejercicio 01:");
		var ej01 = new CreateModify();
		ej01.createList();
		System.out.println(ej01);
		System.out.println("Modificar elemento 2:");
		ej01.modifyList();
		System.out.println(ej01);
	}

	/**
	 * Acceder y consultar
	 */
	public static void ex02() {
		System.out.println("Ejercicio 02:");
		var ej02 = new AccessConsult();
		System.out.println(ej02);
		System.out.println("Posición 1: " + ej02.getPos(1));
		System.out.println("¿Contiene 78? " + ej02.contains(78));
		System.out.println("Índice primer 92: " + ej02.indexOf(92));
		System.out.println("Índice último 92: " + ej02.lastIndexOf(92));
	}

	/**
	 * Eliminar por Índice y Valor
	 */
	public static void ex03() {
		System.out.println("Ejercicio 03:");
		var ej03 = new Delete();
		System.out.println(ej03);
		System.out.println("Eliminar elemento 0");
		ej03.remove(0);
		System.out.println(ej03);
		ej03.remove("Valencia");
		System.out.println("Eliminar elemento \"Valencia\"");
		System.out.println(ej03);
	}

	/**
	 * Filtrar
	 */
	public static void ex04() {
		System.out.println("Ejercicio 04:");
		var ej04 = new RemoveIf();
		System.out.println(ej04);
		System.out.println("Eliminar menores a 10");
		ej04.removeIf(10.0);
		System.out.println(ej04);
	}

	/**
	 * Recorrer
	 */
	public static void ex05() {
		System.out.println("Ejercicio 05:");
		var ej05 = new ForEach();
		System.out.println(ej05);
	}

	/**
	 * Ordenar Enteros
	 * 
	 * @param sc Scanner
	 */
	public static void ex06(Scanner sc) {
		System.out.println("Ejercicio 06:");
		var ej06 = new SortIntegers();
		for (int i = 1; i <= 10; i++) {
			ej06.add(CustomInput.requestInteger(sc, "Introduzca valor nº " + i));
		}
		ej06.sort();
		System.out.println(ej06);
	}

	/**
	 * Ordenar Cadenas
	 * 
	 * @param sc Scanner
	 */
	public static void ex07(Scanner sc) {
		System.out.println("Ejercicio 07:");
		var ej07 = new SortStrings();
		for (int i = 1; i <= 10; i++) {
			ej07.add(CustomInput.requestInput(sc, "Introduzca cadena nº " + i));
		}
		ej07.sort();
		System.out.println(ej07);
	}

	/**
	 * Lista de cartas aleatorias
	 */
	public static void ex08() {
		System.out.println("Ejercicio 08:");
		var ej08 = new SortedCards();
		System.out.println(ej08);
	}

	/**
	 * Lista de cartas aleatorias y ordenadas
	 */
	public static void ex09() {
		System.out.println("Ejercicio 09:");
		var ej09 = new SortedCards();
		System.out.println(ej09);
		System.out.println("Ordenada:");
		ej09.sortList();
		System.out.println(ej09);
	}

	private static void appLoop() {
		// Abrir Scanner en try para no tener que cerrarlo
		try (var sc = new Scanner(System.in);) {
			// Variable para almacenar la opción
			var option = -1;
			while (option != 0) {
				// Cadena con las opciones disponibles
				var label = "Introduzca:\n";
				for (var string : OPTIONS) {
					label += string;
				}

				// Pedimos la opción a usar
				option = CustomInput.requestInteger(sc, label);

				// Si la opción no es válida avisamos
				if (option < 0 || option > OPTIONS.length - 1) {
					System.err.println("Error, opción no válida");
					CustomInput.requestInput(sc, "Pulse intro para continuar");
					// Y volvemos a repetir el bucle
					continue;
				}

				// Dependiendo del valor de la opción selecionada
				switch (option) {
				// Crear y modificar
				case 1:
					ex01();
					break;
				// Acceder y consultar
				case 2:
					ex02();
					break;
				// Eliminar por Índice y Valor
				case 3:
					ex03();
					break;
				// Filtrar
				case 4:
					ex04();
					break;
				// Recorrer
				case 5:
					ex05();
					break;
				// Ordenar Enteros
				case 6:
					ex06(sc);
					break;
				// Ordenar Cadenas
				case 7:
					ex07(sc);
					break;
				// Lista de cartas aleatorias
				case 8:
					ex08();
					break;
				// Lista de cartas ordenadas
				case 9:
					ex09();
					break;
				// Cierre de programa
				case 0:
					// Avisar
					System.out.println("Cerrando programa.");
					break;
				}
				CustomInput.requestInput(sc, "Pulse intro para continuar");
			}
		}
	}

	public static void main(String[] args) {
		appLoop();
	}
}
