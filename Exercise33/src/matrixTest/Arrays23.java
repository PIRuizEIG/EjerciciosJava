package matrixTest;

/** Define tres arrays de 20 números enteros cada una, con nombres
 * número, cuadrado y cubo. Carga el array número con valores aleatorios
 * entre 0 y 100. En el array cuadrado se deben almacenar los cuadrados
 * de los valores que hay en el array numero. En el array cubo se deben
 * almacenar los cubos de los valores que hay en numero.
 * A continuación, muestra el contenido de los tres arrays dispuesto en tres columnas.
 * Autor Pablo Illescas Ruiz
 */

/**
 * Clase que crea objeto con 3 array de enteros, uno llenado aleatoriamente y
 * los otros dos con los valores de los cuadrados y los cubos de los valores del
 * array base
 */
public class Arrays23 {
	/**
	 * Longitud del array
	 */
	public static final int SIZE = 20;

	/**
	 * Valor máximo para el array
	 */
	public static final int MAXVALUE = 100;

	/**
	 * Declarar atributos
	 */
	private int[] numero, cuadrado, cubo;

	/**
	 * Constructor para crear los array con tamaño por defecto
	 */
	public Arrays23() {
		this(SIZE);
	}

	/**
	 * Constructor para crear los array con tamaño recibido
	 * 
	 * @param size Tamaño de los array
	 */
	public Arrays23(int size) {
		if (size <= 0) {
			size = SIZE;
			System.out.println("Error. Tamaño no válido, asignando valor por defecto");
		}
		numero = new int[size];
		cuadrado = new int[size];
		cubo = new int[size];
		fillArray(numero);
		powArray();
	}

	/**
	 * Constructor para crear objeto con array recibido
	 * 
	 * @param array Array para asignar al array base
	 */
	public Arrays23(int[] array) {
		numero = array;
		cuadrado = new int[array.length];
		cubo = new int[array.length];
		powArray();
	}

	/**
	 * Llena un array con valores aleatorios de 0 a MAXVALUE
	 * 
	 * @param array Array a rellenar
	 */
	private void fillArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * (MAXVALUE + 1));
		}
	}

	/**
	 * Llena los array cuadrado y cubo con los valores calculados
	 */
	private void powArray() {
		for (int i = 0; i < numero.length; i++) {
			cuadrado[i] = numero[i] * numero[i];
			cubo[i] = numero[i] * numero[i] * numero[i];
		}
	}

	/**
	 * Muestra los tres arrays en tres columnas
	 */
	public void showArrays() {
		System.out.printf("%-10s%-12s%-12s%n", "Número", "Cuadrado", "Cubo");
		System.out.println("-----------------------------------");
		for (int i = 0; i < numero.length; i++) {
			System.out.printf("%-10d%-12d%-12d%n", numero[i], cuadrado[i], cubo[i]);
		}
	}

	/**
	 * Getter de numero
	 * 
	 * @return Array de enteros numero
	 */
	public int[] getNumero() {
		return numero;
	}

	/**
	 * Getter de cuadrado
	 * 
	 * @return Array de enteros cuadrado
	 */
	public int[] getCuadrado() {
		return cuadrado;
	}

	/**
	 * Getter de cubo
	 * 
	 * @return Array de enteros cubo
	 */
	public int[] getCubo() {
		return cubo;
	}

	/**
	 * Setter de numero
	 * 
	 * @param array Nuevo valor de numero
	 */
	public void setNumero(int[] array) {
		this.numero = array;
		powArray();
	}

	public static void main(String args[]) {
		var obj = new Arrays23();

		obj.showArrays();
	}
}
