package comun;

import java.util.Scanner;

/**
 * Clase que controla las asignaturas de una clase de un centro de formación
 */
public class ExamenComun {

	/**
	 * Matriz para Almacenar las notas
	 */
	private double[][] notas;

	String[] asignaturas = { "Mátematicas", "Lengua", "Programación" };

	/**
	 * Scanner para guardar los datos
	 */
	Scanner sc = new Scanner(System.in);

	/**
	 * Constructor vacío
	 */
	public ExamenComun() {
		notas = new double[numeroAlumnos()][asignaturas.length];
	}

	/**
	 * Constructor con número de estudiantes
	 * 
	 * @param students Estudiantes en la clase
	 */
	public ExamenComun(int students) {
		notas = new double[students][asignaturas.length];
	}

	/**
	 * Pedir el número de alumnos
	 * 
	 * @return Entero con la cantidad de alumnos, mayor a 0
	 */
	public int numeroAlumnos() {
		int numAlumnos;
		do {
			System.out.print("Introduzca cantidad de alumnos: ");
			numAlumnos = sc.nextInt();
			if (numAlumnos < 0)
				System.out.println("Error, la cantidad debe ser mayor a 0");
		} while (numAlumnos < 0);

		return numAlumnos;
	}

	/**
	 * Pide nota de una asignatura al usuario
	 * 
	 * @param nombre Nombre de la asignatura
	 * @return Double entre 0 y 10 con la nota
	 */
	public double pedirNota(String nombre) {
		double nota;

		do {
			System.out.printf("Introduzca nota para %s: ", nombre);
			nota = sc.nextDouble();
			if (nota < 0 || nota > 10)
				System.out.println("Error, nota debe estar entre 0 y 10");
		} while (nota < 0 || nota > 10);

		return nota;
	}

	/**
	 * Introducir por teclado todas las notas
	 */
	public void cargarNotas() {
		for (int estu = 0; estu < notas.length; estu++) {
			for (int asig = 0; asig < notas[0].length; asig++) {
				notas[estu][asig] = pedirNota(asignaturas[asig]);
			}
		}
	}

	/**
	 * Calcula y muestra el promedio de cada asignatura
	 */
	public void promedio() {
		double sum = 0;

		for (int asig = 0; asig < notas[0].length; asig++) {
			for (int estu = 0; estu < notas.length; estu++) {
				sum += notas[estu][asig];
			}
			System.out.printf("Promedio: %s %.2f%n", asignaturas[asig], (sum / notas.length));
			sum = 0;
		}
	}

	/**
	 * Calcula y muestra el promedio de cada asignatura
	 */
	public void min() {

		for (int asig = 0; asig < notas[0].length; asig++) {
			double min = Double.POSITIVE_INFINITY;
			for (int estu = 0; estu < notas.length; estu++) {
				if (min > notas[estu][asig])
					min = notas[estu][asig];
			}
			System.out.printf("Mínimo: %s %.2f%n", asignaturas[asig], min);
		}
	}

	/**
	 * Calcula y muestra el promedio de cada asignatura
	 */
	public void max() {

		for (int asig = 0; asig < notas[0].length; asig++) {
			double max = Double.NEGATIVE_INFINITY;
			for (int estu = 0; estu < notas.length; estu++) {
				if (max < notas[estu][asig])
					max = notas[estu][asig];
			}
			System.out.printf("Máximo: %s %.2f%n", asignaturas[asig], max);
		}
	}
	
	/**
	 * Calcula media, mínimo y máximo de cada asignatura
	 */
	public void mostrarDatos() {
		for (int asig = 0; asig < notas[0].length; asig++) {
			// Suma inicializada a 0 por asignatura
			double sum = 0;
			// Asignamos el valor más alto para el primer valor para calcular el mínimo
			double min = Double.POSITIVE_INFINITY;
			// Asignamos el valor más bajo para el primer valor para calcular el máximo
			double max = Double.NEGATIVE_INFINITY;
			
			for (int estu = 0; estu < notas.length; estu++) {
				// Suma para promedio
				sum += notas[estu][asig];
				// Buscar mínimo, si es menor al guardado sobreescribir
				if (min > notas[estu][asig])
					min = notas[estu][asig];
				// Buscar máximo, si es mayor al guardado sobreescribir
				if (max < notas[estu][asig])
					max = notas[estu][asig];
			}
			System.out.printf("%s: %n", asignaturas[asig].toUpperCase());
			// La media es la suma de asignatura partida las notas
			System.out.printf("Promedio: %.2f%n", (sum / notas.length));
			// Mostrar mínimo y máximo
			System.out.printf("Mínimo: %.2f%n", min);
			System.out.printf("Máximo: %.2f%n", max);
			sum = 0;
		}
	}

	public static void main(String[] args) {
		ExamenComun miClase;

		miClase = new ExamenComun();
		miClase.cargarNotas();
		miClase.mostrarDatos();
	}

}
