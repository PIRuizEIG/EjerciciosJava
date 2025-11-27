package arrayTest;
/* Crea una clase llamada ArrayInvierte que tenga un atributo privado de tipo array de enteros.
 * La clase debe incluir:
 *  • Un constructor que reciba el array y lo asigne.
 *  • Un método público invierte() que modifique el array para que esté en orden inverso.
 *  • Un método público mostrarArray() que muestre el contenido del array.
 *  • Métodos getter y setter para el array.
 *  • En el método main, crea una instancia con un array de ejemplo, inviértelo y muéstralo.
 * Autor: Pablo Illescas
 */

/**
 * Clase con array de enteros.
 * Tiene un método reordena el array en orden inverso
 */
public class ArrayInvierte {
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
	public ArrayInvierte(int[] intArray) {
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
	 * Invierte el contenido del array
	 */
	public void invierte() {
		for (int i = 0; i < intArray.length/2; i++) {
			var j = intArray.length - 1 - i;
			var temp = intArray[i];
			intArray[i] = intArray[j];
			intArray[j] = temp;
		}
	}
	
	public static void main(String args[]) {
		int array[] = {1, 2, 3 ,4 ,5, 6, 7};
		var obj = new ArrayInvierte(array);
		obj.mostrarArray();
		obj.invierte();
		obj.mostrarArray();
	}

}
