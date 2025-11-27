package actEvaluable1;

// Importaciones
import java.util.Scanner;

/* Gestión de Calificaciones
 * 
 * Objetivo:
 * Desarrollar un programa en Java que permita gestionar las 
 * calificaciones de los alumnos de una clase, calculando estadísticas 
 * básicas por asignatura. 
 * 
 * Descripción:
 * El programa debe solicitar al usuario el número de 
 * alumnos de la clase y, para cada alumno, recoger las notas de tres 
 * asignaturas: Matemáticas, Lengua y Programación. Finalmente, 
 * mostrará un resumen con las estadísticas de cada asignatura.
 * 
 * Requisitos Específicos:
 * Entrada de Datos
 * 	-Número de alumnos: El programa debe solicitar el número de 
 * alumnos, validando que sea un número mayor que cero. 
 * 	-Notas por alumno: Para cada alumno, se deben introducir tres 
 * notas (float con dos decimales): Matemáticas, Lengua, y Programación 
 * 
 * Validaciones: 
 * El número de alumnos debe ser mayor que 0. Si se introduce un valor 
 * no válido, el programa debe mostrar un mensaje de error y solicitar
 * de nuevo el dato. Si la nota introducida no está entre 0-10 debe 
 * volver a pedirla hasta que la meta correctamente.
 * 
 * Procesamiento: Para cada asignatura, el programa debe calcular: 
 * 	Nota media (promedio de todas las notas)
 * 	Nota más alta (máximo)
 * 	Nota más baja (mínimo)
 * 
 * Salida del Programa: 
 * Mostrar un informe claro con las estadísticas de cada asignatura,
 * formateado adecuadamente.
 * 
 * === GESTIÓN DE CALIFICACIONES ===
 * 
 * Introduzca el número de alumnos en clase: 1
 * 
 * --- ALUMNO 1 ---
 * Nota de Matemáticas: 5.50
 * Nota de Lengua: 6.75
 * Nota de Programación: 7.25
 * 
 * === INFORMACIÓN ESTADÍSTICA ===
 * MATEMÁTICAS:
 * Nota media: 5.50
 * Nota más alta: 5.50
 * Nota más baja: 5.50
 * LENGUA:
 * Nota media: 6.75
 * Nota más alta: 6.75
 * Nota más baja: 6.75
 * PROGRAMACIÓN:
 * Nota media: 7.25
 * Nota más alta: 7.25
 * Nota más baja: 7.25
 * 
 * Introduzca el número de alumnos en clase: -2
 * Error: El número de alumnos debe ser mayor que cero.
 * 
 *  Nota de Matemáticas: 15.50
 *  Error la nota de ser de 0-10.
 *  
 * Autor: Pablo Illescas
 */
public class ActividadEvaluable1 {
	// Constantes
	static final int MAX = 10;
	static final int MIN = 0;

	// Método principal
	public static void main(String args[]) {
		// Declaración de variables
		Scanner sc = new Scanner(System.in);
		int students;
		
		float mathEval;
		float mathTotal = 0;
		float mathMin = 0;
		float mathMax = 0;
		
		float langEval;
		float langTotal = 0;
		float langMin = 0;
		float langMax = 0;
		
		float progEval;
		float progTotal = 0;
		float progMin = 0;
		float progMax = 0;

		// Texto Cabecera
		System.out.println("=== GESTIÓN DE CALIFICACIONES ===\n");

		// Capturamos la entrada nº de alumnos
		students = GetStudents(sc);

		// Capturamos las notas de alumnos
		for (int i = 1; i <= students; i++) {
			// Texto Cabecera
			System.out.printf("\n--- ALUMNO %d ---\n\n", i);

			// Capturamos el valor 1a asignatura
			mathEval = GetEval(sc, "Matemáticas");

			// Capturamos el valor 2a asignatura
			langEval = GetEval(sc, "Lengua");
			
			// Capturamos el valor 3a asignatura
			progEval = GetEval(sc, "Programación");

			// Procesamos
			if (i == 1) {
				// Primer valor todos los valores son iguales
				mathTotal = mathEval;
				mathMin = mathEval;
				mathMax = mathEval;
				
				langTotal = langEval;
				langMin = langEval;
				langMax = langEval;
				
				progTotal = progEval;
				progMin = progEval;
				progMax = progEval;
			} else {
				/*
				 * El resto de valores se procesan los valores ya almacenados contra el valor
				 * nuevo
				 */
				// Valor mínimo
				if (mathMin > mathEval)
					mathMin = mathEval;
				
				if (langMin > langEval)
					langMin = langEval;
				
				if (progMin > progEval)
					progMin = progEval;
				
				// Valor máximo

				if (mathMax < mathEval)
					mathMax = mathEval;
				
				if (langMax < langEval)
					langMax = langEval;
				
				if (progMax < progEval)
					progMax = progEval;
				
				// Total para nota media

				mathTotal += mathEval;
				langTotal += langEval;
				progTotal += progEval;
			}
		}

		// Mostramos los resultados

		// Texto Cabecera
		System.out.println("\n=== INFORMACIÓN ESTADÍSTICA ===\n");

		// 1a asignatura
		ShowEval("MATEMÁTICAS", students, mathTotal, mathMax, mathMin);
		
		// 2a asginatura
		ShowEval("LENGUA", students, langTotal, langMax, langMin);
		
		// 3a asignatura
		ShowEval("PROGRAMACIÓN", students, progTotal, progMax, progMin);

		// Cerrar Scanner
		sc.close();
	}

	// Metodo para capturar el número de alumnos
	private static int GetStudents(Scanner sc) {
		// Variables
		int students;

		// En bucle hasta recibir dato valido, do while para recibir al menos el 1er
		// valor
		do {
			// Pedimos el valor
			System.out.print("Introduzca el número de alumnos en clase: ");
			students = sc.nextInt();

			// Comprobamos si es valido
			if (students <= MIN)
				System.out.println("Error: El número de alumnos debe ser mayor que cero.");
		} while (students <= MIN);

		// Devolvemos el valor
		return students;
	}

	// Metodo para capturar una nota de alumno
	private static float GetEval(Scanner sc, String name) {
		// Variables
		float eval;

		// En bucle hasta recibir dato valido, do while para recibir al menos el 1er
		// valor
		do {
			// Pedimos el valor
			System.out.printf("Nota de %s: ", name);
			eval = sc.nextFloat();

			// Comprobamos si es valido
			if (eval < MIN || eval > MAX)
				System.out.printf("Error la nota de ser de %d-%d.%n", MIN, MAX);
		} while (eval < MIN || eval > MAX);

		// Devolvemos el valor
		return eval;
	}

	// Metodo para mostrar los datos procesados de una asignatura
	private static void ShowEval(String name, int amount, float total, float max, float min) {
		System.out.printf("%s:\n", name);
		System.out.printf(" Nota media: %.2f\n", total / amount);
		System.out.printf(" Nota más alta: %.2f\n", max);
		System.out.printf(" Nota más baja: %.2f\n", min);
	}
}
