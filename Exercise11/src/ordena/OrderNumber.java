package ordena;

import java.util.Scanner;

/* Escribe un programa que ordene tres números enteros introducidos por teclado.
 * Autor: Pablo Illescas
 */
public class OrderNumber {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int integers[] = new int[3];

		// Introducimos los enteros
		for (int i = 0; i < 3; i++) {
			System.out.printf("Enter the integer number %d:%n", i + 1);
			integers[i] = sc.nextInt();
		}
		
		// Los ordenamos
		int temp;
		for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2 - i; j++) {
                if (integers[j] > integers[j + 1]) {
                    temp = integers[j];
                    integers[j] = integers[j + 1];
                    integers[j + 1] = temp;
                }
            }
        }
		
		// Los mostramos
		for (int i = 0; i < 3; i++) {
			System.out.printf("%d ", integers[i]);
		}
		System.out.println();
		
		sc.close();
	}
}
