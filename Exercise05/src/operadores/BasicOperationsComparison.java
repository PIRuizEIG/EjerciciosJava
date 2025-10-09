package operadores;
import java.util.Scanner;
/*
 * Pide dos números enteros al usuario y muestra la suma, resta, producto y división entera.
 * Usa una estructura if-else para evitar dividir entre cero y muestra mensajes claros.
 * Además, indica si el primer número es mayor, si son iguales y si la suma es par.
 * Ejemplo de salida de ejecución:
 * Introduce primer número: 8
 * Introduce segundo número: 0
 * No se puede dividir entre cero
 * Suma: 8
 * Resta: 8
 * Producto: 0
 * ¿El primer número es mayor que el segundo? true
 * ¿Los números son iguales? false
 * ¿La suma es par? true 
 * Autor: Pablo Illescas
 */
public class BasicOperationsComparison {
	public static void main(String[] args) {
		// Declaración de variables
		int i, j;
		// Iniciar Scanner
		Scanner sc = new Scanner(System.in);
		// Pedir dos números enteros al usuario
		System.out.println("Introduce primer número: ");
		i = sc.nextInt();
		System.out.println("Introduce segundo número: 0: ");
		j = sc.nextInt();
		// Mostrar suma, resta, producto y división entera
		System.out.printf("Suma: %d%nResta: %d%nProducto: %d%n",
				i + j,
				i - j,
				i + j);
		// Usa una estructura if-else para evitar dividir entre cero y muestra mensajes claros.
		if (j == 0) System.out.printf("No se puede dividir %d por %d, división por zero%n", i, j);
		else System.out.printf("División: %d con resto: %d%n", i / j, i % j);
		// ¿El primer número es mayor que el segundo?
		if (i > j) System.out.printf("%d es mayor que %d%n", i, j);
		else if (i < j ) System.out.printf("%d es menor que %d%n", i, j);
		// ¿Los números son iguales?
		if (i == j) System.out.printf("%d y %d son iguales%n", i, j);
		else System.out.printf("%d y %d son diferentes%n", i, j);
		// ¿La suma es par?
		if ((i + j) % 2 == 0) System.out.printf("La suma %d + %d = %d es par%n", i, j, i+j);
		else System.out.printf("La suma %d + %d = %d es impar%n", i, j, i+j);
		// Cerrar Scanner
		sc.close();
	}
}
