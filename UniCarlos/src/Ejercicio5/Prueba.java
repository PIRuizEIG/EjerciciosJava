package Ejercicio5;

/**
 * <h1>Main para probar la clase Estudiante</h1>
 * <h2>Autor: Pablo Illescas</h2>
 */
public class Prueba {
	@SuppressWarnings("static-access")
	public static void main (String args[]) {
		Estudiante e1 = new Estudiante("Ana", 20);
		Estudiante e2 = new Estudiante("Luis", 22);
		System.out.println("Total: " + Estudiante.obtenerTotal()); // 2
		e1.totalEstudiantes = 10;
		System.out.println("Total: " + Estudiante.obtenerTotal()); // 10
		//Estudiante.resetContador();
		//System.out.println("Total: " + Estudiante.obtenerTotal()); // Error
		System.out.println(e1.toString());
		System.out.println(e2.toString());
		e1.totalEstudiantes = 100;
		e1 = new Estudiante("Ana", 20);
	}	
}
