package matrixTest;
import java.util.Scanner;
/* Crea una clase llamada MatrixOps que tenga dos atributos privados de tipo matriz de enteros
 * y pida las dimensiones de las matrices.
 * La clase debe incluir:
 * • Un constructor que cree las matrices y las asigne a los atributos.
 * • Un método que reciba una matriz y cargue los valores con números aleatorios del 1-100
 * • Un método que muestre el contenido de una matriz recibida por parámetro.
 * • Pida la operación que se quiere realizar (+,-) y que realice esa operación de las matrices.
 * • Métodos getter y setter para la matriz.
 * • En el método main, llama a las funciones para ver la suma de las dos matrices.
 * Autor: Pablo Illescas Ruiz
 */

/**
 * Clase que crea un objeto con dos matrices de enteros con valores aleatorios del 1 al 100 y
 * permite realizar sumas y resta de las matrices.
 */
public class MatrixOps {
	
	/**
	 * Matriz de enteros
	 */
	private int [][] matrix1;
	
	/**
	 * Getter que devuelve la matriz
	 * @return Array bidimensional de enteros
	 */
	public int[][] getMatrix1() {
		return matrix1;
	}
	
	/**
	 * Constructor de tamaño determinado
	 * @param rows Filas de las matrices
	 * @param columns Columnas de las matrices
	 */
	public MatrixOps(int rows, int columns) {
		matrix1 = new int[rows][columns];
		matrix2 = new int[rows][columns];
		initMatrices();
	}
	
	/**
	 * Constructor para matrices concretas
	 * @param matrix1 Matriz 1
	 * @param matrix2 Matriz 2
	 */
	public MatrixOps(int matrix1[][], int matrix2[][]) {
		this.matrix1 = matrix1;
		this.matrix2 = matrix2;
	}
	
	/**
	 * Setter que ajusta el atributo matriz de enteros de la clase
	 * @param matrix Nuevo array bidimensional de enteros
	 */
	public void setMatrix1(int[][] matrix) {
		this.matrix1 = matrix;
	}
	
	/**
	 * Matriz de enteros
	 */
	private int [][] matrix2;
	
	/**
	 * Getter que devuelve la matriz
	 * @return Array bidimensional de enteros
	 */
	public int[][] getMatrix2() {
		return matrix2;
	}
	
	/**
	 * Setter que ajusta el atributo matriz de enteros de la clase
	 * @param matrix Nuevo array bidimensional de enteros
	 */
	public void setMatrix2(int[][] matrix) {
		this.matrix2 = matrix;
	}
	
	/**
	 * Devuelve la cantidad de filas en la matriz
	 * @return Entero con la cantidad de filas
	 */
	public int getMatrixRows(int matrix[][])
	{
		return matrix.length;
	}
	
	/**
	 * Devuelve la cantidad de columnas de la matriz
	 * @return Entero con la cantidad de columnas
	 */
	public int getMatrixColumns(int matrix[][])
	{
		return matrix[0].length;
	}
	
	/**
	 * Inicializar la matriz con valores aleatorios
	 */
	private void initMatrix(int matrix[][]) {
		for (int r = 0; r < getMatrixRows(matrix); r++) {
			for (int c = 0; c < getMatrixColumns(matrix); c++) {
				matrix[r][c] = (int) (Math.random() * 100) + 1;
			}
		}
	}
	
	/**
	 * Inicializar las matrices con valores aleatorios
	 */
	private void initMatrices() {
		initMatrix(matrix1);
		initMatrix(matrix2);
	}
	
	/**
	 * Método que muestra el contenido de una matriz
	 * @param matrix Matriz a mostrar
	 */
	public void showMatrix(int matrix[][]) {
		for (int r = 0; r < getMatrixRows(matrix); r++) {
			for (int c = 0; c < getMatrixColumns(matrix); c++) {
				System.out.printf("%02d\t ", matrix[r][c]);
			}
			System.out.println();
		}
	}
	
	/**
	 * Método que suma las dos matrices atributo
	 * @return Matriz suma
	 */
	public int[][] sumMatrix()
	{
		int rows = getMatrixRows(matrix1);
		int columns = getMatrixColumns(matrix1);
		int sumMatrix[][] = new int [rows][columns];
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < columns; c++) {
				sumMatrix[r][c] = matrix1[r][c] + matrix2[r][c];
			}
		}
		return sumMatrix;
	}
	
	/**
	 * Método que resta las dos matrices atributo
	 * @return Matriz suma
	 */
	public int[][] subMatrix()
	{
		int rows = getMatrixRows(matrix1);
		int columns = getMatrixColumns(matrix1);
		int sumMatrix[][] = new int [rows][columns];
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < columns; c++) {
				sumMatrix[r][c] = matrix1[r][c] - matrix2[r][c];
			}
		}
		return sumMatrix;
	}
	
	/**
	 * Pide al usuario la operación y muestra el resultado
	 */
	public void doOps(Scanner sc)
	{
		char c;
		do {
			System.out.print("Introduzca + para suma y - para resta: ");
			c = sc.next().charAt(0);
			if (c != '+' && c != '-') System.out.println("Error. Operación no valida");
		} while (c != '+' && c != '-');
		
		System.out.println("Matriz 1:");
	    showMatrix(matrix1);

	    System.out.println("Matriz 2:");
	    showMatrix(matrix2);
		
		switch(c)
		{
		case '+':
			System.out.println("Suma:");
			showMatrix(sumMatrix());
			break;
		case '-':
			System.out.println("Resta:");
			showMatrix(subMatrix());
		}
	}
	
	/**
	 * Metodo auxiliar para pedir dimensiones de las matrices
	 * @param message Mensaje para pedir dimensiones
	 * @param sc Scanner para introducir los valores
	 * @return Entero con la dimensión de la matriz
	 */
	private static int GetNum(String message, Scanner sc)
	{
		int num;
		do {
			System.out.println(message);
			num = sc.nextInt();
			if (num <= 0) System.out.println("Error. El valor debe ser mayor que 0.");
		} while (num <= 0);
		return num;
	}
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int rows = GetNum("Introduzca cuantas filas poseen las matrices", sc);
		int columns = GetNum("Introduzca cuantas columnas poseen las matrices", sc);
		
		var obj = new MatrixOps(rows, columns);
		obj.doOps(sc);
	}
}
