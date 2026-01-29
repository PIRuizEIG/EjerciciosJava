package archivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * <h1>Ejercicio 3 : CSV Ventas</h1>
 * <p>
 * Desarrolla un programa en Java que lea ventas de productos desde un fichero
 * CSV y genere un informe de ventas.<br>
 * Practica lectura de ficheros, parseo CSV y escritura de informes con manejo
 * de excepciones. <br>
 * Lee el fichero "ventas.csv" con formato: producto,cantidad,precio (ej:
 * "Laptop,2,1200.50"). Calcula:
 * <ol>
 * <li>Total ventas por producto (cantidad × precio)1.</li>
 * <li>Producto más vendido (mayor cantidad total)2.</li>
 * <li>Ticket medio (total ventas / total productos vendidos)3.</li>
 * </ol>
 * <p>
 * Escribe informe en "informe_ventas.txt":
 * <p>
 * INFORME DE VENTAS ================= <br>
 * Producto más vendido: [nombre] (cantidad: X) <br>
 * Total ventas: XXXXX.XX € <br>
 * Precio medio: XXXX.XX € <br>
 * Detalle: <br>
 * - Laptop: XXXX.XX € <br>
 * - Raton: XXXX.XX € ... <br>
 * <p>
 * Límite: Hasta 200 líneas de ventas.
 * <h2>Requisitos Técnicos</h2>
 * <ul>
 * <li>BufferedReader + split(",") para leer CSV</li>
 * <li>Arrays fijos: String[] productos, double[] totalesVentas</li>
 * <li>Contador manual para productos únicos (máx 50)</li>
 * <li>Comparación manual para encontrar máximo</li>
 * <li>BufferedWriter para informe formateado</li>
 * <li>Manejo IOException, NumberFormatException</li>
 * <li>String.format("%.2f", valor) para decimales</li>
 * </ul>
 * <h2>Autor: Pablo Illescas</h2>
 */
public class EjercicioFichero03 {

	/**
	 * Límite de productos
	 */
	public static final int MAX_PRODUCTS = 50;
	
	
	/**
	 * Límite de líneas a leer
	 */
	public static final int MAX_READINGS = 200;

	/**
	 * Nombre del archivo CSV
	 */
	public static final String CSV_NAME = "ventas.csv";
	
	/**
	 * Nombre del archivo de salida
	 */
	public static final String OUTPUT_NAME = "informe_ventas.txt";

	/**
	 * Nombre de los productos
	 */
	private String[] productos = new String[MAX_PRODUCTS];

	/**
	 * Ventas del producto
	 */
	private int[] ventas = new int[MAX_PRODUCTS];

	/**
	 * Precios del producto
	 */
	private double[] precios = new double[MAX_PRODUCTS];

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
			String linea = br.readLine();
			String[] newLine;
			
			int amount = 0;
			int lines = 0;

