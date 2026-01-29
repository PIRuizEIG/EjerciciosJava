package archivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * <h1>Salario empleados</h1>
 * <p>
 * Desarrolla un programa en Java que lea datos de empleados desde CSV y genere
 * un informe de nóminas.
 * <p>
 * Lee "empleados.csv" con formato: id,nombre,sueldoBase,horasExtra (ej:
 * "001,Juan Pérez,2000,15"). Calcula:
 * <ol>
 * <li>Sueldo total = sueldoBase + (horasExtra × 25€)</li>
 * <li>Categoría: A (>3000€), B (2000-3000€), C (<2000€)</li>
 * <li>Empleado mejor pagado por categoría</li>
 * <li>Total nómina por categoría</li>
 * <li>En el fichero de entrada los trabajadores no tienen por qué venir
 * ordenados por id, pero a la hora de mostrarlo sí se ha de mostrar ordenado
 * por id.</li>
 * <li>Si alguna línea tiene más o menos campos de los solicitados obviar esa
 * línea y mostrar al final que esa línea se descarta por ese motivo.</li>
 * <li>Si hay algún trabajador repetido, sólo se considera la primera aparición
 * y se descartan las siguientes. Se muestra el mensaje de línea descartada.
 * </li>
 * <li>Si se alcanza el máximo número de trabajadores se debe parar de leer el
 * fichero y mostrar la info con lo leído hasta ese momento.</li>
 * <li>Si se lee algún campo numérico y se detecta que no es numérico se
 * descarta la línea y se muestra mensaje.</li>
 * </ol>
 * <p>
 * Escribe en "nominas.txt":
 * <p>
 * INFORME DE NÓMINAS <br>
 * ================== <br>
 * CATEGORÍA A (>3000€): Total XXXX€ - Mejor: [nombre] <br>
 * CATEGORÍA B (2000-3000€): Total XXXX€ - Mejor: [nombre] <br>
 * CATEGORÍA C (<2000€): Total XXXX€ - Mejor: [nombre] <br>
 * DETALLE EMPLEADOS: <br>
 * ID | Nombre | Sueldo Base | Horas Extra | Sueldo Total | Categoría <br>
 * 001 | Juan Pérez | 2000 | 15 | 2375 | B <br>
 * ... <br>
 * GRAN TOTAL NÓMINAS: XXXXX€
 * <p>
 * Límite: 150 empleados.
 * <h2>Requisitos Técnicos</h2>
 * <ul>
 * <li>Arrays fijos: String[] nombres, double[] sueldosTotales, char[]
 * categorias, int[] contadoresCategoria[3]</li>
 * <li>Búsqueda manual del mejor pagado por categoría</li>
 * <li>Formato tabla con String.format("| %-3s | %-12s | ..., datos)`</li>
 * <li>Validación: sueldoBase > 0, horasExtra ≥ 0</li>
 * </ul>
 * <h2>Ejemplo empleados.csv</h2>
 * <p>
 * 001,Juan Pérez,2000,15 <br>
 * 002,María García,2500,8 <br>
 * 003,Pedro López,1800,25 <br>
 * 004,Ana Martín,3200,0 <br>
 * 005,Luis Rodríguez,2200,12
 * <h2>Salida esperada nominás.txt</h2>
 * <p>
 * INFORME DE NÓMINAS <br>
 * ================== <br>
 * CATEGORÍA A (>3000€): Total 3200,00€ - Mejor: Ana Martín <br>
 * CATEGORÍA B (2000-3000€): Total 10000,00€ - Mejor: María García <br>
 * DETALLE EMPLEADOS: <br>
 * ID | Nombre | Sueldo Base | Horas Extra | Sueldo Total | Categoría <br>
 * ---+-------------+-------------+-------------+--------------+---------- <br>
 * 001 | Juan Pérez | 2000,00 | 15 | 2375,00 | B <br>
 * 002 | María García | 2500,00 | 8 | 2700,00 | B <br>
 * 003 | Pedro López | 1800,00 | 25 | 2425,00 | B <br>
 * 004 | Ana Martín | 3200,00 | 0 | 3200,00 | A <br>
 * 005 | Luis Rodríguez | 2200,00 | 12 | 2500,00 | B <br>
 * GRAN TOTAL NÓMINAS: 13200,00€
 * <h2>Autor: Pablo Illescas</h2>
 */

public class EjercicioFichero04 {

	/**
	 * Nombre del archivo CSV
	 */
	public static final String CSV_NAME = "empleados.csv";
	
	/**
	 * Nombre del archivo CSV malo
	 */
	public static final String BAD_CSV = "empleadosMal.csv";

	/**
	 * Nombre del archivo de salida
	 */
	public static final String OUTPUT_NAME = "nominas.txt";

	/**
	 * Número máximo de empleados
	 */
	public static final int MAX_EMPLOYEES = 150;

	/**
	 * Sueldo limite categoria B
	 */
	public static final double CAT_B = 2000;

	/**
	 * Sueldo limite categoria A
	 */
	public static final double CAT_A = 3000;

	/**
	 * Cantidad de empleados
	 */
	private int employeeAmount = 0;

	/**
	 * Array de empleados
	 */
	private Employee[] employees = new Employee[MAX_EMPLOYEES];

	/**
	 * Escribe la cadena text en el archivo filename
	 * 
	 * @param filename Nombre del archivo destino
	 * @param text     Texto a escribir
	 */
	public void writeToFile(String filename, String text) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
			bw.write(text);
			bw.close();
		} catch (IOException ioe) {
			System.out.println("No se ha podido escribir");
		}
	}

	/**
	 * Lee el archivo pasado como parametro
	 * 
	 * @param filename Nombre del archivo
	 */
	public static void readFile(String filename) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String linea = br.readLine();
			while (linea != null) {
				System.out.println(linea);
				linea = br.readLine();
			}
			br.close(); // ¡IMPORTANTE CERRAR EL FICHERO!
		} catch (IOException ioe) {
			System.out.println("Error al leer");
		}
	}

	/**
	 * Lee un archivo CSV y guarda el contenido en los array del objeto
	 * 
	 * @param filename Nombre del fichero a leer
	 */
	public void readCsv(String filename) {
		// Capturar errores de lectura de fichero
		try {
			// Abrir buffer de lectura
			BufferedReader br = new BufferedReader(new FileReader(filename));

			// Leemos la primera línea y preparamos el array de cadenas
			String line = br.readLine();
			String[] newLine;
			int lines = 0;

			// Mientras queden líneas en el csv y no llegemos al máximo de lecturas
			while (line != null) {
				// Separamos la línea en un array de cadenas
				newLine = line.trim().split(",");
				// Si la línea no tiene el número de elementos correctos la saltamos
				if (newLine.length != 4) {
					System.out.printf("Error de formato CSV en la línea %d%n", lines);
					// Leemos la siguiente línea
					line = br.readLine();
					// Aumentamos las líneas leídas
					lines++;
					continue;
				}
				// Capturar error de conversión de números
				try {
					// Si no nos hemos pasado al añadir empleados
					if (employeeAmount < MAX_EMPLOYEES) {
						var id = Integer.parseInt(newLine[0].trim());
						var repeated = false;
						for (int i = 0; i < employeeAmount; i++) {
							if (id == employees[i].getId()) {
								System.out.printf("Empleado %d repetido en linea %d%n", id, lines);
								repeated = true;
								break;
							}
						}
						// Guardamos los datos de la línea en un empleado nuevo
						var temp = new Employee(id, newLine[1].trim(), Double.parseDouble(newLine[2].trim()),
								Integer.parseInt(newLine[3].trim()));
						// Si el sueldo o horas extras no tienen sentido o si el empleado está repetido
						// damos error
						if (temp.getSalary() <= 0 || temp.getOvertime() < 0 || repeated) {
							System.out.printf("Error en linea %d: %s%n", lines, line);
						} else {
							// Lo guardamos en el array
							employees[employeeAmount] = temp;
							// Aumentamos el contador de empleados
							employeeAmount++;
						}
					} else {
						break;
					}
				} catch (NumberFormatException e) {
					// Si no es la primera línea (Cabecera)
					if (lines > 0)
						// Si la línea no contiene números no se hace nada y avisamos de error
						System.out.printf("Error de formato CSV en la línea %d%n", lines);
				}
				// Leemos la siguiente línea
				line = br.readLine();
				// Aumentamos las líneas leídas
				lines++;
			}
			// Cerrar el archivo
			br.close();
		} catch (FileNotFoundException fnf) {
			System.out.println("Error, archivo no encontrado");
		} catch (IOException ioe) {
			System.out.println("Error al leer");
		}
		sortEmployeesById();
	}

	/**
	 * Obtener informe de los empleados
	 */
	public String getEmployeeReport() {
		var returnString = String.format(
				"DETALLE EMPLEADOS:\n" + " %-2s| %-14s| %-12s| %-12s| %-13s| %-9s\n"
						+ "---+---------------+-------------+-------------+--------------+----------\n",
				"ID", "Nombre", "Sueldo Base", "Horas Extra", "Sueldo Total", "Categoría");
		for (int i = 0; i < employeeAmount; i++) {
			returnString = returnString.concat(employees[i].toString() + "\n");
		}
		return returnString;
	}

	/**
	 * Obtener el empleado mejor pagado
	 */
	public Employee getHighestPaid(char category) {
		// Si no tenemos empleados devolver null
		if (employeeAmount <= 0)
			return null;
		// Inicializar valores
		Employee returnValue = null;
		double highestPay = 0;
		// Recorrer la lista de empleados hasta encontrar el mejor pagado
		for (int i = 0; i < employeeAmount; i++) {
			// Si no es de nuestra categoria lo saltamos
			if (employees[i].getCategory() != category)
				continue;
			// Comparamos la paga, si es la mayor lo guardamos
			var salary = employees[i].getTotalSalary();
			if (salary > highestPay) {
				highestPay = salary;
				returnValue = employees[i];
			}
		}
		return returnValue;
	}

	/**
	 * Obtener la suma del salario de la categoría
	 * 
	 * @param category
	 */
	public double getCategoryTotalSalary(char category) {
		// Si no tenemos empleados devolver null
		if (employeeAmount <= 0)
			return 0;
		// Inicializar valor
		double pay = 0;
		// Recorrer la lista de empleados y sumar pagas
		for (int i = 0; i < employeeAmount; i++) {
			// Si no es de nuestra categoria lo saltamos
			if (employees[i].getCategory() != category)
				continue;
			pay += employees[i].getTotalSalary();
		}
		return pay;
	}

	/**
	 * Obtener la suma de salarios
	 */
	public double getTotalSalary() {
		// Si no tenemos empleados devolver null
		if (employeeAmount <= 0)
			return 0;
		// Inicializar valor
		double pay = 0;
		// Recorrer la lista de empleados y sumar pagas
		for (int i = 0; i < employeeAmount; i++) {
			pay += employees[i].getTotalSalary();
		}
		return pay;
	}

	/**
	 * Obtener reporte del salario total
	 */
	public String getPayTotal() {
		return String.format("GRAN TOTAL NOMINAS: %.2f €", getTotalSalary());
	}

	/**
	 * Obtener reporte de los empleados mejor pagados por categoría
	 */
	public String getPayrollReport() {
		String returnString = "INFORME DE NOMINAS\n" + "==================\n";
		var highest = getHighestPaid('A');
		String name;
		if (highest == null)
			name = "Ninguno";
		else
			name = highest.getName();
		var pay = getCategoryTotalSalary('A');
		returnString = returnString
				.concat(String.format("CATEGORIA A (>%.0f€): Total %.2f € - Mejor: %s\n", CAT_A, pay, name));
		highest = getHighestPaid('B');
		if (highest == null)
			name = "Ninguno";
		else
			name = highest.getName();
		pay = getCategoryTotalSalary('B');
		returnString = returnString
				.concat(String.format("CATEGORIA B (%.0f-%.0f€): Total %.2f € - Mejor: %s\n", CAT_B, CAT_A, pay, name));
		highest = getHighestPaid('C');
		if (highest == null)
			name = "Ninguno";
		else
			name = highest.getName();
		pay = getCategoryTotalSalary('C');
		returnString = returnString
				.concat(String.format("CATEGORIA C (<%.0f€): Total %.2f € - Mejor: %s\n", CAT_B, pay, name));
		return returnString;
	}
	
	public String getFullReport() {
		String returnValue = getPayrollReport();
		returnValue = returnValue.concat("\n" + getEmployeeReport());
		returnValue = returnValue.concat("\n" + getPayTotal());
		return returnValue;
	}
	
	/**
	 * Ordenar empleados por ID
	 */
	public void sortEmployeesById() {
	    for (int i = 0; i < employeeAmount - 1; i++) {
	        for (int j = 0; j < employeeAmount - i - 1; j++) {
	            if (employees[j].getId() > employees[j + 1].getId()) {
	                Employee temp = employees[j];
	                employees[j] = employees[j + 1];
	                employees[j + 1] = temp;
	            }
	        }
	    }
	}

	public static void main(String[] args) {
		
		var obj = new EjercicioFichero04();
		obj.readCsv(CSV_NAME);
		obj.writeToFile(OUTPUT_NAME, obj.getFullReport());
		EjercicioFichero04.readFile(OUTPUT_NAME);
		
		var obj2 = new EjercicioFichero04();
		obj2.readCsv(BAD_CSV);
		System.out.println(obj2.getFullReport());
	}

}