package archivos;

/**
 * Clase de apoyo para EjercicioFichero04, contiene ID, nombre, Sueldo base y
 * Horas extras
 */
public class Employee {

	/**
	 * Sueldo limite categoria B
	 */
	public static final double CAT_B = 2000;

	/**
	 * Sueldo limite categoria A
	 */
	public static final double CAT_A = 3000;

	/**
	 * Valor de las horas extra
	 */
	public static final double OVERTIME_VALUE = 25;

	/**
	 * ID del empleado
	 */
	private int id;

	/**
	 * Nombre del empleado
	 */
	private String name;

	/**
	 * Salario del empleado
	 */
	private double salary;

	/**
	 * Horas extras
	 */
	private int overtime;

	/**
	 * Salario total
	 */
	private double totalSalary;

	/**
	 * Categoría
	 */
	private char category;

	/**
	 * Crear estructura de empleado
	 * 
	 * @param id       ID
	 * @param name     Nombre
	 * @param salary   Sueldo base
	 * @param overtime Horas extra
	 */
	public Employee(int id, String name, double salary, int overtime) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.overtime = overtime;
		this.totalSalary = calculateSalary();
		this.category = calculateCategory();
	}

	/**
	 * Obtener Categoria del empleado
	 * 
	 * @return Caracter con la categoria
	 */
	private char calculateCategory() {
		if (totalSalary < CAT_B)
			return 'C';
		else if (totalSalary <= CAT_A)
			return 'B';
		else
			return 'A';
	}

	/**
	 * Obtener el sueldo total
	 * 
	 * @return Sueldo
	 */
	private double calculateSalary() {
		return salary + (OVERTIME_VALUE * overtime);
	}

	/**
	 * Obtener ID del trabajador
	 */
	public int getId() {
		return id;
	}

	/**
	 * Obtener Nombre del trabajador
	 */
	public String getName() {
		return name;
	}

	/**
	 * Obtener Salario base del trabajador
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * Obtener horas extras del trabajador
	 */
	public int getOvertime() {
		return overtime;
	}

	/**
	 * Obtener salario base del trabajador
	 */
	public double getTotalSalary() {
		return totalSalary;
	}

	/**
	 * Obtener categoría del trabajador
	 */
	public char getCategory() {
		return category;
	}

	/**
	 * Obtener la información del empleado
	 */
	public String toString() {
		return String.format("%03d|%14s |%10.2f € |%12d |%11.2f € |%9c ", id, name, salary, overtime, totalSalary,
				category);
	}
}
