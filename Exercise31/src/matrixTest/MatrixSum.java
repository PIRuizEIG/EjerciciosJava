package matrixTest;

/* Crea una clase llamada MatrixSum que tenga dos atributos privados de tipo matriz de enteros de 3x3.
 * La clase debe incluir:
 * • Un constructor que cree las matrices y las asigne a los atributos.
 * • Un método que reciba una matriz y cargue los valores con números aleatorios del 1-100
 * • Un método que muestre el contenido de una matriz recibida por parámetro.
 * • Un método que sume el contenido de las dos matrices atributos de la clase.
 * • Métodos getter y setter para la matriz.
 * • En el método main, llama a las funciones para ver la suma de las dos matrices.
 * Autor: Pablo Illescas Ruiz
 */

/**
 * Clase que crea un objeto con dos matrices de enteros con valores aleatorios
 * del 1 al 100 y muestra la suma de ambas matrices.
 */
public class MatrixSum {
	/**
	 * Longitud del array
	 */
	public static final int SIZE = 3;

	/**
	 * Matriz de enteros
	 */
	private int[][] matrix1;

	/**
	 * Getter que devuelve la matriz
	 * 
	 * @return Array bidimensional de enteros
	 */
	public int[][] getMatrix1() {
		return matrix1;
	}

	/**
	 * Setter que ajusta el atributo matriz de enteros de la clase
	 * 
	 * @param matrix Nuevo array bidimensional de enteros
	 */
	public void setMatrix1(int[][] matrix) {
		this.matrix1 = matrix;
	}

	/**
	 * Matriz de enteros
	 */
	private int[][] matrix2;

	/**
	 * Getter que devuelve la matriz
	 * 
	 * @return Array bidimensional de enteros
	 */
	public int[][] getMatrix2() {
		return matrix2;
	}

	/**
	 * Setter que ajusta el atributo matriz de enteros de la clase
	 * 
	 * @param matrix Nuevo array bidimensional de enteros
	 */
	public void setMatrix2(int[][] matrix) {
		this.matrix2 = matrix;
	}

	/**
	 * Devuelve la cantidad de filas en la matriz
	 * 
	 * @return Entero con la cantidad de filas
	 */
	public int getMatrixRows(int matrix[][]) {
		return matrix.length;
	}

	/**
	 * Devuelve la cantidad de columnas de la matriz
	 * 
	 * @return Entero con la cantidad de columnas
	 */
	public int getMatrixColumns(int matrix[][]) {
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
	 * Constructor sin valores
	 */
	public MatrixSum() {
		this(SIZE, SIZE);
	}

	/**
	 * Constructor de tamaño determinado
	 * 
	 * @param rows    Filas de las matrices
	 * @param columns Columnas de las matrices
	 */
	public MatrixSum(int rows, int columns) {
		matrix1 = new int[rows][columns];
		matrix2 = new int[rows][columns];
		initMatrices();
	}

	/**
	 * Constructor para matrices concretas
	 * 
	 * @param matrix1 Matriz 1
	 * @param matrix2 Matriz 2
	 */
	public MatrixSum(int matrix1[][], int matrix2[][]) {
		this.matrix1 = matrix1;
		this.matrix2 = matrix2;
	}

	/**
	 * Método que muestra el contenido de una matriz
	 * 
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
	 * Método que muestra el contenido de una matriz por columnas en lugar de filas
	 * 
	 * @param matrix Matriz a mostrar
	 */
	public void showMatrixByCols(int matrix[][]) {
		for (int c = 0; c < getMatrixColumns(matrix); c++) {
			for (int r = 0; r < getMatrixRows(matrix); r++) {

				System.out.printf("%02d\t ", matrix[r][c]);
			}
			System.out.println();
		}
	}

	/**
	 * Método que suma las dos matrices atributo
	 * 
	 * @return Matriz suma
	 */
	public int[][] sumMatrix() {
		int rows = getMatrixRows(matrix1);
		int columns = getMatrixColumns(matrix1);
		int sumMatrix[][] = new int[rows][columns];
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < columns; c++) {
				sumMatrix[r][c] = matrix1[r][c] + matrix2[r][c];
			}
		}
		return sumMatrix;
	}

	public static void main(String args[]) {
		MatrixSum obj = new MatrixSum();

		System.out.println("Matriz 1:");
		obj.showMatrix(obj.getMatrix1());
		System.out.println("Matriz 1 por columnas:");
		obj.showMatrixByCols(obj.getMatrix1());

		System.out.println("\nMatriz 2:");
		obj.showMatrix(obj.getMatrix2());
		System.out.println("Matriz 1 por columnas:");

		System.out.println("\nSuma de las dos matrices:");
		obj.showMatrix(obj.sumMatrix());
	}
}
