package ejercicio1;

/* 1.	Declara tres variables:
 * •	Un int que almacene la cantidad disponible en stock.
 * •	Un double que almacene el precio unitario del producto.
 * •	Un char que almacene la categoría del producto (por ejemplo: 'A' para alimentos, 'R' para ropa, 'E' para electrónicos).
 * 2.	Imprime estas variables en consola usando:
 * •	System.out.print() para mostrar la cantidad y la categoría en una misma línea.
 * •	System.out.println() para mostrar el precio en una línea nueva.
 * •	System.out.printf() para mostrar un resumen con un texto formateado que incluya la categoría, la cantidad y el precio con dos decimales.
 * 3.	Calcula y muestra el valor total del stock multiplicando cantidad por precio usando printf para formatear con dos decimales.
 * 4.	Añade mensajes descriptivos combinando texto y variables en cada impresión.
 * Cantidad en stock: 50, Categoría: E
 * Precio unitario: 19.99€
 * Resumen del producto: Categoría E, Cantidad 50, Precio 19,99€
 * *********************
 * Valor total del stock: 999,50€  
 * *********************
 * Autor: Pablo Illescas
*/

public class Ejercicio1 {

	public static void main(String[] args) {
		// Declaración de variables
		int stock = 5;
		double precio = 30;
		char categoria = 'A';
		
		// Mostrar contenido
		System.out.print("Cantidad en stock: " + stock + ", Categoría: " + categoria + '\n');
		System.out.println("Precio unitario: " + precio + "€");
		System.out.printf("Resumen del producto: Categoría %c, Cantidad %d, Precio %.2f€ \n", categoria, stock, precio);
		System.out.println("***********************************************************");
		System.out.printf("* Valor total del stock: %.2f€                          * \n", stock * precio);
		System.out.println("***********************************************************");
	}
}