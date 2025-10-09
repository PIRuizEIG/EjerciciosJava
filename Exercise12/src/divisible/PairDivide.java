package divisible;

import java.util.Scanner;

/* Realiza un programa que diga si un número introducido por 
 * teclado es par y/o divisible entre 5.
 * Autor: Pablo Illescas
 */
public class PairDivide {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int integer;
		
		// Introducir número		
		System.out.printf("Enter the integer number :%n");
		integer = sc.nextInt();
		
		System.out.printf("The number %d is ", integer);
		
		// Comprobar si es divisible entre dos o par
		if (integer % 2 == 0)
			System.out.print("even");
		else
			System.out.print("odd");
		
		// Comprobamos si es divisible entre 5
		if (integer % 5 == 0)
			System.out.print(" and is divisible by five");
		else
			System.out.print(" and is not divisible by five");

		sc.close();
	}
}
