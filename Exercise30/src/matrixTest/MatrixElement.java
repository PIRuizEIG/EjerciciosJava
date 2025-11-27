package matrixTest;
import java.util.Scanner;
/* Crea una clase llamada MatrixElement que tenga un atributo privado de tipo matriz de enteros de 4x4.
 * La clase debe incluir:
 *  • Un constructor que reciba la matriz y lo asigne al atributo.
 *  • Un método que cargue los valores de la matriz por teclado
 *  • Un método que muestre el contenido de la matriz por columnas y filas en cada línea. Ej. 
 *  	3 5 6 2
 *  	4 6 4 4
 *  	3 6 5 3
 *  	5 6 7 8
 *  • Un método que pida dos coordenadas de fila (F) y columna(C) (0-3) y devuelva el valor de la posición (F,C).
 *  • Métodos getter y setter para la matriz.
 *  • En el método main, crea una instancia, llama al método para cargar los valores, muestra el contenido de la
 *  	matriz, llama al método que pide las coordenadas y devuelve el valor de la matriz de esas coordenadas.
 * Autor: Pablo Illescas
 */

/**
 * Clase con un atributo de array bidimensional de enteros con un método para mostrar la matriz en su totalidad
 * showMatrix y otro método para preguntar por el valor en la posición getValueAt(row, column)
 */
public class MatrixElement {
	/**
	 * Longitud del array
	 */
	public static final int SIZE = 4;
	/**
	 * Matriz de enteros
	 */
	private int [][] matrix;
	
	/**
	 * Getter que devuelve la matriz
	 * @return Array bidimensional de enteros
	 */
	public int[][] getMatrix() {
		return matrix;
	}
	
	/**
	 * Setter que ajusta el atributo matriz de enteros de la clase
	 * @param matrix Nuevo array bidimensional de enteros
	 */
	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}
	
	/**
	 * Devuelve la cantidad de filas en la matriz
	 * @return Entero con la cantidad de filas
	 */
	public int getMatrixRows()
	{
		return matrix.length;
	}
	
	/**
	 * Devuelve la cantidad de columnas de la matriz
	 * @return Entero con la cantidad de columnas
	 */
	public int getMatrixColumns()
	{
		return matrix[0].length;
	}
	
	/**
	 * Constructor para crear objeto con la matriz recibida
	 * @param matrix Matriz del objeto a crear
	 */
	public MatrixElement(int matrix[][]) {
		this.matrix = matrix;
	}
	
	/**
	 * Constructor para crear una matriz vacía de tamaño recibido
	 * @param rows Filas del array bidimensional
	 * @param columns Columnas del array bidimensional
	 */
	public MatrixElement(int rows, int columns) {
		this.matrix = new int [rows][columns];
	}
	
	/**
	 * Constructor para crear una matriz vacía de tamaño SIZE
	 */
	public MatrixElement()
	{
		this.matrix = new int [SIZE][SIZE];
	}
	
	/**
	 * Método que carga por teclado la matriz de enteros
	 */
	public void loadMatrix()
	{
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca valores para las posiciones: ");
		for (int r = 0; r < getMatrixRows(); r++) {
			for (int c = 0; c < getMatrixColumns(); c++) {
				System.out.printf("[%d][%d]: ", r, c);
				matrix[r][c] = sc.nextInt();
			}
		}
		System.out.println();
	}
	
	/**
	 * Método que muestra la matriz entera por pantalla
	 */
	public void showMatrix()
	{
		System.out.println("Matriz: ");
		for (int r = 0; r < getMatrixRows(); r++) {
			for (int c = 0; c < getMatrixColumns(); c++) {
				System.out.printf("[%02d]\t", matrix[r][c]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	/**
	 * Método que devuelve el valor en la posición
	 * @param row Fila a buscar
	 * @param column Columna a buscar
	 * @return Entero en la posición
	 */
	public int getValueAt(int row, int column) {
		return matrix[row][column];
	}
	
	public static void main (String args[]) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		MatrixElement obj = new MatrixElement(SIZE, SIZE);
		obj.loadMatrix();
		obj.showMatrix();
		
		System.out.println("Buscando valor");
		System.out.print("Introduzca fila a buscar: ");
		int row = sc.nextInt();
		System.out.print("Introduzca columna a buscar: ");
		int column = sc.nextInt();
		System.out.printf("Valor en [%d][%d]: %d", row, column, obj.getValueAt(row, column));		
	}
}
