package actEvaluable2;

import java.util.Scanner;
/* Se requiere desarrollar un programa en Java que permita calcular los gastos en salarios
 * que tendrá una empresa en los próximos tres años (2026, 2027 y 2028).
 * El programa debe realizar las siguientes acciones:
 *  Pedir al usuario que ingrese el número de trabajadores.
 *  Para cada trabajador, solicitar su sueldo mensual correspondiente a enero de 2026.
 *  Calcular para cada trabajador el coste total anual en salarios para los años 2026, 2027 y 2028.
 *  Considerar que el sueldo de cada año se incrementará en 1000 euros respecto al año anterior.
 *   Por ejemplo: si un trabajador cobra 20.000 € en 2026, en 2027 su sueldo será 21.000 €
 *   (20.000 + 1000), y en 2028 será 22.000 € (21.000 + 1000).
 *  Controlar que tanto número de trabajadores como salarios mensuales sean positivos.
 *  Mostrar el coste total en salarios que tendrá la empresa para cada trabajador en los tres años.
 *  Mostrar el coste total anual de la empresa en salarios para cada año (2026, 2027 y 2028).
 *  Mostrar el coste total acumulado de salarios que deberá afrontar la empresa en los tres años.
 * Autor: Pablo Illescas
 */

/**
 * Clase que calcula los gastos por salarios en un número dado de años de una
 * empresa
 */
public class ActividadEvaluable2 {
	/**
	 * Año inicial por defecto
	 */
	private static final int YEAR1 = 2026;

	/**
	 * Años a almacenar por defecto
	 */
	private static final int YEARS = 3;

	/**
	 * Pagas al año por defecto
	 */
	private static final int PAYMENTS = 12;

	/**
	 * Aumento anual por defecto
	 */
	private static final double INCREASE = 1000;

	/**
	 * Salarios de los empleados de la empresa
	 */
	private double salaries[][];

	/**
	 * Primer año del programa
	 */
	private int firstYear;

	/**
	 * Getter de los salarios
	 * 
	 * @return Matriz duplicada con los salarios
	 */
	public double[][] getSalaries() {
		return salaries.clone();
	}

	/**
	 * Setter de los salarios
	 * 
	 * @param salaries Matriz para asignar los salarios
	 */
	public void setSalaries(double[][] salaries) {
		this.salaries = salaries.clone();
	}

	/**
	 * Constructor para crear el objeto usando una matriz con los salarios
	 * 
	 * @param salaries Matriz con los salarios
	 */
	public ActividadEvaluable2(double[][] salaries) {
		setSalaries(salaries);
	}

	/**
	 * Constructor vacío
	 */
	public ActividadEvaluable2() {
		Scanner sc = new Scanner(System.in);
		var amount = getEmployees(sc);
		this.firstYear = YEAR1;
		this.salaries = new double[YEARS][amount];
	}

	/**
	 * Constructor para crear el objeto usando la cantidad de empleados
	 * 
	 * @param employees Cantidad de empleados
	 */
	public ActividadEvaluable2(int employees) {
		this(employees, YEAR1);
	}

	/**
	 * Constructor para crear el objeto usando la cantidad de empleados y el primer
	 * año
	 * 
	 * @param employees Cantidad de empleados
	 * @param firstYear Primer año del programa
	 */
	public ActividadEvaluable2(int employees, int firstYear) {
		this(employees, firstYear, YEARS);
	}

	/**
	 * Constructor para crear el objeto usando la cantidad de empleados, el primer
	 * año y el número de años a calcular
	 * 
	 * @param employees Cantidad de empleados
	 * @param firstYear Primer año del programa
	 * @param years     Numero de años a calcular
	 */
	public ActividadEvaluable2(int employees, int firstYear, int years) {
		this.salaries = new double[years][employees];
		this.firstYear = firstYear;
	}

	/**
	 * Método para obtener el número de trabajadores
	 * 
	 * @param sc Scanner para la captura de teclado
	 * @return Entero mayor a 0 con la cantidad de empleados
	 */
	public static int getEmployees(Scanner sc) {
		// Guarda la cantidad de empleados
		int amount;

		// Mientras el número de empleados no sea valido seguimos pidiendo la cantidad
		// de empleados
		do {
			System.out.print("Introduzca la cantidad de empleados: ");
			amount = sc.nextInt();
			if (amount <= 0)
				System.out.println("Error. La cantidad de empleados debe ser mayor a 0.");
		} while (amount <= 0);

		// Devolvemos la cantidad de empleados
		return amount;
	}

	/**
	 * Método para obtener el salario de un empleado
	 * 
	 * @param sc Scanner para la captura de teclado
	 * @return Double mayor a 0 con el salario anual de un empleado
	 */
	public static double getSalary(Scanner sc, int employee) {
		// Guarda el salario mensual
		double monthly;

		// Mientras el salario no sea valido seguimos pidiendo el salario
		do {
			System.out.printf("Introduzca el salario del empleado %d: ", employee);
			monthly = sc.nextDouble();
			if (monthly <= 0)
				System.out.println("Error. El salario debe ser mayor a 0.");
		} while (monthly <= 0);

		// Se devuelve el calculo de salario mensual multiplicado por mensualidades
		return monthly * PAYMENTS;
	}

