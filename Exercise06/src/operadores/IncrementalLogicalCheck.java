package operadores;
/*
 * Crea una variable entera con valor 20. Muestra el valor inicial, luego incrementa el valor usando
 * el operador prefijo y después usando el postfijo, mostrando valores antes y después de la
 * operación postfija. Finalmente, evalúa si el valor final está entre 21 y 25 usando operadores
 * lógicos y muestra el resultado.
 * Autor: Pablo Illescas
 */
public class IncrementalLogicalCheck {
	public static void main(String[] args) {
		// Crea una variable entera con valor 20
		int i = 20;
		// Muestra el valor inicial
		System.out.printf("Valor inicial: %d%n", i);
		// luego incrementa el valor usando el operador prefijo
		System.out.printf("Después de ++value: %d%n", ++i);
		// y después usando el postfijo
		System.out.printf("Después de value++: %d%n", i++);
		// Mostrar valor final
		System.out.printf("Valor final: %d%n", i);
		// evalúa si el valor final está entre 21 y 25 usando operadores lógicos y muestra el resultado
		boolean value = i > 21 && i < 25;
		System.out.printf("¿Valor entre 21 y 25? %b%n", value);
	}
}
