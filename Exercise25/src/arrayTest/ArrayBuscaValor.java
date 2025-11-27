package arrayTest;
/* Crea una clase llamada ArrayBuscaValor que tenga un atributo privado de tipo array de enteros.
 * La clase debe incluir:
 *  • Un constructor que reciba el array y lo asigne.
 *  • Un método público buscaPosicion() que reciba un número y devuelva su posición si está en el array, o -1 si no está.
 *  • Métodos getter y setter para el array.
 *  • En el método main, crea una instancia con un array de ejemplo y busca un número introduciendo el valor a buscar.
 * Autor: Pablo Illescas
 */

/**
 * Clase con array de enteros.
 * Tiene un método que busca si un valor está dentro del array
 */
public class ArrayBuscaValor {
	
	/**
	 * Array de enteros
	 */
	private int intArray[];

	/**
	 * Setter del Array
	 * @param array nuevo array
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
	 * Constructor con Array <b>intArray</b> recibido
	 * @param intArray Array de enteros
	 */
	public ArrayBuscaValor(int[] intArray) {
		this.intArray = intArray;
	}
	
	/**
	 * Recibe un número y devuelva su posición o -1 si no está en el array
	 * @param value Valor a buscar
	 * @return La posicion del valor <b>value</b> en el Array o -1 si no lo encuentra
	 */
	public int buscaPosicion(int value)
	{
		int result = -1;
		
		for (int i = 0; i < intArray.length; i++)
		{
			if (intArray[i] == value) return i;
		}
		
		return result;
	}
	
	public static void main (String args[])	{
		int [] miArray = {15, 1, 9, 3, 4, 5};
		
		ArrayBuscaValor obj = new ArrayBuscaValor(miArray);
		
		int i = obj.buscaPosicion(15);
		if (i == -1)
			System.out.println("Valor no encontrado");
		else
			System.out.printf("Valor encontrado en posición %d\n", i);
	}
}
