package arrayTest;
/* Crea una clase llamada ArrayStrings que tenga un atributo privado de tipo array de cadenas.
 * La clase debe incluir:
 *  • Un constructor que reciba el array y lo asigne al atributo.
 *  • Un método público mostrar() que recorra el array y muestre todas las cadenas.
 *  • Un método público contarConLetra(char letra) que cuente cuántas cadenas comienzan con la letra especificada.
 *  • Un método público pedirLetra() que lea la letra por la que deben comenzar las palabras (usando Scanner).
 *  • Métodos getter y setter para el array.
 *  • En el método main, crea una instancia con un array de ejemplo de cadenas, muestra todas las cadenas,
 *   solicita la letra al usuario y muestra la cantidad de cadenas que comienzan con la letra introducida.
 *  Autor Pablo Illescas
 */

/**
 * Clase con Array de cadenas que cuenta cuantas cadenas empiezan por una letra concreta
 */
import java.util.Scanner;
public class ArrayStrings {
	/**
	 * Array de cadenas
	 */
	private String[] strArray;
	
	/**
	 * Constructor que crea el objeto con el array recibido
	 * @param strArray Array de cadenas a asignar
	 */
	public ArrayStrings(String[] strArray) {
		this.strArray = strArray;
	}
	
	/**
	 * Muestra todas las cadenas en strArray
	 */
	public void mostrar() {
		for (var s : strArray) {
			System.out.printf("%s%n", s);
		}
	}
	
	/**
	 * Pide una letra por teclado y la devuelve
	 * @return char letra
	 */
	public char pedirLetra() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		/**
		 * Caracter para la busqueda
		 */
		char c;
		
		System.out.print("Introduzca la letra a buscar: ");
		c = sc.next().charAt(0);
		
		return c;
	}
	
	/**
	 * Cuenta cuantas cadenas de strArray empiezan por letra
	 * @param letra Caracter a buscar
	 * @return Entero con la cantidad de cadenas que empiezan por letra
	 */
	public int contarConLetra(char letra) {
		int i = 0;
		
		for (var s : strArray) {
			letra = Character.toUpperCase(letra);
			if (s.toUpperCase().charAt(0) == letra) i++;
		}
		
		return i;
	}
	
	/**
	 * Método de ejecución
	 */
	public static void main(String args[]) {
		String[] newArray = {"Hola", "Soy Edu", "Feliz Navidad", "Hola mundo", "2 test"};
		
		ArrayStrings obj = new ArrayStrings(newArray);
		
		char c = obj.pedirLetra();
		
		obj.mostrar();
		
		System.out.printf("%d cadena(s) empiezan el caracter %c", obj.contarConLetra(c), c);
	}
}
