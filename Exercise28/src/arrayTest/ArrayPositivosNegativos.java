package arrayTest;
/* Crea una clase llamada ArrayPositivosNegativos que tenga un atributo privado
 * de tipo array de enteros.
 * La clase debe incluir:
 *  • Un constructor que reciba el array y lo asigne.
 *  • Un método público cuentaPositivos() que devuelva la cantidad de valores positivos.
 *  • Un método público cuentaNegativos() que devuelva la cantidad de valores negativos.
 *  • Un método público mostrarArray() que muestre el contenido del array.
 *  • Métodos getter y setter para el array.
 *  • En el método main, crea una instancia con un array de ejemplo y muestra ambos resultados.
 * 
 */

/**
 * Clase con array de enteros que cuenta cuantos números son positivos y cuantos negativos
 */
public class ArrayPositivosNegativos {
	/**
	 * Array de enteros
	 */
	private int intArray[];

	/**
	 * Constructor con Array recibido
	 * @param array Array de enteros
	 */
	public ArrayPositivosNegativos(int[] intArray) {
		this.intArray = intArray;
	}
	
	/**
	 * Setter del Array
	 * @param Array nuevo array
	 */
	public void setArray(int array[]) {
		this.intArray = array;
	}
	
	/**
	 * Getter del Array
	 * @return Array de la clase
	 */
	public int[] getArray() {
		return intArray;
	}
	
	/**
	 * Método para mostrar el contenido del array
	 */
	public void mostrarArray() {
		for (var i : intArray) {
			System.out.printf("%d\t", i);
		}
		System.out.println();
	}
	
	/**
	 * Método que cuenta cuantos positivos contiene el array
	 * @return
	 */
	public int cuentaPositivos() {
		int pos = 0;
		
		for (int i : intArray) {
			if (i >= 0) pos++;
		}
		
		return pos;
	}
	
	/**
	 * Método que cuenta cuantos negativos contiene el array
	 * @return
	 */
	public int cuentaNegativos() {
		int neg = 0;
		
		for (int i : intArray) {
			if (i < 0) neg++;
		}
		
		return neg;
	}
	
	public static void main(String args[]) {
		int array[] = {8, 7, -3 ,5 ,-4, 2, -6, 1};
		var obj = new ArrayPositivosNegativos(array);
		obj.mostrarArray();
		System.out.printf("Negativos: %d Positivos: %d", obj.cuentaNegativos(), obj.cuentaPositivos());
	}
}
