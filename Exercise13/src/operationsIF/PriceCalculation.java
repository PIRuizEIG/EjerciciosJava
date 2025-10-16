package operationsIF;
import java.util.Scanner;
/* El programa debe permitir al usuario ingresar:
 * Edad (número entero)
 * Día de la semana (como número: 1=Lunes, ..., 3=Miércoles, ..., 7=Domingo)
 * ¿Tiene carnet de estudiante? (1 = Sí, 0 = No)
 * 
 * El sistema calculará el acceso y el porcentaje de descuento aplicable según las siguientes reglas:
 * Condición			Descuento	Notas
 * Menores de 12 años	50%			Solo acceso acompañado (no verificado en este ejercicio)
 * Mayores de 65 años	70%			Acceso para tercera edad
 * Entre 12 y 26 años y
 * con carnet de
 * estudiante			50%			Descuento estudiantil
 * Cualquier persona el 
 * día miércoles(día 3)	40%			Aplica "Día del Espectador"
 * Combinación:
 * estudiante +
 * miércoles 			60%			50% + 40%; se aplica descuento combinado (no acumulable al 100%)
 * Combinación:
 * tercera edad +
 * miércoles			80%			70% + 40% (máximo permitido)
 * Ninguna condición
 * aplicable			0%			Precio normal
 * Regla de prioridad: Si múltiples descuentos son aplicables, el descuento máximo es del 80%.
 * No se permiten descuentos acumulativos que superen este límite. 
 * Autor: Pablo Illescas
 */

public class PriceCalculation {
	// Variables de configuración
	final static int MINOR = 12;
	final static int SENIOR = 65;
	final static int CAP = 26;
	final static int SPECTATOR = 3;
	
	public static void main(String args[]) {
		// Declaración de variables
		int		age;
		int		day;
		int		discount;
		boolean	isStudent;
		char	tmp;
		Scanner	sc = new Scanner(System.in);
		
		// Entrada de valores
		System.out.print("Introduzca su edad: ");
		age = sc.nextInt();
		do {
			System.out.println("Introduzca el día de la semana como número");
			System.out.println("1.- Lunes\n2.- Martes\n3.- Miercoles");
			System.out.println("4.- Jueves\n5.- Viernes\n6.- Sabado\n7.- Doming");
			day = sc.nextInt();
			if (day < 1 || day > 7)
				System.out.println("Respuesta no valida.");
		} while (day < 1 || day > 7);
		// Consume el salto de línea
		sc.nextLine();
		do {
			System.out.println("Posee carnet de estudiante (S)i (N)o: ");
			tmp = sc.nextLine().toLowerCase().charAt(0);
			if (tmp != 's' && tmp != 'n')
				System.out.println("Respuesta no valida.");
		} while (tmp != 's' && tmp != 'n');
		isStudent = tmp == 's';
		
		// Calculamos el descuento		
		if (day == SPECTATOR) {
			if (age < MINOR || age > SENIOR) {
				discount = 80;
			} else if (age >= MINOR && age <= CAP && isStudent){
				discount = 60;
			} else {
				discount = 40;
			}			
		} else {
			if (age < MINOR) {
				discount = 50;
			} else if (age > SENIOR) {
				discount = 70;
			} else if (age >= MINOR && age <= CAP && isStudent){
				discount = 50;
			} else {
				discount = 0;
			}
		}
		System.out.printf("El descuento es %d%%", discount);
		
		sc.close();
	}
}
