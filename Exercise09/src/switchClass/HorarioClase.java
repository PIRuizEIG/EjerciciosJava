package switchClass;
import java.util.Scanner; 

/* Escribe un programa que pida por teclado un día de la semana y 
 * que diga las asignaturas que toca ese día. 
 * Autor: Pablo Illescas
 */

public class HorarioClase {
	public static void main (String args[])
	{
		int day;
		Scanner sc = new Scanner(System.in);
		
		// Pedir día de la semana. Si no es valido repetir
		
		System.out.println("Input:");
		do {
			System.out.println("1.- Monday\n2.- Tuesday\n3.- Wednesday\n"
				+ "4.- Thursday\n5.- Friday\n6.- Saturday\n7.- Sunday");
			day = sc.nextInt();
			if (day < 1 || day > 7)
				System.out.println("Error. Please input a valid weekday:");
		} while (day < 1 || day > 7);
		
		// Indicar las asignaturas por día
		switch (day) {
		case 1:
			System.out.println("Lenguaje de Marcas & Bases de Datos");
			break;
		case 2:
			System.out.println("Programación & Empleabilidad");
			break;
		case 3:
			System.out.println("Bases de Datos & Entornos de Desarrollo");
			break;
		case 4:
			System.out.println("Lenguaje de Marcas & Bases de Datos");
			break;
		case 5:
			System.out.println("Programación, Digitalización & Sostenibilidad");
			break;
		default:
			System.out.println("Happy Weekend");
		}
		
		sc.close();
	}
}
