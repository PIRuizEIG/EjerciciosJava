package arrayTest;
/* Crea una clase llamada ArrayOrdena que tenga un atributo privado de tipo array de enteros.
 * La clase debe incluir:
 *  • Un constructor que reciba el array y lo asigne.
 *  • Un método público ordena() que ordene el array de menor a mayor.
 *  • Un método público mostrarArray() que muestre el contenido del array.
 *  • Métodos getter y setter para el array.
 *  • En el método main, crea una instancia con un array de ejemplo, ordénalo y muéstralo.
 * Autor: Pablo Illescas
 */

/**
 * Clase con array de enteros.
 * Tiene un método que ordena el array
 */
public class ArrayOrdena {
	/**
	 * Array de enteros
	 */
	private int intArray[];

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
	 * Constructor con Array recibido
	 * @param array Array de enteros
	 */
	public ArrayOrdena(int[] intArray) {
		this.intArray = intArray;
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
	 * Ordena el contenido del array
	 */
	public void ordena() {
		var limit = intArray.length;
		for (int i = 0; i < limit - 1; i++) {
	        for (int j = 0; j < limit - i - 1; j++) {
	            if (intArray[j] > intArray[j + 1]) {
	                int temp = intArray[j];
	                intArray[j] = intArray[j + 1];
	                intArray[j + 1] = temp;
	            }
	        }
	    }
	}
	
	public static void main(String args[]) {
		int array[] = {8, 7, 3 ,5 ,4, 2, 6, 1};
		var obj = new ArrayOrdena(array);
		obj.mostrarArray();
		obj.ordena();
		obj.mostrarArray();
	}
}
