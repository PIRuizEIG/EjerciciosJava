package Ejercicio5;

/**
 * <h1>Contador de Estudiantes (static + accesos)</h1>
 * <p>
 * Crea una clase Estudiante que lleve control global del número de estudiantes
 * creados.
 * <h2>Requisitos:</h2>
 * <ul>
 * <li>Atributo static public int totalEstudiantes (compartido por todos los
 * objetos).</li>
 * <li>Atributo static private int maxEstudiantes = 100 (solo accesible dentro
 * de la clase).</li>
 * <li>Atributos de instancia: private String nombre, private int edad.</li>
 * <li>Constructor public Estudiante(String nombre, int edad):
 * <ul>
 * <li>Incrementa totalEstudiantes automáticamente.</li>
 * <li>Si totalEstudiantes > maxEstudiantes, lanza IllegalStateException.</li>
 * </ul>
 * </li>
 * <li>Método static public int obtenerTotal(): devuelve totalEstudiantes.</li>
 * <li>Método private static void resetContador(): pone totalEstudiantes = 0
 * (solo interno).</li>
 * <li>Getters public para nombre y edad.</li>
 * </ul>
 * <h2>Autor: Pablo Illescas</h2>
 */
public class Estudiante {
	/**
	 * Cantidad de Estudiantes en la clase
	 */
	public static int totalEstudiantes = 0;

	/**
	 * Cantidad máxima de Estudiantes permitidos
	 */
	private static int maxEstudiantes = 100;

	/**
	 * Nombre del alumno
	 */
	private String nombre;

	/**
	 * Edad del alumno
	 */
	private int edad;

	/**
	 * Incrementa totalEstudiantes automáticamente
	 * 
	 * @param nombre Nombre del alumno
	 * @param edad   Edad del alumno
	 */
	public Estudiante(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
		totalEstudiantes++;
		if (totalEstudiantes > maxEstudiantes)
			throw new IllegalStateException("¡Máximo de estudiantes alcanzado!");
	}

	/**
	 * Obtener nombre del alumno
	 * 
	 * @return Cadena con el nombre del alumno
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Obtener edad del alumno
	 * 
	 * @return Entero con la edad del alumno
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * Obtener el total de alumnos
	 * 
	 * @return Entero con la cantidad de alumnos
	 */
	public static int obtenerTotal() {
		return totalEstudiantes;
	}

	/**
	 * Reinicia el contador de alumnos
	 */
	@SuppressWarnings("unused")
	private static void resetContador() {
		totalEstudiantes = 0;
	}

	public String toString() {
		return nombre + ": " + edad;
	}
}