			// Mientras queden líneas en el csv y no llegemos al máximo de lecturas
			while (linea != null && lines < MAX_READINGS) {
				// Separamos la línea en un array de cadenas
				newLine = linea.trim().split(",");
				// Capturar error de conversión de números
				try {
					// Guardamos los valores de la línea en el formato correcto
					var name = newLine[0].trim();
					var sales = Integer.parseInt(newLine[1].trim());
					var price = Double.parseDouble(newLine[2].trim());

					// Recorremos los array del objeto
					for (int i = 0; i < amount + 1; i++) {
						// Si llegamos a un elemento vacío del array guardamos los valores y salimos del
						// bucle
						if (productos[i] == null) {
							// Controlamos el máximo de productos
							if (amount >= MAX_PRODUCTS) {
								System.out.println("Límite de productos alcanzado");
								continue;
							}
							productos[i] = name;
							ventas[i] = sales;
							precios[i] = price;
							amount++;
							break;
						}
						// Si encontramos un producto ya guardado aumentamos las ventas y salimos del
						// bucle
						if (productos[i].compareToIgnoreCase(name) == 0) {
							ventas[i] += sales;
							break;
						}
					}
				} catch (NumberFormatException e) {
					// Si no es la primera línea (Cabecera)
					if (lines > 0)
						// Si la línea no contiene números no se hace nada y avisamos de error
						System.out.printf("Error de formato CSV en la línea %d%n", lines);
				}
				// Leemos la siguiente línea
				linea = br.readLine();
				// Aumentamos las líneas leídas
				lines++;
			}
			// Cerrar el archivo
			br.close();
		} catch (IOException ioe) {
			System.out.println("Error al leer");
		}
	}

	/**
	 * Muestra el contenido de los arrays por pantalla
	 */
	public void showSales() {
		for (int i = 0; i < productos.length; i++) {
			if (productos[i] == null)
				break;
			var s = String.format("Producto: %s Ventas: %d Precio: %.2f € Total:  %.2f €", productos[i], ventas[i],
					precios[i], ventas[i] * precios[i]);
			System.out.println(s);
		}
	}
	
	/**
	 * Obtener listado de ventas
	 * 
	 * @return Cadena con las ventas de productos
	 */
	public String getSales() {
		String s = "";
		for (int i = 0; i < productos.length; i++) {
			if (productos[i] == null)
				break;
			var newS = String.format("- %s: %.2f €%n", productos[i], ventas[i] * precios[i]);
			s = s.concat(newS);
		}
		return s;
	}

	/**
	 * Obtener el producto con el índice indicado
	 * 
	 * @param index Índice a mirar
	 * @return Cadena con los valores del producto
	 */
	public String getProduct(int index) {
		if (productos[index] == null)
			return null;
		return String.format("%s: (Ventas:%d)", productos[index], ventas[index]);
	}

	/**
	 * Obtener el total de ventas
	 * 
	 * @return Total facturado
	 */
	public double getTotalSales() {
		double sum = 0;
		for (int i = 0; i < productos.length; i++) {
			if (productos[i] == null)
				break;
			sum += ventas[i] * precios[i];
		}
		return sum;
	}
	
	/**
	 * Obtener el total de productos
	 * 
	 * @return Número de productos
	 */
	public int getTotalProducts() {
		int sum = 0;
		for (int i = 0; i < productos.length; i++) {
			if (productos[i] == null)
				break;
			sum += ventas[i];
		}
		return sum;
	}

	/**
	 * Obtener el precio medio por producto
	 * 
	 * @return Venta media
	 */
	public double getAverage() {
		var products = getTotalProducts();
		if (products <= 0)
			return 0;
		else
			return getTotalSales() / products;
	}

	/**
	 * Obtener el precio medio por producto
	 * 
	 * @param total Total facturado
	 * @return Venta media
	 */
	public double getAverage(double total) {
		var products = getTotalProducts();
		if (products <= 0)
			return 0;
		else
			return total / products;
	}

	/**
	 * Encontrar el índice del producto mejor vendido
	 * 
	 * @return Índice del producto mejor vendido
	 */
	public int findBestSelling() {
		var index = 0;

		// Recorremos los array
		for (int i = 1; i < ventas.length; i++) {
			// Si no hay objetos en este índice cerramos el bucle
			if (productos[i] == null)
				break;
			// Si las ventas del producto actual es mayor al guardado cambiamos el índice
			if (ventas[i] > ventas[index])
				index = i;
		}

		// Devolvemos el índice del producto con más ventas
		return index;
	}
	
	/**
	 * Obtener informe de ventas
	 * 
	 * @return Cadena con el informe de ventas
	 */
	public String getReport() {
		var total = getTotalSales();
		return String.format("INFORME DE VENTAS ================= \r\n"
				+ "Producto más vendido: %s \r\n"
				+ "Total ventas: %.2f € \r\n"
				+ "Precio medio: %.2f € \r\n"
				+ "Detalle: \r\n"
				+ "%s", getProduct(findBestSelling()), total, getAverage(total), getSales());
	}
	
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

	public static void main(String[] args) {
		var obj = new EjercicioFichero03();
		obj.readCsv(CSV_NAME);
		obj.writeToFile(OUTPUT_NAME, obj.getReport());
		EjercicioFichero03.readFile(OUTPUT_NAME);
	}

}
