package operationsFor;
/* Muestra los números del 320 al 160, contando
 * de 20 en 20 hacia atrás utilizando un bucle for.
 * Autor: Pablo Illescas
 */
public class BackCount {
	// Declaramos limites
	final static int MIN = 160;
	final static int MAX = 320;
	final static int EXECUTION = 20;
	public static void main (String args[]) {
		// Bucle de máximo a mínimo que resta la variación
		for (int i = MAX; i >= MIN; i -= EXECUTION) {
			System.out.printf("%d%n", i);
		}
	}
}
