package arrayTest;
/* Crea una clase llamada ArrayMaxMin que tenga un atributo privado de tipo array de enteros.
 * La clase debe incluir:
 *  • Un constructor que reciba un array de enteros y lo asigne al atributo.
 *  • Un método público getMax() que recorra el array y devuelva el valor máximo.
 *  • Un método público getMin() que recorra el array y devuelva el valor mínimo.
 *  • Métodos getter y setter para el array.
 *  • En el método main, crea una instancia con un array de ejemplo y muestra el
 *  	valor máximo y el valor mínimo.
 *  Autor: Pablo Illescas
 */

/**
 * Clase con array de enteros que busca el valor máximo y el valor mínimo
 */
public class ArrayMaxMin {
	
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
	public ArrayMaxMin(int[] intArray) {
		this.intArray = intArray;
	}
	
	/**
	 * Metodo que devuelve el valor más grande
	 * @return Entero mayor
	 */
	public int getMax()	{
		int max = intArray[0];
		
		for (int i = 1; i < intArray.length; i++)
		{
			if (intArray[i] > max) max = intArray[i];
		}
		
		return max;
	}
	
	/**
	 * Metodo que devuelve el valor más pequeño
	 * @return Entero mayor
	 */
	public int getMin()	{
		int min = intArray[0];
		
		for (int i = 1; i < intArray.length; i++)
		{
			if (intArray[i] < min) min = intArray[i];
		}
		
		return min;
	}
	
	public static void main (String args[])	{
		int [] miArray = {15, 1, 9, 3, 4, 5};
		
		ArrayMaxMin obj = new ArrayMaxMin(miArray);
		
		System.out.printf("El valor mayor es el %d y el menor es %d", obj.getMax(), obj.getMin());
	}
	
}
