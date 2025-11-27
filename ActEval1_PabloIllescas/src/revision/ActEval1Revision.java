package revision;

//Importaciones
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

/**
 * Clase que controla las asignaturas de una clase de un centro de formación
 */
public class ActEval1Revision {

	/**
	 * Nota mínima
	 */
	static final int MIN = 0;
	/**
	 * Nota máxima
	 */
	static final int MAX = 10;

	/**
	 * Scanner para capturar entrada de teclado
	 */
	private Scanner sc;

	/**
	 * Cantidad de estudiantes
	 */
	private int students;

	/**
	 * Asignaturas de la clase
	 */
	private Subject[] subjects;

	/**
	 * Asignaturas por defecto
	 */
	private void defaultSubjects() {
		this.subjects = new Subject[] { new Subject("Matemáticas", students), new Subject("Lengua", students),
				new Subject("Programación", students) };
	}

	/**
	 * Constructor vacío
	 */
	public ActEval1Revision() {
		sc = new Scanner(System.in);
		System.out.println("=== GESTIÓN DE CALIFICACIONES ===\n");

		students = getStudents();

		defaultSubjects();
	}

	/**
	 * Constructor con el número de alumnos
	 * 
	 * @param students Número de estudiantes
	 */
	public ActEval1Revision(int students) {
		sc = new Scanner(System.in);
		System.out.println("=== GESTIÓN DE CALIFICACIONES ===\n");
		this.students = students;

		defaultSubjects();
	}

	/**
	 * Constructor con el número de alumnos y las asignaturas ya creadas
	 * 
	 * @param students Número de estudiantes
	 * @param subjects Array de asignaturas
	 */
	public ActEval1Revision(int students, Subject[] subjects) {
		sc = new Scanner(System.in);
		System.out.println("=== GESTIÓN DE CALIFICACIONES ===\n");
		this.students = students;

		this.subjects = subjects.clone();
	}

	/**
	 * Constructor con las asignaturas ya creadas
	 * 
	 * @param subjects Array de asignaturas
	 */
	public ActEval1Revision(Subject[] subjects) {
		sc = new Scanner(System.in);
		System.out.println("=== GESTIÓN DE CALIFICACIONES ===\n");

		students = getStudents();

		this.subjects = subjects.clone();
	}

	/**
	 * Metodo para capturar el número de alumnos
	 * 
	 * @return Entero con el número de alumnos
	 */
	private int getStudents() {
		int students;

		do {
			System.out.print("Introduzca el número de alumnos en clase: ");
			students = sc.nextInt();

			if (students <= MIN)
				System.out.println("Error: El número de alumnos debe ser mayor que cero.");
		} while (students <= MIN);

		return students;
	}

	/**
	 * Metodo para capturar una nota de alumno entre MIN y MAX
	 * 
	 * @param name Nombre de la asignatura
	 * @return double con una nota valida
	 */
	private double getEval(String name) {
		double eval;

		do {
			System.out.printf("Nota de %s: ", name);
			eval = sc.nextDouble();

			if (eval < MIN || eval > MAX)
				System.out.printf("Error la nota de ser de %d-%d.%n", MIN, MAX);
		} while (eval < MIN || eval > MAX);

		return eval;
	}

	/**
	 * Capturar todas las notas de los alumnos
	 */
	private void captureGrades() {
		for (int i = 0; i < students; i++) {
			System.out.printf("\n--- ALUMNO %d ---\n\n", i + 1);
			for (Subject s : subjects) {
				s.addEval(getEval(s.getName()));
			}
		}
	}

	/**
	 * Mostrar estadísticas
	 */
	private void showStatistics() {
		System.out.println("\n=== INFORMACIÓN ESTADÍSTICA ===\n");
		for (Subject s : subjects) {
			s.showEval();
		}
	}
	
	/**
	 * Metodo de ejecución
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		var obj = new ActEval1Revision();

		obj.captureGrades();

		obj.showStatistics();
	}
}
