package switchClass;

import java.util.Scanner;

/* Escribe un programa que pida por teclado 3 notas de 3 exámenes y que de la 
 * nota media en número y en Calificación (Insuficiente, Suficiente, Bien, 
 * Notable y Sobresaliente). Debe dar error si alguna nota no es válida.
 * Autor: Pablo Illescas
 */
public class AverageGrade {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		float grades[] = new float[3];

		// Introducimos las notas
		for (int i = 0; i < 3; i++) {
			do {
				System.out.printf("Introduzca la nota del examen nº %d:%n", i + 1);
				grades[i] = sc.nextFloat();
				if (grades[i] < 0 || grades[i] > 10)
					System.out.printf("%f no es una nota valida:%n", grades[i]);
			} while (grades[i] < 0 || grades[i] > 10);
		}

		// Calculamos la nota media
		float average = (grades[0] + grades[1] + grades[2]) / 3;

		// Mostramos el resultado como nota y como grado
		/*if (average < 5)
			System.out.printf("Average: %.2f, Insuficiente%n", average);
		else if (average < 7)
			System.out.printf("Average: %.2f, Suficiente%n", average);
		else if (average < 8)
			System.out.printf("Average: %.2f, Bien%n", average);
		else if (average < 9)
			System.out.printf("Average: %.2f, Notable%n", average);
		else
			System.out.printf("Average: %.2f, Sobresaliente%n", average);*/

		String grade = switch ((int) average) {
		case 0, 1, 2, 3, 4 -> "Insuficiente";
		case 5, 6 -> "Suficiente";
		case 7 -> "Bien";
		case 8 -> "Notable";
		case 9, 10 -> "Sobresaliente";
		default -> "Error, Nota no valida";
		};
		
		System.out.printf("Nota Media: %.2f, %s%n", average, grade);
		sc.close();
	}
}
