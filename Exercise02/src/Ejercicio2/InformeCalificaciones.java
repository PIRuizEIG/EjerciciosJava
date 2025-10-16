package Ejercicio2;
/* Ejercicio para probar las variables, la impresion en pantalla y un condicional en Java
 * Java
 * Nombres: Pablo Illescas
 */
/* Ejercicio: Informe de calificaciones de estudiante
 * Un profesor desea crear un programa en Java que almacene y muestre información de un estudiante y sus calificaciones.
 * Declara las siguientes variables:
 * Un String para el nombre del estudiante.
 * Un int para la cantidad de asignaturas.
 * Un double para el promedio final de calificaciones.
 * Un char para la calificación cualitativa ('A' para excelente, 'B' para bueno, 'C' para regular, etc.).
 * Imprime estas variables usando:
 * System.out.println() para mostrar el nombre del estudiante.
 * System.out.print() para mostrar la cantidad de asignaturas y la calificación cualitativa en la misma línea.
 * System.out.printf() para mostrar un informe detallado donde el promedio se muestre con dos decimales y el nombre se muestre
 * alineado a la izquierda con un ancho de 20 caracteres.
 * Añade un mensaje final usando printf que muestre si el estudiante aprobó o no, dependiendo si el promedio es mayor o igual 
 * a 6.0, mostrando el texto en mayúsculas si aprobó, y en minúsculas si no.
 * Nombre de la Clase a crear:InformeCalificaciones
 * ejemplo salida
 * Nombre del estudiante:
 * Laura Pérez
 * Asignaturas: 5, Calificación cualitativa: B
 * Informe: Laura Pérez          | Asignaturas: 5 | Promedio: 7.86 | Calificación: B
 * ESTUDIANTE APROBADO CON PROMEDIO 7.86
 */
public class InformeCalificaciones {
	public static void main(String[] args) {
		// Se declaran las variables
		String	nombre;
		int		asignaturas;
		double	promedio;
		char	calificacion;
		
		// Se asignan valores
		nombre = "Laura Pérez";
		asignaturas = 5;
		promedio = 7.86;
		calificacion = 'B';
		
		// System.out.println() para mostrar el nombre del estudiante.
		System.out.println("Nombre del estudiante:\t" + nombre);
		
		/* System.out.print() para mostrar la cantidad de asignaturas y la calificación cualitativa
		 * en la misma línea.
		 */
		System.out.print("Asignaturas: " + asignaturas + ", Calificación cualitativa: " + calificacion + '\n');
		
		/* System.out.printf() para mostrar un informe detallado donde el promedio se muestre con dos
		 * decimales y el nombre se muestre alineado a la izquierda con un ancho de 20 caracteres.
		 * Alineación a la derecha (por defecto), - indica alineación a la izquierda.
		 * %.2f Imprime el promedio con 2 decimales.
		 */
		System.out.printf("Informe: %-20s | Asignaturas: %d | Promedio: %.2f | Calificación: %c%n",
                nombre, asignaturas, promedio, calificacion);
		
		/* Añade un mensaje final usando printf que muestre si el estudiante aprobó o no, dependiendo si el
		 * promedio es mayor o igual a 6.0, mostrando el texto en mayúsculas si aprobó, y en minúsculas si no.
		 */
		if (promedio >= 6.0)
		{
			System.out.printf("ESTUDIANTE APROBADO CON PROMEDIO %.2f", promedio);
		}
		else
		{
			System.out.printf("Estudiante suspenso con promedio %.2f", promedio);
		}
		System.out.println("\n***********************************************************");
		
		// Prueba de función
		nombre = "Luis Soto";
		asignaturas = 4;
		promedio = 8.45;
		calificacion = 'A';
		MostrarInfo(nombre, asignaturas, promedio, calificacion);
		System.out.println("\n***********************************************************");
		MostrarInfo("Maximiliano Fernández Soto", 3, 3.75, 'D');
		System.out.println("\n***********************************************************");
		MostrarInfo("Luis Pérez", 5, 7.8, 'B');
		System.out.println("\n***********************************************************");
		MostrarInfo("María López", 4, 5.3, 'D');
		System.out.println("\n***********************************************************");
		MostrarInfo("Carlos Ruiz", 6, 6.0, 'C');
	}
	private static void MostrarInfo(String nombre, int asignaturas, double promedio, char calificacion)
	{
		System.out.println("Nombre del estudiante:\t" + nombre);
		System.out.print("Asignaturas: " + asignaturas + ", Calificación cualitativa: " + calificacion + '\n');
		System.out.printf("Informe: %-20s | Asignaturas: %d | Promedio: %.2f | Calificación: %c%n",
				nombre, asignaturas, promedio, calificacion);
		if (promedio >= 6.0)	{
			System.out.printf("ESTUDIANTE APROBADO CON PROMEDIO %.2f", promedio);
		}
		else	{
			System.out.printf("Estudiante suspenso con promedio %.2f", promedio);
		}
	}
}
