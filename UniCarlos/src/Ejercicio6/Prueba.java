package Ejercicio6;

/**
 * <h1>Main para probar la clase Calculadora</h1>
 * <h2>Autor: Pablo Illescas</h2>
 */
public class Prueba {
	public static void main (String args[]) {
		System.out.print("Sumar 3 + 4: ");
		System.out.println(Calculadora.sumar(3, 4));
		System.out.print("Hipotenusa catetos 3 y 4: ");
		System.out.println(Calculadora.hipotenusa(3, 4));
		System.out.print("PI: ");
		System.out.println(Calculadora.PI);
		//Calculadora.raizCuadrada(4);
	}
}