	/**
	 * Método para llenar una matriz con salarios
	 * 
	 * @param matrix Matriz a rellenar
	 * @param sc     Scanner para la captura de teclado
	 */
	public static void fillMatrix(double[][] matrix, Scanner sc) {
		// Recorremos la matriz para rellenarla
		for (int year = 0; year < matrix.length; year++) {
			for (int salary = 0; salary < matrix[0].length; salary++) {
				// Si es el primer año se rellena por teclado
				if (year == 0)
					matrix[year][salary] = getSalary(sc, salary + 1);
				// El resto de años se calculan sobre el primero
				else
					matrix[year][salary] = matrix[0][salary] + (INCREASE * year);
			}
		}
	}

	/**
	 * Método para rellenar los salarios
	 * 
	 * @param sc Scanner para la captura de teclado
	 */
	public void fillSalaries(Scanner sc) {
		fillMatrix(salaries, sc);
	}

	/**
	 * Método para mostrar el contenido de una matrix de tipo Double
	 * 
	 * @param matrix
	 */
	public static void showMatrix(double[][] matrix) {
		for (int year = 0; year < matrix.length; year++) {
			for (int salary = 0; salary < matrix[0].length; salary++) {
				System.out.printf("%.2f ", matrix[year][salary]);
			}
			System.out.println();
		}
	}

	/**
	 * Mostrar el salario de un empleado
	 * 
	 * @param employee Empleado del que mostrar la información
	 */
	public void showEmployeeData(int employee) {
		// Guarda el salario
		double sum = 0;

		// Recorremos la información guardada del empleado y la vamos sumando
		for (int year = 0; year < getYearAmount(); year++) {
			System.out.printf("Coste empleado(%d) año %d: %.2f€%n", employee, year + firstYear,
					salaries[year][employee - 1]);
			sum += salaries[year][employee - 1];
		}

		// Mostramos el coste del empleado en los años
		System.out.printf("Coste Total de los %d años para empleado(%d):%.2f€%n", getYearAmount(), employee, sum);
	}

	/**
	 * Mostrar el salario de todos los empleados
	 */
	public void showEmployeeData() {
		System.out.println("__________Costes por trabajador__________");
		// Recorremos los empleados y los mostramos de 1 en 1
		for (int i = 1; i <= getEmployeeAmount(); i++) {
			showEmployeeData(i);
			System.out.println("_________________________________________");
		}
	}

	/**
	 * Mostrar el coste de salarios del año
	 * 
	 * @param year Año a mirar
	 * @return suma del coste por años
	 */
	public double showYearlyData() {
		// Guarda la suma
		double sum = 0;

		System.out.println("______________Costes por Año_____________");
		// Recorremos los años
		for (int year = 0; year < getYearAmount(); year++) {
			// Guarda la suma por año y se reinicia
			double yearSum = 0;
			// Recorremos los empleados y añadimos a la suma de este año
			for (int salary = 0; salary < getEmployeeAmount(); salary++) {
				yearSum += salaries[year][salary];
			}
			// Añadimos a la suma total la suma de este año y mostramos la información del
			// año
			System.out.printf("Coste Total año (%d): %.2f€%n", year + firstYear, yearSum);
			sum += yearSum;
		}
		System.out.println("_________________________________________");
		// Devolvemos la suma de todos los años
		return sum;
	}

	/**
	 * Mostrar y calcular el coste de salarios total
	 */
	public void showTotalCost() {
		// Guarda la suma
		double sum = 0;
		// Recorremos toda la matriz y sumamos toda la información
		for (int year = 0; year < getYearAmount(); year++) {
			for (int salary = 0; salary < getEmployeeAmount(); salary++) {
				sum += salaries[year][salary];
			}
		}
		// Mostramos el resultado por pantalla
		System.out.printf("Coste Total de los %d años para Empresa: %.2f€%n", getYearAmount(), sum);
	}

	/**
	 * Mostrar toda la información
	 */
	public void showAllData() {
		// Mostrar información de los empleados
		showEmployeeData();
		// Mostramos la información anual y guardamos el resultado
		double sum = showYearlyData();
		// Mostramos el calculo de gasto total
		System.out.println("______________Costes Empresa_____________");
		System.out.printf("Coste Total de los %d años para Empresa: %.2f€%n", getYearAmount(), sum);
	}

	/**
	 * Devolver la cantidad de empleados
	 * 
	 * @return Entero con la cantidad de empleados guardados
	 */
	public int getEmployeeAmount() {
		return salaries[0].length;
	}

	/**
	 * Devolver cantidad de años guardados
	 * 
	 * @return Entero con la cantidad de años guardados
	 */
	public int getYearAmount() {
		return salaries.length;
	}

	/**
	 * Método de ejecución
	 * 
	 * @param args Argumentos de ejecución (No usado)
	 */
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		var salarios = new ActividadEvaluable2();
		salarios.fillSalaries(sc);
		salarios.showAllData();
	}
}
